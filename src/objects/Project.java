package objects;

import users.TeamLead;
import users.TeamMember;
import users.Tester;

import java.util.ArrayList;

public class Project {
    String projectName;
    String description;
    String deadline;

    ArrayList<String> chatBox = new ArrayList<>();
    ArrayList<String> fileFolder = new ArrayList<>();
    String projectStatus;
    ArrayList<String> workflow = new ArrayList<>();
    ArrayList<Task> taskArrayList = new ArrayList<>();
    ArrayList<Issue> issueArrayList = new ArrayList<>();
    ArrayList<TeamMember> teamMemberArrayList = new ArrayList<>();
    ArrayList<TeamLead> teamLeadArrayList = new ArrayList<>();
    ArrayList<Task> progressArrayList = new ArrayList<>();
    Tester tester;

    public Project(String projectName, String description, String deadline) {
        this.projectName = projectName;
        this.description = description;
        this.deadline = deadline;
        this.projectStatus = "Not yet Started";
    }

    public Project(String projectName, String description, String deadline, ArrayList<TeamMember> teamMemberArrayList, ArrayList<TeamLead> teamLeadArrayList) {
        this.projectName = projectName;
        this.description = description;
        this.deadline = deadline;
        this.teamMemberArrayList = teamMemberArrayList;
        this.teamLeadArrayList = teamLeadArrayList;
        this.projectStatus = "Not yet Started";
    }

    public Project(String projectName, String description, String deadline, ArrayList<TeamMember> teamMemberArrayList, ArrayList<TeamLead> teamLeadArrayList, Tester tester) {
        this.projectName = projectName;
        this.description = description;
        this.deadline = deadline;
        this.projectStatus = "Not yet Started";
        this.teamMemberArrayList = teamMemberArrayList;
        this.teamLeadArrayList = teamLeadArrayList;
        this.tester = tester;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public ArrayList<String> getChatBox() {
        return chatBox;
    }

    public void setChatBox(ArrayList<String> chatBox) {
        this.chatBox = chatBox;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public ArrayList<String> getWorkflow() {
        return workflow;
    }

    public void setWorkflow(ArrayList<String> workflow) {
        this.workflow = workflow;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public ArrayList<Issue> getIssueArrayList() {
        return issueArrayList;
    }

    public void setIssueArrayList(ArrayList<Issue> issueArrayList) {
        this.issueArrayList = issueArrayList;
    }

    public ArrayList<TeamMember> getTeamMemberArrayList() {
        return teamMemberArrayList;
    }

    public void setTeamMemberArrayList(ArrayList<TeamMember> teamMemberArrayList) {
        this.teamMemberArrayList = teamMemberArrayList;
    }

    public ArrayList<TeamLead> getTeamLeadArrayList() {
        return teamLeadArrayList;
    }

    public void setTeamLeadArrayList(ArrayList<TeamLead> teamLeadArrayList) {
        this.teamLeadArrayList = teamLeadArrayList;
    }

    public ArrayList<String> getFileFolder() {
        return fileFolder;
    }

    public void setFileFolder(ArrayList<String> fileFolder) {
        this.fileFolder = fileFolder;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public ArrayList<Task> getProgressArrayList() {
        return progressArrayList;
    }

    public void setProgressArrayList(ArrayList<Task> progressArrayList) {
        this.progressArrayList = progressArrayList;
    }
}
