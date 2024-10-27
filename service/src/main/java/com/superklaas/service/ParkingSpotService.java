package com.superklaas.service;

import com.superklaas.domain.models.parking_lot.ParkingLot;
import com.superklaas.domain.models.parking_spot.ParkingSpot;
import com.superklaas.domain.repository.ParkingSpotRepository;
import com.superklaas.infrastructure.exceptions.InvalidLicenceException;
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
        parkingLot.reduceAvailableSpotsLeft();
        return parkingSpotRepository.save(parkingSpot);
    }

}
