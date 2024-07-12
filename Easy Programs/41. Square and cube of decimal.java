/*	Write a program to find the square, cube of the given decimal number
Sample Input:
Given Number: 0.6
Sample Output:
Square Number: 0.36
Cube Number:0.216 */


public class Main {
    public static void main(String[] args) {
        double number = 0.6; 
        double square = number * number;
        double cube = number * number * number;
        System.out.println("Square Number: " + square);
        System.out.println("Cube Number: " + cube);
    }
}
