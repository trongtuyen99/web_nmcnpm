USE [WebDongHoDB]
GO
/****** Object:  Table [dbo].[contactdb]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[nguoidung]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[orderdb]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[producerdb]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[productdb]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[sanpham]    Script Date: 12/9/2019 12:02:52 AM ******/
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
/****** Object:  Table [dbo].[userdb]    Script Date: 12/9/2019 12:02:52 AM ******/
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
ALTER TABLE [dbo].[orderdb] ADD  CONSTRAINT [DF__orderdb__CREATED__70DDC3D8]  DEFAULT (getdate()) FOR [CREATED_TIME]
GO
ALTER TABLE [dbo].[userdb] ADD  DEFAULT ('ROLE_USER ') FOR [ROLE]
GO
