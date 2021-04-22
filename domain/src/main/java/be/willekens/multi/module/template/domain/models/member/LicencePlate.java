package be.willekens.multi.module.template.domain.models.member;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class LicencePlate {

    @Column(name = "plate_number")
    private String plateNumber;
    @Column(name = "issuing_country")
    private String issuingCountry;

    public LicencePlate() {
    }

    public LicencePlate(String plateNumber, String issuingCountry) {
        this.plateNumber = plateNumber;
        this.issuingCountry = issuingCountry;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicencePlate that = (LicencePlate) o;
        return Objects.equals(plateNumber, that.plateNumber) && Objects.equals(issuingCountry, that.issuingCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, issuingCountry);
    }
}
