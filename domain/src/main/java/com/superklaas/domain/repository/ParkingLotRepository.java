package com.superklaas.domain.repository;


import com.superklaas.domain.models.parking_lot.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer> {

}
