create
database imagine_store;

create table Customers
(
    customer_id SERIAL not null primary key,
    first_name  varchar(25) not null,
    last_name   varchar(30) not null
);

insert into Customers (customer_id, first_name, last_name)
values (1, 'Ivan', 'Ivanov'),
       (2, 'Petr', 'Petrov'),
       (3, 'Andrei', 'Fedorov'),
       (4, 'Andrei', 'Andreev'),
       (5, 'Julia', 'Petrova'),
       (6, 'Rita', 'Ivanova'),
       (7, 'Anna', 'Drozd'),
       (8, 'Vita', 'Fedorova'),
       (9, 'Yanna', 'Andreeva'),
       (10, 'Anna', 'Kot');

select *
from Customers;

create table "Orders"
(
    order_id SERIAL not null primary key,
    customer_id  serial not null Unique,
    "date_order" date   not null,
    foreign key (customer_id) references Customers (customer_id)
);

insert into "Orders" (order_id, customer_id, "date_order")
values (123, 1, '2021-09-15'),
       (124, 2, '2021-09-16'),
       (125, 3, '2021-09-17'),
       (126, 4, '2021-09-21'),
       (127, 6, '2021-09-25'),
       (128, 5, '2021-09-29'),
       (129, 9, '2021-10-01'),
       (130, 7, '2021-10-15'),
       (131, 8, '2021-10-16'),
       (132, 10, '2021-10-18');

select *
from "Orders";

create table Order_product
(
    order_id   SERIAL  not null primary key,
    product_id VARCHAR not null UNIQUE,
    quantity   int not null,
    FOREIGN KEY (order_id) REFERENCES "Orders" (order_id)
);

insert into Order_product (order_id, product_id, quantity)
values (123, '200830', 1),
       (124, '200839', 2),
       (125, '56384', 4),
       (126, '57878', 4),
       (127, '54759', 1),
       (128, '47854', 2),
       (129, '46125', 1),
       (130, '24578', 1),
       (131, '21121', 5),
       (132, '12345', 1);

select *
from Order_product;

create table Products
(
    product_id   VARCHAR not null primary key,
    product_name VARCHAR,
    product_size VARCHAR
);

insert into Products (product_id, product_name, product_size)
values ('200839', 'Frame Pool', '244*76'),
       ('56384', 'Frame Pool', '457*122'),
       ('57878', 'Frame Pool', '460*120'),
       ('54759', 'Inflatable mattress', '76*191*25'),
       ('47854', 'Inflatable mattress', '152*203*25'),
       ('46125', 'Inflatable mattress', '157*88*18'),
       ('24578', 'Inflatable mattress', '157*88*10'),
       ('21121', 'Inflatable bed', '152*200*15'),
       ('12345', 'Inflatable bed', '140*190*15'),
       ('12346', 'Inflatable bed', '120*200*25');

select *
from Products;

select *
from Customers
where first_name like ('An_%');

select product_name
from Products
where not (product_name = 'Inflatable mattress' or product_name = 'Frame Pool');

select *
from Customers
where first_name in ('Andrei')
  and customer_id between 1 and 5;

select *
from Products
where (product_name = 'Inflatable bed' or product_name = 'Inflatable mattress');

select *
from Order_product
where quantity = 1
  and order_id between 129 and 132;

update Customers
set first_name='Polina'
where first_name like 'Ri_%';

select *
from Customers;

delete
from Order_product
where order_id between 125 and 127;

select *
from Order_product;