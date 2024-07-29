//ComputeMethods.java
import java.util.Random;

public class ComputeMethods {
    // Method to convert Fahrenheit to Celsius
    public double fToC(double degreesF) {
        return 5.0 / 9 * (degreesF - 32);
    }

    // Method to compute the hypotenuse of a triangle given its side lengths
    public double hypotenuse(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }

    // Method to simulate rolling two 6-sided dice and return their sum
    public int roll() {
        Random random = new Random();
        int die1 = random.nextInt(6) + 1; 
        int die2 = random.nextInt(6) + 1; 
        return die1 + die2; 
    }
}

//TestClass.java
public class TestClass {
    public static void main(String[] args) {
        ComputeMethods cm = new ComputeMethods();
        
        // Test the fToC method
        double fahrenheit = 100; // Example Fahrenheit value
        double celsius = cm.fToC(fahrenheit);
        System.out.println("Temp in Celsius is " + celsius);
        
        // Test the hypotenuse method
        int sideA = 5; // Example side length
        int sideB = 7; // Example side length
        double hypotenuse = cm.hypotenuse(sideA, sideB);
        System.out.println("Hypotenuse is " + hypotenuse);
        
        // Test the roll method
        int diceSum = cm.roll();
        System.out.println("The sum of the dice values is " + diceSum);
    }
}
