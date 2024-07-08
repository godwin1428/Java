/* Write a program to check the entered user name is valid or not. Get both the inputs from the user.*/

public class Main {
    public static void main(String[] args) {
        String username="godwin1428";
        if (isValidUsername(username)) {
            System.out.println("The username is valid.");
        } else {
            System.out.println("The username is invalid.");
        }
    }
    
    public static boolean isValidUsername(String username) {
        if (username.length() < 5) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
