package com.OpenCrew.ERentCar.rents.application.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.rents.application.dto.ReservationClientDTO;
import com.OpenCrew.ERentCar.rents.application.dto.ReservationDTO;
import com.OpenCrew.ERentCar.rents.application.dto.ReservationOwnerDTO;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class ReservationMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public ReservationClientDTO toClientDTO(Reservation model){
        return mapper.map(model, ReservationClientDTO.class);
    }
    public ReservationOwnerDTO toOwnerDTO(Reservation model){
        return mapper.map(model, ReservationOwnerDTO.class);
    }
    public ReservationDTO toDTO(Reservation model){
        return mapper.map(model, ReservationDTO.class);
    }
    public List<ReservationClientDTO> modelListToListClientDTO(List<Reservation>modelList){
        return mapper.mapList(modelList, ReservationClientDTO.class);
    }
    public List<ReservationOwnerDTO> modelListToListOwnerDTO(List<Reservation>modelList){
        return mapper.mapList(modelList, ReservationOwnerDTO.class);
    }
}
