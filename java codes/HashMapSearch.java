package COLLECTIONS;


import java.util.HashMap;
 
public class HashMapSearch {
	public static void main(String[] args) {
		HashMap<Character, String> hmap = new HashMap<>();
		hmap.put('v', "violet");
		hmap.put('I', "Indigo");
		hmap.put('B', "Blue");
		hmap.put('G', "Green");
		hmap.put('R', "Red");
		
		//search
		char searchKey = 'G';
		if (hmap.containsKey(searchKey)) {
			System.out.println("Found: " + hmap.get(searchKey));
		} else {
			System.out.println("Product not found for key: " + searchKey);
		}
 
		// Insert
		char newKey = 'Y';
		String newValue = "Yellow";
		if (!hmap.containsKey(newKey)) {
			hmap.put(newKey, newValue);
			System.out.println("Inserted new product: " + newKey + " -> " + newValue);
		} else {
			System.out.println("Key " + newKey + " already exists with value: " + hmap.get(newKey));
		}
 
		
		System.out.println("Updated HashMap: " + hmap);
	}
}
 
 