package be.willekens.multi.module.template.domain.models.parking_lot;

import javax.persistence.*;

@Entity
@Table(name="postal_codes")
public class PostalCode {

    @Id
    @Column(name="postal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "postal_code", unique=true)
    private String postalCode;
    @Column(name="city")
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
