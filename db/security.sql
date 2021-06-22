CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null references authorities (id)
);

insert into authorities (authority)
values ('ROLE_USER');
insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
-- root password = 123
values ('root', true, '$2a$10$3k8bnsScosCtG591rmSubeZwn3HOZwmN9O2nrYJFOD6Vh5Mo2I/AG',
        (select id from authorities where authority = 'ROLE_ADMIN'));