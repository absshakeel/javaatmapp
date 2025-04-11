# ATM Interface System

A Java console-based ATM interface project with multiple actors (Customer and Admin) that includes login functionality, transaction operations, and proper error handling. The system uses text files as a simple database to store user information, account details, and transaction history.

## Features

### Customer Features
- Login with User ID and PIN
- Check account balance
- Deposit money
- Withdraw money
- View transaction history
- Logout

### Admin Features
- Login with Admin credentials
- View all customer accounts
- Create new customer accounts
- Logout

## Project Structure

### Core Classes
- `ATMApp.java` - Main entry point for the application
- `ATM.java` - Core class that handles ATM operations, user authentication, and menu interfaces
- `User.java` - Abstract base class for all users with common attributes and methods
- `Customer.java` - Represents a bank customer with account management capabilities
- `Admin.java` - Represents a bank administrator with system management capabilities
- `Account.java` - Represents a bank account with balance and transaction methods
- `Transaction.java` - Represents a financial transaction with type, amount, and timestamp
- `FileStorage.java` - Handles all file operations for persistent data storage

### Data Storage

The application uses text files to store data persistently:

- `users.txt` - Stores user information (type, ID, PIN)
  ```
  CUSTOMER,C001,1234
  ADMIN,A001,9999
  ```

- `accounts.txt` - Stores account information (user ID, account number, balance)
  ```
  C001,A001,1000.0
  C002,A002,2500.0
  ```

- `transactions.txt` - Stores transaction history (user ID, type, amount, balance after, timestamp)
  ```
  C001,DEPOSIT,100.0,1100.0,2023-04-11 10:30:45
  ```

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command-line terminal

### Setup
1. Clone or download this repository to your local machine
2. Navigate to the project directory

## How to Run

1. Compile all Java files:
   ```
   javac *.java
   ```

2. Run the application:
   ```
   java ATMApp
   ```

## Usage Examples

### Customer Login
1. Enter User ID (e.g., C001)
2. Enter PIN (e.g., 1234)
3. Select from available options:
   - Check Balance
   - Deposit
   - Withdraw
   - View Transaction History
   - Logout

### Admin Login
1. Enter User ID (e.g., A001)
2. Enter PIN (e.g., 9999)
3. Select from available options:
   - View All Accounts
   - Create New Account
   - Logout

## Default Users

### Customer Accounts
- User ID: C001, PIN: 1234, Initial Balance: $1000
- User ID: C002, PIN: 5678, Initial Balance: $2500

### Admin Account
- User ID: A001, PIN: 9999

## Error Handling

The application handles various error scenarios gracefully:
- Invalid login credentials
- Insufficient funds for withdrawals
- Invalid input formats (non-numeric values for amounts)
- Negative or zero amounts for transactions
- File I/O errors during data storage operations

## System Design

### Class Hierarchy
- `User` (Abstract)
  - `Customer`
  - `Admin`

### Data Persistence
The system automatically saves all changes to the text files when the application exits, ensuring data persistence between sessions. If the data files don't exist when the application starts, it initializes with default sample users and accounts.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.