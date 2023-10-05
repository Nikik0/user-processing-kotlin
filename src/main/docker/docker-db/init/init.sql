create table admin(
    id serial primary key,
    name varchar(30),
    surname varchar(30),
    info varchar(100),
    age bigint,
    role varchar(20)
);
create table enrollee(
    id serial primary key,
    name varchar(30),
    surname varchar(30),
    info varchar(100),
    age bigint,
    role varchar(20),
    is_accepted boolean
);
create table mentor(
    id serial primary key,
    name varchar(30),
    surname varchar(30),
    info varchar(100),
    age bigint,
    role varchar(20)
);
create table professor(
    id serial primary key,
    name varchar(30),
    surname varchar(30),
    info varchar(100),
    age bigint,
    role varchar(20),
    subject varchar(20)
);
create table professor(
    id serial primary key,
    name varchar(30),
    surname varchar(30),
    info varchar(100),
    age bigint,
    role varchar(20),
    course bigint,
    group_id bigint
);
