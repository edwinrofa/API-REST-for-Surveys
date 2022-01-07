-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema consumer_survey_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema consumer_survey_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `consumer_survey_db` DEFAULT CHARACTER SET utf8 ;
USE `consumer_survey_db` ;

-- -----------------------------------------------------
-- Table `consumer_survey_db`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `identification` VARCHAR(20) NOT NULL,
  `registration_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumer_survey_db`.`survey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`survey` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `survey_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumer_survey_db`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`question` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `question_type` ENUM('multiple_choice', 'open') NOT NULL,
  `question_description` VARCHAR(200) NOT NULL,
  `survey` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_question_survey_idx` (`survey` ASC),
  CONSTRAINT `fk_question_survey`
    FOREIGN KEY (`survey`)
    REFERENCES `consumer_survey_db`.`survey` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumer_survey_db`.`option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`option` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `option` VARCHAR(150) NOT NULL,
  `question` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_option_question1_idx` (`question` ASC),
  CONSTRAINT `fk_option_question1`
    FOREIGN KEY (`question`)
    REFERENCES `consumer_survey_db`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumer_survey_db`.`customer_survey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`customer_survey` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `customer` INT UNSIGNED NOT NULL,
  `survey` INT UNSIGNED NOT NULL,
  `date_survey` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_survey_customer1_idx` (`customer` ASC),
  INDEX `fk_customer_survey_survey1_idx` (`survey` ASC),
  CONSTRAINT `fk_customer_survey_customer1`
    FOREIGN KEY (`customer`)
    REFERENCES `consumer_survey_db`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_survey_survey1`
    FOREIGN KEY (`survey`)
    REFERENCES `consumer_survey_db`.`survey` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumer_survey_db`.`customer_response`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumer_survey_db`.`customer_response` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `question` INT UNSIGNED NOT NULL,
  `customer_survey` INT UNSIGNED NOT NULL,
  `open_response` VARCHAR(150) NULL,
  `option` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_response_question1_idx` (`question` ASC),
  INDEX `fk_customer_response_customer_survey1_idx` (`customer_survey` ASC),
  INDEX `fk_customer_response_option1_idx` (`option` ASC),
  CONSTRAINT `fk_customer_response_question1`
    FOREIGN KEY (`question`)
    REFERENCES `consumer_survey_db`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_response_customer_survey1`
    FOREIGN KEY (`customer_survey`)
    REFERENCES `consumer_survey_db`.`customer_survey` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_response_option1`
    FOREIGN KEY (`option`)
    REFERENCES `consumer_survey_db`.`option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
