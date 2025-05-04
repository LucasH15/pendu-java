import com.lucas.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var random = new Random();
        final var words = "hotel ambulance voiture hopital cardio fitness gardien magasin".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Le pendu commence !");

        while(true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre : ");

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Vous avez perdu !");
                System.out.println("Le mot était : " + game.getSecretWord());
            }

            if (game.isWin()) {
                System.out.println(game);
                System.out.println("Vous avez gagnez !");
            }

            if (game.isLost() || game.isWin()) {
                do {
                    var replayAnswer = scanLetter("Voulez-vous rejouer ? (o/n) : ");
                    if (replayAnswer == 'o') {
                        wordToGuess = words[random.nextInt(words.length)];
                        game = new GuessGame(wordToGuess, 10);
                        break;
                    } else if (replayAnswer == 'n') {
                        System.exit(0);
                    }
                } while (true);
            }
        }
    }

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.print(question);
            var input = scanner.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }
}