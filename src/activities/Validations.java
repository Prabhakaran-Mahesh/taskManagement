package activities;

import designs.Ui;

import java.util.Scanner;

public class Validations {

    /*
    -> number validation
    -> sometimes user may give input other than int where int is required
    -> this function prevents from input mismatch error
     */
    public static int numberCheck(Scanner scanner){
        int choice;

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            // Advances the scanner to prevent input errors
            scanner.nextLine();
            // Sets the condition to false to break the loop
            return choice;
        } else {
            System.out.println("\n\t\tInvalid input.\n");
            // Advances the scanner to prevent input errors
            scanner.nextLine();
            Ui.printLine();
            System.out.println("\n");
            return -1;
        }

    }

    /*
    -> email validation
    -> email verification is used to check whether correct format of email is passed as input
     */
    public static String emailValidation(Scanner scanner) {
        String email;
        String regex = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$";

        while(true){
            System.out.print("\t\tEnter Email ID : ");
            email = scanner.next();

            if(email.matches(regex)){
                return email;
            }
            else{
                System.out.println("\t\tmail id not correct!\n");
            }
        }
    }
}
