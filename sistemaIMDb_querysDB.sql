CREATE TABLE shows (
	id INT AUTO_INCREMENT,
	show_title VARCHAR(255),
	show_network VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE `user` (
	id INT AUTO_INCREMENT,
	username VARCHAR(255),
	email VARCHAR(255),
	`password` VARCHAR(255),
	password_confirmation VARCHAR(255),
	`role` VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE rating (
	id INT AUTO_INCREMENT,
	rating INT(1),
	show_id INT,
	user_id INT,
	PRIMARY KEY (id),
	CONSTRAINT fk_show_id FOREIGN KEY (show_id) REFERENCES shows (id),
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


SELECT AVG(rating) FROM rating WHERE show_id = 2;

SELECT * FROM rating r WHERE r.show_id = 2;

SELECT * FROM shows;
SELECT * FROM `user`;
SELECT * FROM rating; 

SELECT s.id AS id, s.show_title AS showTitle, s.show_network AS showNetwork, AVG(r.rating) AS avgRating FROM shows s
JOIN rating r ON r.show_id = s.id GROUP BY s.id;

SELECT * FROM shows s INNER JOIN rating r ON s.id = r.show_id;

SELECT s.id, s.show_title, s.show_network , AVG(r.rating) FROM shows s INNER JOIN rating r ON s.id = r.show_id GROUP BY s.id ;




