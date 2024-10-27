package com.superklaas.domain.repository;

import com.superklaas.domain.models.parking_spot.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Integer> {

}
