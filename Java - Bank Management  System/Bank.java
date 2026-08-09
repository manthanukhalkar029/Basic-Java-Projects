import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Account with this number already exists.");
        } else {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account created successfully for " + account.getAccountHolderName());
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found in the bank.");
            return;
        }
        for (Account account : accounts.values()) {
            account.displayAccountDetails();
        }
    }
}