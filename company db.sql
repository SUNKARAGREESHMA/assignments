
CREATE DATABASE IF NOT EXISTS CompanyDB;
USE CompanyDB;
 
 DROP TABLE IF EXISTS Employees;
 DROP TABLE IF EXISTS Projects;
  DROP TABLE IF EXISTS  Assignments;
  DROP TABLE IF EXISTS  Salaries;
  
CREATE TABLE Departments (
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50) NOT NULL UNIQUE,
    Location VARCHAR(100) NOT NULL
);

-- Create Employees Table


CREATE TABLE Employees (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DepartmentID INT NOT NULL,
    DateOfBirth DATE NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Gender ENUM('Male', 'Female', 'Other') NOT NULL,
    HireDate DATE NOT NULL CHECK (HireDate >= '2000-01-01'),
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);
 
-- Create Projects Table
CREATE TABLE Projects (
    ProjectID INT AUTO_INCREMENT PRIMARY KEY,
    ProjectName VARCHAR(100) NOT NULL UNIQUE,
    StartDate DATE NOT NULL,
    EndDate DATE, CHECK (EndDate > StartDate),
    Budget DECIMAL(15, 2) NOT NULL CHECK (Budget > 0)
);
 
CREATE TABLE Assignments (
    AssignmentID INT AUTO_INCREMENT PRIMARY KEY,
    EmployeeID INT NOT NULL,
    ProjectID INT NOT NULL,
    HoursWorked DECIMAL(5, 2) NOT NULL CHECK (HoursWorked >= 0),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
);
 
-- Create Salaries Table
CREATE TABLE Salaries (
    SalaryID INT AUTO_INCREMENT PRIMARY KEY,
    EmployeeID INT NOT NULL,
    BaseSalary DECIMAL(10, 2) NOT NULL CHECK (BaseSalary > 0),
    Bonus DECIMAL(10, 2) CHECK (Bonus >= 0),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);
 
-- Insert into Departments
INSERT INTO Departments (DepartmentName, Location) VALUES
('HR', 'New York'),
('IT', 'San Francisco'),
('Finance', 'Chicago'),
('Marketing', 'Los Angeles');
 
-- Insert into Employees
INSERT INTO Employees (FirstName, LastName, DepartmentID, DateOfBirth, Email, Gender, HireDate) VALUES
('John', 'Doe', 1, '1985-04-12', 'john.doe@example.com', 'Male', '2010-05-10'),
('Jane', 'Smith', 2, '1990-08-23', 'jane.smith@example.com', 'Female', '2015-07-19'),
('Alice', 'Brown', 3, '1982-11-17', 'alice.brown@example.com', 'Female', '2008-02-25'),
('Bob', 'Johnson', 4, '1979-03-30', 'bob.johnson@example.com', 'Male', '2005-01-15');
 
-- Insert into Projects
INSERT INTO Projects (ProjectName, StartDate, EndDate, Budget) VALUES
('Website Redesign', '2023-01-01', '2023-12-31', 100000),
('Mobile App Development', '2023-03-01', '2024-02-28', 150000),
('Data Migration', '2022-06-01', '2023-06-30', 50000);
 
-- Insert into Assignments
INSERT INTO Assignments (EmployeeID, ProjectID, HoursWorked) VALUES
(1, 1, 120),
(2, 2, 250),
(3, 3, 180),
(4, 1, 90);
 
-- Insert into Salaries
INSERT INTO Salaries (EmployeeID, BaseSalary, Bonus) VALUES
(1, 60000, 5000),
(2, 80000, 7000),
(3, 75000, 6000),
(4, 90000, 10000);

#   1 . Retrieve all employees in the IT department

 select e.EmployeeID, e.FirstName ,e.LastName,d.DepartmentName from Employees e join  Departments d on e.DepartmentID = d.DepartmentID where DepartmentName='IT';
 
 #  2. Find employees hired after 2010
 
 select * from Employees;
select * from Employees where HireDate>'2010-12-31';


#  3. List projects with a budget exceeding $80,000

select * FROM Projects where Budget>80000;


#  4. Sort employees by their hire date in descending order.

select * from Employees order by HireDate desc; 

#  5. Show projects sorted by their budget in ascending order

select * from Projects order by Budget;

#  6. Count the number of employees in each department

select d.DepartmentName ,count(e.EmployeeID) as empcount from Departments d left join Employees e on d.DepartmentID=e.DepartmentID group by d.DepartmentName ;

#  7. Display the top 3 employees with the highest base salary

select * from Salaries order by BaseSalary desc limit 3; 

#  8. Retrieve employee names along with their department names


select Employees.FirstName,Departments.DepartmentName from Employees,Departments where Employees.DepartmentID=Departments.DepartmentID;


# 9. List all assignments, including employee and project details.


SELECT a.AssignmentID, e.FirstName, e.LastName, p.ProjectName, a.HoursWorked FROM Assignments a
join Employees e on a.EmployeeID = e.EmployeeID
 join Projects p on a.ProjectID = p.ProjectID;
 
 
 #  10. Find employees working on the project with the highest budget

select e.EmployeeID, e.FirstName, e.LastName, p.ProjectName
from Assignments a
join Employees e on a.EmployeeID = e.EmployeeID
join Projects p on a.ProjectID = p.ProjectID
where p.Budget = (SELECT MAX(Budget) FROM Projects);
 
#  11. Calculate the age of each employee.

select EmployeeID, FirstName, LastName,
       TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) as Age
from Employees;
 
# 12. Calculate the total salary (base + bonus) for each employee
select s.EmployeeID,e.FirstName, e.LastName,(s.BaseSalary + IFNULL(s.Bonus, 0)) as TotalSalary
from Salaries s join Employees e on s.EmployeeID = e.EmployeeID;
 
#  13.Find all employees hired in 2015.

select EmployeeID, FirstName, LastName, HireDate
from Employees
where YEAR(HireDate) = 2015;
 
# 14.Retrieve the names of projects ending before December 2023.

select ProjectName, EndDate
from Projects
where EndDate < '2023-12-01';
 
#  15.List employees with base salaries greater than $70,000.

select e.EmployeeID, e.FirstName, e.LastName, s.BaseSalary
from Salaries s
join Employees e on s.EmployeeID = e.EmployeeID
where s.BaseSalary > 70000;
 
#  16.Count the number of projects handled by each employee.

select e.EmployeeID, e.FirstName, e.LastName, COUNT(a.ProjectID) as ProjectCount from Employees e
left join Assignments a on e.EmployeeID = a.EmployeeID
group by e.EmployeeID, e.FirstName, e.LastName;
 
# 17.List all departments located in "San Francisco."

select DepartmentID, DepartmentName, Location from Departments
where Location = 'San Francisco';
 
# 18.Display project names along with total hours worked on each.

select p.ProjectName, SUM(a.HoursWorked) as TotalHours from Projects p
left join Assignments a on p.ProjectID = a.ProjectID
group by p.ProjectName;
 
# 19.Find the highest bonus received by any employee.

select MAX(Bonus) as HighestBonus
from Salaries;
 
# 20. Identify projects that lasted for more than 12 months.

select ProjectID, ProjectName, StartDate, EndDate from Projects where TIMESTAMPDIFF(MONTH, StartDate, EndDate) > 12;
 
# 21.Retrieve all projects starting in 2023.

select ProjectID, ProjectName, StartDate
from Projects
where YEAR(StartDate) = 2023;
 
# 22.Calculate the total hours worked by each employee across all projects.

select e.EmployeeID, e.FirstName, e.LastName, SUM(a.HoursWorked) as TotalHours
from Employees e
left join Assignments a on e.EmployeeID = a.EmployeeID
group by e.EmployeeID, e.FirstName, e.LastName;
 
# 23.Find the department with the most employees.

select d.DepartmentName, COUNT(e.EmployeeID) as EmployeeCount
from Departments d left join Employees e on d.DepartmentID = e.DepartmentID
group by d.DepartmentName
order by EmployeeCount DESC LIMIT 1;
 
# 24.List employees who were born before 1985.

select EmployeeID, FirstName, LastName, DateOfBirth from Employees where DateOfBirth < '1985-01-01';
