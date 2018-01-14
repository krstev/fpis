CREATE TABLE `zahtev_za_nabavku` (
  `id` BIGINT(11) NOT NULL,
  `kreiran` DATETIME NULL,
  `kreirao` BIGINT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_radnik_idx` (`kreirao` ASC),
  CONSTRAINT `fk_radnik`
    FOREIGN KEY (`kreirao`)
    REFERENCES `fpis`.`radnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);