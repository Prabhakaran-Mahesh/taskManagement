package objects;

import users.Member;
import users.TeamLead;

import java.util.ArrayList;

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

    public Project(String projectName, String deadline, String status, String projectDescription) {
        this.projectName = projectName;
        this.deadline = deadline;
        this.status = status;
        this.projectMembers = new ArrayList<>();
        this.taskArrayList = new ArrayList<>();
        this.projectDescription = projectDescription;
    }

    public Project(String projectName, TeamLead teamLead, String deadline, String status, String projectDescription) {
        this.projectName = projectName;
        this.teamLead = teamLead;
        this.deadline = deadline;
        this.status = status;
        this.projectMembers = new ArrayList<>();
        this.taskArrayList = new ArrayList<>();
        this.projectDescription = projectDescription;
    }

    public Project(String projectName, TeamLead teamLead, ArrayList<Member> projectMembers, String deadline, String status, String projectDescription) {
        this.projectName = projectName;
        this.teamLead = teamLead;
        this.projectMembers = projectMembers;
        this.deadline = deadline;
        this.status = status;
        this.taskArrayList = new ArrayList<>();
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }

    public ArrayList<Member> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(ArrayList<Member> projectMembers) {
        this.projectMembers = projectMembers;
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

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
