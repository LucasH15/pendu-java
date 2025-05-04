package com.lucas.game;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {
    private List<String> secretWord = new ArrayList<>();
    private int lifePoints;
    private List<String> guessWord = new ArrayList<>();

    public GuessGame(String wordToGuess, int lifePoints) {
        for (char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for (int i = 0; i < secretWord.size(); i++) {
            this.guessWord.add("_");
        }
    }

    @Override
    public String toString() {
        return String.join(" ", guessWord);
    }
}
