USE [WebDongHoDB]
GO
/****** Object:  Table [dbo].[contactdb]    Script Date: 12/9/2019 2:56:45 PM ******/
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
/****** Object:  Table [dbo].[nguoidung]    Script Date: 12/9/2019 2:56:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nguoidung](
	[mand] [int] NOT NULL,
	[email] [varchar](50) NOT NULL,
	[hoten] [varchar](50) NOT NULL,
	[matkhau] [varchar](15) NOT NULL,
	[quyentruycap] [varchar](10) NOT NULL,
	[sdt] [varchar](15) NOT NULL,
	[tendangnhap] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mand] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orderdb]    Script Date: 12/9/2019 2:56:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PRODUCT_ID] [int] NOT NULL,
	[CREATED_TIME] [datetime] NOT NULL,
	[ADDRESS] [nvarchar](200) NOT NULL,
	[PRICE] [bigint] NOT NULL,
	[QUANTITY] [int] NOT NULL,
 CONSTRAINT [PK_orderdb_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[producerdb]    Script Date: 12/9/2019 2:56:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producerdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [nvarchar](100) NOT NULL,
	[WEBSITE] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_producerdb] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productdb]    Script Date: 12/9/2019 2:56:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [nvarchar](200) NOT NULL,
	[PRICE] [bigint] NOT NULL,
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
/****** Object:  Table [dbo].[sanpham]    Script Date: 12/9/2019 2:56:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanpham](
	[masp] [int] NOT NULL,
	[dongia] [varchar](20) NOT NULL,
	[hinhanh] [varchar](50) NOT NULL,
	[mansx] [int] NOT NULL,
	[ngaycapnhatcuoi] [varchar](20) NOT NULL,
	[ngaytao] [varchar](20) NOT NULL,
	[nguoicapnhat] [int] NOT NULL,
	[nguoitao] [int] NOT NULL,
	[soluong] [int] NOT NULL,
	[tensanpham] [varchar](100) NOT NULL,
	[thongtin] [varchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userdb]    Script Date: 12/9/2019 2:56:45 PM ******/
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
INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (2, N'Me', N'test@mail.com', N'Blahh')
SET IDENTITY_INSERT [dbo].[contactdb] OFF
SET IDENTITY_INSERT [dbo].[orderdb] ON 

INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (1, 6, CAST(N'2019-12-08T13:19:23.017' AS DateTime), N'blah', 6666, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (2, 8, CAST(N'2019-12-08T13:19:33.363' AS DateTime), N'beh', 8888, 2)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (3, 9, CAST(N'2019-12-08T13:19:41.550' AS DateTime), N'nah', 9999, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (5, 10, CAST(N'2019-12-08T17:59:09.760' AS DateTime), N'hh', 3333, 6)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (6, 0, CAST(N'2019-12-08T18:09:46.623' AS DateTime), N'blah', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (7, 0, CAST(N'2019-12-08T18:11:16.423' AS DateTime), N'tran duy hung', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (8, 0, CAST(N'2019-12-08T18:33:44.133' AS DateTime), N'b', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (9, 0, CAST(N'2019-12-08T20:07:45.307' AS DateTime), N'me', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (10, 0, CAST(N'2019-12-08T20:11:14.237' AS DateTime), N'me', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (11, 0, CAST(N'2019-12-08T20:18:35.203' AS DateTime), N'finaltime', 0, 0)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (15, 6, CAST(N'2019-12-08T20:47:53.573' AS DateTime), N'', 5, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (16, 6, CAST(N'2019-12-08T21:20:50.323' AS DateTime), N'', 5, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (17, 6, CAST(N'2019-12-08T22:00:32.667' AS DateTime), N'hah', 10, 2)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (18, 6, CAST(N'2019-12-08T22:01:22.230' AS DateTime), N'ff', 5, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (19, 8, CAST(N'2019-12-08T22:02:32.567' AS DateTime), N'ff', 111111, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (20, 9, CAST(N'2019-12-09T13:46:22.907' AS DateTime), N'blah', 10000, 2)
SET IDENTITY_INSERT [dbo].[orderdb] OFF
SET IDENTITY_INSERT [dbo].[producerdb] ON 

INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (1, N'Test 1', N'1.com')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (2, N'Test 2', N'2.com')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (3, N'Test 3', N'3.com')
SET IDENTITY_INSERT [dbo].[producerdb] OFF
SET IDENTITY_INSERT [dbo].[productdb] ON 

INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (6, N'Test 3', 5, 33, 444, N'hihi', N'/images/s3.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (8, N'Test 10', 111111, 1, 100000, N'neh', N'/images/s2.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (9, N'Test 5', 5000, 5, 50, N'heh', N'/images/s3.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (10, N'Test 4', 4444, 4, 44444, N'neh', N'/images/s2.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (11, N'Test 5', 5555, 5, 55555, N'phhh', N'/images/s3.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (12, N'Test 69', 69, 69, 69, N'lol', N'/images/s2.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (13, N'Test 96', 100000, 1, 16, N'this is a test product', N'/images/s2.jpg')
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
ALTER TABLE [dbo].[orderdb] ADD  CONSTRAINT [DF__orderdb__CREATED__70DDC3D8]  DEFAULT (getdate()) FOR [CREATED_TIME]
GO
ALTER TABLE [dbo].[userdb] ADD  DEFAULT ('ROLE_USER ') FOR [ROLE]
GO
