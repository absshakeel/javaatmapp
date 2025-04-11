import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Transaction - Represents a financial transaction in the ATM system
 * Stores details like transaction type, amount, and resulting balance
 */
public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }
    
    public Transaction(String type, double amount, double balanceAfter, String timestampStr) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.parse(timestampStr, formatter);
    }
    
    public String getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getBalanceAfter() {
        return balanceAfter;
    }
    
    public String getTimestamp() {
        return timestamp.format(formatter);
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s: $%.2f, Balance: $%.2f", 
                           getTimestamp(), type, amount, balanceAfter);
    }
}