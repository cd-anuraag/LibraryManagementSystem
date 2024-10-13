package Library;

public class Book {
    private final String name;
    private final String author;
    private String issuedTo;
    private String issuedOn;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void issueBook(String issuedTo, String issuedOn) {
        this.issuedTo = issuedTo;
        this.issuedOn = issuedOn;
    }

    public void returnBook() {
        this.issuedTo = null;
        this.issuedOn = null;
    }
}