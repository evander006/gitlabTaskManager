package evaanufr.dev.taskmanagement.models;

import evaanufr.dev.taskmanagement.enums.TaskPriority;
import evaanufr.dev.taskmanagement.enums.TaskStatus;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private Long creatorId;
    private Long assignedUserId;
    private TaskStatus status;
    private LocalDateTime createDateTime;
    private LocalDateTime deadlineTime;
    private TaskPriority priority;

    public Task(Long id, Long creatorId, Long assignedUserId, TaskStatus status, LocalDateTime createDateTime, LocalDateTime deadlineTime, TaskPriority priority) {
        this.id = id;
        this.creatorId = creatorId;
        this.assignedUserId = assignedUserId;
        this.status = status;
        this.createDateTime = createDateTime;
        this.deadlineTime = deadlineTime;
        this.priority = priority;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", assignedUserId=" + assignedUserId +
                ", status=" + status +
                ", createDateTime=" + createDateTime +
                ", deadlineTime=" + deadlineTime +
                ", priority=" + priority +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}
