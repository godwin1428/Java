/*	Write a program to find the number of composite numbers in an array of elements
Sample Input;:
Array of elements = {16, 18, 27, 16, 23, 21, 19}
Sample Output:
Number of Composite Numbers = 5  */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {16, 18, 27, 16, 23, 21, 19};
        int compositeCount = 0;
        for (int num : arr) {
            if (isComposite(num)) {
                compositeCount++;
            }
        }
        System.out.println("Number of Composite Numbers = " + compositeCount);
    }

    public static boolean isComposite(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}
