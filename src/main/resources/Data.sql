insert into menu (menuid, menu_name, price) values (2, 'test1', 5000);

insert into bill (OrderId) values (3);

insert into stock (stockid, stock_name, stock_rest) values (4, 'test1', 4);

create table kiosk.bill
(
    orderid bigint auto_increment
        primary key
);

create table kiosk.menu
(
    menuid    bigint auto_increment
        primary key,
    menu_name varchar(255) not null,
    price     int          not null
);

create table kiosk.stock
(
    stockid    bigint auto_increment
        primary key,
    stock_name varchar(255) not null,
    stock_rest int          not null
);

