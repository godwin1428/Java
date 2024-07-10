/*	Write a program to reverse a number using loop?(Get the input from user)
Sample Input:
Number: 14567
Sample Output:
Reverse Number: 76541 */


import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        System.out.println("Reverse Number: " + reversedNumber);
        scanner.close();
    }
}
