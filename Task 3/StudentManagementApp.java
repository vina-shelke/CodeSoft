package task3;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1/2/3/4/5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's roll number: ");
                    int rollNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println("Name and grade are required fields.");
                    } else {
                        Student student = new Student(name, rollNumber, grade);
                        sms.addStudent(student);
                        System.out.println("Student added successfully!");
                    }
                    break;

                case "2":
                    System.out.print("Enter the roll number of the student to remove: ");
                    int removeRollNumber = Integer.parseInt(scanner.nextLine());
                    if (sms.removeStudent(removeRollNumber)) {
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case "3":
                    System.out.print("Enter the roll number of the student to search: ");
                    int searchRollNumber = Integer.parseInt(scanner.nextLine());
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case "4":
                    sms.displayAllStudents();
                    break;

                case "5":
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
