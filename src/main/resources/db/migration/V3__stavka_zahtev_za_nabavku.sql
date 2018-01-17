CREATE TABLE `stavka_zahteva_za_nabavku` (
  `id` BIGINT(11) NOT NULL DEFAULT 0,
  `artikal` BIGINT(11) NULL,
  `kolicina` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_artikal_idx` (`artikal` ASC),
  CONSTRAINT `fk_artikal`
    FOREIGN KEY (`artikal`)
    REFERENCES `fpis`.`artikal` (`kataloski_broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);