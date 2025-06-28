-- Create Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

-- Create Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Transactions Table
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Create Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

--INSERT INTO CUSTOMERS
INSERT INTO Customers VALUES (1, 'Rahul Mehra', TO_DATE('1950-05-15', 'YYYY-MM-DD'), 8000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Priya Sharma', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15000, SYSDATE);





--INSERT INTO ACCOUNTS
INSERT INTO Accounts VALUES (1, 1, 'Savings', 8000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Current', 15000, SYSDATE);

--INSERT INTO TRANSACTIONS
INSERT INTO Transactions VALUES (1, 1, TO_DATE('2024-06-01', 'YYYY-MM-DD'), 2000, 'Credit');
INSERT INTO Transactions VALUES (2, 1, TO_DATE('2024-06-05', 'YYYY-MM-DD'), 500, 'Debit');

--INSERT INTO LOANS
INSERT INTO Loans VALUES (1, 1, 50000, 8.5, TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2025-07-01','YYYY-MM-DD'));
INSERT INTO Loans VALUES (2, 2, 30000, 9.0, TO_DATE('2024-07-01','YYYY-MM-DD'), TO_DATE('2025-07-15','YYYY-MM-DD'));

--INSERT INTO EMPLOYEES
INSERT INTO Employees VALUES (1, 'Neha Kulkarni', 'Manager', 85000, 'Loans', TO_DATE('2018-04-01', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Raj Malhotra', 'Clerk', 35000, 'Accounts', TO_DATE('2020-01-10', 'YYYY-MM-DD'));

COMMIT


/* Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
o	Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
*/
DECLARE
  CURSOR customer_cursor IS
    SELECT c.CustomerID,
           EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM DOB) AS Age,
           l.LoanID,
           l.InterestRate
    FROM Customers c
    JOIN Loans l
      ON c.CustomerID = l.CustomerID;

BEGIN
  FOR customer_record IN customer_cursor LOOP
    IF customer_record.Age > 60 THEN
      UPDATE Loans
         SET InterestRate = InterestRate - 1
       WHERE LoanID = customer_record.LoanID;

      DBMS_OUTPUT.PUT_LINE(
        'Customer ' || customer_record.CustomerID || ': interest rate discounted.'
      );
    END IF;
  END LOOP;
  COMMIT;
END;

/*
Scenario 2: A customer can be promoted to VIP status based on their balance.
o	Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
*/

ALTER TABLE Customers ADD IsVIP VARCHAR2(5);
DECLARE
  CURSOR customer_cursor IS
    SELECT CustomerID, Balance FROM Customers;

  var_customer_id Customers.CustomerID%TYPE;
  var_balance Customers.Balance%TYPE;
BEGIN
  FOR customer_record IN customer_cursor LOOP
    var_customer_id := customer_record.CustomerID;
    var_balance := customer_record.Balance;

    IF var_balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = var_customer_id;

      DBMS_OUTPUT.PUT_LINE('Customer ID: ' || var_customer_id || 
                           ' → Promoted to VIP');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Customer ID: ' || var_customer_id || 
                           ' → Not eligible for VIP');
    END IF;
  END LOOP;
  COMMIT;
END;

/* Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
o	Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.
*/

DECLARE
  CURSOR due_loan_cursor IS
    SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

  var_customer_id Customers.CustomerID%TYPE;
  var_customer_name Customers.Name%TYPE;
  var_loan_id Loans.LoanID%TYPE;
  var_end_date Loans.EndDate%TYPE;
BEGIN
  FOR loan_record IN due_loan_cursor LOOP
    var_customer_id := loan_record.CustomerID;
    var_customer_name := loan_record.Name;
    var_loan_id := loan_record.LoanID;
    var_end_date := loan_record.EndDate;
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || var_loan_id || 
                         ' for Customer ' || var_customer_name || 
                         ' (ID: ' || var_customer_id || 
                         ') is due on ' || TO_CHAR(var_end_date, 'DD-MON-YYYY'));
  END LOOP;
END;

/*Exercise 3: Stored Procedures

Scenario 1: The bank needs to process monthly interest for all savings accounts.
o	Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.
*/

SELECT * FROM ACCOUNTS;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE PROCESSMONTHLYINTEREST AS
BEGIN
    UPDATE ACCOUNTS
    SET BALANCE = BALANCE * 1.01,
        LASTMODIFIED = SYSDATE
    WHERE ACCOUNTTYPE = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END PROCESSMONTHLYINTEREST;
/
EXEC PROCESSMONTHLYINTEREST();
SELECT * FROM ACCOUNTS;

/* Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
o	Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.
*/
SELECT * FROM EMPLOYEES;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEBONUS(
    P_DEPARTMENT IN EMPLOYEES.DEPARTMENT%TYPE,
    P_BONUS_PERCENTAGE IN NUMBER
) AS
BEGIN
    UPDATE EMPLOYEES
    SET SALARY = SALARY * (1 + P_BONUS_PERCENTAGE / 100),
        HIREDATE = SYSDATE
    WHERE DEPARTMENT = P_DEPARTMENT; 
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in the ' || P_DEPARTMENT || ' department.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END UPDATEEMPLOYEEBONUS;
/
EXEC UPDATEEMPLOYEEBONUS('IT',5);
EXEC UPDATEEMPLOYEEBONUS('HR',3);
SELECT * FROM EMPLOYEES;

/* Scenario 3: Customers should be able to transfer funds between their accounts.
o	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
*/
SELECT * FROM ACCOUNTS;
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE TRANSFERFUNDS(
    P_FROM_ACCOUNT_ID IN ACCOUNTS.ACCOUNTID%TYPE,
    P_TO_ACCOUNT_ID IN ACCOUNTS.ACCOUNTID%TYPE,
    P_AMOUNT IN NUMBER
) AS
    V_FROM_BALANCE ACCOUNTS.BALANCE%TYPE;
BEGIN 
    SELECT BALANCE INTO V_FROM_BALANCE
    FROM ACCOUNTS
    WHERE ACCOUNTID = P_FROM_ACCOUNT_ID
    FOR UPDATE;
    IF V_FROM_BALANCE < P_AMOUNT THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;
    UPDATE ACCOUNTS
    SET BALANCE = BALANCE - P_AMOUNT,
        LASTMODIFIED = SYSDATE
    WHERE ACCOUNTID = P_FROM_ACCOUNT_ID;
    UPDATE ACCOUNTS
    SET BALANCE = BALANCE + P_AMOUNT,
        LASTMODIFIED = SYSDATE
    WHERE ACCOUNTID = P_TO_ACCOUNT_ID;
    COMMIT;
DBMS_OUTPUT.PUT_LINE('Transfer of ' || P_AMOUNT || ' from account ' || P_FROM_ACCOUNT_ID || ' to account ' ||
 P_TO_ACCOUNT_ID || ' completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TRANSFERFUNDS;
/
EXEC TRANSFERFUNDS(1,2,100);