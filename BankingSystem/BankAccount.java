
 package COLLECTIONS;
import java.util.Objects;
 
public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private double balance;
 
	public BankAccount(int accountNumber, String accountHolderName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
 
	public int getAccountNumber() {
		return accountNumber;
	}
 
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
 
	public String getAccountHolderName() {
		return accountHolderName;
	}
 
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
 
	public double getBalance() {
		return balance;
	}
 
	public void setBalance(double balance) {
		this.balance = balance;
	}
 
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
 
	public boolean withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, accountNumber, balance);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountHolderName, other.accountHolderName) && accountNumber == other.accountNumber
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance);
	}
 
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + "]";
	}
 
}