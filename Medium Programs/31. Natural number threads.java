public class NaturalNumberThreads {

    public static void main(String[] args) {
        // Create threads with different ranges for displaying natural numbers
        Thread thread1 = new Thread(new NumberPrinter(1, 10));
        Thread thread2 = new Thread(new NumberPrinter(11, 20));
        Thread thread3 = new Thread(new NumberPrinter(21, 30));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class NumberPrinter implements Runnable {
    private int start;
    private int end;

    // Constructor to initialize the range
    public NumberPrinter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                // Sleep for a while to simulate time between number prints
                Thread.sleep(500); // 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
