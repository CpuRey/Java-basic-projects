import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        // Create Scanner and Random objects
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Stores the best (lowest) number of attempts
        int highScore = Integer.MAX_VALUE;

        // Stores the user's choice to play again
        String playAgain;

        System.out.println("=== Number Guessing Game ===");

        // Repeat the game until the user chooses to quit
        do {

            int maxNumber = 100;

            // Difficulty Selection
            System.out.println("\nChoose Difficulty");
            System.out.println("1. Easy   (1 - 50)");
            System.out.println("2. Medium (1 - 100)");
            System.out.println("3. Hard   (1 - 500)");

            int difficulty;

            // Validate difficulty input
            while (true) {

                System.out.print("Enter choice (1-3): ");

                if (input.hasNextInt()) {

                    difficulty = input.nextInt();

                    if (difficulty >= 1 && difficulty <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                    }

                } else {

                    System.out.println("Invalid input! Please enter a number.");
                    input.next();

                }
            }

            // Set the maximum random number based on difficulty
            switch (difficulty) {

                case 1:
                    maxNumber = 50;
                    break;

                case 2:
                    maxNumber = 100;
                    break;

                case 3:
                    maxNumber = 500;
                    break;

            }

            // Generate a random number
            int secretNumber = random.nextInt(maxNumber) + 1;

            // Variables for the game
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("\nI am thinking of a number between 1 and " + maxNumber + ".");
            System.out.println("You only have " + maxAttempts + " attempts.");
                       
            // Guessing Loop
            while (attempts < maxAttempts && guess != secretNumber) {

                System.out.print("\nEnter your guess: ");

                // Validate number input
                if (input.hasNextInt()) {

                    guess = input.nextInt();
                    attempts++;

                    // Correct guess
                    if (guess == secretNumber) {

                        System.out.println("\n🎉 Congratulations!");
                        System.out.println("You guessed the number in " + attempts + " attempt(s)!");

                        // Update high score
                        if (attempts < highScore) {

                            highScore = attempts;
                            System.out.println("🏆 New High Score!");

                        }

                        System.out.println("Best Score: " + highScore + " attempt(s).");

                    } else {

                        // Wrong guess
                        System.out.println("❌ You are wrong!");

                        if (guess < secretNumber) {
                            System.out.println("Hint: Too low!");
                        } else {
                            System.out.println("Hint: Too high!");
                        }

                        System.out.println("Attempts Used : " + attempts + "/" + maxAttempts);
                        System.out.println("Attempts Left : " + (maxAttempts - attempts));
                    }

                } else {

                    System.out.println("Invalid input! Please enter a number.");
                    input.next();

                }
            }

            // Player loses
            if (guess != secretNumber) {

                System.out.println("\n💀 Game Over!");
                System.out.println("You used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + secretNumber);

            }

            // Ask if the player wants to play again
            System.out.print("\nPlay Again? (y/n): ");
            playAgain = input.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("\nThank you for playing!");

        input.close();
    }
}
