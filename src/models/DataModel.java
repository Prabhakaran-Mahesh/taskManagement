package models;

import users.Manager;
import users.TeamLead;
import users.TeamMember;
import users.Tester;

import java.util.ArrayList;

public class DataModel {

    static ArrayList<Manager> managerArrayList = new ArrayList<>();
    static ArrayList<TeamMember> teamMembers = new ArrayList<>();
    static ArrayList<TeamLead> teamLeads = new ArrayList<>();
    static ArrayList<Tester> testers = new ArrayList<>();
    static ArrayList<String> projectStatus = new ArrayList<>();
    static ArrayList<String> priority = new ArrayList<>();
    static ArrayList<String> taskStatus = new ArrayList<>();
    static  ArrayList<String> issueStatus = new ArrayList<>();
    static ArrayList<String> issueSeverity = new ArrayList<>();
    static ArrayList<String> issueClassification = new ArrayList<>();

    static ArrayList<String> memberTaskStatus = new ArrayList<>();
    static ArrayList<String> memberIssueStatus = new ArrayList<>();
    static ArrayList<String> recurringTaskType = new ArrayList<>();

    static public ArrayList<Manager> getManagerArrayList() {
        return managerArrayList;
    }

    static public void setManagerArrayList() {
        managerArrayList.add(new Manager("Prabha", "prabha@gmail.com", "prabha123", "zoho"));
    }

    public static ArrayList<String> getModelProjectStatus() {
        return projectStatus;
    }

    public static void setModelProjectStatus() {
        projectStatus.add("Not yet Started");
        projectStatus.add("Implementation");
        projectStatus.add("Beta version Deployed");
        projectStatus.add("Deployed");
        projectStatus.add("Closed");
    }

    public static ArrayList<String> getPriority() {
        return priority;
    }

    public static void setPriority() {
        priority.add("None");
        priority.add("Low");
        priority.add("Medium");
        priority.add("High");
        priority.add("Very High");
    }

    public static ArrayList<String> getTaskStatus() {
        return taskStatus;
    }

    public static void setTaskStatus() {
        taskStatus.add("Not yet Started");
        taskStatus.add("Requirement Analysis");
        taskStatus.add("Designing");
        taskStatus.add("Implementation");
        taskStatus.add("Optimization");
        taskStatus.add("On hold");
        taskStatus.add("Delayed");
        taskStatus.add("Submitted for test");
        taskStatus.add("Issue Reported");
        taskStatus.add("Completed");
    }

    public static ArrayList<String> getIssueStatus() {
        return issueStatus;
    }

    public static void setIssueStatus() {
        issueStatus.add("Analysis");
        issueStatus.add("Implementation");
        issueStatus.add("Optimization");
        issueStatus.add("Submitted for Test");
        issueStatus.add("Committed");
        issueStatus.add("Delayed");
    }

    public static ArrayList<String> getMemberTaskStatus() {
        return memberTaskStatus;
    }

    public static void setMemberTaskStatus() {
        memberTaskStatus.add("Not yet Started");
        memberTaskStatus.add("Requirement Analysis");
        memberTaskStatus.add("Designing");
        memberTaskStatus.add("Implementation");
        memberTaskStatus.add("Optimization");
        memberTaskStatus.add("Submitted for test");
        memberTaskStatus.add("On hold");
        memberTaskStatus.add("Delayed");
    }

    public static ArrayList<String> getMemberIssueStatus() {
        return memberIssueStatus;
    }

    public static void setMemberIssueStatus() {
        memberIssueStatus.add("Analysis");
        memberIssueStatus.add("Implementation");
        memberIssueStatus.add("On hold");
        memberIssueStatus.add("Delayed");
        memberIssueStatus.add("Submitted for Test");
        memberIssueStatus.add("Issue Reported");
        memberIssueStatus.add("Committed");
    }

    public static ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public static void setTeamMembers() {
        teamMembers.add(new TeamMember("member1", "member1@gmail.com", "member1"));
        teamMembers.add(new TeamMember("member2", "member2@gmail.com", "member2"));
        teamMembers.add(new TeamMember("member3", "member3@gmail.com", "member3"));
        teamMembers.add(new TeamMember("member4", "member4@gmail.com", "member4"));
        teamMembers.add(new TeamMember("member5", "member5@gmail.com", "member5"));
        teamMembers.add(new TeamMember("member6", "member6@gmail.com", "member6"));
        teamMembers.add(new TeamMember("member7", "member7@gmail.com", "member7"));
        teamMembers.add(new TeamMember("member8", "member8@gmail.com", "member8"));
        teamMembers.add(new TeamMember("member9", "member9@gmail.com", "member9"));
        teamMembers.add(new TeamMember("member10", "member10@gmail.com", "member10"));
    }

    public static ArrayList<TeamLead> getTeamLeads() {
        return teamLeads;
    }

    public static void setTeamLeads(ArrayList<TeamLead> teamLeads) {
        DataModel.teamLeads = teamLeads;
    }

    public static ArrayList<Tester> getTesters() {
        return testers;
    }

    public static void setTesters(ArrayList<Tester> testers) {
        DataModel.testers = testers;
    }

    public static ArrayList<String> getRecurringTaskType() {
        return recurringTaskType;
    }

    public static void setRecurringTaskType() {
        recurringTaskType.add("None");
        recurringTaskType.add("Daily");
        recurringTaskType.add("Weekly");
        recurringTaskType.add("BiWeekly");
        recurringTaskType.add("Monthly");
        recurringTaskType.add("Annually");
    }

    public static ArrayList<String> getIssueSeverity() {
        return issueSeverity;
    }

    public static void setIssueSeverity() {
        issueSeverity.add("Critical");
        issueSeverity.add("Major");
        issueSeverity.add("Minor");
    }

    public static ArrayList<String> getIssueClassification() {
        return issueClassification;
    }

    public static void setIssueClassification() {
        issueClassification.add("Security");
        issueClassification.add("Crash/Hang");
        issueClassification.add("Data Loss");
        issueClassification.add("Performance");
        issueClassification.add("UI/Usability");
        issueClassification.add("Enhancement");
        issueClassification.add("Other bugs");
    }
}