package activities;


import models.DataModel;
import models.DesignModel;
import users.Manager;
import users.TeamLead;
import users.TeamMember;
import users.Tester;

import java.util.Scanner;

public class Login {
    static Scanner scanner = new Scanner(System.in);

    /*
    -> login verification method is used to verify the login credentials of the user.
    -> this method is used to check the credentials, ie. name, password
    -> the method takes in email and password and search all the arraylist accordingly to find the user type.
     */
    private static boolean loginVerification(String email, String password){

        for (Manager manager : DataModel.getManagerArrayList()) {
            if (manager.getMemberPassword().equals(password) && manager.getMemberEmail().equals(email)) {
                manager.managerWorks();
                return true;
            }
            else if(manager.getMemberEmail().equals(email)){
                System.out.println("\n\t\tIncorrect Password");
                return false;
            }
        }

        for (Tester tester : DataModel.getTesters()) {
            if (tester.getMemberPassword().equals(password) && tester.getMemberEmail().equals(email)) {
                tester.testerWorks();
                return true;
            }
            else if(tester.getMemberEmail().equals(email)){
                System.out.println("\n\t\tIncorrect Password");
                return false;
            }
        }

        for (TeamLead teamLead : DataModel.getTeamLeads()) {
            if (teamLead.getMemberPassword().equals(password) && teamLead.getMemberEmail().equals(email)) {
                teamLead.teamLeadWork();
                return true;
            }
            else if(teamLead.getMemberEmail().equals(email)){
                System.out.println("\n\t\tIncorrect Password");
                return false;
            }
        }
        for (TeamMember teamMember : DataModel.getTeamMembers()) {
            if (teamMember.getMemberPassword().equals(password) && teamMember.getMemberEmail().equals(email)) {
                teamMember.teamMemberWork();
                return true;
            }
            else if(teamMember.getMemberEmail().equals(email)){
                System.out.println("\n\t\tIncorrect Password");
                return false;
            }
        }

        System.out.println("\n\t\tCheck your Credentials");
        return false;

    }

    /*
    -> this is the main login method.
    -> gets input and checks input and process are done
     */
    public static void loginMethod() {
        boolean verification = false; // for calling loginVerification function
        int limit = 3; // if the user hits wrong credentials for 3 times. the application ends

        String email="", password;
        //String type;

        // loop stops when correct credentials are given or when attempts exceed 3 times.
        while(!verification){

            limit--;
            if(limit == -1){
                System.out.println("\n\t\tYou have attempted 3 times with wrong credentials!\n");
                DesignModel.printLine();
                System.exit(0);
            }
            else if(limit<2){
                System.out.println("\t\tYou have " + (limit+1) + " more attempts left\n");
            }

            System.out.println();
            DesignModel.printLine();
            System.out.println();

            System.out.print("\t\tEnter Email ID : ");
            email = scanner.next();

            System.out.print("\t\tEnter Password : ");
            //password = String.valueOf(console.readPassword());
            password = scanner.next();

            verification = loginVerification(email, password);

        }
    }

}

