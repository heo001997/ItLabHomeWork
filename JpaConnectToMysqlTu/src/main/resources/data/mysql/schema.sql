use mydatabase;

DROP TABLE IF EXISTS `Type`;
CREATE TABLE `Type` (
                          `id` int(5),
                          `name` varchar(30),
                          PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
                      `id` int(5),
                      `name` varchar(30),
                      `type_Id` int(5),
                      PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `Item`;
CREATE TABLE `Item` (
                      `id` int(5),
                      `name` varchar(30),
                      PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `ItemCategory`;
CREATE TABLE `ItemCategory` (
                      `item_Id` int(5),
                      `category_Id` int(5),
                      PRIMARY KEY(`item_Id`)
);
