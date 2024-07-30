import java.util.Scanner;

public class StringOperations {

    public static void main(String[] args) {
        // Accept the string from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        // i) Replace a word in the given string
        // Replace "Saveetha" with "Example" as an example
        String replacedString = inputString.replace("Saveetha", "Example");
        System.out.println("String after replacement: " + replacedString);

        // ii) Find the length of the string
        int length = inputString.length();
        System.out.println("Length of the string: " + length);

        // iii) Convert the string to uppercase
        String upperCaseString = inputString.toUpperCase();
        System.out.println("String in uppercase: " + upperCaseString);
        
        // Close the scanner
        scanner.close();
    }
}
