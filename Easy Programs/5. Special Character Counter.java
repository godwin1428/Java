/* Write a program to print the special characters separately and print number of Special characters in the line? */

public class Main {
    public static void main(String[] args) {
        String input="sfrgeg@$(@%:<dfsds52)";
        int specialCharCount = 0;

        System.out.println("Special characters in the line:");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
                System.out.println(ch);
                specialCharCount++;
            }
        }
        System.out.println("Number of special characters: " + specialCharCount);
    }
}
