INSERT INTO role(name) values
    ('ADMIN'),
    ('USER'),
    ('SUPPLIER');

INSERT INTO app_user( email, password, pseudo, role_id) values
    ('a@gmail.com',123,'Arm', 1),
    ('b@gmail.com',123,'Brm', 3),
    ('c@gmail.com',123,'Crm', 2);