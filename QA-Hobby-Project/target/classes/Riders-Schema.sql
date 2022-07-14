DROP TABLE IF EXISTS `riders` CASCADE;
create table `riders` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`rider_name` VARCHAR(255),
	`team_name` VARCHAR(255), 
	`sponsor_name` VARCHAR(255)
);