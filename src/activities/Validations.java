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
}
