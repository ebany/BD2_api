-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proyecto1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto1` ;
USE `proyecto1` ;


-- -----------------------------------------------------
-- Table `proyecto1`.`Videojuego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`Videojuego` (
  `idVideojuego` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(1000) NOT NULL,
  `Acerca_de` VARCHAR(1000) NOT NULL,
  `storyline` VARCHAR(1000) NOT NULL,
  `Fecha_Lanzamiento` VARCHAR(1000) NOT NULL,
  `raiting` DOUBLE NOT NULL,
  `raitingCount` INT NOT NULL,
  `Category_idCategory` INT NOT NULL,
  `aggregatedRaiting` DOUBLE NOT NULL,
  `aggregatedRaitingCount` INT NOT NULL,
  PRIMARY KEY (`idVideojuego`, `Category_idCategory`)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto1`.`Plataforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`Plataforma` (
  `idPlataforma` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(1000) NOT NULL,
  `Descripcion` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idPlataforma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto1`.`plataforma_videojuego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`plataforma_videojuego` (
  `Videojuego_idVideojuego` INT NOT NULL,
  `Plataforma_idPlataforma` INT NOT NULL,
  PRIMARY KEY (`Videojuego_idVideojuego`, `Plataforma_idPlataforma`),
  INDEX `fk_plataforma_videojuego_Plataforma1_idx` (`Plataforma_idPlataforma` ASC) VISIBLE,
  CONSTRAINT `fk_plataforma_videojuego_Videojuego1`
    FOREIGN KEY (`Videojuego_idVideojuego`)
    REFERENCES `proyecto1`.`Videojuego` (`idVideojuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plataforma_videojuego_Plataforma1`
    FOREIGN KEY (`Plataforma_idPlataforma`)
    REFERENCES `proyecto1`.`Plataforma` (`idPlataforma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto1`.`Genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`Genero` (
  `idGenero` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(1000) NOT NULL,
  `Descripcion` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idGenero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto1`.`videojuego_genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`videojuego_genero` (
  `Genero_idGenero` INT NOT NULL,
  `Videojuego_idVideojuego` INT NOT NULL,
  PRIMARY KEY (`Genero_idGenero`, `Videojuego_idVideojuego`),
  INDEX `fk_videojuego_genero_Videojuego1_idx` (`Videojuego_idVideojuego` ASC) VISIBLE,
  CONSTRAINT `fk_videojuego_genero_Genero1`
    FOREIGN KEY (`Genero_idGenero`)
    REFERENCES `proyecto1`.`Genero` (`idGenero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_videojuego_genero_Videojuego1`
    FOREIGN KEY (`Videojuego_idVideojuego`)
    REFERENCES `proyecto1`.`Videojuego` (`idVideojuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `proyecto1`.`language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`Language` (
  `idLanguage` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idLanguage`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `proyecto1`.`language_supports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto1`.`Language_supports` (
  `game` INT NOT NULL,
  `language` INT NOT NULL,
  PRIMARY KEY (`game`, `language`),
  INDEX `fk_a_videojuego_genero_Videojuego1_idx` (`language` ASC) VISIBLE,
  CONSTRAINT `fk_a_videojuego_genero_Genero1`
    FOREIGN KEY (`game`)
    REFERENCES `proyecto1`.`Videojuego` (`idVideojuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_a_videojuego_genero_Videojuego1`
    FOREIGN KEY (`language`)
    REFERENCES `proyecto1`.`Language` (`idLanguage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
