package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.parking_spot.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Integer> {

}
