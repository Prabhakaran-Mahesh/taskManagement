package activities;

import designs.Models;
import designs.Ui;
import users.Manager;

import java.util.Scanner;

public class SignUp {
    /*
    -> Registration method
    -> Only manager role can register and other roles cannot register directly
     */
    public static void signupMethod(Scanner scanner) {
        Manager manager = new Manager();

        String email="", password, name="";
        System.out.println();
        Ui.printLine();
        System.out.println();

        System.out.print("\t\tEnter your Name : ");
        name = scanner.next();

        System.out.print("\t\tEnter Email ID : ");
        email = scanner.next();

        System.out.print("\t\tEnter Password : ");
        //password = String.valueOf(console.readPassword());
        password = scanner.next();

        System.out.println("\t\tYou have successfully created your Manager Account");

        manager.setName(name);
        manager.setEmail(email);
        manager.setPassword(password);
        Models.managers.add(manager);

        Ui.printLine();
    }
}
