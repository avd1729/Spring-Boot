package com.example.todo2.controller;

import com.example.todo2.model.Task;
import com.example.todo2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("tasks/{userId}")
    public ResponseEntity<List<Task>> getTaskByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(service.getTaskByUser(userId), HttpStatus.OK);
    }
}
