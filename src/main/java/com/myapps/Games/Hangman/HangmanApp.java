package com.myapps.Games.Hangman;

import com.myapps.utils.Credits;
import com.myapps.utils.Utils;

import java.io.FileNotFoundException;

public class HangmanApp {
    public void startHangman() throws FileNotFoundException {
        HangmanUtils.printHangmanLogo();
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
                    playHangman();
                    if (new Credits().getCredits() <= 0) {
                        new Credits().gameOver();
                        new Utils().pause();
                        userSelection = 3;
                    }
                    break;
                case 2:
                    int credits = new Credits().getCredits();
                    System.out.println("Posiadasz " + credits + " kredytów");
                    new Utils().pause();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }

        } while (userSelection != 3);
    }

    private void playHangman() {
        Scaffold scaffold = new Scaffold();
        System.out.println(scaffold.getShape());
        String hiddenWord = HangmanUtils.hiddenWordToGuess(scaffold.getWordToGuess());
        System.out.println("\n" + hiddenWord);
    }
}
