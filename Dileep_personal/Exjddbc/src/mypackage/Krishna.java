package mypackage;

import java.util.*;

;

class Book{
	public int id;
	public String name;
	public String author;
	public String catogery;
	Book(int id,String name,String author, String catogery){
		this.id=id;
		this.name=name;
		this.author=author;
		this.catogery=catogery;	
	}
	void display() {
		System.out.println("==========================");
		System.out.println("Book id was :"+ id);
		System.out.println("Book name was:"+name);
		System.out.println("Book author was"+ author);
		System.out.println("Book catogary was"+catogery);
	}
}
public class Krishna {

	public static void main(String[] args) {
		ArrayList<Book> al=new ArrayList<>();
		Scanner sc =new Scanner(System.in);
		int ch1=0;
	
		do {
			System.out.println("Hello welcomm");
			System.out.println("1)create");
			System.out.println("2)display");
			System.out.println("3)exit");
			System.out.println("Slect the valuse");
			ch1=sc.nextInt();
			if(ch1==1) {
		     
		    	 System.out.println("please create the values if you want");
		    	 System.out.println("Enter id:");int id=sc.nextInt();
		    	 sc.nextLine();
		    	 System.out.println("Enter name:");String s=sc.nextLine();
		    	 System.out.println("Enter author:");String a=sc.nextLine();
		    	 System.out.println("Enter catogery");
		    	 
		    	 String c=sc.nextLine();
		    	 al.add(new Book(id,s,a,c) );
		     }
		    if(ch1==2) {
		    	
		    	Iterator<Book> i=al.iterator();
		    	while(i.hasNext()) {
		    		Book b=i.next();
		    		b.display();
		    	}
		    
			}
		    if(ch1==3) {
		    	System.out.println("Thank you ");
		    }
		}while(ch1!=3);
		
	 sc.close();
	}
}
