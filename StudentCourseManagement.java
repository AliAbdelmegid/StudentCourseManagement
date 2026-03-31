import java.util.ArrayList;
import java.util.Scanner;

// ===== Course Class =====
class Course {
    int id;
    String title;

    Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + " - " + title;
    }
}

// ===== Student Class =====
class Student {
    int id;
    String name;
    ArrayList<Course> courses = new ArrayList<>(); // Student hat mehrere Kurse

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
    }

    public String toString() {
        return id + " - " + name + " | Courses: " + courses;
    }
}

// ===== Main Class =====
public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Show Students");
            System.out.println("4. Show Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) addStudent();
            else if (choice == 2) addCourse();
            else if (choice == 3) showStudents();
            else if (choice == 4) showCourses();
            else if (choice == 5) enrollStudent();
            else if (choice == 6) System.out.println("Bye!");
            else System.out.println("Invalid choice");

        } while (choice != 6);
    }

    // ===== Methods =====
    static void addStudent() {
        System.out.print("Student ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added!");
    }

    static void addCourse() {
        System.out.print("Course ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        courses.add(new Course(id, title));
        System.out.println("Course added!");
    }

    static void showStudents() {
        if(students.size() == 0) System.out.println("No students.");
        else {
            for(int i=0; i<students.size(); i++) {
                System.out.println(students.get(i));
            }
        }
    }

    static void showCourses() {
        if(courses.size() == 0) System.out.println("No courses.");
        else {
            for(int i=0; i<courses.size(); i++) {
                System.out.println(courses.get(i));
            }
        }
    }

    static void enrollStudent() {
        System.out.print("Student ID: ");
        int sid = sc.nextInt(); sc.nextLine();
        Student student = null;
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).id == sid) {
                student = students.get(i);
                break;
            }
        }
        if(student == null) { System.out.println("Student not found."); return; }

        System.out.print("Course ID: ");
        int cid = sc.nextInt(); sc.nextLine();
        Course course = null;
        for(int i=0; i<courses.size(); i++) {
            if(courses.get(i).id == cid) {
                course = courses.get(i);
                break;
            }
        }
        if(course == null) { System.out.println("Course not found."); return; }

        student.enroll(course);
        System.out.println("Student enrolled!");
    }
}
