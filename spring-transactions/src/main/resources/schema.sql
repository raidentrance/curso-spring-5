drop table if exists post;
drop table if exists author;
create table if not exists post(id int primary key, name varchar (200) not null, content clob, author varchar(100));
create table if not exists author(id int primary key, name varchar (200) not null, twitter varchar(100));