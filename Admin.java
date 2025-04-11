import java.util.Map;

/**
 * Admin - Represents a bank administrator with special privileges
 * Extends the User class and adds administrative functionality
 */
public class Admin extends User {
    
    public Admin(String userId, String pin) {
        super(userId, pin);
    }
    
    public void viewAllAccounts(Map<String, User> users) {
        System.out.println("\n========================================");
        System.out.println("             ALL ACCOUNTS              ");
        System.out.println("========================================");
        System.out.printf("%-10s %-15s\n", "User ID", "Balance");
        System.out.println("----------------------------------------");
        
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (entry.getValue() instanceof Customer) {
                Customer customer = (Customer) entry.getValue();
                System.out.printf("%-10s $%-14.2f\n", 
                    customer.getUserId(), 
                    customer.checkBalance());
            }
        }
        System.out.println("========================================");
    }
    
    public Customer createCustomer(String userId, String pin, double initialDeposit) {
        Customer newCustomer = new Customer(userId, pin);
        Account newAccount = new Account("A" + userId.substring(1), initialDeposit);
        newCustomer.setAccount(newAccount);
        return newCustomer;
    }
}