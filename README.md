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


# ATM INTERFACE SYSTEM - PROJECT PROPOSAL

## 1. Project Overview

The ATM Interface System is proposed as a comprehensive Java-based application that simulates the functionality of an Automated Teller Machine (ATM). This console-based system will provide users with a realistic banking experience through multiple user roles, secure authentication mechanisms, and persistent data storage. The project aims to demonstrate fundamental programming concepts including object-oriented design, file handling, user authentication, and transaction processing.

## 2. Project Objectives

- Develop a fully functional ATM simulation system with role-based access control
- Implement secure user authentication using PIN-based verification
- Create a persistent data storage system using text files as a database
- Design an intuitive console-based user interface for banking operations
- Demonstrate object-oriented programming principles through proper class hierarchy
- Implement comprehensive error handling and input validation
- Provide transaction logging and history viewing capabilities

## 3. Project Scope

### In Scope

- Console-based user interface with clear menu navigation
- Customer functionality: login, balance inquiry, deposits, withdrawals, transaction history, logout
- Admin functionality: system administration, user account management, system monitoring
- File-based database system for persistent data storage
- PIN-based authentication with role-based access control
- Transaction logging with timestamps
- Comprehensive error handling and input validation

### Out of Scope

- Graphical user interface (potential future enhancement)
- Database integration beyond text files (potential future enhancement)
- Advanced security features like encryption or multi-factor authentication
- Network capabilities for distributed access
- Integration with actual banking systems

## 4. Technical Approach

### Architecture

The system will follow an object-oriented architecture with clear separation of concerns:

1. **Core Classes**:
   - Abstract `User` class as the base for different user types
   - `Customer` and `Admin` classes extending the base User class
   - `Account` class for managing financial data and operations
   - `Transaction` class for representing financial transactions
   - `ATM` class for orchestrating the overall system operation
   - `FileStorage` utility for handling data persistence

2. **Data Persistence**:
   The application will implement a file-based database system using text files:
   - `users.txt` - Storing user credentials and roles
   - `accounts.txt` - Maintaining account information
   - `transactions.txt` - Recording transaction history

3. **Security Features**:
   - PIN-based authentication system
   - Role-based access control (Customer vs Admin privileges)
   - Input validation to prevent invalid operations
   - Transaction logging for audit purposes

### Development Methodology

The project will be developed using an incremental approach:

1. Core class structure design and implementation
2. User authentication system development
3. Transaction processing functionality implementation
4. File-based persistence layer creation
5. User interface refinement
6. Comprehensive testing and debugging

## 5. Project Timeline

| Phase | Duration | Activities |
|-------|----------|------------|
| Planning | 1 week | Requirements analysis, system design, class diagram creation |
| Development - Core | 2 weeks | Implementation of core classes and authentication system |
| Development - Features | 2 weeks | Implementation of transaction processing and file storage |
| Testing | 1 week | Unit testing, integration testing, and bug fixing |
| Documentation | 1 week | Code documentation, user manual creation |
| **Total** | **7 weeks** | |

## 6. Resources Required

### Technical Resources

- Java Development Kit (JDK) 8 or higher
- Integrated Development Environment (IDE) such as Eclipse, IntelliJ IDEA, or NetBeans
- Version control system (Git)
- Text editor for documentation

### Human Resources

- Java Developer(s) with knowledge of:
  - Object-oriented programming
  - File I/O operations
  - Console-based application development
  - Exception handling

## 7. Expected Outcomes

### Deliverables

- Complete source code with proper documentation
- User manual for both customer and admin operations
- System documentation including class diagrams and flow charts
- Test cases and test results documentation

### Success Criteria

- The system successfully authenticates users based on their roles
- Customers can perform all banking operations (balance inquiry, deposits, withdrawals)
- Transaction history is properly maintained and can be viewed
- Admin users can access system management features
- All data persists between application sessions
- The system handles errors gracefully without crashing

## 8. Future Enhancements

Potential areas for future development include:

- Graphical user interface implementation
- Database integration (replacing text files)
- Enhanced security features (encryption, multi-factor authentication)
- Additional banking features (transfers, bill payments)
- Administrative reporting capabilities
- Mobile application version

## 9. Risks and Mitigation Strategies

| Risk | Impact | Mitigation Strategy |
|------|--------|---------------------|
| Data corruption | High | Implement backup mechanisms and data validation |
| Security vulnerabilities | High | Regular code reviews and security testing |
| Usability issues | Medium | User testing and interface refinement |
| Scope creep | Medium | Clear requirements documentation and change management |

## 10. Conclusion

The ATM Interface System project provides an excellent opportunity to demonstrate practical application of programming concepts and software design principles. By simulating a real-world banking system, the project will showcase fundamental skills in object-oriented design, data persistence, user authentication, and transaction processing. The modular architecture allows for future enhancements while delivering a fully functional system within the proposed timeline.

---

Prepared as a project proposal for the ATM Interface System implementation.





# ATM INTERFACE SYSTEM - PROJECT DESCRIPTION

## Project Overview
The ATM Interface System is a comprehensive Java-based application that simulates the functionality of an Automated Teller Machine (ATM). This console-based system provides a realistic banking experience with multiple user roles, secure authentication, and persistent data storage. The project demonstrates fundamental programming concepts including object-oriented design, file handling, user authentication, and transaction processing.

## Technical Implementation

### Architecture
The system follows an object-oriented architecture with clear separation of concerns:

1. **Core Classes**:
   - Abstract `User` class serves as the base for different user types
   - `Customer` and `Admin` classes extend the base User class with role-specific functionality
   - `Account` class manages financial data and operations
   - `Transaction` class represents financial transactions with timestamps
   - `ATM` class orchestrates the overall system operation
   - `FileStorage` utility handles data persistence

2. **Data Persistence**:
   The application implements a file-based database system using text files:
   - `users.txt` - Stores user credentials and roles (CUSTOMER/ADMIN, ID, PIN)
   - `accounts.txt` - Maintains account information (User ID, Account Number, Balance)
   - `transactions.txt` - Records transaction history (User ID, Type, Amount, Balance, Timestamp)

3. **Security Features**:
   - PIN-based authentication system
   - Role-based access control (Customer vs Admin privileges)
   - Input validation to prevent invalid operations
   - Transaction logging for audit purposes

## Functional Features

### Customer Features
- Secure login with User ID and PIN
- Account balance inquiry
- Cash deposit functionality
- Cash withdrawal with balance validation
- Transaction history viewing
- Secure logout

### Admin Features
- System administration capabilities
- User account management
- System monitoring functionality

## Technical Highlights

1. **Object-Oriented Design**:
   - Inheritance hierarchy (User → Customer/Admin)
   - Encapsulation of data within appropriate classes
   - Abstraction of common functionality
   - Polymorphic behavior based on user roles

2. **Error Handling**:
   - Robust exception handling for file operations
   - Input validation to prevent invalid transactions
   - Graceful error recovery mechanisms

3. **Data Management**:
   - Persistent storage across application sessions
   - Transaction logging with timestamps
   - Real-time balance updates

## Development Approach
The project was developed using an incremental approach:

1. Core class structure design and implementation
2. User authentication system development
3. Transaction processing functionality implementation
4. File-based persistence layer creation
5. User interface refinement
6. Comprehensive testing and debugging

## Learning Outcomes
This project demonstrates proficiency in:

- Java programming fundamentals
- Object-oriented programming principles
- File I/O operations
- Data persistence techniques
- User authentication implementation
- Console-based user interface design
- Error handling and input validation
- Software architecture principles

## Future Enhancements
Potential areas for future development include:

- Graphical user interface implementation
- Database integration (replacing text files)
- Enhanced security features (encryption, multi-factor authentication)
- Additional banking features (transfers, bill payments)
- Administrative reporting capabilities

---
Developed as a course project demonstrating practical application of programming concepts and software design principles.