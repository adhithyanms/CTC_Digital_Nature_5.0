SET SERVEROUTPUT ON;
DECLARE
CURSOR loan_cursor IS
    SELECT 
    c.customer_name,
    l.loan_amount,
    l.due_date
    FROM customers c
    JOIN loans l
    ON c.customer_id=l.customer_id
    WHERE l.due_date <= SYSDATE+30;
BEGIN
FOR loan IN loan_cursor
LOOP
DBMS_OUTPUT.PUT_LINE(
    'Reminder : '
    || loan.customer_name
    || ' Loan amount '
    || loan.loan_amount
    || ' Due Date '
    || loan.due_date
);

END LOOP;
END;
/
