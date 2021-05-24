

create table package(id int not null primary key auto_increment,
                     sendDate datetime not null,
                     preArriveDate datetime not null,
                     arriveDate datetime not null,
                     state int not null,
                     ordersId int not null,
                     senderId int not null,
                     receiverId int not null,
                     foreign key(ordersId) references ordersDetail(id),
                     foreign key(senderId) references user(id),
                     foreign key(receiverId) references user(id)
                    );
drop table package;
insert into package(sendDate, preArriveDate, arriveDate, state, ordersDetailId, senderId, receiverId) values('2021-01-01','2021-01-03','2021-01-03',3,1,1,3);
insert into package(sendDate, preArriveDate, arriveDate, state, ordersDetailId, senderId, receiverId) values('2021-01-01','2021-01-03','2021-01-03',3,2,1,3);
insert into package(sendDate, preArriveDate, arriveDate, state, ordersDetailId, senderId, receiverId) values('2021-01-01','2021-01-04','2021-01-04',3,3,1,2);
insert into package(sendDate, preArriveDate, arriveDate, state, ordersDetailId, senderId, receiverId) values('2021-01-02','2021-01-04','2021-01-05',4,5,2,1);
insert into package(sendDate, preArriveDate, arriveDate, state, ordersDetailId, senderId, receiverId) values('2021-01-02','2021-01-04','2021-01-05',3,4,3,1);