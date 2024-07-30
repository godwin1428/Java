import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWriteExample {

    public static void main(String[] args) {
        String data = "Computer Science and Engineering";
        String filename = "example.txt";

        // Write the string to a file
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            System.out.println("Data written to file: " + data);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Read the string from the file
        try (FileReader reader = new FileReader(filename)) {
            int character;
            System.out.print("Data read from file: ");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }
}
