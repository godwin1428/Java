/*	Write a program to print the multiplication table of number m up to n.
Sample Input:
M = 4
N = 5
Sample Output:
1x4=4
2x4=8
3x4=12
4x4=16
5x4=20
*/

public class Main {
    public static void main(String[] args) {
        int m = 4; 
        int n = 10; 
        for (int i = 1; i <= n; i++) {
            int result = i * m;
            System.out.println(i + "x" + m + "=" + result);
        }
    }
}
