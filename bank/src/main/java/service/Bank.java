package service;

import com.zeroc.Ice.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class Bank {

    private final String currencyServiceAddress;
    private final int currencyServicePort;
    private final String[] currenciesAsString;
    private ExchangeRateRequest exchangeRateRequest;
    private Map<String, AccountEntity> accountEntities;
    private ConcurrentMap<Currency, CurrencyEntity> currencyEntities;
    private final String adapterId;
    private ManagedChannel managedChannel;

    Bank(String adapterId, String currencyServiceAddress, int currencyServicePort, String[] currencies) {
        this.currencyServiceAddress = currencyServiceAddress;
        this.currencyServicePort = currencyServicePort;
        this.currenciesAsString = currencies;
        this.accountEntities = new HashMap<>();
        this.currencyEntities = new ConcurrentHashMap<>();
        this.adapterId = adapterId;
        assignCurrenciesForRequests();
    }

    void start() {
        getInitialExchangeRates();
        initCurrencyServiceUpdateStream();
        startListeningForClients();
    }

    private void getInitialExchangeRates() {
        System.out.println("Fetching all necessary initial exchange rates from the server.");
        this.managedChannel = ManagedChannelBuilder.forAddress(this.currencyServiceAddress, this.currencyServicePort)
                .usePlaintext()
                .build();
        ExchangeRateServiceGrpc.ExchangeRateServiceBlockingStub blockingStub = ExchangeRateServiceGrpc
                .newBlockingStub(managedChannel);
        ExchangeRateSequence sequence;
        try {
            sequence = blockingStub.getInitialExchangeRates(this.exchangeRateRequest);
        } catch (StatusRuntimeException e) {
            System.out.println("An error occurred while fetching the initial exchange rates from the currency service!");
            System.out.println(e.getStatus());
            return;
        }
        List<ExchangeRateInfo> allRates = sequence.getExchangeRateInfoList();
        for (ExchangeRateInfo info : allRates) {
            this.currencyEntities.put(info.getCurrency(), new CurrencyEntity(info.getCurrency(), info.getRate()));
        }
    }

    private void initCurrencyServiceUpdateStream() {
        new Thread(() -> {
            System.out.println("Subscribing to the currency service for exchange rate updates.");
            ExchangeRateServiceGrpc.ExchangeRateServiceBlockingStub blockingStub = ExchangeRateServiceGrpc
                    .newBlockingStub(managedChannel);
            Iterator<ExchangeRateSequence> sequenceIterator;
            try {
                sequenceIterator = blockingStub.getExchangeRateStream(this.exchangeRateRequest);
            } catch (StatusRuntimeException e) {
                System.out.println("An error occurred while fetching updated exchange rates from the currency service!");
                System.out.println(e.getStatus());
                return;
            }
            while (sequenceIterator.hasNext()) {
                ExchangeRateSequence sequence = sequenceIterator.next();
                System.out.println("Received a new bundle of exchange rate updates. Currencies which have changed: ");
                List<ExchangeRateInfo> updatedRates = sequence.getExchangeRateInfoList();
                for (ExchangeRateInfo info : updatedRates) {
                    System.out.println(" - " + info.getCurrency().toString());
                    System.out.println("   " + info.getRate());
                    this.currencyEntities.put(info.getCurrency(), new CurrencyEntity(info.getCurrency(), info.getRate()));
                }
            }
        }).start();
    }

    private void startListeningForClients() {
        Communicator communicator = Util.initialize();
        communicator.getProperties().load("./config.server");
        ObjectAdapter adapter = communicator.createObjectAdapter("BankAdapter" + this.adapterId);
        SystemImpl system = new SystemImpl(this.accountEntities, adapter, communicator, this.exchangeRateRequest,
                this.currencyEntities);
        System.out.println("Listening for clients...");
        adapter.add(system, new Identity("system", "factory"));
        adapter.activate();
        communicator.waitForShutdown();
    }

    private void assignCurrenciesForRequests() {
        ExchangeRateRequest.Builder exchangeRateBuilder = ExchangeRateRequest.newBuilder();
        exchangeRateBuilder.setBaseCurrency(Currency.PLN);
        for (String currency : this.currenciesAsString) {
            switch(currency) {
                case "EUR":
                    exchangeRateBuilder.addCurrencyType(Currency.EUR);
                    break;
                case "USD":
                    exchangeRateBuilder.addCurrencyType(Currency.USD);
                    break;
                case "JPY":
                    exchangeRateBuilder.addCurrencyType(Currency.JPY);
                    break;
                case "CHF":
                    exchangeRateBuilder.addCurrencyType(Currency.CHF);
                    break;
                case "CNY":
                    exchangeRateBuilder.addCurrencyType(Currency.CNY);
                    break;
                default: break;
            }
        }
        this.exchangeRateRequest = exchangeRateBuilder.build();
    }

}
