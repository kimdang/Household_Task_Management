package com.kdang.task.controller;

import com.kdang.task.model.Task;
import com.kdang.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public Task createTask(@RequestBody Task task) {
        // @RequestBody annotation is used to map the request body to method parameter
        return taskService.createTask(task);
    }

    // READ
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> readTask() {
        return taskService.getTasks();
    }

    // UPDATE
    @RequestMapping(value = "/tasks/{task_id}", method = RequestMethod.PUT)
    public Task updateTask(@PathVariable(value = "task_id") Integer task_id, @RequestBody Task taskDetails) {
        return taskService.updateTask(task_id, taskDetails);
    }

    // DELETE
    @RequestMapping(value = "/tasks/{task_id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable(value = "task_id") Integer task_id) {
        taskService.deleteTask(task_id);
    }


}
