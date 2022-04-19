package users;

import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    String teamName;
    String teamEmail;
    String teamPassword;
    ArrayList<Task> tasksAssignedForTesting = new ArrayList<>();

    public Tester() {
    }

    public Tester(String teamName, String teamEmail, String teamPassword) {
        this.teamName = teamName;
        this.teamEmail = teamEmail;
        this.teamPassword = teamPassword;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Task> getTasksAssignedForTesting() {
        return tasksAssignedForTesting;
    }

    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    public String getTeamEmail() {
        return teamEmail;
    }

    public void TestTasks(){
        return;
    }

    public void workOfTestingTeam(Scanner scanner){

    }
}
