import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * ATM - Core class that handles ATM operations
 * This class manages user authentication and transaction processing
 */
public class ATM {
    private Map<String, User> users;
    private User currentUser;
    private Scanner scanner;
    private boolean running;
    
    public ATM() {
        scanner = new Scanner(System.in);
        running = false;
        
        // Load users from files or initialize with sample users if files don't exist
        users = FileStorage.loadAllData();
        
        // If no users were loaded, initialize with sample users
        if (users.isEmpty()) {
            initializeUsers();
            // Save the initial users to files
            FileStorage.saveAllData(users);
        }
    }
    
    private void initializeUsers() {
        // Create a customer user
        User customer = new Customer("C001", "1234");
        Account customerAccount = new Account("A001", 1000.0);
        ((Customer) customer).setAccount(customerAccount);
        users.put(customer.getUserId(), customer);
        
        // Create another customer user
        User customer2 = new Customer("C002", "5678");
        Account customer2Account = new Account("A002", 2500.0);
        ((Customer) customer2).setAccount(customer2Account);
        users.put(customer2.getUserId(), customer2);
        
        // Create an admin user
        User admin = new Admin("A001", "9999");
        users.put(admin.getUserId(), admin);
    }
    
    public void start() {
        running = true;
        displayWelcomeScreen();
        
        while (running) {
            if (currentUser == null) {
                authenticateUser();
            } else {
                processUserActions();
            }
        }
        
        // Save all data before exiting
        FileStorage.saveAllData(users);
        System.out.println("\nThank you for using our ATM. Goodbye!");
        scanner.close();
    }
    
    private void displayWelcomeScreen() {
        System.out.println("========================================");
        System.out.println("           WELCOME TO THE ATM          ");
        System.out.println("========================================");
    }
    
    private void authenticateUser() {
        System.out.println("\nPlease login to continue");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        User user = users.get(userId);
        
        if (user != null && user.validatePin(pin)) {
            currentUser = user;
            System.out.println("\nLogin successful! Welcome, " + userId);
        } else {
            System.out.println("\nInvalid User ID or PIN. Please try again.");
        }
    }
    
    private void processUserActions() {
        if (currentUser instanceof Customer) {
            processCustomerActions();
        } else if (currentUser instanceof Admin) {
            processAdminActions();
        }
    }
    
    private void processCustomerActions() {
        Customer customer = (Customer) currentUser;
        
        System.out.println("\n========================================");
        System.out.println("              CUSTOMER MENU            ");
        System.out.println("========================================");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Transaction History");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine();
        
        try {
            switch (choice) {
                case "1":
                    checkBalance(customer);
                    break;
                case "2":
                    deposit(customer);
                    break;
                case "3":
                    withdraw(customer);
                    break;
                case "4":
                    viewTransactionHistory(customer);
                    break;
                case "5":
                    logout();
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    
    private void processAdminActions() {
        Admin admin = (Admin) currentUser;
        
        System.out.println("\n========================================");
        System.out.println("               ADMIN MENU              ");
        System.out.println("========================================");
        System.out.println("1. View All Accounts");
        System.out.println("2. Add New Customer");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine();
        
        try {
            switch (choice) {
                case "1":
                    admin.viewAllAccounts(users);
                    break;
                case "2":
                    addNewCustomer(admin);
                    break;
                case "3":
                    logout();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    
    private void checkBalance(Customer customer) {
        double balance = customer.checkBalance();
        System.out.println("\nYour current balance: $" + String.format("%.2f", balance));
    }
    
    private void deposit(Customer customer) {
        System.out.print("\nEnter amount to deposit: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }
            
            boolean success = customer.deposit(amount);
            if (success) {
                System.out.println("Deposit successful. New balance: $" + 
                                  String.format("%.2f", customer.checkBalance()));
                // Save the updated data to files
                FileStorage.saveAllData(users);
            } else {
                System.out.println("Deposit failed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }
    
    private void withdraw(Customer customer) {
        System.out.print("\nEnter amount to withdraw: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }
            
            boolean success = customer.withdraw(amount);
            if (success) {
                System.out.println("Withdrawal successful. New balance: $" + 
                                  String.format("%.2f", customer.checkBalance()));
                // Save the updated data to files
                FileStorage.saveAllData(users);
            } else {
                System.out.println("Withdrawal failed. Insufficient funds.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }
    
    private void viewTransactionHistory(Customer customer) {
        customer.viewTransactionHistory();
    }
    
    private void addNewCustomer(Admin admin) {
        System.out.print("\nEnter new Customer ID: ");
        String customerId = scanner.nextLine();
        
        if (users.containsKey(customerId)) {
            System.out.println("User ID already exists.");
            return;
        }
        
        System.out.print("Enter PIN for new customer: ");
        String pin = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: $");
        try {
            double initialDeposit = Double.parseDouble(scanner.nextLine());
            if (initialDeposit < 0) {
                System.out.println("Initial deposit cannot be negative.");
                return;
            }
            
            User newCustomer = admin.createCustomer(customerId, pin, initialDeposit);
            users.put(customerId, newCustomer);
            System.out.println("New customer created successfully.");
            
            // Save the updated data to files
            FileStorage.saveAllData(users);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }
    
    private void logout() {
        currentUser = null;
        System.out.println("\nYou have been logged out.");
    }
}