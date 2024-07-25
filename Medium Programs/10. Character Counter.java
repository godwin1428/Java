/*10.	Write a program to read a character until a * is encountered. Also count the number of uppercase, lowercase, and numbers entered by the users.
Sample Input:
Enter * to exit…
Enter any character: W
Enter any character: d
Enter any character: A
Enter any character: G
Enter any character: g
Enter any character: H
Enter any character: *
Sample Output:
Total count of lower case:2
Total count of upper case:4
Total count of numbers =0 */


import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int numberCount = 0;

        while (true) {
            System.out.print("Enter any character: ");
            char ch = scanner.next().charAt(0);

            if (ch == '*') {
                break;
            }

            if (Character.isUpperCase(ch)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseCount++;
            } else if (Character.isDigit(ch)) {
                numberCount++;
            }
        }

        // Display the counts
        System.out.println("Total count of lower case: " + lowerCaseCount);
        System.out.println("Total count of upper case: " + upperCaseCount);
        System.out.println("Total count of numbers: " + numberCount);

        scanner.close();
    }
}
