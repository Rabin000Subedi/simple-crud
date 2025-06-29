-- Add sample departments
INSERT INTO department (name) VALUES ('IT');
INSERT INTO department (name) VALUES ('HR');


-- Add sample users
INSERT INTO user (name, email, department_id) VALUES ('Rabin Subedi', 'rabin@example.com', 1);
INSERT INTO user (name, email, department_id) VALUES ('Hari Bahadur', 'hari@example.com', 1);
INSERT INTO user (name, email, department_id) VALUES ('Ram Singh', 'ram@example.com', 2);