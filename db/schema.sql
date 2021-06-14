create table post
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

insert into post (name) values ('О чем этот форум?');
insert into post (name) values ('Правила форума.');