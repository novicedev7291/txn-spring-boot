create table orders(
    id int primary key auto_increment,
    order_id varchar(50),
    qty int,
    creation_date datetime,
    created_by varchar(50),
    version int
);