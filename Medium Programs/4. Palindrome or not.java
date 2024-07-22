/*4.	Write a program using choice to check
Case 1: Given string is palindrome or not
Case 2: Given number is palindrome or not
Sample Input:
Case = 1
String = MADAM
Sample Output:
Palindrome */


public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int caseNumber = 1; 
        String input = "MADAM"; 
        switch (caseNumber) {
            case 1:
                if (isPalindrome(input)) {
                    System.out.println("Palindrome");
                } else {
                    System.out.println("Not Palindrome");
                }
                break;
                
            case 2:
                if (isPalindrome(input)) {
                    System.out.println("Palindrome");
                } else {
                    System.out.println("Not Palindrome");
                }
                break;

            default:
                System.out.println("Invalid case");
                break;
        }
    }
}
