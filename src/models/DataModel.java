package models;

import users.Manager;

import java.util.ArrayList;

public class DataModel {

    static ArrayList<Manager> managerArrayList = new ArrayList<>();
    static ArrayList<String> projectStatus = new ArrayList<>();
    static ArrayList<String> priority = new ArrayList<>();
    static ArrayList<String> taskStatus = new ArrayList<>();
    static ArrayList<String> issueStatus = new ArrayList<>();

    static ArrayList<String> memberTaskStatus = new ArrayList<>();
    static ArrayList<String> memberIssueStatus = new ArrayList<>();

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
        projectStatus.add("On Hold");
    }

    public static ArrayList<String> getPriority() {
        return priority;
    }

    public static void setPriority() {
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
        taskStatus.add("Submitted for test");
        taskStatus.add("Issue Reported");
        taskStatus.add("Completed");
        taskStatus.add("On hold");
        taskStatus.add("Delayed");
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
        memberIssueStatus.add("Optimization");
        memberIssueStatus.add("Submitted for Test");
        memberIssueStatus.add("Delayed");
    }
}