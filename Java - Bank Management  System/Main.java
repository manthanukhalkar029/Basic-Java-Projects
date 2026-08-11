
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=================================");
            System.out.println("     BANK MANAGEMENT SYSTEM      ");
            System.out.println("=================================");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Account Details");
            System.out.println("6. Print Account Statement");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String savAccNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String savName = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double savBalance = scanner.nextDouble();
                    System.out.print("Enter Interest Rate (e.g. 0.05 for 5%): ");
                    double rate = scanner.nextDouble();

                    bank.createAccount(new SavingsAccount(savAccNum, savName, savBalance, rate));
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String chkAccNum = scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String chkName = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double chkBalance = scanner.nextDouble();
                    System.out.print("Enter Overdraft Limit: ");
                    double limit = scanner.nextDouble();

                    bank.createAccount(new CheckingAccount(chkAccNum, chkName, chkBalance, limit));
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String depAccNum = scanner.nextLine();
                    Account depAcc = bank.getAccount(depAccNum);
                    if (depAcc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amt = scanner.nextDouble();
                        depAcc.deposit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String withAccNum = scanner.nextLine();
                    Account withAcc = bank.getAccount(withAccNum);
                    if (withAcc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amt = scanner.nextDouble();
                        withAcc.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String infoAccNum = scanner.nextLine();
                    Account infoAcc = bank.getAccount(infoAccNum);
                    if (infoAcc != null) {
                        infoAcc.displayAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    String stmtAccNum = scanner.nextLine();
                    Account stmtAcc = bank.getAccount(stmtAccNum);
                    if (stmtAcc != null) {
                        stmtAcc.printAccountStatement();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    bank.displayAllAccounts();
                    break;

                case 8:
                    System.out.println("Thank you for using the Bank Management System!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please select between 1 and 7.");
            }
        }
    }
}
