package users;

import activities.Validation;
import activities.WelcomePage;
import models.DataModel;
import models.DesignModel;
import objects.Issue;
import objects.Project;
import objects.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamMember {
    String memberName;
    String memberEmail;
    String memberPassword;
    String memberStatus;

    ArrayList<Task> assignedTasks = new ArrayList<>();
    ArrayList<Issue> assignedIssues = new ArrayList<>();
    ArrayList<Task> ownTasks = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    ArrayList<Project> projectArrayList = new ArrayList<>();

    public TeamMember() {
    }

    public TeamMember(String memberName, String memberEmail, String memberPassword) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberStatus = "Open to Projects";
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public ArrayList<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(ArrayList<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public ArrayList<Task> getOwnTasks() {
        return ownTasks;
    }

    public void setOwnTasks(ArrayList<Task> ownTasks) {
        this.ownTasks = ownTasks;
    }

    public ArrayList<Issue> getAssignedIssues() {
        return assignedIssues;
    }

    public void setAssignedIssues(ArrayList<Issue> assignedIssues) {
        this.assignedIssues = assignedIssues;
    }

    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    public void exitVerification(){
        String exit;
        while(true){
            System.out.print("\t\tAre you sure, Do you want to Logout? yes/no : ");
            exit = scanner.next();
            if(exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("no")){
                break;
            }
            else{
                System.out.println("\n\t\tInvalidInput\n");
                DesignModel.printLine();
                System.out.println("\n");
            }
        }

        if("yes".equalsIgnoreCase(exit)){
            //Todo: report sending
            //sendReport();
            System.out.println();
            DesignModel.printLine();
            WelcomePage.loginDisplay();
            System.exit(0);

        }
        else{
            System.out.println();
            DesignModel.printLine();

        }
    }

    public void changePassword(){
        String oldPassword, newPassword;
        System.out.println();
        DesignModel.printLine();
        System.out.println("\t\tPassword Change");
        System.out.print("\t\t\tEnter your Current Password : ");
        oldPassword = scanner.next();
        if(this.getMemberPassword().equals(oldPassword)){
            System.out.print("\t\t\tEnter your New Password : ");
            //newPassword = String.valueOf(console.readPassword());;
            newPassword = scanner.next();

            this.setMemberPassword(newPassword);
            System.out.println("\t\tPassword Altered");
            DesignModel.printLine();
        }
        else{
            System.out.println("\t\tOld Password Incorrect");
            DesignModel.printLine();
        }
    }

    private void updateAssignedTaskDetails(ArrayList<Task> tasks){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Task which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=getAssignedTasks().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Task selectedTask = tasks.get(choice-1);

        System.out.println("\n\t\tCurrent Status : " + selectedTask.getTaskStatus());
        System.out.print("\t\tEnter the new New Priority S.no : ");

        int i = 0;
        for(String m : DataModel.getMemberTaskStatus()){
            i++;
            System.out.print("\n\t\t\t S.no : " + i + ". " + m);
        }
        System.out.println();
        DesignModel.printLine();

        System.out.print("\t\tChoose task Status! Enter");
        int priorityChoice = -1;
        while(true) {
            while (priorityChoice == -1) {
                System.out.print("\t\t S.no: ");
                priorityChoice = Validation.numberCheck(scanner);
            }

            if (priorityChoice < 1 || priorityChoice > DataModel.getMemberTaskStatus().size()) {
                System.out.println("\n\t\t S.no not found!");
            } else {
                break;
            }
        }

        selectedTask.setTaskStatus(DataModel.getMemberTaskStatus().get(priorityChoice-1));
    }

    public void viewAssignedTask(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tView the Assigned tasks");
        System.out.println();


        if (getAssignedTasks().size() == 0) {
            System.out.println("\t\t\tNo task is created yet!");
        } else {
            int i = 0;
            System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
            for (Task task : getAssignedTasks()) {
                i++;
                System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
            }

            DesignModel.printLine();

            //System.out.println("\n\t\tDo you want to update Task Details? Enter 1 to yes, Enter -1 to no");
            System.out.println("\t\t1. Update Tasks");
            System.out.println("\t\t2. Search Task By Criteria");
            System.out.println("\t\t3. Go back");

            int ver;
            while (true) {
                System.out.print("\t\tEnter your choice : ");
                ver = Validation.numberCheck(scanner);
                if (ver == -2 || ver == 1 || ver == 2) {
                    break;
                } else {
                    System.out.println("\t\tWrong input");
                }
            }

            if (ver == 1) {
                updateAssignedTaskDetails(getAssignedTasks());
            }
            else if(ver == 2){
                ArrayList<Task> filteredTasks = new ArrayList<>();

                System.out.println("\t\t\t Key words that can be searched");
                System.out.println("\t\t\t\tTask Name");
                //System.out.println("\t\t\t\tNot yet Started");
                for(String stat : DataModel.getTaskStatus()){
                    System.out.println("\t\t\t\t" + stat);
                }
                for(String prior : DataModel.getPriority()){
                    System.out.println("\t\t\t\t" + prior);
                }

                System.out.print("\n\t\tEnter the value you want to Search : ");
                String enteredSearchValue = scanner.nextLine();
                System.out.print("");


                for (Task task : getAssignedTasks()) {
                    if (task.getTaskName().equalsIgnoreCase(enteredSearchValue)) {
                        filteredTasks.add(task);
                    } else if (task.getTaskStatus().equalsIgnoreCase(enteredSearchValue)) {
                        filteredTasks.add(task);
                    } else if (task.getTaskPriority().equalsIgnoreCase(enteredSearchValue)) {
                        filteredTasks.add(task);
                    }
                }

                if(filteredTasks.size()==0){
                    System.out.println("\t\tNo tasks are found under the given criteria : " + enteredSearchValue);
                }
                else{
                    i=0;
                    System.out.printf("\n\t\t%15s %15s %15s %15s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                    for(Task task : filteredTasks){
                        i++;
                        System.out.printf("\t\t%15s %15s %15s %15s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
                    }

                    System.out.println("\n\t\tDo you want to update Task Details? Enter 1 to yes, Enter -1 to no");

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
                        updateAssignedTaskDetails(filteredTasks);
                    }
                }

            }
            System.out.println();
            DesignModel.printLine();

        }

    }

    private void updateAssignedIssueDetails(){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Issue which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=getAssignedIssues().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Issue selectedTask = getAssignedIssues().get(choice-1);

        System.out.println("\n\t\tCurrent Status : " + selectedTask.getIssueStatus());
        System.out.print("\t\tEnter the new New Priority S.no : ");

        int i = 0;
        for(String m : DataModel.getMemberIssueStatus()){
            i++;
            System.out.print("\n\t\t\t S.no : " + i + ". " + m);
        }
        System.out.println();
        DesignModel.printLine();

        System.out.print("\t\tChoose Issue Status! Enter");
        int priorityChoice = -1;
        while(true) {
            while (priorityChoice == -1) {
                System.out.print("\t\t S.no: ");
                priorityChoice = Validation.numberCheck(scanner);
            }

            if (priorityChoice < 1 || priorityChoice > DataModel.getMemberIssueStatus().size()) {
                System.out.println("\n\t\t S.no not found!");
            } else {
                break;
            }
        }

        selectedTask.setIssueStatus(DataModel.getMemberIssueStatus().get(priorityChoice-1));
        getProjectArrayList().get(0).getProgressArrayList().add(selectedTask);
    }

    public void viewAssignedIssue(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tView the Assigned Issues");
        System.out.println();


        if (getAssignedIssues().size() == 0) {
            System.out.println("\t\t\tNo task is created yet!");
        } else {
            int i = 0;
            System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "IssueName", "Priority", "Deadline", "Status", "Description");
            for (Issue task : getAssignedIssues()) {
                i++;
                System.out.printf("\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getIssueStatus(), task.getDescription());
            }

            DesignModel.printLine();

            System.out.println("\n\t\tDo you want to update Issue Details? Enter 1 to yes, Enter -1 to no");
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
                updateAssignedIssueDetails();
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
            System.out.print("\n\t\tEnter the s.no of the Project which you want to add chat : ");
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
                        getProjectArrayList().get(chatboxResult).getChatBox().add("\t\t\t\t" + this.memberName + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }


    public void createOwnTasks(){
        //ArrayList<Task> taskArrayList = new ArrayList<>();

        System.out.println();
        DesignModel.printLine();

        boolean done = false;
        int choice;
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

                } while (!Validation.dateValidation(taskDeadline));

                System.out.println("\t\tPriority List : ");

                int i = 0;
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
                getOwnTasks().add(task);

            }  else if (choice == -2) {
                //System.out.println("\t\tTasks Added to the task");
                done = true;
                System.out.println();
                DesignModel.printLine();
            } else {
                System.out.println("\t\tWrong number. check your Input!\n");
            }
        }
    }

    public void viewOwnTasks(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tView the Own Tasks");
        System.out.println();


        if (getOwnTasks().size() == 0) {
            System.out.println("\t\t\tNo Own tasks is created yet!");
        } else {
            int i = 0;
            System.out.printf("\n\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
            for (Task task : getOwnTasks()) {
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
                updateOwnTaskDetails();
            }
        }
    }

    private void updateOwnTaskDetails(){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Task which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<= getOwnTasks().size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Task selectedTask = getOwnTasks().get(choice-1);

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

                    } while (!Validation.dateValidation(deadline));

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

                    System.out.print("\t\tChoose task Priority! Enter");
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
                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");
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
            System.out.print("\n\t\tEnter the s.no of the Project which you want to view Files : ");
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
                System.out.println("\t\t\t" + msg);
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

    public void viewDashboard(){
        System.out.println("\n\t\tDashboard!\n");
        System.out.println("\n\t\t\tCurrently working Tasks : \n");

        int i=0;
        for(Task task : getAssignedTasks()){
            i++;
            if(task.getTaskStatus().equalsIgnoreCase("Implementation") || task.getTaskStatus().equalsIgnoreCase("Optimization") || task.getTaskStatus().equalsIgnoreCase("Designing") || task.getTaskStatus().equalsIgnoreCase("Requirement Analysis")){
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
            }
        }

        i = 0;
        System.out.println("\n\t\t\t Not Started Tasks : \n");
        for(Task task : getAssignedTasks()){
            i++;
            if(task.getTaskStatus().equalsIgnoreCase("Not yet Started")){
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", "S.no", "TaskName", "Priority", "Deadline", "Status", "Description");
                System.out.printf("\t\t\t\t%15s %15s %15s %20s %25s %25s\n", i, task.getTaskName(), task.getTaskPriority(), task.getDeadline(), task.getTaskStatus(), task.getDescription());
            }
        }

        //workflow();
    }

    public void teamMemberWork(){
        System.out.println("\n\t\tWelcome : " + this.getMemberName().toUpperCase());

        while(true) {
            this.viewDashboard();
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to View/Update AssignedTask Status");
            System.out.println("\t\t\t Enter 2 to View/Update AssignedIssue Status");
            System.out.println("\t\t\t Enter 3 to Create Own Tasks");
            System.out.println("\t\t\t Enter 4 to View/Update Own Tasks");
            System.out.println("\t\t\t Enter 5 for DiscussionBox");
            System.out.println("\t\t\t Enter 6 to Add files to Project");
            System.out.println("\t\t\t Enter -1 to Logout\n");

            int adminChoice = -1;
            while (adminChoice == -1) {
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validation.numberCheck(scanner);
            }


            switch (adminChoice) {
                case -2 -> this.exitVerification();
                case 0 -> this.changePassword();
                case 1 -> this.viewAssignedTask();
                case 2 -> this.viewAssignedIssue();
                case 3 -> this.createOwnTasks();
                case 4 -> this.viewOwnTasks();
                case 5 -> this.writeDiscussionBox();
                case 6 -> this.inputFiles();
                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }
        }
    }
}
