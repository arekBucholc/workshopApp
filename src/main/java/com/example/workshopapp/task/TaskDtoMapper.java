package com.example.workshopapp.task;

import com.example.workshopapp.car.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskDtoMapper {
    private final CarRepository carRepository;

    public TaskDtoMapper( CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    TaskDto map(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setCost(task.getCost());
        taskDto.setCarId(task.getCar().getId());
        taskDto.setCarMake(task.getCar().getMake());
        taskDto.setCarModel(task.getCar().getModel());

        return taskDto;
    }

   Task map(TaskDto taskDto){
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setStartDate(taskDto.getStartDate());
        task.setCost(taskDto.getCost());
        carRepository.findById(taskDto.getCarId()).ifPresent(task::setCar);

        return task;
   }
}
