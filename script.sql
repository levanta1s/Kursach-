CREATE TABLE Clients (
                         ClientID int AUTO_INCREMENT,
                         ClientLogin varchar(255),
                         ClientPassword varchar(255),
                         ClientFullName varchar(255),
                         ClientPassport varchar(255),
                         ClientPhoneNumber varchar(255),
                         ClientAdress varchar(255),
                        PRIMARY KEY (ClientID)
);
CREATE TABLE employees (
                        EmployeeID int AUTO_INCREMENT,
                        EmployeeLogin varchar(255),
                        EmployeePassword varchar(255),
                        EmployeeFullName varchar(255),
                        ContractNumber int,
                        DateOfRecruitment varchar(255),
                        Position int,
                        PRIMARY KEY (EmployeeID)
);
CREATE TABLE Contacts (
                           ContractNumber int AUTO_INCREMENT,
                           DateOfSigning varchar(255),
                           ClientID int,
                           EmployeeID int,
                          PRIMARY KEY (ContractNumber),
                          FOREIGN KEY (ClientID) REFERENCES Clients(ClientID),
                          FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);
CREATE TABLE DepositTypes (
                              TypeID int AUTO_INCREMENT,
                              TypeName varchar(255),
                              TypeMinMoney int,
                              TypeMaxMoney int,
                              TypePeriod int,
                              TypeCapitalization int,
                              TypeInterestRate int,
                              PRIMARY KEY (TypeID)
);
CREATE TABLE Deposits (
                         DepositNumber int AUTO_INCREMENT,
                         InitialMoney int,
                         DateOfOpening varchar(255),
                         PlannedFinalMoney int,
                         TypeID int,
                         ContractNumber int,
                         ClientID int,
                         PRIMARY KEY (DepositNumber),
                         FOREIGN KEY (TypeID) REFERENCES DepositTypes(TypeID),
                         FOREIGN KEY (ClientID) REFERENCES Clients(ClientID)
);






admin login -- Admin
admin password -- Admin
