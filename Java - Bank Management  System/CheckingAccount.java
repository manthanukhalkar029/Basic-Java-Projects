// Demonstrates Inheritance & Polymorphism with Overdraft Limit
public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrew ₹" + amount + ". Current balance: ₹" + getBalance());
            return true;
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount.");
            return false;
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Checking Account Details ---");
        System.out.println("Account Number  : " + getAccountNumber());
        System.out.println("Holder Name     : " + getAccountHolderName());
        System.out.println("Balance         : ₹" + getBalance());
        System.out.println("Overdraft Limit : ₹" + overdraftLimit);
    }
}