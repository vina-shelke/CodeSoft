import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Guess the Number game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerLimit + " and " + upperLimit + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high. Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                        roundsWon++;
                        break;
                    }

                    if (attempts == maxAttempts) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine();  // Clear the invalid input from the scanner
                }
            }

            totalAttempts += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game over! You won " + roundsWon + " rounds and took a total of " + totalAttempts + " attempts.");
    }
}
