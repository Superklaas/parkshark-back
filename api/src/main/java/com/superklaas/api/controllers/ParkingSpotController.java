package com.superklaas.api.controllers;

import com.superklaas.api.dtos.CreateParkingSpotDto;
import com.superklaas.api.dtos.ReceiveParkingSpotDto;
import com.superklaas.api.mappers.ParkingSpotMapper;
import com.superklaas.domain.models.parking_spot.ParkingSpot;
import com.superklaas.service.ParkingSpotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = ParkingSpotController.PARKING_SPOT_RESOURCE_PATH)
public class ParkingSpotController {
    public static final String PARKING_SPOT_RESOURCE_PATH = "/parking-spots";
    private static final Logger logger = LoggerFactory.getLogger(ParkingSpotController.class);

    private ParkingSpotService parkingSpotService;
    private ParkingSpotMapper parkingSpotMapper;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService, ParkingSpotMapper parkingSpotMapper) {
        this.parkingSpotService = parkingSpotService;
        this.parkingSpotMapper = parkingSpotMapper;
    }

    @PreAuthorize("hasAuthority('ALLOCATE_PARKING_SPOT')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceiveParkingSpotDto allocateParkingSpot(@RequestBody CreateParkingSpotDto createParkingSpotDto) {
        logger.info("Attempt to allocate a parking spot");
        ParkingSpot parkingSpot = parkingSpotService.createParkingSpot(parkingSpotMapper.createParkingSpotDto_to_parkingSpot(createParkingSpotDto));
        return parkingSpotMapper.parkingSpot_to_ReceiveParkingSpotDto(parkingSpot);
    }

}
