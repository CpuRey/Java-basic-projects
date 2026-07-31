import java.util.Scanner;

public class GuardiansCafe {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println("\n  Welcome to Lightning Counter's Guardian Cafe!!");
        System.out.println("  Here are the available drinks:\n");

        // Coffee menu
        String[] coffee = {
            "  1.) Espresso = 5.90$",
            "  2.) Macchiato = 5.95$",
            "  3.) Coffee With Cream = 5.95$",
            "  4.) Chocolate Coffee = 4.25$",
            "  5.) House Blend = 2.99$",
            "  6.) Decaf Coffee = 2.99$"
        };

        // Display menu
        for (int i = 0; i < coffee.length; i++) {
            System.out.println(coffee[i]);
        }

        String paymentMethod;
        int order;
        double pay;
        double change;
        double total = 0;

        // Order validation
        while (true) {

            System.out.print("\n  Order number (1-6): ");

            if (input.hasNextInt()) {
                order = input.nextInt();

                if (order >= 1 && order <= 6) {
                    break;
                } else {
                    System.out.println("  Invalid order. Please choose between 1 and 6.");
                }

            } else {
                System.out.println("  Invalid input. Please enter a number.");
                input.next();
            }
        }

        switch (order) {

            case 1:
                System.out.println("  You ordered an Espresso.");
                total = 5.90;
                break;

            case 2:
                System.out.println("  You ordered a Macchiato.");
                total = 5.95;
                break;

            case 3:
                System.out.println("  You ordered a Coffee With Cream.");
                total = 5.95;
                break;

            case 4:
                System.out.println("  You ordered a Chocolate Coffee.");
                total = 4.25;
                break;

            case 5:
                System.out.println("  You ordered a House Blend.");
                total = 2.99;
                break;

            case 6:
                System.out.println("  You ordered a Decaf Coffee.");
                total = 2.99;
                break;
        }

        // Payment method validation
        while (true) {

            System.out.print("\n  Payment Method [Gcash/Cash]: ");
            paymentMethod = input.next();

            if (paymentMethod.equalsIgnoreCase("Gcash")) {
                System.out.println("  Please send your payment to #XxxxXXXxx");
                break;
            } else if (paymentMethod.equalsIgnoreCase("Cash")) {
                System.out.println("  Please pay at the counter.");
                break;
            } else {
                System.out.println("  Invalid payment method.");
            }
        }

        // Payment validation
        while (true) {

            System.out.print("\n  Amount of cash entered: ");

            if (input.hasNextDouble()) {
                pay = input.nextDouble();

                if (pay >= 0) {
                    break;
                } else {
                    System.out.println("  Amount cannot be negative.");
                }

            } else {
                System.out.println("  Invalid input. Please enter a number.");
                input.next();
            }
        }

        change = pay - total;

        // Display result
        if (pay > total) {
            System.out.println("  Your change is: " + change + "$");
        } else if (pay == total) {
            System.out.println("  Payment received. Total paid: " + total + "$");
        } else {
            System.out.println("  You are short by: " + (-change) + "$");
        }

        input.close();
    }
}