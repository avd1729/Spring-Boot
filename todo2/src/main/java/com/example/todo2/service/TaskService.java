package com.example.todo2.service;

import com.example.todo2.model.Task;
import com.example.todo2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getTaskByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
