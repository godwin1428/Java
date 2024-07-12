/*	Write a program to find the square root of a perfect square number(print both the positive and negative values)
Sample Input:
Enter the number: 6561
Sample Output:
Square Root: 81, -81 */


public class Main {
    public static void main(String[] args) {
        int number = 6561; 
        int sqrt = (int) Math.sqrt(number);
        System.out.println("Square Root: " + sqrt + ", " + (-sqrt));
    }
}
