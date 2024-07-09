/* Write a program to arrange the letters of the word alphabetically in reverse order
Sample Input:
Enter the word: MOSQUE
Sample Output:
Alphabetical Order: U S Q O M E */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String Word = "MOSQUE";
        char[] charArray = Word.toCharArray();
        Arrays.sort(charArray);
        String rev="";
        for(int i=charArray.length-1;i>=0;i--)
        {
            rev+=charArray[i];
        }
        System.out.println("Alphabetical Order in Reverse: " + rev);
    }
}

