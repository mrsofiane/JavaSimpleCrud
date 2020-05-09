
DROP DATABASE IF EXISTS jdbc_workshop_db;

CREATE DATABASE jdbc_workshop_db;

USE jdbc_workshop_db;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (30),
    gender BOOLEAN,
    salary REAL
);

INSERT INTO employee (id, name, gender, salary) values (1,"mr sofiane",true,2300);
INSERT INTO employee (id, name, gender, salary) values (2,"mr khalil",true,2500);
INSERT INTO employee (id, name, gender, salary) values (3,"mme fatima",false,2300);
INSERT INTO employee (id, name, gender, salary) values (4,"mme lucy",false,1800);