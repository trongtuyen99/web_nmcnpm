USE [master]
GO
/****** Object:  Database [WebDongHoDB]    Script Date: 12/10/2019 12:27:46 PM ******/
CREATE DATABASE [WebDongHoDB]
GO
ALTER DATABASE [WebDongHoDB] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [WebDongHoDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [WebDongHoDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WebDongHoDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WebDongHoDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WebDongHoDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WebDongHoDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [WebDongHoDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WebDongHoDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WebDongHoDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WebDongHoDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WebDongHoDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WebDongHoDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WebDongHoDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WebDongHoDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WebDongHoDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WebDongHoDB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [WebDongHoDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WebDongHoDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WebDongHoDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WebDongHoDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WebDongHoDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WebDongHoDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WebDongHoDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WebDongHoDB] SET RECOVERY FULL 
GO
ALTER DATABASE [WebDongHoDB] SET  MULTI_USER 
GO
ALTER DATABASE [WebDongHoDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WebDongHoDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WebDongHoDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WebDongHoDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [WebDongHoDB] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'WebDongHoDB', N'ON'
GO
ALTER DATABASE [WebDongHoDB] SET QUERY_STORE = OFF
GO
USE [WebDongHoDB]
GO
USE [WebDongHoDB]
GO
/****** Object:  Sequence [dbo].[hibernate_sequence]    Script Date: 12/10/2019 12:27:46 PM ******/
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[contactdb]    Script Date: 12/10/2019 12:27:46 PM ******/
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
/****** Object:  Table [dbo].[orderdb]    Script Date: 12/10/2019 12:27:46 PM ******/
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
/****** Object:  Table [dbo].[producerdb]    Script Date: 12/10/2019 12:27:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producerdb](
	[ID] [int] NOT NULL,
	[NAME] [nvarchar](100) NOT NULL,
	[WEBSITE] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_producerdb] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productdb]    Script Date: 12/10/2019 12:27:46 PM ******/
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
/****** Object:  Table [dbo].[userdb]    Script Date: 12/10/2019 12:27:46 PM ******/
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
INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (2, N'Moon', N'moon@gmail.com', N'I love you')
INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (3, N'Moon', N'moon@gmail.com', N'test')
INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (4, N'Moon', N'moon@gmail.com', N'a')
INSERT [dbo].[contactdb] ([ID], [NAME], [EMAIL], [MESSAGE]) VALUES (5, N'Moon', N'moon@gmail.com', N'Kế hoạch trả thẻ Bảo hiểm y tế đợt 1 cho sinh viên K64
Nhà trường tiến hành trả thẻ BHYT đợt 1 cho sinh viên khóa 64.
Danh sách sinh viên nhận thẻ BHYT xem tại đây: http://bit.ly/2se5JKf
Mời các em lớp trưởng đại diện lên nhận thẻ Bảo hiểm y tế cho lớp theo kế hoạch phân công cụ thể từ 26/11/2019 đến 13/12/2019 như sau:
1- Viện Công nghệ thông tin & TT, Viện Điện, Viện Điện tử Viễn thông, Viện Toán Ứng dụng và tin học tại bàn 1 – Phòng 103 – C1
2- Viện Cơ khí, Viện Dệt may – Da Giầy và Thời trang, Viện KH&CN Vật liệu, Viện Sư phạm kỹ thuật, Viện Cơ khí Động lực, Viện KH&CN Nhiệt lạnh, Viện Vật lý Kỹ thuật tại bàn 2 – Phòng 103 – C1
3- Viện Kỹ thuật hóa học, Viện Kinh tế và Quản lý, Viện Ngoại ngữ, Viện CN Sinh học & CN Thực phẩm, Viện KH&CN Môi trường tại bàn 8 – Phòng 104 – C1
Lưu ý:
Lớp trưởng lên nhận thẻ và trả thẻ cho sinh viên trong lớp. Sinh viên sau khi nhận thẻ BHYT kiểm tra ngay các thông tin in trên thẻ: họ tên, ngày tháng năm sinh và giới tính. Nếu có sai sót sinh viên trực tiếp lên Phòng 104- C1 (gặp cô Kim Chi) để sửa thẻ.
Do cơ quan Bảo hiểm Quận Hai Bà Trưng đang trong quá trình xử lý mã số bảo hiểm xã hội bị trùng lặp nên hiện còn một số sinh viên chưa có thẻ. Nhà trường đang phối hợp chặt chẽ với cơ quan Bảo hiểm để xử lý dữ liệu sớm trả thẻ cho các em.
Trường hợp SV SV đã đóng tiền mua BHYT nhưng chưa có thẻ, nếu SV bị ốm đột xuất thì liên hệ ngay với Phòng CTSV để được hỗ trợ thủ tục làm thẻ BHYT để đảm bảo quyền lợi khám chữa bệnh.
Mọi thắc mắc sinh viên liên hệ số điện thoại: 024. 38693108 (gặp cô Kim Chi).
Nguồn: Công tác Sinh viên ĐHBK Hà Nội')
SET IDENTITY_INSERT [dbo].[contactdb] OFF
SET IDENTITY_INSERT [dbo].[orderdb] ON 

INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (1, 12, CAST(N'2019-12-10T07:58:51.810' AS DateTime), N'blah', 7060000, 1)
INSERT [dbo].[orderdb] ([ID], [PRODUCT_ID], [CREATED_TIME], [ADDRESS], [PRICE], [QUANTITY]) VALUES (2, 12, CAST(N'2019-12-10T08:59:02.447' AS DateTime), N'blah', 7060000, 1)
SET IDENTITY_INSERT [dbo].[orderdb] OFF
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (10, N'Seiko', N'https://www.seikowatches.com/')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (11, N'Doxa', N'https://doxawatches.com/')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (12, N'Fouetté', N'https://www.fouette.co/')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (13, N'Tissot', N'https://www.tissotwatches.com/')
INSERT [dbo].[producerdb] ([ID], [NAME], [WEBSITE]) VALUES (14, N'Orient ', N'https://www.orient-watch.com/')
SET IDENTITY_INSERT [dbo].[productdb] ON 

INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (12, N'Seiko SRPD51K1', N'7060000', 10, 98, N'Mẫu Seiko SRPD51K1 nổi bật với vẻ ngoài dày dặn với phẩn vỏ máy kim loại loại mạ bạc độ dày 13mm, các chấm tròn trắng dạ quang với thiết kế to bản nổi bật trên mặt số xanh.', N'/dw/1_SRPD51K1-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (13, N'Doxa nam D157KWH', N'16610000', 11, 200, N'Đồng hồ Doxa nam D157KWH kiểu dáng 2 kim đơn giản cùng với 8 viên kim cương đính trên mặt số size 39mm tạo điểm nhấn nổi bật sang trọng cùng với vỏ máy mạ vàng.', N'/dw/2_D157KWH-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (14, N'Fouetté OR-1', N'15500000', 12, 300, N'Mẫu Fouetté OR-1 mang trên mình một thiết kế độc đáo khắc họa lên hình ảnh một vũ công ba lê chuyên nghiệp đang trình diễn trên nền mặt số được đính kèm các viên kim cương tạo nên một vẻ đẹp đầy cuốn hút dành cho phái đẹp.', N'/dw/2_OR-1-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (15, N'Fouetté OR-5', N'15500000', 12, 300, N'Mẫu đồng hồ Fouetté OR-5 mang trên mình một thiết kế độc đáo khắc họa lên hình ảnh một vũ công ba lê chuyên nghiệp đang trình diễn trên nền mặt số được đính kèm các viên kim cương tạo nên một vẻ đẹp đầy cuốn hút dành cho phái đẹp
', N'/dw/3_OR-5-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (16, N'Doxa D187RIY ', N'16500000', 11, 200, N'Một thiết kế mang phong cách lịch lãm nam tính đến từ mẫu Doxa phiên bản giới hạn chỉ 500 chiếc trên toàn thế giới D187RIY, sang trọng tinh tế với phần vạch số mỏng được vàng hồng thời trang trước mặt kính Sapphire
', N'/dw/12_D187RIY-2-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (17, N'Doxa D220RSV', N'39750000', 11, 200, N'Mang đến một vẻ giản dị của chiếc đồng hồ 3 kim Doxa D220RSV với phiên bản vàng hồng trẻ trung, ẩn bên dưới mặt kính Sapphire mặt số được đính kèm các viên kim cương chứa đựng sự tinh tế đầy quyền lực cho phái mạnh.
', N'/dw/16_D220RSV-699x699.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (18, N'Tissot T035.617.16.031.00', N'14560000', 13, 100, N'Đồng hồ T035.617.16.031.00 cho thiết kế cổ điển qua chi tiết dây đeo bằng da màu nâu, mang tính hiện đại thông qua mặt đồng hồ dáng thể thao mạnh mẽ, niềng kim loại đem cảm giác chắc chắn.
', N'/dw/20_T035.617.16.031.00-399x399.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (19, N'Tissot T063.610.36.038.00', N'10000000', 13, 100, N'Đồng hồ Tissot T063.610.36.038.00 với mặt đồng hồ được làm bằng kính Sapphire chống xước, kim chỉ, gạch số , niềng được mạ vàng, dây da nâu, mang đến cho phái mạnh sự sang trọng, lịch lãm.
', N'/dw/40_T063.610.36.038.00.jpg')
INSERT [dbo].[productdb] ([ID], [NAME], [PRICE], [PRODUCER_ID], [STOCK_NUMBER], [DESCRIPTION], [IMAGE]) VALUES (20, N'Orient SUNE5005W0', N'254000', 14, 200, N'Mẫu đồng hồ Orient SUNE5005W0 mang đến một vẻ ngoài giản dị với kiểu dáng 3 kim cùng các chi tiết tạo hình mỏng của sự tinh tế, và không kém cạnh ấn tượng nam tính cùng với khả năng chịu nước lên đến 10ATM.
', N'/dw/43_SUNE5005W0-2-699x699.jpg')
SET IDENTITY_INSERT [dbo].[productdb] OFF
SET IDENTITY_INSERT [dbo].[userdb] ON 

INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (1, N'Moon', N'0912345678', N'moon@gmail.com', N'admin1', N'ROLE_ADMIN', N'$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda', N'$2a$10$/a4Ilf4Ml.I.QXm1.OXKEOedBC.2cHaKTmve1X3nYOw4Crx7dhAda')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (2, N'Phong Ha', N'06969696969', N'lol@lol.com', N'admin2', N'ROLE_USER ', N'$2a$10$1qqYOonQeHRoPXIxUaMi4.SgbVYeXLxT.zypwZ.GGUAStRFzhVMEm', N'$2a$10$T.mmPbx4O6Fes3Xve7WI4uzfLzrlUbS9TVml1GIMcCqKRbEIbAVK.')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (3, N'Test Name 1', N'011111111111', N'test1@test.com', N'user1', N'ROLE_USER ', N'$2a$10$yZLLDORTrNk1yV0yLvbjF.f4CxoEmb94NLSgVEUcBLBWEkblB9wju', N'$2a$10$yy/PyJpcRQJ0sxksbDlQUO2UhWI58WK2IFDl0sHpO9sgUDB1/7GLK')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (4, N'Test Name 2', N'02222222222', N'test2@lol.com', N'user2', N'ROLE_USER ', N'$2a$10$T1DgPI7g5iyV2ZvLzhOahOa1tWRfPnaE6pFsuDi.4dS2cpk7UT.mW', N'$2a$10$ou369KLzuKw0rrfQgQg12eSa0G.c1yOo/5D1Ack05yKVsCaB4qUEe')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (5, N'Test Name 3', N'02222222223', N'test3@lol.com', N'user3', N'ROLE_USER ', N'$2a$10$./7/a.t8KS1.mTHIvhKm6.HTjZiE5dS92qezaYXtZxeFL5CokhfdC', N'$2a$10$iGNAGF0mwUPu8cjO.dW5kOxsIzymjbdWXaMtGEbM2S68BEOsoGtYi')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (6, N'Test Name 4', N'02222222224', N'test4@lol.com', N'user4', N'ROLE_USER ', N'$2a$10$i0tjEiGzNGJQjg/co71VWOVglrBLs5/C29NTaux7VHuz.zzOh..gq', N'$2a$10$nkIcPlGRZ7523yMD./yhWu9xE5ks1pYMK3kT13OCSES1PG0twWVU.')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (9, N'blah', N'2222222', N'blah@gmail.com', N'user6', N'ROLE_USER ', N'$2a$10$YVKtBPMCXUKXG4VAExfisub2FGE3u/n.HkusQ60o5G/FkQqCMbl/u', N'$2a$10$GAF4NJF8u3EIw8gLYCsseus9f8meISg86PPx4bL2IRAkc8Eim8QxS')
INSERT [dbo].[userdb] ([ID], [FULLNAME], [PHONE], [EMAIL], [USERNAME], [ROLE], [PASSWORD], [CPASSWORD]) VALUES (8, N'Sun', N'08123456789', N'sun@gmail.com', N'sun', N'ROLE_USER ', N'$2a$10$kQ/DHeEAgCIwKtzMYIc7NulBL0YV4tKEJnr9UUes4kK.tVdIPxPui', N'$2a$10$T.RyX4uuUhbAQpP/P6Z2je6t4HzH/7YP.N9dx91RiWhIMw5ji302y')
SET IDENTITY_INSERT [dbo].[userdb] OFF
ALTER TABLE [dbo].[userdb] ADD  DEFAULT ('ROLE_USER ') FOR [ROLE]
GO
USE [master]
GO
ALTER DATABASE [WebDongHoDB] SET  READ_WRITE 
GO
