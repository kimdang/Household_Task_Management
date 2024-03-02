package com.kdang.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.kdang.task.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    // This repository manages model class Task, where primary key is long
    // JpaRepository interface has save(), findAll(), delete() methods which enable CRUD operations

}
