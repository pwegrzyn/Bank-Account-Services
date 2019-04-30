package code;

import com.zeroc.Ice.Current;
import generated.bank.*;

public class AccountImpl implements Account {

    private final AccountEntity entity;

    public AccountImpl(AccountEntity entity) {
        this.entity = entity;
    }

    @Override
    public long checkAccountBalance(Current current) {
        return entity.getBalance();
    }

    @Override
    public AccountType checkAccountType(Current current) {
        return entity.getType();
    }

    @Override
    public Credit applyForCredit(Currency currency, long creditValue, int period, Current current) throws AuthorizationFailed, CurrencyNotSupported {
        return null;
    }

}
