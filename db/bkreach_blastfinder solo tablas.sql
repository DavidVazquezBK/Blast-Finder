-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bkreach_blastfinder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bkreach_blastfinder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `bkreach_blastfinder`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `iniciales` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  UNIQUE INDEX `iniciales_UNIQUE` (`iniciales` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bkreach_blastfinder`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`Producto` (
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
    REFERENCES `bkreach_blastfinder`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bkreach_blastfinder`.`Ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`Ubicacion` (
  `idUbicacion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(60) NULL DEFAULT 'Sin descripción',
  PRIMARY KEY (`idUbicacion`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bkreach_blastfinder`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`Material` (
  `idMaterial` INT NOT NULL AUTO_INCREMENT,
  `notas` VARCHAR(60) NULL DEFAULT 'Sin notas',
  `Producto_idProducto` INT NOT NULL,
  `nombre` VARCHAR(30) NULL DEFAULT 'Generando',
  PRIMARY KEY (`idMaterial`),
  INDEX `fk_Material_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Material_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `bkreach_blastfinder`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bkreach_blastfinder`.`Movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`Movimiento` (
  `idMovimiento` INT NOT NULL AUTO_INCREMENT,
  `Material_idMaterial` INT NOT NULL,
  `Ubicacion_idUbicacion` INT NOT NULL,
  `fechaHora` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_Material_has_Ubicacion_Ubicacion1_idx` (`Ubicacion_idUbicacion` ASC),
  INDEX `fk_Material_has_Ubicacion_Material1_idx` (`Material_idMaterial` ASC),
  PRIMARY KEY (`idMovimiento`),
  CONSTRAINT `fk_Material_has_Ubicacion_Material1`
    FOREIGN KEY (`Material_idMaterial`)
    REFERENCES `bkreach_blastfinder`.`Material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Material_has_Ubicacion_Ubicacion1`
    FOREIGN KEY (`Ubicacion_idUbicacion`)
    REFERENCES `bkreach_blastfinder`.`Ubicacion` (`idUbicacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Placeholder table for view `bkreach_blastfinder`.`ultimomovimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`ultimomovimiento` (`idMovimiento` INT, `Material_idMaterial` INT, `Ubicacion_idUbicacion` INT, `fechaHora` INT);

-- -----------------------------------------------------
-- Placeholder table for view `bkreach_blastfinder`.`ultimomovimientonombres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bkreach_blastfinder`.`ultimomovimientonombres` (`'id'` INT, `'material'` INT, `'ubicacion'` INT, `fechaHora` INT);

-- -----------------------------------------------------
-- View `bkreach_blastfinder`.`ultimomovimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bkreach_blastfinder`.`ultimomovimiento`;
USE `bkreach_blastfinder`;
CREATE OR REPLACE VIEW `ultimomovimiento` AS select `Movimiento`.`idMovimiento` AS `idMovimiento`,`Movimiento`.`Material_idMaterial` AS `Material_idMaterial`,`Movimiento`.`Ubicacion_idUbicacion` AS `Ubicacion_idUbicacion`,`Movimiento`.`fechaHora` AS `fechaHora` from `Movimiento` where `Movimiento`.`fechaHora` in (select max(`Movimiento`.`fechaHora`) from `Movimiento` group by `Movimiento`.`Material_idMaterial`) order by `Movimiento`.`Material_idMaterial`;

-- -----------------------------------------------------
-- View `bkreach_blastfinder`.`ultimomovimientonombres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bkreach_blastfinder`.`ultimomovimientonombres`;
USE `bkreach_blastfinder`;
CREATE  OR REPLACE VIEW `ultimomovimientonombres` AS SELECT ultimomovimiento.idMovimiento as 'id', material.nombre as 'material', ubicacion.nombre as 'ubicacion', ultimomovimiento.fechaHora FROM `ultimomovimiento`, ubicacion, material WHERE ubicacion.idUbicacion=ultimomovimiento.Ubicacion_idUbicacion AND material.idMaterial=ultimomovimiento.Material_idMaterial ORDER BY `ultimomovimiento`.`fechaHora` DESC;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
