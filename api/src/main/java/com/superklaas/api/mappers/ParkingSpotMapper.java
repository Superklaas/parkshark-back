package com.superklaas.api.mappers;

import com.superklaas.api.dtos.CreateParkingSpotDto;
import com.superklaas.domain.models.member.LicencePlate;
import com.superklaas.api.dtos.ReceiveParkingSpotDto;
import com.superklaas.domain.models.parking_spot.ParkingSpot;
import com.superklaas.service.MemberService;
import com.superklaas.service.ParkingLotService;
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
