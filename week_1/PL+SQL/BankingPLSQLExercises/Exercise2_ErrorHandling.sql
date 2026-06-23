-- Exercise 2: Error Handling
-- Schema assumed: Accounts, Customers, Employees.

SET SERVEROUTPUT ON;

-- Scenario 1: Safe transfer of funds between two accounts.
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account_id IN NUMBER,
  p_to_account_id   IN NUMBER,
  p_amount          IN NUMBER
) IS
  v_from_balance NUMBER;
  v_to_balance   NUMBER;
BEGIN
  SELECT Balance
  INTO v_from_balance
  FROM Accounts
  WHERE AccountID = p_from_account_id
  FOR UPDATE;

  SELECT Balance
  INTO v_to_balance
  FROM Accounts
  WHERE AccountID = p_to_account_id
  FOR UPDATE;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer.');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_amount
  WHERE AccountID = p_from_account_id;

  UPDATE Accounts
  SET Balance = Balance + p_amount
  WHERE AccountID = p_to_account_id;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('SafeTransferFunds failed: ' || SQLERRM);
    ROLLBACK;
END;
/

-- Scenario 2: Update an employee salary and log an error if the employee does not exist.
CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id IN NUMBER,
  p_percent     IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percent / 100)
  WHERE EmployeeID = p_employee_id;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Employee not found: ' || p_employee_id);
    RETURN;
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UpdateSalary failed: ' || SQLERRM);
    ROLLBACK;
END;
/

-- Scenario 3: Insert a new customer and prevent duplicate IDs.
CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id IN NUMBER,
  p_name        IN VARCHAR2,
  p_dob         IN DATE,
  p_balance     IN NUMBER
) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer already exists with ID: ' || p_customer_id);
    ROLLBACK;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('AddNewCustomer failed: ' || SQLERRM);
    ROLLBACK;
END;
/

-- Sample Output:
-- SafeTransferFunds failed: ORA-20001: Insufficient funds for transfer.
-- Employee not found: 99
-- Customer already exists with ID: 1
