package objects;

import java.util.ArrayList;

public class Task {
    String taskName;
    String deadline;
    String status;
    String taskPriority;
    String taskDescription;

    public Task() {
    }

    public Task(String taskName, String deadline, String status, String taskPriority, String taskDescription) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = status;
        this.taskPriority = taskPriority;
        this.taskDescription = taskDescription;
    }

    public Task(String taskName, String deadline, String status, String taskDescription) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = status;
        this.taskDescription = taskDescription;
    }

    public Task(String taskName, String deadline, String taskDescription) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.status = "Not yet Started";
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
