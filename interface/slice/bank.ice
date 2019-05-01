#ifndef BANK_ICE
#define BANK_ICE

module bank {

    enum Currency {
        PLN,
        EUR,
        USD,
        JPY,
        CHF,
        CNY
    }

    enum AccountType { 
        STANDARD, 
        PREMIUM 
    };

    struct UserData {
        string name;
        string surname;
        string pesel;
        long monthlyIncome;
    };

    struct AccountCreationResult {
        string password;
        AccountType accountType;
    };

    struct Credit {
        double rateOfForeignCurrencyDuringSigning;
        Currency baseCurrency;
        Currency foreignCurrency;
        int creditPeriod;
        int numberOfInstallments;
        int numberOfCapitalizationPeriods;
        double interestRate;
        double commissionCostRate;
        long valueOfBorrowedCapital;
        long creditCostInBaseCurrency;
        long creditCostInForeignCurrency;
    };

    exception BankSystemException {
        string reason;
    };

    exception AuthorizationFailed extends BankSystemException {};
    exception PESELAlreadyInUse extends BankSystemException {};
    exception InvalidCredentials extends BankSystemException {};
    exception CurrencyNotSupported extends BankSystemException {};
    exception InternalSystemError extends BankSystemException {};
    exception SystemCurrentlyUnavailable extends BankSystemException {};

    interface Account {
        long checkAccountBalance();
        UserData getUserData();
        AccountType checkAccountType();
    };

    interface PremiumAccount extends Account {
        Credit applyForCredit(Currency currency, long creditValue, int period) throws CurrencyNotSupported;
    };

    interface System {
        AccountCreationResult createAccount(UserData userData) throws PESELAlreadyInUse;
        Account* logInToAccount(string pesel) throws InvalidCredentials;
    };

};

#endif