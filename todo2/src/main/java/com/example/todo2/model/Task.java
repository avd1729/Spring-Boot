package com.example.todo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int priority;
    private boolean completionStatus;

    @ManyToOne(fetch = FetchType.LAZY) // A task belongs to one user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key
    private User user;

}