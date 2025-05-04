package com.lucas.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessGame {
    private List<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private List<Character> guessWord = new ArrayList<>();
    private Set<Character> guessLetters = new HashSet<>();

    public GuessGame(String wordToGuess, int lifePoints) {
        for (char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for (int i = 0; i < secretWord.size(); i++) {
            this.guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return "GuessGame{" +
                "lifePoints=" + lifePoints +
                ", guessWord=" + guessWord +
                ", guessLetters=" + guessLetters +
                "}";
    }

    public void guessLetter(char letter) {
        if (secretWord.contains(letter) && !guessWord.contains(letter)) {
            var index = 0;
            for (char c : secretWord) {
                if (c == letter) {
                    guessWord.set(index, letter);
                }
                index++;
            }
        } else if (!guessWord.contains(letter) && !guessLetters.contains(letter)) {
            guessLetters.add(letter);
            lifePoints--;
        }
    }

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWin() {
        return !guessWord.contains('_');
    }

    public String getSecretWord() {
        StringBuilder result = new StringBuilder();
        for (char c : secretWord) {
            result.append(c);
        }
        return result.toString();
    }
}
