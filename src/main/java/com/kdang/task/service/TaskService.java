package com.kdang.task.service;

import com.kdang.task.model.Task;
import com.kdang.task.repository.TaskRepository;
import com.kdang.task.repository.TaskSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.kdang.task.repository.TaskSpecs.hasName;

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
    public Task updateTask(Long taskID, Task taskDetails) {
        // Object taskDetails contains NEW task details
        Task task = taskRepository.findById(taskID).get();
        task.setDescription(taskDetails.getDescription());
        task.setName(taskDetails.getName());
        task.setCreateDate(taskDetails.getCreateDate());
        task.setDueDate(taskDetails.getDueDate());
        task.setCompleted(taskDetails.isCompleted());
        task.setAssignedTo(taskDetails.getAssignedTo());
        task.setCreateBy(taskDetails.getCreateBy());

        return taskRepository.save(task);
    }

    // DELETE
    public void deleteTask(Long taskID) {
        taskRepository.deleteById(taskID);
    }

    // SEARCH
    public List<Task> searchByName(String name) {
        Specification<Task> spec = Specification.where(null);
        if (name != null) {
            spec = TaskSpecs.hasName(name);
        }
        return taskRepository.findAll(spec);
    }
}
