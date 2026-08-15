import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public abstract int getMaxBorrowLimit();

    public boolean canBorrow() {
        return borrowedBooks.size() < getMaxBorrowLimit();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayUserDetails() {
        System.out.println("\n--- User Details ---");
        System.out.println("User ID       : " + userId);
        System.out.println("Name          : " + name);
        System.out.println("Books Borrowed: " + borrowedBooks.size() + " / " + getMaxBorrowLimit());
    }
}

// Student Subclass: Allows borrowing up to 3 books
class Student extends User {
    public Student(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }
}

// Faculty Subclass: Allows borrowing up to 5 books
class Faculty extends User {
    public Faculty(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }
}