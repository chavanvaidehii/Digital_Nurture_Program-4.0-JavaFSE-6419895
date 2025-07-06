-- Create database
CREATE DATABASE IF NOT EXISTS ormlearn;
USE ormlearn;

-- Drop tables if they exist
DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS skill;

-- Create department table
CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(100)
);

-- Create skill table
CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(100)
);

-- Create employee table
CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(100),
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Create employee_skill (Many-to-Many Join Table)
CREATE TABLE employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Insert departments
INSERT INTO department (dp_name) VALUES ('HR'), ('Finance'), ('IT');

-- Insert skills
INSERT INTO skill (sk_name) VALUES ('Java'), ('SQL'), ('Spring Boot'), ('Python');

-- Insert employees
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES 
('Alice', 70000, 1, '1990-05-01', 1),
('Bob', 50000, 0, '1992-08-15', 2),
('Charlie', 80000, 1, '1988-12-20', 3),
('David', 60000, 1, '1991-11-05', 1);

-- Insert employee-skill mapping
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES 
(1, 1), -- Alice - Java
(1, 2), -- Alice - SQL
(2, 1), -- Bob - Java
(3, 3), -- Charlie - Spring Boot
(4, 2), -- David - SQL
(4, 4); -- David - Python