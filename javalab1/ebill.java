package javalab1;
import java.util.Scanner;

public class ebill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Old reading and Current reading
        System.out.print("Enter the old meter reading: ");
        int oldReading = scanner.nextInt();

        System.out.print("Enter the current meter reading: ");
        int currentReading = scanner.nextInt();

        // Calculate units consumed
        int units = currentReading - oldReading;
        double bill = 0.0;

        if (units < 0) {
            System.out.println("Invalid readings! Current reading cannot be less than old reading.");
        } else {
            // Using if-else-if ladder for slab rates
            if (units <= 50) {
                bill = units * 1.0;
            } else if (units <= 100) {
                bill = (50 * 1.0) + ((units - 50) * 2.0);
            } else if (units <= 200) {
                bill = (50 * 1.0) + (50 * 2.0) + ((units - 100) * 3.0);
            } else if (units <= 400) {
                bill = (50 * 1.0) + (50 * 2.0) + (100 * 3.0) + ((units - 200) * 4.0);
            } else {
                bill = (50 * 1.0) + (50 * 2.0) + (100 * 3.0) + (200 * 4.0) + ((units - 400) * 5.0);
            }

            // Display results
            System.out.println("Total Units Consumed: " + units);
            System.out.println("Total Electricity Bill: Rs. " + bill);
        }

        scanner.close();
    }
}
