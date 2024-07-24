/*	Find the Mth maximum number and Nth minimum number in an array and then find the sum of it and difference of it.
Sample Input:
Array of elements = {14, 16, 87, 36, 25, 89, 34}
M = 1
N = 3
Sample Output:
1stMaximum Number = 89
3rdMinimum Number = 25
Sum = 114
Difference = 64 */


import java.util.Arrays;

public class MaxMinFinder {
    public static void main(String[] args) {
        int[] array = {14, 16, 87, 36, 25, 89, 34};
        int M = 1;
        int N = 3;
        Arrays.sort(array);
        int MthMax = array[array.length - M];
        int NthMin = array[N - 1];
        int sum = MthMax + NthMin;
        int difference = MthMax - NthMin;
        System.out.println(M + "th Maximum Number = " + MthMax);
        System.out.println(N + "th Minimum Number = " + NthMin);
        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
    }
}
