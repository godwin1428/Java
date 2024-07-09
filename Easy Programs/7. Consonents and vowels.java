/*	Write a program to print consonants and vowels separately in the given word
Sample Input:
Given Word: Engineering
Sample Output:
Consonants: n g n r n g
Vowels: e i e ei */

public class Main {
    public static void main(String[] args) {
        String statement = "Engineering";
        statement = statement.toLowerCase();
        StringBuilder consonants = new StringBuilder();
        StringBuilder vowel = new StringBuilder();
        for (int i = 0; i < statement.length(); i++) {
            char ch = statement.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel.append(ch).append(" "); 
            }
            else if (Character.isLetter(ch)) { 
                consonants.append(ch).append(" ");
            }
        }
        System.out.println("vowels: " + vowel);
        System.out.println("Consonants: "+consonants);
    }
}
