package ComA;

import java.util.Scanner;


public class Finally_ex {
	
	
	
	
	void display() {
		
			}
		

	public static void main(String[] args) {
		
		int name;
		
		Scanner sc =new Scanner(System.in);
		
		Finally_ex obj=new Finally_ex();
try {
			

			System.out.println("Enter name:"); name=sc.nextInt();
			
			
			sc.nextLine();
			System.out.println("my name is "+ name);
			
		}
		catch(Exception e) {
			
			System.out.println("Hello boss give right input");
			
		}
		finally {
			System.out.println("Thnaks for coding");
		}

		
		
		
		
	}
	
	
	
    

}
