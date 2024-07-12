/*	Program to find whether the given number is Armstrong number or not
Sample Input:
Enter number: 153
Sample Output:
Given number is Armstrong number
*/

public class Main {
    public static void main(String[] args) {
        int number = 153; 
        if (isArmstrong(number)) {
            System.out.println("Given number is Armstrong number");
        } else {
            System.out.println("Given number is not Armstrong number");
        }
    }
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == originalNumber;
    }
}
