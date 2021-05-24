create table goods
(
    id int not null primary key auto_increment,
    name varchar(32) not null,
    stock int not null,
    userId int,
    foreign key(userId) references user(id)
);

insert into goods(name,stock,userId) values('goods1',10,2);
insert into goods(name,stock,userId) values('goods2',20,3);
insert into goods(name,stock,userId) values('goods3',5,4);
insert into goods(name,stock,userId) values('goods4',34,2);
insert into goods(name,stock,userId) values('goods5',122,3);
insert into goods(name,stock,userId) values('goods6',1212,3);
insert into goods(name,stock,userId) values('goods7',4,2);
alter table goods add column weight double default 1.0;