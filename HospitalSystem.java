package HOSPITALMANAGEMENTSYSTEM;

import java.util.*;

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> records = new ArrayList<>();
        boolean exit = false;

        System.out.println("=== Hospital Management System v2.0 ===");

        while (!exit) {
            // TRY block: contains code that might throw an exception
            try {
                System.out.println("\nSelect an option:");
                System.out.println("1. Register Doctor");
                System.out.println("2. Register Patient");
                System.out.println("3. View Records & Exit");
                System.out.print("Choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                if (choice == 3) {
                    exit = true;
                    continue;
                }

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter ID Number: ");
                int id = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Specialty: ");
                    String specialty = sc.nextLine();

                    records.add(new Doctor(name, id, salary, specialty));
                    System.out.println("Doctor registered successfully.");

                } else if (choice == 2) {
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Ailment/Reason for Visit: ");
                    String ailment = sc.nextLine();

                    records.add(new Patient(name, id, ailment));
                    System.out.println("Patient registered successfully.");
                } else {
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }

            }
            // CATCH block: handles specific input errors (e.g., typing letters for ID)
            catch (InputMismatchException e) {
                System.err.println("Input Error: Please use numbers for ID, Choice, and Salary.");
                sc.nextLine(); // Clear the scanner buffer to prevent infinite loops
            }
            // CATCH block: handles any other unexpected errors
            catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
            // FINALLY block: executes regardless of whether an error happened or not
            finally {
                System.out.println(">> Transaction process completed.");
            }
        }

        // Final output demonstrating inheritance and method calls
        System.out.println("\n--- Final Hospital Directory ---");
        for (Person p : records) {
            p.displayInfo();
            if (p instanceof MedicalAction) {
                ((MedicalAction) p).performDuty();
            }
            if (p instanceof Billable) {
                ((Billable) p).generateInvoice();
            }
        }

        sc.close();
        System.out.println("System Shutdown.");
    }
}