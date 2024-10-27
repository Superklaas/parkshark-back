package com.superklaas.service;

import com.superklaas.domain.models.address.Address;
import com.superklaas.domain.models.parking_lot.ParkingLot;
import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.repository.ParkingLotRepository;
import com.superklaas.infrastructure.exceptions.ParkingLotDoesNotExistException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@NoArgsConstructor
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private PostalCodeService postalCodeService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        Address parkingLotAddress = parkingLot.getAddress();
        parkingLotAddress.setPostalCode(getPostalCodeByPostalCodeOrCreateNewOne(parkingLotAddress.getPostalCode()));
        Address contactAddress = parkingLot.getContactPerson().getAddress();
        contactAddress.setPostalCode(getPostalCodeByPostalCodeOrCreateNewOne(contactAddress.getPostalCode()));
        return parkingLotRepository.save(parkingLot);
    }

    public PostalCode getPostalCodeByPostalCodeOrCreateNewOne(PostalCode postalCode) {
        PostalCode resultPostalCode = postalCodeService.getByPostalCode(postalCode.getPostalCode());
        if (resultPostalCode == null) {
            resultPostalCode = postalCodeService.createPostalCode(postalCode);
        }
        return resultPostalCode;
    }

    public ParkingLot findById(int id) {
        Optional<ParkingLot> parkingLot =  parkingLotRepository.findById(id);
        if (parkingLot.isEmpty()) {
            throw new ParkingLotDoesNotExistException("There is no parking lot with id = " + id);
        }
        return parkingLot.get();
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.findAll();
    }
}
