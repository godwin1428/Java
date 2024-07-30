public class Student {
    // Fields for student details
    private String name;
    private int registerNumber;
    private int[] marks = new int[5]; // Array to store marks for five subjects

    // Constructor to initialize student details
    public Student(String name, int registerNumber, int mark1, int mark2, int mark3, int mark4, int mark5) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.marks[0] = mark1;
        this.marks[1] = mark2;
        this.marks[2] = mark3;
        this.marks[3] = mark4;
        this.marks[4] = mark5;
    }

    // Method to calculate total marks
    public int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate average marks
    public double calculateAverage() {
        return calculateTotal() / 5.0;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Register Number: " + registerNumber);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average Marks: " + calculateAverage());
    }

    public static void main(String[] args) {
        // Create a Student object with sample data
        Student student = new Student("John Doe", 12345, 85, 90, 78, 92, 88);
        
        // Display student details
        student.displayDetails();
    }
}
