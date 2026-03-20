package HOSPITALMANAGEMENTSYSTEM;

public class Doctor extends Employee implements MedicalAction {
    private String specialty;

    public Doctor(String name, int id, double salary, String specialty) {
        super(name, id, salary);
        this.specialty = specialty;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Doctor] " + getName() + " (ID: " + getId() + ") | Specialty: " + specialty);
    }

    @Override
    public void performDuty() {
        System.out.println("Dr. " + getName() + " is currently examining patients.");
    }
}
