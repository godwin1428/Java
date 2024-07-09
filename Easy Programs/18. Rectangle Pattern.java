/*	Write a program to print rectangle symbol pattern.
Get the symbol as input from user */


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the symbol to use for the rectangle pattern: ");
        String symbol = sc.nextLine();

        int rows = 5;
        int cols = 10;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println(); 
        }
        sc.close(); 
    }
}
