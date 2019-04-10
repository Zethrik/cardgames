package com.myapps.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardUtils {
    private String[] names = {"Dwójka", "Trójka", "Czwórka", "Piątka", "Szóstka", "Siódemka",
        "Ósemka", "Dziewiątka", "Dziesiątka", "Walet", "Dama", "Król", "As", "Joker"};
    private String[] colors = {"Pik", "Kier", "Trefl", "Karo"};

    public Deck createStandardDeck() {
        List<Card> cards = new ArrayList<>();
        int cardsCounter = 0;

        while (cards.size() < 52) {
            for (int i = 0; i < 4; i++) {
                Card card = new Card();
                card.setName(names[cardsCounter]);
                card.setColor(colors[i]);
                cards.add(card);
            }
            cardsCounter++;
        }

        Deck deck = new Deck();
        deck.setCards(cards);
        return deck;
    }

    public Deck shuffleDeck(Deck deck) {
        Collections.shuffle((List<?>) deck);
        return deck;
    }
}
