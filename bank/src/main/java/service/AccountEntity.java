package service;

import bank.AccountType;

import java.util.Objects;

public class AccountEntity {

    private String name;
    private String surname;
    private String password;
    private String pesel;
    private long monthlyIncome;
    private AccountType type;
    private long balance;
    private static final long incomePremiumStep = 1500000;

    public AccountEntity(String name, String surname, String pesel, long monthlyIncome) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.monthlyIncome = monthlyIncome;
        if (monthlyIncome > incomePremiumStep) {
            this.type = AccountType.PREMIUM;
        } else {
            this.type = AccountType.STANDARD;
        }
        this.balance = 0;
        generatePassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public long getMonthlyIncome() {
        return monthlyIncome;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return monthlyIncome == that.monthlyIncome &&
                balance == that.balance &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                pesel.equals(that.pesel) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, monthlyIncome, type, balance);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }

    private void generatePassword() {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        int count = 8;
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        this.password = builder.toString();
    }
}
