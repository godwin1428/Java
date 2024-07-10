/*	Write a program to print the below pattern
1
2 2
3  3  3    
4  4   4   4
3  3  3
2  2
1
*/

public class Main {
    public static void main(String[] args) {
        int n = 4; 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
