# Terminal-Based Bank Management System (Java)

A modular, menu-driven Bank Management System built in Java that runs directly in the terminal. This project demonstrates core Object-Oriented Programming (OOP) concepts by simulating real-world banking operations such as creating savings/checking accounts, depositing, withdrawing, and viewing account details.

---

## ✨ Features

* **Account Types**:
  * **Savings Account**: Supports interest generation and enforces strict withdrawal limits based on available balance.
  * **Checking Account**: Includes an overdraft limit, allowing withdrawals beyond current balance up to a specified threshold.
* **Core Banking Operations**:
  * Create new Savings or Checking accounts.
  * Deposit and withdraw funds with input validation.
  * Check account details by Account Number.
  * Display a summary of all accounts registered in the system.
* **In-Memory Storage**: Fast $O(1)$ account lookup using Java `HashMap`.

---

## 🛠️ OOP Concepts Demonstrated

* **Encapsulation**: Account details (like balance) are kept `private` and accessed or modified safely through methods.
* **Abstraction**: An `abstract class Account` defines common properties and abstract method signatures for all account types.
* **Inheritance**: `SavingsAccount` and `CheckingAccount` extend `Account` to reuse base code and add specialized functionality.
* **Polymorphism**: Dynamic method dispatch allows `withdraw()` and `displayAccountDetails()` to execute distinct logic based on the actual account type at runtime.

---

## 📂 Project Structure

```text
├── Account.java         # Abstract base class for all accounts
├── SavingsAccount.java  # Subclass with interest rate logic
├── CheckingAccount.java # Subclass with overdraft limit logic
├── Bank.java           # Central manager handling account storage and lookups
└── Main.java           # Command Line Interface (CLI) entry point