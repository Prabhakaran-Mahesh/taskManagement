package objects;

import activities.Login;
import activities.SignUp;
import activities.Validations;
import designs.Ui;

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
                boolean correct = false;
                System.out.print("Do you really want to exit? yes/no : ");
                while(!correct){

                    String decision = scanner.next();
                    if(decision.equalsIgnoreCase("yes")){
                        correct = true;
                        Ui.printLine();
                        exit = true;
                    }
                    else if(decision.equalsIgnoreCase("no")){
                        correct = true;
                    }
                    else{
                        System.out.print("\t\t\nWrong input! Enter yes or no : ");
                    }
                }
            }

            else if(isNumber == 1){
                Login.loginMethod(scanner);
            }
            else if(isNumber == 2){
                SignUp.signupMethod(scanner);
            }


        }while (!exit);
    }
}
