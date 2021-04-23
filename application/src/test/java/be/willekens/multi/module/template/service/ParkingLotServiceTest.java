package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.address.PostalCode;
import be.willekens.multi.module.template.domain.models.parking_lot.*;
import be.willekens.multi.module.template.domain.models.price.Price;
import be.willekens.multi.module.template.domain.repository.ParkingLotRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.ParkingLotDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    Address address;
    ContactPerson contactPerson;
    ParkingLot parkingLot;
    List<ParkingLot> parkingLots;

    @BeforeEach
    void setUp() {
        address = new Address("Sussame Street", "32", new PostalCode("3300", "Tienen"));
        contactPerson = new ContactPerson("Ihsan", "04555555", "", "rafael@excalibur.com", address);
        parkingLot = new ParkingLot("Andre", Category.ABOVE_GROUND_BUILDING, 10, contactPerson, address,
                Price.createPriceInEuros(3));
        parkingLots = List.of(parkingLot);
    }

    @Test
    void createParkingLot_whenValidParkingLot_thenReturnParkingLot() {
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        when(postalCodeService.getByPostalCode(address.getPostalCode().getPostalCode())).thenReturn(address.getPostalCode());
        assertThat(parkingLotService.createParkingLot(parkingLot)).isEqualTo(parkingLot);
        verify(parkingLotRepository).save(parkingLot);
    }

    @Test
    void getAllParkingLots_whenParkingLotsInDB_thenReturnListParkingLots() {
        when(parkingLotRepository.findAll()).thenReturn(parkingLots);
        assertThat(parkingLotService.getAllParkingLots()).containsExactly(parkingLot);
        verify(parkingLotRepository).findAll();
    }

    @Test
    void findById_whenParkingLotInDB_thenReturnParkingLot() {
        when(parkingLotRepository.findById(1)).thenReturn(ofNullable(parkingLot));
        assertThat(parkingLotService.findById(1)).isEqualTo(parkingLot);
        verify(parkingLotRepository).findById(anyInt());
    }

    @Test
    void findById_whenNoParkingLotInDB_thenThrowParkingLotDoesNotExistException() {
        when(parkingLotRepository.findById(1)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> parkingLotService.findById(1))
                .isInstanceOf(ParkingLotDoesNotExistException.class)
                .hasMessage("There is no parking lot with id = 1");
    }

}
