class Box {
    // Instance variables for dimensions
    private double length;
    private double width;
    private double height;

    // Default constructor that initializes dimensions
    public Box() {
        // Default dimensions
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    // Method to calculate the volume of the box
    public double calculateVolume() {
        return length * width * height;
    }

    // Method to display the dimensions of the box
    public void displayDimensions() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

public class BoxVolume {

    public static void main(String[] args) {
        // Create an instance of Box using the default constructor
        Box box = new Box();

        // Display the dimensions of the box
        box.displayDimensions();

        // Calculate and display the volume of the box
        double volume = box.calculateVolume();
        System.out.println("Volume of the box: " + volume);
    }
}
