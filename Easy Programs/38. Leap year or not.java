import java.util.*;
public class Main {
    public static void main(String[] args) 
    {
       String a="04/11/2000";
       String[] b=a.split("/");
       int year=Integer.valueOf(b[2]);
       if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
       {
         System.out.print("Leap year");
           
       }
      else
      {
        System.out.print("Not Leap year");  
      }
        
    }
}
