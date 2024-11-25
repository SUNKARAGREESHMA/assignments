CREATE DATABASE COUNTRY;
USE COUNTRY;

CREATE TABLE countries (
    country_id VARCHAR(5) PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL,
    region_id INT NOT NULL
);
 
 CREATE TABLE jobs (
    JOB_ID VARCHAR(10) PRIMARY KEY NOT NULL,
    JOB_TITLE VARCHAR(35) NOT NULL DEFAULT 'null',
    MIN_SALARY DECIMAL (6,0) DEFAULT 0,
    MAX_SALARY DECIMAL (6,0) DEFAULT 0
);
 
CREATE TABLE job_history (
    employee_id INT PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    job_id VARCHAR(10) NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (job_id) REFERENCES jobs(JOB_ID)
);
 drop table departments;
 CREATE TABLE  departments (
  DEPARTMENT_ID  DECIMAL (4,0) default 0 ,
    LOCATION_ID DECIMAL (4,0) default 0 ,
    MANAGER_ID DECIMAL (6,0) default 0 ,
    DEPARTMENT_NAME VARCHAR(30) NOT NULL DEFAULT 'NULL',
    primary key(DEPARTMENT_ID,MANAGER_ID)
   
);
drop table employees; 
 
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    hire_date DATE NOT NULL,
    job_id VARCHAR(10) NOT NULL,
    salary DECIMAL(8,2),
    commission DECIMAL(8,2),
     MANAGER_ID DECIMAL (6,0),
    DEPARTMENT_ID DECIMAL(4,0),
    FOREIGN KEY (job_id) REFERENCES jobs(JOB_ID),
    FOREIGN KEY (DEPARTMENT_ID, MANAGER_ID) REFERENCES departments(DEPARTMENT_ID, MANAGER_ID)
);
desc countries;
desc jobs;
desc job_history ;
desc departments;
desc employees;