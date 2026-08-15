# 📚 Terminal-Based Library Management System (Java)

A modular, terminal-driven Library Management System implemented in Core Java. This project demonstrates foundational Object-Oriented Programming (OOP) principles by modeling real-world library operations such as catalog management, member tier registration (Students vs. Faculty), book checkouts, and returns.

---

## ✨ Features

* **Role-Based Membership**:
  * **Student**: Allowed to borrow up to **3 books** simultaneously.
  * **Faculty**: Allowed to borrow up to **5 books** simultaneously.
* **Catalog Management**:
  * Add new books with unique Book IDs, titles, and authors.
  * View complete catalog with live availability status (`AVAILABLE` vs. `ISSUED`).
* **Circulation Operations**:
  * **Issue Book**: Validates book availability and member quota before checkout.
  * **Return Book**: Verifies ownership against user's borrowed list and updates catalog status.
* **In-Memory Performance**: $O(1)$ constant-time lookup using Java `HashMap` for both books and users.

---

## 🛠️ OOP Principles Demonstrated

* **Encapsulation**: Class fields (`id`, `title`, `borrowedBooks`, `isIssued`) are strictly `private`, accessible only via validated getters, setters, and business methods.
* **Abstraction**: `abstract class User` defines the base blueprint and enforces the contractual implementation of `getMaxBorrowLimit()`.
* **Inheritance**: `Student` and `Faculty` extend `User`, reusing member state and identity management without duplicated code.
* **Polymorphism**: `user.canBorrow()` dynamically resolves each subclass's borrowing quota at runtime without explicit type casting.

---

## 📂 Project Structure

```text
├── Book.java      # Book entity with availability state
├── User.java      # Abstract User base class + Student/Faculty subclasses
├── Library.java   # Central manager coordinating books, users, and transactions
└── Main.java      # Command Line Interface (CLI) entry point