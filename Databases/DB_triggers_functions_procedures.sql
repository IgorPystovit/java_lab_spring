create database Dynamic_SQL;
CREATE DATABASE StoredPr_DB;
use StoredPr_DB;
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE StoredPr_DB; 

CREATE TABLE employee(
    id                 INT               AUTO_INCREMENT,
    surname            VARCHAR(30)       NOT NULL,
    name               CHAR(30)          NOT NULL,
    midle_name         VARCHAR(30),
    identity_number    CHAR(10),
    passport           CHAR(10),
    experience         DECIMAL(10, 1),
    birthday           DATE,
    post               VARCHAR(15)       NOT NULL,
    pharmacy_id        INT,
    PRIMARY KEY (id)
)ENGINE=INNODB;

set FOREIGN_KEY_CHECKS = 1;
alter table employee add constraint FK_post foreign key employee(post) references post(post) on update no action on delete no action;
alter table employee add constraint FK_employee_pharmacy foreign key employee(pharmacy_id) references pharmacy(id) on delete no action;

CREATE TABLE medicine(
    id               INT            AUTO_INCREMENT,
    name             VARCHAR(30)    NOT NULL,
    ministry_code    CHAR(10),
    recipe           BIT(1),
    narcotic         BIT(1),
    psychotropic     BIT(1),
    PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE medicine_zone(
    medicine_id    INT    NOT NULL,
    zone_id        INT    NOT NULL,
    PRIMARY KEY (medicine_id, zone_id)
)ENGINE=INNODB;

alter table medicine_zone add constraint FK_medicine_zone_medicine foreign key medicine_zone(medicine_id) references
medicine(id) on delete no action;
alter table medicine_zone add constraint FK_medicine_zone_zone foreign key medicine_zone(zone_id) references 
zone(id) on delete no action;

CREATE TABLE pharmacy(
    id                 INT            AUTO_INCREMENT,
    name               VARCHAR(15)    NOT NULL,
    building_number    VARCHAR(10),
    www                VARCHAR(40),
    work_time          TIME,
    saturday           BIT(1),
    sunday             BIT(1),
    street             VARCHAR(25),
    PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE pharmacy_medicine(
    pharmacy_id    INT    NOT NULL,
    medicine_id    INT    NOT NULL,
    PRIMARY KEY (pharmacy_id, medicine_id)
)ENGINE=INNODB;

alter table pharmacy_medicine add constraint FK_pharmacy_medicine_pharmaacy foreign key pharmacy_medicine(pharmacy_id) references 
pharmacy(id) on delete no action;
alter table pharmacy_medicine add constraint FK_pharmacy_medicine_medicine foreign key pharmacy_medicine(medicine_id) references
medicine(id) on delete no action;

CREATE TABLE post(
    post    VARCHAR(15)    NOT NULL,
    PRIMARY KEY (post)
)ENGINE=INNODB;

CREATE TABLE street(
    street    VARCHAR(25)    NOT NULL,
    PRIMARY KEY (street)
)ENGINE=INNODB;

CREATE TABLE zone(
    id      INT            AUTO_INCREMENT,
    name    VARCHAR(25)    NOT NULL,
    PRIMARY KEY (id)
)ENGINE=INNODB;

use StoredPr_DB;

select * from pharmacy;
insert pharmacy values
(1,'pharmacy4','04','www.somePharmacyBuilding4.com',091500,0,1,'Mazepy st.'),
(2,'pharmacy6','06','www.somePharmacyBuilding6.com',100000,0,0,'Vyhovskoho st.');


#retrieves name and building_number from pharmacy table by employee id
delimiter //
create function getPharmacyBuilding(emlpoyee_id int) returns varchar(15)
begin
declare temp_pharmacy_id int;
declare building_name,building_num varchar(15); 
set temp_pharmacy_id = (select pharmacy_id from employee where id = emlpoyee_id);
set building_name = (select name from pharmacy where id = temp_pharmacy_id);
set building_num = (select building_number from pharmacy where id = temp_pharmacy_id);
return concat(building_name,'#',building_num);
end //
delimiter ;
 
#returns min experience from employee table
delimiter //
create function getMinExperience()
returns decimal(10,1)
begin
return (select min(experience) from employee);
end //
delimiter ;

#dynamically creates tables named by employee
delimiter //
create procedure tableDynamicCreator()
begin
declare done int default 0;
declare nameT,surnameT,midle_nameT varchar(30);
declare employeeName varchar(50);
declare employeeCursor cursor for select surname,name,midle_name from employee;
declare continue handler for not found set done = 1;
open employeeCursor;
myLoop : loop
if done = 1 then 
leave myLoop;
end if;
fetch employeeCursor into nameT,surnameT,midle_nameT;
set @temp_query = concat('call createEmployeeTable(\'',concat(nameT,surnameT,midle_nameT),'\')');
prepare my_query from @temp_query;
execute my_query;
deallocate prepare my_query;
end loop myLoop;
close employeeCursor;
end //
delimiter ;


delimiter //
create procedure createEmployeeTable(in employeeName varchar(50))
begin
declare randomColumn varchar(50);
declare tableData varchar(200) default '';
declare tempRandomNum int;
declare columnsNum int;
set columnsNum = round(rand()*10);
myLoop : while columnsNum > 0 do
case columnsNum
when 9 then set randomColumn = 'id int,';
when 8 then set randomColumn = 'name varchar(20),';
when 7 then set randomColumn = 'age int,';
when 6 then set randomColumn = 'job char,';
when 5 then set randomColumn = 'fortune decimal,';
when 4 then set randomColumn = 'expierence decimal,';
when 3 then set randomColumn = 'homeAddress varchar(50),';
when 2 then set randomColumn = 'phoneNumber varchar(15),';
when 1 then set randomColumn = 'idCard varchar(20)';
else set randomColumn = 'random char';
end case;
set tableData = concat(tableData,randomColumn);
set columnsNum = columnsNum - 1;
end while myLoop;
set @temp_query = concat('create table ',employeeName,'(',tableData,')');
prepare some_query from @temp_query;
execute some_query;
deallocate prepare some_query;
end //
delimiter ;


delimiter //
create procedure medicine_zoneInput(in medicine int,in zone int)
begin
if medicine in(select id from medicine) and zone in (select id from zone) then
begin
	insert medicine_zone values(medicine,zone);
end;
else 
	insert medicine_zone values(0,0);
end if;
end //
delimiter ;

#checks style of ministry_code input into medicine 
delimiter //
create trigger ministryCodeChecker before insert on medicine for each row
begin
if new.ministry_code not rlike '[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]' then
begin
signal sqlstate '45000'
set message_text = "Wrong input style";
end;
end if; 
end //
delimiter ;

#disable user to modify post values
delimiter //
create trigger modificationDisabler before update on post for each row 
begin
signal sqlstate '45000' 
set message_text = "You are disabled to modify post values";
end //
delimiter ;

#disable user to input identity_number where last 2 numbers are zeros
delimiter //
create trigger idChecker before insert on employee for each row
begin
if new.identity_number rlike '0{2}$' then 
begin 
 signal sqlstate '45000'
 set message_text = "identity_number cannot ends with '00'";
end;
end if; 
end //
delimiter ;
