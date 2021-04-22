package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.models.parking_spot.ParkingSpot;
import be.willekens.multi.module.template.domain.repository.ParkingSpotRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidLicenceException;
import be.willekens.multi.module.template.infrastructure.exceptions.NoParkingSpotLeftException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository, ParkingLotService parkingLotService) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotService = parkingLotService;
    }

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        if (!parkingSpot.getMemberId().getLicencePlate().equals(parkingSpot.getLicencePlate())) {
            throw new InvalidLicenceException("Provided licence plate is invalid");
        }

        ParkingLot parkingLot = parkingLotService.findById(parkingSpot.getParkingLotId().getId());
        if (parkingLot.getAvailableSpotsLeft() == 0) {
            throw new NoParkingSpotLeftException("There is no parking spot available");
        }
        parkingLot.reduce_available_spots_left();
        return parkingSpotRepository.save(parkingSpot);
    }

}
