package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(new ArrayList<>());

        System.out.println("Welcome to the Library.Library Management System");

        System.out.println("Press 1 to add a book");
        System.out.println("Press 2 to issue a book");
        System.out.println("Press 3 to return a book");
        System.out.println("Press 4 to display all books");


        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("Enter the name of the book you want to add");
                String name = scanner.next();
                System.out.println("Enter the author of the book you want to add");
                String author = scanner.next();
                library.addBook(new Book(name, author));
            }
            break;
            case 2: {
                System.out.println("Enter the name of the book you want to issue");
                String name = scanner.nextLine();
                if (!library.checkBookExists(new Book(name, null))) {
                    System.out.println("Book does not exist");
                    return;
                }
                if (!library.checkIfBookAvailable(new Book(name, null))) {
                    System.out.println("Book is not available");
                    return;
                }
                Book b = library.findBook(name);
                System.out.println("Enter the name of the person you are issuing the book to");
                String issuedTo = scanner.next();
                System.out.println("Todays date is " + java.time.LocalDate.now());
                library.issueBook(b, issuedTo, java.time.LocalDate.now().toString());
            }
            break;
            case 3: {
                System.out.println("Enter the name of the book you want to return");
                String name = scanner.next();
                if (!library.checkBookExists(new Book(name, null))) {
                    System.out.println("Book does not exist");
                    return;
                }
                if (library.checkIfBookAvailable(new Book(name, null))) {
                    System.out.println("Book is not issued");
                    return;
                }
                Book b = library.findBook(name);
                library.returnBook(b);
            }
            break;
            case 4: {
                library.displayBooks();
            }
        }
        System.out.println("Do you want to perform another operation? Press 1 for yes and 2 for no");
        int choice = scanner.nextInt();
        if (choice == 1) {
            main(args);
        }
        if (choice == 2) {
            System.out.println("Thank you for using the Library Management System");
        }
    }
}
