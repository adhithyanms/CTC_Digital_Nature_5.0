CREATE TABLE customers(

    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    age NUMBER,
    loan_interest_rate NUMBER,
    balance NUMBER,
    IsVIP VARCHAR2(10)

);



CREATE TABLE loans(

    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    loan_amount NUMBER,
    due_date DATE,

    FOREIGN KEY(customer_id)
    REFERENCES customers(customer_id)

);
