package com.OpenCrew.ERentCar.rents.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.rents.application.commands.RentUpdateCommand;
import com.OpenCrew.ERentCar.rents.application.commands.ReservationPayCommand;
import com.OpenCrew.ERentCar.rents.application.handlers.RentUpdateCommandHandler;
import com.OpenCrew.ERentCar.rents.application.handlers.ReservationPayCommandHandler;
import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.rents.domain.repository.RentRepository;
import com.OpenCrew.ERentCar.rents.domain.services.RentService;

@Service
public class RentServiceImpl implements RentService{
    private final ReservationPayCommandHandler reservationPayCommandHandler;
    private final RentUpdateCommandHandler rentUpdateCommandHandler;
    private final RentRepository rentRepository;
    public RentServiceImpl(ReservationPayCommandHandler reservationPayCommandHandler, RentRepository rentRepository,RentUpdateCommandHandler rentUpdateCommandHandler) {
        this.reservationPayCommandHandler = reservationPayCommandHandler;
        this.rentUpdateCommandHandler=rentUpdateCommandHandler;
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Rent> getByClientId(Long clientId) {
        return this.rentRepository.findAllRentsByClientId(clientId);
    }

    @Override
    public List<Rent> getByOwnerId(Long ownerId) {
        return this.rentRepository.findAllRentsByOwnerId(ownerId);
    }

    @Override
    public Rent registerRent(Long id) {
        ReservationPayCommand reservationPayCommand=new ReservationPayCommand("IN PROGRESS");
        return this.reservationPayCommandHandler.handle(reservationPayCommand,id);
    }

    @Override
    public Rent endRent(Long id) {
        RentUpdateCommand rentUpdateCommand=new RentUpdateCommand("FINALIZED");
        return this.rentUpdateCommandHandler.handle(rentUpdateCommand, id);
    }
}