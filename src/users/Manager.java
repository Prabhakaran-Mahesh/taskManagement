package users;

import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Member{

    ArrayList<Project> projectArraylist = new ArrayList<>();

    public Manager() {
        super();
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    /*
    // create user method is used to create and add a member to the company
    // as no users except the manager can register
    // other users are created or generated by the manager
    // This functions creates a temporary password for the user w2hich he can later update
     */
    public void createUser(Scanner keyboard){

        String name, password, email;

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tAdd a User to Your Team");

        System.out.print("\t\t\tEnter Name of the User : ");
        name = keyboard.next();

        email = Validations.emailValidation(keyboard);

        System.out.print("\t\t\tEnter Temporary Password : ");
        password = keyboard.next();

        Member member = new Member(name, email, password);
        Models.members.add(member);
        System.out.println("\t\tUser added to the team");
        Ui.printLine();
    }

    /*
    //Manager creates or opens a project using this function
    //Adds members to the project
    // and appoints a teamlead to guide the members to complete the task
     */
    public void createProject(Scanner scanner){

        String projectName, description, deadline;
        TeamLead teamLead;
        ArrayList<Member> memberArrayList = new ArrayList<>();
        //ArrayList<Task> taskArrayList;

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tCreate a Project");

        System.out.print("\t\t\tEnter Name of the Project : ");
        projectName = scanner.next();
        System.out.print("\t\t\tProduct Description : ");
        scanner.nextLine();
        description = scanner.nextLine();
        System.out.print("");

        do {
            System.out.print("\t\t\tProject Deadline (Date format : dd-MM-yyyy) : ");
            deadline = scanner.next();

        } while (!Validations.dateValidation(deadline));


        System.out.print("\n\t\t\tEnter the ID number of the users you want for this project\n\t\t\tEnter -1 to stop. ");
        int i=0;
        for(Member m : Models.members){
            i++;
            System.out.print("\n\t\t S.no : " + i + ". Name : " + m.getName());
        }

        System.out.println("\n\t\tEnter your choices\n");
        int memberChoice = -1;
        while(true){
            while(memberChoice == -1){
                System.out.print("\t\t S.no: ");
                memberChoice = Validations.numberCheck(scanner);
            }

            if(memberChoice == -2){
                break;
            }
            else if(memberChoice<1 || memberChoice>Models.members.size()){
                System.out.println("\n\t\t S.no not found!");
                memberChoice = -1;
                continue;
            }
            memberArrayList.add(Models.members.get(memberChoice-1));
            memberChoice = -1;
        }

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tMembers Added to the Project : ");

        i = 0;
        for(Member m : memberArrayList){
            i++;
            System.out.print("\n\t\t\t S.no : " + i + ". Name : " + m.getName());
        }
        System.out.println();
        Ui.printLine();

        System.out.print("\t\tChoose your ProjectLead! Enter their");
        memberChoice = -1;
        while(true){
            while(memberChoice == -1){
                System.out.print("\t\t S.no: ");
                memberChoice = Validations.numberCheck(scanner);
            }

            if(memberChoice<1 || memberChoice>memberArrayList.size()){
                System.out.println("\n\t\t S.no not found!");
                memberChoice = -1;
            }
            else{
                break;
            }
        }
        Member mem = memberArrayList.get(memberChoice-1);
        teamLead = new TeamLead(mem.name, mem.email, mem.password);
        Models.teamLeads.add(teamLead);

        Project project = new Project(projectName, teamLead, memberArrayList, deadline, description);

        System.out.println("\n\t\tProject created!");
        teamLead.setProject(project);
        projectArraylist.add(project);

        for(Member m : memberArrayList){
            m.setProject(project);
        }

        Ui.printLine();

    }

    /*
    // using this function the manager can view the projects that he owns
    // he can also see the current status of the project
     */
    public void viewProjects(){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tProject Details\n");

        if(projectArraylist.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            Ui.printLine();
        }
        else{
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "TaskName", "Deadline", "Status", "Description");

            for(Project project : projectArraylist){

                int i=0, j=0;
                for(Task projectTask : project.getTaskArrayList()){
                    if(projectTask.getStatus().equalsIgnoreCase("Not yet started")){
                        i++;
                    }
                    else if(projectTask.getStatus().equalsIgnoreCase("Completed")){
                        j++;
                    }
                }

                if(i==project.getTaskArrayList().size()){
                    project.setStatus("Not yet started");
                }
                else if(j==project.getTaskArrayList().size()){
                    project.setStatus("Completed");
                }
                else{
                    project.setStatus("Implementation");
                }
                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getStatus(), project.getProjectDescription());
            }
            Ui.printLine();
        }

    }

    public int readDiscussionBox(Project pr){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tCHAT BOX");
        if(pr == null){
            System.out.println("\t\tNo chatBoxes are available for you!");
            System.out.println();
            Ui.printLine();
            return -1;
        }
        else if(pr.getChatBox().size() == 0){
            System.out.println("\t\tChatbox is Empty");
            return 1;
        }
        else{
            for(String msg : pr.getChatBox()){
                System.out.println("\t\t\t" + msg);
            }
            return 1;
        }
    }

    public void writeDiscussionBox(Scanner scanner, Project pr){

        while(true){
            int chatboxResult = readDiscussionBox(pr);

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

                    pr.getChatBox().add("\t\t\t\tMANAGER -> " + this.name + " : " + chat);
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }

    /*
    -> this function handles all the functions that are used by manager
    -> this function is called once the manager gets logged in
     */
    public void workOfManager(Scanner scanner){
        int adminChoice=-1;
        System.out.println("\n\t\tWelcome back Manager : " + name.toUpperCase());

        while(true){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Add a User to your team");
            System.out.println("\t\t\t Enter 2 to Create a new Project");
            System.out.println("\t\t\t Enter 3 to View Projects");
            System.out.println("\t\t\t Enter 4 for DiscussionBox");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            while(adminChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validations.numberCheck(scanner);
            }


            switch (adminChoice) {
                case -2 -> this.exitVerification(scanner);

                case 0 -> this.changePassword(scanner);
                case 1 -> this.createUser(scanner);

                case 2 -> this.createProject(scanner);

                case 3 -> this.viewProjects();

                case 4-> {
                    System.out.println();
                    Ui.printLine();

                    if(projectArraylist.size() == 0){
                        System.out.println("\t\tNo Project created yet to have a discussion group");
                    }
                    else{
                        System.out.println("\t\tChoose the chatGroup :\n");
                        int i=0;
                        for(Project p : projectArraylist){
                            i++;
                            System.out.println("\t\t" + i + ". Project " + p.getProjectName() + " ChatBox");
                        }

                        System.out.println();
                        Ui.printLine();

                        System.out.print("\n\t\t Enter S.no :");
                        int chatboxChoice = -1;
                        while(true) {

                            while (chatboxChoice == -1) {
                                System.out.print("\t\t S.no: ");
                                chatboxChoice = Validations.numberCheck(scanner);
                            }

                            if (chatboxChoice < 1 || chatboxChoice > projectArraylist.size()) {
                                System.out.println("\n\t\t S.no not found!");
                            } else {
                                break;
                            }
                        }

                        writeDiscussionBox(scanner, projectArraylist.get(chatboxChoice-1));
                    }
                    System.out.println();
                    Ui.printLine();
                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }
            adminChoice = -1;

        }
    }
}
