package evaanufr.dev.taskmanagement.services;

import evaanufr.dev.taskmanagement.enums.TaskPriority;
import evaanufr.dev.taskmanagement.enums.TaskStatus;
import evaanufr.dev.taskmanagement.models.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class TaskService {
    private Map<Long, Task> tasksMap=Map.of(
            1L,new Task(1l, 2l,3l, TaskStatus.CREATED, LocalDateTime.now(), LocalDateTime.now().plusDays(5), TaskPriority.HIGH),
            2L,new Task(2l, 2l,3l, TaskStatus.DONE, LocalDateTime.now(), LocalDateTime.now().plusDays(6), TaskPriority.LOW),
            3L,new Task(3l, 2l,6l, TaskStatus.IN_PROGRESS, LocalDateTime.now(), LocalDateTime.now().plusDays(3), TaskPriority.MEDIUM),
            4L,new Task(4l, 2l,5l, TaskStatus.CREATED, LocalDateTime.now(), LocalDateTime.now().plusDays(2), TaskPriority.HIGH)
    );

    public Task getTaskById(Long id){
        if (!tasksMap.containsKey(id)){
            throw new NoSuchElementException("No task with id "+id+" found");
        }else {
            return tasksMap.get(id);
        }
    }
    public List<Task> getAllTasks(){
        return  tasksMap.values().stream().toList();
    }
}
