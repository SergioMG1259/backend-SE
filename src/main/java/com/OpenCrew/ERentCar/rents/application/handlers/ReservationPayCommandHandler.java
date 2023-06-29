package com.OpenCrew.ERentCar.rents.application.handlers;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.rents.application.commands.ReservationPayCommand;
import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.rents.domain.repository.RentRepository;
import com.OpenCrew.ERentCar.rents.domain.repository.ReservationRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;

@Service
public class ReservationPayCommandHandler {
    private final ReservationRepository reservationRepository;
    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    public ReservationPayCommandHandler(ReservationRepository reservationRepository, RentRepository rentRepository,CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.rentRepository = rentRepository;
        this.carRepository=carRepository;
    }

    public Rent handle(ReservationPayCommand command,Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFound("RESERVATION",id));
        reservation.setState("PAYED");
        reservationRepository.save(reservation);

        Car car=reservation.getCar();
        car.setState("RENTED");
        carRepository.save(car);

        Rent rent=new Rent();
        rent.setPayDate( new Date());
        rent.setState(command.getState());
        rent.setReservation(reservation);
        rent.setStateScore(false);

        return rentRepository.save(rent);
    }
}
