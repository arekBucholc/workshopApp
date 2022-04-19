package com.example.workshopapp.car;

import com.example.workshopapp.task.Task;
import org.springframework.stereotype.Service;

@Service
public class CarTaskDtoMapper {
    CarTaskDto map(Task task){
        CarTaskDto dto = new CarTaskDto();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setCost(task.getCost());
        dto.setCarMake(task.getCar().getMake());
        dto.setCarModel(task.getCar().getModel());

        return dto;
    }
}
