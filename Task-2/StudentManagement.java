import java.util.*;
public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();   
                    
                list.add(new Student(id, name, marks));
                System.out.println("Student Added Successfully!");
                    break;

                case 2:    if (list.isEmpty()) {
                        System.out.println("No Students to Display.");
                    } else {
                        for (Student s : list) {
                            System.out.println(s);
                        }
                    }
                    break; 

                case 3: 
                 System.out.print("Enter ID to Update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    
                    for (Student s : list) {
                        if (s.getStudentId() == updateId) {
                            sc.nextLine(); // Consume newline
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter New Marks: ");
                            double newMarks = sc.nextDouble();

                            s.setStudentName(newName);
                            s.setStudentMarks(newMarks);
                            System.out.println("Student Updated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found.");
                    }
                    break;

                        case 4:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = false;

                    for (Student s : list) {
                        if (s.getStudentId() == deleteId) {
                            list.remove(s);
                            System.out.println("Student Deleted Successfully!");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student Not Found.");
                    }
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
