import java.util.HashMap;
import java.util.Map;

public class EmployeeRecord {

    public static void main(String[] args) {
        // Create a Map to store employee records
        Map<Integer, String> employeeMap = new HashMap<>();

        // i. Add objects
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");

        // Display the records
        System.out.println("Employee records: " + employeeMap);

        // ii. Check if the map is empty or not
        boolean isEmpty = employeeMap.isEmpty();
        System.out.println("Is the map empty? " + isEmpty);

        // iii. Remove a specified object
        employeeMap.remove(102); // Remove the employee with ID 102

        // Display the records after removal
        System.out.println("Employee records after removal: " + employeeMap);

        // iv. Clear the map
        employeeMap.clear();

        // Display the records after clearing
        System.out.println("Employee records after clearing: " + employeeMap);
        System.out.println("Size of the map after clearing: " + employeeMap.size());
    }
}
