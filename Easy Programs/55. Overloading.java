public class Overload {
    
    public void assignValues(int a, int b) {
        System.out.println("Assigning values with two arguments:");
        System.out.println("a = " + a + ", b = " + b);
    }

    public void assignValues(int a, int b, int c) {
        System.out.println("Assigning values with three arguments:");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
    }

    public void assignValues(int a, int b, int c, int d) {
        System.out.println("Assigning values with four arguments:");
        System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
    }

    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.assignValues(1, 2);
        overload.assignValues(5, 6, 7);
        overload.assignValues(10, 20, 30, 40);
    }
}
