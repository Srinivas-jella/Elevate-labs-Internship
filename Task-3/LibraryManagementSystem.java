import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    
                    Book newBook = new Book(id, title, false);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Exiting... Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }
}
