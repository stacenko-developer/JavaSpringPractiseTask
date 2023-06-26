insert into users (id, login, password)
    values ('bc9802a2-6c94-494d-b88d-a7edc25009b3', 'user', '$2a$04$O2EEJnythbHMRmsMAlY.B.7rv8L2KWTY/zvJbBIcZ5AI8iYrl4BX.');

insert into role (id, name)
    values ('0ebcaf45-f8d2-4e23-8d62-3dd31ef8013a', 'user');

insert into user_role (role_id, user_id)
    values ('0ebcaf45-f8d2-4e23-8d62-3dd31ef8013a', 'bc9802a2-6c94-494d-b88d-a7edc25009b3');