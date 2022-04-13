import designs.Models;
import designs.Ui;
import objects.LoginSignUpPage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Models.setManagers();
        Models.setMembers();

        Ui.printTitle();
        LoginSignUpPage.loginDisplay(scanner);

    }
}
