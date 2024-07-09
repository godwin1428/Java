/*	Write a program to print the following pattern
Sample Input:
Enter the number to be printed: 1
Max Number of time printed: 3
1
11
111
11
1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be printed: ");
        int num = sc.nextInt();
        System.out.print("Max Number of times to be printed: ");
        int max = sc.nextInt();

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
            }
            System.out.println();
        }
        for (int i = max - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
            }
            System.out.println();
        }
        sc.close();
    }
}
