CREATE TABLE VEHICLE (
	VEHICLE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	VEHICLE_TYPE VARCHAR(16) NOT NULL,
	VEHICLE_MODEL VARCHAR(16) NOT NULL,
	NUMBER_OF_PASSENGERS VARCHAR (16) NOT NULL,
	NUMBER_OF_KILOMETERS VARCHAR(16) NOT NULL,
	PRODUCTION_YEAR VARCHAR(16) NOT NULL
	);
	
CREATE TABLE CLIENT (
	CLIENT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	FIRST_NAME VARCHAR(32),
	LAST_NAME VARCHAR(32),
	EMAIL_ADDRESS VARCHAR(32),
	ADDRESS VARCHAR(64),
	COUNTRY VARCHAR(16),
	STATE VARCHAR(16),
	PHONE_NUMBER VARCHAR(16)
	);
	
CREATE TABLE RESERVATION (
	RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	VEHICLE_ID BIGINT NOT NULL,
	CLIENT_ID BIGINT NOT NULL,
	RESERVATION_DATE DATE
	);
	
ALTER TABLE RESERVATION ADD FOREIGN KEY (VEHICLE_ID) REFERENCES VEHICLE(VEHICLE_ID);
ALTER TABLE RESERVATION ADD FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID);
CREATE INDEX IDX_RESERVATION_DATE ON RESERVATION(RESERVATION_DATE);