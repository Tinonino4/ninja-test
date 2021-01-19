DROP TABLE IF EXISTS address;

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  street VARCHAR(100) NOT NULL,
  state VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  country VARCHAR(50) NOT NULL,
  zip VARCHAR(5) NOT NULL
);

INSERT INTO address (street, state, city, country, zip) VALUES
  ('Calle de la Espiga', '', 'Madrid', 'España', '28047'),
  ('Calle del Trigo', '', 'Madrid', 'España', '28049');

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  `id` INT AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
  `birthdate` DATE DEFAULT NULL,
  address INT,
  foreign key (ADDRESS) references ADDRESS(ID)
);

INSERT INTO user (name, email, birthdate, address) VALUES
  ('Juan', 'Juan@test.com', '1993-07-12', 1),
  ('Pepe', 'Pepe@test.com', '1988-06-03', 2);