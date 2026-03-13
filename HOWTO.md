# Hospital Management System (OOP)

## Project Description
This is a Java-based Hospital Management System designed to demonstrate core Object-Oriented Programming (OOP) principles. The system manages three main types of people: **Doctors**, **Nurses**, and **Patients**. It allows for dynamic data entry and ensures data integrity through robust exception handling.

## OOP Principles Implemented
* **Encapsulation:** Used private attributes with public getters and setters in the `Person` and `HospitalStaff` classes.
* **Inheritance:** Established an "IS-A" relationship where `Doctor` and `Nurse` inherit from `HospitalStaff`, which inherits from `Person`.
* **Abstraction:** Created `Person` and `HospitalStaff` as abstract classes to prevent direct instantiation of generic entities.
* **Polymorphism:** Overrode the `displayInfo()` method across different subclasses to provide specific behaviors.
* **Interfaces:** Implemented `MedicalAction` (for clinical duties) and `Billable` (for financial transactions).

## Dynamic Features & Robustness
### User Input
The system uses the `Scanner` class within a `while` loop in `HospitalSystem.java`, allowing users to choose which type of record to create and input data in real-time.

### Exceptions Implemented
1.  **InputMismatchException:**
    * **Scenario:** If a user enters a name (String) when the system asks for an ID (Integer).
    * **Handling:** The program catches the error, displays a friendly message, clears the scanner buffer, and allows the user to try again without crashing.
2.  **Generic Exception Catch:**
    * **Scenario:** Any unforeseen runtime errors.
    * **Handling:** A top-level `catch(Exception e)` block ensures the program stays alive even if an unexpected error occurs.
3.  **Finally Block:**
    * **Purpose:** Executes a "System update check" log after every attempt, ensuring that cleanup or logging occurs regardless of success or failure.

## How to Run the Project
1.  Download or clone the repository.
2.  Open your terminal or IDE.
3.  Compile the files: `javac *.java`
4.  Run the main program: `java HospitalSystem`