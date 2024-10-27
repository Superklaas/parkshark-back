package com.superklaas.service;

import com.superklaas.domain.models.member.LicencePlate;
import com.superklaas.domain.models.member.Member;
import com.superklaas.domain.models.parking_lot.ParkingLot;
import com.superklaas.domain.models.parking_spot.ParkingSpot;
import com.superklaas.domain.repository.ParkingSpotRepository;
import com.superklaas.infrastructure.exceptions.InvalidLicenceException;
import com.superklaas.infrastructure.exceptions.NoParkingSpotLeftException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingSpotServiceTest {

    @Mock
    ParkingSpotRepository parkingSpotRepository;
    @Mock
    ParkingLotService parkingLotService;
    @InjectMocks
    ParkingSpotService parkingSpotService;

    Member member;
    ParkingLot parkingLot;
    ParkingSpot parkingSpot;

    @BeforeEach
    void setUp() {
        member = new Member().setLicencePlate(new LicencePlate("1", "B"));
        parkingLot = new ParkingLot();
        parkingSpot = new ParkingSpot(member, parkingLot, new LicencePlate("1", "B"), LocalDate.now());
    }

    @Test
    void createParkingSpot_whenLicensePlatesDoNotMatch_thenThrowInvalidLicenceException() {
        member.setLicencePlate(new LicencePlate("2", "B"));
        parkingSpot.setMemberId(member);
        assertThatThrownBy(() -> parkingSpotService.createParkingSpot(parkingSpot))
                .isInstanceOf(InvalidLicenceException.class)
                .hasMessage("Provided licence plate is invalid");
    }

    @Test
    void createParkingSpot_whenParkingLotFullyBooked_thenThrowNoParkingSpotLeftException() {
        parkingLot.setAvailableSpotsLeft(0);
        when(parkingLotService.findById(parkingSpot.getParkingLotId().getId())).thenReturn(parkingLot);
        assertThatThrownBy(() -> parkingSpotService.createParkingSpot(parkingSpot))
                .isInstanceOf(NoParkingSpotLeftException.class)
                .hasMessage("There is no parking spot available");
    }

    @Test
    void createParkingSpot_whenParkingSpotCreated_thenAvailableParkingSpotsDecreasedByOne() {
        // GIVEN
        parkingLot.setAvailableSpotsLeft(2);
        when(parkingSpotRepository.save(parkingSpot)).thenReturn(parkingSpot);
        when(parkingLotService.findById(parkingSpot.getParkingLotId().getId())).thenReturn(parkingLot);
        // WHEN
        parkingSpotService.createParkingSpot(parkingSpot);
        // THEN
        assertThat(parkingLot.getAvailableSpotsLeft()).isEqualTo(1);
    }

    @Test
    void createParkingSpot_whenParkingSpotCreated_thenReturnParkingSpot() {
        // GIVEN
        parkingLot.setAvailableSpotsLeft(2);
        when(parkingSpotRepository.save(parkingSpot)).thenReturn(parkingSpot);
        when(parkingLotService.findById(parkingSpot.getParkingLotId().getId())).thenReturn(parkingLot);
        // WHEN
        ParkingSpot returnedParkingSpot = parkingSpotService.createParkingSpot(parkingSpot);
        // THEN
        Assertions.assertThat(parkingSpotService.createParkingSpot(parkingSpot)).isEqualTo(parkingSpot);
    }

}
