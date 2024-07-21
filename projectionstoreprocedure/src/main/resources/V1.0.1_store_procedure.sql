DELIMITER //
CREATE OR REPLACE PROCEDURE get_employee(IN lastName varchar(255))
BEGIN
SELECT id, first_name, last_name FROM employee WHERE last_name like 'lastName';
END;
