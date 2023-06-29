package com.OpenCrew.ERentCar.rents.application.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.rents.application.commands.ReservationCreateCommand;
import com.OpenCrew.ERentCar.rents.application.commands.ReservationUpdateCommand;
import com.OpenCrew.ERentCar.rents.application.handlers.ReservationCreateCommandHandler;
import com.OpenCrew.ERentCar.rents.application.handlers.ReservationUpdateCommandHandler;
import com.OpenCrew.ERentCar.rents.application.requests.CreateReservation;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.rents.domain.repository.ReservationRepository;
import com.OpenCrew.ERentCar.rents.domain.services.ReservationService;
import com.OpenCrew.ERentCar.shared.exception.BadRequestException;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationCreateCommandHandler reservationCreateCommandHandler;
    private final ReservationUpdateCommandHandler reservationUpdateCommandHandler;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;
    private final Validator validator;
    public ReservationServiceImpl(ReservationCreateCommandHandler reservationCreateCommandHandler,
            Validator validator,UserRepository userRepository,CarRepository carRepository,
            ReservationRepository reservationRepository,ReservationUpdateCommandHandler reservationUpdateCommandHandler) {
        this.reservationCreateCommandHandler = reservationCreateCommandHandler;
        this.userRepository=userRepository;
        this.carRepository=carRepository;
        this.reservationRepository=reservationRepository;
        this.reservationUpdateCommandHandler=reservationUpdateCommandHandler;
        this.validator = validator;
    }
    @Override
    public Reservation getById(Long id) {
        return this.reservationRepository.findById(id).orElseThrow(()->new ResourceNotFound("RESERVATION",id));
    }
    @Override
    public Reservation registerReservation(CreateReservation reservation, Long ownerId, Long carId, Long clientId) {
        Set<ConstraintViolation<CreateReservation>>violations=validator.validate(reservation);
        if(!violations.isEmpty()){
            throw new BadRequestException("RESERVATION",violations);
        }
        User owner=this.userRepository.findById(ownerId).orElseThrow(()->new ResourceNotFound("USER",ownerId));
        User client=this.userRepository.findById(clientId).orElseThrow(()->new ResourceNotFound("USER",ownerId));
        Car car=this.carRepository.findById(carId).orElseThrow(()->new ResourceNotFound("CAR",ownerId));

        ReservationCreateCommand reservationCreateCommand= new ReservationCreateCommand(
            reservation.getReserveDate(),reservation.getReturnDate(),reservation.getAmount(),reservation.getLocation()
        );

        return this.reservationCreateCommandHandler.handle(reservationCreateCommand, owner,client,car);
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    @Override
    public List<Reservation> getByClientId(Long clientId) {
        return this.reservationRepository.findAllReservationsByClientId(clientId);
    }
    @Override
    public List<Reservation> getByOwnerId(Long ownerId) {
        return this.reservationRepository.findAllReservationsByOwnerId(ownerId);
    }
    @Override
    public Reservation acceptReservation(Long reservationId) {
        ReservationUpdateCommand reservationUpdateCommand=new ReservationUpdateCommand("ACCEPTED");
        return this.reservationUpdateCommandHandler.handle(reservationUpdateCommand, reservationId);
    }
    @Override
    public Reservation declineReservation(Long reservationId) {
       ReservationUpdateCommand reservationUpdateCommand=new ReservationUpdateCommand("DECLINED");
        return this.reservationUpdateCommandHandler.handle(reservationUpdateCommand, reservationId);
    }
    
    
}
