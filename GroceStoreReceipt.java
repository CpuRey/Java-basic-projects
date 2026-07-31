import java.util.Scanner;

public class GroceStoreReceipt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Visual
        String line = "  ===========";

        // Define Storage
        System.out.print("  How many items did you purchase? ");
        int max = sc.nextInt();

        String[] itemName = new String[max];
        int[] price = new int[max];
        int[] quantity = new int[max];
        double grandTotal = 0;

        System.out.println(line);

        // Loops
        for (int i = 0; i < max; i++) {

            System.out.print("  Item Name: ");
            itemName[i] = sc.next();

            System.out.print("  Item Price: ");
            price[i] = sc.nextInt();

            System.out.print("  Quantity: ");
            quantity[i] = sc.nextInt();

            System.out.println(line);
        }

        // Display
        System.out.println("\n  Total Prices: ");

        for (int i = 0; i < max; i++) {

            int total = price[i] * quantity[i];

            System.out.println("  Item Name: " + itemName[i]);
            System.out.println("  " + price[i] + " * " + quantity[i] + "  = " + total + "$");
            System.out.println(line);

            grandTotal += total;
        }

        // Calculate if discount is available
        if (grandTotal > 500) {

            double discount = 0.1;
            double withDiscount = grandTotal * discount;
            grandTotal = grandTotal - withDiscount;

            System.out.println("  Grand Total (With Discount):  " + grandTotal + "$");

        } else {

            System.out.println("  Grand Total:  " + grandTotal + "$");
        }
    }
}