package be.willekens.multi.module.template.domain.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
}
