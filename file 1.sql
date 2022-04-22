
# create database CNDA;
use CNDA;

show tables;
select * from da_user;
select * from da_group_user;
create table DA_USER (
DA_GROUP_ID int not null primary key auto_increment,
DA_GROUP_NAME varchar(30),
DA_GROUP_DESC varchar(150),
DA_GROUP_STATUS varchar(1),
CREATED_DT datetime,
CREATED_USER varchar(30),
LASTUPDATE_DATE datetime,
LASTUPDATE_USER varchar(30),
RECORD_SOURCE varchar(30),
OBJECT_VERSION_NUMBER int
);

# drop table DA_USER;-- 

create table DA_GROUP_USER (
DA_GROUP_USER_ID int not null auto_increment primary key,
DA_GROUP_ID int not null,
USER_CAP_NUMBER varchar(30),
DA_GROUP_USER_STATUS varchar(1),
CREATED_DT datetime,
CREATED_USER varchar(30),
LASTUPDATE_DATE datetime,
LASTUPDATE_USER varchar(30),
RECORD_SOURCE varchar(30),
OBJECT_VERSION_NUMBER int,
FOREIGN KEY (DA_GROUP_ID) REFERENCES DA_USER(DA_GROUP_ID)
);

describe DA_GROUP_USER;