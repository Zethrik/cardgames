package com.myapps.utils;

import java.util.Random;
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

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
