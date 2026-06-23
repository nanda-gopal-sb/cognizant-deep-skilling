-- Exercise 5: Triggers
-- Schema assumed: Customers, Accounts, Transactions.

SET SERVEROUTPUT ON;

-- Supporting table for transaction audit records.
BEGIN
  EXECUTE IMMEDIATE '
    CREATE TABLE AuditLog (
      TransactionID   NUMBER,
      AccountID       NUMBER,
      TransactionDate DATE,
      Amount          NUMBER,
      TransactionType VARCHAR2(10),
      LoggedAt        DATE
    )';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -955 THEN
      RAISE;
    END IF;
END;
/

-- Scenario 1: Update the last modified date whenever a customer record is updated.
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: Insert an audit record whenever a transaction is inserted.
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    TransactionID, AccountID, TransactionDate, Amount, TransactionType, LoggedAt
  ) VALUES (
    :NEW.TransactionID,
    :NEW.AccountID,
    :NEW.TransactionDate,
    :NEW.Amount,
    :NEW.TransactionType,
    SYSDATE
  );
END;
/

-- Scenario 3: Enforce rules for deposits and withdrawals.
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  IF UPPER(:NEW.TransactionType) = 'DEPOSIT' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20003, 'Deposit amount must be positive.');
    END IF;
  ELSIF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20004, 'Withdrawal amount must be positive.');
    END IF;

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20005, 'Withdrawal amount cannot exceed balance.');
    END IF;
  END IF;
END;
/

-- Sample Output:
-- Updating a customer automatically refreshes LastModified.
-- Every transaction inserted into Transactions is copied into AuditLog.
-- Invalid deposits and over-limit withdrawals are rejected with an application error.
