package com.myapps.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Credits {
    private File file = new File("credits.txt");
    private Scanner scanner = new Scanner(file);

    public Credits() throws FileNotFoundException {
    }

    public int getCredits() {
        String text = scanner.nextLine();
        return Integer.parseInt(text);
    }

    public void setCredits(int credits) throws FileNotFoundException {
        PrintWriter saver = new PrintWriter("credits.txt");
        saver.println(credits);
        saver.close();
    }

    public void addCredits(int value) throws FileNotFoundException {
        int credits = getCredits();
        credits += value;
        setCredits(credits);
    }

    public void reduceCredits(int value) throws FileNotFoundException {
        int credits = getCredits();
        credits -= value;
        setCredits(credits);
    }

    public void gameOver() throws FileNotFoundException {
        System.out.println(" /$$$$$$$   /$$$$$$  /$$   /$$ /$$   /$$ /$$$$$$$  /$$   /$$ /$$$$$$$$\n" +
                "| $$__  $$ /$$__  $$| $$$ | $$| $$  /$$/| $$__  $$| $$  | $$|__  $$__/\n" +
                "| $$  \\ $$| $$  \\ $$| $$$$| $$| $$ /$$/ | $$  \\ $$| $$  | $$   | $$   \n" +
                "| $$$$$$$ | $$$$$$$$| $$ $$ $$| $$$$$/  | $$$$$$$/| $$  | $$   | $$   \n" +
                "| $$__  $$| $$__  $$| $$  $$$$| $$  $$  | $$__  $$| $$  | $$   | $$   \n" +
                "| $$  \\ $$| $$  | $$| $$\\  $$$| $$\\  $$ | $$  \\ $$| $$  | $$   | $$   \n" +
                "| $$$$$$$/| $$  | $$| $$ \\  $$| $$ \\  $$| $$  | $$|  $$$$$$/   | $$   \n" +
                "|_______/ |__/  |__/|__/  \\__/|__/  \\__/|__/  |__/ \\______/    |__/   \n" +
                "                                                                      ");
        setCredits(100);
    }
}