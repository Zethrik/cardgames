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
        scaffold.setHiddenWord(HangmanUtils.hiddenWordToGuess(scaffold.getWordToGuess()));
        int userSelection;

        do {
            System.out.println(scaffold.getShape());
            System.out.println("\n" + scaffold.getHiddenWord());
            System.out.println("\n1) Odgadnij literę");
            System.out.println("2) Odgadnij hasło");
            System.out.println("3) Poddaj się");
            System.out.print("\nTwój wybór: ");
            userSelection = new Utils().getUserInt();

            switch (userSelection) {
                case 1:
                    guessLetter(scaffold);
                    break;
                case 2:
                    guessWord();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Błędny wybór\n");
            }
        } while (scaffold.getMistakes() < 6 && userSelection != 3);
    }

    private void guessLetter(Scaffold scaffold) {
        String wordToGuess = scaffold.getWordToGuess();
        String usedLetters = scaffold.getUsedLetters();
        System.out.println("\nPodaj literę: ");
        String letter = String.valueOf(new Utils().getUserString()).toLowerCase();
        if (letter.length() != 1) {
            System.out.println("To nie była litera");
            new Utils().pause();
        } else {
            if (wordToGuess.contains(letter) && !usedLetters.contains(letter)) {
                usedLetters += letter;
                scaffold.setUsedLetters(usedLetters);

                String hiddenWord = scaffold.getHiddenWord();
                StringBuilder newHiddenWord = new StringBuilder();
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (String.valueOf(wordToGuess.charAt(i)).equals(letter)) {
                        newHiddenWord.append(letter);
                    } else {
                        newHiddenWord.append(hiddenWord.charAt(i));
                    }
                }
                scaffold.setHiddenWord(newHiddenWord.toString());
                System.out.println("Brawo. Słowo zawiera literę " + letter);
            } else {
                System.out.println("W słowie nie ma litery " + letter);
                int mistakes = scaffold.getMistakes();
                mistakes++;
                scaffold.setMistakes(mistakes);
                scaffold.setShape(HangmanUtils.updateScaffoldShape(mistakes));
            }
        }

    }

    private void guessWord() {
    }
}
