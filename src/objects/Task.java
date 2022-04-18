package objects;


//Task class is the important class of the projecy
// the task class is the blue print of all task objects that makes up a project

public class Task {
    String taskName;
    String deadline;
    String status;
    String taskDescription;
    String priority;

    public Task(String taskName, String deadline, String taskDescription, String priority) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.status = "Not yet Started";
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getPriority() {
        return priority;
    }

}
