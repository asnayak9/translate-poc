DROP TABLE IF EXISTS tax_account;
DROP TABLE IF EXISTS tax_types;
DROP TABLE IF EXISTS taxbook;

CREATE TABLE taxbook (
  taxbook_id INT AUTO_INCREMENT  PRIMARY KEY,
  s_no INT NOT NULL,
  demand_no INT NOT NULL,
  door_no INT NOT NULL,
  house_type VARCHAR(250) NOT NULL,
  name VARCHAR(250) DEFAULT NULL,
  fh_name VARCHAR(250) DEFAULT NULL,
  height INT NOT NULL,
  length INT NOT NULL,
  total INT NOT NULL
);
insert into taxbook(s_no, demand_no, door_no, house_type, name, fh_name, height, length, total)
	values (1, 1, 1, 'Concrete', 'RANI', 'MARUTHAIVEERAN', 27, 22, 594),
		(2, 2, 2, 'IAY', 'SAMPOORANAM', 'SENTHIL', 22, 21, 462);

DROP TABLE IF EXISTS tax_types;
create table tax_types(
	tax_type_id INT PRIMARY KEY,
	type_name VARCHAR(250) NOT NULL
);
insert into tax_types(tax_type_id, type_name) values(1,'REQUIRED'), (2,'RECEIVED'), (3,'REQUIRED_BALANCE');

DROP TABLE IF EXISTS tax_account;
CREATE TABLE tax_account(
	id INT AUTO_INCREMENT PRIMARY KEY,
	taxbook_id INT NOT NULL,
	tax_type_id INT NOT NULL,
	
	house_tax_arrear INT,
	house_tax_current INT,
	
	liberty_tax_arrear INT,
	liberty_tax_current INT,
	
	total_tax_arrear INT,
	total_tax_current INT,
	
	foreign key (taxbook_id) references taxbook(taxbook_id),
	foreign key (tax_type_id) references tax_types(tax_type_id)
);
insert into tax_account(taxbook_id, tax_type_id, house_tax_current, liberty_tax_current, total_tax_current)
	values (
		(select taxbook_id from taxbook where s_no=1 and demand_no=1 and door_no=1),
		(select tax_type_id from tax_types where type_name='REQUIRED'),
		330, 30, 330
	),
	(
		(select taxbook_id from taxbook where s_no=1 and demand_no=1 and door_no=1),
		(select tax_type_id from tax_types where type_name='RECEIVED'),
		331, 31, 331
	),
	(
		(select taxbook_id from taxbook where s_no=1 and demand_no=1 and door_no=1),
		(select tax_type_id from tax_types where type_name='REQUIRED_BALANCE'),
		332, 32, 332
	);
insert into tax_account(taxbook_id, tax_type_id, house_tax_arrear, house_tax_current, liberty_tax_arrear, liberty_tax_current, total_tax_arrear, total_tax_current)
	values (
		(select taxbook_id from taxbook where s_no=2 and demand_no=2 and door_no=2),
		(select tax_type_id from tax_types where type_name='REQUIRED'),
		1,330, 1,30, 1,330
	);	
