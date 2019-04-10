package com.myapps.Games;

import com.myapps.cards.Card;
import com.myapps.cards.CardUtils;
import com.myapps.cards.Deck;
import com.myapps.utils.Utils;

import java.util.List;


public class Blackjack {

    public void startBlackjack() {
        printBlackjackLogo();
        int userSelection;
        do {
            System.out.println("\n1) Nowa gra");
            System.out.println("2) Menu główne");
            System.out.print("\nTwój wybór: ");
            userSelection = new Utils().getUserInt();
            System.out.println();
            switch (userSelection) {
                case 1:
                    playBlackjack();
                    break;
                case 2:
                    System.out.println("Do zobaczenia");
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 2);
    }

    private void playBlackjack() {
        Deck deck = new CardUtils().createStandardDeck();

    }

    private void printBlackjackLogo() {
        System.out.println("______ _            _    _            _    \n" +
                "| ___ \\ |          | |  (_)          | |   \n" +
                "| |_/ / | __ _  ___| | ___  __ _  ___| | __\n" +
                "| ___ \\ |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                "| |_/ / | (_| | (__|   <| | (_| | (__|   < \n" +
                "\\____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                "                       _/ |                \n" +
                "                      |__/    ");
    }
}
