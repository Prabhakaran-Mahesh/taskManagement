package objects;

import users.Member;
import users.TeamLead;
import users.Tester;

import java.util.ArrayList;



// Project class defines the project which is going to be handled by the task management system
// The project class is the structure of project objects.
public class Project {
    private String projectName;
    private ArrayList<TeamLead> teamLead;
    private Tester tester;
    private ArrayList<Member> projectMembers;
    private String deadline;
    private String status;
    private ArrayList<Task> taskArrayList;
    private String projectDescription;

    public ArrayList<String> chatBox;

    public Project() {
        this.projectMembers = new ArrayList<>();
        this.taskArrayList = new ArrayList<>();

        chatBox = new ArrayList<>();
    }

    public Project(String projectName, ArrayList<TeamLead> teamLead, Tester tester, ArrayList<Member> projectMembers, String deadline, String projectDescription) {
        this.projectName = projectName;
        this.teamLead = teamLead;
        this.projectMembers = projectMembers;
        this.deadline = deadline;
        this.status = "Not yet started";
        this.taskArrayList = new ArrayList<>();
        this.projectDescription = projectDescription;
        this.tester = tester;

        chatBox = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ArrayList<Member> getProjectMembers() {
        return projectMembers;
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

    public ArrayList<String> getChatBox() {
        return chatBox;
    }

    public void setChatBox(ArrayList<String> chatBox) {
        this.chatBox = chatBox;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }
}
