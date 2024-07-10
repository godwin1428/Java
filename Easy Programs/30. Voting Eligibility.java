/*	Write a program to find whether the person is eligible for vote or not. And if that particular person is not eligible, then print how many years are left to be eligible.
Sample Input:
Enter your age:	7
Sample output:
You are allowed to vote after 11 years */


public class Main {
    public static void main(String[] args) {
        int age = 7; 

        int votingAge = 18;
        if (age >= votingAge) {
            System.out.println("You are eligible to vote.");
        } else {
            int yearsLeft = votingAge - age;
            System.out.println("You are allowed to vote after " + yearsLeft + " years.");
        }
    }
}
