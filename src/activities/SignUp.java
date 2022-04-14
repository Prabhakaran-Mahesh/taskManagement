package activities;

import designs.Models;
import designs.Ui;
import users.Manager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    public static void signupMethod(Scanner scanner) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Manager manager = new Manager();

        boolean verification = false; // for calling loginVerification function

        String email="", password, name="";

        // loop stops when correct credentials are given or when attempts exceed 3 times.
        while(!verification){

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

            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                System.out.println("\t\tYou have successfully created your Manager Account");

                manager.setName(name);
                manager.setEmail(email);
                manager.setPassword(password);
                Models.managers.add(manager);

                Ui.printLine();
                verification = true;
            }
            else{
                System.out.println("\t\tWrong email Id\n");
            }
        }
    }
}
