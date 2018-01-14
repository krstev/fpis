CREATE TABLE `radnik` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `prezime` VARCHAR(45) NULL,
  `identifikacioni_broj` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `artikal` (
  `kataloski_broj` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NULL,
  `opis` VARCHAR(100) NULL,
  `cena` DECIMAL(6,2) NULL,
  `stanje_na_lageru` INT NULL,
  `naruceno` INT NULL,
  `rezervisano` INT NULL,
  `otpremljeno` INT NULL,
  `vraceno_komitentu` INT NULL,
  `izdato` INT NULL,
  `prodato` INT NULL,
  `reklamirano` INT NULL,
  PRIMARY KEY (`kataloski_broj`));

  CREATE TABLE `komitent` (
  `pib` BIGINT(9) NOT NULL,
  `naziv` VARCHAR(45) NULL,
  `adresa` VARCHAR(45) NULL,
  `telefon` VARCHAR(45) NULL,
  `fax` VARCHAR(45) NULL,
  `website` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `registarski_broj` VARCHAR(45) NULL,
  `sifra_delatnosti` INT NULL,
  PRIMARY KEY (`pib`));
