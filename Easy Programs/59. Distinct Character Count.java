import java.util.HashMap;

public class DistinctCharactersCount {
    public static void main(String[] args) {
        String inputString = "hello world";
        inputString = inputString.replace(" ", "").toLowerCase();

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        System.out.println("Distinct Characters and their Counts:");
        for (HashMap.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
