package com.OpenCrew.ERentCar.rents.infraestructure;

import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.rents.domain.repository.RentRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RentRepositoryImpl extends JpaRepository<Rent,Long>,RentRepository{
    @Query(value="select R.*from rents as R left join reservations RV " +
            "on R.reservation_id=RV.id where RV.client_id=?1 group by R.id,R.pay_date,R.state,R.reservation_id,R.state_score; ", nativeQuery = true)
    List<Rent> findAllRentsByClientId(Long clientId);

    @Query(value="select R.*from rents as R left join reservations RV " +
            "on R.reservation_id=RV.id where RV.owner_id=?1 group by R.id,R.pay_date,R.state,R.reservation_id,R.state_score; ", nativeQuery = true)
    List<Rent> findAllRentsByOwnerId(Long ownerId);
}
