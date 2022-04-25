package users;

import activities.Validation;
import models.DataModel;
import models.DesignModel;
import objects.Issue;
import objects.Project;
import objects.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends TeamMember{

    String organisationName;
    ArrayList<TeamMember> companyMembers = new ArrayList<>();
    ArrayList<Task> createdTasks = new ArrayList<>();
    ArrayList<Issue> createdIssue = new ArrayList<>();

    ArrayList<TeamLead> teamLeads = new ArrayList<>();
    Tester tester = new Tester("", "", "");

    ArrayList<Project> projectArrayList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public Manager(){}

    public Manager(String memberName, String memberEmail, String memberPassword, String organisationName) {
        super(memberName, memberEmail, memberPassword);
        this.organisationName = organisationName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public ArrayList<TeamMember> getCompanyMembers() {
        return companyMembers;
    }

    public void setCompanyMembers(ArrayList<TeamMember> companyMembers) {
        this.companyMembers = companyMembers;
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

    public ArrayList<TeamLead> getTeamLeads() {
        return teamLeads;
    }

    public void setTeamLeads(ArrayList<TeamLead> teamLeads) {
        this.teamLeads = teamLeads;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    @Override
    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    @Override
    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    public void addMembersToTheCompany(){
        String name, password, email;

        System.out.println();
        DesignModel.printLine();
        System.out.println("\t\tAdd a User to Your Team");

        System.out.print("\t\t\tEnter Name of the User : ");
        name = scanner.nextLine();
        System.out.print("");

        System.out.print("\t");
        email = Validation.emailValidation();

        System.out.print("\t\t\tEnter Temporary Password : ");
        password = scanner.next();

        TeamMember member = new TeamMember(name, email, password);
        this.getCompanyMembers().add(member);
        System.out.println("\t\tUser added to the Organisation");
        DesignModel.printLine();
    }

    public void createProjects(){

        String projectName, description, deadline;
        ArrayList<TeamMember> memberArrayList = new ArrayList<>();

        ArrayList<TeamMember> memberEligibleForTester = new ArrayList<>();

        //ArrayList<Task> taskArrayList;

        System.out.println();
        DesignModel.printLine();
        System.out.println("\t\tCreate a Project");

        System.out.print("\t\t\tEnter Name of the Project : ");
        projectName = scanner.nextLine();
        System.out.print("");
        System.out.print("\t\t\tProduct Description : ");
        scanner.nextLine();
        description = scanner.nextLine();
        System.out.print("");

        do {
            System.out.print("\t\t\tProject Deadline (Date format : dd-MM-yyyy) : ");
            deadline = scanner.next();

        } while (!Validation.dateValidation(deadline));


        System.out.print("\n\t\t\tEnter the ID number of the users you want for this project\n\t\t\tEnter -1 to stop. ");
        int i=0;
        for(TeamMember m : getCompanyMembers()){
            i++;
            System.out.print("\n\t\t S.no : " + i + ". Name : " + m.getMemberName());
        }

        System.out.println("\n\t\tEnter your choices\n");
        int memberChoice = -1;
        while(true){
            while(memberChoice == -1){
                System.out.print("\t\t S.no: ");
                memberChoice = Validation.numberCheck(scanner);
            }

            if(memberChoice == -2){
                break;
            }
            else if(memberChoice<1 || memberChoice>getCompanyMembers().size()){
                System.out.println("\n\t\t S.no not found!");
                memberChoice = -1;
                continue;
            }
            memberArrayList.add(getCompanyMembers().get(memberChoice-1));
            memberEligibleForTester.add(getCompanyMembers().get(memberChoice-1));
            getCompanyMembers().get(memberChoice-1).setMemberStatus("Closed");
            memberChoice = -1;
        }

        System.out.println();
        DesignModel.printLine();
        System.out.println("\t\tMembers Added to the Project : ");

        if(memberArrayList.size() == 0){
            Project project = new Project(projectName, description, deadline);
            projectArrayList.add(project);
            System.out.println("\n\t\tProject created!");
            return;
        }
        else {
            i = 0;
            for (TeamMember m : memberArrayList) {
                i++;
                System.out.print("\n\t\t\t S.no : " + i + ". Name : " + m.getMemberName());
            }
            System.out.println();
            DesignModel.printLine();

            System.out.print("\t\tChoose your ProjectLead/ ProjectLeads! Enter -1 to stop. Enter their");
            memberChoice = -1;
            while (true) {
                while (memberChoice == -1) {
                    System.out.print("\t\t S.no: ");
                    memberChoice = Validation.numberCheck(scanner);
                }

                if (memberChoice == -2) {
                    break;
                } else if (memberChoice < 1 || memberChoice > memberArrayList.size()) {
                    System.out.println("\n\t\t S.no not found!");
                    memberChoice = -1;
                    continue;
                }
                TeamMember mem = memberArrayList.get(memberChoice - 1);
                memberEligibleForTester.remove(mem);

                TeamLead lead = new TeamLead(mem);
                //teamLeads.add(lead);
                getTeamLeads().add(lead);
                memberChoice = -1;
            }

            System.out.println();
            DesignModel.printLine();
            System.out.println("\t\tMembers Added to the Project Except TeamLeaders: ");

            i = 0;
            for (TeamMember m : memberEligibleForTester) {
                i++;
                System.out.print("\n\t\t\t S.no : " + i + ". Name : " + m.getMemberName());
            }
            System.out.println();
            DesignModel.printLine();
        }

        if(memberEligibleForTester.size() == 0){

            Project project = new Project(projectName, description, deadline, memberArrayList, teamLeads);
            System.out.println("\n\t\tProject created!");
            for(TeamLead lead : teamLeads){
                System.out.print("Hi");
                lead.getProjectArrayList().add(project);
            }

            projectArrayList.add(project);
            for(TeamMember m : memberArrayList){
                m.getProjectArrayList().add(project);
            }
            return;
        }
        else{
            System.out.print("\t\tChoose your Tester");
            memberChoice = -1;
            while(true){
                while(memberChoice == -1){
                    System.out.print("\t\t S.no: ");
                    memberChoice = Validation.numberCheck(scanner);
                }

                if(memberChoice<1 || memberChoice>memberEligibleForTester.size()){
                    System.out.println("\n\t\t S.no not found!");
                    memberChoice = -1;
                }
                else{
                    break;
                }
            }
            //System.out.println(memberChoice);
            TeamMember mem = memberEligibleForTester.get(memberChoice-1);
            memberArrayList.remove(mem);
            Tester test = new Tester(mem);
            this.setTester(test);
        }


        Project project = new Project(projectName, description, deadline, memberArrayList, teamLeads,tester);

        System.out.println("\n\t\tProject created!");
        for(TeamLead lead : teamLeads){
            //System.out.println("Hi");
            lead.getProjectArrayList().add(project);
        }

        projectArrayList.add(project);
        for(TeamMember m : memberArrayList){
            m.getProjectArrayList().add(project);
        }

        tester.getProjectArrayList().add(project);

        DesignModel.printLine();
    }

    public void addMembersToProject(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tProject Details\n");

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else {
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");

            int i =0;
            for (Project project : projectArrayList) {

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            int choice;

            while(true){
                System.out.print("\n\t\tEnter the s.no of the Project which you want to add user : ");
                choice = Validation.numberCheck(scanner);
                if(choice>0 && choice<=projectArrayList.size()){
                    break;
                }
                else{
                    System.out.println("\t\tWrong input");
                }
            }

            Project selectedProject = projectArrayList.get(choice-1);

            ArrayList<TeamMember> additionMemberArrayList = getCompanyMembers();
            Tester tester = selectedProject.getTester();

            for(TeamMember member : selectedProject.getTeamMemberArrayList()) {
                additionMemberArrayList.remove(member);
            }
            for(TeamMember member : additionMemberArrayList){
                if(tester.getMemberEmail().equalsIgnoreCase(member.getMemberEmail())){
                    additionMemberArrayList.remove(member);
                    break;
                }
            }


            System.out.print("\n\t\t\tEnter the ID number of the users you want for this project\n\t\t\tEnter -1 to stop. ");
            i=0;
            for(TeamMember m : additionMemberArrayList){

                i++;
                System.out.print("\n\t\t S.no : " + i + ". Name : " + m.getMemberName());


            }

            System.out.println("\n\t\tEnter your choices\n");
            int memberChoice = -1;
            while(true){
                while(memberChoice == -1){
                    System.out.print("\t\t S.no: ");
                    memberChoice = Validation.numberCheck(scanner);
                }

                if(memberChoice == -2){
                    break;
                }
                else if(memberChoice<1 || memberChoice>additionMemberArrayList.size()){
                    System.out.println("\n\t\t S.no not found!");
                    memberChoice = -1;
                    continue;
                }
                selectedProject.getTeamMemberArrayList().add(additionMemberArrayList.get(memberChoice-1));
                memberChoice = -1;
            }
            System.out.println("\n\t\tMembers Added to the Project!");

            System.out.println();
            DesignModel.printLine();

        }
    }

    public void editProjectDetails(){
        int choice;

        while(true){
            System.out.print("\n\t\tEnter the s.no of the Project which you want to update : ");
            choice = Validation.numberCheck(scanner);
            if(choice>0 && choice<=projectArrayList.size()){
                break;
            }
            else{
                System.out.println("\t\tWrong input");
            }
        }

        Project selectedProject = projectArrayList.get(choice-1);

        boolean update = true;
        while(update){
            System.out.println("\n\t\t\tEnter the s.no of credential you want to change!");
            System.out.println("\t\t\t Enter 1 to Project Name ");
            System.out.println("\t\t\t Enter 2 to Project Deadline");
            System.out.println("\t\t\t Enter 3 to Project Description");
            System.out.println("\t\t\t Enter 4 to Project Status");
            //System.out.println("\t\t\t Enter 5 to Project Deployment Status");
            System.out.println("\t\t\t Enter -1 to back\n");

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
                    System.out.println("\n\t\tCurrent Name : " + selectedProject.getProjectName());
                    System.out.print("\t\tEnter the new Project Name : ");
                    String chat;
                    //scanner.nextLine();
                    chat = scanner.nextLine();
                    System.out.print("");

                    if(Validation.messageValidation(chat)){
                        selectedProject.setProjectName(chat);
                    }
                }

                case 2 -> {
                    System.out.println("\n\t\tCurrent Deadline : " + selectedProject.getDeadline());
                    String deadline;
                    do {
                        System.out.print("\t\t\tProject Deadline (Date format : dd-MM-yyyy) : ");
                        deadline = scanner.next();

                    } while (!Validation.dateValidation(deadline));

                    selectedProject.setDeadline(deadline);
                }

                case 3 -> {
                    System.out.println("\n\t\tCurrent Description : " + selectedProject.getDescription());
                    System.out.print("\t\tEnter the new Project Name : ");
                    String description;
                    //scanner.nextLine();
                    description = scanner.nextLine();
                    System.out.print("");

                    selectedProject.setDescription(description);
                }

                case 4 -> {
                    int i=0;
                    for(String stat : DataModel.getModelProjectStatus()){
                        i++;
                        System.out.println("\t\t" + i + ". " + stat);
                    }

                    int status=-1;
                    while(status == -1){
                        System.out.print("\t\t\t Enter your Choice : ");
                        status = Validation.numberCheck(scanner);
                        if(status > DataModel.getModelProjectStatus().size() || status < 1){
                            System.out.println("\t\t Wrong input!");
                        }
                    }

                    System.out.println("\n\t\tCurrent Status : " + selectedProject.getProjectStatus());
                    System.out.print("\t\tEnter the S.no :");

                    selectedProject.setProjectStatus(DataModel.getModelProjectStatus().get(status-1));
                }

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");
            }
        }

    }

    public void viewProjects(){
        System.out.println();
        DesignModel.printLine();

        System.out.println("\t\tProject Details\n");

        if(projectArrayList.size() == 0){
            System.out.print("\t\tNo Projects found!\n");
            DesignModel.printLine();
        }
        else{
            System.out.printf("\n\t\t%15s %15s %15s %25s %35s\n", "S.no", "ProjectName", "Deadline", "Status", "Description");
            int i=0;
            for(Project project : projectArrayList){

                i++;
                System.out.printf("\t\t%15s %15s %15s %25s %35s\n", i, project.getProjectName(), project.getDeadline(), project.getProjectStatus(), project.getDescription());
            }
            DesignModel.printLine();

            System.out.println("\n\t\tDo you want to update Project Details? Enter 1 to yes, Enter -1 to no");
            int ver;
            while(true){
                System.out.print("\t\tEnter your choice : ");
                ver = Validation.numberCheck(scanner);
                if(ver == -2 || ver == 1) {
                    break;
                }
                else{
                    System.out.println("\t\tWrong input");
                }
            }

            if(ver == 1){
                editProjectDetails();
            }
        }

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
                    taskName = scanner.next();
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
                            priorityChoice = -1;
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
                    taskName = scanner.next();
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
                        getProjectArrayList().get(chatboxResult).getChatBox().add("\t\t\t\tManager -> " + this.memberName + " : " + chat);
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
                        getProjectArrayList().get(chatboxResult).getFileFolder().add("\t\t\t\tTeamLead -> " + this.memberName + " : " + chat);
                    }
                } else {
                    System.out.println("\t\tWrong number. check your Input!\n");
                }
            }
        }
    }


    public void managerWorks(){
        companyMembers.add(new TeamMember("member1", "member1@gmail.com", "member1"));
        companyMembers.add(new TeamMember("member2", "member2@gmail.com", "member2"));
        companyMembers.add(new TeamMember("member3", "member3@gmail.com", "member3"));
        companyMembers.add(new TeamMember("member4", "member4@gmail.com", "member4"));
        companyMembers.add(new TeamMember("member5", "member5@gmail.com", "member5"));
        companyMembers.add(new TeamMember("member6", "member6@gmail.com", "member6"));
        companyMembers.add(new TeamMember("member7", "member7@gmail.com", "member7"));
        companyMembers.add(new TeamMember("member8", "member8@gmail.com", "member8"));
        companyMembers.add(new TeamMember("member9", "member9@gmail.com", "member9"));
        companyMembers.add(new TeamMember("member10", "member10@gmail.com", "member10"));

        System.out.println("\n\t\tWelcome Manager : " + this.getMemberName().toUpperCase());

        while(true){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Add a User to your Organisation");
            System.out.println("\t\t\t Enter 2 to Create a new Project");
            System.out.println("\t\t\t Enter 3 to Add Member to your Project");
            System.out.println("\t\t\t Enter 4 to View/Update Details of Projects");
            System.out.println("\t\t\t Enter 5 to Add Tasks");
            System.out.println("\t\t\t Enter 6 to Add Issues");
            System.out.println("\t\t\t Enter 7 to Create Own Tasks");
            System.out.println("\t\t\t Enter 8 to View/Update Own Tasks");
            System.out.println("\t\t\t Enter 9 for DiscussionBox");
            System.out.println("\t\t\t Enter 10 to Add Files");
            System.out.println("\t\t\t Enter -1 to Logout\n");

            int adminChoice=-1;
            while(adminChoice == -1){
                System.out.print("\t\t\t Enter your Choice : ");
                adminChoice = Validation.numberCheck(scanner);
            }


            switch (adminChoice) {
                case -2 -> this.exitVerification();

                case 0 -> this.changePassword();
                case 1 -> this.addMembersToTheCompany();
                case 2 -> this.createProjects();
                case 3 -> this.addMembersToProject();
                case 4 -> this.viewProjects();
                case 5 -> this.createTasks();
                case 6 -> this.createIssues();
                case 7 -> this.createOwnTasks();
                case 8 ->this.viewOwnTasks();
                case 9 -> this.writeDiscussionBox();
                case 10 -> this.inputFiles();

                default -> System.out.println("\n\tWrong value. Give correct input number!\n");

            }
        }

    }
}
