package COLLECTIONS;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Arraydemo {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
 
        
        ArrayList<String> empNames = new ArrayList<>();
        ArrayList<String> empAddresses = new ArrayList<>();
 
       
        System.out.print("Enter the number of employees: ");
        int num = scanner.nextInt();
        scanner.nextLine();
 
        System.out.println("Enter employee names:");
        for (int i = 0; i < num; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            empNames.add(scanner.nextLine());
        }
 
      
        System.out.println("Enter employee addresses:");
        for (int i = 0; i < num; i++) {
            System.out.print("Address for " + empNames.get(i) + ": ");
            empAddresses.add(scanner.nextLine());
        }
 
       
        System.out.println("Employee Names: " + empNames);
        System.out.println("Employee Addresses: " + empAddresses);
 
       
        ArrayList<String> combinedList = new ArrayList<>(empNames);
        combinedList.addAll(empAddresses);
 
       
        System.out.println("Combined List (Names + Addresses): " + combinedList);
 
        
        System.out.print("Enter a name or address to remove: ");
        String toRemove = scanner.nextLine();
        combinedList.remove(toRemove);
        System.out.println("Updated Combined List: " + combinedList);
 
        System.out.println("size of te arraylist : "+combinedList.size());
        System.out.println("Get new element which is at index 1 : "+combinedList.get(1));
        scanner.close();
    }
}
 