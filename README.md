import java.util.ArrayList;
import java.util.Scanner;

public abstract class Employee {
    protected int id;
    protected String name;
    protected double baseSalary;

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Full-Time");
        System.out.println("Salary: $" + calculateSalary());
    }
}

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0); // baseSalary not used
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Part-Time");
        System.out.println("Salary: $" + calculateSalary());
    }
}


public class PayrollSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            System.out.println("\n--- Payroll System Menu ---");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addFullTimeEmployee();
                case 2 -> addPartTimeEmployee();
                case 3 -> displayEmployees();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private void addFullTimeEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Base Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = scanner.nextDouble();

        employees.add(new FullTimeEmployee(id, name, salary, bonus));
    }

    private void addPartTimeEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Hours Worked: ");
        int hours = scanner.nextInt();
        System.out.print("Enter Hourly Rate: ");
        double rate = scanner.nextDouble();

        employees.add(new PartTimeEmployee(id, name, hours, rate));
    }

    

    private void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println("\n--- Employee Details ---");
            emp.displayInfo();
        }
    }
}






public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.run();
    }
}

