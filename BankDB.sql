CREATE DATABASE BankDB;
USE BankDB;
CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(15),
    Address VARCHAR(255)
);
 
CREATE TABLE Accounts (
    AccountID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(50),
    Balance DECIMAL(10, 2),
    CreatedDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
 
CREATE TABLE Transactions (
    TransactionID INT AUTO_INCREMENT PRIMARY KEY,
    AccountID INT,
    TransactionType VARCHAR(50),
    Amount DECIMAL(10, 2),
    TransactionDate DATETIME,
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
 
CREATE TABLE Branches (
    BranchID INT AUTO_INCREMENT PRIMARY KEY,
    BranchName VARCHAR(100),
    Location VARCHAR(100)
);
 
CREATE TABLE Employees (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    BranchID INT,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    Role VARCHAR(50),
    Salary DECIMAL(10, 2),
    FOREIGN KEY (BranchID) REFERENCES Branches(BranchID)
);
 
INSERT INTO Customers (FirstName, LastName, Email, Phone, Address) 
VALUES 
    ('John', 'Doe', 'john.doe@example.com', '1234567890', '123 Elm St'), 
    ('Jane', 'Smith', 'jane.smith@example.com', '9876543210', '456 Oak St'), 
    ('Michael', 'Brown', 'michael.brown@example.com', '5678901234', '789 Pine St');
INSERT INTO Accounts (CustomerID, AccountType, Balance, CreatedDate)
VALUES
    (1, 'Savings', 5000.00, '2023-01-15'),
    (1, 'Checking', 2000.00, '2023-02-10'),
    (2, 'Savings', 10000.00, '2023-03-05'),
    (3, 'Savings', 7000.00, '2023-04-20');
 
INSERT INTO Transactions (AccountID, TransactionType, Amount, TransactionDate)
VALUES
    (1, 'Deposit', 1000.00, '2023-01-20 10:00:00'),
    (1, 'Withdrawal', 500.00, '2023-01-25 14:30:00'),
    (2, 'Deposit', 2000.00, '2023-02-15 09:15:00'),
    (3, 'Withdrawal', 1000.00, '2023-04-25 16:45:00');
    
    
    #  list all customers and their accounts with balances
select  
c.CustomerID, c.FirstName, c.LastName, a.AccountID, a.AccountType, a.Balance from Customers c join 
Accounts a on c.CustomerID = a.CustomerID;