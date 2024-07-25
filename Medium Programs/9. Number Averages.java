/*	Write a program to read the numbers until -1 is encountered. Find the average of positive numbers and negative numbers entered by user.
Sample Input:
Enter -1 to exit…
Enter the number: 7
Enter the number: -2
Enter the number: 9
Enter the number: -8
Enter the number: -6
Enter the number: -4
Enter the number: 10
Enter the number:  -1
Sample Output:
The average of negative numbers is: -5.0
The average of positive numbers is : 8.66666667 */


import java.util.Scanner;

public class NumberAverages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positiveSum = 0;
        int positiveCount = 0;
        int negativeSum = 0;
        int negativeCount = 0;

        while (true) {
            System.out.print("Enter the number: ");
            int number = scanner.nextInt();

            if (number == -1) {
                break;
            }

            if (number > 0) {
                positiveSum += number;
                positiveCount++;
            } else if (number < 0) {
                negativeSum += number;
                negativeCount++;
            }
        }

        // Calculate and display the average of positive numbers
        if (positiveCount > 0) {
            double positiveAverage = (double) positiveSum / positiveCount;
            System.out.println("The average of positive numbers is: " + positiveAverage);
        } else {
            System.out.println("No positive numbers entered.");
        }

        // Calculate and display the average of negative numbers
        if (negativeCount > 0) {
            double negativeAverage = (double) negativeSum / negativeCount;
            System.out.println("The average of negative numbers is: " + negativeAverage);
        } else {
            System.out.println("No negative numbers entered.");
        }

        scanner.close();
    }
}
