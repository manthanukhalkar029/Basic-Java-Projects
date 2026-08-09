// Demonstrates Inheritance & Polymorphism
public class SavingsAccount extends Account {
    private double interestRate; // e.g., 0.04 for 4%

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrew ₹" + amount + ". Remaining balance: ₹" + getBalance());
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest of ₹" + interest + " applied.");
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Savings Account Details ---");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Holder Name    : " + getAccountHolderName());
        System.out.println("Balance        : ₹" + getBalance());
        System.out.println("Interest Rate  : " + (interestRate * 100) + "%");
    }
}