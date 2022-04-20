package users;

import activities.Validations;
import designs.Models;
import designs.Ui;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;


// a team lead is created when a member of a project is promoted as teamlead
// the team lead has the access to create tasks for a project
// teamlead divides the work for the team according to the tasks

public class TeamLead extends Member{

    public static Scanner scanner = new Scanner(System.in);

    Project mainProject = new Project();

    public TeamLead(String name, String email, String password) {
        super(name, email, password);
    }


    public void setProject(Project project) {
        this.mainProject = project;
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
                        mainProject.getChatBox().add("\t\t\t\tTeamLead -> " + this.name + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }


    // this is the important function of the task management system
    // using this function the teamlead creates tasks for the assigned project
   public void createTasks(){
        ArrayList<Task> taskArrayList = new ArrayList<>();

        System.out.println();
        Ui.printLine();

        System.out.println("\t\tAdd tasks to the Project");

        boolean done = false;
        while(!done){
            System.out.println("\t\t\t1. Add task");
            System.out.println("\t\t\t-1. Task Adding completed");

            int choice;
            do {
                System.out.print("\n\t\tEnter your choice : ");
                choice = Validations.numberCheck(scanner);
            } while (choice == -1);

            if(choice == 1){
                Task task;

                String taskName, taskDescription, taskDeadline;

                System.out.print("\t\t\tEnter Name of the Task : ");
                taskName = scanner.next();
                System.out.print("\t\t\tTask Description : ");
                scanner.nextLine();
                taskDescription = scanner.nextLine();
                System.out.print("");

                do {
                    System.out.print("\t\t\tTask Deadline (Date format : dd-MM-yyyy) : ");
                    taskDeadline = scanner.next();

                } while (!Validations.deadlineDateValidation(mainProject.getDeadline(), taskDeadline));

                System.out.println("\t\tPriority List : ");

                int i = 0;
                for(String m : Models.getPriority()){
                    i++;
                    System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                }
                System.out.println();
                Ui.printLine();

                System.out.print("\t\tChoose task Priority! Enter");
                int priorityChoice = -1;
                while(true) {
                    while (priorityChoice == -1) {
                        System.out.print("\t\t S.no: ");
                        priorityChoice = Validations.numberCheck(scanner);
                    }

                    if (priorityChoice < 1 || priorityChoice > Models.getPriority().size()) {
                        System.out.println("\n\t\t S.no not found!");
                    } else {
                        break;
                    }
                }
                task = new Task(taskName, taskDeadline, taskDescription, Models.getPriority().get(priorityChoice-1));
                taskArrayList.add(task);

                System.out.println("\t\t\tSelect Members for the task. Choose their S.no. Enter -1 to Stop");
                i=0;
                int mem;
                for(Member m : mainProject.getProjectMembers()){
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
                    else if(mem <-1 || mem >mainProject.getProjectMembers().size() || mem == 0){
                        System.out.println("\n\t\t User not found! Enter the correct S.no");
                    }
                    else{
                        if(mainProject.getProjectMembers().get(mem-1).getEmail() == this.getEmail()){
                            this.assignedTasks.add(task);
                        }
                        else{
                            mainProject.getProjectMembers().get(mem-1).assignedTasks.add(task);
                        }

                    }
                }


                System.out.println();
                Ui.printLine();
            }
            else if(choice == -2){
                System.out.println("\t\tTasks Added to the task");
                done = true;
                mainProject.setTaskArrayList(taskArrayList);
                System.out.println();
                Ui.printLine();
            } else{
                System.out.println("\t\tWrong number. check your Input!\n");
            }

        }

   }

    private void updateTaskDetails(Scanner scanner){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Project which you want to update : ");
            choice = Validations.numberCheck(scanner);
            if(choice>0 && choice<=mainProject.getTaskArrayList().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Task selectedTask = mainProject.getTaskArrayList().get(choice-1);

        boolean update = true;
        while(update){
            System.out.println("\n\t\t\tEnter the s.no of credential you want to change!");
            System.out.println("\t\t\t Enter 1 to Task Name ");
            System.out.println("\t\t\t Enter 2 to Task Deadline");
            System.out.println("\t\t\t Enter 3 to Task Description");
            System.out.println("\t\t\t Enter 4 to Task Priority ");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            int updateChoice = -1;
            while(updateChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                updateChoice = Validations.numberCheck(scanner);
            }

            switch (updateChoice){
                case -2 -> {
                    update = false;

                    System.out.println();
                    Ui.printLine();
                }

                case 1 -> {
                    System.out.println("\n\t\tCurrent Name : " + selectedTask.getTaskName());
                    System.out.print("\t\tEnter the new Task Name : ");
                    String chat;
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validations.messageValidation(chat)){
                        selectedTask.setTaskName(chat);
                    }
                }

                case 2 -> {
                    System.out.println("\n\t\tCurrent Deadline : " + selectedTask.getDeadline());
                    String deadline;
                    do {
                        System.out.print("\t\t\tTask Deadline (Date format : dd-MM-yyyy) : ");
                        deadline = scanner.next();

                    } while (!Validations.deadlineDateValidation(mainProject.getDeadline(), deadline));

                    selectedTask.setDeadline(deadline);
                }

                case 3 -> {
                    System.out.println("\n\t\tCurrent Description : " + selectedTask.getTaskDescription());
                    System.out.print("\t\tEnter the new Project Name : ");
                    String description;
                    //scanner.nextLine();
                    description = scanner.nextLine();
                    System.out.print("");

                    selectedTask.setTaskDescription(description);
                }

                case 4 -> {
                    System.out.println("\n\t\tCurrent Priority : " + selectedTask.getTaskDescription());
                    System.out.print("\t\tEnter the new New Priority S.no : ");

                    int i = 0;
                    for(String m : Models.getPriority()){
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    Ui.printLine();

                    System.out.print("\t\tChoose task Priority! Enter");
                    int priorityChoice = -1;
                    while(true) {
                        while (priorityChoice == -1) {
                            System.out.print("\t\t S.no: ");
                            priorityChoice = Validations.numberCheck(scanner);
                        }

                        if (priorityChoice < 1 || priorityChoice > Models.getPriority().size()) {
                            System.out.println("\n\t\t S.no not found!");
                        } else {
                            break;
                        }
                    }

                    selectedTask.setPriority(Models.getPriority().get(priorityChoice-1));
                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");
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

       if(mainProject.getTaskArrayList().size() == 0){
           System.out.println("\t\t\tNo task is created yet!");
       }
       else {
           int i = 0;
           System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
           for (Task task : mainProject.getTaskArrayList()) {
               i++;
               System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getTaskDescription());
           }

           Ui.printLine();

           System.out.println("\n\t\tDo you want to update Task Details? Enter 1 to yes, Enter -1 to no");
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

           if(ver == 1){
               updateTaskDetails(scanner);
           }
       }
   }

    /*
     -> this function handles all the functions that are used by teamlead
     -> this function is called once the teamlead gets logged in
      */
   public void workOfTeamLead(){
       System.out.println("\n\t\tWelcome back Teamlead : " + name.toUpperCase());

       while(true){
           int adminChoice  = -1;
           System.out.println("\n\t\tWhat would you like to do :");

           System.out.println("\n\t\t\t Enter 0 to Change Password");
           System.out.println("\t\t\t Enter 1 to Add tasks to the Project");
           System.out.println("\t\t\t Enter 2 to View/Update details of Tasks status");
           System.out.println("\t\t\t Enter 3 to View/Update status of Tasks Assigned");
           System.out.println("\t\t\t Enter 4 for DiscussionBox");
           System.out.println("\t\t\t Enter -1 to Exit\n");

           while(adminChoice == -1){
               System.out.print("\t\t\t Enter your Choice : ");
               adminChoice = Validations.numberCheck(scanner);
           }

           switch (adminChoice) {
               case -2 -> this.exitVerification(scanner);

               case 0 -> this.changePassword(scanner);

               case 1 -> this.createTasks();

               case 2 -> this.viewTask();

               case 3 -> this.viewAssignedTasks(scanner, mainProject);

               case 4 -> this.writeDiscussionBox(scanner);

               default -> System.out.println("\n\tWrong value. Give correct input number!\n");

           }

       }
   }


}
