// Superclass
class SuperClass {
    int value;

    // Parameterized constructor
    SuperClass(int value) {
        this.value = value;
        System.out.println("SuperClass constructor called with value: " + value);
    }

    // Method in the superclass
    void display() {
        System.out.println("Value in SuperClass: " + value);
    }
}

// Subclass
class SubClass extends SuperClass {
    int value; // This hides the `value` field in SuperClass

    // Parameterized constructor in subclass
    SubClass(int superValue, int subValue) {
        super(superValue); // Call the superclass constructor
        this.value = subValue;
    }

    // Method in the subclass
    void display() {
        // Call superclass method
        super.display();
        System.out.println("Value in SubClass: " + value);
    }
}

public class HideMembersDemo {

    public static void main(String[] args) {
        // Create an instance of SubClass
        SubClass obj = new SubClass(100, 200);

        // Display values
        obj.display();
    }
}
