package myfirstproject;
import java.util.*;

/**
 * 
 */
public class Jcore1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello john");
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("ENter the name of the employee:");
		System.out.print("Enter age: ");
//		int age = sc.nextInt(); 
		
//		if (age>18) {
//			System.out.println("He is elgible for applying for job");
//			
//		}
//		else{
//			System.out.println("he was not eligible for the context");
//		}
//     
		
//		Even or odd program
		System.out.print("Enter the number you want to check:");
		
		int num=sc.nextInt();
		
		if(num<0) {
		   System.out.println("number was less than zero");
		}
		else {
		if(num%2==0) {
			
			System.out.println("Enter number was ever");
			
		}
		else {
			System.out.println("number was odd" );
		}
	}

	}


} 
