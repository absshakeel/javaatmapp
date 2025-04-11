# ATM Interface System - UML Diagrams

This document contains UML diagrams for the ATM Interface System, providing visual representations of the system's structure, behavior, and interactions.

## 1. Use Case Diagram

```
+---------------------------------------------------------------------+
|                        ATM Interface System                          |
+---------------------------------------------------------------------+
|                                                                     |
|  +-------------+                                +---------------+    |
|  |             |    +------------------+       |               |    |
|  |  Customer   |----| Login to System  |       |    Admin      |    |
|  |             |    +------------------+       |               |    |
|  +-------------+                               +---------------+    |
|        |                                              |             |
|        |                                              |             |
|        |                                              |             |
|        v                                              v             |
|  +-------------+    +------------------+    +------------------+    |
|  |             |    |                  |    |                  |    |
|  | Check       |    | Deposit Money    |    | View All        |    |
|  | Balance     |    |                  |    | Accounts        |    |
|  |             |    |                  |    |                  |    |
|  +-------------+    +------------------+    +------------------+    |
|        |                     |                       |              |
|        |                     |                       |              |
|        v                     v                       v              |
|  +-------------+    +------------------+    +------------------+    |
|  |             |    |                  |    |                  |    |
|  | Withdraw    |    | View Transaction|    | Create New      |    |
|  | Money       |    | History         |    | Account         |    |
|  |             |    |                  |    |                  |    |
|  +-------------+    +------------------+    +------------------+    |
|        |                     |                       |              |
|        |                     |                       |              |
|        v                     v                       v              |
|  +--------------------------------------------------+              |
|  |                      Logout                       |              |
|  +--------------------------------------------------+              |
|                                                                     |
+---------------------------------------------------------------------+
```

### Description:

The Use Case Diagram illustrates the interactions between the actors (Customer and Admin) and the system. It shows the various operations that each actor can perform:

**Customer Use Cases:**
- Login to System
- Check Balance
- Deposit Money
- Withdraw Money
- View Transaction History
- Logout

**Admin Use Cases:**
- Login to System
- View All Accounts
- Create New Account
- Logout

## 2. Activity Diagrams

### 2.1 Customer Login Activity Diagram

```
+---------------------------------------------------------------------+
|                                                                     |
|                              START                                  |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Display Welcome   |                          |
|                     |  Screen            |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Prompt for User   |                          |
|                     |  ID and PIN        |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Validate          |                          |
|                     |  Credentials      |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                      +------------------+                           |
|                      |   Valid?         |                           |
|                      +------------------+                           |
|                       /              \                             |
|                      /                \                            |
|                     v                  v                           |
|         +---------------+       +------------------+               |
|         | Display Error |       | Display Customer |               |
|         | Message       |       | Menu             |               |
|         +---------------+       +------------------+               |
|                 |                        |                         |
|                 v                        v                         |
|         +---------------+       +------------------+               |
|         | Return to     |       | Process Customer |               |
|         | Login Prompt  |       | Selection        |               |
|         +---------------+       +------------------+               |
|                                         |                         |
|                                         v                         |
|                                  +-------------+                  |
|                                  |    END     |                  |
|                                  +-------------+                  |
|                                                                     |
+---------------------------------------------------------------------+
```

### 2.2 Withdrawal Activity Diagram

```
+---------------------------------------------------------------------+
|                                                                     |
|                              START                                  |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Display Withdraw  |                          |
|                     |  Screen            |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Prompt for        |                          |
|                     |  Amount            |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                     +--------------------+                          |
|                     |  Validate Amount   |                          |
|                     +--------------------+                          |
|                                |                                    |
|                                v                                    |
|                      +------------------+                           |
|                      | Amount > 0?      |                           |
|                      +------------------+                           |
|                       /              \                             |
|                      /                \                            |
|                     v                  v                           |
|         +---------------+       +------------------+               |
|         | Display Error |       | Check Sufficient |               |
|         | Message       |       | Balance          |               |
|         +---------------+       +------------------+               |
|                 |                        |                         |
|                 v                        v                         |
|                 |               +------------------+               |
|                 |               | Sufficient?      |               |
|                 |               +------------------+               |
|                 |                /              \                 |
|                 |               /                \                |
|                 |              v                  v               |
|                 |    +---------------+    +------------------+    |
|                 |    | Display       |    | Update Account   |    |
|                 |    | Insufficient  |    | Balance          |    |
|                 |    | Funds Message |    |                  |    |
|                 |    +---------------+    +------------------+    |
|                 |            |                     |              |
|                 |            |                     v              |
|                 |            |             +------------------+    |
|                 |            |             | Record          |    |
|                 |            |             | Transaction     |    |
|                 |            |             +------------------+    |
|                 |            |                     |              |
|                 |            |                     v              |
|                 |            |             +------------------+    |
|                 |            |             | Display Success  |    |
|                 |            |             | Message          |    |
|                 |            |             +------------------+    |
|                 |            |                     |              |
|                 v            v                     v              |
|         +--------------------------------------------------+      |
|         |           Return to Customer Menu               |      |
|         +--------------------------------------------------+      |
|                                |                                  |
|                                v                                  |
|                           +----------+                            |
|                           |   END    |                            |
|                           +----------+                            |
|                                                                     |
+---------------------------------------------------------------------+
```

## 3. Class Diagram

```
+---------------------------------------------------------------------+
|                                                                     |
|  +-------------------+          +----------------------+            |
|  |      ATMApp       |          |         ATM         |            |
|  +-------------------+          +----------------------+            |
|  | - main(args)      |<>------->| - authenticateUser() |            |
|  +-------------------+          | - showMainMenu()     |            |
|                                 | - showCustomerMenu() |            |
|                                 | - showAdminMenu()    |            |
|                                 +----------------------+            |
|                                           ^                        |
|                                           |                        |
|                                           |                        |
|  +-------------------+          +----------------------+            |
|  |    FileStorage    |          |         User        |            |
|  +-------------------+          +----------------------+            |
|  | - loadUsers()     |<>------->| # userId: String    |            |
|  | - saveUsers()     |          | # pin: String       |            |
|  | - loadAccounts()  |          | # type: UserType    |            |
|  | - saveAccounts()  |          +----------------------+            |
|  | - loadTransactions()|         | + authenticate()     |            |
|  | - saveTransactions()|         | + getUserId()        |            |
|  +-------------------+          | + getType()          |            |
|                                 +----------------------+            |
|                                           ^                        |
|                                           |                        |
|                  +-------------------------+------------------------+
|                  |                                                 |
|                  |                                                 |
|  +-------------------+                          +-------------------+
|  |     Customer      |                          |      Admin        |
|  +-------------------+                          +-------------------+
|  | - accounts: List  |                          | + viewAllAccounts()|  
|  +-------------------+                          | + createAccount()  |  
|  | + checkBalance()  |                          +-------------------+  
|  | + deposit()       |                                               |
|  | + withdraw()      |<>---------+                                  |
|  | + viewHistory()   |           |                                  |
|  +-------------------+           |                                  |
|                                  |                                  |
|                                  |                                  |
|  +-------------------+           |           +-------------------+  |
|  |     Account       |<>---------+           |   Transaction     |  |
|  +-------------------+                       +-------------------+  |
|  | - accountNumber   |<>-------------------->| - type: TransType |  |
|  | - balance         |                       | - amount          |  |
|  | - userId          |                       | - timestamp       |  |
|  +-------------------+                       | - balanceAfter    |  |
|  | + getBalance()    |                       +-------------------+  |
|  | + deposit()       |                       | + getDetails()    |  |
|  | + withdraw()      |                       +-------------------+  |
|  | + getTransactions()|                                             |
|  +-------------------+                                             |
|                                                                     |
+---------------------------------------------------------------------+
```

### Description:

The Class Diagram illustrates the structure of the ATM Interface System, showing the relationships between the different classes:

1. **ATMApp**: The main entry point for the application.

2. **ATM**: Core class that handles ATM operations, user authentication, and menu interfaces.

3. **User**: Abstract base class for all users with common attributes and methods.
   - **Customer**: Extends User, represents a bank customer with account management capabilities.
   - **Admin**: Extends User, represents a bank administrator with system management capabilities.

4. **Account**: Represents a bank account with balance and transaction methods.

5. **Transaction**: Represents a financial transaction with type, amount, and timestamp.

6. **FileStorage**: Handles all file operations for persistent data storage.

The diagram shows the following relationships:
- Composition between ATMApp and ATM
- Association between ATM and User
- Inheritance from User to Customer and Admin
- Association between Customer and Account
- Association between Account and Transaction
- Association between FileStorage and all data-related classes

## 4. Sequence Diagram for Withdrawal Process

```
+------+      +------+      +--------+      +---------+      +-------------+
|      |      |      |      |        |      |         |      |             |
| User |      | ATM  |      |Customer|      | Account |      | Transaction |
|      |      |      |      |        |      |         |      |             |
+------+      +------+      +--------+      +---------+      +-------------+
   |              |             |               |                  |        
   | 1. Select    |             |               |                  |        
   | Withdraw     |             |               |                  |        
   |------------->|             |               |                  |        
   |              | 2. Request  |               |                  |        
   |              | Withdrawal  |               |                  |        
   |              |------------>|               |                  |        
   |              |             | 3. Enter      |                  |        
   |              |             | Amount        |                  |        
   |              |<------------|               |                  |        
   |              |             | 4. Check      |                  |        
   |              |             | Balance       |                  |        
   |              |             |-------------->|                  |        
   |              |             |               | 5. Return        |        
   |              |             |               | Balance          |        
   |              |             |<--------------|                  |        
   |              |             | 6. If         |                  |        
   |              |             | Sufficient    |                  |        
   |              |             | Withdraw      |                  |        
   |              |             |-------------->|                  |        
   |              |             |               | 7. Update        |        
   |              |             |               | Balance          |        
   |              |             |               |----------------->|        
   |              |             |               |                  | 8. Create
   |              |             |               |                  | Transaction
   |              |             |               |<-----------------|        
   |              |             |<--------------|                  |        
   |              |<------------|               |                  |        
   | 9. Display   |             |               |                  |        
   | Result       |             |               |                  |        
   |<-------------|             |               |                  |        
   |              |             |               |                  |        
```

### Description:

The Sequence Diagram illustrates the flow of the withdrawal process in the ATM Interface System:

1. User selects the Withdraw option from the ATM menu
2. ATM requests withdrawal operation from the Customer object
3. Customer enters the withdrawal amount
4. Customer checks the account balance
5. Account returns the current balance
6. If the balance is sufficient, Customer initiates the withdrawal
7. Account updates the balance
8. Transaction record is created
9. Result is displayed to the User

---

These UML diagrams provide a comprehensive visual representation of the ATM Interface System's structure, behavior, and interactions, complementing the textual description in the README.md file.