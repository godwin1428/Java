import java.util.Arrays;

public class NthLargestNumber {

    // Function to find the Nth largest number in an array
    public static int findNthLargest(int[] arr, int n) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // The Nth largest element is at index (arr.length - n)
        return arr[arr.length - n];
    }

    public static void main(String[] args) {
        // Hardcoded array and value of N
        int[] arr = {14, 67, 48, 23, 5, 62};
        int n = 4;

        // Check if N is valid
        if (n <= 0 || n > arr.length) {
            System.out.println("Invalid value of N. It should be between 1 and " + arr.length);
            return;
        }

        // Find the Nth largest number
        int nthLargest = findNthLargest(arr, n);

        // Output
        System.out.println(n + "th Largest number: " + nthLargest);
    }
}
