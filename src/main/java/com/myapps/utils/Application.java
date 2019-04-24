package com.myapps.utils;

import com.myapps.Games.Blackjack.BlackjackApp;
import com.myapps.Games.Hangman.HangmanApp;
import com.myapps.Games.RPS.RPSApp;

import java.io.FileNotFoundException;

public class Application {

    public void start() throws FileNotFoundException {
        int userSelection;
        do {
            printGameLogo();
            printMainMenu();
            System.out.print("\nWybierz grę: ");
            userSelection = new Utils().getUserInt();
            switch (userSelection) {
                case 1:
                    new BlackjackApp().startBlackjack();
                    break;
                case 2:
                    new HangmanApp().startHangman();
                case 8:
                    new Credits().setCredits(100);
                    System.out.println("Kredyty zostały zresetowane do 100");
                    new Utils().pause();
                    break;
                case 9:
                    int credits = new Credits().getCredits();
                    System.out.println("Posiadasz " + credits + " kredytów");
                    new Utils().pause();
                    break;
                case 666:
                    new RPSApp().startRPS();
                    break;
                case 0:
                    System.out.println("Do zobaczenia");
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 0);
    }

    private void printMainMenu() {
        System.out.println("\n1) Blackjack");
        System.out.println("2) Wisielec");
        System.out.println("8) Reset kredytów");
        System.out.println("9) Liczba kredytów");
        System.out.println("0) Wyjdź");
    }

    private void printGameLogo() {
        System.out.println("\n" +
                "   ___  __                                     __\n" +
                "  / _ \\/ /__ ___ _____ ________  __ _____  ___/ /\n" +
                " / ___/ / _ `/ // / _ `/ __/ _ \\/ // / _ \\/ _  / \n" +
                "/_/  /_/\\_,_/\\_, /\\_, /_/  \\___/\\_,_/_//_/\\_,_/  \n" +
                "            /___//___/                           \n");
    }

}
