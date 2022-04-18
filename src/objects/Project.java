package objects;

import users.Member;
import users.TeamLead;

import java.util.ArrayList;



// Project class defines the project which is going to be handled by the task management system
// The project class is the structure of project objects.

public class Project {
    String projectName;
    TeamLead teamLead;
    ArrayList<Member> projectMembers;
    String deadline;
    String status;
    ArrayList<Task> taskArrayList;
    String projectDescription;

    public Project() {
        this.projectMembers = new ArrayList<>();
        this.taskArrayList = new ArrayList<>();
    }

    public Project(String projectName, TeamLead teamLead, ArrayList<Member> projectMembers, String deadline, String projectDescription) {
        this.projectName = projectName;
        this.teamLead = teamLead;
        this.projectMembers = projectMembers;
        this.deadline = deadline;
        this.status = "Not yet started";
        this.taskArrayList = new ArrayList<>();
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public ArrayList<Member> getProjectMembers() {
        return projectMembers;
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

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

}
