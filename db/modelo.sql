-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema blastfinder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema blastfinder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `blastfinder` DEFAULT CHARACTER SET utf8 ;
USE `blastfinder` ;

-- -----------------------------------------------------
-- Table `blastfinder`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `iniciales` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  UNIQUE INDEX `iniciales_UNIQUE` (`iniciales` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blastfinder`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  `iniciales` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Material_Categoria1_idx` (`Categoria_idCategoria` ASC),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  UNIQUE INDEX `iniciales_UNIQUE` (`iniciales` ASC),
  CONSTRAINT `fk_Material_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `blastfinder`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blastfinder`.`Ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`Ubicacion` (
  `idUbicacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(60) NULL DEFAULT 'Sin descripción',
  PRIMARY KEY (`idUbicacion`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blastfinder`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`Material` (
  `idMaterial` INT NOT NULL AUTO_INCREMENT,
  `notas` VARCHAR(60) NULL DEFAULT 'Sin notas',
  `Producto_idProducto` INT NOT NULL,
  `nombre` VARCHAR(30) NULL DEFAULT 'Generando',
  PRIMARY KEY (`idMaterial`),
  INDEX `fk_Material_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Material_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `blastfinder`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blastfinder`.`Movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`Movimiento` (
  `idMovimiento` INT NOT NULL AUTO_INCREMENT,
  `Material_idMaterial` INT NOT NULL,
  `Ubicacion_idUbicacion` INT NOT NULL,
  `fechaHora` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_Material_has_Ubicacion_Ubicacion1_idx` (`Ubicacion_idUbicacion` ASC),
  INDEX `fk_Material_has_Ubicacion_Material1_idx` (`Material_idMaterial` ASC),
  PRIMARY KEY (`idMovimiento`),
  CONSTRAINT `fk_Material_has_Ubicacion_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `blastfinder`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Material_has_Ubicacion_Ubicacion1`
    FOREIGN KEY (`Ubicacion_idUbicacion`)
    REFERENCES `blastfinder`.`Ubicacion` (`idUbicacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `blastfinder` ;

-- -----------------------------------------------------
-- Placeholder table for view `blastfinder`.`ultimomovimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`ultimomovimiento` (`idMovimiento` INT, `Material_idMaterial` INT, `Ubicacion_idUbicacion` INT, `fechaHora` INT);

-- -----------------------------------------------------
-- Placeholder table for view `blastfinder`.`ultimomovimientonombres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blastfinder`.`ultimomovimientonombres` (`'id'` INT, `'material'` INT, `'ubicacion'` INT, `fechaHora` INT);

-- -----------------------------------------------------
-- View `blastfinder`.`ultimomovimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blastfinder`.`ultimomovimiento`;
USE `blastfinder`;
CREATE  OR REPLACE VIEW `ultimomovimiento` AS select `blastfinder`.`movimiento`.`idMovimiento` AS `idMovimiento`,`blastfinder`.`movimiento`.`Material_idMaterial` AS `Material_idMaterial`,`blastfinder`.`movimiento`.`Ubicacion_idUbicacion` AS `Ubicacion_idUbicacion`,`blastfinder`.`movimiento`.`fechaHora` AS `fechaHora` from `blastfinder`.`movimiento` where `blastfinder`.`movimiento`.`fechaHora` in (select max(`blastfinder`.`movimiento`.`fechaHora`) from `blastfinder`.`movimiento` group by `blastfinder`.`movimiento`.`Material_idMaterial`) order by `blastfinder`.`movimiento`.`Material_idMaterial`;

-- -----------------------------------------------------
-- View `blastfinder`.`ultimomovimientonombres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blastfinder`.`ultimomovimientonombres`;
USE `blastfinder`;
CREATE  OR REPLACE VIEW `ultimomovimientonombres` AS SELECT ultimomovimiento.idMovimiento as 'id', material.nombre as 'material', ubicacion.nombre as 'ubicacion', ultimomovimiento.fechaHora FROM `ultimomovimiento`, ubicacion, material WHERE ubicacion.idUbicacion=ultimomovimiento.Ubicacion_idUbicacion AND material.idMaterial=ultimomovimiento.Material_idMaterial ORDER BY `ultimomovimiento`.`fechaHora` DESC;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
