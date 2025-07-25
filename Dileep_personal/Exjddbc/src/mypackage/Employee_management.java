package mypackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Emp {
    Scanner sc = new Scanner(System.in);
    int id, age, salary;
    String name, designation;

    Emp() {
        System.out.println("Enter Employee ID:");
        id = sc.nextInt();
        System.out.println("Enter Employee Name:");
        name = sc.next();
        System.out.println("Enter Employee Age:");
        age = sc.nextInt();
    }

    void display() {
        System.out.println("=====================");
        System.out.println("Employee id : " + id);
        System.out.println("Employee name : " + name);
        System.out.println("Employee age : " + age);
        System.out.println("Employee salary : " + salary);
        System.out.println("Employe designation: " + designation);
    }

    void raiseSalary(int amount) {
        salary += amount;
        System.out.println("Salary raised. New salary: " + salary);
    }

    public int getId() {
        return id;
    }
}

class Clerk extends Emp {
    Clerk() {
        salary = 25000;
        designation = "Clerk";
    }
}

class Dev extends Emp {
    Dev() {
        salary = 50000;
        designation = "Developer";
    }
}

class Tester extends Emp {
    Tester() {
        salary = 40000;
        designation = "Tester";
       }   
}

class Manager extends Emp {
    Manager() {
        salary = 80000;
        designation = "Manager";
       }
}


public class Employee_management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Emp> employeeList = new ArrayList<>();
        int choice1, subChoice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Create Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Raise Salary by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice1 = sc.nextInt();

            switch (choice1) {
              case 1:
                      do {
                           System.out.println("\n--- Choose Employee Role ---");
                          System.out.println("1. Clerk");
                          System.out.println("2. Developer");
                            System.out.println("3. Tester");
                        System.out.println("4. Manager");
                          System.out.println("5. Exit");
                          System.out.print("Enter your choice: ");
                        subChoice = sc.nextInt();

                        switch (subChoice) {
                            case 1:
                                employeeList.add(new Clerk());
                                break;
                            case 2:
                                employeeList.add(new Dev());
                                break;
                            case 3:
                                employeeList.add(new Tester());
                                break;
                            case 4:
                                employeeList.add(new Manager());
                                break;
                            case 5:
                                System.out.println("Exit from the choice");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (subChoice != 5);
                    break;

                case 2:
                    System.out.println("\n=== Employee List ===");
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees to display.");
                    } 
                    else {
                        for (Emp e : employeeList) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;
                    Iterator<Emp> i = employeeList.iterator();
                    while (i.hasNext()) {
                        Emp e = i.next();
                        if (e.getId() == deleteId) {
                            i.remove();
                            foundDelete = true;
                            System.out.println("Employee with ID " + deleteId + " deleted.");
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Employee with ID " + deleteId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to raise salary: ");
                    int raiseId = sc.nextInt();
                    boolean foundRaise = false;
                    for (Emp e : employeeList) {
                        if (e.getId() == raiseId) {
                            System.out.print("Enter amount to raise: ");
                            int amount = sc.nextInt();
                            e.raiseSalary(amount);
                            foundRaise = true;
                            break;
                        }
                    }
                    if (!foundRaise) {
                        System.out.println("Employee with ID " + raiseId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice1 != 5);
        sc.close();
    }
}

