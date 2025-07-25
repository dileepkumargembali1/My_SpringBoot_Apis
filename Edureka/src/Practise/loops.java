package Practise;
import java.util.*;
public class loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		lets learn about different loops in java
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number...");
		int x = sc.nextInt();
		
		int rem, sum=0;
		
		for (;x > 0; x = x / 10)
		{
			rem = x % 10;
			sum = sum + rem;
		}
		System.out.println("Added digits of a number is "+sum);
	}

}
