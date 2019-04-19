use mydatabase;

insert into type(id,name) values (1,'type1');
insert into type(id,name) values (2,'type2');

insert into category(id,name,type_id) values (1,'cat1',1);
insert into category(id,name,type_id) values (2,'cat2',1);
insert into category(id,name,type_id) values (3,'cat3',2);
insert into category(id,name,type_id) values (4,'cat4',2);

insert into item(id,name) values (1,'item1');
insert into item(id,name) values (2,'item2');
insert into item(id,name) values (3,'item3');
insert into item(id,name) values (4,'item4');
insert into item(id,name) values (5,'item5');
insert into item(id,name) values (6,'item6');

insert into itemcategory(category_id,item_id) values (1,1);
insert into itemcategory(category_id,item_id) values (2,2);
insert into itemcategory(category_id,item_id) values (3,3);
insert into itemcategory(category_id,item_id) values (4,4);
insert into itemcategory(category_id,item_id) values (1,5);
insert into itemcategory(category_id,item_id) values (1,6);