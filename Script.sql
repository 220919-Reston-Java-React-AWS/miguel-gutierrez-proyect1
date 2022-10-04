-- PRIMARY KEY, FOREGN KEY, DEFAULT, UNIQUE, NOT NULL, CHECK

drop table if exists reimbursements;
drop table if exists users;
drop table if exists roles;
drop table if exists student;


create table roles(
role_id INTEGER primary key,
rolename VARCHAR(30) not null -- employee and manager
);


create table users(
id SERIAL primary key,--SERIAL is an auto-incrementing version of INTEGER
username VARCHAR (30) not null unique,
password VARCHAR (30) not null,
first_name VARCHAR(200) not null,
last_name VARCHAR(200) not null,
role_id INTEGER not null,
constraint fk_role_type foreign KEY(role_id) references roles(role_id)
);


create table reimbursements(
id SERIAL primary key,
description VARCHAR(30)not null,
amount numeric(10,2) not null check (amount >=0),
pendingorcompleted boolean not null,
aprovedordenied boolean,
employee_id integer not null references users(id),
manager_id integer  references roles(role_id)
);

insert into roles (role_id, rolename)
values 
(1, 'Employee'),
(2, 'Manager');

insert into users (username, password, first_name, last_name, role_id)
values 
('ctcmiguel', 'P@ssW0rd', 'Miguel', 'Gutierrez', 2), -- Manager
('GleGar', 'password123', 'Glen', 'Gardfield', 1),
('JesCol', 'text123', 'Jessica', 'Colter', 1);

insert into reimbursements (id, description, amount, pendingorcompleted, aprovedordenied, employee_id, manager_id)
values
(1, 'Travel', 100, true, false, 2, 1);



select * from roles;
select * from users; 
select * from reimbursements;



update reimbursements 
set 
aprovedordenied = true,
manager_id = 1
where id = 1;

