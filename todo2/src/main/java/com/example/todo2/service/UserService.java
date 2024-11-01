package com.example.todo2.service;

import com.example.todo2.model.User;
import com.example.todo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
