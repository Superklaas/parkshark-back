package be.willekens.multi.module.template.domain.models.parking_lot;

public class PostalCode {

    private String postalCode;
    private String label;

    public PostalCode(String postalCode, String label) {
        this.postalCode = postalCode;
        this.label = label;
    }

    public PostalCode() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLabel() {
        return label;
    }
}
