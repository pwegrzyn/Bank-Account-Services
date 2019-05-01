package service;

import com.zeroc.Ice.Current;
import bank.*;

public class AccountImpl implements Account {

    protected final AccountEntity entity;

    public AccountImpl(AccountEntity entity) {
        this.entity = entity;
    }

    @Override
    public long checkAccountBalance(Current current) {
        return this.entity.getBalance();
    }

    @Override
    public UserData getUserData(Current current) {
        UserData userData = new UserData();
        userData.monthlyIncome = this.entity.getMonthlyIncome();
        userData.name = this.entity.getName();
        userData.surname = this.entity.getSurname();
        userData.pesel = this.entity.getPesel();
        return userData;
    }

    @Override
    public AccountType checkAccountType(Current current) {
        return this.entity.getType();
    }

}
