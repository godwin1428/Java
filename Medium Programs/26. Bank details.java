import java.util.Hashtable;

public class BankDetails {

    public static void main(String[] args) {
        // Create a Hashtable to store bank details
        Hashtable<Integer, String> bankDetails = new Hashtable<>();

        // i) Add 3 records
        bankDetails.put(1001, "John Doe");
        bankDetails.put(1002, "Jane Smith");
        bankDetails.put(1003, "Emily Johnson");

        // Display the records
        System.out.println("Bank details: " + bankDetails);

        // ii) Display the size of the Hashtable
        int size = bankDetails.size();
        System.out.println("Size of the Hashtable: " + size);

        // iii) Clear the Hashtable
        bankDetails.clear();

        // Display the records after clearing
        System.out.println("Bank details after clearing: " + bankDetails);
        System.out.println("Size of the Hashtable after clearing: " + bankDetails.size());
    }
}
