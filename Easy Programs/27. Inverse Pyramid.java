/*	Write a program to print inverted pyramid pattern.
Input: no of rows: 3
Output 
    *****
     ***
      * */


public class InvertedPyramidPattern {
    public static void main(String[] args) {
        int rows = 3;
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2 * (rows - i) - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
