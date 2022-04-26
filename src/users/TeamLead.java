package users;

import activities.Validation;
import models.DataModel;
import models.DesignModel;
import objects.Issue;
import objects.Project;
import objects.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamLead extends TeamMember{
    ArrayList<Task> createdTasks = new ArrayList<>();
    ArrayList<Issue> createdIssue = new ArrayList<>();

    ArrayList<Project> projectArrayList = new ArrayList<>();

    public TeamLead(TeamMember teamMember) {
        super(teamMember.memberName, teamMember.memberEmail, teamMember.memberPassword);
    }



    public ArrayList<Task> getCreatedTasks() {
        return createdTasks;
    }

    public void setCreatedTasks(ArrayList<Task> createdTasks) {
        this.createdTasks = createdTasks;
    }

    public ArrayList<Issue> getCreatedIssue() {
        return createdIssue;
    }

    public void setCreatedIssue(ArrayList<Issue> createdIssue) {
        this.createdIssue = createdIssue;
    }

    @Override
    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    @Override
    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    public void createTasks(){
        //ArrayList<Task> taskArrayList = new ArrayList<>();

        System.out.println();
        DesignModel.printLine();

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else {
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
            int i = 0;
            for (Project project : projectArrayList) {

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            int choice;

            while(true){
                System.out.print("\n\t\tEnter the s.no of the Project which you want to add Tasks : ");
                choice = Validation.numberCheck(scanner);
                if(choice>0 && choice<=projectArrayList.size()){
                    break;
                }
                else{
                    System.out.println("\t\tWrong input");
                }
            }

            Project selectedProject = projectArrayList.get(choice-1);



            System.out.println("\t\tAdd tasks to the Project");

            boolean done = false;
            while (!done) {
                System.out.println("\t\t\t1. Add task");
                System.out.println("\t\t\t-1. Task Adding completed");
                do {
                    System.out.print("\n\t\tEnter your choice : ");
                    choice = Validation.numberCheck(scanner);
                } while (choice == -1);

                if (choice == 1) {
                    Task task;

                    String taskName, taskDescription, taskDeadline;

                    System.out.print("\t\t\tEnter Name of the Task : ");
                    taskName = scanner.nextLine();
                    System.out.print("");
                    System.out.print("\t\t\tTask Description : ");
                    scanner.nextLine();
                    taskDescription = scanner.nextLine();
                    System.out.print("");

                    do {
                        System.out.print("\t\t\tTask Deadline (Date format : dd-MM-yyyy) : ");
                        taskDeadline = scanner.next();

                    } while (!Validation.deadlineDateValidation(selectedProject.getDeadline(), taskDeadline));

                    System.out.println("\t\tPriority List : ");

                    i = 0;
                    for (String m : DataModel.getPriority()) {
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.print("\t\tChoose task Priority! Enter");
                    int priorityChoice = -1;
                    while (true) {
                        while (priorityChoice == -1) {
                            System.out.print("\t\t S.no: ");
                            priorityChoice = Validation.numberCheck(scanner);
                        }

                        if (priorityChoice < 1 || priorityChoice > DataModel.getPriority().size()) {
                            System.out.println("\n\t\t S.no not found!");
                        } else {
                            break;
                        }
                    }
                    task = new Task(taskName, taskDeadline, taskDescription, DataModel.getPriority().get(priorityChoice - 1));
                    selectedProject.getTaskArrayList().add(task);

                    System.out.println("\t\t\tSelect Members for the task. Choose their S.no. Enter -1 to Stop");
                    i = 0;
                    int mem;
                    for (TeamMember m : selectedProject.getTeamMemberArrayList()) {
                        i++;
                        System.out.println("\t\t\tS.no. " + i + " Name : " + m.getMemberName());
                    }
                    System.out.println();
                    while (true) {

                        System.out.print("\t\t\tS.no : ");
                        mem = scanner.nextInt();
                        if (mem == -1) {
                            break;
                        } else if (mem < -1 || mem > selectedProject.getTeamMemberArrayList().size() || mem == 0) {
                            System.out.println("\n\t\t User not found! Enter the correct S.no");
                        } else {
                            selectedProject.getTeamMemberArrayList().get(mem - 1).assignedTasks.add(task);
                            for(TeamLead teamLead :selectedProject.getTeamLeadArrayList()){
                                if(selectedProject.getTeamMemberArrayList().get(mem - 1).getMemberEmail().equalsIgnoreCase(teamLead.getMemberEmail())){
                                    teamLead.getAssignedTasks().add(task);
                                    break;
                                }
                            }

                        }
                    }


                    System.out.println();
                    DesignModel.printLine();
                } else if (choice == -2) {
                    System.out.println("\t\tTasks Added to the task");
                    done = true;
                    System.out.println();
                    DesignModel.printLine();
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }

            }
        }

    }

    public void createIssues(){
        //ArrayList<Task> taskArrayList = new ArrayList<>();

        System.out.println();
        DesignModel.printLine();

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else {
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
            int i = 0;
            for (Project project : projectArrayList) {

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            int choice;

            while(true){
                System.out.print("\n\t\tEnter the s.no of the Project which you want to add Issues : ");
                choice = Validation.numberCheck(scanner);
                if(choice>0 && choice<=projectArrayList.size()){
                    break;
                }
                else{
                    System.out.println("\t\tWrong input");
                }
            }

            Project selectedProject = projectArrayList.get(choice-1);



            System.out.println("\t\tAdd Issues to the Project");

            boolean done = false;
            while (!done) {
                System.out.println("\t\t\t1. Add Issue");
                System.out.println("\t\t\t-1. Issue Adding completed");
                do {
                    System.out.print("\n\t\tEnter your choice : ");
                    choice = Validation.numberCheck(scanner);
                } while (choice == -1);

                if (choice == 1) {
                    Issue issue;

                    String taskName, taskDescription, taskDeadline;

                    System.out.print("\t\t\tEnter Name of the Issue : ");
                    taskName = scanner.nextLine();
                    System.out.print("");
                    System.out.print("\t\t\tIssue Description : ");
                    scanner.nextLine();
                    taskDescription = scanner.nextLine();
                    System.out.print("");

                    do {
                        System.out.print("\t\t\tIssue Deadline (Date format : dd-MM-yyyy) : ");
                        taskDeadline = scanner.next();

                    } while (!Validation.deadlineDateValidation(selectedProject.getDeadline(), taskDeadline));

                    System.out.println("\t\tPriority List : ");

                    i = 0;
                    for (String m : DataModel.getPriority()) {
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.print("\t\tChoose Issue Priority! Enter");
                    int priorityChoice = -1;
                    while (true) {
                        while (priorityChoice == -1) {
                            System.out.print("\t\t S.no: ");
                            priorityChoice = Validation.numberCheck(scanner);
                        }

                        if (priorityChoice < 1 || priorityChoice > DataModel.getPriority().size()) {
                            System.out.println("\n\t\t S.no not found!");
                        } else {
                            break;
                        }
                    }
                    issue = new Issue(taskName, taskDeadline, taskDescription, DataModel.getPriority().get(priorityChoice - 1));
                    selectedProject.getIssueArrayList().add(issue);

                    System.out.println("\t\t\tSelect Members for the task. Choose their S.no. Enter -1 to Stop");
                    i = 0;
                    int mem;
                    for (TeamMember m : selectedProject.getTeamMemberArrayList()) {
                        i++;
                        System.out.println("\t\t\tS.no. " + i + " Name : " + m.getMemberName());
                    }
                    System.out.println();
                    while (true) {

                        System.out.print("\t\t\tS.no : ");
                        mem = scanner.nextInt();
                        if (mem == -1) {
                            break;
                        } else if (mem < -1 || mem > selectedProject.getTeamMemberArrayList().size() || mem == 0) {
                            System.out.println("\n\t\t User not found! Enter the correct S.no");
                        } else {
                            selectedProject.getTeamMemberArrayList().get(mem - 1).getAssignedIssues().add(issue);
                            for(TeamLead teamLead :selectedProject.getTeamLeadArrayList()){
                                if(selectedProject.getTeamMemberArrayList().get(mem - 1).getMemberEmail().equalsIgnoreCase(teamLead.getMemberEmail())){
                                    teamLead.getAssignedIssues().add(issue);
                                    break;
                                }
                            }
                        }
                    }


                    System.out.println();
                    DesignModel.printLine();
                } else if (choice == -2) {
                    System.out.println("\t\tIssues Added");
                    done = true;
                    System.out.println();
                    DesignModel.printLine();
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }

            }
        }

    }

    private void updateTaskDetails(Project selectedProject){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Task which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=selectedProject.getTaskArrayList().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Task selectedTask = selectedProject.getTaskArrayList().get(choice-1);

        boolean update = true;
        while(update){
            System.out.println("\n\t\t\tEnter the s.no of credential you want to change!");
            System.out.println("\t\t\t Enter 1 to Task Name ");
            System.out.println("\t\t\t Enter 2 to Task Deadline");
            System.out.println("\t\t\t Enter 3 to Task Description");
            System.out.println("\t\t\t Enter 4 to Task Priority ");
            System.out.println("\t\t\t Enter 5 to Task Status ");
            System.out.println("\t\t\t Enter -1 to Go back\n");

            int updateChoice = -1;
            while(updateChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                updateChoice = Validation.numberCheck(scanner);
            }

            switch (updateChoice){
                case -2 -> {
                    update = false;

                    System.out.println();
                    DesignModel.printLine();
                }

                case 1 -> {
                    System.out.println("\n\t\tCurrent Name : " + selectedTask.getTaskName());
                    System.out.print("\t\tEnter the new Task Name : ");
                    String chat;
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validation.messageValidation(chat)){
                        selectedTask.setTaskName(chat);
                    }
                }

                case 2 -> {
                    System.out.println("\n\t\tCurrent Deadline : " + selectedTask.getDeadline());
                    String deadline;
                    do {
                        System.out.print("\t\t\tTask Deadline (Date format : dd-MM-yyyy) : ");
                        deadline = scanner.next();

                    } while (!Validation.deadlineDateValidation(selectedProject.getDeadline(), deadline));

                    selectedTask.setDeadline(deadline);
                }

                case 3 -> {
                    System.out.println("\n\t\tCurrent Description : " + selectedTask.getDescription());
                    System.out.print("\t\tEnter the new Project Name : ");
                    String description;
                    //scanner.nextLine();
                    description = scanner.nextLine();
                    System.out.print("");

                    selectedTask.setDescription(description);
                }

                case 4 -> {
                    System.out.println("\n\t\tCurrent Priority : " + selectedTask.getTaskPriority());
                    System.out.print("\t\tEnter the new New Priority S.no : ");

                    int i = 0;
                    for(String m : DataModel.getPriority()){
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.print("\t\tChoose task Priority! Enter");
                    int priorityChoice = -1;
                    while(true) {
                        while (priorityChoice == -1) {
                            System.out.print("\t\t S.no: ");
                            priorityChoice = Validation.numberCheck(scanner);
                        }

                        if (priorityChoice < 1 || priorityChoice > DataModel.getPriority().size()) {
                            System.out.println("\n\t\t S.no not found!");
                        } else {
                            break;
                        }
                    }

                    selectedTask.setTaskPriority(DataModel.getPriority().get(priorityChoice-1));
                }

                case 5 -> {
                    System.out.println("\n\t\tCurrent Status : " + selectedTask.getTaskStatus());
                    System.out.print("\t\tEnter the new New Priority S.no : ");

                    int i = 0;
                    for(String m : DataModel.getTaskStatus()){
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.println("\n\t\tEnter 1 to select a Status. Enter 2 to add Custom Status");
                    int select = -1;
                    while(select == -1){
                        System.out.print("\t\t\t Enter your Choice : ");
                        select = Validation.numberCheck(scanner);
                        if(select < 1 || select > 2){
                            System.out.println("\t\tWrong input! Enter 1 or 2");
                            select = -1;
                        }
                    }
                    if(select == 1){
                        System.out.print("\t\tChoose task Status! Enter");
                        int priorityChoice = -1;
                        while(true) {
                            while (priorityChoice == -1) {
                                System.out.print("\t\t S.no: ");
                                priorityChoice = Validation.numberCheck(scanner);
                            }

                            if (priorityChoice < 1 || priorityChoice > DataModel.getTaskStatus().size()) {
                                System.out.println("\n\t\t S.no not found!");
                            } else {
                                break;
                            }
                        }

                        selectedTask.setTaskStatus(DataModel.getTaskStatus().get(priorityChoice-1));
                        selectedProject.getProgressArrayList().add(selectedTask);
                        if(DataModel.getTaskStatus().get(priorityChoice-1).equalsIgnoreCase("Submitted for test")){
                            selectedProject.getTester().getAssignedTasks().add(selectedTask);
                        }
                    }
                    else{
                        System.out.print("\t\tEnter the custom Status : ");
                        String chat;
                        //scanner.nextLine();
                        chat = scanner.nextLine();
                        System.out.print("");

                        DataModel.getTaskStatus().add(chat);
                        selectedTask.setTaskStatus(chat);
                    }

                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");
            }
        }

    }

    public void viewTask(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tView the Project tasks");
        System.out.println();

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else {
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
            int i = 0;
            for (Project project : projectArrayList) {

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            int choice;

            while (true) {
                System.out.print("\n\t\tEnter the s.no of the Project which you want to View Tasks : ");
                choice = Validation.numberCheck(scanner);
                if (choice > 0 && choice <= projectArrayList.size()) {
                    break;
                } else {
                    System.out.println("\t\tWrong input");
                }
            }

            Project selectedProject = projectArrayList.get(choice - 1);


            if (selectedProject.getTaskArrayList().size() == 0) {
                System.out.println("\t\t\tNo task is created yet!");
            } else {
                i = 0;
                System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                for (Task task : selectedProject.getTaskArrayList()) {
                    i++;
                    System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
                }

                DesignModel.printLine();

                System.out.println("\n\t\tDo you want to update Task Details? Enter 1 to yes, Enter -1 to no");
                int ver;
                while (true) {
                    System.out.print("\t\tEnter your choice : ");
                    ver = Validation.numberCheck(scanner);
                    if (ver == -2 || ver == 1) {
                        break;
                    } else {
                        System.out.println("\t\tWrong input");
                    }
                }

                if (ver == 1) {
                    updateTaskDetails(selectedProject);
                }
            }
        }
    }

    private void updateIssueDetails(Project selectedProject){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Issue which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=selectedProject.getIssueArrayList().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Issue selectedTask = selectedProject.getIssueArrayList().get(choice-1);

        boolean update = true;
        while(update){
            System.out.println("\n\t\t\tEnter the s.no of credential you want to change!");
            System.out.println("\t\t\t Enter 1 to Issue Name ");
            System.out.println("\t\t\t Enter 2 to Issue Deadline");
            System.out.println("\t\t\t Enter 3 to Issue Description");
            System.out.println("\t\t\t Enter 4 to Issue Priority ");
            System.out.println("\t\t\t Enter 5 to Issue Status");
            System.out.println("\t\t\t Enter -1 to Go back\n");

            int updateChoice = -1;
            while(updateChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                updateChoice = Validation.numberCheck(scanner);
            }

            switch (updateChoice){
                case -2 -> {
                    update = false;

                    System.out.println();
                    DesignModel.printLine();
                }

                case 1 -> {
                    System.out.println("\n\t\tCurrent Name : " + selectedTask.getTaskName());
                    System.out.print("\t\tEnter the new Issue Name : ");
                    String chat;
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validation.messageValidation(chat)){
                        selectedTask.setTaskName(chat);
                    }
                }

                case 2 -> {
                    System.out.println("\n\t\tCurrent Deadline : " + selectedTask.getDeadline());
                    String deadline;
                    do {
                        System.out.print("\t\t\tIssue Deadline (Date format : dd-MM-yyyy) : ");
                        deadline = scanner.next();

                    } while (!Validation.deadlineDateValidation(selectedProject.getDeadline(), deadline));

                    selectedTask.setDeadline(deadline);
                }

                case 3 -> {
                    System.out.println("\n\t\tCurrent Description : " + selectedTask.getDescription());
                    System.out.print("\t\tEnter the new Description : ");
                    String description;
                    //scanner.nextLine();
                    description = scanner.nextLine();
                    System.out.print("");

                    selectedTask.setDescription(description);
                }

                case 4 -> {
                    System.out.println("\n\t\tCurrent Priority : " + selectedTask.getTaskPriority());
                    System.out.print("\t\tEnter the new New Priority S.no : ");

                    int i = 0;
                    for(String m : DataModel.getPriority()){
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.print("\t\tChoose Issue Priority! Enter");
                    int priorityChoice = -1;
                    while(true) {
                        while (priorityChoice == -1) {
                            System.out.print("\t\t S.no: ");
                            priorityChoice = Validation.numberCheck(scanner);
                        }

                        if (priorityChoice < 1 || priorityChoice > DataModel.getPriority().size()) {
                            System.out.println("\n\t\t S.no not found!");
                        } else {
                            break;
                        }
                    }

                    selectedTask.setTaskPriority(DataModel.getPriority().get(priorityChoice-1));
                }

                case 5 -> {
                    System.out.println("\n\t\tCurrent Status : " + selectedTask.getIssueStatus());
                    System.out.print("\t\tEnter the new New Status S.no : ");

                    int i = 0;
                    for(String m : DataModel.getIssueStatus()){
                        i++;
                        System.out.print("\n\t\t\t S.no : " + i + ". " + m);
                    }
                    System.out.println();
                    DesignModel.printLine();

                    System.out.println("\n\t\tEnter 1 to select a Status. Enter 2 to add Custom Status");
                    int select = -1;
                    while(select == -1){
                        System.out.print("\t\t\t Enter your Choice : ");
                        select = Validation.numberCheck(scanner);
                        if(select < 1 || select > 2){
                            System.out.println("\t\tWrong input! Enter 1 or 2");
                            select = -1;
                        }
                    }
                    if(select ==1){
                        System.out.print("\t\tChoose Issue Status! Enter");
                        int priorityChoice = -1;
                        while(true) {
                            while (priorityChoice == -1) {
                                System.out.print("\t\t S.no: ");
                                priorityChoice = Validation.numberCheck(scanner);
                            }

                            if (priorityChoice < 1 || priorityChoice > DataModel.getIssueStatus().size()) {
                                System.out.println("\n\t\t S.no not found!");
                            } else {
                                break;
                            }
                        }

                        selectedTask.setIssueStatus(DataModel.getIssueStatus().get(priorityChoice-1));
                        if(DataModel.getIssueStatus().get(priorityChoice-1).equalsIgnoreCase("Submitted for test")){
                            selectedProject.getTester().getAssignedTasks().add(selectedTask);
                        }
                    } else{
                        System.out.print("\t\tEnter the custom Status : ");
                        String chat;
                        //scanner.nextLine();
                        chat = scanner.nextLine();
                        System.out.print("");

                        DataModel.getIssueStatus().add(chat);
                        selectedTask.setIssueStatus(chat);
                    }

                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");
            }
        }

    }

    public void viewIssue(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tView the Project tasks");
        System.out.println();

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else {
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
            int i = 0;
            for (Project project : projectArrayList) {

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            int choice;

            while (true) {
                System.out.print("\n\t\tEnter the s.no of the Project which you want to View Tasks : ");
                choice = Validation.numberCheck(scanner);
                if (choice > 0 && choice <= projectArrayList.size()) {
                    break;
                } else {
                    System.out.println("\t\tWrong input");
                }
            }

            Project selectedProject = projectArrayList.get(choice - 1);


            if (selectedProject.getIssueArrayList().size() == 0) {
                System.out.println("\t\t\tNo task is created yet!");
            } else {
                i = 0;
                System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                for (Issue task : selectedProject.getIssueArrayList()) {
                    i++;
                    System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getIssueStatus(), task.getDescription());
                }

                DesignModel.printLine();

                System.out.println("\n\t\tDo you want to update Task Details? Enter 1 to yes, Enter -1 to no");
                int ver;
                while (true) {
                    System.out.print("\t\tEnter your choice : ");
                    ver = Validation.numberCheck(scanner);
                    if (ver == -2 || ver == 1) {
                        break;
                    } else {
                        System.out.println("\t\tWrong input");
                    }
                }

                if (ver == 1) {
                    updateIssueDetails(selectedProject);
                }
            }
        }
    }

    public int readDiscussionBox(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tCHAT BOX");
        if(getProjectArrayList().size() == 0){
            System.out.println("\t\tNo chatBoxes are available for you!");
            return -1;
        }
        System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
        int i = 0;
        for (Project project : projectArrayList) {

            i++;
            System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
        }
        DesignModel.printLine();

        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Project which you want to add Issues : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=projectArrayList.size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Project selectedProject = projectArrayList.get(choice-1);
        if(selectedProject.getChatBox().size() == 0){
            System.out.println("\t\tChatbox is Empty");
        }
        else{
            for(String msg : selectedProject.getChatBox()){
                System.out.println("\t\t\t" + msg);
            }
        }
        return choice-1;
    }

    // this writeDiscussionBox helps to chat in the discussionBox.
    public void writeDiscussionBox(){

        int chatboxResult = readDiscussionBox();
        while(true){

            if(chatboxResult == -1){
                break;
            }
            else{
                System.out.println("\n\t\t\t Enter 1 to Add a chat.");
                System.out.println("\t\t\t Enter -1 to End chat");

                int choice;
                do {
                    System.out.print("\n\t\tEnter your choice : ");
                    choice = Validation.numberCheck(scanner);
                } while (choice == -1);

                if (choice == -2) {
                    System.out.println();
                    DesignModel.printLine();

                    break;
                } else if (choice == 1) {
                    String chat;
                    System.out.print("\n\t\tYour message : ");
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validation.messageValidation(chat)){
                        getProjectArrayList().get(chatboxResult).getChatBox().add("\t\t\t\tTeamLead -> " + this.memberName + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }

    public int viewFiles(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tFile Folder");
        if(getProjectArrayList().size() == 0){
            System.out.println("\t\tNo File Folder are available for you!");
            return -1;
        }
        System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
        int i = 0;
        for (Project project : projectArrayList) {

            i++;
            System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
        }
        DesignModel.printLine();

        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Project which you want to add Files : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=projectArrayList.size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Project selectedProject = projectArrayList.get(choice-1);
        if(selectedProject.getFileFolder().size() == 0){
            System.out.println("\t\tFileFolder is Empty");
        }
        else{
            for(String msg : selectedProject.getFileFolder()){
                System.out.println("\t\t\t" + msg + "\t\tDownload!");
            }
        }
        return choice-1;
    }

    // this writeDiscussionBox helps to chat in the discussionBox.
    public void inputFiles(){

        int chatboxResult = viewFiles();
        while(true){

            if(chatboxResult == -1){
                break;
            }
            else{
                System.out.println("\n\t\t\t Enter 1 to Add a File.");
                System.out.println("\n\t\t\t Enter 2 to Download a File.");
                System.out.println("\t\t\t Enter -1 to Close");

                int choice;
                do {
                    System.out.print("\n\t\tEnter your choice : ");
                    choice = Validation.numberCheck(scanner);
                } while (choice == -1);

                if (choice == -2) {
                    System.out.println();
                    DesignModel.printLine();

                    break;
                } else if (choice == 1) {
                    String chat;
                    System.out.print("\n\t\tYour FileName : ");
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validation.messageValidation(chat)){
                        File file = new File("E:/Java/projects/taskManagement/src/files/"+chat);
                        if(file.exists()) {
                            System.out.println("\t\tFile Uploaded Successfully");
                            getProjectArrayList().get(chatboxResult).getFileFolder().add("\t\t\t\tTeamLead -> " + this.memberName + " : " + chat);
                        }
                        else{
                            System.out.println("\t\tFile not Found in your Directory");
                        }
                    }
                } else if (choice == 2) {
                    int size = getProjectArrayList().get(chatboxResult).getFileFolder().size();
                    if(size == 0)
                        System.out.println("\t\t\tNo Files are found!");
                    else{
                        int i=0;
                        for(String string : getProjectArrayList().get(chatboxResult).getFileFolder()){
                            i++;
                            System.out.printf("\t\t%s. %s\n", i, string);
                        }

                        int file = 0;

                        while(true){
                            System.out.print("\n\t\tEnter the s.no of the file you want to download : ");
                            file = Validation.numberCheck(scanner);
                            if(file>0 && file<=getProjectArrayList().get(chatboxResult).getFileFolder().size()){
                                break;
                            }
                            else{
                                System.out.println("\t\tWrong input");
                            }
                        }

                        System.out.println("\n\t\t\t" + getProjectArrayList().get(chatboxResult).getFileFolder().get(file-1) + " file Downloaded");
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }

    public void workFlow() {
        Project selectedProject = getProjectArrayList().get(0);

        System.out.println("\n\t\tWorkFlow : \n");

        for(Task task : selectedProject.getProgressArrayList()){
            System.out.printf("\t\t\t\tName : %s \tPriority : %s \tStatus : %s\n", task.getTaskName(), task.getTaskPriority(), task.getTaskStatus());
            char arrow = '\u2193';
            System.out.println("\t\t\t\t\t"+arrow);
        }
    }

    public void viewDashboard(){
        System.out.println("\n\t\tDashboard!\n");
        System.out.println("\n\t\t\tCurrently working Tasks : \n");

        int i=0;
        for(Task task : getProjectArrayList().get(0).getTaskArrayList()){
            i++;
            if(task.getTaskStatus().equalsIgnoreCase("Implementation") || task.getTaskStatus().equalsIgnoreCase("Optimization") || task.getTaskStatus().equalsIgnoreCase("Designing") || task.getTaskStatus().equalsIgnoreCase("Requirement Analysis")){
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
            }
        }

        i = 0;
        System.out.println("\n\t\t\t Not Started Tasks : \n");
        for(Task task : getProjectArrayList().get(0).getTaskArrayList()){
            i++;
            if(task.getTaskStatus().equalsIgnoreCase("Not yet Started")){
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
            }
        }

        this.workFlow();
    }


    public void teamLeadWork(){
        System.out.println("\n\t\tWelcome : " + this.getMemberName().toUpperCase());

        while(true) {
            this.viewDashboard();
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Add tasks to the Project");
            System.out.println("\t\t\t Enter 2 to Add Issues to the Project");
            System.out.println("\t\t\t Enter 3 to View/Update details of Tasks");
            System.out.println("\t\t\t Enter 4 to View/Update details of Issues");
            System.out.println("\t\t\t Enter 5 to Create Own Tasks");
            System.out.println("\t\t\t Enter 6 to View/Update Own Tasks");
            System.out.println("\t\t\t Enter 7 for DiscussionBox");
            System.out.println("\t\t\t Enter 8 to Add Files");
            System.out.println("\t\t\t Enter -1 to Logout\n");

            int adminChoice = -1;
            while (adminChoice == -1) {
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validation.numberCheck(scanner);
            }


            switch (adminChoice) {
                case -2 -> this.exitVerification();
                case 0 -> this.changePassword();
                case 1 -> this.createTasks();
                case 2 -> this.createIssues();
                case 3 -> this.viewTask();
                case 4 -> this.viewIssue();
                case 5 -> this.createOwnTasks();
                case 6 -> this.viewOwnTasks();
                case 7 -> this.writeDiscussionBox();
                case 8 -> this.inputFiles();

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }
        }
    }
}
