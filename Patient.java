package HOSPITALMANAGEMENTSYSTEM;

public class Patient extends Person implements Billable {
    private String ailment;

    public Patient(String name, int id, String ailment) {
        super(name, id); 
        this.ailment = ailment;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Patient] " + getName() + " (ID: " + getId() + ") | Ailment: " + ailment);
    }

    @Override
    public void generateInvoice() {
        System.out.println(">>> Generating medical bill for " + getName() + " (Treatment: " + ailment + ")");
    }
}
