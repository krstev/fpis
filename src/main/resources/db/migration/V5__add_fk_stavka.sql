ALTER TABLE `stavka_zahteva_za_nabavku`
ADD COLUMN `zahtev` BIGINT(11) NULL AFTER `kolicina`,
ADD INDEX `fk_zahtev_idx` (`zahtev` ASC);
ALTER TABLE `stavka_zahteva_za_nabavku`
ADD CONSTRAINT `fk_zahtev`
  FOREIGN KEY (`zahtev`)
  REFERENCES `zahtev_za_nabavku` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
