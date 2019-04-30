package code;

import com.zeroc.Ice.*;
import generated.bank.*;
import generated.bank.System;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class SystemImpl implements System {

    private final Map<String, AccountEntity> userEntities;
    private final ConcurrentMap<String, CurrencyEntity> currencyEntities;
    private final ObjectAdapter adapter;
    private final Communicator communicator;
    private final String bankServerAddress;
    private final String bankServerPort;

    public SystemImpl(Map<String, AccountEntity> userEntities, ConcurrentMap<String,
            CurrencyEntity> currencyEntities, ObjectAdapter adapter, Communicator communicator) {
        this.userEntities = userEntities;
        this.currencyEntities = currencyEntities;
        this.adapter = adapter;
        this.communicator = communicator;
        IPEndpointInfo endpointInfo = (IPEndpointInfo) adapter.getEndpoints()[0].getInfo();
        this.bankServerAddress = endpointInfo.host;
        this.bankServerPort = (new Integer(endpointInfo.port)).toString();
    }

    @Override
    public AccountCreationResult createAccount(UserData userData, Current current) throws PESELAlreadyInUse {
        checkIfPESELisUnique(userData);
        AccountEntity entity = new AccountEntity(userData.name, userData.surname, userData.pesel, userData.monthlyIncome);
        this.userEntities.put(entity.getPesel(), entity);
        AccountImpl account = new AccountImpl(entity);
        this.adapter.add(account, new Identity(entity.getPesel(), entity.getType().toString()));
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
