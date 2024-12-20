package COLLECTIONS;

import java.util.*;

public class BankManagement {
   public static void main(String[] args) {
       BankingSystem bankingSystem = new BankingSystem();

       // Add accounts
       bankingSystem.addAccount(new BankAccount(101, "Alice", 5000));
       bankingSystem.addAccount(new BankAccount(102, "Bob", 3000));
       bankingSystem.addAccount(new BankAccount(103, "Charlie", 0));
       bankingSystem.addAccount(new BankAccount(104, "Diana", 12000));

       System.out.println("All Accounts:");
       bankingSystem.displayAccounts();

       // Deposit money
       bankingSystem.deposit(101, 2000);
       bankingSystem.deposit(103, 1000);

       System.out.println("\nAfter Deposits:");
       bankingSystem.displayAccounts();

       // Withdraw money
       bankingSystem.withdraw(102, 500);

       System.out.println("\nAfter Withdrawal:");
       bankingSystem.displayAccounts();

       // Remove inactive accounts
       bankingSystem.removeInactiveAccounts();

       System.out.println("\nAfter Removing Inactive Accounts:");
       bankingSystem.displayAccounts();

       // Display account with the highest balance
       Optional<BankAccount> highest = bankingSystem.getAccountWithHighestBalance();
       highest.ifPresent(account -> System.out.println("\nAccount with Highest Balance: " + account));

       // Display account with the lowest balance
       Optional<BankAccount> lowest = bankingSystem.getAccountWithLowestBalance();
       lowest.ifPresent(account -> System.out.println("\nAccount with Lowest Balance: " + account));
   }
}
