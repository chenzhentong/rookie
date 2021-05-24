create table logistics
(
    id int not null primary key auto_increment,
    message varchar(256) not null,
    sentDate datetime not null,
    packageId int not null,
    foreign key(packageId) references package(id)
)