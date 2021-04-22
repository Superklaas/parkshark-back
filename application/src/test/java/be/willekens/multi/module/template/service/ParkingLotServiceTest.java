package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.parking_lot.*;
import be.willekens.multi.module.template.domain.models.price.Price;
import be.willekens.multi.module.template.domain.repository.ParkingLotRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ParkingLotServiceTest {

    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private PostalCodeService postalCodeService;
    @InjectMocks
    private ParkingLotService parkingLotService;


    Address address = new Address("Sussame Street", "32", new PostalCode("3300", "Tienen"));
    ContactPerson contactPerson = new ContactPerson("Ihsan", "04555555", "", "rafael@excalibur.com", address);


    @Test
    void createNewParkingLot_thenReturnsParkingLot() {
        ParkingLot parkingLot = new ParkingLot("Andre", Category.ABOVE_GROUND_BUILDING, 10, contactPerson, address, Price.createPriceInEuros(3));
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        when(postalCodeService.getByPostalCode(address.getPostalCode().getPostalCode())).thenReturn(address.getPostalCode());

        assertThat(parkingLotService.createParkingLot(parkingLot)).isEqualTo(parkingLot);
        verify(parkingLotRepository).save(parkingLot);
    }


}
