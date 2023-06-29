package com.OpenCrew.ERentCar.rents.application.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.rents.application.dto.RentClientDTO;
import com.OpenCrew.ERentCar.rents.application.dto.RentOwnerDTO;
import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class RentMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public RentClientDTO toClientDTO(Rent model){
        return mapper.map(model, RentClientDTO.class);
    }
    public List<RentClientDTO> modelListToListClientDTO(List<Rent>modelList){
        return mapper.mapList(modelList, RentClientDTO.class);
    }
    public List<RentOwnerDTO> modelListToListOwnerDTO(List<Rent>modelList){
        return mapper.mapList(modelList, RentOwnerDTO.class);
    }
}
