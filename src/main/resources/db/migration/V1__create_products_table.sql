create table products
(
    id    varchar(36) not null primary key,
    name  varchar(255),
    price bigint
) engine = innodb;