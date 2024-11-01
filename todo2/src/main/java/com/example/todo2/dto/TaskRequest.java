package com.example.todo2.dto;

import lombok.Data;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private int priority;
    private boolean completionStatus;
    private Long userId;
}
