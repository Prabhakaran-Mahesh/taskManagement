package users;

import activities.Validations;
import designs.Ui;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester extends Member{
    String teamName;
    String teamEmail;
    String teamPassword;
    ArrayList<Task> tasksAssignedForTesting = new ArrayList<>();

    Project mainProject = new Project();

    public Project getMainProject() {
        return mainProject;
    }

    public void setMainProject(Project mainProject) {
        this.mainProject = mainProject;
    }

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

    public void testTask(){
        //Todo:
        for(Task testTask : tasksAssignedForTesting){
            System.out.println("\t\t" + testTask.getTaskName());
        }
        return;
    }

    //readDiscussionBox displays all the chat that happened in the discussionBox.
    public int readDiscussionBox(){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tCHAT BOX");
        if(mainProject == null){
            System.out.println("\t\tNo chatBoxes are available for you!");
            return -1;
        }
        else if(mainProject.getChatBox().size() == 0){
            System.out.println("\t\tChatbox is Empty");
            return 1;
        }
        else{
            for(String msg : mainProject.getChatBox()){
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
                        mainProject.getChatBox().add("\t\t\t\tTester(QA) -> " + this.name + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }

    public void workOfTester(Scanner scanner) {
        System.out.println("\n\t\tWelcome back Teamlead : " + teamName.toUpperCase());

        while (true) {
            int adminChoice = -1;
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Do Testing");
            System.out.println("\t\t\t Enter 2 for DiscussionBox");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            while (adminChoice == -1) {
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validations.numberCheck(scanner);
            }

            switch (adminChoice) {
                case -2 -> this.exitVerification(scanner);

                case 0 -> this.changePassword(scanner);

                case 1 -> this.testTask();

                case 2 -> this.writeDiscussionBox(scanner);

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }

        }
    }


}
