
create table user(id int not null primary key auto_increment,name varchar(32) not null,account varchar(16) not null,
password varchar(16) not null,type int, IDCard varchar(18), phone varchar(11)
);
insert into user(name,account,password,type,IDCard,phone) value('陈振同','1765770246','123456',0,'370982199901280619','17861128823');
insert into user(name,account,password,type,IDCard,phone) value('卖家1','seller1','123456',1,'370982199111111111','17861128811');
insert into user(name,account,password,type,IDCard,phone) value('卖家2','seller2','123456',1,'370982199222222222','17861128822');
insert into user(name,account,password,type,IDCard,phone) value('卖家3','seller3','123456',1,'370982199333333333','17861128833');