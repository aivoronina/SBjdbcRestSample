
-- Schema KTK
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS KTK CASCADE;

-- -----------------------------------------------------
-- Schema KTK
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS KTK;

-- -----------------------------------------------------
-- Table `KTK`.`PATIENTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS KTK.PATIENTS ;

CREATE TABLE IF NOT EXISTS KTK.PATIENTS (
  id SERIAL NOT NULL,
  firstName VARCHAR(45) NULL,
  lastName VARCHAR(45) NULL,
  idCard VARCHAR(45) NULL,
  facilityId VARCHAR(45) NULL,
  PRIMARY KEY (id))
;

CREATE UNIQUE INDEX IDcard_UNIQUE ON KTK.PATIENTS (idCard ASC);

CREATE UNIQUE INDEX FacilityId_UNIQUE ON KTK.PATIENTS (facilityId ASC);

CREATE INDEX FirstName_IND ON KTK.PATIENTS (firstName ASC);

CREATE INDEX LastName_IND ON KTK.PATIENTS (lastName ASC);

