package objects;

import activities.Validations;

import java.util.Locale;
import java.util.Scanner;

public class LoginSignUpPage {
    public static void loginDisplay(Scanner scanner){
        System.out.println("\n\ttWelcome User".toUpperCase(Locale.ROOT));
        System.out.println("\n\tLogin/SignUp\n\n");


        boolean exit = false;
        do{
            System.out.println("\t\tEnter 1 for Login");
            System.out.println("\t\tEnter 2 for Registration");
            System.out.println("\t\tEnter 0 for Exit\n");

            int isNumber = -1;
            while(isNumber == -1){
                System.out.print("\t\tEnter your choice : ");
                isNumber = Validations.numberCheck(scanner);
            }

            if(isNumber == 0){
                exit = true;
            }


        }while (!exit);
    }
}
