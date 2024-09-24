import java.io.Serializable;

public class Employee implements Serializable {
    private int employeeID;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeID, String name, String position, double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}
