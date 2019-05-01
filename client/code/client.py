
import sys
import Ice
import os
from account import AccountEntity, PremiumAccountEntity

Ice.loadSlice('./interface/slice/bank.ice')

import bank


class ClientApp(Ice.Application):
    
    def __init__(self):
        self.two_way = None
        self.active_account = None
        Ice.Application.__init__(self, Ice.Application.NoSignalHandling)

    def run(self, args):
        print('Please choose bank endpoint (1/2): ', end='', flush=True)
        server_id = sys.stdin.readline().strip()
        self.two_way = bank.SystemPrx.checkedCast(
            self.communicator().propertyToProxy('System'+server_id+'.Proxy').ice_twoway().ice_secure(False))
        self.run_interactive_loop()
        return 0

    def log_in(self):
        print('Please provide your PESEL: ', end='', flush=True)
        pesel = sys.stdin.readline().strip()
        print('Please provide your password: ', end='', flush=True)
        password = sys.stdin.readline().strip()
        try:
            ctx = {'passwordAttempt': password}
            account_proxy = self.two_way.logInToAccount(pesel, ctx)
            if account_proxy != None and account_proxy.ice_isA("::bank::PremiumAccount"):
                self.active_account = PremiumAccountEntity(pesel, bank.PremiumAccountPrx.checkedCast(account_proxy))
            elif account_proxy != None and account_proxy.ice_isA("::bank::Account"):
                self.active_account = AccountEntity(pesel, account_proxy)
            else:
                print('Error!')
                return False
            print('Successfully obtained access to the account.')
            return True
        except bank.InvalidCredentials:
            print("The credentials you have provided are invalid!")
            return False

    def create_account(self):
        print('Please provide your name: ', end='', flush=True)
        name = sys.stdin.readline().strip()
        print('Please provide your surname: ', end='', flush=True)
        surname = sys.stdin.readline().strip()
        print('Please provide your PESEL: ', end='', flush=True)
        pesel = sys.stdin.readline().strip()
        print('Please provide your monthly income: ', end='', flush=True)
        monthly_income = int(sys.stdin.readline().strip())
        user_data = bank.UserData(name, surname, pesel, monthly_income)
        try:
            result = self.two_way.createAccount(user_data)
            print(f'Your account type: {result.accountType}')
            print(f'Your password: {result.password}')
        except bank.PESELAlreadyInUse:
            print('The provided PESEL is already in use!')
        return

    def check_account_balance(self):
        return self.active_account.check_account_balance() / 100

    def check_account_type(self):
        return self.active_account.check_account_type()

    def get_user_data(self):
        return self.active_account.get_user_data()

    def apply_for_credit(self):
        if not isinstance(self.active_account, PremiumAccountEntity):
            print('Only Premium users can apply for a credit!')
            return
        print('Please provide chosen foreign currency: ', end='', flush=True)
        currency = sys.stdin.readline().strip()
        print('Please provide the value of the credit: ', end='', flush=True)
        credit_value = sys.stdin.readline().strip()
        print('Please provide the period of the credit: ', end='', flush=True)
        credit_period = sys.stdin.readline().strip()
        try:
            credit_result = self.active_account.apply_for_credit(self.string_currency_to_enum(currency), int(credit_value), int(credit_period))
            print('Credit successfully obtainted. Your account balance has been updated accordingly. Details of the agreement:')
            print(f'Rate Of Foreign Currency During Signing: {credit_result.rateOfForeignCurrencyDuringSigning}')
            print(f'Base Currency: {credit_result.baseCurrency}')
            print(f'Foreign Currency: {credit_result.foreignCurrency}')
            print(f'Credit Period: {credit_result.creditPeriod}')
            print(f'Number Of Installments: {credit_result.numberOfInstallments}')
            print(f'Number Of Capitalization Periods: {credit_result.numberOfCapitalizationPeriods}')
            print(f'Interest Rate: {credit_result.interestRate}')
            print(f'Commission Cost Rate: {credit_result.commissionCostRate}')
            print(f'Value Of Borrowed Capital: {credit_result.valueOfBorrowedCapital}')
            print(f'Credit Cost In Base Currency: {credit_result.creditCostInBaseCurrency / 100}')
            print(f'Credit Cost In Foreign Currency: {credit_result.creditCostInForeignCurrency / 100}')
        except bank.CurrencyNotSupported:
            print('The chosen currency is not supported by the bank!')
        return

    def string_currency_to_enum(self, currency_string):
        if currency_string == "USD":
            return bank.Currency.USD
        elif currency_string == "PLN":
            return bank.Currency.PLN
        elif currency_string == "EUR":
            return bank.Currency.EUR
        elif currency_string == "JPY":
            return bank.Currency.JPY
        elif currency_string == "CHF":
            return bank.Currency.CHF
        elif currency_string == "CNY":
            return bank.Currency.CNY
        else:
            return None

    def run_interactive_loop(self):
        while True:
            print('Choose option (login/create_account/exit): ', end='', flush=True)
            response = sys.stdin.readline().strip()
            if response == 'login':
                if self.log_in():
                    isLoggendIn = True
                    while isLoggendIn:
                        print('Choose option (account_balance/account_type/user_data/credit/logout): ', end='', flush=True)
                        response = sys.stdin.readline().strip()
                        if response == 'account_balance':
                            print(f'Current account balance: {self.check_account_balance()}')
                        elif response == 'account_type':
                            print(f'Current account type: {self.check_account_type()}')
                        elif response == 'user_data':
                            user_data = self.get_user_data()
                            print(f'Name: {user_data.name}')
                            print(f'Surname: {user_data.surname}')
                            print(f'PESEL: {user_data.pesel}')
                            print(f'Declared Monthly Income: {user_data.monthlyIncome / 100}')
                        elif response == 'logout':
                            isLoggendIn = False
                        elif response == 'credit':
                            self.apply_for_credit()
                        else:
                            print('Unrecognized option. Try again.')
            elif response == 'create_account':
                self.create_account()
            elif response == 'exit':
                return
            else:
                print('Unrecognized option. Try again.')
