package com.OpenCrew.ERentCar.rents.application.handlers;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.rents.application.commands.ReservationUpdateCommand;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.rents.domain.repository.ReservationRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;

@Service
public class ReservationUpdateCommandHandler {
    private final ReservationRepository reservationRepository;

    public ReservationUpdateCommandHandler(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    
    public Reservation handle(ReservationUpdateCommand command,Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFound("RESERVATION",id));

        // Actualizar el estado de la reserva
        reservation.setState(command.getState());

        reservationRepository.save(reservation);
        return reservation;
    }
}
