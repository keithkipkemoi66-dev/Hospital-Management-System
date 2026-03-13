package HOSPITALMANAGEMENTSYSTEM;

public abstract class Employee extends HospitalStaff implements Payable {
    private double salary;

    public Employee(String name, int id, double salary) {
        super(name, id); // Use of super to call parent constructor
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}