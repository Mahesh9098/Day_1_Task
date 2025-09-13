import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    @override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Grade=" + grade +
                '}';
    }
}

public class Main {  
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        double grade = scanner.nextDouble();

        Student student = new Student(id, name, grade);
        students.add(student);
        System.out.println("✅ Student Added Successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        boolean removed = false;
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("❌ Student Removed Successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("⚠ Student with ID " + id + " not found.");
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayStudents();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }

    public static void main(String[] args) {
        Main sms = new Main();
        sms.run();
    }
}
