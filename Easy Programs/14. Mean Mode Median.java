/*	Find the Mean, Median, Mode of the array of numbers?
Sample Input;:
Array of elements = {16, 18, 27, 16, 23, 21, 19}
Sample Output:
Mean = 20
Median = 19
Mode = 16 */

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {16, 18, 27, 16, 23, 21, 19};
        int n = arr.length;

        //mean
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int ans=sum/n;
        System.out.println("Mean:"+ans); 

        //median
        Arrays.sort(arr);
        double median;
        if (n % 2 == 0) {
            median = (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            median = arr[n / 2];
        }
        System.out.println("Median = " + median);

        //mode
        int maxValue = 0;
        int maxCount = 0;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (arr[j] == arr[i]) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = arr[i];
            }
        }
        System.out.println("Mode = " + maxValue);
    }
}
