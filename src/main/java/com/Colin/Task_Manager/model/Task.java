package com.Colin.Task_Manager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    @Id
    private String taskId;
    private String taskName;
    private String description;

    public Task(String taskId, String taskName, String description) {

        
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 50)
            throw new IllegalArgumentException("Invalid task name");
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 500)
            throw new IllegalArgumentException("Invalid description");
        this.description = description;
    }
}
