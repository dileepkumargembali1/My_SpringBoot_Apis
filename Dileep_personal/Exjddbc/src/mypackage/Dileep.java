package mypackage;

import java.util.ArrayList;
import java.util.Scanner;


class Icecream{
	public int id;
	public String name;
	private String flavour;
	
	Scanner sc=new Scanner(System.in);

 
   Icecream(int id,String name){
	   
	   this.id=id;
	   this.name=name;
	   
   }

public String getFlavour() {
	return flavour;
}

public void setFlavour(String flavour) {
	this.flavour = flavour;
}

void display() {
	
	System.out.println("ID is"+ id);
	System.out.println("name is "+name);
	System.out.println("Flavour is"+ flavour);
}
   
}

public class Dileep {
	
	public static void main(String[] args) {
		
		ArrayList<Icecream> al=new ArrayList<>();
		
		int ch1=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1)create");
			System.out.println("2)display");
			System.out.println("3)exit");
			System.out.println("Please enter the value");
			ch1=sc.nextInt();
			if(ch1==1) {
				
				System.out.println("Enter ID");int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name:");String name=sc.nextLine();
				System.out.println("Ente flavour");String flavour=sc.nextLine();
				Icecream a=new Icecream(id,name);
				a.setFlavour(flavour);
				al.add(a);
				System.out.println("object address:"+ a);
				
				
			}
			
			if(ch1==2) {
				
				for(Icecream i : al) {
					i.display();
				}
			}
			
			if(ch1==3) {
				System.out.println("Thank you");
			}
		}while(ch1!=3);
		
		
	}

}
