CREATE DATABASE PZ5;
USE PZ5;

CREATE TABLE hospital (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          base_year INT
);

CREATE TABLE doctor (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        hospital_id INT,
                        name VARCHAR(255),
                        specialty VARCHAR(255),
                        FOREIGN KEY (hospital_id) REFERENCES hospital(id)
);