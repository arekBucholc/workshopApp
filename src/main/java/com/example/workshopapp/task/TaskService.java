package com.example.workshopapp.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;

   public TaskService( TaskRepository taskRepository,  TaskDtoMapper taskDtoMapper) {
        this.taskRepository = taskRepository;
        this.taskDtoMapper = taskDtoMapper;
    }

    Optional<TaskDto> getTaskById(Long id){
       return taskRepository.findById(id).map(taskDtoMapper::map);
    }

    TaskDto saveTask(TaskDto taskDto){
       Task taskToSave = taskDtoMapper.map(taskDto);
       Task savedTask = taskRepository.save(taskToSave);
       return taskDtoMapper.map(savedTask);
    }

    @Transactional
    public Optional<TaskDto> updateTask(Long id, TaskDto taskDto){
       return taskRepository.findById(id).map(target-> setEntityFields(taskDto,target)).map(taskDtoMapper::map);
    }

    public void deleteTask(Long id){
       taskRepository.deleteById(id);
    }

    private Task setEntityFields(TaskDto source, Task target){
       if (source.getDescription()!=null){
           target.setDescription(source.getDescription());
       }
       if (source.getStartDate()!=null){
           target.setStartDate(source.getStartDate());
       }
       if (source.getCost()!=null){
           target.setCost(source.getCost());
       }
      return target;
    }
}
