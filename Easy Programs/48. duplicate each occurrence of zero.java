/*	Write a program to given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
Input: arr = [1, 0, 2, 3, 0, 4, 5, 0]
Output: [1, 0, 0, 2, 3, 0, 0, 4]
Explanation: After calling your function, the input array is modified to [1, 0, 0, 2, 3, 0, 0, 4] */


public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == 0) {
                // Shift elements to the right to make space for duplicate zero
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // Duplicate the zero
                if (i + 1 < n) {
                    arr[i + 1] = 0;
                }
                // Skip the next element since it's the duplicated zero
                i += 1;
            }
            i += 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        
        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
