create table member(
id bigint(5) not null auto_increment,
name varchar(255),
city varchar(255),
street varchar(255),
zipcode varchar(255),
is_deleted boolean, 
created_at timestamp,  
updated_at timestamp, 
primary key(id));

create table orders (
order_id bigint(5) not null auto_increment,
member_id bigint(5), 
orderdate timestamp, 
status varchar(255), 
is_deleted boolean, 
created_at timestamp,  
updated_at timestamp, 
primary key(order_id));


create table order_item (
order_item_id bigint(5) not null auto_increment, 
order_id bigint(5),
member_id bigint(5), 
orderprice varchar(255), 
count bigint(5), 
is_deleted boolean, 
created_at timestamp,  
updated_at timestamp, 
primary key(order_item_id));

create table item (
item_id bigint(5) not null auto_increment, 
name varchar(255),
price bigint(5), 
stockquantity bigint(5), 
is_deleted boolean, 
created_at timestamp,  
updated_at timestamp,
 primary key(item_id));
 
alter table orders add constraint fk_member_orders foreign key (member_id) references member (id) on delete cascade;
alter table order_item add constraint fk_item_orderItem foreign key (order_item_id) references item (item_id) on delete cascade;
alter table order_item add constraint fk_orders_orderItem foreign key (order_id) references orders (order_id) on delete cascade;
