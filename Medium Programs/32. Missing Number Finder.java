public class MissingNumberFinder {

    public static void main(String[] args) {
        // Example array
        int[] a = {1, 4, 5, 3, 7, 8, 6}; // Missing number should be 2
        int n = 8;

        // Find the missing number
        int missingNumber = findMissingNumber(a, n);
        System.out.println("The missing number is: " + missingNumber);
    }

    public static int findMissingNumber(int[] array, int n) {
        // Calculate the expected sum of numbers from 1 to n
        int sumExpected = n * (n + 1) / 2;

        // Calculate the actual sum of numbers in the array
        int sumActual = 0;
        for (int num : array) {
            sumActual += num;
        }

        // The missing number is the difference between the expected sum and the actual sum
        return sumExpected - sumActual;
    }
}
