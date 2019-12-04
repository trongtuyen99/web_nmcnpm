CREATE DATABASE WebDongHoDB
GO
USE [WebDongHoDB]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 11/5/2019 12:47:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[maDH] [int] IDENTITY(1,1) NOT NULL,
	[maND] [int] NULL,
	[maSP] [int] NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[sdt] [varchar](15) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[yeuCau] [nvarchar](200) NULL,
	[thoiGian] [datetime] NOT NULL,
	[trangThai] [varchar](20) NOT NULL,
	[nguoiCapNhat] [int] NULL,
	[ngayCapNhatCuoi] [datetime] NULL,
 CONSTRAINT [PK_donhang] PRIMARY KEY CLUSTERED 
(
	[maDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 11/5/2019 12:47:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userdb](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [varchar](15) NOT NULL,
	[PASSWORD] [char](60) NOT NULL,
	[FULLNAME] [nvarchar](50) NOT NULL,
	[PHONE] [varchar](15) NOT NULL,
	[EMAIL] [varchar](50) NOT NULL,
	[quyenTruyCap] [char](10) NOT NULL,
 CONSTRAINT [PK_nguoidung] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaSanXuat]    Script Date: 11/5/2019 12:47:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaSanXuat](
	[maNSX] [int] IDENTITY(1,1) NOT NULL,
	[tenNsx] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[sdt] [varchar](15) NOT NULL,
	[website] [varchar](50) NOT NULL,
	[logo] [varchar](50) NOT NULL,
 CONSTRAINT [PK_nhasanxuat] PRIMARY KEY CLUSTERED 
(
	[maNSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanHoi]    Script Date: 11/5/2019 12:47:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanHoi](
	[maPH] [int] IDENTITY(1,1) NOT NULL,
	[maND] [int] NOT NULL,
	[noiDung] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_phanhoi] PRIMARY KEY CLUSTERED 
(
	[maPH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/5/2019 12:47:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [int] NOT NULL,
	[maNSX] [int] NOT NULL,
	[tenSanPham] [nvarchar](100) NOT NULL,
	[donGia] [varchar](20) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thongTin] [nvarchar](500) NOT NULL,
	[hinhAnh] [varchar](50) NOT NULL,
	[nguoiCapNhat] [int] NULL,
	[ngayCapNhatCuoi] [datetime] NULL,
	[nguoiTao] [int] NOT NULL,
	[ngayTao] [datetime] NOT NULL,
 CONSTRAINT [PK_sanpham] PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_donhang_nguoidung] FOREIGN KEY([maND])
REFERENCES [dbo].[NguoiDung] ([maND])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_donhang_nguoidung]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_NguoiDung1] FOREIGN KEY([nguoiCapNhat])
REFERENCES [dbo].[NguoiDung] ([maND])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_NguoiDung1]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_donhang_sanpham] FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_donhang_sanpham]
GO
ALTER TABLE [dbo].[PhanHoi]  WITH CHECK ADD  CONSTRAINT [FK_phanhoi_nguoidung] FOREIGN KEY([maND])
REFERENCES [dbo].[NguoiDung] ([maND])
GO
ALTER TABLE [dbo].[PhanHoi] CHECK CONSTRAINT [FK_phanhoi_nguoidung]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NguoiDung] FOREIGN KEY([nguoiCapNhat])
REFERENCES [dbo].[NguoiDung] ([maND])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NguoiDung]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NguoiDung1] FOREIGN KEY([nguoiTao])
REFERENCES [dbo].[NguoiDung] ([maND])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NguoiDung1]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_sanpham_nhasanxuat] FOREIGN KEY([maNSX])
REFERENCES [dbo].[NhaSanXuat] ([maNSX])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_sanpham_nhasanxuat]
GO


/* INSERT table NguoiDung */
--INSERT [dbo].[NguoiDung] ([tenDangNhap], [matKhau], [hoTen], [sdt], [email], [quyenTruyCap]) VALUES (N'admin1', N'$2a$10$ftsOC6mTM916hBIRdbtRHOa88WdjQxqhhpYX55GJTY3oJUEMjAfAW', N'Admin 1', N'091234567', N'admin1@mail.com', N'ROLE_ADMIN')
--INSERT [dbo].[NguoiDung] ([tenDangNhap], [matKhau], [hoTen], [sdt], [email], [quyenTruyCap]) VALUES (N'admin2', N'$2a$10$ftsOC6mTM916hBIRdbtRHOa88WdjQxqhhpYX55GJTY3oJUEMjAfAW', N'Admin 2', N'091765432', N'admin2@mail.com', N'ROLE_ADMIN')
--INSERT [dbo].[NguoiDung] ([tenDangNhap], [matKhau], [hoTen], [sdt], [email], [quyenTruyCap]) VALUES (N'user1', N'$2a$10$b/OuRTh/omtLXWWInfm.KOwTEJA2qQkN3/ShsJ6Z.vu.RrZhxVv76', N'User 1', N'097654321', N'user1@mail.com', N'ROLE_USER ')
--INSERT [dbo].[NguoiDung] ([tenDangNhap], [matKhau], [hoTen], [sdt], [email], [quyenTruyCap]) VALUES (N'user2', N'$2a$10$b/OuRTh/omtLXWWInfm.KOwTEJA2qQkN3/ShsJ6Z.vu.RrZhxVv76', N'User 2 ', N'097123456', N'user2@mail.com', N'ROLE_USER ')


CREATE TABLE contactdb(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	NAME NVARCHAR(20),
	EMAIL NVARCHAR(20),
	MESSAGE NTEXT
)