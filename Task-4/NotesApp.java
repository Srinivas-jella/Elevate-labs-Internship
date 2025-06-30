import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
public class NotesApp {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice = 0;
        while (choice!=3) {
            System.out.println("---Notes App---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Write your notes: ");
                    String notes = scanner.nextLine();
                    try {
                        FileWriter fWriter = new FileWriter("notes.txt",true);
                        fWriter.write(notes+"\n");
                        fWriter.close();
                        System.out.println("Notes saved!");
                        
                    } catch (IOException e) {
                        System.out.println("Error while saving the note..");
                    }
                    break;

                case 2:
                    System.out.println("--Your notes--");
                    try {
                        BufferedReader reader= new BufferedReader(new FileReader("notes.txt"));
                        String line;
                        while ((line=reader.readLine())!=null) {
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error reading the file.");
                    }
                    break;

                case 3:
                System.out.println("Exiting..");
                break;  

                default:
                    System.out.println("Invalid Input.. try again");
                    break;
            }

        }
        
        scanner.close();
        
    }
}