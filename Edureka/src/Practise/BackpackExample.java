package Practise;

import java.util.*;


public class BackpackExample {
	
	static ArrayList<String> name=new ArrayList<>();
	
  public static void main(String[] args) {
    ArrayList<String> backpack = new ArrayList<>();
    backpack.add("Shirt");
    backpack.add("Toothbrush");
    backpack.add("Book");

    System.out.println("Item at index 1: " + backpack.get(1));
  }
}
