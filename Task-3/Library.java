import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added.");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.isIssued()) {
                    System.out.println("Book Already Issued.");
                } else {
                    b.setIssued(true);
                    System.out.println("Book Issued.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                if (b.isIssued()) {
                    b.setIssued(false);
                    System.out.println("Book Returned.");
                } else {
                    System.out.println("Book is Not Issued.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }
}
