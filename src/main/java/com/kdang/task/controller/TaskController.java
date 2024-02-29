package com.kdang.task.controller;

import com.kdang.task.model.Task;
import com.kdang.task.model.TaskSpecification;
import com.kdang.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> readTasks() {
        return taskService.getTasks();
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

//    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Task> search(@RequestParam(value = "search") String search) {
//        TaskSpecification builder = new TaskSpecification();
//        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
//        Matcher matcher = pattern.matcher(search + ",");
//        while (matcher.find()) {
//            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
//        }
//    }
}
