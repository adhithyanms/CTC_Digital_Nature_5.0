DECLARE
CURSOR c_customer IS
    SELECT customer_id,balance
    FROM customers;
BEGIN
    FOR c IN c_customer
LOOP
    IF c.balance > 10000 THEN
    UPDATE customers
    SET IsVIP='TRUE'
    WHERE customer_id=c.customer_id;
END IF;
END LOOP;
COMMIT;
END;
/
