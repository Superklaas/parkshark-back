package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.repository.ParkingLotRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.ParkingLotDoesNotExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
@NoArgsConstructor
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
       return parkingLotRepository.save(parkingLot);
    }


    public void checkIfIsThereParkingSpotAvailable(ParkingLot parkingLotId) {
      Optional<ParkingLot> parkingLot =  parkingLotRepository.findById(parkingLotId.getId());
      parkingLot.get().reduce_available_spots_left();
    }

    public ParkingLot findById(int id) {
        Optional<ParkingLot> parkingLot =  parkingLotRepository.findById(id);
        if (parkingLot.isEmpty()) {
            throw new ParkingLotDoesNotExistException("There is no parking lot with id = " + id);
        }
        return parkingLot.get();
    }
}
