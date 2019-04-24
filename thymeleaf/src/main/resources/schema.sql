use dictdb;
drop table if exists dictionary;
create table dictionary(
                         id int Not null auto_increment,
                         word varchar(200),
                         mean varchar(8000),
                         type varchar(200),
                         primary key (id)
);