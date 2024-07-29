import java.util.Scanner;

public class TrafficLightSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a color code: ");
        int currentColor = scanner.nextInt();
        
        String nextColor;
        
        switch (currentColor) {
            case 1:
                nextColor = "green";
                break;
            case 2:
                nextColor = "yellow";
                break;
            case 3:
                nextColor = "red";
                break;
            default:
                nextColor = "Invalid color";
                break;
        }
        
        // Determine the next color based on the current color
        if (!nextColor.equals("Invalid color")) {
            switch (currentColor) {
                case 1:
                    nextColor = "green";
                    break;
                case 2:
                    nextColor = "yellow";
                    break;
                case 3:
                    nextColor = "red";
                    break;
            }
        }
        
        System.out.println("Next Traffic Light is " + nextColor);
        
        scanner.close();
    }
}
