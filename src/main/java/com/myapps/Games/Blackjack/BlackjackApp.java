package com.myapps.Games.Blackjack;

import com.myapps.cards.Card;
import com.myapps.cards.CardUtils;
import com.myapps.cards.Deck;
import com.myapps.utils.Credits;
import com.myapps.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class BlackjackApp {

    public void startBlackjack() throws FileNotFoundException {
        BlackjackUtils.printBlackjackLogo();
        int userSelection;
        do {
            System.out.println("\n1) Nowa gra");
            System.out.println("2) Liczba kredytów");
            System.out.println("3) Menu gier");
            System.out.print("\nTwój wybór: ");
            userSelection = new Utils().getUserInt();
            System.out.println();
            switch (userSelection) {
                case 1:
                    playBlackjack();
                    break;
                case 2:
                    int credits = new Credits().getCredits();
                    System.out.println("Posiadasz " + credits + " kredytów");
                    new Utils().pause();
                    startBlackjack();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 2);
    }

    private void playBlackjack() throws FileNotFoundException {
        Deck standardDeck = new CardUtils().createStandardDeck();
        Deck deck = BlackjackUtils.addBlackjackValuesToCards(standardDeck);
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
            cards.remove(random);
            if (score < 21) {
                System.out.println("Grasz dalej? T/N");
                userSelection = scanner.nextLine().toUpperCase();
            }
        }
        System.out.println();
        blackjackResults(score, cards);
    }

    private static void blackjackResults(int score, List<Card> cards) throws FileNotFoundException {
        if (score < 21) {
            System.out.println("Cykor!");
            if (score > 15) {
                int valueToAdd = score - 15;
                System.out.println("Kredyty zwiększają się o" + valueToAdd);
                new Credits().addCredits(valueToAdd);
            } else {
                System.out.println("Tracisz 10 kredytów");
                new Credits().reduceCredits(10);
            }
        } else if (score == 22 && cards.size() == 50) {
            System.out.println("Perskie oko! Wygrywasz!");
            System.out.println("Otrzymujesz 50 kredytów");
            new Credits().addCredits(50);
        } else if (score == 21) {
            System.out.println("Jesteś zwycięzcą!");
            System.out.println("Otrzymujesz 25 kredytów");
            new Credits().addCredits(25);
        } else  {
            System.out.println("Przegrywasz!");
            System.out.println("Tracisz 10 kredytów");
            new Credits().reduceCredits(10);
        }
        new Utils().pause();
    }
}
