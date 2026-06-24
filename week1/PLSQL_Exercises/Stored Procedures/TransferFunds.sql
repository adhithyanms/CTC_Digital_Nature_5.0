CREATE OR REPLACE PROCEDURE TransferFunds
(
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
)
AS
source_balance NUMBER;
BEGIN
    SELECT balance
    INTO source_balance
    FROM accounts
    WHERE account_id = from_account;
    IF source_balance >= amount THEN
    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_account;
    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_account;
COMMIT;
ELSE
    DBMS_OUTPUT.PUT_LINE(
    'Insufficient Balance'
    );
END IF;
END;
/