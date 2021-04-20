package be.willekens.multi.module.template.domain.models.parking_lot;

public class Price {

    private final Currency currency;
    private final double value;

    public Price(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public static Price createPriceInEuros(double value) {
        return new Price(Currency.EURO,value);
    }

    @Override
    public String toString() {
        return value + " " + currency;
    }
}
