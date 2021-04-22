package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateParkingSpotDto {

    private int memberId;
    private int parkingLotId;
    private String licencePlateNumber;
    private String licencePlateCountry;

}
