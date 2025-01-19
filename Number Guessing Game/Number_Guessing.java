import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Number_Guessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        byte numberToGuess = (byte) (random.nextInt(100) + 1);
        byte numberOfTries = 0;
        byte guess;
        boolean win = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");

        while (!win) {
            try {
                guess = scanner.nextByte();
                numberOfTries++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100:");
                } else if (guess == numberToGuess) {
                    win = true;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again:");
                } else {
                    System.out.println("Too high! Try again:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next(); // Clear invalid input
            }
        }

        System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
    }
}