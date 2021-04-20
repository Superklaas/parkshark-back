package be.willekens.multi.module.template.domain.models.parking_lot;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price {

    @Column
    private Currency currency;
    @Column
    private double value;

    public Price(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public Price() {
    }

    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public static Price createPriceInEuros(double value) {
        return new Price(Currency.EURO, value);
    }

    @Override
    public String toString() {
        return value + " " + currency;
    }
}
