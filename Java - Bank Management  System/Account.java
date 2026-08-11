import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Math.max(initialBalance, 0.0);
        this.transactionHistory = new ArrayList<>();

        // Record initial deposit transaction if starting balance > 0
        if (this.balance > 0) {
            transactionHistory.add(new Transaction("INITIAL DEP", this.balance, this.balance));
        }        
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    //Helper method for subclasses to record transactions
    protected void addTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, amount, this.balance));
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount + ". New balance: ₹" + balance);
            //Record deposit transaction
            addTransaction("DEPOSIT", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to display full transaction history
    public void printAccountStatement() {
        System.out.println("\n--- Transaction Statement for Account: " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactionHistory) {
                t.displayTransaction();
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public abstract boolean withdraw(double amount);

    public abstract void displayAccountDetails();
}