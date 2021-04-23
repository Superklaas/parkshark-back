package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateParkingSpotDto;
import be.willekens.multi.module.template.domain.models.member.LicencePlate;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingSpotDto;
import be.willekens.multi.module.template.domain.models.parking_spot.ParkingSpot;
import be.willekens.multi.module.template.service.MemberService;
import be.willekens.multi.module.template.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ParkingSpotMapper {

    private final ParkingLotService parkingLotService;
    private final MemberService memberService;

    @Autowired
    public ParkingSpotMapper(ParkingLotService parkingLotService, MemberService memberService) {
        this.parkingLotService = parkingLotService;
        this.memberService = memberService;
    }

    public ParkingSpot createParkingSpotDto_to_parkingSpot(CreateParkingSpotDto createParkingSpotDto) {
        return new ParkingSpot()
                .setParkingLotId(parkingLotService.findById(createParkingSpotDto.getParkingLotId()))
                .setMemberId(memberService.findById(createParkingSpotDto.getMemberId()))
                .setLicencePlate(new LicencePlate(createParkingSpotDto.getLicencePlateNumber(), createParkingSpotDto.getLicencePlateCountry()))
                .setStartAllocationDate(LocalDate.now());
    }

    public ReceiveParkingSpotDto parkingSpot_to_ReceiveParkingSpotDto(ParkingSpot parkingSpot) {
        return new ReceiveParkingSpotDto()
                .setId(parkingSpot.getId())
                .setParkingLotId(parkingSpot.getParkingLotId().getId())
                .setMemberId(parkingSpot.getMemberId().getId())
                .setLicencePlateNumber(parkingSpot.getLicencePlate().getPlateNumber())
                .setLicencePlateCountry(parkingSpot.getLicencePlate().getIssuingCountry());
    }

}
