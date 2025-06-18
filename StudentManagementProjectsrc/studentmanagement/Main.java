package studentmanagement;
import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	        StudentManagementSystem sms = new StudentManagementSystem();
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n--- Student Management System ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display All Students");
	            System.out.println("3. Search Student by ID");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Age: ");
	                    int age = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Course: ");
	                    String course = sc.nextLine();
	                    sms.addStudent(new Student(id, name, age, course));
	                    break;

	                case 2:
	                    sms.displayAllStudents();
	                    break;

	                case 3:
	                    System.out.print("Enter ID to search: ");
	                    int sid = sc.nextInt();
	                    Student s = sms.searchStudentById(sid);
	                    System.out.println(s != null ? s : "Student not found.");
	                    break;

	                case 4:
	                    System.out.print("Enter ID to update: ");
	                    int uid = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter new Name: ");
	                    String uname = sc.nextLine();
	                    System.out.print("Enter new Age: ");
	                    int uage = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter new Course: ");
	                    String ucourse = sc.nextLine();
	                    if (sms.updateStudentById(uid, uname, uage, ucourse)) {
	                        System.out.println("Student updated successfully.");
	                    } else {
	                        System.out.println("Student not found.");
	                    }
	                    break;

	                case 5:
	                    System.out.print("Enter ID to delete: ");
	                    int did = sc.nextInt();
	                    if (sms.deleteStudentById(did)) {
	                        System.out.println("Student deleted.");
	                    } else {
	                        System.out.println("Student not found.");
	                    }
	                    break;

	                case 0:
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid choice.");
	            }
	        } while (choice != 0);

	        sc.close();
	    }
	}


