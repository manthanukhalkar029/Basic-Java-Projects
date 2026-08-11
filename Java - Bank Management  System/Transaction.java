import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type; // "DEPOSIT" or "WITHDRAWAL"
    private double amount;
    private double postBalance;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, double postBalance) {
        this.type = type;
        this.amount = amount;
        this.postBalance = postBalance;
        this.timestamp = LocalDateTime.now();
    }

    public void displayTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("[%s] %-10s | Amount: ₹%-10.2f | Balance: ₹%.2f\n",
                timestamp.format(formatter), type, amount, postBalance);
    }
}