INSERT INTO dog_rescue.location (business_name, city, phone, state, street_address, zip) 
	VALUES('PetRescue', 'New York', '555-222-4444', 'New York', '1234 W. 9876 N.', '88889');
	
INSERT INTO dog_rescue.dog (age, location_id, color, name)
	VALUES(2, 1, 'Black and Brown', 'Grace');

INSERT INTO dog_rescue.dog (age, location_id, color, name)
	VALUES(0, 1, 'White', 'Alice');
	
INSERT INTO dog_rescue.breed (breed_id, name)
	VALUES(1, 'Pug');
	
INSERT INTO dog_rescue.dog_breed (breed_id, dog_id)
	VALUES(1, 1);

INSERT INTO dog_rescue.location_dogs (dogs_dog_id, location_location_id)
	VALUES(1, 1);