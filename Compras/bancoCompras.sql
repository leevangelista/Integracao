SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `compras`.`fornecedores`
-- -----------------------------------------------------

CREATE DATABASE compras;

CREATE TABLE IF NOT EXISTS `compras`.`fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(255) NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `compras`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compras`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `estoque` INT NOT NULL,
  `valor_custo` DECIMAL(10,2) NOT NULL,
  `valor_venda` DECIMAL(10,2) NOT NULL,
  `dat_ultima_compra` DATE NOT NULL,
  `fornecedores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_fornecedores1_idx` (`fornecedores_id` ASC),
  CONSTRAINT `fk_produtos_fornecedores1`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `compras`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compras`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compras`.`compras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dat_compra` DATE NOT NULL,
  `nota_fiscal` VARCHAR(6) NOT NULL,
  `valor_total` DECIMAL(10,2) NOT NULL,
  `fornecedores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compras_fornecedores1_idx` (`fornecedores_id` ASC),
  CONSTRAINT `fk_compras_fornecedores1`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `compras`.`fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compras`.`compras_itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compras`.`compras_itens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `compras_id` INT NOT NULL,
  `produtos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compras_itens_compras1_idx` (`compras_id` ASC),
  INDEX `fk_compras_itens_produtos1_idx` (`produtos_id` ASC),
  CONSTRAINT `fk_compras_itens_compras1`
    FOREIGN KEY (`compras_id`)
    REFERENCES `compras`.`compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compras_itens_produtos1`
    FOREIGN KEY (`produtos_id`)
    REFERENCES `compras`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use compras;
select * from fornecedores;
select * from produtos;