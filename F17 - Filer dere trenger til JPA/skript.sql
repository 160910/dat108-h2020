DROP SCHEMA IF EXISTS f17 CASCADE;
CREATE SCHEMA f17;
SET search_path = f17;

CREATE TABLE klasse 
(
   kode     CHARACTER VARYING (10),
   program  CHARACTER VARYING (40),
   PRIMARY KEY (kode)
);

CREATE TABLE student 
(
   id           CHARACTER (7),
   navn         CHARACTER VARYING (40),
   klasse_kode  CHARACTER VARYING (10),
   PRIMARY KEY (id),
   FOREIGN KEY (klasse_kode) REFERENCES klasse (kode)
);

INSERT INTO klasse VALUES 
	('19hData', 'Dataingeniør'),
	('19hInf', 'Informasjonsteknologi');
	
INSERT INTO student VALUES
	('123456', 'Arne', '19hData'),
	('123457', 'Brit', '19hData'),
	('123458', 'Carl', '19hInf'),
	('123459', 'Dina', '19hInf'),
	('123460', 'Erik', '19hInf');
	






