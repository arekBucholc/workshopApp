package com.example.workshopapp.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto){
        TaskDto savedTask = taskService.saveTask(taskDto);
        URI savedTaskUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(savedTaskUri).body(savedTask);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto){
        return taskService.updateTask(id,taskDto).map(task -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
