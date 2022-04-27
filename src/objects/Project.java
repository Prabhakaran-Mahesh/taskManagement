package objects;

import users.TeamLead;
import users.TeamMember;
import users.Tester;

import java.util.ArrayList;

public class Project {
    String projectId;
    String projectName;
    String projectDescription;
    String deadline;
    String duration;
    String status;
    ArrayList<TeamMember> teamMemberArrayList = new ArrayList<>();
    ArrayList<TeamLead> teamLeadArrayList = new ArrayList<>();
    Tester tester;
    ArrayList<String> chatGroup = new ArrayList<>();
    ArrayList<String> fileManager = new ArrayList<>();
    ArrayList<Task> taskArrayList = new ArrayList<>();
    ArrayList<String> workflow = new ArrayList<>();
    ArrayList<Object> recycleBin = new ArrayList<>();
    ArrayList<String> materials = new ArrayList<>();

    public Project(String projectName, String projectDescription, String deadline) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.deadline = deadline;
        this.status = "Not yet started";
    }

    public Project(String projectName, String projectDescription, String deadline, ArrayList<TeamMember> teamMemberArrayList, ArrayList<TeamLead> teamLeadArrayList, Tester tester) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.deadline = deadline;
        this.status = "Not yet Started";
        this.teamMemberArrayList = teamMemberArrayList;
        this.teamLeadArrayList = teamLeadArrayList;
        this.tester = tester;
    }

    public Project(String projectName, String projectDescription, String deadline, ArrayList<TeamMember> teamMemberArrayList, ArrayList<TeamLead> teamLeadArrayList) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.deadline = deadline;
        this.status = "Not yet Started";
        this.teamMemberArrayList = teamMemberArrayList;
        this.teamLeadArrayList = teamLeadArrayList;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public ArrayList<String> getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(ArrayList<String> chatGroup) {
        this.chatGroup = chatGroup;
    }

    public ArrayList<String> getFileManager() {
        return fileManager;
    }

    public void setFileManager(ArrayList<String> fileManager) {
        this.fileManager = fileManager;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }

    public ArrayList<String> getWorkflow() {
        return workflow;
    }

    public void setWorkflow(ArrayList<String> workflow) {
        this.workflow = workflow;
    }

    public ArrayList<Object> getRecycleBin() {
        return recycleBin;
    }

    public void setRecycleBin(ArrayList<Object> recycleBin) {
        this.recycleBin = recycleBin;
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }
}
