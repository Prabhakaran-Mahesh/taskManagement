package users;

import designs.Models;
import designs.Ui;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Manager extends Member{

    ArrayList<Project> projectArraylist = new ArrayList<>();

    public Manager() {
        super();
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    public void createUser(Scanner keyboard){

        String name, password, email;

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tAdd a User to Your Team");

        System.out.print("\t\t\tEnter Name of the User : ");
        name = keyboard.next();
        System.out.print("\t\t\tEnter Email Id of the User : ");
        email = keyboard.next();
        System.out.print("\t\t\tEnter Temporary Password : ");
        password = keyboard.next();

        Member member = new Member(name, email, password);
        Models.members.add(member);
        System.out.println("\t\tUser added to the team");
        Ui.printLine();
    }

    public void createProject(Scanner scanner){

        String projectName, description, deadline;
        TeamLead teamLead;
        ArrayList<Member> memberArrayList = new ArrayList<>();
        ArrayList<Task> taskArrayList;

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tCreate a Project");

        System.out.print("\t\t\tEnter Name of the Project : ");
        projectName = scanner.next();
        System.out.print("\t\t\tProduct Description : ");
        scanner.nextLine();
        description = scanner.nextLine();
        System.out.print("");
        System.out.print("\t\t\tProject Deadline : ");
        deadline = scanner.next();

        System.out.print("\n\t\t\tEnter the ID number of the users you want for this project\n\t\t\tEnter -1 to stop. ");
        int i=0;
        for(Member m : Models.members){
            i++;
            System.out.print("\n\t\t S.no : " + i + ". Name : " + m.getName());
        }

        System.out.println("\n\t\tEnter your choices\n");
        int memberChoice;
        while(true){
            System.out.print("\t\t S.no: ");
            memberChoice = scanner.nextInt();
            if(memberChoice == -1){
                break;
            }
            else if(memberChoice<1 || memberChoice>Models.members.size()){
                System.out.println("\n\t\t S.no not found!");
                continue;
            }
            memberArrayList.add(Models.members.get(memberChoice-1));
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
        while(true){
            System.out.print("\t\t S.no: ");
            memberChoice = scanner.nextInt();

            if(memberChoice<1 || memberChoice>memberArrayList.size()){
                System.out.println("\n\t\t S.no not found!");
                continue;
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
        Ui.printLine();

    }

    public void viewProjects(Scanner scanner){
        System.out.println();
        Ui.printLine();

        System.out.println("\t\tProject Details\n");
        for(Project project : projectArraylist){
            //System.out.println("Project title : " + project.getProjectName().toUpperCase(Locale.ROOT));
            if(project.getTaskArrayList().size() == 0){
                project.setStatus("Not yet started");
            }
            else{
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
                else if(i==project.getTaskArrayList().size()){
                    project.setStatus("Completed");
                }
                else{
                    project.setStatus("Implementation");
                }
            }

            if(project.getTaskArrayList().size() == 0){
                System.out.println("\t\t\tNo task is assigned to you yet!");
            }
            else {
                int i = 0;
                for (Project proj : projectArraylist) {
                    i++;
                    System.out.printf("\n\t\t%15s d%15s %15s %25s %25s\n", "S.no", "TaskName", "Deadline", "Status", "Description");
                    System.out.printf("\t\t%15s %15s %15s %25s %25s\n", i, proj.getProjectName(), proj.getDeadline(), proj.getStatus(), proj.getProjectDescription());
                }
            }
        }
    }

    public void workOfManager(Scanner scanner){
        int adminChoice;
        System.out.println("\n\t\tWelcome back " + name.toUpperCase());

        boolean check = true;
        while(check){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Add a User to your team");
            System.out.println("\t\t\t Enter 2 to Create a new Project");
            System.out.println("\t\t\t Enter 3 to View Projects");
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
                    this.createUser(scanner);
                    break;
                }

                case 2 : {
                    this.createProject(scanner);
                    break;
                }

                case 3 : {
                    this.viewProjects(scanner);
                    break;
                }
            }

        }
    }
}
