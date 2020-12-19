insert into taxbook(s_no, demand_no, door_no, house_type, name, fh_name, height, length, total)
	values (1, 1, 1, 'Concrete', 'RANI', 'MARUTHAIVEERAN', 27, 22, 594),
		(2, 2, 2, 'IAY', 'SAMPOORANAM', 'SENTHIL', 22, 21, 462);

insert into tax_types(tax_type_id, type_name) values(1,'REQUIRED'), (2,'RECEIVED'), (3,'REQUIRED_BALANCE');

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
		1,330, 1,30, 1,330);	
