public class MultiCatchExample {

    public static void main(String[] args) {
        // Example array
        int[] array = {1, 2, 3};

        // Example variables for arithmetic operations
        int divisor = 0;
        Integer nullValue = null;

        // Handling ArithmeticException
        try {
            int result = 10 / divisor; // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        }

        // Handling ArrayIndexOutOfBoundsException
        try {
            int number = array[5]; // This will cause ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }

        // Handling NullPointerException
        try {
            int length = nullValue.intValue(); // This will cause NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e);
        }

        // Other code can continue executing here
        System.out.println("Program continues after handling exceptions.");
    }
}
