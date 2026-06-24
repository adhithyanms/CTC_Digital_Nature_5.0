SET SERVEROUTPUT ON;
-- Interest
BEGIN
ProcessMonthlyInterest();
END;
/
-- Bonus
BEGIN
    UpdateEmployeeBonus(
    'IT',
    10
    );

END;
/
-- Transfer
BEGIN
    TransferFunds(
    201,
    202,
    5000
    );
END;
/

SELECT * FROM savings_accounts;
SELECT * FROM employees;
SELECT * FROM accounts;
