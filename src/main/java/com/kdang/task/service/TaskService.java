package com.kdang.task.service;

import com.kdang.task.model.Task;
import com.kdang.task.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // CREATE
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // READ
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    // UPDATE
    public Task updateTask(Integer taskID, Task taskDetails) {
        // Object taskDetails contains NEW task details
        Task task = taskRepository.findById(taskID).get();
        task.setDescription(taskDetails.getDescription());
        task.setName(taskDetails.getName());
        task.setCreateDate(taskDetails.getCreateDate());
        task.setDueDate(taskDetails.getDueDate());
        task.setCompleted(taskDetails.isCompleted());

        return taskRepository.save(task);
    }

    // DELETE
    public void deleteTask(Integer taskID) {
        taskRepository.deleteById(taskID);
    }
}
