create table orders
(
    id int not null primary key auto_increment,
    num int  default 1,
    userId int not null,
    foreign key(userId) references user(id)

);