package myfirstproject;
import java.util.*;

class Book {
    private String bookId;
    private String title;
    private boolean isAvailable;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDetails() {
        return "Book ID: " + bookId + ", Title: " + title + ", Available: " + isAvailable;
    }

    public void markAsLoaned() {
        isAvailable = false;
    }

    public void markAsReturned() {
        isAvailable = true;
    }
}

class Borrower {
    private String borrowerId;
    private String name;
    private Book borrowedBook;
    
    
     
    public Borrower(String borrowerId, String name) {
        this.borrowerId = borrowerId;
        this.name = name;
        this.borrowedBook = null;
    }

    public boolean borrowBook(Book book) {
        if (borrowedBook == null && book.isAvailable()) {
            borrowedBook = book;
            book.markAsLoaned();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBook != null && borrowedBook == book) {
            book.markAsReturned();
            borrowedBook = null;
            return true;
        }
        return false;
    }
  
    
}
class Library {
    private List<Book> books=new ArrayList<>();;
   
    public void addBook(Book book) {
        books.add(book);
    }
    
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public boolean loanBook(String bookId, Borrower borrower) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            return borrower.borrowBook(book);
        }
        return false;
    }

    public boolean returnBook(String bookId, Borrower borrower) {
        Book book = findBookById(bookId);
        if (book != null) {
            return borrower.returnBook(book);
        }
        return false;
    }

    public void displayBooks() {
        System.out.println("\nCurrent Library Books:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }
}

public class librarymanagement {
    public static void main(String[] args)
    {
        Library library = new Library();

        Book book1 = new Book("B001", "Java Programming");
        Book book2 = new Book("B002", "Data Structures");
        Book book3 = new Book("B003", "Algorithms");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Borrower borrower1 = new Borrower("BR01", "Ravi");

        boolean borrowResult1 = library.loanBook("B001", borrower1);
        System.out.println("Ravi borrowed B001: " + borrowResult1);

        boolean borrowResult2 = library.loanBook("B002", borrower1);
        System.out.println("Ravi tried to borrow B002: " + borrowResult2);

        library.displayBooks();

        boolean returnResult = library.returnBook("B001", borrower1);
        System.out.println("Ravi returned B001: " + returnResult);

        boolean borrowResult3 = library.loanBook("B002", borrower1);
        System.out.println("Ravi borrowed B002: " + borrowResult3);

        library.displayBooks();
    }
}
