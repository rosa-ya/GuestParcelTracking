DROP TABLE IF EXISTS TBL_GUEST;

CREATE TABLE TBL_GUEST (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  check_in timestamp DEFAULT NULL,
  check_out timestamp DEFAULT NULL
);

INSERT INTO
	TBL_GUEST (first_name, last_name, check_in, check_out)
VALUES
  	('Jan', 'Jan', '2021-02-27 20:02:21.550','2021-02-28 20:02:21.550'),
  	('Mike', 'Mike', '2021-02-27 20:02:21.550',null),
  	('Adam', 'Adam', '2021-02-27 20:02:21.550',null);