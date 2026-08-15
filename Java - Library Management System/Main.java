import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Add New Book");
            System.out.println("2. Register Member (Student/Faculty)");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bId, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String uId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Type (1 for Student, 2 for Faculty): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        library.registerUser(new Student(uId, name));
                    } else if (type == 2) {
                        library.registerUser(new Faculty(uId, name));
                    } else {
                        System.out.println("Invalid member type.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String issueUId = scanner.nextLine();
                    library.issueBook(issueBId, issueUId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String retBId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String retUId = scanner.nextLine();
                    library.returnBook(retBId, retUId);
                    break;

                case 5:
                    library.displayAllBooks();
                    break;

                case 6:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Select between 1 and 6.");
            }
        }
    }
}