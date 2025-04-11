/**
 * Account - Represents a bank account with balance and operations
 */
public class Account {
    private String accountNumber;
    private double balance;
    
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        
        balance += amount;
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        
        balance -= amount;
        return true;
    }
}