# Homework 14th SQL & JBDC

## Table employee

![table](https://user-images.githubusercontent.com/20258751/55909026-28c37200-5c05-11e9-9422-bd0ed46c43c0.png)


## Pre Statement getIdByEname()
------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `getIdByEname`
	(IN TEMPNAME VARCHAR(30),
	OUT EID INT)

BEGIN
	
	SELECT ID
    
	FROM EMPLOYEE
    
	WHERE ENAME = TEMPNAME;

END

------------