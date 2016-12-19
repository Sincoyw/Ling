CREATE SCHEMA `ling` ;

drop table if exists t_ling_user;

CREATE TABLE `ling`.`t_ling_user` (
  `user_id` VARCHAR(255) NOT NULL,
  `salt_fixed` CHAR(8) NULL,
  `salt_random` CHAR(8) NULL,
  `password` VARCHAR(45) NOT NULL,
  `access_level` INT ZEROFILL NOT NULL,
  `cellphone` VARCHAR(11) NULL,
  `last_visit_time` DATETIME NULL,
  `home_site` TEXT(10) NULL,
  `email` VARCHAR(320) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `cellphone_UNIQUE` (`cellphone` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

