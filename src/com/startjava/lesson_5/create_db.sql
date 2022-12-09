-- create database
CREATE DATABASE Jaegers;
-- connect database
\c jaegers;
-- create table
CREATE TABLE Jaegers(
	id 			SERIAL PRIMARY KEY,
	modelName 	TEXT,
	mark		TEXT,
	height		NUMERIC(4,2),
	weight      NUMERIC(4,3),	
	status		TEXT,
	origin		TEXT,
	launch		DATE,
	kaijuKill	INTEGER
);
