package com.myapps.Games.Blackjack;

import com.myapps.cards.Card;
import com.myapps.cards.Deck;

import java.util.List;

public class BlackjackUtils {
    public static void printBlackjackLogo() {
        System.out.println("______ _            _    _            _    \n" +
                "| ___ \\ |          | |  (_)          | |   \n" +
                "| |_/ / | __ _  ___| | ___  __ _  ___| | __\n" +
                "| ___ \\ |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                "| |_/ / | (_| | (__|   <| | (_| | (__|   < \n" +
                "\\____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                "                       _/ |                \n" +
                "                      |__/    ");
    }

    static Deck addBlackjackValuesToCards(Deck deck) {
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
