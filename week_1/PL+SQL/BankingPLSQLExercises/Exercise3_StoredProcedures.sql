-- Exercise 3: Stored Procedures
-- Schema assumed: Accounts, Employees.

SET SERVEROUTPUT ON;

-- Scenario 1: Process monthly interest for all savings accounts.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';

  COMMIT;
END;
/

-- Scenario 2: Add a bonus percentage to employees in a given department.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department   IN VARCHAR2,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department;

  COMMIT;
END;
/

-- Scenario 3: Transfer funds between two accounts with balance validation.
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account_id IN NUMBER,
  p_to_account_id   IN NUMBER,
  p_amount          IN NUMBER
) IS
  v_from_balance NUMBER;
  v_to_balance   NUMBER;
  v_next_txn_id  NUMBER;
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
    RAISE_APPLICATION_ERROR(-20002, 'Source account has insufficient balance.');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_amount
  WHERE AccountID = p_from_account_id;

  UPDATE Accounts
  SET Balance = Balance + p_amount
  WHERE AccountID = p_to_account_id;

  SELECT NVL(MAX(TransactionID), 0) + 1
  INTO v_next_txn_id
  FROM Transactions;

  INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
  VALUES (v_next_txn_id, p_from_account_id, SYSDATE, p_amount, 'Withdrawal');

  INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
  VALUES (v_next_txn_id + 1, p_to_account_id, SYSDATE, p_amount, 'Deposit');

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TransferFunds failed: ' || SQLERRM);
    ROLLBACK;
END;
/

-- Sample Output:
-- Savings account balances increase by 1 percent.
-- Employees in the selected department receive the bonus percentage.
-- Funds are transferred after checking the source balance.
