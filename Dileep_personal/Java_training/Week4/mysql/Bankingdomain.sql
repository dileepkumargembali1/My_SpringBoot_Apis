-- BANKING DOMAIN DATABASE CREATION WITH PROPER FK REFERENCES
create database bankingdomain;
use bankingdomain;
-- 1. CUSTOMERS TABLE
CREATE TABLE CUSTOMERS (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    date_of_birth DATE,
    account_opening_date DATE
);

-- 2. ACCOUNTS TABLE
CREATE TABLE ACCOUNTS (
    account_id INT PRIMARY KEY,
    customer_id INT,
    account_type VARCHAR(50),
    balance DECIMAL(12,2),
    status VARCHAR(50),
    created_date DATE,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)
);

-- 3. TRANSACTIONS TABLE
CREATE TABLE TRANSACTIONS (
    transaction_id INT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(50),
    amount DECIMAL(12,2),
    transaction_date DATE,
    description VARCHAR(255),
    reference_account_id INT,
    FOREIGN KEY (account_id) REFERENCES ACCOUNTS(account_id),
    FOREIGN KEY (reference_account_id) REFERENCES ACCOUNTS(account_id)
);

-- 4. LOANS TABLE
CREATE TABLE LOANS (
    loan_id INT PRIMARY KEY,
    customer_id INT,
    loan_type VARCHAR(50),
    loan_amount DECIMAL(12,2),
    interest_rate DECIMAL(5,2),
    tenure_months INT,
    status VARCHAR(50),
    approval_date DATE,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)
);

-- 5. LOAN_PAYMENTS TABLE
CREATE TABLE LOAN_PAYMENTS (
    payment_id INT PRIMARY KEY,
    loan_id INT,
    payment_date DATE,
    amount_paid DECIMAL(12,2),
    principal_amount DECIMAL(12,2),
    interest_amount DECIMAL(12,2),
    balance_remaining DECIMAL(12,2),
    FOREIGN KEY (loan_id) REFERENCES LOANS(loan_id)
);

-- 6. CREDIT_CARDS TABLE
CREATE TABLE CREDIT_CARDS (
    card_id INT PRIMARY KEY,
    customer_id INT,
    card_number VARCHAR(20) UNIQUE,
    card_type VARCHAR(50),
    credit_limit DECIMAL(12,2),
    outstanding_balance DECIMAL(12,2),
    issue_date DATE,
    expiry_date DATE,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)
);

-- 7. ATM_TRANSACTIONS TABLE
CREATE TABLE ATM_TRANSACTIONS (
    atm_txn_id INT PRIMARY KEY,
    account_id INT,
    atm_id VARCHAR(50),
    transaction_type VARCHAR(50),
    amount DECIMAL(12,2),
    transaction_date DATE,
    location VARCHAR(100),
    FOREIGN KEY (account_id) REFERENCES ACCOUNTS(account_id)
);

-- INSERT DATA INTO TABLES

-- CUSTOMERS DATA
INSERT INTO CUSTOMERS VALUES (1, 'Ravi Kumar', 'ravi@example.com', '9876543210', 'Hyderabad', '1990-05-15', '2020-01-10');
INSERT INTO CUSTOMERS VALUES (2, 'Priya Sharma', 'priya@example.com', '9876501234', 'Delhi', '1988-03-22', '2021-06-05');
INSERT INTO CUSTOMERS VALUES (3, 'Arjun Reddy', 'arjun@example.com', '9988776655', 'Chennai', '1992-11-02', '2022-02-20');
INSERT INTO CUSTOMERS VALUES (4, 'Sneha Rao', 'sneha@example.com', '9123456789', 'Bangalore', '1995-09-12', '2023-07-15');
INSERT INTO CUSTOMERS VALUES (5, 'Vikas Patel', 'vikas@example.com', '9998887776', 'Mumbai', '1991-12-30', '2024-03-10');

-- ACCOUNTS DATA
INSERT INTO ACCOUNTS VALUES (101, 1, 'Savings', 50000.00, 'Active', '2020-01-15');
INSERT INTO ACCOUNTS VALUES (102, 2, 'Current', 150000.00, 'Active', '2021-06-10');
INSERT INTO ACCOUNTS VALUES (103, 3, 'Savings', 75000.00, 'Active', '2022-02-25');
INSERT INTO ACCOUNTS VALUES (104, 4, 'Savings', 20000.00, 'Active', '2023-07-20');
INSERT INTO ACCOUNTS VALUES (105, 5, 'Current', 100000.00, 'Active', '2024-03-15');

-- TRANSACTIONS DATA
INSERT INTO TRANSACTIONS VALUES (1001, 101, 'Deposit', 10000.00, '2024-06-01', 'Initial Deposit', NULL);
INSERT INTO TRANSACTIONS VALUES (1002, 102, 'Transfer', 5000.00, '2024-06-05', 'Sent to Ravi', 101);
INSERT INTO TRANSACTIONS VALUES (1003, 101, 'Receive', 5000.00, '2024-06-05', 'Received from Priya', 102);
INSERT INTO TRANSACTIONS VALUES (1004, 103, 'Deposit', 20000.00, '2024-06-10', 'Salary Deposit', NULL);
INSERT INTO TRANSACTIONS VALUES (1005, 104, 'Withdrawal', 5000.00, '2024-06-12', 'ATM Withdrawal', NULL);

-- LOANS DATA
INSERT INTO LOANS VALUES (201, 1, 'Home Loan', 2000000.00, 7.5, 240, 'Approved', '2023-05-20');
INSERT INTO LOANS VALUES (202, 2, 'Car Loan', 500000.00, 8.0, 60, 'Approved', '2023-07-01');
INSERT INTO LOANS VALUES (203, 3, 'Personal Loan', 300000.00, 12.5, 36, 'Approved', '2024-01-10');
INSERT INTO LOANS VALUES (204, 4, 'Education Loan', 400000.00, 9.0, 48, 'Approved', '2024-02-15');
INSERT INTO LOANS VALUES (205, 5, 'Business Loan', 1000000.00, 10.0, 120, 'Approved', '2024-03-25');

-- LOAN_PAYMENTS DATA
INSERT INTO LOAN_PAYMENTS VALUES (301, 201, '2024-01-15', 20000.00, 15000.00, 5000.00, 1985000.00);
INSERT INTO LOAN_PAYMENTS VALUES (302, 201, '2024-02-15', 20000.00, 15000.00, 5000.00, 1970000.00);
INSERT INTO LOAN_PAYMENTS VALUES (303, 202, '2024-04-10', 10000.00, 8000.00, 2000.00, 490000.00);
INSERT INTO LOAN_PAYMENTS VALUES (304, 203, '2024-05-05', 15000.00, 10000.00, 5000.00, 290000.00);
INSERT INTO LOAN_PAYMENTS VALUES (305, 204, '2024-06-15', 12000.00, 9000.00, 3000.00, 391000.00);

-- CREDIT_CARDS DATA
INSERT INTO CREDIT_CARDS VALUES (401, 1, '4111222233334444', 'Platinum', 200000.00, 5000.00, '2022-03-10', '2027-03-10');
INSERT INTO CREDIT_CARDS VALUES (402, 2, '5555666677778888', 'Gold', 100000.00, 2000.00, '2023-08-01', '2028-08-01');
INSERT INTO CREDIT_CARDS VALUES (403, 3, '4444555566667777', 'Silver', 50000.00, 1000.00, '2024-01-15', '2029-01-15');
INSERT INTO CREDIT_CARDS VALUES (404, 4, '3333444455556666', 'Platinum', 150000.00, 2500.00, '2024-03-10', '2029-03-10');
INSERT INTO CREDIT_CARDS VALUES (405, 5, '2222333344445555', 'Gold', 120000.00, 3000.00, '2024-04-20', '2029-04-20');

-- ATM_TRANSACTIONS DATA
INSERT INTO ATM_TRANSACTIONS VALUES (501, 101, 'ATM-001', 'Withdrawal', 2000.00, '2024-06-10', 'Hyderabad');
INSERT INTO ATM_TRANSACTIONS VALUES (502, 102, 'ATM-002', 'Deposit', 5000.00, '2024-06-12', 'Delhi');
INSERT INTO ATM_TRANSACTIONS VALUES (503, 103, 'ATM-003', 'Withdrawal', 3000.00, '2024-06-15', 'Chennai');
INSERT INTO ATM_TRANSACTIONS VALUES (504, 104, 'ATM-004', 'Withdrawal', 1000.00, '2024-06-18', 'Bangalore');
INSERT INTO ATM_TRANSACTIONS VALUES (505, 105, 'ATM-005', 'Deposit', 7000.00, '2024-06-20', 'Mumbai');

-- 1. List all active accounts with their current balances
SELECT 
    account_id, 
    customer_id, 
    account_type, 
    balance 
FROM 
    ACCOUNTS 
WHERE 
    status = 'Active';

-- 2. Find customers who have multiple account types
SELECT 
    c.customer_id, 
    c.name, 
    COUNT(DISTINCT a.account_type) AS account_type_count
FROM 
    CUSTOMERS c
JOIN 
    ACCOUNTS a ON c.customer_id = a.customer_id
GROUP BY 
    c.customer_id, c.name
HAVING 
    COUNT(DISTINCT a.account_type) > 1;

-- 3. Calculate total deposits and withdrawals for each account in the last month
SELECT 
    account_id, 
    SUM(CASE WHEN transaction_type = 'Deposit' THEN amount ELSE 0 END) AS total_deposits,
    SUM(CASE WHEN transaction_type = 'Withdrawal' THEN amount ELSE 0 END) AS total_withdrawals
FROM 
    TRANSACTIONS
WHERE 
    transaction_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
GROUP BY 
    account_id;

-- 4. Display customers with overdue loan payments (assuming overdue = balance_remaining > 0)
SELECT 
    c.customer_id, 
    c.name, 
    l.loan_id, 
    lp.payment_date, 
    lp.balance_remaining
FROM 
    CUSTOMERS c
JOIN 
    LOANS l ON c.customer_id = l.customer_id
JOIN 
    LOAN_PAYMENTS lp ON l.loan_id = lp.loan_id
WHERE 
    lp.balance_remaining > 0;

-- 5. Identify potentially fraudulent transactions: multiple high-value transactions within short time (10 minutes)
SELECT 
    t1.account_id, 
    t1.transaction_id, 
    t1.amount, 
    t1.transaction_date, 
    t2.transaction_id AS other_transaction_id, 
    t2.amount AS other_amount, 
    t2.transaction_date AS other_transaction_date
FROM 
    TRANSACTIONS t1
JOIN 
    TRANSACTIONS t2 ON t1.account_id = t2.account_id AND t1.transaction_id <> t2.transaction_id
WHERE 
    t1.amount >= 10000 AND 
    t2.amount >= 10000 AND 
    ABS(TIMESTAMPDIFF(MINUTE, t1.transaction_date, t2.transaction_date)) <= 10
ORDER BY 
    t1.account_id, t1.transaction_date;

-- 6. Generate monthly statement for specific account (replace :accountId with actual account id)
SELECT 
    transaction_id, 
    account_id, 
    transaction_type, 
    amount, 
    transaction_date, 
    description
FROM 
    TRANSACTIONS
WHERE 
    account_id = :accountId AND 
    MONTH(transaction_date) = MONTH(CURDATE()) AND 
    YEAR(transaction_date) = YEAR(CURDATE())
ORDER BY 
    transaction_date;

-- 7. Find customers eligible for loan pre-approval based on balance > 100000 and total deposits > 50000 in last 6 months
SELECT 
    c.customer_id, 
    c.name, 
    a.account_id, 
    a.balance, 
    SUM(t.amount) AS total_recent_deposits
FROM 
    CUSTOMERS c
JOIN 
    ACCOUNTS a ON c.customer_id = a.customer_id
JOIN 
    TRANSACTIONS t ON a.account_id = t.account_id
WHERE 
    a.balance >= 100000 AND 
    t.transaction_type = 'Deposit' AND 
    t.transaction_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
GROUP BY 
    c.customer_id, c.name, a.account_id, a.balance
HAVING 
    total_recent_deposits >= 50000;

-- 8. Calculate bank's total exposure to each loan type
SELECT 
    loan_type, 
    SUM(loan_amount) AS total_exposure
FROM 
    LOANS
GROUP BY 
    loan_type;
    

-- 9. Create a view showing customer profitability (total deposits - total withdrawals + loan interest earned)
CREATE VIEW CUSTOMER_PROFITABILITY AS
SELECT 
    c.customer_id, 
    c.name,
    COALESCE(SUM(CASE WHEN t.transaction_type = 'Deposit' THEN t.amount ELSE 0 END),0) - 
    COALESCE(SUM(CASE WHEN t.transaction_type = 'Withdrawal' THEN t.amount ELSE 0 END),0) + 
    COALESCE(SUM(l.loan_amount * l.interest_rate / 100), 0) AS profitability
FROM 
    CUSTOMERS c
LEFT JOIN 
    ACCOUNTS a ON c.customer_id = a.customer_id
LEFT JOIN 
    TRANSACTIONS t ON a.account_id = t.account_id
LEFT JOIN 
    LOANS l ON c.customer_id = l.customer_id
GROUP BY 
    c.customer_id, c.name;

-- 10. Identify inactive accounts with no transactions in last 90 days
SELECT 
    a.account_id, 
    a.customer_id, 
    a.account_type, 
    a.balance
FROM 
    ACCOUNTS a
LEFT JOIN 
    TRANSACTIONS t ON a.account_id = t.account_id AND t.transaction_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
WHERE 
    t.transaction_id IS NULL;