DROP SCHEMA IF EXISTS crm;

CREATE SCHEMA crm;
USE crm;

CREATE TABLE sales_rep
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE items
(
    id           VARCHAR(255) NOT NULL,
    name         VARCHAR(255),
    phone_number VARCHAR(255),
    email        VARCHAR(255),
    company_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE leads
(
    id           VARCHAR(255) NOT NULL,
    sales_rep_id VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (id)
        REFERENCES items (id),
    FOREIGN KEY (sales_rep_id)
        REFERENCES sales_rep (id)
);

CREATE TABLE contacts
(
    id         VARCHAR(255) NOT NULL,
    account_id VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (id)
        REFERENCES items (id),
    FOREIGN KEY (account_id)
        REFERENCES accounts (id)
);


CREATE TABLE accounts
(
    id             VARCHAR(255) NOT NULL,
    company_name   VARCHAR(255),
    industry       VARCHAR(255),
    employee_count INT,
    city           VARCHAR(255),
    country        VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE opportunities
(
    id                VARCHAR(255) NOT NULL,
    quantity          INT,
    decision_maker_id VARCHAR(255),
    status            VARCHAR(255),
    product           VARCHAR(255),
    account_id        VARCHAR(255),
    sales_rep_id      VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (decision_maker)
        REFERENCES contacts (id),
    FOREIGN KEY (account_id)
        REFERENCES accounts (id),
    FOREIGN KEY (sales_rep_id)
        REFERENCES sales_rep (id)
);
    
    
    
    