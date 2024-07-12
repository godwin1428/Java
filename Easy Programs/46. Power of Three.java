/*	Write a program to given an integer n, return true if it is a power of three. Otherwise, return false.
Input =27
Output= true
Explanation: 27=33 */


public class Main {
    public static void main(String[] args) {
        int n = 27; 
        boolean result = isPowerOfThree(n);
        System.out.println(result);
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
