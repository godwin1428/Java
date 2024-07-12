public class Main {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static int lcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    public static void main(String[] args) {
        int a = 24; 
        int b = 36; 
        int gcdValue = gcd(a, b);
        int lcmValue = lcm(a, b, gcdValue);
        System.out.println("GCD: " + gcdValue);
        System.out.println("LCM: " + lcmValue);
    }
}
