public class SpecialCharacterCounter {

    public static void main(String[] args) {
        // Given statement
        String statement = "Modi Birthday @ September 17, #&$% is the wishes code for him.";
        
        // Initialize the counter for special characters
        int count = 0;
        
        // Iterate through each character in the statement
        for (int i = 0; i < statement.length(); i++) {
            char c = statement.charAt(i);
            
            // Check if the character is neither a letter, digit, nor whitespace
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                count++;
            }
        }

        // Output
        System.out.println("Number of special Characters: " + count);
    }
}
