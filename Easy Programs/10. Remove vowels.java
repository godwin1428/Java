/*	Write a program that accepts a string from user and displays the same string after removing vowels from it.
Sample Input & Output:
	Enter a string: we can play the game 
	The string without vowels is: w cn ply thgm */

public class Main {
    public static void main(String[] args) {
        String statement = "we can play the game ";
        StringBuilder consonants = new StringBuilder();
        for (int i = 0; i < statement.length(); i++) {
            char ch = statement.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                continue;
            }
            else { 
                consonants.append(ch);
            }
        }
        System.out.println("Consonants: "+consonants);
    }
}
