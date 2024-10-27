package com.superklaas.domain.models.parking_spot;

import com.superklaas.domain.models.member.LicencePlate;
import com.superklaas.domain.models.member.Member;
import com.superklaas.domain.models.parking_lot.ParkingLot;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_spot_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
    @ManyToOne
    @JoinColumn(name="parking_lot_id")
    private ParkingLot parkingLotId;
    @Embedded
    private LicencePlate licencePlate;
    @Column(name = "start_allocation_date",columnDefinition = "DATE")
    private LocalDate startAllocationDate;

    public ParkingSpot(Member memberId, ParkingLot parkingLotId, LicencePlate licencePlate, LocalDate startAllocationDate) {
        this.memberId = memberId;
        this.parkingLotId = parkingLotId;
        this.licencePlate = licencePlate;
        this.startAllocationDate = startAllocationDate;
    }

    public ParkingSpot() {
    }

    public int getId() {
        return id;
    }

    public Member getMemberId() {
        return memberId;
    }

    public ParkingLot getParkingLotId() {
        return parkingLotId;
    }

    public LicencePlate getLicencePlate() {
        return licencePlate;
    }

    public LocalDate getStartAllocationDate() {
        return startAllocationDate;
    }

    public ParkingSpot setMemberId(Member memberId) {
        this.memberId = memberId;
        return this;
    }

    public ParkingSpot setParkingLotId(ParkingLot parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ParkingSpot setLicencePlate(LicencePlate licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public ParkingSpot setStartAllocationDate(LocalDate startAllocationDate) {
        this.startAllocationDate = startAllocationDate;
        return this;
    }
}
