USE [master]
GO
/****** Object:  Database [UserBook]    Script Date: 21/8/2022 8:09:11 PM ******/
CREATE DATABASE [UserBook]
GO
ALTER DATABASE [UserBook] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [UserBook].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [UserBook] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [UserBook] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [UserBook] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [UserBook] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [UserBook] SET ARITHABORT OFF 
GO
ALTER DATABASE [UserBook] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [UserBook] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [UserBook] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [UserBook] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [UserBook] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [UserBook] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [UserBook] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [UserBook] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [UserBook] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [UserBook] SET  DISABLE_BROKER 
GO
ALTER DATABASE [UserBook] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [UserBook] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [UserBook] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [UserBook] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [UserBook] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [UserBook] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [UserBook] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [UserBook] SET RECOVERY FULL 
GO
ALTER DATABASE [UserBook] SET  MULTI_USER 
GO
ALTER DATABASE [UserBook] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [UserBook] SET DB_CHAINING OFF 
GO
ALTER DATABASE [UserBook] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [UserBook] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [UserBook] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [UserBook] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'UserBook', N'ON'
GO
ALTER DATABASE [UserBook] SET QUERY_STORE = OFF
GO
USE [UserBook]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 21/8/2022 8:09:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[username] [varchar](50) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[isAdmin] [bit] NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Registration] ([username], [lastname], [password], [isAdmin]) VALUES (N'admin', N'toan pro', N'1', 0)
GO
INSERT [dbo].[Registration] ([username], [lastname], [password], [isAdmin]) VALUES (N'tri', N'tri', N'1', 1)
GO
INSERT [dbo].[Registration] ([username], [lastname], [password], [isAdmin]) VALUES (N'hao', N'hao vip', N'1', 1)
GO
INSERT [dbo].[Registration] ([username], [lastname], [password], [isAdmin]) VALUES (N'toan', N'toan pro', N'1', 1)
GO
INSERT [dbo].[Registration] ([username], [lastname], [password], [isAdmin]) VALUES (N'long', N'long dragon', N'1', 0)
GO
USE [master]
GO
ALTER DATABASE [UserBook] SET  READ_WRITE 
GO
