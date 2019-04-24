package com.myapps.Games.Blackjack;

import com.myapps.cards.Card;
import com.myapps.cards.Deck;

import java.util.List;

class BlackjackUtils {
    static void printBlackjackLogo() {
        System.out.println("\n" +
                ".------..------..------..------..------..------..------..------..------.\n" +
                "|B.--. ||L.--. ||A.--. ||C.--. ||K.--. ||J.--. ||A.--. ||C.--. ||K.--. |\n" +
                "| :(): || :/\\: || (\\/) || :/\\: || :/\\: || :(): || (\\/) || :/\\: || :/\\: |\n" +
                "| ()() || (__) || :\\/: || :\\/: || :\\/: || ()() || :\\/: || :\\/: || :\\/: |\n" +
                "| '--'B|| '--'L|| '--'A|| '--'C|| '--'K|| '--'J|| '--'A|| '--'C|| '--'K|\n" +
                "`------'`------'`------'`------'`------'`------'`------'`------'`------'\n");
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
