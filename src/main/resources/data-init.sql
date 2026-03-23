INSERT INTO role(name) values
    ('ADMIN'),
    ('USER'),
    ('SUPPLIER');

INSERT INTO app_user( email, password, pseudo, role_id) values
    ('a@gmail.com',123,'Arm', 1),
    ('b@gmail.com',123,'Brm', 3),
    ('c@gmail.com',123,'Crm', 2);

INSERT INTO component (serial_number, name, description, loaner_id) VALUES
    ('E123456789', 'Ecran de salle', 'Eraflure sur le côté droit', null),
    ('E987654321', 'Ecran de salle', 'Bon état',2);

INSERT INTO tag (name) VALUES
   ('détérioré'),
   ('réservé');

INSERT INTO tag_component (component_id, tag_id) VALUES
    (1,1),
    (1,2),
    (2,2);

