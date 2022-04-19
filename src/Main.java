import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;

import java.util.Scanner;

/*
-> the starter class of the task management system application.
-> the program runs from here.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        //invoking the static models
        Models.setManagers();
        Models.setMembers();
        Models.setStatus();
        Models.setPriority();
        Models.setTestingTeams();

        //title card and loginPage
        Ui.printTitle();
        LoginSignUpPage.loginDisplay(scanner);

    }
}
