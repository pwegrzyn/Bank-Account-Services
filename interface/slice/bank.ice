#ifndef BANK_ICE
#define BANK_ICE

module bank {

    enum Currency {
        PLN,
        EUR,
        USD,
        JPY,
    };

    enum AccountType { 
        STANDARD, 
        PREMIUM 
    };

    struct UserData {
        string name;
        string surname;
        string pesel;
        int monthlyIncome;
    };

    struct AccountCreationResult {
        string password;
        AccountType accountType;
    };

    struct Credit {
        double creditRateBaseCurrency;
        double creditRateForeignCurrency;
        Currency baseCurrency;
        Currency foreignCurrency;
        int creditPeriod;
        double creditValue;
        double interestRate;
        double creditCost;
    };

    exception BankSystemException {
        string reason;
    };

    exception AuthorizationFailed extends BankSystemException {};
    exception InvalidCredentials extends BankSystemException {};
    exception CurrencyNotSupported extends BankSystemException {};
    exception InternalSystemError extends BankSystemException {};
    exception SystemCurrentlyUnavailable extends BankSystemException {};

    interface User {
        double checkAccountBalance();
        AccountType checkAccountType();
    };

    interface PremiumUser extends User {
        Credit applyForCredit(Currency currency, double creditValue, int period) throws CurrencyNotSupported;
    };

    interface System {
        AccountCreationResult createAccount(UserData userData);
        User* logInStandard(string pesel) throws InvalidCredentials;
        PremiumUser* logInPremium(string pesel) throws InvalidCredentials, AuthorizationFailed;
    };

};

#endif