import java.util.*;
public class studentManagementSystem {
    static int total = 0;
    static int rollNo[] = new int[1000];
    static String collegeName = "Haldia Institute of Technology";
    static String studentName[] = new String[1000];
    static String department = "Computer Science & Engineering";
    static Scanner sc = new Scanner(System.in);

    // Show Menu Bar
    public static void showMenu() {
        System.out.println("\n--- Menu Bar ---\n");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Calculate Report Card and Generate Marksheet.");
        System.out.println("7. Exit !");
    }

    // Add Student
    public static void addStudent() {
        sc.nextLine();
        System.out.print("Enter Student's Name : ");
        studentName[total] = sc.nextLine();

        System.out.print("Enter Roll No : ");
        int roll = sc.nextInt();
        if (roll > 0) {
            rollNo[total] = roll;
            total++;
            System.out.println("Student added Successfully !!");
        } else {
            System.out.println("Student is not added Successfully !!");
        }
    }

    // View Student
    public static void viewStudent() {
        if (total == 0) {
            System.out.println("Student is not founded !!");
        } else {
            System.out.println("Student List :- ");
            for (int i = 0; i < total; i++) {
                System.out.println(
                        "Name :- " + studentName[i] + ",  Roll No - " + rollNo[i] + ",  " + "College - " + collegeName);
            }
            System.out.println();
        }
    }

    // Search Student
    public static void searchStudent() {
        if (total == 0) {
            System.out.println("No Student is Founded !");
        } else {
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Roll");
            System.out.print("Enter Your Search Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name : ");
                    String search = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < total; i++) {
                        if (studentName[i].contains(search)) {
                            System.out.println("Student is Founded !");
                            System.out.println(
                                    (i + 1) + " Name = " + studentName[i] + " Roll No - " + rollNo[i] + " "
                                            + collegeName);

                            found = true;
                        }
                        if (!found) {
                            System.out.println("Student is not Found !!");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Student Roll : ");
                    int roll = sc.nextInt();
                    boolean foundByRoll = false;
                    for (int i = 0; i < total; i++) {
                        if (rollNo[i] == roll) {
                            System.out.println("Student is Founded !");
                            System.out.println(
                                    (i + 1) + " Name = " + studentName[i] + " Roll No - " + rollNo[i] + " "
                                            + collegeName);

                            foundByRoll = true;
                        }
                        if (!foundByRoll) {
                            System.out.println("Student is not Found !!");
                        }
                    }
                    break;
                default:
                    System.out.println("Enter Right Choice !");
            }

        }
    }

    // Update Student
    public static void updateStudent() {
        sc.nextLine();
        System.out.print("Enter Student Roll Number to Update : ");
        int update = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < total; i++) {
            if (rollNo[i] == update) {
                System.out.println("--- Enter New Details ---");
                sc.nextLine();
                System.out.print("Enter new Name : ");
                studentName[i] = sc.nextLine();
                System.out.print("Enter new Roll Number : ");
                int roll = sc.nextInt();
                if (roll > 0) {
                    rollNo[i] = roll;
                    System.out.println("Student details Update Successfully !");
                } else {
                    System.out.println("Invalid Roll !");
                }

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student is not Found !");
        }
    }

    // Delete Student
    public static void deleteStudent() {
        if (total == 0) {
            System.out.println("\nNo Student Found!\n");
            return;
        }
        System.out.print("Enter Roll to Delete from Data Base : ");
        int del = sc.nextInt();
        boolean deleted = false;

        for (int i = 0; i < total; i++) {
            if (rollNo[i] == del) {
                for (int j = i; j < total - 1; j++) {
                    studentName[j] = studentName[j + 1];
                    rollNo[j] = rollNo[j + 1];
                }
                total--;
                deleted = true;
                System.out.println("\nStudent Deleted Successfully.\n");
                break;
            }
        }
        if (!deleted) {
            System.out.println("\nStudent Not Found.\n");
        }
    }

    // Calculate Report Card and Generate Marksheet
    public static void card() {
        System.out.println("Coming Soon...!");
        return;
    }

    // Exit
    public static void exit() {
        System.out.println("Thank You !\n");
        return;
    }

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("\nEnter Your Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    card();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.err.println("Invalid Choice !");
            }
        } while (choice != 7);
        sc.close();
    }
}
