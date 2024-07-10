/*	Write a program to convert the given decimal to binary and print the reverse of the binary decimal.
Input: 11
Output: 13
Explanation: (11)10 = (1011)2.
After reversing the bits we get:
(1101)2 = (13)10 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int decimalNumber = scanner.nextInt();
        String binaryString = Integer.toBinaryString(decimalNumber);
        String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();

        int reversedDecimalNumber = Integer.parseInt(reversedBinaryString, 2);
        System.out.println("Output: " + reversedDecimalNumber);

        scanner.close();
    }
}
