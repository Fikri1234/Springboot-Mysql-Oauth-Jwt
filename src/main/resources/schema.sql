CREATE TABLE OAUTH_CLIENT_DETAILS (
  CLIENT_ID VARCHAR(255) PRIMARY KEY,
  RESOURCE_IDS VARCHAR(255),
  CLIENT_SECRET VARCHAR(255),
  SCOPE VARCHAR(255),
  AUTHORIZED_GRANT_TYPES VARCHAR(255),
  WEB_SERVER_REDIRECT_URI VARCHAR(255),
  AUTHORITIES VARCHAR(255),
  ACCESS_TOKEN_VALIDITY INTEGER,
  REFRESH_TOKEN_VALIDITY INTEGER,
  ADDITIONAL_INFORMATION VARCHAR(4096),
  AUTOAPPROVE VARCHAR(255)
);

CREATE TABLE OAUTH_CLIENT_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255)
);

//contains access token information
CREATE TABLE OAUTH_ACCESS_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION_ID VARCHAR(255) PRIMARY KEY,
  USER_NAME VARCHAR(255),
  CLIENT_ID VARCHAR(255),
  AUTHENTICATION VARBINARY(8000),
  REFRESH_TOKEN VARCHAR(255)
);

//contains refresh tokens information
CREATE TABLE OAUTH_REFRESH_TOKEN (
  TOKEN_ID VARCHAR(255),
  TOKEN VARBINARY(8000),
  AUTHENTICATION VARBINARY(8000)
);

CREATE TABLE OAUTH_CODE (
  CODE VARCHAR(255),
  AUTHENTICATION VARBINARY(8000)
);

CREATE TABLE OAUTH_APPROVALS (
  USERID VARCHAR(255),
  CLIENTID VARCHAR(255),
  SCOPE VARCHAR(255),
  STATUS VARCHAR(10),
  EXPIRESAT TIMESTAMP,
  LASTMODIFIEDAT TIMESTAMP
);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api', /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km', 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 300, 3600);

INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',
 /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 300, 3600);
 
 
 CREATE TABLE M_USER (
  ID BIGINT(20),
  PASSWORD VARCHAR(255),
  USER_NAME VARCHAR(255),
  ACCOUNT_EXPIRED BOOLEAN,
  ACCOUNT_LOCKED BOOLEAN,
  CREDENTIAL_EXPIRED BOOLEAN,
  ENABLED BOOLEAN,
  PRIMARY KEY (ID)
);

INSERT INTO M_USER(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIAL_EXPIRED, ENABLED)
  VALUES (1, 'admin', /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', FALSE, FALSE, FALSE, TRUE);

INSERT INTO M_USER(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIAL_EXPIRED, ENABLED)
  VALUES (2, 'budi', /*budi1234*/'$2a$08$1kRxTVadsyebkxcngE.1Oea8k5nUHDrpc9e2uVMkDrcU.jQD6N.kS', FALSE, FALSE, FALSE, TRUE);

INSERT INTO M_USER(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIAL_EXPIRED, ENABLED)
  VALUES (3, 'danang', /*danang1234*/'$2a$08$KtW9IZLQ3R63OnK6q8I3A.23AKbkvWaipXHfwCKMemdwtEWvHM.k2', FALSE, FALSE, FALSE, TRUE);

INSERT INTO M_USER(ID, USER_NAME, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIAL_EXPIRED, ENABLED)
  VALUES (4, 'darto', /*darto1234*/'$2a$08$AH8QaSTu8ZTsvwTdOWAGSeauv4GEaJ.9xgjvLMynj4bZOWKpBniyS', FALSE, FALSE, FALSE, TRUE);

ALTER TABLE M_USER RENAME COLUMN CREDENTIALS_EXPIRED TO CREDENTIAL_EXPIRED;