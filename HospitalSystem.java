package HOSPITALMANAGEMENTSYSTEM;

import java.util.*;

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> records = new ArrayList<>();
        boolean exit = false;

        System.out.println(" Hospital Management System");

        while (!exit) {
            try {
                System.out.println("\nSelect an option:");
                System.out.println("1. Register Doctor");
                System.out.println("2. Register Nurse");
                System.out.println("3. Register Patient");
                System.out.println("4. View Records & Exit");
                System.out.print("Choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // Clear the scanner

                if (choice == 4) {
                    exit = true;
                    continue;
                }

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
                    continue;
                }

                // Everyone needs a name and ID
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter ID Number: ");
                int id = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine(); // Clear the scanner
                    System.out.print("Enter Specialty: ");
                    String specialty = sc.nextLine();
                    records.add(new Doctor(name, id, salary, specialty));
                    System.out.println("Doctor registered successfully!");

                } else if (choice == 2) {
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    System.out.print("Enter Floor Level (number): ");
                    int floor = sc.nextInt();
                    sc.nextLine(); // Clear the scanner
                    records.add(new Nurse(name, id, salary, floor));
                    System.out.println("Nurse registered successfully!");

                } else if (choice == 3) {
                    sc.nextLine(); // Clear the scanner
                    System.out.print("Enter Ailment/Reason for Visit: ");
                    String ailment = sc.nextLine();
                    records.add(new Patient(name, id, ailment));
                    System.out.println("Patient registered successfully!");
                }

            } catch (InputMismatchException e) {
                System.err.println("Input Error: Please use numbers for Choice, ID, Salary, and Floor.");
                sc.nextLine(); // Clear the bad input so it doesn't loop forever
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        //Final output
        System.out.println("\n--- Final Hospital Directory ---");
        for (Person p : records) {
            p.displayInfo();

            // Checking interfaces using instanceof
            if (p instanceof MedicalAction) {
                ((MedicalAction) p).performDuty();
            }
            if (p instanceof Billable) {
                ((Billable) p).generateInvoice();
            }
            System.out.println("--------------------------------");
        }

        sc.close();
        System.out.println("Thank you for visiting us");
    }
}
