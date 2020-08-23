-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gastos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gastos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gastos` DEFAULT CHARACTER SET utf8 ;
USE `gastos` ;

-- -----------------------------------------------------
-- Table `gastos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gastos`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `sexo` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `saldo` DECIMAL NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gastos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gastos`.`categoria` (
  `idcategoria` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `tipo` INT NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gastos`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gastos`.`transaccion` (
  `idtransaccion` INT NOT NULL AUTO_INCREMENT,
  `valor` DECIMAL(8,2) NOT NULL,
  `fecha` VARCHAR(10) NOT NULL,
  `frecuencia` VARCHAR(45) NOT NULL,
  `usuario_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`idtransaccion`),
  INDEX `fk_transaccion_usuario_idx` (`usuario_id` ASC) ,
  INDEX `fk_transaccion_categoria1_idx` (`categoria_id` ASC) ,
  CONSTRAINT `fk_transaccion_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `gastos`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaccion_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `gastos`.`categoria` (`idcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
