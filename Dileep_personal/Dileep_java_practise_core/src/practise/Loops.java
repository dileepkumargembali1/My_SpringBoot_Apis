package practise;
import java.util.*;
public class Loops {
//Loops and brak and continue
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int rang=sc.nextInt();
		for(int i=1;i<=rang;i++) {
			if(i==3) {
				
				break;
			}
			System.out.println("print"+i);
		}
		for(int i=1;i<rang;i++) {
			if(i==3) {
				
				continue;
			}
			System.out.println("print"+i);
		}
		int n=1;
		for(int i=10;i>n;i--) {
			System.out.println("Print:"+i);
		}
		System.out.println("Loop got out");
	}

}
