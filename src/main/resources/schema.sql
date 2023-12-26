create table persons
(
    name           varchar(50) not null,
    surname        varchar(50) not null,
    age            int not null,
    phone_number   varchar(20) not null,
    city_of_living varchar(60) not null default 'Moscow',
    constraint PK_Person primary key (name, surname, age)
);