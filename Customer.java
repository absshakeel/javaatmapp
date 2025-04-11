import java.util.ArrayList;
import java.util.List;

/**
 * Customer - Represents a bank customer who can perform transactions
 * Extends the User class and adds account-related functionality
 */
public class Customer extends User {
    private Account account;
    private List<Transaction> transactionHistory;
    
    public Customer(String userId, String pin) {
        super(userId, pin);
        this.transactionHistory = new ArrayList<>();
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public double checkBalance() {
        return account.getBalance();
    }
    
    public boolean deposit(double amount) {
        boolean success = account.deposit(amount);
        if (success) {
            Transaction transaction = new Transaction("DEPOSIT", amount, account.getBalance());
            transactionHistory.add(transaction);
        }
        return success;
    }
    
    public boolean withdraw(double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            Transaction transaction = new Transaction("WITHDRAW", amount, account.getBalance());
            transactionHistory.add(transaction);
        }
        return success;
    }
    
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    
    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
    
    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("\nNo transaction history available.");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("          TRANSACTION HISTORY          ");
        System.out.println("========================================");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "No.", "Type", "Amount", "Balance");
        System.out.println("----------------------------------------");
        
        int count = 1;
        for (Transaction transaction : transactionHistory) {
            System.out.printf("%-10d %-10s $%-9.2f $%-14.2f\n", 
                count++, 
                transaction.getType(), 
                transaction.getAmount(), 
                transaction.getBalanceAfter());
        }
        System.out.println("========================================");
    }
}