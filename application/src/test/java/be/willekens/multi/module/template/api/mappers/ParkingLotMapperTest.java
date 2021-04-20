package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateAddressDto;
import be.willekens.multi.module.template.api.dtos.CreateContactPersonDto;
import be.willekens.multi.module.template.api.dtos.CreateParkingLotDto;
import be.willekens.multi.module.template.domain.models.parking_lot.Category;
import be.willekens.multi.module.template.domain.models.parking_lot.ParkingLot;
import be.willekens.multi.module.template.domain.models.parking_lot.Price;
import be.willekens.multi.module.template.domain.repository.ParkingLotRepository;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidCategoryException;
import be.willekens.multi.module.template.infrastructure.exceptions.InvalidEmailException;
import be.willekens.multi.module.template.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParkingLotMapperTest {


    @Mock
    private ContactPersonMapper contactPersonMapper;
    @Mock
    private AddressMapper addressMapper;
    @InjectMocks
    private ParkingLotMapper parkingLotMapper;

    private final String NAME = "Stalenstraat";
    private final String VALID_CATEGORY = "UNDERGROUND_BUILDING";
    private final int MAX_CAPACITY= 100;
    private final double VALID_PRICE = 10;


    @Test
    void ifInvalidCategoryIsPassed_thenThrowsInvalidCategoryException() {
        CreateParkingLotDto testDto = new CreateParkingLotDto();
        testDto.setCategory("test");
        testDto.setContactPerson(createContactPersonDtoFactory());
        testDto.setParkingAddress(createAddressDtoFactory());
        testDto.setName(NAME);
        testDto.setMaxCapacity(MAX_CAPACITY);
        testDto.setPricePerHour(VALID_PRICE);
        assertThrows(InvalidCategoryException.class, ()-> parkingLotMapper.createParkingLotDto_to_parkingLot(testDto));
    }

    @ParameterizedTest
    @ValueSource(strings = {"UNDERGROUND_BUILDING", "ABOVE_GROUND_BUILDING", "underground_building",
            "above_ground_building"})
    void ifValidCategoryIsPassed_thenDoesNotThrowException(String input) throws Exception {
        //Given
        CreateParkingLotDto testDto = new CreateParkingLotDto();
        testDto.setCategory(input);
        testDto.setContactPerson(createContactPersonDtoFactory());
        testDto.setParkingAddress(createAddressDtoFactory());
        testDto.setName(NAME);
        testDto.setMaxCapacity(MAX_CAPACITY);
        testDto.setPricePerHour(VALID_PRICE);
        //When & Then
        parkingLotMapper.createParkingLotDto_to_parkingLot(testDto);
    }

    private CreateContactPersonDto createContactPersonDtoFactory(){
        CreateContactPersonDto createContactPersonDto = new CreateContactPersonDto();
        createContactPersonDto.setContactPersonsAddress(createAddressDtoFactory());
        createContactPersonDto.setEmail("test@valid.be");
        createContactPersonDto.setFullname("Sherlock Holmes");
        createContactPersonDto.setMobilePhoneNumber("011223344");
        createContactPersonDto.setTelephoneNumber("998877444");
        return createContactPersonDto;
    }

    private CreateAddressDto createAddressDtoFactory(){
        CreateAddressDto createAddressDto = new CreateAddressDto();
        createAddressDto.setStreetName("Baker Street");
        createAddressDto.setStreetNumber("221B");
        createAddressDto.setCity("London");
        createAddressDto.setPostalCode("1000");
        return createAddressDto;
    }

}