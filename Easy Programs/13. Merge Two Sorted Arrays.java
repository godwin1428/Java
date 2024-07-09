/*	Write a program for Merge two sorted arrays using Array list 
Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8} */


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8};
        ArrayList<Integer> mergedList = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            mergedList.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            mergedList.add(arr2[j]);
        }
        Collections.sort(mergedList);
        System.out.println("Merged and Sorted Array:");
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
    }
}
