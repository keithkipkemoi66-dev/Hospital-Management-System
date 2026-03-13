package HOSPITALMANAGEMENTSYSTEM;

public class Patient extends HospitalStaff implements Evaluatable {
    private double gpa;

    public Patient(String name, int id, double gpa) {
        super(name, id);
        this.gpa = gpa;
    }

    @Override
    public void displayRole() {
        System.out.println("[Student] Name: " + getName() + " | GPA: " + gpa);
    }

    @Override
    public void evaluatePerformance() {
        System.out.println("Evaluating student " + getName() + " based on Semester GPA.");
    }
}