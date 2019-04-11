package com.myapps.Games;

import com.myapps.cards.Card;
import com.myapps.cards.CardUtils;
import com.myapps.cards.Deck;
import com.myapps.utils.Utils;

import java.util.List;
import java.util.Scanner;


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
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 2);
    }

    private void playBlackjack() {
        Deck standardDeck = new CardUtils().createStandardDeck();
        Deck deck = addBlackjackValuesToCards(standardDeck);
        Deck blackjackDeck = CardUtils.shuffleDeck(deck);
        List<Card> cards = blackjackDeck.getCards();
        int score = 0;
        int maxRandom = 51;
        String userSelection = "";

        while (score < 21 && !userSelection.equals("N") ) {
            Scanner scanner = new Scanner(System.in);
            int random = Utils.getRandomNumberInRange(0, maxRandom);
            maxRandom--;
            Card drawnCard = cards.get(random);
            score += drawnCard.getValue();
            System.out.println("Nowa karta to " + drawnCard.getName() + " " + drawnCard.getColor());
            System.out.println("Punkty: " + score);
            if (score < 21) {
                System.out.println("Grasz dalej? T/N");
                userSelection = scanner.nextLine().toUpperCase();
            }
        }

        System.out.println();
        if (score < 21) {
            System.out.println("Cykor!");
        } else if (score == 21) {
            System.out.println("Jesteś zwycięzcą!");
        } else  {
            System.out.println("Przegrywasz!");
        }
        new Utils().pause();
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

    private Deck addBlackjackValuesToCards(Deck deck) {
        List<Card> cards = deck.getCards();
        int value = 2;
        int counter = 0;
        for (int i = 0; i < 52; i++) {
            if (i < 36) {
                cards.get(i).setValue(value);
                counter++;
                if (counter == 4) {
                    counter = 0;
                    value++;
                }
            } else if (i < 48) {
                cards.get(i).setValue(10);
            } else {
                cards.get(i).setValue(11);
            }
        }

        Deck d = new Deck();
        d.setCards(cards);
        return d;
    }
}
