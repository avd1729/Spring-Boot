package com.example.todo2.service;

import com.example.todo2.dto.TaskRequest;
import com.example.todo2.model.Task;
import com.example.todo2.model.User;
import com.example.todo2.repository.TaskRepository;
import com.example.todo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> getTaskByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public Task createTask(TaskRequest taskRequest) {
        // Retrieve the user using userId from the TaskRequest
        User user = userRepository.findById(taskRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + taskRequest.getUserId()));

        // Create a new Task and set fields
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        task.setCompletionStatus(taskRequest.isCompletionStatus());
        task.setUser(user); // Set the User object

        return repository.save(task); // Save the task
    }


}
