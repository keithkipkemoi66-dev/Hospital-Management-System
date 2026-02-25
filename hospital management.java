/**
 * 1. IManageable (Interface)
 * Purpose: Defines a standard contract for database operations[cite: 2, 3].
 */
class IManageable {
    constructor() {
        if (this.constructor === IManageable) {
            throw new Error("Interface 'IManageable' cannot be instantiated.");
        }
    }
    saveData() { throw new Error("Method 'saveData()' must be implemented."); } [cite: 7]
    deleteData() { throw new Error("Method 'deleteData()' must be implemented."); } [cite: 8]
}

/**
 * 2. Person (Abstract Class)
 * Purpose: Base for all human-related classes[cite: 9, 11].
 */
class Person {
    static totalPeopleCount = 0; // Class (Static) attribute [cite: 16]

    constructor(name, age, contactInfo) {
        if (this.constructor === Person) {
            throw new Error("Abstract class 'Person' cannot be instantiated.");
        }
        // Encapsulation: Private-like attributes using underscores
        this._name = name; [cite: 14]
        this._age = age; [cite: 14]
        this._contactInfo = contactInfo; [cite: 14]
        Person.totalPeopleCount++; [cite: 16]
    }

    // Concrete method [cite: 21]
    updateContact(newContact) {
        this._contactInfo = newContact;
        console.log(`Contact updated for ${this._name}`);
    }

    // Pure virtual method [cite: 19]
    performRole() {
        throw new Error("Method 'performRole()' must be implemented.");
    }
}

/**
 * 3. Patient (Concrete Class)
 * Inherits from Person[cite: 22, 23].
 */
class Patient extends Person {
    constructor(name, age, contactInfo, patientID, ailment) {
        super(name, age, contactInfo); // Constructor usage [cite: 29]
        this._patientID = patientID; [cite: 27]
        this._ailment = ailment; [cite: 27]
        this._billAmount = 0.0; [cite: 27]
    }

    // Method Overriding [cite: 29]
    performRole() {
        console.log(`Patient ${this._name} is recovering from ${this._ailment}.`);
    }

    payBill(amount) { [cite: 30]
        this._billAmount = amount;
        console.log(`Bill of $${this._billAmount} paid for Patient ID: ${this._patientID}`);
    }
}

/**
 * 4. Doctor (Concrete Class)
 * Inherits from Person and implements IManageable logic[cite: 31, 32].
 */
class Doctor extends Person {
    constructor(name, age, contactInfo, employeeID, specialization) {
        super(name, age, contactInfo); [cite: 36]
        this._employeeID = employeeID; [cite: 34]
        this._specialization = specialization; [cite: 34]
        this._isAvailable = true; [cite: 34]
    }

    performRole() { [cite: 36]
        console.log(`Dr. ${this._name} is conducting a ${this._specialization} consultation.`);
    }

    // Implementation of IManageable methods [cite: 38]
    saveData() {
        console.log(`Saving Doctor ${this._employeeID} credentials to database...`);
    }

    deleteData() {
        console.log(`Removing Doctor ${this._employeeID} from registry.`);
    }
}

/**
 * 5. Ward (Concrete Class)
 * Represents physical hospital location[cite: 39, 40].
 */
class Ward {
    static occupiedBeds = 0; // Static occupancy tracker [cite: 43]

    constructor(wardNumber, capacity, wardType) { [cite: 45]
        this._wardNumber = wardNumber; [cite: 42]
        this._capacity = capacity; [cite: 42]
        this._wardType = wardType; [cite: 42]
    }

    checkAvailability() { [cite: 46]
        return Ward.occupiedBeds < this._capacity;
    }

    assignPatient() { [cite: 48]
        if (this.checkAvailability()) {
            Ward.occupiedBeds++;
            console.log(`Patient assigned to Ward ${this._wardNumber}. Total occupancy: ${Ward.occupiedBeds}`);
        } else {
            console.log("Ward is full!");
        }
    }
}

// --- MAIN EXECUTION ---

// 1. Create Objects
const doc1 = new Doctor("Christopher Kabucho", 45, "doc.chris@hospital.com", "DOC001", "Cardiology");
const pat1 = new Patient("Emmanuel Okoth", 28, "emman.ok@mail.com", "PAT555", "Flu");
const icuWard = new Ward(101, 2, "ICU");

// 2. Demonstrate Inheritance and Method Overriding
console.log(`--- Hospital System Log ---`);
doc1.performRole(); // Dr. Christopher Kabucho is conducting a Cardiology consultation.
pat1.performRole(); // Patient Emmanuel Okoth is recovering from Flu.

// 3. Demonstrate Encapsulation and Concrete Methods
pat1.updateContact("new.email@okoth.com");

// 4. Demonstrate Interface implementation
doc1.saveData();

// 5. Demonstrate Static Attributes and Ward Logic
icuWard.assignPatient();
console.log(`Total people registered in system: ${Person.totalPeopleCount}`);