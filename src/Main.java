import com.lucas.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "hotel ambulance voiture hopital cardio fitness gardien magasin".split(" ");
        final var wordToGuess = words[random.nextInt(words.length)];
        final var game = new GuessGame(wordToGuess, 10);

        System.out.println("Le pendu commence !");

        while(true) {
            System.out.println(game);
            System.out.print("Entrez une lettre : ");
            final var letter = scanner.nextLine().charAt(0);
        }
    }
}