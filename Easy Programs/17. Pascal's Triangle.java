public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int coef = 1; 
            for (int j = 0; j < n - i ; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%4d", coef);
                coef = coef * (i - j) / j;
            }
            System.out.println();
        }
    }
}
