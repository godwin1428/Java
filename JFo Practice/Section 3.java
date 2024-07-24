import java.util.Scanner;

public class JavaLibsPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        double height;
        String color;
        String city;
        String food;
        String animal;
        String movie;
        int number;
        double price;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        System.out.print("Enter your height (in meters): ");
        height = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Enter your favorite color: ");
        color = scanner.nextLine();

        System.out.print("Enter the city you live in: ");
        city = scanner.nextLine();

        System.out.print("Enter your favorite food: ");
        food = scanner.nextLine();

        System.out.print("Enter your favorite animal: ");
        animal = scanner.nextLine();

        System.out.print("Enter your favorite movie: ");
        movie = scanner.nextLine();

        System.out.print("Enter a number: ");
        number = scanner.nextInt();

        System.out.print("Enter a price (e.g., 19.99): ");
        price = scanner.nextDouble();

        System.out.println("\nHere is your JavaLibs story:\n");
        System.out.println("Once upon a time, there was a person named " + name + ", who was " + age + " years old.");
        System.out.println(name + " lived in the beautiful city of " + city + ", known for its stunning " + color + " sky.");
        System.out.println("Every day, " + name + " would enjoy eating " + food + " while watching " + movie + " and dreaming about " + animal + "s.");
        System.out.println("One day, " + name + " decided to take a trip and found a magical place where everything cost " + price + " dollars.");
        System.out.println("The height of the tallest tree in this place was " + height + " meters, and it was " + number + " times more beautiful than any other place.");
        
        scanner.close();
    }
}
