// Parent class
class Parent {
    // Method in the parent class
    public void printMessage() {
        System.out.println("This is parent class");
    }
}

// Child class extending Parent
class Child extends Parent {
    // Method in the child class
    public void printChildMessage() {
        System.out.println("This is child class");
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Create an object of the parent class and call its method
        Parent parent = new Parent();
        parent.printMessage(); // Output: This is parent class

        // 2. Create an object of the child class and call its method
        Child child = new Child();
        child.printChildMessage(); // Output: This is child class

        // 3. Call the method of the parent class by object of the child class
        child.printMessage(); // Output: This is parent class
    }
}
