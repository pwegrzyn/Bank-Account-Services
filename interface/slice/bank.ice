#ifndef BANK_ICE
#define BANK_ICE

module generated {
    module bank {
    
        enum Currency {
            PLN,
            EUR,
            USD,
            JPY,
            CHF,
            CNH
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
            long creditRateBaseCurrency;
            long creditRateForeignCurrency;
            Currency baseCurrency;
            Currency foreignCurrency;
            int creditPeriod;
            long creditValue;
            double interestRate;
            long creditCost;
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
            AccountType checkAccountType();
            Credit applyForCredit(Currency currency, long creditValue, int period) throws CurrencyNotSupported, AuthorizationFailed;
        };
    
        interface System {
            AccountCreationResult createAccount(UserData userData) throws PESELAlreadyInUse;
            Account* logInToAccount(string pesel) throws InvalidCredentials;
        };
    
    };
}

#endif