import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    private List<Employee> employeeList;

    public ManagementSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == employee.getEmployeeID()) {
                throw new IllegalArgumentException("Employee ID must be unique.");
            }
        }
        employeeList.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    public void calculateAverageSalary() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to calculate average salary.");
            return;
        }
        double totalSalary = 0;
        for (Employee emp : employeeList) {
            totalSalary += emp.getSalary();
        }
        double averageSalary = totalSalary / employeeList.size();
        System.out.println("Average Salary: $" + averageSalary);
    }

    public void saveEmployeesToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
            System.out.println("Employee data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    public void loadEmployeesFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employeeList = (List<Employee>) ois.readObject();
            System.out.println("Employee data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data: " + e.getMessage());
        }
    }
}
