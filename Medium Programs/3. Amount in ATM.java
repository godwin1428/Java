/*3.	Write a program to print the total amount available in the ATM machine with the conditions applied.
Total denominations are 2000, 500, 200, 100, get the denomination priority from the user and the total number of notes from the user to display the total available balance to the user
Sample Input:
Enter the 1st Denomination: 500
Enter the 1st Denomination number of notes: 4
Enter the 2nd Denomination: 100
Enter the 2nd  Denomination number of notes: 20
Enter the 3rd  Denomination: 200
Enter the 3rd  Denomination number of notes: 32
Enter the 4th Denomination: 2000
Enter the 4th Denomination number of notes: 1
Sample Output:
Total Available Balance in ATM: 12400 */


import java.util.Scanner;

public class ATMBalanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] denominations = new int[4];
        int[] counts = new int[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter the " + (i + 1) + "st Denomination: ");
            denominations[i] = scanner.nextInt();
            System.out.print("Enter the " + (i + 1) + "st Denomination number of notes: ");
            counts[i] = scanner.nextInt();
        }

        int totalBalance = 0;
        for (int i = 0; i < 4; i++) {
            totalBalance += denominations[i] * counts[i];
        }
        System.out.println("Total Available Balance in ATM: " + totalBalance);
        scanner.close();
    }
}
