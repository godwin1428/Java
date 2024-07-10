/*	Write a program to print the below pattern
1
4     9
16   25    36
49   64    81    100 */


public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k*k+" ");
                k++;
            }
            System.out.println();
        }
    }
}
