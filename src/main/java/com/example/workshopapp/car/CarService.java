package com.example.workshopapp.car;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarDtoMapper carDtoMapper;
    private final CarTaskDtoMapper carTaskDtoMapper;

    public CarService(CarRepository carRepository,CarDtoMapper carDtoMapper,CarTaskDtoMapper carTaskDtoMapper) {
        this.carRepository = carRepository;
        this.carDtoMapper = carDtoMapper;
        this.carTaskDtoMapper = carTaskDtoMapper;
    }


    List<Car> findAllCars(){
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }



    Optional<CarDto> getCarById(Long id){
        return carRepository.findById(id).map(carDtoMapper::map);
    }
    List<CarTaskDto> getTasksByCarId(Long carId){
        return carRepository.findById(carId).map(Car::getTasks).orElse(Collections.emptyList()).stream()
                .map(carTaskDtoMapper::map).toList();
    }

    CarDto saveCar(CarDto carDto){
        Car car = carDtoMapper.map(carDto);
        Car savedCar = carRepository.save(car);
        return carDtoMapper.map(savedCar);
    }

    Optional<CarDto> replaceCar(Long carId, CarDto carDto){
        if (!carRepository.existsById(carId)){
            return Optional.empty();
        }
        carDto.setId(carId);
        Car carToUpdate = carDtoMapper.map(carDto);
        Car updatedEntity = carRepository.save(carToUpdate);
        return Optional.of(carDtoMapper.map(updatedEntity));
    }

    void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
