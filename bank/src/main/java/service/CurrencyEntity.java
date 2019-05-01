package service;

import java.util.Objects;

public class CurrencyEntity {

    private final String code;
    private double rate;
    private final Currency type;

    public CurrencyEntity(Currency type, double rate) {
        this.type = type;
        this.rate = rate;
        switch (this.type) {
            case EUR:
                this.code =  "EUR";
                break;
            case USD:
                this.code = "USD";
                break;
            case JPY:
                this.code = "JPY";
                break;
            case CHF:
                this.code = "CHF";
                break;
            case CNY:
                this.code = "CNY";
                break;
            default:
                this.code = null;
                break;
        }
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Currency getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity entity = (CurrencyEntity) o;
        return Double.compare(entity.rate, rate) == 0 &&
                Objects.equals(code, entity.code) &&
                type == entity.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, rate, type);
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "code='" + code + '\'' +
                ", rate=" + rate +
                ", type=" + type +
                '}';
    }
}