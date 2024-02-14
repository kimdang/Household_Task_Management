package com.kdang.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kdang.task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // This repository manages model class Task, where primary key is integer
    // JpaRepository interface has save(), findAll(), delete() methods which enable CRUD operations
}
