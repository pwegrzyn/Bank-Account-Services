package code;

import com.zeroc.Ice.*;
import generated.service.Currency;
import generated.service.ExchangeRateRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {

    private final String currencyServiceAddress;
    private final int currencyServicePort;
    private final String[] currenciesAsString;
    private ExchangeRateRequest exchangeRateRequest;
    private Map<String, AccountEntity> accountEntities;
    private ConcurrentMap<String, CurrencyEntity> currencyEntities;
    private final String adapterId;

    public Bank(String adapterId, String currencyServiceAddress, int currencyServicePort, String[] currencies) {
        this.currencyServiceAddress = currencyServiceAddress;
        this.currencyServicePort = currencyServicePort;
        this.currenciesAsString = currencies;
        this.accountEntities = new HashMap<>();
        this.currencyEntities = new ConcurrentHashMap<>();
        this.adapterId = adapterId;
        assignCurrenciesForRequests();
    }

    public void start() {
        initCurrencyServiceLink();
        startListeningForClients();
    }

    private void initCurrencyServiceLink() {

    }

    private void startListeningForClients() {
        Communicator communicator = Util.initialize();
        communicator.getProperties().load("./config.server");
        ObjectAdapter adapter = communicator.createObjectAdapter("BankAdapter" + this.adapterId);
        IPEndpointInfo endpointInfo = (IPEndpointInfo) adapter.getEndpoints()[0].getInfo();
        String hostName = endpointInfo.host;
        int port = endpointInfo.port;
        SystemImpl system = new SystemImpl(this.accountEntities, this.currencyEntities, adapter, communicator);
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
                case "CNH":
                    exchangeRateBuilder.addCurrencyType(Currency.CNH);
                    break;
                default: break;
            }
        }
        this.exchangeRateRequest = exchangeRateBuilder.build();
    }

}
