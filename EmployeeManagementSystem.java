import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagementSystem managementSystem = new ManagementSystem();

        // Load employees from file if available
        managementSystem.loadEmployeesFromFile("employees.dat");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Calculate Average Salary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        
                        System.out.print("Enter Employee Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter Employee Position: ");
                        String position = scanner.nextLine();
                        
                        System.out.print("Enter Employee Salary: ");
                        double salary = scanner.nextDouble();
                        
                        Employee employee = new Employee(id, name, position, salary);
                        managementSystem.addEmployee(employee);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    managementSystem.displayEmployees();
                    break;
                case 3:
                    managementSystem.calculateAverageSalary();
                    break;
                case 4:
                    managementSystem.saveEmployeesToFile("employees.dat");
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
