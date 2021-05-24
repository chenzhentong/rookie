create table city
(
    id int not null primary key auto_increment,
    name varchar(32) not null,
    provinceId int not null,
    foreign key(provinceId) references province(id)
);

insert into city(name,provinceId) values('济南',1);
insert into city(name,provinceId) values('青岛',1);
insert into city(name,provinceId) values('烟台',1);
insert into city(name,provinceId) values('潍坊',1);
insert into city(name,provinceId) values('淄博',1);
insert into city(name,provinceId) values('济宁',1);
insert into city(name,provinceId) values('泰安',1);


insert into city(name,provinceId) values('南京',7);
insert into city(name,provinceId) values('苏州',7);
insert into city(name,provinceId) values('常州',7);
insert into city(name,provinceId) values('无锡',7);
insert into city(name,provinceId) values('南通',7);
insert into city(name,provinceId) values('宿迁',7);
insert into city(name,provinceId) values('泰州',7);

insert into city(name,provinceId) values('杭州',6);
insert into city(name,provinceId) values('宁波',6);
insert into city(name,provinceId) values('嘉兴',6);

insert into city(name,provinceId) values('福州',5);

insert into city(name,provinceId) values('石家庄',9);