/* Write a program to print Right Triangle Star Pattern
    Sample Input:: n = 5
Output: 
 * 
 * * 
 * * * 
 * * * * 
 * * * * * */

public class Main {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
