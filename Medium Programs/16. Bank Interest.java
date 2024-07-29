// Base class
class Bank {
    // Method to get the rate of interest, to be overridden by subclasses
    public double getRateOfInterest() {
        return 0.0; // Default rate of interest
    }
}

// SBI subclass
class SBI extends Bank {
    @Override
    public double getRateOfInterest() {
        return 8.4; // SBI rate of interest
    }
}

// ICICI subclass
class ICICI extends Bank {
    @Override
    public double getRateOfInterest() {
        return 7.3; // ICICI rate of interest
    }
}

// AXIS subclass
class AXIS extends Bank {
    @Override
    public double getRateOfInterest() {
        return 9.7; // AXIS rate of interest
    }
}

// Main class to demonstrate the functionality
public class BankInterestDemo {

    public static void main(String[] args) {
        // Create instances of each bank
        Bank sbi = new SBI();
        Bank icici = new ICICI();
        Bank axis = new AXIS();

        // Print the rate of interest for each bank
        System.out.println("SBI Interest Rate: " + sbi.getRateOfInterest() + "%");
        System.out.println("ICICI Interest Rate: " + icici.getRateOfInterest() + "%");
        System.out.println("AXIS Interest Rate: " + axis.getRateOfInterest() + "%");
    }
}
