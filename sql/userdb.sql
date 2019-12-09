CREATE DATABASE grocery
go
CREATE TABLE userdb(
	ID INT IDENTITY(1,1),
	FULLNAME NVARCHAR(30),
	PHONE NVARCHAR(15),
	EMAIL VARCHAR(30),
	USERNAME VARCHAR(30),
	ROLE CHAR(10) NOT NULL DEFAULT 'ROLE_USER',
	PASSWORD VARCHAR(100),
	CPASSWORD VARCHAR(100)
)

INSERT dbo.userdb
        ( FULLNAME ,
          PHONE ,
          EMAIL ,
          USERNAME ,
          ROLE ,
          PASSWORD ,
          CPASSWORD
        )
VALUES  ( N'Moon' , -- FULLNAME - nvarchar(30)
          N'0912345678' , -- PHONE - nvarchar(15)
          'moon@gmail.com' , -- EMAIL - varchar(20)
          'admin1' , -- USERNAME - varchar(20)
          'ROLE_ADMIN' , -- ROLE - char(10)
          '$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda' , -- PASSWORD - varchar(100)
          '$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda'  -- CPASSWORD - varchar(100)
        )


CREATE TABLE contactdb(
	ID INT IDENTITY(1,1),
	NAME NVARCHAR(30),
	PHONE VARCHAR(15),
	EMAIL VARCHAR(30),
	SUBJECT VARCHAR(30),
	MESSAGE TEXT
)
CREATE TABLE productdb(
	ID INT IDENTITY(1,1),
	PRODUCTID VARCHAR(10),
	NAME NVARCHAR(30),
	TYPE NVARCHAR(15),
	IMAGE VARCHAR(100),
	AMOUNT INT,
	PRICE FLOAT,
	DESCRIPTION TEXT
)