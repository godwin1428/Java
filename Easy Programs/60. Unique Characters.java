import java.util.HashMap;
import java.util.HashSet;

public class UniqueCharacters {
    public static void main(String[] args) {
        String inputString = "abcb";

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        HashSet<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (HashMap.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
            }
        }

        System.out.println("Unique Characters:");
        for (char c : uniqueChars) {
            System.out.println(c);
        }
    }
}
