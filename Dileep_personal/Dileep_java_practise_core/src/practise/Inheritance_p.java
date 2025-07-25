package practise;

class Father {

	String home = "Guptha_villa";
	long bankbalance = 1000000;
	String name;

	/*
	 * Father(String name){ this.name=name; }
	 */

	void display() {
		System.out.println("This is super class");
	}
}

class Son extends Father {

	/*
	 * Son(String jshaj) { super(jshaj); // TODO Auto-generated constructor stub }
	 */
	String name = "dileep";

	void display(String name) {

		System.out.println("dad property:" + home);
		System.out.println("name: " + this.name);
		System.out.println("name: " + super.name);
		System.out.println("name: " + name);
	}

}

public class Inheritance_p {

	public static void main(String[] args) {
		Son obj = new Son();
		obj.display("ram");
		Father obj1 = new Father();
		obj1.display();

	}

}
