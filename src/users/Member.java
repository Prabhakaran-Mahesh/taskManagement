package users;

import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

/*
// Member function is the parent class of all the user types in this project
// this contains all credentials anf functions of the user
 */
public class Member {
    String name;
    String email;
    String password;

    // contains all the tasks assigned to the member
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

    /*
    // when a user tries to log out exitVerification function is called
    // this function verifies whether the user really wants to exit or not
     */
    public void exitVerification(Scanner keyboard) {
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

    /*
    // As manager sets password for every member as temporary password
    // all members including the manager has the change password function
    // so that everyone can have their secured password
     */
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

    /*
    // view assigned task displays brief information on the tasks that are assigned for an user
    // this ia a read only function
     */
    public void viewAssignedTasks(){
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

    /*
    // update task status is the actual work of the user
    // the user should keep updating the status of the task given to him
     */
    public void updateTaskStatus(Scanner scanner){

        viewAssignedTasks();

        int choice;
        while(true){
            System.out.print("\t\tEnter the s.no : ");
            choice = Validations.numberCheck(scanner);
            if(choice != -1 && (choice>0 && choice<=assignedTasks.size())){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
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


    public void readDiscussionBox(){
        System.out.println();
        Ui.printLine();

        if(Models.getDiscussionBox().size() == 0){
            System.out.println("\n\t\tEmpty Chat box");
        }
        else{
            for(String chat : Models.getDiscussionBox()){
                System.out.println("\t\t" + chat);
            }
        }

        System.out.println();
        Ui.printLine();
    }

    public void writeDiscussionBox(Scanner scanner){
        readDiscussionBox();
    }

    /*
    -> this function handles all the functions that are used by member
    -> this function is called once the member gets logged in
     */
    public void workOfMember(Scanner scanner){
        int adminChoice = -1;
        System.out.println("\n\t\tWelcome back Member : " + name.toUpperCase());

        boolean check = true;
        while(check){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to view Tasks Assigned");
            System.out.println("\t\t\t Enter 2 to Update task status");
            System.out.println("\t\t\t Enter 3 for DiscussionBox");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            while(adminChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validations.numberCheck(scanner);
            }

            switch (adminChoice){

                case -2 : {
                    this.exitVerification(scanner);
                    break;
                }

                case 0 : {
                    this.changePassword(scanner);
                    break;
                }

                case 1 : {
                    this.viewAssignedTasks();
                    break;
                }

                case 2 : {
                   this.updateTaskStatus(scanner);
                   break;
                }
                case 3 : {
                    this.writeDiscussionBox(scanner);
                    break;
                }
                default: {
                    System.out.println("\n\tWrong value. Give correct input number!\n");
                    break;
                }
            }
            adminChoice = -1;

        }
    }
}
