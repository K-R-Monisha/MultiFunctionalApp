import java.util.*;

public class MultiFunctionApp {
    private static List<Book> books = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<String> todoList = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📌 Multi-Functional Java App");
            System.out.println("1. Binary-Decimal Converter");
            System.out.println("2. Library Management");
            System.out.println("3. Student Grade Manager");
            System.out.println("4. To-Do List Manager");
            System.out.println("5. Employee Record System");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: binaryDecimalConverter(scanner); break;
                case 2: libraryManagement(scanner); break;
                case 3: studentGradeManager(scanner); break;
                case 4: toDoListManager(scanner); break;
                case 5: employeeRecordSystem(scanner); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }

    // 🟢 1. Binary-Decimal Converter
    private static void binaryDecimalConverter(Scanner scanner) {
        System.out.print("Enter 1 for Binary to Decimal or 2 for Decimal to Binary: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter a binary number: ");
            String binaryInput = scanner.nextLine();
            System.out.println("Decimal: " + Integer.parseInt(binaryInput, 2));
        } else if (choice == 2) {
            System.out.print("Enter a decimal number: ");
            int decimalInput = scanner.nextInt();
            System.out.println("Binary: " + Integer.toBinaryString(decimalInput));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // 🔴 2. Library Management System
    private static void libraryManagement(Scanner scanner) {
        while (true) {
            System.out.println("\n📚 Library Management");
            System.out.println("1. Add Book\n2. Remove Book\n3. Display Books\n4. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    books.add(new Book(title, author, ISBN));
                    System.out.println("Book added!");
                    break;
                case 2:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    books.removeIf(book -> book.getISBN().equals(removeISBN));
                    System.out.println("Book removed if found.");
                    break;
                case 3:
                    books.forEach(System.out::println);
                    break;
                case 4:
                    return;
            }
        }
    }

    // 🔵 3. Student Grade Manager
    private static void studentGradeManager(Scanner scanner) {
        while (true) {
            System.out.println("\n🎓 Student Grade Manager");
            System.out.println("1. Add Student\n2. Show Students\n3. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    students.add(new Student(name, grade));
                    System.out.println("Student added.");
                    break;
                case 2:
                    students.forEach(System.out::println);
                    break;
                case 3:
                    return;
            }
        }
    }

    // 🟡 4. To-Do List Manager
    private static void toDoListManager(Scanner scanner) {
        while (true) {
            System.out.println("\n✅ To-Do List");
            System.out.println("1. Add Task\n2. Remove Task\n3. Show Tasks\n4. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    todoList.add(scanner.nextLine());
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task number to remove: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (taskIndex > 0 && taskIndex <= todoList.size()) {
                        todoList.remove(taskIndex - 1);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ". " + todoList.get(i));
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    // 🟠 5. Employee Record System
    private static void employeeRecordSystem(Scanner scanner) {
        while (true) {
            System.out.println("\n👔 Employee Records");
            System.out.println("1. Add Employee\n2. Show Employees\n3. Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    employees.add(new Employee(name, position));
                    System.out.println("Employee added.");
                    break;
                case 2:
                    employees.forEach(System.out::println);
                    break;
                case 3:
                    return;
            }
        }
    }

    // 📕 Book Class
    static class Book {
        private String title, author, ISBN;
        public Book(String title, String author, String ISBN) {
            this.title = title; this.author = author; this.ISBN = ISBN;
        }
        public String getISBN() { return ISBN; }
        public String toString() { return "📖 " + title + " by " + author + " (ISBN: " + ISBN + ")"; }
    }

    // 📗 Student Class
    static class Student {
        private String name;
        private int grade;
        public Student(String name, int grade) { this.name = name; this.grade = grade; }
        public String toString() { return "🎓 " + name + " - Grade: " + grade; }
    }

    // 📘 Employee Class
    static class Employee {
        private String name, position;
        public Employee(String name, String position) { this.name = name; this.position = position; }
        public String toString() { return "👔 " + name + " - " + position; }
    }
}
