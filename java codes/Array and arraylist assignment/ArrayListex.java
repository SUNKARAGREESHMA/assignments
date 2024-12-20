package COLLECTIONS;
import java.util.ArrayList;
import java.util.Scanner;
 
public class ArrayListex{
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Employee Names
        ArrayList<String> empNames = new ArrayList<>();
        System.out.println("Enter employee names (press '0' to stop):");
        String name;
        while (!(name = scanner.nextLine()).equals("0")) {
            empNames.add(name);
        }
 
        System.out.println("Employee Names: " + empNames);
 
        System.out.println("Enter a name to add to Employee Names:");
        String newName = scanner.nextLine();
        empNames.add(newName);
        System.out.println("After adding new employee: " + empNames);
 
        System.out.println("Enter the index to update and the new name (e.g., '1 sam'): ");
        int indexToUpdate = scanner.nextInt();
        scanner.nextLine(); 
        String updatedName = scanner.nextLine();
        empNames.set(indexToUpdate, updatedName);
        System.out.println("After updating employee name: " + empNames);
 
        System.out.println("Enter the index to retrieve:");
        int indexToRetrieve = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Employee at index " + indexToRetrieve + ": " + empNames.get(indexToRetrieve));
 
        System.out.println("Enter the index to remove:");
        int indexToRemove = scanner.nextInt();
        scanner.nextLine(); 
        empNames.remove(indexToRemove);
        System.out.println("After removing employee: " + empNames);
 
        // Employee Addresses
        ArrayListex<String> empAddresses = new ArrayListex<>();
        System.out.println("Enter employee addresses (press '0' to stop):");
        String address;
        while (!(address = scanner.nextLine()).equals("0")) {
            empAddresses.add(address);
        }
 
        System.out.println("Employee Addresses: " + empAddresses);
 
        System.out.println("Enter an address to add:");
        String newAddress = scanner.nextLine();
        empAddresses.add(newAddress);
        System.out.println("After adding new address: " + empAddresses);
 
        System.out.println("Enter the index to update and the new address (e.g., '2 delhi'):");
        int addressUpdate = scanner.nextInt();
        scanner.nextLine(); 
        String updatedAddress = scanner.nextLine();
        empAddresses.set(addressUpdate, updatedAddress);
        System.out.println("After updating address: " + empAddresses);
 
        System.out.println("Enter the index to retrieve:");
        int addressRetrieve = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Address at index " + addressRetrieve + ": " + empAddresses.get(addressRetrieve));
 
        System.out.println("Enter the index to remove:");
        int addressIndexToRemove = scanner.nextInt();
        scanner.nextLine(); 
        empAddresses.remove(addressIndexToRemove);
        System.out.println("After removing address: " + empAddresses);
 
        // Combine 
        ArrayListex<String> combinedList = new ArrayListex<>();
        combinedList.addAll(empNames);
        combinedList.addAll(empAddresses);
 
        
        System.out.println("Combined Employee Names and Addresses: " + combinedList);
 
        scanner.close();
    }
}
 