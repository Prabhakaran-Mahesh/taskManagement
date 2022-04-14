package users;

import designs.Models;
import designs.Ui;

import java.util.Scanner;

public class Manager extends Member{
    public Manager() {
        super();
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    static void createUser(Scanner keyboard){

        String name, password, email;

        System.out.println();
        Ui.printLine();
        System.out.println("\t\tAdd a User to Your Team");

        System.out.print("\t\t\tEnter Name of the User : ");
        name = keyboard.next();
        System.out.print("\t\t\tEnter Email Id of the User : ");
        email = keyboard.next();
        System.out.print("\t\t\tEnter Temporary Password : ");
        password = keyboard.next();

        Member member = new Member(name, email, password);
        Models.members.add(member);
        System.out.println("\t\tUser added to the team");
        Ui.printLine();
    }

    public void workOfManager(Scanner scanner){
        int adminChoice;
        System.out.println("\n\t\tWelcome back " + name.toUpperCase());

        boolean check = true;
        while(check){
            System.out.println("\n\t\tWhat would you like to do :");

            System.out.println("\n\t\t\t Enter 0 to Change Password");
            System.out.println("\t\t\t Enter 1 to Add a User to your team");
            System.out.println("\t\t\t Enter 2 to Create a new Project");
            System.out.println("\t\t\t Enter -1 to Exit\n");

            System.out.print("\t\t\t Enter your Choice : ");
            adminChoice = scanner.nextInt();

            switch (adminChoice){

                case -1 : {
                    this.exitVerification(scanner);
                    continue;
                }

                case 0 : {
                    this.changePassword(scanner);
                    break;
                }

                case 1 : {
                    createUser(scanner);
                    break;
                }

                case 2 : {
                    //createProject();
                }
            }

        }
    }
}
