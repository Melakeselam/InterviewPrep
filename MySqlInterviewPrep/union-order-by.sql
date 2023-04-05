use practice;

create table if not exists OCCUPATIONS(
	Name varchar(20) unique,
    Occupation varchar(20)
);

insert into practice.OCCUPATIONS values 
('Samantha','Doctor'),('Julia','Actor'),('Maria','Actor'),('Meera','Singer'),('Ashely','Professor'),('Ketty','Professor'),('Christeen','Professor'),('Jane','Actor'),('Jenny','Doctor'),('Priya','Singer');

select * from practice.OCCUPATIONS;

select output from (
(select 1 as order_group, cast(Name as char) as inner_order, concat(Name,"(", substr(Occupation,1,1),")") as output
    from practice.OCCUPATIONS
 )
union
(select 2 , cast(count(Occupation) as char), concat("There are a total of ",count(Occupation)," ",lower(Occupation),"s.")
        from practice.OCCUPATIONS
        group by Occupation
)
order by order_group asc, inner_order asc
) a;
