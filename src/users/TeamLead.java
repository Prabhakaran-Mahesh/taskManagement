package users;

import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

/*
// a team lead is created when a member of a project is promoted as teamlead
// the team lead has the access to create tasks for a project
// teamlead divides the work for the team according to the tasks
 */
public class TeamLead extends Member{

    public static Scanner scanner = new Scanner(System.in);

    Project project = new Project();

    public TeamLead() {
        super();
    }

    public TeamLead(String name, String email, String password) {
        super(name, email, password);
    }

    public TeamLead(String name, String email, String password, ArrayList<Member> teamMembersArrayList) {
        super(name, email, password);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /*
    // this is the important function of the task management system
    // using this function the teamlead creates tasks for the assigned project
     */
   public void createTasks(){
        ArrayList<Task> taskArrayList = new ArrayList<>();

        System.out.println();
        Ui.printLine();

        System.out.println("\t\tAdd tasks to the Project");

        boolean done = false;
        while(!done){
            System.out.println("\t\t\t1. Add task");
            System.out.println("\t\t\t0. Completed");

            int choice;
            while(true){
                System.out.print("\n\t\tEnter your choice : ");
                choice = Validations.numberCheck(scanner);
                if(choice != -1){
                    break;
                }
            }

            if(choice == 1){
                Task task;

                String taskName, taskDescription, taskDeadline;

                System.out.print("\t\t\tEnter Name of the Task : ");
                taskName = scanner.next();
                System.out.print("\t\t\tTask Description : ");
                scanner.nextLine();
                taskDescription = scanner.nextLine();
                System.out.print("");

                while(true){
                    System.out.print("\t\t\tTask Deadline (Date format : dd-MM-yyyy) : ");
                    taskDeadline = scanner.next();

                    if(Validations.dateValidation(taskDeadline)){
                        break;
                    }
                }

                System.out.println("\t\tPriority List : ");

                int i = 0;
                for(String m : Models.getPriority()){
                    i++;
                    System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                }
                System.out.println();
                Ui.printLine();

                System.out.print("\t\tChoose task Priority! Enter S.no :");
                int priorityChoice = -1;
                while(true) {
                    while (priorityChoice == -1) {
                        System.out.print("\t\t S.no: ");
                        priorityChoice = Validations.numberCheck(scanner);
                    }

                    if (priorityChoice < 1 || priorityChoice > Models.getPriority().size() || priorityChoice == 0) {
                        System.out.println("\n\t\t S.no not found!");
                        continue;
                    } else {
                        break;
                    }
                }
                task = new Task(taskName, taskDeadline, taskDescription, Models.getPriority().get(priorityChoice-1));
                taskArrayList.add(task);

                System.out.println("\t\t\tSelect Members for the task. Choose their S.no. Enter -1 to Stop");
                i=0;
                int mem =0;
                for(Member m : project.getProjectMembers()){
                    i++;
                    System.out.println("\t\t\tS.no. " + i + " Name : " + m.getName());
                }
                System.out.println();
                while(true){

                    System.out.print("\t\t\tS.no : ");
                    mem = scanner.nextInt();
                    if(mem == -1){
                        break;
                    }
                    else if(mem <-1 || mem >project.getProjectMembers().size() || mem == 0){
                        System.out.println("\n\t\t User not found! Enter the correct S.no");
                    }
                    else{
                        project.getProjectMembers().get(mem-1).assignedTasks.add(task);
                    }
                }


                System.out.println();
                Ui.printLine();
            }
            else{
                System.out.println("Tasks Added to the task");
                done = true;
                project.setTaskArrayList(taskArrayList);
                System.out.println();
                Ui.printLine();
            }

        }

   }

    /*
     // view task displays brief information on the tasks.
     // this ia a read only function
      */
   public void viewTask(){
       System.out.println();
       Ui.printLine();

       System.out.println("\t\tView the Project tasks");
       System.out.println();

       if(project.getTaskArrayList().size() == 0){
           System.out.println("\t\t\tNo task is assigned to you yet!");
       }
       else {
           int i = 0;
           for (Task task : project.getTaskArrayList()) {
               i++;
               System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
               System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getTaskDescription());
           }
       }
       System.out.println();
       Ui.printLine();
   }

    /*
     -> this function handles all the functions that are used by teamlead
     -> this function is called once the teamlead gets logged in
      */
   public void workOfTeamLead(){
       int adminChoice  = -1;
       System.out.println("\n\t\tWelcome back " + name.toUpperCase());

       boolean check = true;
       while(check){
           System.out.println("\n\t\tWhat would you like to do :");

           System.out.println("\n\t\t\t Enter 0 to Change Password");
           System.out.println("\t\t\t Enter 1 to Add tasks to the Project");
           System.out.println("\t\t\t Enter 2 to View task status");
           System.out.println("\t\t\t Enter -1 to Exit\n");

           while(adminChoice == -1){
               System.out.print("\t\t\t Enter your Choice : ");
               adminChoice = Validations.numberCheck(scanner);
           }

           switch (adminChoice){

               case -2 : {
                   this.exitVerification(scanner);
                   adminChoice  = -1;
                   continue;
               }

               case 0 : {
                   this.changePassword(scanner);
                   adminChoice  = -1;
                   break;
               }

               case 1 : {
                   this.createTasks();
                   adminChoice  = -1;
                   break;
               }

               case 2 : {
                   this.viewTask();
                   adminChoice  = -1;
                   break;
               }
           }

       }
   }


}
