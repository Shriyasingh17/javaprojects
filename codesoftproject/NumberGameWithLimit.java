import java.util.Scanner;
import java.util.Random;

public class NumberGameWithLimit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MAX_ATTEMPTS = 5; // Maximum number of attempts allowed
        int guessNumber;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        int randomNumber = random.nextInt(100) + 1; // Generates random number between 1 and 100

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts to guess it.");

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ". Enter your guess: ");
            guessNumber = scanner.nextInt();
            attempts++;

            if (guessNumber < randomNumber) {
                System.out.println("Too low!");
            } else if (guessNumber > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly!");
                hasGuessedCorrectly = true;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Game over! You have used all your attempts.");
            System.out.println("The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
