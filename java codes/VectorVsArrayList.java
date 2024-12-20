package COLLECTIONS;


import java.util.ArrayList;
import java.util.Vector;
 
public class VectorVsArrayList {
 
	public static void main(String[] args) {
		

Vector<String> v = new Vector<String>();
ArrayList<String> al = new ArrayList<String>();

System.out.println(" Adding element to Vector and ArrayList");
v.add("Apple");
v.add("Banana");
v.add("cherry");
al.add("Apple");
al.add("Banana");
al.add("cherry");
System.out.println("Vector contents: " + v);
System.out.println("ArrayList contents: " + al);

System.out.println(" Remove banana from vector and arraylist");
v.remove("Banana");
al.remove("Banana");

System.out.println("Vector contents after removal: " + v);
System.out.println("ArrayList contents after removal: " + al);

// Add more elements to exceed the initial capacity of the Vector
v.add("Mango");
v.add("Pineapple");
v.add("Grapes");

// ArrayList will automatically expand as needed as well
al.add("Mango");
al.add("Pineapple");
al.add("Grapes");

// Display updated content of Vector and ArrayList
System.out.println("\nUpdated Vector contents: " + v);
System.out.println("Updated ArrayList contents: " + al);

// Show the size and capacity of Vector and ArrayList
System.out.println("\nVector size: " + v.size());
System.out.println("Vector capacity: " + v.capacity());

System.out.println("ArrayList size: " + al.size());
// ArrayList does not have a direct method to get capacity like Vector
System.out.println("ArrayList capacity is not directly accessible, but its size is: " + al.size());

// Perform random access (getting elements from random index)
System.out.println("\nRandom access in Vector: " + v.get(2));  
System.out.println("Random access in ArrayList: " + al.get(2));  

// Display updated collections after random access
System.out.println("\nUpdated Vector contents after random access: " + v);
System.out.println("Updated ArrayList contents after random access: " + al);

	
	}
 
}
















