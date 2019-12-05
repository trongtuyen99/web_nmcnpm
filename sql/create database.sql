USE [WebDongHoDB]
GO
/****** Object:  Table [dbo].[contactdb]    Script Date: 12/5/2019 9:46:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[contactdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [nvarchar](20) NULL,
	[EMAIL] [nvarchar](20) NULL,
	[MESSAGE] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productdb]    Script Date: 12/5/2019 9:46:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [nvarchar](200) NOT NULL,
	[PRICE] [nvarchar](20) NOT NULL,
	[PRODUCER_ID] [int] NOT NULL,
	[STOCK_NUMBER] [int] NOT NULL,
	[DESCRIPTION] [nvarchar](400) NULL,
	[IMAGE] [nvarchar](100) NULL,
 CONSTRAINT [PK_productdb] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userdb]    Script Date: 12/5/2019 9:46:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FULLNAME] [nvarchar](30) NULL,
	[PHONE] [nvarchar](15) NULL,
	[EMAIL] [varchar](20) NULL,
	[USERNAME] [varchar](20) NULL,
	[ROLE] [char](10) NOT NULL,
	[PASSWORD] [varchar](100) NULL,
	[CPASSWORD] [varchar](100) NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[contactdb] ON 

INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (1, N'Lol', N'lol@lol.com', N'Test message.')
SET IDENTITY_INSERT [dbo].[contactdb] OFF
SET IDENTITY_INSERT [dbo].[productdb] ON 

INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (1, N'Test', N'10', 1, 1, N'hh', N'hh')
SET IDENTITY_INSERT [dbo].[productdb] OFF
SET IDENTITY_INSERT [dbo].[userdb] ON 

INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (1, N'Moon', N'0912345678', N'moon@gmail.com', N'admin1', N'ROLE_ADMIN', N'$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda', N'$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (2, N'Phong Ha', N'06969696969', N'lol@lol.com', N'admin2', N'ROLE_USER ', N'$2a$10$1qqYOonQeHRoPXIxUaMi4.SgbVYeXLxT.zypwZ.GGUAStRFzhVMEm', N'$2a$10$T.mmPbx4O6Fes3Xve7WI4uzfLzrlUbS9TVml1GIMcCqKRbEIbAVK.')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (3, N'Test Name 1', N'011111111111', N'test1@test.com', N'user1', N'ROLE_USER ', N'$2a$10$yZLLDORTrNk1yV0yLvbjF.f4CxoEmb94NLSgVEUcBLBWEkblB9wju', N'$2a$10$yy/PyJpcRQJ0sxksbDlQUO2UhWI58WK2IFDl0sHpO9sgUDB1/7GLK')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (4, N'Test Name 2', N'02222222222', N'test2@lol.com', N'user2', N'ROLE_USER ', N'$2a$10$T1DgPI7g5iyV2ZvLzhOahOa1tWRfPnaE6pFsuDi.4dS2cpk7UT.mW', N'$2a$10$ou369KLzuKw0rrfQgQg12eSa0G.c1yOo/5D1Ack05yKVsCaB4qUEe')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (5, N'Test Name 3', N'02222222223', N'test3@lol.com', N'user3', N'ROLE_USER ', N'$2a$10$./7/a.t8KS1.mTHIvhKm6.HTjZiE5dS92qezaYXtZxeFL5CokhfdC', N'$2a$10$iGNAGF0mwUPu8cjO.dW5kOxsIzymjbdWXaMtGEbM2S68BEOsoGtYi')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (6, N'Test Name 4', N'02222222224', N'test4@lol.com', N'user4', N'ROLE_USER ', N'$2a$10$i0tjEiGzNGJQjg/co71VWOVglrBLs5/C29NTaux7VHuz.zzOh..gq', N'$2a$10$nkIcPlGRZ7523yMD./yhWu9xE5ks1pYMK3kT13OCSES1PG0twWVU.')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (7, N'Test Name 5', N'02222222225', N'test5@lol.com', N'user5', N'ROLE_USER ', N'$2a$10$Tog2.vuwQH/L5JmwjsuRzOtm6Zk846Z.BUL9tMv4kclgVfU0cikiG', N'$2a$10$RgCecyxm7IPMbqkQuv0ugub1yOOuz0j7ATXd9G86U0amtT7bYkYo.')
SET IDENTITY_INSERT [dbo].[userdb] OFF
ALTER TABLE [dbo].[userdb] ADD  DEFAULT ('ROLE_USER ') FOR [ROLE]
GO
