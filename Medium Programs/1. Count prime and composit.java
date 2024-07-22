/*1.	Write a program to count all the prime and composite numbers entered by the user.
Sample Input:
Enter the numbers 
4
54
29
71
7
59
98
23
Sample Output:
Composite number:3
Prime number:5*/


public class PrimeCompositeCounter {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] countPrimeComposite(int[] numbers) {
        int primeCount = 0;
        int compositeCount = 0;
        for (int num : numbers) {
            if (num > 1) {
                if (isPrime(num)) {
                    primeCount++;
                } else {
                    compositeCount++;
                }
            }
        }
        return new int[]{primeCount, compositeCount};
    }

    public static void main(String[] args) {
        int[] numbers = {4, 54, 29, 71, 7, 59, 98, 23};
        int[] counts = countPrimeComposite(numbers);
        int primeCount = counts[0];
        int compositeCount = counts[1];
        System.out.println("Composite number: " + compositeCount);
        System.out.println("Prime number: " + primeCount);
    }
}
