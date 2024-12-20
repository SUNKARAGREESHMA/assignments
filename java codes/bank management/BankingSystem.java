package COLLECTIONS;
 
import java.util.*;
 
 
public class BankingSystem {
    HashSet<BankAccount> accounts = new HashSet<>();
 
    // Add a new account
    public boolean addAccount(BankAccount account) {
        return accounts.add(account);
    }
 
    // Deposit money
    public boolean deposit(int accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                return true;
            }
        }
        return false;
    }
 
    // Withdraw money
    public boolean withdraw(int accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account.withdraw(amount);
            }
        }
        return false;
    }
 
    // Check account balance
    public BankAccount getAccountByNumber(int accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber() == accountNumber).findFirst().orElse(null);
    }
 
    // Remove inactive accounts (accounts with zero balance)
    public void removeInactiveAccounts() {
        accounts.removeIf(account -> account.getBalance() == 0);
    }
 
    // Display account with the highest balance
    public Optional<BankAccount> getAccountWithHighestBalance() {
        return accounts.stream().max((a, b) -> Double.compare(a.getBalance(), b.getBalance()));
    }
 
    // Display account with the lowest balance
    public Optional<BankAccount> getAccountWithLowestBalance() {
        return accounts.stream().min((a, b) -> Double.compare(a.getBalance(), b.getBalance()));
    }
 
    // Display all accounts
    public void displayAccounts() {
        accounts.forEach(System.out::println);
    }
}