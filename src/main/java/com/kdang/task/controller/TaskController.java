package com.kdang.task.controller;

import com.kdang.task.model.Task;
import com.kdang.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
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
    // Provide optional parameter 'name' for filtering
    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public List<Task> searchByName(@RequestParam(required = false, value = "name") String name) {
        if (name == null) {
            return taskService.getTasks();
        } else {
            return taskService.searchByName(name);
        }
    }

    // UPDATE
    @RequestMapping(value = "/tasks/{taskID}", method = RequestMethod.PUT)
    public Task updateTask(@PathVariable(value = "taskID") Long taskID,
                           @RequestBody Task taskDetails) {
        return taskService.updateTask(taskID, taskDetails);
    }

    // DELETE
    @RequestMapping(value = "/tasks/{taskID}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable(value = "taskID") Long taskID) {
        taskService.deleteTask(taskID);
    }



}
