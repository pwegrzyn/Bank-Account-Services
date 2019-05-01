package service;

import com.zeroc.Ice.*;
import bank.*;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class SystemImpl implements bank.System {

    private final Map<String, AccountEntity> userEntities;
    private final ObjectAdapter adapter;
    private final Communicator communicator;
    private final String bankServerAddress;
    private final String bankServerPort;
    private final ExchangeRateRequest supportedCurrencies;
    private final ConcurrentMap<Currency, CurrencyEntity> exchangeRates;

    public SystemImpl(Map<String, AccountEntity> userEntities, ObjectAdapter adapter, Communicator communicator,
                      ExchangeRateRequest supportedCurrencies, ConcurrentMap<Currency, CurrencyEntity> exchangeRates) {
        this.userEntities = userEntities;
        this.adapter = adapter;
        this.communicator = communicator;
        IPEndpointInfo endpointInfo = (IPEndpointInfo) adapter.getEndpoints()[0].getInfo();
        this.bankServerAddress = endpointInfo.host;
        this.bankServerPort = (new Integer(endpointInfo.port)).toString();
        this.supportedCurrencies = supportedCurrencies;
        this.exchangeRates = exchangeRates;
    }

    @Override
    public AccountCreationResult createAccount(UserData userData, Current current) throws PESELAlreadyInUse {
        checkIfPESELisUnique(userData);
        AccountEntity entity = new AccountEntity(userData.name, userData.surname, userData.pesel, userData.monthlyIncome);
        this.userEntities.put(entity.getPesel(), entity);
        switch (entity.getType()) {
            case STANDARD:
                this.adapter.add(new AccountImpl(entity), new Identity(entity.getPesel(), entity.getType().toString()));
                break;
            case PREMIUM:
                this.adapter.add(new PremiumAccountImpl(entity, this.supportedCurrencies, this.exchangeRates),
                        new Identity(entity.getPesel(), entity.getType().toString()));
                break;
        }
        java.lang.System.out.println("New account has been created: ");
        java.lang.System.out.println("Type: " + entity.getType().toString());
        java.lang.System.out.println("PESEL: " + entity.getPesel());
        AccountCreationResult result = new AccountCreationResult();
        result.accountType = entity.getType();
        result.password = entity.getPassword();
        return result;
    }

    @Override
    public AccountPrx logInToAccount(String pesel, Current current) throws InvalidCredentials {
        if(this.userEntities.get(pesel) == null) {
            java.lang.System.out.println("Unsuccessful login attempt detected!");
            throw new InvalidCredentials();
        }
        String passwordAttempt = current.ctx.get("passwordAttempt");
        AccountEntity account = this.userEntities.get(pesel);
        if(!account.getPassword().equals(passwordAttempt)) {
            java.lang.System.out.println("Unsuccessful login attempt detected!");
            throw new InvalidCredentials();
        }
        String proxyString = account.getType().toString() + "/" + account.getPesel() + ":" + "tcp -h " +
                this.bankServerAddress + " -p " + this.bankServerPort + ":udp -h " + this.bankServerAddress +
                " -p " + this.bankServerPort;
        java.lang.System.out.println("A user has logged in: ");
        java.lang.System.out.println("PESEL: " + account.getPesel());
        return AccountPrx.uncheckedCast(communicator.stringToProxy(proxyString));
    }

    private void checkIfPESELisUnique(UserData userData) throws PESELAlreadyInUse {
        for(Map.Entry<String, AccountEntity> acc : this.userEntities.entrySet()) {
            if(acc.getKey().equals(userData.pesel)) {
                throw new PESELAlreadyInUse();
            }
        }
    }

}
