package objects;

public class Issue extends Task{
    public Issue(String taskName, String description, String deadline, String taskPriority) {
        super(taskName, description, deadline, taskPriority);
        this.issueStatus = "Not yet Started";
    }

    String issueStatus;

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}
