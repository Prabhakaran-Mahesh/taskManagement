package users;

import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;


// Member function is the parent class of all the user types in this project
// this contains all credentials anf functions of the user
public class Member {
    String name;
    String email;
    String password;

    Project project;

    // contains all the tasks assigned to the member
    public ArrayList<Task> assignedTasks = new ArrayList<>();

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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



    public void filterTaskAssignedViews(ArrayList<Task> assignTasks, int get, Scanner scanner, Project project){
        int i = 0;
        ArrayList<Task> filteredTasks = new ArrayList<>();

        if(get==1){
            System.out.printf("\n\t\t%15s %15s %15s %15s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
            for(Task task : assignTasks){
                i++;
                System.out.printf("\t\t%15s %15s %15s %15s %25s %25s\n", i, task.getTaskName(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getTaskDescription());
            }

        }
        else{
            System.out.println("\t\t\t Key words that can be searched");
            System.out.println("\t\t\t\tTask Name");
            System.out.println("\t\t\t\tNot yet Started");
            for(String stat : Models.getStatus()){
                System.out.println("\t\t\t\t" + stat);
            }
            for(String prior : Models.getPriority()){
                System.out.println("\t\t\t\t" + prior);
            }

            System.out.print("\n\t\tEnter the value you want to Search : ");
            String enteredSearchValue = scanner.nextLine();
            System.out.print("");


            for (Task task : assignTasks) {
                if (task.getTaskName().equalsIgnoreCase(enteredSearchValue)) {
                    filteredTasks.add(task);
                } else if (task.getStatus().equalsIgnoreCase(enteredSearchValue)) {
                    filteredTasks.add(task);
                } else if (task.getPriority().equalsIgnoreCase(enteredSearchValue)) {
                    filteredTasks.add(task);
                }
            }

            if(filteredTasks.size()==0){
                System.out.println("\t\tNo tasks are found under the given criteria : " + enteredSearchValue);
            }
            else{
                System.out.printf("\n\t\t%15s %15s %15s %15s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                for(Task task : filteredTasks){
                    i++;
                    System.out.printf("\t\t%15s %15s %15s %15s %25s %25s\n", i, task.getTaskName(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getTaskDescription());
                }
            }


        }

        System.out.println("\n\t\tDo you want to update status of any task? Enter 1 to yes, Enter -1 to no");
        int ver;
        while(true){
            System.out.print("\t\tEnter your choice : ");
            ver = Validations.numberCheck(scanner);
            if(ver == -2 || ver == 1) {
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        if(ver == 1 && get == 1){
            updateTaskStatus(scanner, assignTasks, project);
        } else if(ver == 1 && filteredTasks.size() != 0){
            updateTaskStatus(scanner, filteredTasks, project);
        }
    }

    /*
    -> view assigned task displays brief information on the tasks that are assigned for an user
    -> this ia a read only function]
    -> this view occurs according to the sorting option chosen
     */
    public int viewAssignedTasks(Scanner scanner, Project project){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tView the Assigned tasks");
        System.out.println();

        if(assignedTasks.size() == 0){
            System.out.println("\t\t\tNo task is assigned to you yet!");

            System.out.println();
            Ui.printLine();
            return 0;
        }
        else {
            System.out.println("\t\t1. All tasks");
            System.out.println("\t\t2. Search By criteria");

            int choice;
            do {
                System.out.print("\n\t\tEnter your choice : ");
                choice = Validations.numberCheck(scanner);
            } while (choice == -1);

            if (choice == 1 || choice == 2) {
                filterTaskAssignedViews(assignedTasks, choice, scanner, project);
            } else{
                System.out.print("\n\t\tThe number input is incorrect!");
            }

            System.out.println();
            Ui.printLine();

            return 1;
        }
    }

    /*
    // update task status is the actual work of the user
    // the user should keep updating the status of the task given to him
     */
    public void updateTaskStatus(Scanner scanner, ArrayList<Task> assignTasks, Project project){


        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the task which you want to update : ");
            choice = Validations.numberCheck(scanner);
            if(choice>0 && choice<=assignTasks.size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Task selectedTask = assignTasks.get(choice-1);
        System.out.println("\t\t"+selectedTask.getTaskName()+"\n");

        System.out.println("\t\tStatus list : ");
        int i=0;
        for(String status : Models.getStatus()){
            i++;
            System.out.println("\t\t\t"+i+". "+ status);
        }
        do {
            System.out.print("\t\tPick a status using S.no of the task to update: ");
            choice = Validations.numberCheck(scanner);
        } while (choice == -1 || (choice <= 0 || choice > Models.getStatus().size()));

        selectedTask.setStatus(Models.getStatus().get(choice-1));
        if(choice == Models.getStatus().size()){

            // sending the task to tester if submitted
            project.getTester().getTasksAssignedForTesting().add(selectedTask);
        }
        System.out.println("\n\t\tTask Status Updated");

    }


    //readDiscussionBox displays all the chat that happened in the discussionBox.
    public int readDiscussionBox(){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tCHAT BOX");
        if(project == null){
            System.out.println("\t\tNo chatBoxes are available for you!");
            return -1;
        }
        else if(getProject().getChatBox().size() == 0){
            System.out.println("\t\tChatbox is Empty");
            return 1;
        }
        else{
            for(String msg : getProject().getChatBox()){
                System.out.println("\t\t\t" + msg);
            }
            return 1;
        }
    }

    // this writeDiscussionBox helps to chat in the discussionBox.
    public void writeDiscussionBox(Scanner scanner){

        while(true){
            int chatboxResult = readDiscussionBox();

            if(chatboxResult == -1){
                break;
            }
            else{
                System.out.println("\n\t\t\t Enter 1 to Add a chat.");
                System.out.println("\t\t\t Enter -1 to End chat");

                int choice;
                do {
                    System.out.print("\n\t\tEnter your choice : ");
                    choice = Validations.numberCheck(scanner);
                } while (choice == -1);

                if (choice == -2) {
                    System.out.println();
                    Ui.printLine();

                    break;
                } else if (choice == 1) {
                    String chat;
                    System.out.print("\n\t\tYour message : ");
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validations.messageValidation(chat)){
                        project.getChatBox().add("\t\t\t\t" + this.name + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }

    /*
    -> this function handles all the functions that are used by member
    -> this function is called once the member gets logged in
     */
    public void workOfMember(Scanner scanner){
        int adminChoice = -1;
        System.out.println("\n\t\tWelcome back Member : " + name.toUpperCase());

        while(true){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to View/Update status of Tasks Assigned");
            System.out.println("\t\t\t Enter 2 for DiscussionBox");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            while(adminChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validations.numberCheck(scanner);
            }

            switch (adminChoice) {
                case -2 -> this.exitVerification(scanner);

                case 0 -> this.changePassword(scanner);

                case 1 -> this.viewAssignedTasks(scanner, project);

                case 2 -> this.writeDiscussionBox(scanner);

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }
            adminChoice = -1;

        }
    }
}
