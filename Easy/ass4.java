import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class ass4{
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Salary: "); double salary = sc.nextDouble();
        employees.add(new Employee(id, name, salary));
    }

    public static void updateEmployee() {
        System.out.print("Enter ID to update: "); int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: "); e.name = sc.nextLine();
                System.out.print("Enter New Salary: "); e.salary = sc.nextDouble();
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void removeEmployee() {
        System.out.print("Enter ID to remove: "); int id = sc.nextInt();
        employees.removeIf(e -> e.id == id);
    }

    public static void searchEmployee() {
        System.out.print("Enter ID to search: "); int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add 2. Update 3. Remove 4. Search 5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}