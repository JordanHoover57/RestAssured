INSERT INTO VEHICLE (VEHICLE_TYPE, VEHICLE_MODEL, NUMBER_OF_PASSENGERS, NUMBER_OF_KILOMETERS, PRODUCTION_YEAR) VALUES ('FORD','MUSTANG','4','20000',2018);
INSERT INTO VEHICLE (VEHICLE_TYPE, VEHICLE_MODEL, NUMBER_OF_PASSENGERS, NUMBER_OF_KILOMETERS, PRODUCTION_YEAR) VALUES ('FORD','SHELBY GT500','4','10000',2020);
INSERT INTO VEHICLE (VEHICLE_TYPE, VEHICLE_MODEL, NUMBER_OF_PASSENGERS, NUMBER_OF_KILOMETERS, PRODUCTION_YEAR) VALUES ('FORD','FOCUS SI','4','1000',2019);
INSERT INTO VEHICLE (VEHICLE_TYPE, VEHICLE_MODEL, NUMBER_OF_PASSENGERS, NUMBER_OF_KILOMETERS, PRODUCTION_YEAR) VALUES ('FORD','WRANGLER','4','25000',2020);


INSERT INTO CLIENT (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ADDRESS, COUNTRY, STATE, PHONE_NUMBER) VALUES ('JORDAN','HOOVER','JORDAN@AOL.COM','156 SNABLY AVE JOHNSTOWN','USA','PA','814 244 2665');
INSERT INTO CLIENT (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ADDRESS, COUNTRY, STATE, PHONE_NUMBER) VALUES ('LUKE','SKYWALKER','SKYWALKIN@AOL.COM','313 SAND DRIVE MOS EISLEY','TATOINE','MI','090 234 2665');
INSERT INTO CLIENT (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ADDRESS, COUNTRY, STATE, PHONE_NUMBER) VALUES ('GERALT','RIVIA','MONSTERKILLER@YAHOO.COM','1272 KAER MOREN DRIVE','RIVIA','RI','000 987 0980');

INSERT INTO RESERVATION (VEHICLE_ID, CLIENT_ID, RESERVATION_DATE) VALUES ((SELECT VEHICLE_ID FROM VEHICLE WHERE VEHICLE_MODEL = 'MUSTANG'),(SELECT CLIENT_ID FROM CLIENT WHERE FIRST_NAME ='JORDAN'),'2020-01-01');
