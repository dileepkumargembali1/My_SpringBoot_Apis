package practise;


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
    
    public void setId(int id) {
    	this.id=id;
    }
}


public class Biscuit1 {
	
	public static void main(String[] args) {
        Employee e = new Employee(101, "John");
        e.display();
        e.setId(21);
        e.display();
        // ❌ You cannot change id or name now.
    }

}
