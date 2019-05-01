

class AccountEntity:

    def __init__(self, pesel, proxy):
        self.pesel = pesel
        self.account_proxy = proxy

    def check_account_balance(self):
        return self.account_proxy.checkAccountBalance()

    def check_account_type(self):
        return self.account_proxy.checkAccountType()

    def get_user_data(self):
        return self.account_proxy.getUserData()


class PremiumAccountEntity(AccountEntity):
    
    def apply_for_credit(self, currency, value, period):
        return self.account_proxy.applyForCredit(currency, value, period)