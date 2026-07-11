create database bankmanagementsystem;
show databases;
use bankmanagementsystem;

CREATE TABLE signup (
    formno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    fname VARCHAR(100),
    dob VARCHAR(30),
    gender VARCHAR(20),
    email VARCHAR(100),
    mstat VARCHAR(20),
    address VARCHAR(200),
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(10)
);
show tables;
desc signup;

SELECT DATABASE();
SHOW TABLES;

select * from signup;

USE bankmanagementsystem;

CREATE TABLE signuptwo (
    formno VARCHAR(20),
    religion VARCHAR(30),
    category VARCHAR(30),
    income VARCHAR(50),
    education VARCHAR(50),
    occupation VARCHAR(50),
    pan VARCHAR(20),
    adhar VARCHAR(20),
    seniorcitizen VARCHAR(10),
    existingaccount VARCHAR(10)
);

show tables;
SELECT * FROM signuptwo;

CREATE TABLE signupthree(
    formno VARCHAR(20),
    accountType VARCHAR(50),
    cardnumber VARCHAR(20),
    pin VARCHAR(10),
    facility VARCHAR(200)
);
select * from signupthree;
create table login(formno varchar(20), cardnumber varchar(20) , pin varchar(20));
INSERT INTO login
VALUES('1001','5040931234567890','1234');
show tables;
select * from login;

CREATE TABLE bank (
    pin VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);
select * from bank;

