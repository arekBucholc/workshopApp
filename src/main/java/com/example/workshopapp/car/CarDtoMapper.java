package com.example.workshopapp.car;

import org.springframework.stereotype.Service;

@Service
public class CarDtoMapper {
    CarDto map(Car car){
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setMake(car.getMake());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());
        carDto.setOwnerFirstName(car.getOwnerFirstName());
        carDto.setOwnerLastName(car.getOwnerLastName());
        carDto.setOwnerContactNumber(car.getOwnerContactNumber());
        return carDto;
    }

    Car map(CarDto carDto){
       Car car = new Car();
       car.setId(carDto.getId());
       car.setMake(carDto.getMake());
       car.setModel(carDto.getModel());
       car.setYear(carDto.getYear());
       car.setOwnerFirstName(carDto.getOwnerFirstName());
       car.setOwnerLastName(carDto.getOwnerLastName());
       car.setOwnerContactNumber(carDto.getOwnerContactNumber());
       return car;
    }
}
