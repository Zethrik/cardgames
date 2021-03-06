package com.myapps.Games.Hangman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.FileNotFoundException;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Scaffold {
    private String shape = "  ______\n |/     |\n |      \n |      \n |      " +
            "\n |     \n |\n/ \\";
    private String wordToGuess;
    {
        try {
            wordToGuess = HangmanUtils.randomWordToGuess().toLowerCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private String hiddenWord;
    private String usedLetters = ":";
    private int mistakes = 0;
}
