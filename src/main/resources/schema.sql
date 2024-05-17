DROP SCHEMA IF EXISTS dog_rescue;
CREATE SCHEMA dog_rescue;
USE dog_rescue;

CREATE TABLE breed (
  breed_id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (breed_id)
);

CREATE TABLE location (
  location_id bigint NOT NULL AUTO_INCREMENT,
  business_name varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  state varchar(255) DEFAULT NULL,
  street_address varchar(255) DEFAULT NULL,
  zip varchar(255) DEFAULT NULL,
  PRIMARY KEY (location_id)
);

CREATE TABLE dog (
  age int NOT NULL,
  dog_id bigint NOT NULL AUTO_INCREMENT,
  location_id bigint NOT NULL,
  color varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (dog_id),
  FOREIGN KEY (location_id) REFERENCES location (location_id)
);

CREATE TABLE dog_breed (
  breed_id bigint NOT NULL,
  dog_id bigint NOT NULL,
  PRIMARY KEY (breed_id, dog_id),
  FOREIGN KEY (breed_id) REFERENCES breed (breed_id),
  FOREIGN KEY (dog_id) REFERENCES dog (dog_id)
);

CREATE TABLE location_dogs (
  dogs_dog_id bigint NOT NULL,
  location_location_id bigint NOT NULL,
  PRIMARY KEY (dogs_dog_id, location_location_id),
  FOREIGN KEY (dogs_dog_id) REFERENCES dog (dog_id),
  FOREIGN KEY (location_location_id) REFERENCES location (location_id)
);