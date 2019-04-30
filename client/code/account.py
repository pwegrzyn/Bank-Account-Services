
class AccountEntity:

    def __init__(self, pesel, proxy):
        self.pesel = pesel
        self.proxy_object = proxy

    def check_account_balance(self):
        return self.proxy_object.checkAccountBalance()
