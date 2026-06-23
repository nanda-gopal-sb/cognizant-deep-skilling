-- Exercise 4: Functions
-- Schema assumed: Customers, Accounts, Loans.

SET SERVEROUTPUT ON;

-- Scenario 1: Calculate a customer's age in years.
CREATE OR REPLACE FUNCTION CalculateAge(
  p_dob IN DATE
) RETURN NUMBER IS
BEGIN
  RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;
/

-- Scenario 2: Calculate the monthly installment for a loan.
-- Assumption: interest rate is passed as an annual percentage.
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  p_loan_amount   IN NUMBER,
  p_interest_rate IN NUMBER,
  p_years         IN NUMBER
) RETURN NUMBER IS
  v_months NUMBER := p_years * 12;
  v_monthly_rate NUMBER := p_interest_rate / 100 / 12;
BEGIN
  IF v_monthly_rate = 0 THEN
    RETURN p_loan_amount / v_months;
  END IF;

  RETURN p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) /
         (POWER(1 + v_monthly_rate, v_months) - 1);
END;
/

-- Scenario 3: Check if an account has enough balance for a transaction.
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  p_account_id IN NUMBER,
  p_amount     IN NUMBER
) RETURN BOOLEAN IS
  v_balance NUMBER;
BEGIN
  SELECT Balance
  INTO v_balance
  FROM Accounts
  WHERE AccountID = p_account_id;

  RETURN v_balance >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/

-- Sample Output:
-- CalculateAge(DATE '1985-05-15') returns 41 when run in 2026.
-- CalculateMonthlyInstallment returns the expected EMI value.
-- HasSufficientBalance(1, 500) returns TRUE for an account with sufficient balance.
