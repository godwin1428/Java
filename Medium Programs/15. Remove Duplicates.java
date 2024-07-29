public class RemoveDuplicates {

    public static void main(String[] args) {
        // Hardcoded array
        int[] array = {10, 20, 20, 30, 40, 40, 50};

        // Array to hold non-duplicate items
        int[] tempArray = new int[array.length];
        int tempSize = 0;

        // Remove duplicates
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < tempSize; j++) {
                if (array[i] == tempArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                tempArray[tempSize] = array[i];
                tempSize++;
            }
        }

        // Output non-duplicate items
        System.out.print("Non-duplicate items:\n[");
        for (int i = 0; i < tempSize; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(tempArray[i]);
        }
        System.out.println("]");
    }
}
