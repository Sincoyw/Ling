CREATE DATABASE `ling` ;

CREATE USER 'ling_man'@'localhost' identified by 'ling_man';
grant all on ling.* to 'ling_man';

USE ling;

drop table if exists t_ling_user;

CREATE TABLE `t_ling_user` (
  `user_uuid` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NOT NULL,
  `salt_fixed` CHAR(8) NULL,
  `salt_random` CHAR(8) NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  `access_level` INT ZEROFILL NOT NULL,
  `cellphone` VARCHAR(11) NULL,
  `last_visit_time` DATETIME NULL,
  `home_site` TEXT(10) NULL,
  `email` VARCHAR(320) NOT NULL,
  PRIMARY KEY (`user_uuid`),
  UNIQUE INDEX `user_uuid_UNIQUE` (`user_uuid` ASC),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));