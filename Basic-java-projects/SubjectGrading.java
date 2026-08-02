import java.util.Scanner;

public class SubjectGrading {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Ask for the number of subjects
        int storage;

        while (true) {
            System.out.print("How many subjects are there? ");

            if (input.hasNextInt()) {
                storage = input.nextInt();
                input.nextLine();

                if (storage > 0) {
                    break;
                } else {
                    System.out.println("Please enter a number greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }

        // Create arrays to store subjects and grades
        String[] subjects = new String[storage];
        int[] grades = new int[storage];

        // Variables for calculations
        int total = 0;
        int lowest = 100;
        int highest = 0;

        // Input loop
        for (int i = 0; i < storage; i++) {

            System.out.println("============================================================");

            // Ask for subject name
            System.out.print("Subject: ");
            subjects[i] = input.nextLine();

            // Ask for grade with validation
            while (true) {
                System.out.print("Grade (0-100): ");

                if (input.hasNextInt()) {
                    grades[i] = input.nextInt();
                    input.nextLine();

                    if (grades[i] >= 0 && grades[i] <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    input.nextLine();
                }
            }

            // Add grade to total
            total += grades[i];

            // Check for highest grade
            if (grades[i] > highest) {
                highest = grades[i];
            }

            // Check for lowest grade
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        // Display results
        System.out.println("============================================================");

        double average = (double) total / storage;

        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        // Close Scanner object
        input.close();
    }
}
