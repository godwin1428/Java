/* Write a program that finds whether a given character is present in a string or not. In case it is present it prints the index at which it is present. Do not use built-in find functions to search the character.
Sample Input:
	Enter the string: I am a programmer
	Enter the character to be searched: p
Sample Output:
	P is found in string at index: 8
Note: Check for non available Character in the given statement as Hidden Test case. */


public class FMain {
    public static void main(String[] args) {
        String inputString = "I am a programmer";
        char searchChar = 'p';
        int foundIndex = -1; 

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == searchChar) {
                foundIndex = i+1;
                break; 
            }
        }
        
        if (foundIndex != -1) {
            System.out.println(searchChar + " is found in string at index: " + foundIndex);
        } else {
            System.out.println(searchChar + " is not found in the string.");
        }
    }
}
