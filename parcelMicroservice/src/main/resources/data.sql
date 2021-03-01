DROP TABLE IF EXISTS TBL_PARCEL;

CREATE TABLE TBL_PARCEL (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  guest_id INT NOT NULL,
  parcel_code VARCHAR(250) NOT NULL,
  delivered BOOLEAN
);

INSERT INTO
	TBL_PARCEL (guest_id, parcel_code, delivered)
VALUES
  	(2, 'dd', 0);

