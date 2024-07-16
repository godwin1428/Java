/*	Generate a Java code that implements java selection and iteration statements. Use do while loop to process a menu selection. When a menu is selected, it should display the syntax of the selected statements
*/
import java.util.Scanner;

public class MenuSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. if Statement");
            System.out.println("2. switch Statement");
            System.out.println("3. for Loop");
            System.out.println("4. while Loop");
            System.out.println("5. do-while Loop");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Syntax of if Statement:");
                    System.out.println("if (condition) {");
                    System.out.println("    // Statement block");
                    System.out.println("} else {");
                    System.out.println("    // Statement block");
                    System.out.println("}");
                    break;
                case 2:
                    System.out.println("Syntax of switch Statement:");
                    System.out.println("switch (expression) {");
                    System.out.println("    case value1:");
                    System.out.println("        // Statement block");
                    System.out.println("        break;");
                    System.out.println("    case value2:");
                    System.out.println("        // Statement block");
                    System.out.println("        break;");
                    System.out.println("    default:");
                    System.out.println("        // Default statement block");
                    System.out.println("}");
                    break;
                case 3:
                    System.out.println("Syntax of for Loop:");
                    System.out.println("for (initialization; condition; update) {");
                    System.out.println("    // Statement block");
                    System.out.println("}");
                    break;
                case 4:
                    System.out.println("Syntax of while Loop:");
                    System.out.println("while (condition) {");
                    System.out.println("    // Statement block");
                    System.out.println("}");
                    break;
                case 5:
                    System.out.println("Syntax of do-while Loop:");
                    System.out.println("do {");
                    System.out.println("    // Statement block");
                    System.out.println("} while (condition);");
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid menu option.");
                    break;
            }
            System.out.println(); 
        } while (choice != 0);

        scanner.close();
    }
}
