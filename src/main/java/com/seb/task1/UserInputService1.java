package com.seb.task1;

import java.util.Scanner;

public class UserInputService1 {

    public String getUserText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write your text: ");
        return scanner.nextLine();                       //Given input example: djkhofjkhacatalogdsahf
    }

}
