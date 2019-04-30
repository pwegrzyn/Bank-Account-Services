package code;

import java.util.Objects;

public class CurrencyEntity {

    private final String code;
    private final long purchase;
    private final long sale;

    public CurrencyEntity(String code, long purchase, long sale) {
        this.code = code;
        this.purchase = purchase;
        this.sale = sale;
    }

    public String getCode() {
        return code;
    }

    public double getPurchase() {
        return purchase;
    }

    public double getSale() {
        return sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return purchase == that.purchase &&
                sale == that.sale &&
                code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, purchase, sale);
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "code='" + code + '\'' +
                ", purchase=" + purchase +
                ", sale=" + sale +
                '}';
    }
}