package studentmanagement;
import java.util.*;

public class StudentManagementSystem {
	    private List<Student> students = new ArrayList<>();

	    public void addStudent(Student student) {
	        students.add(student);
	        System.out.println("Student added successfully!");
	    }

	    public void displayAllStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students found.");
	            return;
	        }
	        for (Student s : students) {
	            System.out.println(s);
	        }
	    }

	    public Student searchStudentById(int id) {
	        for (Student s : students) {
	            if (s.getId() == id) {
	                return s;
	            }
	        }
	        return null;
	    }

	    public boolean deleteStudentById(int id) {
	        Student s = searchStudentById(id);
	        if (s != null) {
	            students.remove(s);
	            return true;
	        }
	        return false;
	    }

	    public boolean updateStudentById(int id, String name, int age, String course) {
	        Student s = searchStudentById(id);
	        if (s != null) {
	            s.setName(name);
	            s.setAge(age);
	            s.setCourse(course);
	            return true;
	        }
	        return false;
	    }
	}



