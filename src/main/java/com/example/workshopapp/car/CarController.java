package com.example.workshopapp.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

   public CarController( CarService carService) {
        this.carService = carService;
    }



    @GetMapping("/{id}")
    ResponseEntity<CarDto> getCarById(@PathVariable Long id){
       return carService.getCarById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/tasks")
    ResponseEntity<List<CarTaskDto>> getCarTasks(@PathVariable Long id){
       if (carService.getCarById(id).isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(carService.getTasksByCarId(id));
    }

    @PostMapping
    ResponseEntity<CarDto> saveCar(@RequestBody CarDto car){
       CarDto savedCar = carService.saveCar(car);
       URI savedCarUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(savedCar.getId()).toUri();
       return ResponseEntity.created(savedCarUri).body(savedCar);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceCar(@PathVariable Long id, @RequestBody CarDto carDto){
       return carService.replaceCar(id,carDto).map(c->ResponseEntity.noContent().build())
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCar(@PathVariable Long id){
       carService.deleteCar(id);
       return ResponseEntity.noContent().build();
    }
}
