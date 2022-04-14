package users;

import activities.Login;
import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    String name;
    String email;
    String password;

    ArrayList<Task> assignedTasks = new ArrayList<>();

    public Member() {
    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(ArrayList<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public void exitVerification(Scanner keyboard){
        String exit;
        while(true){
            System.out.print("\t\tAre you sure, Do you want to exit? yes/no : ");
            exit = keyboard.next();
            if(exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("no")){
                break;
            }
            else{
                System.out.println("\n\t\tInvalidInput\n");
                Ui.printLine();
                System.out.println("\n");
            }
        }

        if("yes".equalsIgnoreCase(exit)){
            //Todo: report sending
            //sendReport();
            System.out.println();
            Ui.printLine();
            LoginSignUpPage.loginDisplay(keyboard);
            System.exit(0);

        }
        else{
            System.out.println();
            Ui.printLine();

        }
    }

    public void changePassword(Scanner keyboard) {
        String oldPassword, newPassword;
        System.out.println();
        Ui.printLine();
        System.out.println("\t\tPassword Change");
        System.out.print("\t\t\tEnter your Current Password : ");
        oldPassword = keyboard.next();
        if(password.equals(oldPassword)){
            System.out.print("\t\t\tEnter your New Password : ");
            //newPassword = String.valueOf(console.readPassword());;
            newPassword = keyboard.next();

            setPassword(newPassword);
            System.out.println("\t\tPassword Altered");
            Ui.printLine();
        }
        else{
            System.out.println("\t\tOld Password Incorrect");
            Ui.printLine();
        }
    }

    public void viewAssignedTasks(Scanner scanner){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tView the Project tasks");
        System.out.println();

        if(assignedTasks.size() == 0){
            System.out.println("\t\t\tNo task is assigned to you yet!");
        }
        else {
            int i = 0;
            for (Task task : assignedTasks) {
                i++;
                System.out.printf("\n\t\t%15s d%15s %15s %25s %25s\n", "S.no", "TaskName", "Deadline", "Status", "Description");
                System.out.printf("\t\t%15s %15s %15s %25s %25s\n", i, task.getTaskName(), task.getDeadline(), task.getStatus(), task.getTaskDescription());
            }
        }
        System.out.println();
        Ui.printLine();
    }

    public void updateTaskStatus(Scanner scanner){

        viewAssignedTasks(scanner);

        int choice;
        while(true){
            System.out.print("\t\tEnter the s.no : ");
            choice = Validations.numberCheck(scanner);
            if(choice != -1 && (choice>0 && choice<=assignedTasks.size())){
                break;
            }
        }

        Task selectedTask = assignedTasks.get(choice-1);
        System.out.println("\t\t"+selectedTask.getTaskName()+"\n");

        System.out.println("\t\tStatus list : ");
        int i=0;
        for(String status : Models.getStatus()){
            i++;
            System.out.println("\t\t\t"+i+". "+ status);
        }
        while(true){
            System.out.print("\t\tPick a status using S.no of the task to update: ");
            choice = Validations.numberCheck(scanner);
            if(choice != -1 && (choice>0 && choice<=Models.getStatus().size())){
                break;
            }
        }

        selectedTask.setStatus(Models.getStatus().get(choice-1));
        System.out.println("\n\t\tTask Status Updated");

        System.out.println();
        Ui.printLine();
    }

    public void workOfMember(Scanner scanner){
        int adminChoice;
        System.out.println("\n\t\tWelcome back " + name.toUpperCase());

        boolean check = true;
        while(check){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to view Tasks Assigned");
            System.out.println("\t\t\t Enter 2 to Update task status");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            System.out.print("\t\t\t Enter your Choice : ");
            adminChoice = scanner.nextInt();

            switch (adminChoice){

                case -1 : {
                    this.exitVerification(scanner);
                    continue;
                }

                case 0 : {
                    this.changePassword(scanner);
                    break;
                }

                case 1 : {
                    this.viewAssignedTasks(scanner);
                    break;
                }

                case 2 : {
                   this.updateTaskStatus(scanner);
                   break;
                }
            }

        }
    }
}