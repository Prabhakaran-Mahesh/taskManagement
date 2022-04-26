package objects;

import java.util.ArrayList;

public class RecurringTask {
    String recurringTaskName;
    String recurringTaskDescription;
    String recurringTaskPriority;
    String recurringTaskDeadline;
    String recurringTaskType;

    public RecurringTask(String recurringTaskName, String recurringTaskDescription, String recurringTaskPriority, String recurringTaskType) {
        this.recurringTaskName = recurringTaskName;
        this.recurringTaskDescription = recurringTaskDescription;
        this.recurringTaskPriority = recurringTaskPriority;
        this.recurringTaskType = recurringTaskType;
    }

    public String getRecurringTaskName() {
        return recurringTaskName;
    }

    public void setRecurringTaskName(String recurringTaskName) {
        this.recurringTaskName = recurringTaskName;
    }

    public String getRecurringTaskDescription() {
        return recurringTaskDescription;
    }

    public void setRecurringTaskDescription(String recurringTaskDescription) {
        this.recurringTaskDescription = recurringTaskDescription;
    }

    public String getRecurringTaskPriority() {
        return recurringTaskPriority;
    }

    public void setRecurringTaskPriority(String recurringTaskPriority) {
        this.recurringTaskPriority = recurringTaskPriority;
    }

    public String getRecurringTaskDeadline() {
        return recurringTaskDeadline;
    }

    public void setRecurringTaskDeadline(String recurringTaskDeadline) {
        this.recurringTaskDeadline = recurringTaskDeadline;
    }

    public String getRecurringTaskType() {
        return recurringTaskType;
    }

    public void setRecurringTaskType(String recurringTaskType) {
        this.recurringTaskType = recurringTaskType;
    }
}
