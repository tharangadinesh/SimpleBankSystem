DROP TABLE IF EXISTS FileData;

CREATE TABLE FileData (
  id long AUTO_INCREMENT  PRIMARY KEY,
  source VARCHAR(250) NOT NULL,
  codeListCode VARCHAR(250) NOT NULL,
  code VARCHAR(250) DEFAULT NULL,
  displayValue VARCHAR(250) DEFAULT NULL,
  longDescription VARCHAR(250) DEFAULT NULL,
  fromDate VARCHAR(250) DEFAULT NULL,
  toDate VARCHAR(250) DEFAULT NULL,
  sortingPriority VARCHAR(250) DEFAULT NULL
);