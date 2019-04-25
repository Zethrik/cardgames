package com.myapps.Games.Hangman;

import com.myapps.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanUtils {
    static void printHangmanLogo() {
        System.out.println("\n" +
                " __    __ _     _      _           \n" +
                "/ / /\\ \\ (_)___(_) ___| | ___  ___ \n" +
                "\\ \\/  \\/ / / __| |/ _ \\ |/ _ \\/ __|\n" +
                " \\  /\\  /| \\__ \\ |  __/ |  __/ (__ \n" +
                "  \\/  \\/ |_|___/_|\\___|_|\\___|\\___|\n" +
                "                                   \n");
    }

    static String randomWordToGuess() throws FileNotFoundException {
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            words.add(line);
        }
        int random = Utils.getRandomNumberInRange(0, words.size() - 1);
        return words.get(random);
    }

    static String hiddenWordToGuess(String word) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("*");
        }
        return hiddenWord.toString();
    }

    static String updateScaffoldShape(int mistakes) {
        String newShape = "";
        switch (mistakes) {
            case 1:
                newShape = "  ______\n |/     |\n |      @\n |      \n |      " +
                        "\n |     \n |\n/ \\";
                break;
            case 2:
                newShape = "  ______\n |/     |\n |      @\n |      |\n |      |" +
                        "\n |     \n |\n/ \\";
                break;
            case 3:
                newShape = "  ______\n |/     |\n |      @\n |     \\|\n |      |" +
                        "\n |     \n |\n/ \\";
                break;
            case 4:
                newShape = "  ______\n |/     |\n |      @\n |     \\|/\n |      |" +
                        "\n |     \n |\n/ \\";
                break;
            case 5:
            newShape = "  ______\n |/     |\n |      @\n |     \\|/\n |      |" +
                    "\n |     /\n |\n/ \\";
                break;
            case 6:
                newShape = "  ______\n |/     |\n |      @\n |     \\|/\n |      |" +
                        "\n |     / \\\n |\n/ \\";
                break;
            default:
        }
        return newShape;
    }
}
