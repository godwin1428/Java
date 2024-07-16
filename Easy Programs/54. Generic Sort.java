/*	Create a simple generics class with type parameters for sorting values of different types.
*/
  import java.util.Arrays;

public class GenericSort<T extends Comparable<T>> {
    private T[] array;
    public GenericSort(T[] array) {
        this.array = array;
    }

    public void sort() {
        Arrays.sort(array);
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 8, 1, 3};
        GenericSort<Integer> intSorter = new GenericSort<>(intArray);
        intSorter.sort();
        System.out.print("Sorted Integer Array: ");
        intSorter.printArray();

        String[] strArray = {"apple", "orange", "banana", "grape"};
        GenericSort<String> strSorter = new GenericSort<>(strArray);
        strSorter.sort();
        System.out.print("Sorted String Array: ");
        strSorter.printArray();
    }
}
