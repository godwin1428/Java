/*	Write a program to print the following pattern
Sample Input:
Enter the Character to be printed: %
Max Number of time printed: 3
%
% %
% % % */


public class Main {
    public static void main(String[] args) {
        int n = 3;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("% ");
            }
            System.out.println();
        }
    }
}
