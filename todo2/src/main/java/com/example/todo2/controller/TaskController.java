package com.example.todo2.controller;

import com.example.todo2.dto.TaskRequest;
import com.example.todo2.model.Task;
import com.example.todo2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<Task>> getTaskByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(service.getTaskByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest task) {
        return new ResponseEntity<>(service.createTask(task), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody TaskRequest task) {
        Task task1 = service.updateTaskById(id , task);
        if (task1 != null) {
            return new ResponseEntity<>(task1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        if(task != null) {
            service.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
