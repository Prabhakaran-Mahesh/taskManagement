package objects;

import java.util.ArrayList;

public class Task {
    String taskName;
    String description;
    String deadline;
    String taskStatus;
    String taskPriority;

    ArrayList<String> comments = new ArrayList<>();

    public Task(String taskName, String description, String deadline, String taskPriority) {
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.taskPriority = taskPriority;
        this.taskStatus = "Not yet Started";
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }
}
