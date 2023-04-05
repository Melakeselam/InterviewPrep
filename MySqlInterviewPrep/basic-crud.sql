drop database if exists practice;

show tables;

use practice;

delimiter //
create procedure create_tables()
begin
	create database if not exists practice;

	create table if not exists practice.person_profiles(
		id int unsigned auto_increment,
		father int unsigned,
		mother int unsigned,
		weight decimal(4,2) unsigned,
		height decimal(3,2) unsigned,
		ethnicity varchar(25),
		hair_color varchar(25),
		eye_color varchar(20),
		-- primary key PK_person_profile(id)
		constraint PK_person_profile primary key (id)
	);
    
	create table if not exists practice.person_addresses(
		id int unsigned auto_increment,
		line1 varchar(50) not null,
		line2 varchar(25),
		city_town varchar(25) not null,
		country varchar(25),    
		postal_zip_code varchar(25) not null,
		-- primary key (id)
		constraint PK_person_address primary key (id)
	);
    
    create table if not exists practice.persons(
		id int unsigned  primary key auto_increment,
		first_name varchar(25) not null,
		last_name varchar(25) not null,
		dob date,
		dod date,
		profile_id int unsigned,
		address_id int unsigned,
		contact_phone varchar(20),
		email varchar(50),
		-- foreign key (profile_id) references person_profiles(id),
		-- foreign key (address_id) references person_addresses(id)
		constraint FK_person_profile foreign key (profile_id) references person_profiles(id),
		constraint FK_person_address foreign key (address_id) references person_addresses(id)
	);
    
    alter table practice.person_profiles
	add constraint FK_father 
	foreign key (father) 
	references practice.persons(id);

	alter table practice.person_profiles
	add constraint FK_mother
	foreign key (mother)
	references practice.persons(id);

	create index IDX_person
	on practice.persons(last_name, first_name);

	alter table practice.persons
	add constraint UNX_names
	unique (first_name, last_name);
end //
delimiter ;

delimiter //
create procedure delete_table(in TableName varchar(25))
begin
	if TableName = 'person_profiles' then
		alter table practice.persons
			drop constraint FK_person_profile;
		drop table if exists person_profiles;
	elseif TableName = 'person_addresses' then
		alter table practice.persons
			drop constraint FK_person_address;
		drop table if exists person_addresses;
	elseif TableName = 'persons' then
		alter table practice.persons
			drop constraint FK_person_profile;
		alter table practice.persons
			drop constraint FK_person_address;
		alter table practice.persons
			drop index IDX_person;
		alter table practice.person_profiles
			drop constraint FK_father;
		alter table practice.person_profiles
			drop constraint FK_mother;
		drop table if exists practice.persons;
	end if;
end //
delimiter ;
    
call create_tables();
call delete_table('person_profiles');
call delete_table('person_addresses');
call delete_table('persons');

select * from person_profiles;

show keys FROM person_profiles where Key_name = 'PRIMARY';



select * from person_addresses;

select * from persons;



insert into persons (first_name,last_name,dob,contact_phone,email)
values 
('Melakeselam', 'Mengistu', '1979-08-04', '+1-848-467-1214','melakeselammoges@gmail.com'),
('Martha', 'Mengistu', '1982-07-08', '+251-920-123-4567','marthamoges@gmail.com'),
('Moges', 'Dekussie', '1979-08-04', '848-467-1214',null),
('Zewditu', 'Abebe', '1979-08-04', '848-467-1214',null);

update persons
set dob = '1953-02-15'
where id = 4;


