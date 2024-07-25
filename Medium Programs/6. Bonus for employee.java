6.	In an organization they decide to give bonus to all the employees on New Year. A 5% bonus on salary is given to the grade A workers and 10% bonus on salary to the grade B workers. Write a program to enter the salary and grade of the employee. If the salary of the employee is less than $10,000 then the employee gets an extra 2% bonus on salary Calculate the bonus that has to be given to the employee and print the salary that the employee will get.
Sample Input & Output:
Enter the grade of the employee: B
Enter the employee salary: 50000
Salary=50000
Bonus=5000.0
Total to be paid:55000.0


import java.util.Scanner;

public class BonusCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the grade of the employee (A or B): ");
        char grade = scanner.next().charAt(0);

        System.out.print("Enter the employee salary: ");
        double salary = scanner.nextDouble();

        double bonusPercentage = 0;
        if (grade == 'A') {
            bonusPercentage = 5;
        } else if (grade == 'B') {
            bonusPercentage = 10;
        } else {
            System.out.println("Invalid grade");
            scanner.close();
            return;
        }

        double bonus = (salary * bonusPercentage) / 100;
        if (salary < 10000) {
            bonus += (salary * 2) / 100;
        }

        double totalToBePaid = salary + bonus;

        System.out.println("Salary = " + salary);
        System.out.println("Bonus = " + bonus);
        System.out.println("Total to be paid = " + totalToBePaid);

        scanner.close();
    }
}
	
