package practise;

public class Demo1 {

	public int a=10;
	protected String name ="dileep";
	private int age=22;
	    String city="rjy";
	 void display() {
		 System.out.println(a);
		 System.out.println(name);
		 System.out.println(age);
		 System.out.println(city);
		 System.out.println("This is ending of the parent class");
	 }
	
	 public static void main(String[] args) {
		 
		 sub obj1=new sub();
		 obj1.display(33);
		 
	 }
}
class sub extends Demo1{
	
	void display(int a) {
		super.display();
		 System.out.println(a);
		 System.out.println(name);
//		 System.out.println(re.age);
		 System.out.println(city);
		 System.out.println("this is under sum");
	 }
	
	
}



