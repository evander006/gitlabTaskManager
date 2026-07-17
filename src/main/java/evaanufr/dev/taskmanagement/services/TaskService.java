package evaanufr.dev.taskmanagement.services;

import evaanufr.dev.taskmanagement.enums.TaskStatus;
import evaanufr.dev.taskmanagement.models.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final Map<Long, Task> tasksMap;
    private final AtomicLong idCounter;

    public TaskService() {
        idCounter = new AtomicLong();
        tasksMap = new HashMap<>();
    }

    public Task getTaskById(Long id) {
        if (!tasksMap.containsKey(id)) {
            throw new NoSuchElementException("No task with id " + id + " found");
        } else {
            return tasksMap.get(id);
        }
    }

    public List<Task> getAllTasks() {
        if (tasksMap.isEmpty()) {
            throw new NoSuchElementException("No tasks created yet");
        }
        return tasksMap.values().stream().toList();
    }

    public Task createTask(Task task) {
        if (task.getId()!=null){
            throw new IllegalArgumentException("Id field must be empty when first creating");
        }
        if (task.getStatus()!=null){
            throw new IllegalArgumentException("Id status must be empty when first creating");
        }
        var newTask = new Task(idCounter.getAndIncrement(), task.getCreatorId(), task.getAssignedUserId(), TaskStatus.CREATED, task.getCreateDateTime(), task.getDeadlineTime(), task.getPriority());
        tasksMap.put(newTask.getId(), newTask);
        return newTask;
    }

    public Task updateTask(Long id, Task taskToUpdate) {
        if (!tasksMap.containsKey(id)){
            throw new NoSuchElementException("No such task with id="+id+" found");
        }
        var task=tasksMap.get(id);
        if (task.getStatus().equals(TaskStatus.DONE)){
            throw new NoSuchElementException("Cannot modify task id= "+id+" with status= " + taskToUpdate.getStatus());
        }
        var updatedTask=new Task(task.getId(), taskToUpdate.getCreatorId(), taskToUpdate.getAssignedUserId(), taskToUpdate.getStatus(), taskToUpdate.getCreateDateTime(), taskToUpdate.getDeadlineTime(), taskToUpdate.getPriority());
        tasksMap.put(task.getId(), updatedTask);
        return updatedTask;
    }

    public boolean deleteTask(Long id) {
        if (!tasksMap.containsKey(id)){
            return false;
        }
        var taskToDelete = tasksMap.get(id);
        tasksMap.remove(id);
        return true;
    }
}
