package com.OpenCrew.ERentCar.cars.application.mapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailDTO;
import com.OpenCrew.ERentCar.cars.application.requests.CreateCar;
import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;

public class CarMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public CarDTO toDTO(Car model){
        return mapper.map(model, CarDTO.class);
    }
    public Car toModel(CreateCar createCar){
        return mapper.map(createCar, Car.class);
    }
    public List<CarDTO> modelListToListDTO(List<Car>modelList){
        return mapper.mapList(modelList, CarDTO.class);
    }
    public CarDetailDTO toDetail(Car model){
        return mapper.map(model, CarDetailDTO.class);
    }
}
