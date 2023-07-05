create table auto (
    id UUID default gen_random_uuid() not null,
    engine_capacity integer not null,
    engine_power integer not null,
    production_year integer not null,
    person_id UUID not null,
    primary key (id)
);

create table person (
    id UUID default gen_random_uuid() not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    patronymic varchar(255) not null,
    primary key (id)
);

create table role (
    id UUID default gen_random_uuid() not null,
    name varchar(255) not null,
    primary key (id)
);

create table user_role (
    role_id UUID not null,
    user_id UUID not null
);

create table users (
    id UUID default gen_random_uuid() not null,
    login varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);

alter table if exists auto add constraint FKpn3qp42y5c2dcsw8j09jv36r foreign key (person_id) references person;
alter table if exists user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role;
alter table if exists user_role add constraint FKj345gk1bovqvfame88rcx7yyx foreign key (user_id) references users;