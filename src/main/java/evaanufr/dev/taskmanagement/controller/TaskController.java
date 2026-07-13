package evaanufr.dev.taskmanagement.controller;

import evaanufr.dev.taskmanagement.models.Task;
import evaanufr.dev.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        return taskService.getTaskById(id);
    }
    @GetMapping("/tasks")
    public List<Task> findAllTasks(){
        return taskService.getAllTasks();
    }
}
