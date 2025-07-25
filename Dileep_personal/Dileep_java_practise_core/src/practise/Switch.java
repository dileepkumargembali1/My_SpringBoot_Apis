package practise;

import java.util.*;

public class Switch{
	
	public static void main(String[] args) {
		System.out.println("THis is my first program");
		Scanner sc=new Scanner(System.in);
		Random re=new Random();
		System.out.println("Enter your choice");
		int sel=re.nextInt(3)+1;
		
		
		switch(sel) {
		case 1:
			printHello();
		  break;
		case 2:
			printDileep();
			break;
		default:
			System.out.println("selction was not correct");			
		}
		
		
	}
	public static void printHello() {
		System.out.println("printHell0");
	}
	public static void printDileep() {
		System.out.println("Printdileep");
	}
}