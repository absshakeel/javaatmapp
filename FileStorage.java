import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FileStorage - Handles file operations for the ATM system
 * This class manages reading and writing data to text files
 */
public class FileStorage {
    private static final String USERS_FILE = "users.txt";
    private static final String ACCOUNTS_FILE = "accounts.txt";
    private static final String TRANSACTIONS_FILE = "transactions.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Saves all users to the users.txt file
     * @param users Map of all users in the system
     */
    public static void saveUsers(Map<String, User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (User user : users.values()) {
                if (user instanceof Customer) {
                    writer.println("CUSTOMER," + user.getUserId() + "," + user.getPin());
                } else if (user instanceof Admin) {
                    writer.println("ADMIN," + user.getUserId() + "," + user.getPin());
                }
            }
            System.out.println("Users saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
    
    /**
     * Saves all accounts to the accounts.txt file
     * @param users Map of all users in the system
     */
    public static void saveAccounts(Map<String, User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ACCOUNTS_FILE))) {
            for (User user : users.values()) {
                if (user instanceof Customer) {
                    Customer customer = (Customer) user;
                    Account account = customer.getAccount();
                    writer.println(customer.getUserId() + "," + 
                                  account.getAccountNumber() + "," + 
                                  account.getBalance());
                }
            }
            System.out.println("Accounts saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
    
    /**
     * Saves all transactions to the transactions.txt file
     * @param users Map of all users in the system
     */
    public static void saveTransactions(Map<String, User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TRANSACTIONS_FILE))) {
            for (User user : users.values()) {
                if (user instanceof Customer) {
                    Customer customer = (Customer) user;
                    List<Transaction> transactions = customer.getTransactionHistory();
                    for (Transaction transaction : transactions) {
                        writer.println(customer.getUserId() + "," + 
                                      transaction.getType() + "," + 
                                      transaction.getAmount() + "," + 
                                      transaction.getBalanceAfter() + "," + 
                                      transaction.getTimestamp());
                    }
                }
            }
            System.out.println("Transactions saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }
    
    /**
     * Loads all users from the users.txt file
     * @return Map of users loaded from file
     */
    public static Map<String, User> loadUsers() {
        Map<String, User> users = new HashMap<>();
        File file = new File(USERS_FILE);
        
        if (!file.exists()) {
            System.out.println("Users file not found. Starting with empty users list.");
            return users;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String type = parts[0];
                    String userId = parts[1];
                    String pin = parts[2];
                    
                    if (type.equals("CUSTOMER")) {
                        users.put(userId, new Customer(userId, pin));
                    } else if (type.equals("ADMIN")) {
                        users.put(userId, new Admin(userId, pin));
                    }
                }
            }
            System.out.println("Users loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        
        return users;
    }
    
    /**
     * Loads all accounts from the accounts.txt file
     * @param users Map of users to associate accounts with
     */
    public static void loadAccounts(Map<String, User> users) {
        File file = new File(ACCOUNTS_FILE);
        
        if (!file.exists()) {
            System.out.println("Accounts file not found. Starting with empty accounts.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String userId = parts[0];
                    String accountNumber = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    
                    User user = users.get(userId);
                    if (user instanceof Customer) {
                        Account account = new Account(accountNumber, balance);
                        ((Customer) user).setAccount(account);
                    }
                }
            }
            System.out.println("Accounts loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
    
    /**
     * Loads all transactions from the transactions.txt file
     * @param users Map of users to associate transactions with
     */
    public static void loadTransactions(Map<String, User> users) {
        File file = new File(TRANSACTIONS_FILE);
        
        if (!file.exists()) {
            System.out.println("Transactions file not found. Starting with empty transaction history.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String userId = parts[0];
                    String type = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    double balanceAfter = Double.parseDouble(parts[3]);
                    String timestamp = parts[4];
                    
                    User user = users.get(userId);
                    if (user instanceof Customer) {
                        Transaction transaction = new Transaction(type, amount, balanceAfter, timestamp);
                        ((Customer) user).addTransaction(transaction);
                    }
                }
            }
            System.out.println("Transactions loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }
    
    /**
     * Saves all data to files
     * @param users Map of all users in the system
     */
    public static void saveAllData(Map<String, User> users) {
        saveUsers(users);
        saveAccounts(users);
        saveTransactions(users);
    }
    
    /**
     * Loads all data from files
     * @return Map of users with their accounts and transactions
     */
    public static Map<String, User> loadAllData() {
        Map<String, User> users = loadUsers();
        loadAccounts(users);
        loadTransactions(users);
        return users;
    }
}