CREATE TABLE userdb(
	ID INT IDENTITY(1,1),
	FULLNAME NVARCHAR(30),
	PHONE NVARCHAR(15),
	EMAIL VARCHAR(20),
	USERNAME VARCHAR(20),
	QUYENTRUYCAP CHAR(10) NOT NULL DEFAULT 'ROLE_USER ',
	PASSWORD VARCHAR(100),
	CPASSWORD VARCHAR(100)
)

INSERT dbo.userdb
        ( FULLNAME ,
          PHONE ,
          EMAIL ,
          USERNAME ,
          QUYENTRUYCAP ,
          PASSWORD ,
          CPASSWORD
        )
VALUES  ( N'Moon' , -- FULLNAME - nvarchar(30)
          N'0912345678' , -- PHONE - nvarchar(15)
          'moon@gmail.com' , -- EMAIL - varchar(20)
          'admin1' , -- USERNAME - varchar(20)
          'ROLE_ADMIN' , -- quyenTruyCap - char(10)
          '$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda' , -- PASSWORD - varchar(100)
          '$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda'  -- CPASSWORD - varchar(100)
        )
		SELECT * FROM dbo.userdb