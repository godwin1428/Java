import java.util.*;

public class Main {
    public static String mostFrequentWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        String mostFrequent = "";
        int maxCount = 0;
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) > maxCount) {
                mostFrequent = word;
                maxCount = wordCount.get(word);
            }
        }
        return mostFrequent.substring(0, 1).toUpperCase() + mostFrequent.substring(1);
    }
    public static void main(String[] args) {
        String paragraph = "Ram hit a ball, the hit ball flew far after it was hit";
        String[] banned = {"hit"};
        System.out.println(mostFrequentWord(paragraph, banned));  
    }
}
