import java.util.Scanner;

public class MultipleCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int operators;
        boolean keepRunning = true;
        String repeatUse;

        do {

            // Display menu
            System.out.println("  == Calculator ==");
            System.out.println("  1.) Addition");
            System.out.println("  2.) Subtraction");
            System.out.println("  3.) Multiplication");
            System.out.println("  4.) Division");
            System.out.println("  5.) Modulo");

            // Validate operator
            while (true) {
                System.out.print("  Choose an operator (1-5): ");

                if (input.hasNextInt()) {
                    operators = input.nextInt();

                    if (operators >= 1 && operators <= 5) {
                        break;
                    } else {
                        System.out.println("  Invalid operator. Please choose 1-5.");
                    }

                } else {
                    System.out.println("  Please enter a number.");
                    input.next();
                }
            }

            // First number
            while (true) {
                System.out.print("\n  Enter first number: ");

                if (input.hasNextInt()) {
                    num1 = input.nextInt();
                    break;
                } else {
                    System.out.println("  Invalid input. Enter a number.");
                    input.next();
                }
            }

            // Second number
            while (true) {
                System.out.print("  Enter second number: ");

                if (input.hasNextInt()) {
                    num2 = input.nextInt();

                    if (operators == 4 && num2 == 0) {
                        System.out.println("  Cannot divide by zero.");
                    } else {
                        break;
                    }

                } else {
                    System.out.println("  Invalid input. Enter a number.");
                    input.next();
                }
            }

            // Calculations
            int addition = num1 + num2;
            int subtraction = num1 - num2;
            int multiplication = num1 * num2;
            double division = (double) num1 / num2;
            int modulo = num1 % num2;

            // Display result
            switch (operators) {

                case 1:
                    System.out.println("  The sum is: " + addition);
                    break;

                case 2:
                    System.out.println("  The difference is: " + subtraction);
                    break;

                case 3:
                    System.out.println("  The product is: " + multiplication);
                    break;

                case 4:
                    System.out.println("  The quotient is: " + division);
                    break;

                case 5:
                    System.out.println("  The remainder is: " + modulo);
                    break;
            }

            input.nextLine();

            System.out.print("\n  Do you want to try again? (YES/NO): ");
            repeatUse = input.nextLine();

            if (!repeatUse.equalsIgnoreCase("yes")) {
                keepRunning = false;
                System.out.println("\n  YOU HAVE EXITED.");
            }

        } while (keepRunning);

        input.close();
    }
}