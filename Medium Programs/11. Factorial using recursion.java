import java.util.Scanner;

public class FactorialCalculator {

    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * factorial(n - 1); // Recursive case
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Calculation
        int result = factorial(n);

        // Output
        System.out.println("The factorial of " + n + " is: " + result);

        // Close the scanner
        scanner.close();
    }
}
