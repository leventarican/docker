create table public.programming_languages (
    id int primary key,
    name varchar(255)
);

insert into public.programming_languages (id, name)
values (1, 'Java'), (2, 'Kotlin'), (3, 'Python');
