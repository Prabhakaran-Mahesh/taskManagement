package users;

import activities.Login;
import designs.Ui;
import objects.LoginSignUpPage;

import java.util.Scanner;

public class Member {
    String name;
    String email;
    String password;

    public Member() {
    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void exitVerification(Scanner keyboard){
        String exit;
        while(true){
            System.out.print("\t\tAre you sure, Do you want to exit? yes/no : ");
            exit = keyboard.next();
            if(exit.equalsIgnoreCase("yes") || exit.equalsIgnoreCase("no")){
                break;
            }
            else{
                System.out.println("\n\t\tInvalidInput\n");
                Ui.printLine();
                System.out.println("\n");
            }
        }

        if("yes".equalsIgnoreCase(exit)){
            //Todo: report sending
            //sendReport();
            System.out.println();
            Ui.printLine();
            LoginSignUpPage.loginDisplay(keyboard);
            System.exit(0);

        }
        else{
            System.out.println();
            Ui.printLine();

        }
    }

    public void changePassword(Scanner keyboard) {
        String oldPassword, newPassword;
        System.out.println();
        Ui.printLine();
        System.out.println("\t\tPassword Change");
        System.out.print("\t\t\tEnter your Current Password : ");
        oldPassword = keyboard.next();
        if(password.equals(oldPassword)){
            System.out.print("\t\t\tEnter your New Password : ");
            //newPassword = String.valueOf(console.readPassword());;
            newPassword = keyboard.next();

            setPassword(newPassword);
            System.out.println("\t\tPassword Altered");
            Ui.printLine();
        }
        else{
            System.out.println("\t\tOld Password Incorrect");
            Ui.printLine();
        }
    }
}
