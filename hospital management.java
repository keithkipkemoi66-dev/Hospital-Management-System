// Interface 1: As per your design [cite: 2, 4]
interface IManageable {
    void saveData(); // Pure virtual equivalent [cite: 7]
    void deleteData(); // Pure virtual equivalent [cite: 8]
}

// Interface 2: For billing systems
interface IBillable {
    void calculateFinalCharges(); 
    void printInvoice();
}
// Abstract Class 1: Person [cite: 9]
abstract class Person {
    private String name; // Encapsulation [cite: 14]
    private int age; // [cite: 14]
    private String contactInfo; // [cite: 14]
    static int totalPeopleCount = 0; // Static tracker [cite: 16]

    public Person(String name, int age, String contactInfo) {
        this.name = name; // Use of 'this' [cite: 18]
        this.age = age;
        this.contactInfo = contactInfo;
        totalPeopleCount++;
    }

    // Concrete method [cite: 21]
    public void updateContact(String newContact) {
        this.contactInfo = newContact;
        System.out.println("Contact updated for: " + this.name);
    }

    public abstract void performRole(); // Pure virtual [cite: 19]
    
    // Getters for Encapsulation
    public String getName() { return name; }
}

// Abstract Class 2: Facility
abstract class HospitalFacility {
    protected String locationBlock;

    public HospitalFacility(String block) {
        this.locationBlock = block;
    }

    public abstract void performMaintenance();
}
// Concrete Class 1: Patient [cite: 22]
class Patient extends Person implements IBillable {
    private String patientID; // [cite: 27]
    private String ailment; // [cite: 27]
    private double billAmount; // [cite: 27]

    public Patient(String n, int a, String c, String id, String ailment) {
        super(n, a, c); // Use of 'super' [cite: 29]
        this.patientID = id;
        this.ailment = ailment;
    }

    @Override
    public void performRole() { // Method overriding [cite: 29]
        System.out.println("Patient " + getName() + " is currently in recovery for " + ailment);
    }

    @Override
    public void calculateFinalCharges() { // [cite: 30]
        this.billAmount = 500.00; 
        System.out.println("Charges calculated for ID: " + patientID);
    }

    @Override
    public void printInvoice() {
        System.out.println("Invoice for " + getName() + ": $" + billAmount);
    }
}

// Concrete Class 2: Doctor [cite: 31]
class Doctor extends Person implements IManageable {
    private String employeeID; // [cite: 34]
    private String specialization; // [cite: 34]

    public Doctor(String n, int a, String c, String id, String spec) {
        super(n, a, c); // [cite: 36]
        this.employeeID = id;
        this.specialization = spec;
    }

    @Override
    public void performRole() { // [cite: 36]
        System.out.println("Dr. " + getName() + " is performing a " + specialization + " consultation.");
    }

    @Override
    public void saveData() { // [cite: 38]
        System.out.println("Saving credentials for Doctor ID: " + employeeID);
    }

    @Override
    public void deleteData() { // [cite: 38]
        System.out.println("Removing Doctor " + employeeID + " from active registry.");
    }
}

// Concrete Class 3: Ward [cite: 39]
class Ward extends HospitalFacility {
    private int wardNumber; // [cite: 42]
    private int capacity; // [cite: 42]
    static int occupiedBeds = 0; // [cite: 43]

    public Ward(String block, int num, int cap) {
        super(block);
        this.wardNumber = num;
        this.capacity = cap;
    }

    public void assignPatient() { // [cite: 48]
        if (occupiedBeds < capacity) {
            occupiedBeds++;
            System.out.println("Patient assigned to Ward " + wardNumber);
        }
    }

    @Override
    public void performMaintenance() {
        System.out.println("Sanitizing Ward " + wardNumber + " in Block " + locationBlock);
    }
}
public class HospitalMain {
    public static void main(String[] args) {
        // Instantiate Objects
        Doctor doc = new Doctor("Christopher Kabucho", 45, "0711...", "DOC224138", "Surgeon");
        Patient pat = new Patient("Emmanuel Okoth", 22, "0722...", "PAT224614", "Malaria");
        Ward icu = new Ward("Emergency-Wing", 101, 5);

        // Demonstrate Inheritance and Polymorphism
        System.out.println("--- System Activity ---");
        doc.performRole();
        pat.performRole();

        // Demonstrate Interface usage
        System.out.println("\n--- Database & Billing ---");
        doc.saveData();
        pat.calculateFinalCharges();
        pat.printInvoice();

        // Demonstrate Static Attributes & Encapsulation
        System.out.println("\n--- Statistics ---");
        icu.assignPatient();
        System.out.println("Total People in System: " + Person.totalPeopleCount);
        
        // Group Members: [cite: 50, 51, 52, 53, 54, 55]
    }
}