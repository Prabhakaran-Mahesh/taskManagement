import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        //invoking the static models
        Models.setManagers();
        Models.setMembers();
        Models.setStatus();

        //title card and loginPage
        Ui.printTitle();
        LoginSignUpPage.loginDisplay(scanner);

    }
}
