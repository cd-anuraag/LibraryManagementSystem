package Library;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    public ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }


    public void addBook(Book book) {
        books.add(book);
        System.out.println("Library.Library.Book added successfully");
    }

    public void issueBook(Book book, String issuedTo, String issuedOn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                if (books.get(i).getIssuedTo() != null) {
                    System.out.println("Library.Library.Book is already issued");
                    return;
                }
            }
        }
        book.issueBook(issuedTo, issuedOn);
        System.out.println("Library.Library.Book issued successfully");
    }

    public void returnBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                if (Objects.equals(books.get(i).getIssuedTo(), book.getIssuedTo())) {
                    books.get(i).returnBook();
                    System.out.println("Library.Library.Book returned successfully");
                    return;
                }
            }
        }

    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Library.Library.Book Name: " + books.get(i).getName());
            System.out.println("Author: " + books.get(i).getAuthor());
            System.out.println("Issued To: " + books.get(i).getIssuedTo());
            System.out.println("Issued On: " + books.get(i).getIssuedOn());
            System.out.println();
        }
    }

    public boolean checkBookExists(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfBookAvailable(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                return books.get(i).getIssuedTo() == null;
            }
        }
        return false;
    }

    public Book findBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                return books.get(i);
            }
        }
        return null;
    }

}
