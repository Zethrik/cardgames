package com.myapps.utils;

import com.myapps.Games.Blackjack.BlackjackApp;

public class Application {

    public void start() {
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
                    break;
                case 3:
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
        System.out.println("\n1) BlackjackApp");
        System.out.println("0) Wyjdź");
    }

    private void printGameLogo() {
        System.out.println(".------..------..------..------..------.\n" +
                "|C.--. ||A.--. ||R.--. ||D.--. ||S.--. |\n" +
                "| :/\\: || (\\/) || :(): || :/\\: || :/\\: |\n" +
                "| :\\/: || :\\/: || ()() || (__) || :\\/: |\n" +
                "| '--'C|| '--'A|| '--'R|| '--'D|| '--'S|\n" +
                "`------'`------'`------'`------'`------'");
    }

}
