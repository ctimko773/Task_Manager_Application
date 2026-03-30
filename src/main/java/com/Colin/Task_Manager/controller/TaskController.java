package com.Colin.Task_Manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Colin.Task_Manager.service.TaskService;
import com.Colin.Task_Manager.model.Task;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") 

public class TaskController {
    
    
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        taskService.createTask(task);

        return task; // Placeholder return statement
    }

    
}