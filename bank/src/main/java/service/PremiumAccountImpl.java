package service;

import bank.*;
import com.zeroc.Ice.Current;

import java.lang.System;
import java.util.concurrent.ConcurrentMap;

public class PremiumAccountImpl extends AccountImpl implements PremiumAccount {

    private final ExchangeRateRequest supportedCurrencies;
    private final ConcurrentMap<service.Currency, CurrencyEntity> exchangeRates;
    private final double commissionCostRate = 0.05;
    private final int capitalizationPeriod = 180;
    private final double interestRate = 0.15;

    public PremiumAccountImpl(AccountEntity entity, ExchangeRateRequest supportedCurrencies,
                              ConcurrentMap<service.Currency, CurrencyEntity> exchangeRates) {
        super(entity);
        this.supportedCurrencies = supportedCurrencies;
        this.exchangeRates = exchangeRates;
    }

    @Override
    public Credit applyForCredit(bank.Currency currency, long creditValue, int period, Current current)
            throws CurrencyNotSupported {
        System.out.println("A premium client has applied for a credit.");
        checkIfCurrencyIsSupported(currency);
        Credit credit = new Credit();
        credit.baseCurrency = bank.Currency.PLN;
        credit.foreignCurrency = currency;
        credit.creditPeriod = period;
        credit.rateOfForeignCurrencyDuringSigning = this.exchangeRates.get(this.getServiceCurrencyFromBankCurrency(currency)).getRate();
        credit.commissionCostRate = this.commissionCostRate;
        credit.numberOfCapitalizationPeriods = period / this.capitalizationPeriod;
        credit.valueOfBorrowedCapital = creditValue;
        credit.numberOfInstallments = period / 30;
        credit.interestRate = this.interestRate;
        assignCreditCost(credit);
        this.entity.setBalance(this.entity.getBalance() + credit.valueOfBorrowedCapital);
        return credit;
    }

    private void assignCreditCost(Credit credit) {
        long totalCostInBase = 0;

        // First add the one-time commission cost
        totalCostInBase += credit.valueOfBorrowedCapital * this.commissionCostRate;

        // Then calculate the value of one installment
        double q = 1 + credit.interestRate / credit.numberOfCapitalizationPeriods;
        double qToTheN = Math.pow(q, credit.numberOfInstallments);
        long costOfOneInstallmentInBase = (long) (credit.valueOfBorrowedCapital * qToTheN * ((q - 1) / (qToTheN - 1)));

        // Multiply by the number of installments
        totalCostInBase += (costOfOneInstallmentInBase * credit.numberOfInstallments);

        credit.creditCostInBaseCurrency = totalCostInBase;
        credit.creditCostInForeignCurrency = (long) (totalCostInBase / credit.rateOfForeignCurrencyDuringSigning);
    }

    private void checkIfCurrencyIsSupported(bank.Currency currency) throws CurrencyNotSupported {
        for(service.Currency supportedCurrency : this.supportedCurrencies.getCurrencyTypeList()) {
            if(supportedCurrency.toString().equals(currency.toString())) {
                return;
            }
        }
        throw new CurrencyNotSupported();
    }

    private service.Currency getServiceCurrencyFromBankCurrency(bank.Currency bankCurrency) {
        service.Currency serviceCurrency;
        switch (bankCurrency) {
            case CHF:
                serviceCurrency = service.Currency.CHF; break;
            case USD:
                serviceCurrency = service.Currency.USD; break;
            case JPY:
                serviceCurrency = service.Currency.JPY; break;
            case EUR:
                serviceCurrency = service.Currency.EUR; break;
            case CNY:
                serviceCurrency = service.Currency.CNY; break;
            case PLN:
                serviceCurrency = service.Currency.PLN; break;
             default:
                 serviceCurrency = null;
        }
        return serviceCurrency;
    }

}
