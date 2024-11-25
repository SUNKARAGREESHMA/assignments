CREATE DATABASE BankDB1;
USE BankDB1;
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

    
    INSERT INTO Branches (BranchID, BranchName, Location)
VALUES 
(1, 'Main Branch', 'New York'),
(2, 'South Branch', 'Los Angeles'),
(3, 'East Branch', 'Chicago'),
(4, 'West Branch', 'San Francisco');
 
 
INSERT INTO Employees (EmployeeID, BranchID, FirstName, LastName, Role, Salary)
VALUES 
(1, 1, 'John', 'Doe', 'Manager', 75000.00),
(2, 2, 'Jane', 'Smith', 'Sales Associate', 55000.00),
(3, 3, 'Alice', 'Johnson', 'Software Engineer', 85000.00),
(4, 4, 'Bob', 'Brown', 'HR Specialist', 62000.00);
    
    
    # 1) list all customers and their accounts with balances
select  
c.CustomerID, c.FirstName, c.LastName, a.AccountID, a.AccountType, a.Balance from Customers c join 
Accounts a on c.CustomerID = a.CustomerID;


#  Problem Statement 2: List all employees who manage branches where the total account balances exceed $20,000.
SELECT e.EmployeeID, e.FirstName, e.LastName, b.BranchName
FROM Employees e
JOIN Branches b ON e.BranchID = b.BranchID
WHERE e.BranchID IN (
    SELECT e.BranchID
    FROM Employees e
    JOIN Accounts a ON e.BranchID = a.AccountID  -- Assuming employees manage the accounts
    GROUP BY e.BranchID
    HAVING SUM(a.Balance) > 20000
    
    );
    
   


# Problem Statement 3: Identify accounts whose balance is higher than the average balance of accounts within their branch.

SELECT a.AccountID, a.AccountType, a.Balance
FROM Accounts a
JOIN Employees e ON e.EmployeeID = a.CustomerID 
GROUP BY e.BranchID
HAVING a.Balance > AVG(a.Balance); 

#4. Find customers who have at least one transaction of more than $1,000
select distinct c.FirstName, c.LastName
from Customers c
join Accounts a on c.CustomerID = a.CustomerID
join Transactions t on a.AccountID = t.AccountID
where t.Amount > 1000;


# Problem Statement 5: Get the total deposits and total withdrawals for each account, along with the account type.
select a.AccountID, a.AccountType, sum(CASE WHEN t.TransactionType = 'Deposit' THEN t.Amount ELSE 0 END) as TotalDeposits,
sum(CASE WHEN t.TransactionType = 'Withdrawal' THEN t.Amount ELSE 0 END) as TotalWithdrawals
from Accounts a
left join Transactions t on a.AccountID = t.AccountID
group by a.AccountID, a.AccountType;


# Problem Statement 6: Find pairs of customers who have accounts with the same account type and belong to the same branch.

select c1.FirstName as Customer1FirstName, c1.LastName as Customer1LastName,c2.FirstName as Customer2FirstName, c2.LastName AS Customer2LastName,
a1.AccountType from Customers c1
join Accounts a1 on c1.CustomerID = a1.CustomerID
join Customers c2 on c1.BranchID = c2.BranchID
join Accounts a2 on c2.CustomerID = a2.CustomerID
where c1.CustomerID < c2.CustomerID
and a1.AccountType = a2.AccountType
and a1.BranchID = a2.BranchID;

#Problem Statement 7: Find customers who do not have any transactions recorded.

select c.FirstName, c.LastName
from Customers c
left join Accounts a on c.CustomerID = a.CustomerID
left join Transactions t on a.AccountID = t.AccountID
where t.TransactionID IS NULL;



#8. Rank customers based on their total balance across all accounts
select c.FirstName, c.LastName, sum(a.Balance) as TotalBalance,
RANK() over (order by sum(a.Balance) desc) as Ranks
from Customers c
join Accounts a on c.CustomerID = a.CustomerID
group by c.CustomerID
order by Ranks;

#9. List employees whose salary is above the average salary of all employees in their branch
select e.FirstName, e.LastName, e.Salary, b.BranchName
from Employees e
join Branches b on e.BranchID = b.BranchID
where e.Salary > (select avg(e2.Salary) from Employees e2 where e2.BranchID = e.BranchID);
