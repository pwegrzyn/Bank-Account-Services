package service;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ExchangeRateMarket {

    private ConcurrentMap<Currency, CurrencyEntity> exchangeRates;
    private static final long fluctuationsTime = 5000;
    private final double EPS = 0.00000001;

    public ExchangeRateMarket() {
        this.exchangeRates = new ConcurrentHashMap<>();
        this.exchangeRates.put(Currency.USD, new CurrencyEntity("USD",  3.8291));
        this.exchangeRates.put(Currency.EUR, new CurrencyEntity("EUR",  4.2911));
        this.exchangeRates.put(Currency.JPY, new CurrencyEntity("JPY",  3.4367));
        this.exchangeRates.put(Currency.CHF, new CurrencyEntity("CHF",  3.7607));
        this.exchangeRates.put(Currency.CNY, new CurrencyEntity("CNY",  0.5684));
        new Timer(true).scheduleAtFixedRate(new TimerTask() {

            private static final double minFluctuation = 0.01;
            private static final double maxFluctuation = 0.2;
            private Random random = new Random();

            @Override
            public void run() {
                fluctuateRates(ExchangeRateMarket.this.exchangeRates);
            }

            private void fluctuateRates(ConcurrentMap<Currency, CurrencyEntity> rates) {
                for (Map.Entry<Currency, CurrencyEntity> entry : rates.entrySet()) {
                    if(this.random.nextBoolean()) {
                        double newValue;
                        if(this.random.nextBoolean()) {
                            newValue = entry.getValue().getRate() + getRandomPositiveFluctuation();
                        } else {
                            newValue = entry.getValue().getRate() - getRandomPositiveFluctuation();
                        }
                        entry.getValue().setRate(newValue > 0 ? newValue : 0);
                    }
                }
            }

            private double getRandomPositiveFluctuation() {
                return minFluctuation + (maxFluctuation - minFluctuation) * this.random.nextDouble();
            }

        }, 5000, fluctuationsTime);
    }

    public synchronized List<CurrencyEntity> getAllRates(ExchangeRateRequest request) {
        return this.exchangeRates
                .values()
                .stream()
                .filter(c -> request.getCurrencyTypeList().contains(c.getType()))
                .collect(Collectors.toList());
    }

    public synchronized Tuple2<List<CurrencyEntity>, List<CurrencyEntity>> getChangedRates(ExchangeRateRequest request, List<CurrencyEntity> oldState) {
        List<CurrencyEntity> currencies = this.exchangeRates.values().stream()
                .filter(c -> request.getCurrencyTypeList().contains(c.getType())).collect(Collectors.toList());
        List<CurrencyEntity> stateCopy = new LinkedList<>();
        for (CurrencyEntity entity : currencies) {
            stateCopy.add(new CurrencyEntity(entity.getCode(), entity.getRate()));
        }
        if(oldState == null) {
            return Tuple.of(stateCopy, currencies);
        }
        List<CurrencyEntity> result = new LinkedList<>();
        for (CurrencyEntity freshCurrency : currencies) {
            for (CurrencyEntity oldCurrency : oldState) {
                if(freshCurrency.getCode().equals(oldCurrency.getCode())) {
                    if(Math.abs(freshCurrency.getRate() - oldCurrency.getRate()) > EPS) {
                        result.add(freshCurrency);
                    }
                }
            }
        }
        return Tuple.of(stateCopy, result);
    }

}
