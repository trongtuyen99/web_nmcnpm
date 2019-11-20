CREATE TABLE user_db(
	ID INT IDENTITY(1,1),
	FIRSTNAME NVARCHAR(15),
	LASTNAME NVARCHAR(15),
	EMAIL VARCHAR(15),
	USERNAME VARCHAR(20),
	PASSWORD VARCHAR(20)
)
INSERT dbo.userdb
        ( FIRSTNAME ,
          LASTNAME ,
          EMAIL ,
          USERNAME ,
          PASSWORD
        )
VALUES  (
          N'a' , -- FIRSTNAME - nvarchar(15)
          N'a' , -- LASTNAME - nvarchar(15)
          'a' , -- EMAIL - varchar(15)
          'a' , -- USERNAME - varchar(20)
          'a'  -- PASSWORD - varchar(20)
        )
		SELECT * FROM dbo.userdb
