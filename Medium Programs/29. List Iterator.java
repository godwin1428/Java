import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {
        // Create a List and add elements
        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("A");
        list.add("E");
        list.add("B");
        list.add("D");
        list.add("F");

        // Create a ListIterator to iterate through the list
        ListIterator<String> iterator = list.listIterator();

        // Append "+" symbol to each element
        while (iterator.hasNext()) {
            String element = iterator.next();
            iterator.set(element + "+");
        }

        // Print the modified list in reverse order
        System.out.println("Modified elements in reverse order:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
