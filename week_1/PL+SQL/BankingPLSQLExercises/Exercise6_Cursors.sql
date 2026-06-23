-- Exercise 6: Cursors
-- Schema assumed: Customers, Accounts, Transactions, Loans.

SET SERVEROUTPUT ON;

-- Scenario 1: Generate monthly statements using an explicit cursor.
DECLARE
  CURSOR c_monthly_statements IS
    SELECT c.CustomerID,
           c.Name,
           a.AccountID,
           t.TransactionDate,
           t.Amount,
           t.TransactionType
    FROM Customers c
    JOIN Accounts a ON a.CustomerID = c.CustomerID
    JOIN Transactions t ON t.AccountID = a.AccountID
    WHERE t.TransactionDate >= TRUNC(SYSDATE, 'MM')
      AND t.TransactionDate < ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1)
    ORDER BY c.CustomerID, t.TransactionDate;

  v_row c_monthly_statements%ROWTYPE;
BEGIN
  OPEN c_monthly_statements;
  LOOP
    FETCH c_monthly_statements INTO v_row;
    EXIT WHEN c_monthly_statements%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(
      'Customer: ' || v_row.Name ||
      ' | Account: ' || v_row.AccountID ||
      ' | ' || TO_CHAR(v_row.TransactionDate, 'YYYY-MM-DD') ||
      ' | ' || v_row.TransactionType ||
      ' | Amount: ' || v_row.Amount
    );
  END LOOP;
  CLOSE c_monthly_statements;
END;
/

-- Scenario 2: Apply an annual fee to all accounts using an explicit cursor.
DECLARE
  CURSOR c_accounts IS
    SELECT AccountID, Balance
    FROM Accounts;

  v_account_id Accounts.AccountID%TYPE;
  v_balance    Accounts.Balance%TYPE;
  v_annual_fee NUMBER := 100;
BEGIN
  OPEN c_accounts;
  LOOP
    FETCH c_accounts INTO v_account_id, v_balance;
    EXIT WHEN c_accounts%NOTFOUND;

    UPDATE Accounts
    SET Balance = Balance - v_annual_fee
    WHERE AccountID = v_account_id;
  END LOOP;
  CLOSE c_accounts;

  COMMIT;
END;
/

-- Scenario 3: Update loan interest rates using an explicit cursor.
-- Policy used here: loans above 10000 increase by 1.5 percent, others by 0.5 percent.
DECLARE
  CURSOR c_loans IS
    SELECT LoanID, LoanAmount, InterestRate
    FROM Loans;

  v_loan_id     Loans.LoanID%TYPE;
  v_loan_amount Loans.LoanAmount%TYPE;
  v_rate        Loans.InterestRate%TYPE;
BEGIN
  OPEN c_loans;
  LOOP
    FETCH c_loans INTO v_loan_id, v_loan_amount, v_rate;
    EXIT WHEN c_loans%NOTFOUND;

    UPDATE Loans
    SET InterestRate = InterestRate + CASE WHEN v_loan_amount > 10000 THEN 1.5 ELSE 0.5 END
    WHERE LoanID = v_loan_id;
  END LOOP;
  CLOSE c_loans;

  COMMIT;
END;
/

-- Sample Output:
-- Monthly statements print one line per transaction for the current month.
-- Annual fees are deducted from every account balance.
-- Loan interest rates are updated according to the policy in the cursor loop.
