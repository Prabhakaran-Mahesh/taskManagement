package objects;

import activities.Login;
import activities.SignUp;
import activities.Validations;
import designs.Ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
-> this class is Helps us to display the welcome screen for the program
 */
public class LoginSignUpPage {

    /*
    -> this function is used to display the login page categories
    -> login, signup, exit
     */
    public static void loginDisplay(Scanner scanner){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E dd MMM, yyyy  hh:mm");

        // Display today's date and time.
        System.out.print("\n\tWelcome User".toUpperCase(Locale.ROOT));
        System.out.printf("%83s Today's Date and Time:    %s\n", " ", dateFormat.format(date));
        System.out.println("\n\tLogin/SignUp\n\n");


        boolean exit = false;
        do{
            System.out.println("\t\tEnter 1 for Login");
            System.out.println("\t\tEnter 2 for Manager Registration");
            System.out.println("\t\tEnter -1 for Exit\n");

            int isNumber = -1;
            while(isNumber == -1){
                System.out.print("\t\tEnter your choice : ");
                isNumber = Validations.numberCheck(scanner);
            }

            if(isNumber == -2){
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
            else{
                System.out.println("\tEnter correct number\n");
            }


        }while (!exit);
    }
}
