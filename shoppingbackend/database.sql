--Create Table Category : Date -> 01/05/2018
CREATE TABLE category (
    id INT NOT NULL IDENTITY(100,1) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    image_url VARCHAR(60),
    is_active BIT NOT NULL

);


--Create Table user_detail
CREATE TABLE user_detail(
	id INT NOT NULL IDENTITY(3000,1) PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BIT,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15)
);

--Inserting Users into user_detail table

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Shrikant','Pradhan','Admin','true','Shri@0807','shripradhan.94@gmail.com','7769896344');


INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Samir','Tirpude','Supplier','true','Sam@0208','samtirpude94@gmail.com','7798601127');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Saurabh','Raut','Supplier','true','saurabh@2694','sraut94@gmail.com','9637051548');

---------------------------------------------------------------------------------------------------------------
--Create Table product
CREATE TABLE product(
	id INT NOT NULL IDENTITY(1200,1) PRIMARY KEY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(225),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BIT,
	category_id INT FOREIGN KEY REFERENCES category(id),
	supplier_id INT FOREIGN KEY REFERENCES user_detail(id),
	purchases INT DEFAULT 0,
	views INT DEFAULT 0
);

--Inserting Products into product table

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
Values('PROD4587454','OPPO F11 Pro','OPPO','New Smart Phone With full Screen','25950.00',135,'true',101,3001);


INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
Values('PROD8465489','Samsung Galaxy M10','Samsung','Now livestream your favorite HD content with the Widevine L1 Certification.','7990.00',150,'true',101,3001);



CREATE TABLE product_image(
	img_id INT NOT NULL IDENTITY(1300,1) PRIMARY KEY,
	img_name VARCHAR(40),
	id INT FOREIGN KEY REFERENCES product(id),
);

CREATE TABLE cart(
	id INT NOT NULL IDENTITY(1400,1) PRIMARY KEY,
	cart_lines int,
	grand_total float,
	uid INT FOREIGN KEY REFERENCES user_detail(id),
);

CREATE TABLE address(
	id INT NOT NULL IDENTITY(1500,1) PRIMARY KEY,
	address_line_one varchar(255),
	address_line_two varchar(255),
	billing bit,
	city varchar(255),
	country varchar(255),
	postal_code varchar(255),
	shipping bit,
	state varchar(255),
	userId INT FOREIGN KEY REFERENCES user_detail(id),
);



