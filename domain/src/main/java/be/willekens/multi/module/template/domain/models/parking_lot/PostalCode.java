package be.willekens.multi.module.template.domain.models.parking_lot;

import javax.persistence.*;
import java.util.Objects;

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

    public PostalCode setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public PostalCode setLabel(String label) {
        this.label = label;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode that = (PostalCode) o;
        return postalCode.equals(that.postalCode) && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, label);
    }
}
