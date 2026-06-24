CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
COMMIT;
END;
/