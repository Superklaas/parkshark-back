package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import be.willekens.multi.module.template.domain.models.parking_lot.ContactPerson;
import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.models.parking_lot.PostalCode;
import be.willekens.multi.module.template.domain.repository.ParkingLotRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


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
        parkingLot.setAddress(parkingLotAddress);
        ContactPerson contactPerson = parkingLot.getContactPerson();
        Address contactAddress = contactPerson.getAddress();
        contactAddress.setPostalCode(getPostalCodeByPostalCodeOrCreateNewOne(contactAddress.getPostalCode()));
        contactPerson.setAddress(contactAddress);
        parkingLot.setContactPerson(contactPerson);
       return parkingLotRepository.save(parkingLot);
    }


    public PostalCode getPostalCodeByPostalCodeOrCreateNewOne(PostalCode postalCode) {
        PostalCode resultPostalCode = postalCodeService.getByPostalCode(postalCode.getPostalCode());
        if (resultPostalCode == null) {
            resultPostalCode = postalCodeService.createPostalCode(postalCode);
        }
        return resultPostalCode;
    }
}
