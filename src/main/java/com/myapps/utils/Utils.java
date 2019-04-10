package com.myapps.utils;

import java.util.Scanner;

public class Utils {
    private Scanner scanner = new Scanner(System.in);

    public int getUserInt() {
        String userInput = scanner.nextLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public void pause() {
        System.out.println("\nEnter, by kontynuować");
        scanner.nextLine();
    }
}
