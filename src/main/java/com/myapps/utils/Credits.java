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

    public void addCredits(int value) throws FileNotFoundException{
        int credits = getCredits();
        credits += value;
        PrintWriter saver = new PrintWriter("credits.txt");
        saver.println(credits);
        saver.close();
    }

    public void reduceCredits(int value) throws FileNotFoundException {
        int credits = getCredits();
        credits -= value;
        PrintWriter saver = new PrintWriter("credits.txt");
        saver.println(credits);
        saver.close();
    }
}