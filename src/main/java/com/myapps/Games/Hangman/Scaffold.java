package com.myapps.Games.Hangman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Scaffold {
    private String shape = "  ______\n |/     |\n |      \n |      \n |      " +
            "\n |     \n |\n/ \\";
    private String wordToGuess;
    private String usedLetters;
    private int mistakes;
}
