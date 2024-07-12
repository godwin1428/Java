/*	Program to find the frequency of each element in the array.
Sample Input & Output:
{1, 2, 8, 3, 2, 2, 2, 5, 1}
Pseudo:
Element | Frequency
--------------------------
1           |         2
2           |         4
8           |         1
3           |         1
4           |         1        */


public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 2, 2, 2, 5, 1};
        int maxElement = 0;
        for (int element : arr) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        int[] frequencyArray = new int[maxElement + 1];
        for (int element : arr) {
            frequencyArray[element]++;
        }
        System.out.println("Element | Frequency");
        System.out.println("-------------------");
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                System.out.println(i + "       |    " + frequencyArray[i]);
            }
        }
    }
}
