public class PrimeChecker {

    public static void main(String[] args) {
        // Number to check
        int number1 = 5;
        int number2 = 15;

        // Create Runnable instances for each number
        Runnable primeTask1 = new PrimeTask(number1);
        Runnable primeTask2 = new PrimeTask(number2);

        // Create Threads and pass the Runnables to them
        Thread thread1 = new Thread(primeTask1);
        Thread thread2 = new Thread(primeTask2);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Runnable implementation to check if a number is prime
class PrimeTask implements Runnable {
    private final int number;

    // Constructor to initialize the number
    public PrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Check if the number is prime and print the result
        if (isPrime(number)) {
            System.out.println(number + " is Prime");
        } else {
            System.out.println(number + " is Not Prime");
        }
    }

    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
