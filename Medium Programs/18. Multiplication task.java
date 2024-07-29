public class MultiplicationTable {

    public static void main(String[] args) {
        // Numbers for which we want to display the multiplication table
        int[] numbers = {5, 10};

        // Creating and starting threads for each number
        for (int number : numbers) {
            // Create a Runnable for the current number
            Runnable tableTask = new MultiplicationTask(number);

            // Create a Thread and pass the Runnable to it
            Thread tableThread = new Thread(tableTask);

            // Display thread states before starting
            System.out.println("Thread state before start: " + tableThread.getState());

            // Start the thread
            tableThread.start();

            // Display thread states after starting
            System.out.println("Thread state after start: " + tableThread.getState());

            // Wait for the thread to complete
            try {
                tableThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Display thread states after completion
            System.out.println("Thread state after completion: " + tableThread.getState());
        }
    }
}

// Runnable implementation to print multiplication table
class MultiplicationTask implements Runnable {
    private final int number;

    // Constructor
    public MultiplicationTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Print multiplication table
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " X " + i + " = " + (number * i));
        }
    }
}
