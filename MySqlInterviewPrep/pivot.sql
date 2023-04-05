use practice;

create table if not exists OCCUPATIONS(
	Name varchar(20) unique,
    Occupation varchar(20)
);

insert into practice.OCCUPATIONS values 
('Samantha','Doctor'),('Julia','Actor'),('Maria','Actor'),('Meera','Singer'),('Ashely','Professor'),('Ketty','Professor'),('Christeen','Professor'),('Jane','Actor'),('Jenny','Doctor'),('Priya','Singer');

select * from practice.OCCUPATIONS;

select min(if(occupation='Doctor', name, null)) Doc,
max(if(occupation='Professor', name, null)) Prof,
max(if(occupation='Singer', name, null)) Sing,
min(if(occupation='Actor', name, null)) Actor
from (select *, rank() over(partition by occupation order by name asc) rnk
from occupations) t
group by rnk;