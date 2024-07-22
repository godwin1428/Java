/*5.	Write a program to convert Decimal number equivalent to Binary number and octal numbers?
Sample Input:
Decimal Number: 15
Sample Output:
Binary Number = 1111
Octal = 17 */


public class NumberConverter {
    public static void main(String[] args) {
        int decimalNumber = 15;
        String binaryNumber = Integer.toBinaryString(decimalNumber);
        String octalNumber = Integer.toOctalString(decimalNumber);
        System.out.println("Binary Number = " + binaryNumber);
        System.out.println("Octal = " + octalNumber);
    }
}
