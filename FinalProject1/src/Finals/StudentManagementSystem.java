package Finals;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
	Scanner scanner = new Scanner(System.in);
	HashMap<String, Student> students;
	
	public StudentManagementSystem() {
		students = new HashMap<>();
	}
	
	public void displayMenu() {
		System.out.println("\n*** STUDENT MANAGEMENT SYSTEM ***");
		System.out.println("1. Add a new student");
		System.out.println("2. View all students");
		System.out.println("3. Update student information");
		System.out.println("4. Delete a student");
		System.out.println("5. Search for a student by ID");
		System.out.println("6. Exit the program");
		System.out.print("\nPlease enter your choice (1-6): ");
    }
	public void addStudent() {
		System.out.println("\n--- ADD STUDENT ---");
		
		System.out.print("Enter Student ID: ");
		String id = scanner.nextLine().trim();
        
		if (students.containsKey(id)) {
			System.out.println("Error: Student with ID " + id + " already exists!");
			return;
		}
		System.out.print("Enter Name: ");
		String name = scanner.nextLine().trim();
		
		System.out.print("Enter Course: ");
		String course = scanner.nextLine().trim();
		
		System.out.print("Enter Year Level: ");
		String yearLevel = scanner.nextLine().trim();
        
		if (name.isEmpty() || id.isEmpty() || course.isEmpty() || yearLevel.isEmpty()) {
			System.out.println("Error: All fields are required!");
			return;
		}
        
		Student student = new Student(name, id, course, yearLevel);
		students.put(id, student);
		System.out.println("Student added successfully!");
	}

	public void viewAllStudents() {
		System.out.println("\n--- ALL STUDENTS ---");
        
		if (students.isEmpty()) {
			System.out.println();
			System.out.println("No students found in the system.");
			return;
		}
		System.out.println("Total Students: " + students.size());
		System.out.println("");
		
		ArrayList<Student> studentList = new ArrayList<>(students.values());
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println((i + 1) + ". " + studentList.get(i));
		}
	}
	
	public void updateStudent() {
		System.out.println("\n--- UPDATE STUDENT ---");
		
		System.out.print("Enter Student ID: ");
		String id = scanner.nextLine();
		
		if (!students.containsKey(id)) {
			System.out.println("Error: Student with ID " + id + " not found!");
		    return;
		}
        
		Student student = students.get(id);
		System.out.println("Current Details: " + student);
		
		System.out.print("Enter new Name (current: " + student.getName() + "): ");
		String name = scanner.nextLine();
		if (!name.isEmpty()) {
			student.setName(name);
		}
        
		System.out.print("Enter new Course (current: " + student.getCourse() + "): ");
		String course = scanner.nextLine();
		if (!course.isEmpty()) {
		    student.setCourse(course);
		}
		
		System.out.print("Enter new Year Level (current: " + student.getYearLevel() + "): ");
		String yearLevel = scanner.nextLine();
		if (!yearLevel.isEmpty()) {
		    student.setYearLevel(yearLevel);
		}
		
		students.put(id, student);
		System.out.println("Student updated successfully!");
	}
		
    public void deleteStudent() {
		System.out.println("\n--- DELETE STUDENT ---");
		
		System.out.print("Enter Student ID to delete: ");
		String id = scanner.nextLine();
		
		if (!students.containsKey(id)) {
		    System.out.println("Error: Student with ID " + id + " not found!");
		    return;
		}
        
		Student student = students.get(id);
		System.out.println("Student to delete: " + student);
		
		System.out.print("Are you sure you want to delete this student? (y/n): ");
		String confirmation = scanner.nextLine();
		
		if (confirmation.equalsIgnoreCase("y")) {
		    students.remove(id);
		    System.out.println("Student deleted successfully!");
		} else {
			System.out.println("Deletion cancelled.");
		}
    }
    public void searchStudent() {
		System.out.println("\n--- SEARCH STUDENT ---");
		System.out.println("Available Student IDs:");
	    for (String studentId : students.keySet()) {
	    	System.out.println("ID: " + studentId);
	    }
		System.out.print("Enter Student ID to search: ");
		String id = scanner.nextLine();
		
		if (!students.containsKey(id)) {
		    System.out.println("Error: Student with ID " + id + " not found!");
		    return;
		}
		Student student = students.get(id);
		System.out.println("Student Found:");
		System.out.println(student);
	}

    public void run() {
    	System.out.println("Welcome to Student Management System!");

    	while (true) {
    		try {
				displayMenu();
				int choice = scanner.nextInt();
				scanner.nextLine(); 
					
				switch (choice) {
				    case 1:
				        addStudent();
				        break;
				    case 2:
				        viewAllStudents();
				        break;
				    case 3:
				    	viewAllStudents();
				        updateStudent();
				        break;
				    case 4:
				    	viewAllStudents();
				        deleteStudent();
				        break;
				    case 5:
				        searchStudent();
				        break;
				    case 6:
						System.out.println("Thank you for using Student Management System. Goodbye!");
						return;
				    default:
				    	System.out.println("Invalid option! Please choose 1-6.");
				}
    		} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number between 1-6.");
				scanner.nextLine(); 
            } catch (Exception e) {
            	System.out.println("An error occurred: " + e.getMessage());
            }
        } 
    }
}
