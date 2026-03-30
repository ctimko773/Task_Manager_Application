package com.Colin.Task_Manager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Colin.Task_Manager.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByTaskName(String name);
}