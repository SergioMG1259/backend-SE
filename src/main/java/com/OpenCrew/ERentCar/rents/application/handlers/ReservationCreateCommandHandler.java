package com.OpenCrew.ERentCar.rents.application.handlers;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.rents.application.commands.ReservationCreateCommand;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.rents.domain.repository.ReservationRepository;
import com.OpenCrew.ERentCar.users.domain.entities.User;

@Service
public class ReservationCreateCommandHandler {
    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public ReservationCreateCommandHandler(ReservationRepository reservationRepository,CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository=carRepository;
    }

    public Reservation handle(ReservationCreateCommand command, User owner, User client, Car car){
        Reservation reservation=new Reservation();
        reservation.setReserveDate(command.getReserveDate());
        reservation.setReturnDate(command.getReturnDate());
        reservation.setAmount(command.getAmount());
        reservation.setLocation(command.getLocation());
        reservation.setOwner(owner);
        reservation.setClient(client);
        reservation.setState("WAITING");
        car.setState("RESERVATED");
        reservation.setCar(car);
        this.carRepository.save(car);

        return this.reservationRepository.save(reservation);
    }
}
