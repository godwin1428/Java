import java.util.Arrays;

public class GenericSorter<T extends Comparable<T>> {

    // Method to sort an array of elements
    public void sort(T[] array) {
        Arrays.sort(array);
    }

    // Method to print the array
    public void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example with Integer
        Integer[] intArray = {5, 3, 8, 1, 2};
        GenericSorter<Integer> intSorter = new GenericSorter<>();
        System.out.print("Integer array before sorting: ");
        intSorter.printArray(intArray);
        intSorter.sort(intArray);
        System.out.print("Integer array after sorting: ");
        intSorter.printArray(intArray);

        // Example with String
        String[] strArray = {"apple", "orange", "banana", "pear"};
        GenericSorter<String> strSorter = new GenericSorter<>();
        System.out.print("String array before sorting: ");
        strSorter.printArray(strArray);
        strSorter.sort(strArray);
        System.out.print("String array after sorting: ");
        strSorter.printArray(strArray);
    }
}
