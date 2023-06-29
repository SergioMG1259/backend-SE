package com.OpenCrew.ERentCar.rents.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.rents.domain.repository.ReservationRepository;

@Repository
public interface ReservationRepositoryImpl extends JpaRepository<Reservation,Long>,ReservationRepository{
    
}
