/*	Write Java programs to implement multiple threads and apply join method for thread and thread has to be started after 500ms using sleep (). */

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(500); 
                System.out.println("Thread 1 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(500); 
                System.out.println("Thread 2 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished.");
    }
}
