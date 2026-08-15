import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    // Register User
    public void registerUser(User user) {
        users.put(user.getUserId(), user);
        System.out.println("User registered successfully: " + user.getName());
    }

    // Issue Book
    public void issueBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }
        if (user == null) {
            System.out.println("Error: User not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Error: Book is already issued to someone else.");
            return;
        }
        if (!user.canBorrow()) {
            System.out.println("Error: User reached borrow limit (" + user.getMaxBorrowLimit() + " books).");
            return;
        }

        book.setIssued(true);
        user.borrowBook(book);
        System.out.println("Success: Book '" + book.getTitle() + "' issued to " + user.getName());
    }

    // Return Book
    public void returnBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Error: Invalid Book ID or User ID.");
            return;
        }
        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("Error: This user did not borrow this book.");
            return;
        }

        book.setIssued(false);
        user.returnBook(book);
        System.out.println("Success: Book '" + book.getTitle() + "' returned successfully.");
    }

    // Display All Books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library catalog.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        for (Book b : books.values()) {
            b.displayBook();
        }
    }
}
