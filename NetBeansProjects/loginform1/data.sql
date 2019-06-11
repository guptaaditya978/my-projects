create database userlogin;

use userlogin;

CREATE TABLE users (id INT(3) PRIMARY KEY,username VARCHAR(30) NOT NULL,password VARCHAR(30) NOT NULL);

insert into users values(101,"A","1");