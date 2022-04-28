DROP DATABASE IF EXISTS `BankingProject`;

-- create a database
CREATE DATABASE IF NOT EXISTS `BankingProject`;

USE `bankingproject`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customerId` int(11) NOT NULL,
    name VARCHAR(255) ,
    address VARCHAR(255),
   PRIMARY KEY (`customerId`)
) ;


CREATE table banks(
    Bankcode INTEGER NOT NULL,
    BankName VARCHAR(255) NOT NULL,
    MainOfficeAddress VARCHAR(255),
    Primary Key (Bankcode)
);


CREATE TABLE BRANCHES (
    BranchCode INTEGER NOT NULL,
    Address VARCHAR(255),
    Manager  VARCHAR(255) ,
    HeadOffice VARCHAR(255) ,
    Bankcode INTEGER NOT NULL,
    PRIMARY KEY (BranchCode),
    FOREIGN KEY (Bankcode) REFERENCES Banks(Bankcode)

);

CREATE TABLE EMPLOYEE (
    EmployeeID INTEGER NOT NULL,
    Name VARCHAR(255),
    BranchCode INTEGER ,
    PRIMARY KEY (EmployeeID),
    FOREIGN KEY (BranchCode) REFERENCES BRANCHES(BranchCode)
);



CREATE TABLE Admins (
    AdminID INTEGER NOT NULL,
    NAME VARCHAR(255),
    Bankcode INTEGER,
    PRIMARY KEY (AdminID),
    FOREIGN KEY (Bankcode) REFERENCES BANKS(BANKCODE)
);

CREATE TABLE BANKACCOUNTS (
    AccNo BIGINT NOT NULL,
     TYPE ENUM('SAVINGS','CURRENT'),
    BranchCode INTEGER,
    customerId int NOT NULL,
    PRIMARY KEY (AccNo),
    FOREIGN KEY (BranchCode) REFERENCES BRANCHES(BranchCode),
    FOREIGN KEY (customerId) REFERENCES customers(customerId)

);

CREATE TABLE IF NOT EXISTS TRANSACTIONS(
    TRANSACTIONNO INT NOT NULL,
    AccNo BIGINT NOT NULL,
    AMOUNT BIGINT ,
    TYPE ENUM('DEBIT','CREDIT'),
    TIMESTAMP DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (AccNo) REFERENCES BANKACCOUNTS(AccNo),
    PRIMARY KEY (TRANSACTIONNO)
);

CREATE TABLE reversalRequest(
    requestid int NOT NULL,
    transactionNo int NOT NULL,
    reqDate datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (requestid),
    FOREIGN KEY (transactionNo) REFERENCES TRANSACTIONS(transactionNo)
);

INSERT INTO Banks VALUES('1234','SBI','Nizampet,Hyderabad,Telangana,India,500090');
INSERT INTO Banks VALUES('4356','ICICI','Nizampet,Hyderabad,Telangana,India,500090');

insert into customers VALUES('12','amruth','Nizampet,Hyderabad,Telangana,India,500090');

insert into customers VALUES('13','Aasrith','Miyapur,Hyderabad,Telangana,India,500090');
insert into branches VALUES('250','Nizampet,Hyderabad,Telangana,India,500090','patil','Delhi','1234');

insert into branches VALUES('350','kukatpally,Hyderabad,Telangana,India,500090','Ramesh','Mumbai','4356');
insert into employee VALUES('430','sridevi','250');
insert into employee VALUES('530','Madhuri','350');

insert into bankaccounts values('89023383','savings','250','12');
insert into bankaccounts values('95098764','current','350','13');

INSERT INTO TRANSACTIONS VALUES('2450','89023383','1000','debit',default);
INSERT INTO TRANSACTIONS VALUES('3560','89023383','1000','credit',default);

INSERT INTO admins VALUES('101','Sruthi','1234');

Insert into reversalRequest VALUES('23','2450',default);

Insert into reversalRequest VALUES('33','3560',default);





