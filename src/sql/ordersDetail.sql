create table ordersDetail
(
    id int not null primary key auto_increment,
    num int not null,goodsId int,
    foreign key(goodsId) references goods(id)
);

insert into ordersDetail(num,goodsId) value(2,1);
insert into ordersDetail(num,goodsId) value(1,2);
insert into ordersDetail(num,goodsId) value(3,1);
insert into ordersDetail(num,goodsId) value(4,3);
insert into ordersDetail(num,goodsId) value(1,4);
insert into ordersDetail(num,goodsId) value(5,2);
insert into ordersDetail(num,goodsId) value(8,3);