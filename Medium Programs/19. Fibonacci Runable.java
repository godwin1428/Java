public class FibonacciSeries {

    public static void main(String[] args) {
        // Number of terms in the Fibonacci series
        int terms = 5;

        // Create a Runnable for generating the Fibonacci series
        Runnable fibonacciTask = new FibonacciTask(terms);

        // Create a Thread and pass the Runnable to it
        Thread fibonacciThread = new Thread(fibonacciTask);

        // Start the thread
        fibonacciThread.start();

        // Wait for the thread to complete
        try {
            fibonacciThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Runnable implementation to generate Fibonacci series
class FibonacciTask implements Runnable {
    private final int terms;

    // Constructor to initialize the number of terms
    public FibonacciTask(int terms) {
        this.terms = terms;
    }

    @Override
    public void run() {
        // Generate and print the Fibonacci series
        generateFibonacci(terms);
    }

    private void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Number of terms must be positive.");
            return;
        }

        int a = 0, b = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
