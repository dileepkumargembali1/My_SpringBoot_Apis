package mypackage;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

class Test {
    public static void main(String[] args) {
        Employee e = new Employee(101, "John");
        e.display();
        // ❌ You cannot change id or name now.
    }
}

public class Practise1 {
   
}
