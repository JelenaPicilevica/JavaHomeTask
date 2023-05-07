package com.seb.task2;

import java.util.Scanner;

public class UserInputService {

    public String getUserText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write your text: ");
        return scanner.nextLine();                          //Given input example: djkhofjkhacatalogdsahf
    }

    public boolean caseSensitivityCheck() {
        System.out.println("Please enter 'yes' for case sensitive search of dictionary words " +
                "in your input or 'no' for ignore case search:");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        while (!userChoice.equalsIgnoreCase("yes") && !userChoice.equalsIgnoreCase("no")){
            System.out.println("Wrong input! Please write 'yes' or 'no':");
            userChoice = scanner.nextLine();
        }

        if (userChoice.equalsIgnoreCase("yes")){
            return true;
        } else{
            return false;
        }
    }

}
