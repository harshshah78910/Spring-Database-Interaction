/*
create table person
(
id integer not null,
name varchar(255),
birth_date timestamp,
primary key(id)
);
*/

insert into person (id, name, birth_date) values (10000, 'Harsh', sysdate());
insert into person (id, name, birth_date) values (10001, 'Sys', sysdate());
