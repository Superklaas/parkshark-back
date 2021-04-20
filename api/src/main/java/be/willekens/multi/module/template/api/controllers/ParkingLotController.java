package be.willekens.multi.module.template.api.controllers;


import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.api.dtos.ReceiveParkingLotDto;
import be.willekens.multi.module.template.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = ParkingLotController.PARKING_LOT_RESOURCE_PATH)
public class ParkingLotController {
    public static final String PARKING_LOT_RESOURCE_PATH = "/parking-lots";
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceiveParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        logger.info("Attempt to create a parking  lot");
        return null;
    }


}
