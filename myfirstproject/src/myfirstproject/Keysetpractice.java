package myfirstproject;
import java.util.*;

public class Keysetpractice { 

	public static void main(String[] args) {
		
		HashMap<Integer,String> employee = new HashMap<Integer,String>();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter how many employees you need to insert:");
		int num=sc.nextInt();
		
		for(int i=0;i<num;i++) {
		  int n=sc.nextInt();
		  sc.nextLine();
		  String[] arr=new String[num];
		  String details=sc.nextLine();
		  int salary=sc.nextInt();
		  String value=n+";"+details+";"+salary;
		  arr[i]=value;
		  employee.put(n,arr[i]);
		}
		for(int i: employee.keySet()) {
			System.out.println(i+" : "+employee.get(i));
		}
	
		
		
		

	}

}
