import java.util.*;

public class HashMapSorting {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 20);
        hashMap.put("David", 35);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort(Map.Entry.comparingByValue());

        LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Sorted HashMap by values:");
        for (Map.Entry<String, Integer> entry : sortedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
