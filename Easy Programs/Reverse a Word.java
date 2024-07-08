/* Write a program to reverse a word using loop? (Not to use inbuilt functions)
Sample Input: 
String: TEMPLE
Sample Output:
Reverse String: ELPMET */

class Main{
    public static void main(String[] args) {
        String a="TEMPLE";
        char[] b = a.toCharArray();
        String rev="";
        for(int i=b.length-1;i>=0;i--)
        {
            rev+=b[i];
        }
        System.out.println("Reversed Stirng:"+rev);
    }
}
