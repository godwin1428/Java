public class BinaryConverter {

    // Function to convert binary to decimal
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    // Function to convert decimal to octal
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public static void main(String[] args) {
        // Given binary number
        String binaryNumber = "1101";

        // Convert binary to decimal
        int decimalNumber = binaryToDecimal(binaryNumber);

        // Convert decimal to octal
        String octalNumber = decimalToOctal(decimalNumber);

        // Output
        System.out.println("Decimal Number: " + decimalNumber);
        System.out.println("Octal: " + octalNumber);
    }
}
