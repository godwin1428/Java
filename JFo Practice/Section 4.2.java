import java.util.Scanner;

public class ProcessName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter their name
        System.out.print("Type your name: ");
        String fullName = scanner.nextLine();
        
        // Split the input string into first and last name
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            System.out.println("Invalid input. Please enter both first and last names.");
            return;
        }
        
        String firstName = nameParts[0];
        String lastName = nameParts[1];
        
        // Get the first initial
        char firstInitial = firstName.charAt(0);
        
        // Display the name in the specified format
        System.out.println("Your name is: " + lastName + ", " + firstInitial + ".");
        
        // Close the scanner
        scanner.close();
    }
}
