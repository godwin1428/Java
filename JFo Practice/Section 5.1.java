import java.util.Scanner;

public class ColorRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a color code: ");
        double wavelength = scanner.nextDouble();
        
        String color;
        if (wavelength >= 380 && wavelength < 450) {
            color = "Violet";
        } else if (wavelength >= 450 && wavelength < 495) {
            color = "Blue";
        } else if (wavelength >= 495 && wavelength < 570) {
            color = "Green";
        } else if (wavelength >= 570 && wavelength < 590) {
            color = "Yellow";
        } else if (wavelength >= 590 && wavelength < 620) {
            color = "Orange";
        } else if (wavelength >= 620 && wavelength < 750) {
            color = "Red";
        } else {
            color = "The entered wavelength is not a part of the visible spectrum";
        }
        
        System.out.println("The color is " + color);
        
        scanner.close();
    }
}
