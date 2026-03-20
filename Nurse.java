package HOSPITALMANAGEMENTSYSTEM;

public class Nurse extends Employee implements MedicalAction {
    private int floorLevel;

    public Nurse(String name, int id, double salary, int floorLevel) {
        super(name, id, salary);
        this.floorLevel = floorLevel;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Nurse] " + getName() + " (ID: " + getId() + ") | Assigned Floor: " + floorLevel);
    }

    @Override
    public void performDuty() {
        System.out.println("Nurse " + getName() + " is administering medication.");
    }
}
