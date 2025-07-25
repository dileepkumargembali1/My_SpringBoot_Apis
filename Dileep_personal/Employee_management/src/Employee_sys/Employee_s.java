package Employee_sys;

import java.util.*;

class Emp{
	public int id;
	public String name;
	public int age;
	public int salary;
	public String designation;
	Scanner sc=new Scanner(System.in);
	Emp(){
		
		System.out.println("Enter id:");id=sc.nextInt();
		sc.nextLine();
		System.out.println("Employee name:");name=sc.nextLine();
		System.out.println("age");age=sc.nextInt();
		sc.nextLine();
		
	}
	
	void display() {
		
		System.out.println("Employee id :"+id);
		System.out.println("name :"+name);
		System.out.println("age :"+age);
		System.out.println("salary :"+salary);
		System.out.println("Edesignation :"+designation);
	}
	
}
class Clerk extends Emp{
	
	Clerk(){
		
		salary=20000;
		designation="clerk";
		
		
	}
}

class Dev extends Emp{
	
	Dev(){
		salary=30000;
		designation="Dev";
		
	}
}

class Tester extends Emp{
	
	Tester(){
		
		salary=40000;
		designation="Tester";
		
		
	}
}

class Manager extends Emp{
	
	Manager(){
		salary=50000;
		designation="Manager";
		
	}
}
public class Employee_s {
	
	public static void main(String[] args) {
	ArrayList<Emp> al= new ArrayList<>();
	Scanner sc =new Scanner(System.in);
	int ch1,ch2=0;
	
	do {
		
		System.out.println("======Employee management system=========");
		System.out.println("1)create");
		System.out.println("display all");
		System.out.println("3)delete by id");
		System.out.println("4)raise salary");
		System.out.println("5)exit");
		System.out.println("Choose option ");
		ch1=sc.nextInt();
		switch(ch1) {
		
		case 1:
			do {
				
				System.out.println("1)clerk");
				System.out.println("2)Dev");
				System.out.println("3)Tester");
				System.out.println("4)manager");
				System.out.println("5)Back to main ment");
				System.out.println("CHoose option");
				ch2=sc.nextInt();
				switch(ch2) {
					case 1:
						al.add(new Clerk());
						break;
					case 2:
						al.add(new Dev());
						break;
					case 3:
						al.add(new Tester());
						break;
					case 4:
						al.add(new Manager());
						break;
					case 5:
						System.out.println("back to main menu");
						break;
					default:
						System.out.println("Invali option select right one ");
						
				}
				
			}while(ch2!=5);
			break;
		case 2:
			
			Iterator<Emp> i=al.iterator();
			while(i.hasNext()) {
				Emp e =i.next();
			     e.display();
			     
			}
		  break;
		case 3:
			System.out.println("Delete by id ");
		case 4:
			System.out.println("Exit");
			    break;
			   
		default:
			System.out.println("Invali option");
			
		}
		
	}while(ch1!=3);
	
	
	}
	
	
	
	

}
