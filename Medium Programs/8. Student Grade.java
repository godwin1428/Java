/*	Write a program to enter the marks of a student in four subjects. Then calculate the total and aggregate, display the grade obtained by the student. If the student scores an aggregate greater than 75%, then the grade is Distinction. If aggregate is 60>= and <75, then the grade is First Division. If aggregate is 50 >= and <60, then the grade is Second Division. If aggregate is 40>= and <50, then the grade is Third Division. Else the grade is Fail.

Sample Input & Output:
Enter the marks in python: 90
Enter the marks in c programming: 91
Enter the marks in Mathematics: 92
Enter the marks in Physics: 93
Total= 366
Aggregate = 91.5
DISTINCTION */

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for four subjects
        System.out.print("Enter the marks in Python: ");
        int pythonMarks = scanner.nextInt();

        System.out.print("Enter the marks in C Programming: ");
        int cProgrammingMarks = scanner.nextInt();

        System.out.print("Enter the marks in Mathematics: ");
        int mathMarks = scanner.nextInt();

        System.out.print("Enter the marks in Physics: ");
        int physicsMarks = scanner.nextInt();

        // Calculate total marks and aggregate
        int totalMarks = pythonMarks + cProgrammingMarks + mathMarks + physicsMarks;
        double aggregate = totalMarks / 4.0;

        // Determine grade
        String grade;
        if (aggregate > 75) {
            grade = "DISTINCTION";
        } else if (aggregate >= 60) {
            grade = "FIRST DIVISION";
        } else if (aggregate >= 50) {
            grade = "SECOND DIVISION";
        } else if (aggregate >= 40) {
            grade = "THIRD DIVISION";
        } else {
            grade = "FAIL";
        }

        // Display total, aggregate, and grade
        System.out.println("Total = " + totalMarks);
        System.out.println("Aggregate = " + aggregate);
        System.out.println(grade);

        scanner.close();
    }
}
