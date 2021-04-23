package be.willekens.multi.module.template.api.controllers;

import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.api.dtos.ReceiveAllParkingLotsDto;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingLotDto;
import be.willekens.multi.module.template.api.mappers.ParkingLotMapper;
import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ParkingLotController.PARKING_LOT_RESOURCE_PATH)
public class ParkingLotController {

    public static final String PARKING_LOT_RESOURCE_PATH = "/parking-lots";
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    private final ParkingLotService parkingLotService;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @PreAuthorize("hasAuthority('CREATE_PARKING_LOT')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceiveParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        logger.info("Attempt to create a parking lot");
        ParkingLot parkingLot = parkingLotService.createParkingLot(parkingLotMapper.createParkingLotDto_to_parkingLot(createParkingLotDto));
        return parkingLotMapper.parkingLot_to_receiveParkingLotDto(parkingLot);
    }

    @PreAuthorize("hasAuthority('GET_ALL_PARKING_LOTS')")
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ReceiveAllParkingLotsDto> getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();
        return parkingLotMapper.parkingLot_to_receiveAllParkingLotsDto(parkingLots);
    }

}
