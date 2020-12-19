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

create table tax_types(
	tax_type_id INT PRIMARY KEY,
	type_name VARCHAR(250) NOT NULL
);

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

