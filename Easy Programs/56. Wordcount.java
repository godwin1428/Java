import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inputString = "Hello world Java is great and Java is powerful";
        String[] words = inputString.split(" ");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        System.out.println("Word Count:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
