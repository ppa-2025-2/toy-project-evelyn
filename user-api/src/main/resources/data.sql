DELETE FROM workstations;
DELETE FROM islands;
DELETE FROM users;
DELETE FROM roles;

INSERT INTO roles (name) VALUES
('ROLE_USER'),
('ROLE_GUEST'),
('ROLE_VIEWER')
;