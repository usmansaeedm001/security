drop table if exists api_user;
drop table if exists authority;

create table api_user (
    id bigserial primary key ,
    username varchar(255),
    password varchar(255),
    algorithm varchar(255)
);

create table if not exists authority (
     id bigserial primary key ,
    name varchar(255),
    user_id bigserial references api_user,
    algorithm varchar(255)
)