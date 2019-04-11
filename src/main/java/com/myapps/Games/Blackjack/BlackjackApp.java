package com.myapps.Games.Blackjack;

import com.myapps.cards.Card;
import com.myapps.cards.CardUtils;
import com.myapps.cards.Deck;
import com.myapps.utils.Utils;

import java.util.List;
import java.util.Scanner;


public class BlackjackApp {

    public void startBlackjack() {
        BlackjackUtils.printBlackjackLogo();
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
        Deck deck = BlackjackUtils.addBlackjackValuesToCards(standardDeck);
        Deck blackjackDeck = CardUtils.shuffleDeck(deck);
        List<Card> cards = blackjackDeck.getCards();
        int score = 0;
        int maxRandom = 51;
        String userSelection = "";

        // core blackjack game
        while (score < 21 && !userSelection.equals("N") ) {
            Scanner scanner = new Scanner(System.in);
            int random = Utils.getRandomNumberInRange(0, maxRandom);
            maxRandom--;
            Card drawnCard = cards.get(random);
            score += drawnCard.getValue();
            System.out.println("Nowa karta to " + drawnCard.getName() + " " + drawnCard.getColor());
            System.out.println("Punkty: " + score);
            cards.remove(random);
            if (score < 21) {
                System.out.println("Grasz dalej? T/N");
                userSelection = scanner.nextLine().toUpperCase();
            }
        }

        // blackjack results
        System.out.println();
        if (score < 21) {
            System.out.println("Cykor!");
        } else if (score == 22 && cards.size() == 50) {
            System.out.println("Perskie oko! Wygrywasz!");
        } else if (score == 21) {
            System.out.println("Jesteś zwycięzcą!");
        } else  {
            System.out.println("Przegrywasz!");
        }
        new Utils().pause();
    }
}