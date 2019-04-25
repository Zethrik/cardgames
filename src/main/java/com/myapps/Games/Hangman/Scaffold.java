package com.myapps.Games.Hangman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.FileNotFoundException;

@Getter
@Setter
public class Scaffold {
    private String shape = "  ______\n |/     |\n |      \n |      \n |      " +
            "\n |     \n |\n/ \\";
    private String wordToGuess;

    {
        try {
            wordToGuess = HangmanUtils.randomWordToGuess();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String usedLetters;
    private int mistakes = 0;
}
