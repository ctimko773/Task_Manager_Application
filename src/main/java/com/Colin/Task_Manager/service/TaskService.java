package com.Colin.Task_Manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Colin.Task_Manager.model.Task;
import com.Colin.Task_Manager.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task createTask(Task task) {
        boolean exists = repo.findByTaskName(task.getTaskName()).stream()
            .anyMatch(existingTask -> existingTask.getDescription().equals(task.getDescription()));
        if (!exists) {
            repo.save(task);
        }
        return task;
    }
}
