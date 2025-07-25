package practise;

import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Customer(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }

    // Display method
    public void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Salary    : " + salary);
    }
}

public class CustomerManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = null;
        int choice;

        do {
            System.out.println("\n---- Customer Management System ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Customer Salary: ");
                    double salary = sc.nextDouble();
                    customer = new Customer(id, name, salary);
                    
                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    if (customer != null) {
                        customer.display();
                    } else {
                        System.out.println("No customer data found.");
                    }
                    break;

                case 3:
                    if (customer != null) {
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Salary: ");
                        double newSalary = sc.nextDouble();
                        customer.setName(newName);
                        customer.setSalary(newSalary);
                        System.out.println("Customer updated successfully!");
                    } else {
                        System.out.println("No customer to update.");
                    }
                    break;

                case 4:
                    if (customer != null) {
                        customer = null;
                        System.out.println("Customer deleted.");
                    } else {
                        System.out.println("No customer to delete.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
