package activities;

import designs.Models;
import designs.Ui;
import users.Manager;
import users.Member;
import users.TeamLead;

import java.util.Scanner;

public class Login {

    /*
    -> login verification method is used to verify the login credentials of the user.
    -> this method is used to check the credentials, ie. name, password type
     */
    private static boolean loginVerification(String email, String password, String type){


        if(type.equalsIgnoreCase("manager")) {
            for (Manager x : Models.getManagers()) {
                if (x.getPassword().equals(password) && x.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        else if(type.equalsIgnoreCase("member")){
            //System.out.println("Hello");
            for (Member x : Models.members) {
                if (x.getPassword().equals(password) && x.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        else if(type.equalsIgnoreCase("teamlead")){
            //System.out.println("Hello");
            for (TeamLead x : Models.teamLeads) {
                if (x.getPassword().equals(password) && x.getEmail().equals(email)) {
                    return true;
                }
            }
        }


        System.out.println("\t\tCheck Your Email and Password and Type");
        return false;
    }

    /*
    -> this is the main login method.
    -> gets input and checks input and process are done
     */
    public static void loginMethod(Scanner scanner) {
        boolean verification = false; // for calling loginVerification function
        int limit = 3; // if the user hits wrong credentials for 3 times. the application ends

        String email="", password, type="";

        // loop stops when correct credentials are given or when attempts exceed 3 times.
        while(!verification){

            limit--;
            if(limit == -1){
                System.out.println("\n\t\tYou have attempted 3 times with wrong credentials!\n");
                Ui.printLine();
                System.exit(0);
            }
            else if(limit<2){
                System.out.println("\n\t\tYou have " + (limit+1) + " more attempts left\n");
            }

            System.out.println();
            Ui.printLine();
            System.out.println();

            System.out.print("\t\tEnter Email ID : ");
            email = scanner.next();

            System.out.print("\t\tEnter Password : ");
            //password = String.valueOf(console.readPassword());
            password = scanner.next();

            System.out.print("\t\tEnter Type of your Work : ");
            type = scanner.next();

            verification = loginVerification(email, password, type);

        }
        moveToChoiceDecider(type, email, scanner);
    }

    /*
    ->after verification of credentials
    -> credentials are passed to this method to make the user move into their respective field
     */
    public static void moveToChoiceDecider(String type, String email, Scanner scanner) {

        System.out.println();
        Ui.printLine();

        if (type.equalsIgnoreCase("manager")) {
            for (Manager manager : Models.getManagers()) {
                if (manager.getEmail().equals(email)) {
                    manager.workOfManager(scanner);
                }
            }
        } else if (type.equalsIgnoreCase("member")) {
            for (Member users : Models.getMembers()) {
                if (users.getEmail().equals(email)) {
                    users.workOfMember(scanner);
                }
            }
        } else if (type.equalsIgnoreCase("teamlead")) {
            for (TeamLead teamLead : Models.getTeamLeads()) {
                if (teamLead.getEmail().equals(email)) {
                    teamLead.workOfTeamLead();
                }
            }
        }
    }

}
