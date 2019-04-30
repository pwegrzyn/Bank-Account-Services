
import sys
import Ice
import os
from account import AccountEntity

Ice.loadSlice('./interface/slice/bank.ice')

import generated.bank as bank


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
        loop_active = True
        while loop_active:
            self.create_account()
            self.log_in()
            print(self.active_account.check_account_balance())
        return 0

    def log_in(self):
        print('Please provide your PESEL: ', end='', flush=True)
        pesel = sys.stdin.readline().strip()
        print('Please provide your password: ', end='', flush=True)
        password = sys.stdin.readline().strip()
        try:
            ctx = {'passwordAttempt': password}
            account_proxy = self.two_way.logInToAccount(pesel, ctx)
            self.active_account = AccountEntity(pesel, account_proxy)
            print('Logged in')
        except bank.InvalidCredentials:
            print("The credentials you have provided are invalid!")
        return

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
        result = self.two_way.createAccount(user_data)
        print(f'Your account type: {result.accountType}')
        print(f'Your password: {result.password}')
