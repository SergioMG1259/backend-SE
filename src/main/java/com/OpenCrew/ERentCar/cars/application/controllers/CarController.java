package com.OpenCrew.ERentCar.cars.application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.dto.CarDetailDTO;
import com.OpenCrew.ERentCar.cars.application.mapper.CarMapper;
import com.OpenCrew.ERentCar.cars.application.requests.CreateCar;
import com.OpenCrew.ERentCar.cars.domain.services.CarService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }
    @GetMapping()
    public List<CarDTO>getAllCars(){
        return carMapper.modelListToListDTO(this.carService.getAll());
    }
    
    @GetMapping("/my-cars/{ownerId}")
    public List<CarDTO> getCarByUserId(@PathVariable Long ownerId){
        return carMapper.modelListToListDTO(this.carService.getByUserId(ownerId));
    }
    @PostMapping("register/owner/{ownerId}")
    public ResponseEntity<CarDTO> registerCar(@PathVariable("ownerId")Long ownerId,@Valid @RequestBody CreateCar request){
        CarDTO carDTO= carMapper.toDTO(this.carService.registerCar(request,ownerId));
        return ResponseEntity.ok(carDTO);
    }
    @GetMapping("/car-detail/{carId}")
    public ResponseEntity<CarDetailDTO> getCarDetailById(@PathVariable Long carId){
        CarDetailDTO carDetailsDTO=carMapper.toDetail(this.carService.getById(carId));
        return ResponseEntity.ok(carDetailsDTO);
    }
}
