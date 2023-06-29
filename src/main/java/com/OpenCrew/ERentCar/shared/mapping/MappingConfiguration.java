package com.OpenCrew.ERentCar.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OpenCrew.ERentCar.cars.application.mapper.CarMapper;
import com.OpenCrew.ERentCar.cars.application.mapper.LocationMapper;
import com.OpenCrew.ERentCar.rents.application.mapper.RentMapper;
import com.OpenCrew.ERentCar.rents.application.mapper.ReservationMapper;
import com.OpenCrew.ERentCar.scores.application.mapper.ScoreMapper;
import com.OpenCrew.ERentCar.users.application.mapper.UserMapper;

@Configuration
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper(){return new EnhancedModelMapper();}
    @Bean
    public UserMapper userMapper(){return new UserMapper();}
    @Bean
    public CarMapper carMapper(){return new CarMapper();}
    @Bean
    public LocationMapper locationMapper(){return new LocationMapper();}
    @Bean
    public ReservationMapper reservationMapper(){return new ReservationMapper();}
    @Bean
    public RentMapper rentMapper(){return new RentMapper();}
    @Bean
    public ScoreMapper scoreMapper(){return new ScoreMapper();}
}
