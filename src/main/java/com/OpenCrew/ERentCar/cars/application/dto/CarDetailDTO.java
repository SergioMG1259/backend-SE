package com.OpenCrew.ERentCar.cars.application.dto;

import java.util.List;

import com.OpenCrew.ERentCar.scores.application.dto.ScoreDTO;
import com.OpenCrew.ERentCar.users.application.dto.UserShortDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDetailDTO {
    private Long id;

    private String brand;

    private String model;

    private String type;

    private int seats;

    private int year;

    private String plateNumber;

    private Double mileage;

    private String fuel;

    private String gearBox;

    private Double pricePerDay;

    private String description;

    private Double score;

    private String state;

    private String image;

    private List<LocationDTO> locations;

    private UserShortDTO user;

    private List<ScoreDTO> scoresCar;
}
