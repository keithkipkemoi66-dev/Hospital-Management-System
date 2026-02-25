public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;   // using this
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void displayInfo();
}
public abstract class Staff extends Person {
    private double salary;

    public Staff(String name, int age, double salary) {
        super(name, age);   // using super
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public abstract void work();
}
public interface Payable {
    double calculatePay();
}
public interface Treatable {
    void treatPatient();
}
public class Doctor extends Staff implements Payable, Treatable {

    private String specialization;

    public Doctor(String name, int age, double salary, String specialization) {
        super(name, age, salary);
        this.specialization = specialization;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is diagnosing patients.");
    }

    @Override
    public double calculatePay() {
        return getSalary() + 5000; // bonus
    }

    @Override
    public void treatPatient() {
        System.out.println("Doctor treating patient in " + specialization);
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + getName() + ", Age: " + getAge() + ", Specialization: " + specialization);
    }
}
public class Nurse extends Staff implements Payable {

    public Nurse(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is assisting doctors.");
    }

    @Override
    public double calculatePay() {
        return getSalary();
    }

    @Override
    public void displayInfo() {
        System.out.println("Nurse: " + getName() + ", Age: " + getAge());
    }
}
public class Patient extends Person {

    private String illness;

    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    public String getIllness() {
        return illness;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient: " + getName() + ", Illness: " + illness);
    }
}
public class Hospital {

    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void showHospitalName() {
        System.out.println("Welcome to " + hospitalName);
    }
}
public class Main {

    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital");
        hospital.showHospitalName();

        Doctor doc = new Doctor("Dr. Smith", 45, 80000, "Cardiology");
        Nurse nurse = new Nurse("Mary", 30, 40000);
        Patient patient = new Patient("John", 25, "Flu");

        // Demonstrating inheritance & polymorphism
        doc.displayInfo();
        doc.work();
        doc.treatPatient();
        System.out.println("Doctor Pay: " + doc.calculatePay());

        System.out.println();

        nurse.displayInfo();
        nurse.work();
        System.out.println("Nurse Pay: " + nurse.calculatePay());

        System.out.println();

        patient.displayInfo();
    }
}