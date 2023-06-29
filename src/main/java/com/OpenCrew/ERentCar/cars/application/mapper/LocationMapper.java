package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.cars.application.dto.LocationDTO;
import com.OpenCrew.ERentCar.cars.domain.entities.Location;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class LocationMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;
    
    public Location toModel(LocationDTO locationDTO){
        return mapper.map(locationDTO, Location.class);
    }
    public List<Location> ListDTOListToModel(List<LocationDTO>ListDTO){
        return mapper.mapList(ListDTO, Location.class);
    }
}
