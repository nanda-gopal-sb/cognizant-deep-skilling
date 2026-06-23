-- Exercise 1: Control Structures
-- Schema assumed: Customers, Loans.
-- Sample data from the prompt is expected to be loaded before running this script.

SET SERVEROUTPUT ON;

-- Scenario 1: Apply a 1 percent discount to loan interest rates for customers above 60 years old.
BEGIN
  FOR customer_rec IN (
    SELECT CustomerID
    FROM Customers
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = customer_rec.CustomerID;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 2: Mark customers with balance over 10000 as VIP.
-- The schema does not include an IsVIP column, so this script adds it if needed.
BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP VARCHAR2(5) DEFAULT ''FALSE'')';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -1430 THEN
      RAISE;
    END IF;
END;
/

BEGIN
  FOR customer_rec IN (
    SELECT CustomerID
    FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = customer_rec.CustomerID;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within the next 30 days.
BEGIN
  FOR loan_rec IN (
    SELECT c.Name, l.LoanID, l.EndDate
    FROM Customers c
    JOIN Loans l ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30)
    ORDER BY c.Name
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: ' || loan_rec.Name ||
      ' has loan ' || loan_rec.LoanID ||
      ' due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD')
    );
  END LOOP;
END;
/

-- Sample Output:
-- Customers older than 60 have their loan interest rate reduced by 1 percent.
-- Customers with balance greater than 10000 are marked as TRUE in IsVIP.
-- Reminder: John Doe has loan 1 due on 2031-06-24
