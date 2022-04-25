package activities;


import models.DataModel;
import models.DesignModel;
import users.Manager;

import java.util.Scanner;

public class Registration {

    public static Scanner scanner = new Scanner(System.in);
    /*
    -> Registration method
    -> Only manager role can register and other roles cannot register directly
     */
    public static void signupMethod() {
        Manager manager = new Manager();


        String email, password, name, organisation;
        System.out.println();
        DesignModel.printLine();

        System.out.println("\tManager Registration");
        System.out.println();


        System.out.print("\t\tEnter your Name : ");
        name = scanner.next();

        email = Validation.emailValidation();

        System.out.print("\t\tEnter Password : ");
        password = scanner.next();

        System.out.print("\t\tEnter Organisation Name : ");
        organisation = scanner.next();

        System.out.println("\t\tYou have successfully created your Manager Account\n");

        manager.setMemberName(name);
        manager.setMemberEmail(email);
        manager.setMemberPassword(password);
        manager.setOrganisationName(organisation);

        DataModel.getManagerArrayList().add(manager);

        manager.managerWorks();
    }
}

