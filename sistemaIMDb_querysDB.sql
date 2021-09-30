CREATE TABLE `show` (
	id INT AUTO_INCREMENT,
	show_title VARCHAR(200),
	show_network VARCHAR(200),
	PRIMARY KEY (id)
);

CREATE TABLE `user` (
	id INT AUTO_INCREMENT,
	username VARCHAR(200),
	password VARCHAR(20),
	password_confirmation VARCHAR(20),
	`role` VARCHAR(20),
	PRIMARY KEY (id)
);

CREATE TABLE rating (
	id INT AUTO_INCREMENT,
	rating INT(1),
	show_id INT,
	user_id INT,
	PRIMARY KEY (id),
	CONSTRAINT fk_show_id FOREIGN KEY (show_id) REFERENCES `show` (id),
	CONSTRAINT fl_user_id FOREIGN KEY (user_id) REFERENCES `user` (id)
);

INSERT INTO shows VALUES (NULL, "Los Simpson", "Fox");
INSERT INTO shows VALUES (NULL, "Futurama", "Fox");

INSERT INTO users VALUES (NULL, "Bart Man", "1234", "1234", "ROLE_ADMIN");
INSERT INTO users VALUES (NULL, "Pie Man", "krusty", "krusty", "ROLE_CLIENT");

INSERT INTO rating VALUES (NULL, 5, 1);
INSERT INTO rating VALUES (NULL, 4, 2);
INSERT INTO rating VALUES (NULL, 3, 1);
INSERT INTO rating VALUES (NULL, 3, 2);
INSERT INTO rating VALUES (NULL, 2, 1);
INSERT INTO rating VALUES (NULL, 2, 2);


SELECT AVG(RATING) FROM rating WHERE SHOW_ID = 1;

SELECT * FROM shows;
SELECT * FROM users;
SELECT * FROM rating; 

DROP TABLE users;
DROP TABLE rating;
DROP TABLE shows;

Create Table alter (first name, last name);
Create Table "alter" (first name, last name);



