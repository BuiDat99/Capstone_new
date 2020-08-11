-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: heathyfix
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `post_Id` int(11) NOT NULL,
  `comment_Date` varchar(255) CHARACTER SET utf8 NOT NULL,
  `comment_Content` varchar(13000) CHARACTER SET utf8 NOT NULL,
  `vote` varchar(50) DEFAULT NULL,
  `react` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`comment_Id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_Id`),
  KEY `FK7jok1s6lywoh0srylq8lt7tmn` (`post_Id`),
  CONSTRAINT `FK7jok1s6lywoh0srylq8lt7tmn` FOREIGN KEY (`post_Id`) REFERENCES `posts` (`post_Id`),
  CONSTRAINT `FK8cuvfh5pfccjrr3qfp54277mr` FOREIGN KEY (`post_Id`) REFERENCES `role` (`role_Id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `fk_Comment_postId` FOREIGN KEY (`post_Id`) REFERENCES `posts` (`post_Id`),
  CONSTRAINT `fk_Comment_userID` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,2,1,'23-5-2012','Patrick Blennerhassett bối rối khi mọi người xung quanh đều nhâm nhi ly rượu còn mình thì không, cảm thấy mất tự tin không giống như trước đây. Cảm giác này xảy ra với Patrick trong thời gian đầu ngừng uống rượu. Vài tuần sau anh quen dần, có thể trò chuyện, tương tác với mọi người tự nhiên hơn mà không cần ly rượu trên tay. Patrick là một phóng viên thể thao','5','haha'),(2,2,1,'30 thg 7','312312231',NULL,NULL),(3,2,1,'30 thg 7','datdzvl',NULL,NULL),(4,2,1,'30 thg 7','hehehe\r\n',NULL,NULL),(5,2,1,'30 thg 7','',NULL,NULL),(6,2,1,'30 thg 7','dsaadsdsdsdadassd',NULL,NULL),(7,2,1,'30 thg 7','dsaadsdsdsdadassdassassa',NULL,NULL),(8,2,2,'30 thg 7','123233223',NULL,NULL),(9,2,1,'30 thg 7','wqwqeqweqeweqwqewewq',NULL,NULL),(10,2,1,'30 thg 7','1212',NULL,NULL),(11,2,1,'30 thg 7','123',NULL,NULL),(12,2,1,'30 thg 7','12',NULL,NULL),(13,2,1,'30 thg 7','12',NULL,NULL),(14,2,1,'30 thg 7','1',NULL,NULL),(15,2,1,'30 thg 7','123232',NULL,NULL),(16,2,1,'30 thg 7','12331',NULL,NULL),(17,6,1,'30 thg 7','datz123',NULL,NULL),(18,2,1,'30 thg 7','dssdaasd',NULL,NULL),(19,2,1,'03 thg 8','12312123321312',NULL,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtag_standard`
--

DROP TABLE IF EXISTS `hashtag_standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hashtag_standard` (
  `hs_Id` int(11) NOT NULL AUTO_INCREMENT,
  `hashtag_Code` varchar(50) NOT NULL,
  `hashtag_Content` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`hs_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtag_standard`
--

LOCK TABLES `hashtag_standard` WRITE;
/*!40000 ALTER TABLE `hashtag_standard` DISABLE KEYS */;
/*!40000 ALTER TABLE `hashtag_standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `menu_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `hashtag` varchar(50) NOT NULL,
  `menu_Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `menu_Description` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`menu_Id`),
  KEY `FKscu4x35gdwk4gx29dmk8lnilc` (`user_Id`),
  CONSTRAINT `FKscu4x35gdwk4gx29dmk8lnilc` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `fk_Menu_userId` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_product`
--

DROP TABLE IF EXISTS `menu_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_product` (
  `pm_Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_Id` int(11) NOT NULL,
  `menu_Id` int(11) NOT NULL,
  PRIMARY KEY (`pm_Id`),
  KEY `FK755dtrv1g87t4m13bht0y5c7m` (`menu_Id`),
  KEY `FKo3nngibe84i11ce290eblljw6` (`product_Id`),
  CONSTRAINT `FK755dtrv1g87t4m13bht0y5c7m` FOREIGN KEY (`menu_Id`) REFERENCES `menu` (`menu_Id`),
  CONSTRAINT `FKo3nngibe84i11ce290eblljw6` FOREIGN KEY (`product_Id`) REFERENCES `product` (`product_Id`),
  CONSTRAINT `fk_Menu_Product_menuId` FOREIGN KEY (`menu_Id`) REFERENCES `menu` (`menu_Id`),
  CONSTRAINT `fk_Menu_Product_productId` FOREIGN KEY (`product_Id`) REFERENCES `product` (`product_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_product`
--

LOCK TABLES `menu_product` WRITE;
/*!40000 ALTER TABLE `menu_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `post_Id` int(11) NOT NULL AUTO_INCREMENT,
  `category_Id` int(11) NOT NULL,
  `user_Id` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL,
  `image_Title` varchar(50) CHARACTER SET utf8 NOT NULL,
  `poster` varchar(255) CHARACTER SET utf8 NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 NOT NULL,
  `short_Description` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `detail_Descripton` varchar(13000) CHARACTER SET utf8 NOT NULL,
  `source` varchar(255) CHARACTER SET utf8 NOT NULL,
  `hashtag` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `modified_Date` varchar(255) CHARACTER SET utf8 NOT NULL,
  `creation_Date` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`post_Id`),
  KEY `FKam8ar6luvp8afhfu20gfsydo9` (`user_Id`),
  KEY `FKlkeae4jn0n7godhrsvlbjtygm` (`category_Id`),
  CONSTRAINT `FKam8ar6luvp8afhfu20gfsydo9` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `FKlkeae4jn0n7godhrsvlbjtygm` FOREIGN KEY (`category_Id`) REFERENCES `posts_category` (`category_Id`),
  CONSTRAINT `fk_Posts_categoryId` FOREIGN KEY (`category_Id`) REFERENCES `posts_category` (`category_Id`),
  CONSTRAINT `fk_Posts_userId` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,2,1,'Ảnh hưởng của chế độ ăn uống đến sức khỏe','ruou.jpg','Lê Hằng (Theo SCMP) ','Lê Hằng (Theo SCMP) ','Patrick Blennerhassett bối rối khi mọi người xung quanh đều  nhâm nhi ly rượu còn mình thì không, cảm thấy mất tự tin không giống như trước đây. ','<p>&quot;Patrick Blennerhassett bối rối khi mọi người xung quanh đều nh&acirc;m nhi ly rượu c&ograve;n m&igrave;nh th&igrave; kh&ocirc;ng, cảm thấy mất tự tin kh&ocirc;ng giống như trước đ&acirc;y. Cảm gi&aacute;c n&agrave;y xảy ra với Patrick trong thời gian đầu ngừng uống rượu. V&agrave;i tuần sau anh quen dần, c&oacute; thể tr&ograve; chuyện, tương t&aacute;c với mọi người tự nhi&ecirc;n hơn m&agrave; kh&ocirc;ng cần ly rượu tr&ecirc;n tay. Patrick l&agrave; một ph&oacute;ng vi&ecirc;n thể thao. Đầu th&aacute;ng 5, anh quyết định dừng uống rượu một thời gian để chuẩn bị tốt nhất cho giải chạy marathon tại Hong Kong v&agrave;o th&aacute;ng 2 năm sau. Những thay đổi đầu ti&ecirc;n anh cảm nhận được sau khi ngừng uống rượu l&agrave; thay đổi về mặt thể chất như ngủ ngon giấc, da khỏe hơn, c&acirc;n nặng được kiểm so&aacute;t. Anh cũng cảm thấy c&oacute; nhiều năng lượng hơn trong suốt cả ng&agrave;y. Điều khiến Patrick bất ngờ hơn cả l&agrave; những thay đổi t&iacute;ch cực về mặt tinh thần. Những thay đổi t&acirc;m l&yacute; của Patrick tuy nhỏ nhưng c&oacute; &yacute; nghĩa rất lớn. Sự tỉnh t&aacute;o đ&atilde; thay đổi to&agrave;n bộ con người Patrick, anh l&agrave;m việc năng suất hơn, kh&ocirc;ng c&ograve;n đắm ch&igrave;m trong những suy nghĩ ti&ecirc;u cực, tự thương hại bản th&acirc;n như trước kia. Anh n&oacute;i: &quot;&quot;T&ocirc;i vui hơn mỗi ng&agrave;y&quot;&quot;. Patrick n&oacute;i rằng trước đ&acirc;y t&igrave;m đến rượu bia để giải tỏa mỗi khi lo lắng, căng thẳng. Sau hơn 5 th&aacute;ng kh&ocirc;ng uống rượu, anh nhận thấy đồ uống c&oacute; cồn chỉ đơn giản khiến m&igrave;nh tạm dừng sự căng thẳng. Những suy nghĩ ti&ecirc;u cực kh&ocirc;ng được giải quyết triệt để, vẫn lu&ocirc;n quanh quẩn trong t&acirc;m tr&iacute; anh. B&acirc;y giờ anh đ&atilde; biết c&aacute;ch đối mặt, giải quyết những suy nghĩ ti&ecirc;u cực như mối quan hệ cũ, c&uacute; sốc từng rất kh&oacute; tho&aacute;t ra. Patrick cũng lấy lại được sự c&acirc;n bằng t&acirc;m l&yacute;. &quot;&quot;Khi kh&ocirc;ng c&ograve;n uống rượu, c&oacute; cảm gi&aacute;c như ai đ&oacute; đ&atilde; d&ugrave;ng giấy nh&aacute;m đ&aacute;nh v&agrave;o những bộ phận kh&ocirc; nh&aacute;m nhất trong cơ thể t&ocirc;i&quot;&quot;, Patrick chia sẻ. &quot;&quot;Tất nhi&ecirc;n, t&ocirc;i vẫn chưa thể l&agrave; một người ho&agrave;n hảo v&igrave; ngưng uống rượu. Nhưng chuyển từ say xỉn sang trạng th&aacute;i tỉnh t&aacute;o c&oacute; n&eacute;t g&igrave; đ&oacute; giống như mở được mật m&atilde; một tr&ograve; chơi điện tử&quot;&quot;. Anh th&uacute; nhận kh&ocirc;ng biết c&oacute; thể duy tr&igrave; quyết t&acirc;m ngừng uống rượu trong bao l&acirc;u. Song, với t&igrave;nh trạng mới của bản th&acirc;n, anh đang c&acirc;n nhắc những lợi &iacute;ch cơ thể nhận được nếu ngừng uống rượu m&atilde;i. &quot;&quot;T&ocirc;i sẽ quyết định ngay sau khi kết th&uacute;c giải marathon v&agrave;o th&aacute;ng 2 năm sau. Rất c&oacute; thể cốc rượu m&agrave; t&ocirc;i uống trước th&aacute;ng 5 sẽ l&agrave; cốc rượu cuối c&ugrave;ng trong đời&quot;&quot;, Patrick n&oacute;i. Theo Viện Quốc gia về Lạm dụng Ma t&uacute;y v&agrave; Viện quốc gia về Lạm dụng Rượu v&agrave; Nghiện rượu Mỹ, chỉ uống một lượng &iacute;t rượu, sức khỏe tinh thần con người cũng phải chịu những ảnh hưởng nhất định từ t&aacute;c động của cồn. N&oacute;i một c&aacute;ch đơn giản, n&atilde;o bắt đầu th&iacute;ch nghi với sự hiện diện của cồn v&agrave; tự điều chỉnh c&aacute;c tế b&agrave;o thần kinh, từ đ&oacute; t&aacute;c động ti&ecirc;u cực đến cảm x&uacute;c, động lực, lối tư duy v&agrave; khả năng ra quyết định.&quot;</p>\r\n\r\n<p><img alt=\"123\" src=\"https://cdnmedia.baotintuc.vn/Upload/DmtgOUlHWBO5POIHzIwr1A/files/2020/07/27/phun-thuoc-khu-khuan-270720.jpg\" style=\"height:457px; width:665px\" /></p>\r\n','https://vnexpress.net/trai-nghiem-5-thang-ngung-uong-ruou-cua-mot-chang-trai-3997918.html','12','12','28 thg 7 2020 22:55','12'),(2,6,NULL,'Chế độ ăn uống ảnh hưởng đến thời điểm dậy thì của trẻ','sinhli.png','Nắng Mai','Nắng Mai','Thực tế, trẻ bước vào giai đoạn phát triển nào thì chế độ dinh dưỡng cần phải phù hợp với giai đoạn phát triển đó. Vì vậy để trẻ phát triển đúng với độ tuổi, cần xây dựng một chế độ ăn uống, sinh hoạt hợp lý và kiên trì điều chỉnh để hoãn tình trạng dậy thì sớm ở trẻ xảy ra.','<p>&quot;Bản chất sữa c&ocirc;ng thức tr&ecirc;n thị trường hiện nay c&oacute; rất nhiều loại tuy nhi&ecirc;n đa số đều l&agrave; c&aacute;c loại từ sữa b&ograve;. C&aacute;c hormone tăng trưởng trong sữa c&oacute; cấu tạo ph&ugrave; hợp đối với sự ph&aacute;t triển của b&ograve;. Do đ&oacute;, khi trẻ uống sữa c&ocirc;ng thức th&igrave; hormone tăng trưởng kh&ocirc;ng c&oacute; t&aacute;c dụng.<br />\r\nV&igrave; thế, điều n&agrave;y l&yacute; giải rằng sữa c&ocirc;ng thức hay sữa tươi đều kh&ocirc;ng phải nguy&ecirc;n nh&acirc;n khiến trẻ dậy th&igrave; sớm n&ecirc;n c&aacute;c bậc phụ huynh c&oacute; thể y&ecirc;n t&acirc;m cho trẻ sử dụng sữa m&agrave; kh&ocirc;ng c&ograve;n lo ngại.<br />\r\nĐối với trẻ giai đoạn dậy th&igrave; của trẻ cần c&oacute; chế độ dinh dưỡng hợp l&yacute; gi&uacute;p tăng cường vận động, gi&uacute;p trẻ r&egrave;n luyện sức khỏe v&agrave; c&oacute; lợi &iacute;ch cho việc trau dồi kỹ năng sống của trẻ về sau. Ngo&agrave;i ra việc tu&acirc;n thủ những liệu ph&aacute;p điều trị sẽ gi&uacute;p trẻ cải thiện c&aacute;c triệu chứng v&agrave; ổn định về mặt t&acirc;m l&yacute; để trẻ tiếp nhận qu&aacute; tr&igrave;nh dậy th&igrave; một c&aacute;ch chủ động.&quot;</p>\r\n','https://suckhoehangngay.vn/che-do-an-uong-anh-huong-den-thoi-diem-day-thi-cua-tre-20200514131450048.htm','132','13','28 thg 7 2020 19:40','22 thg 7');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts_category`
--

DROP TABLE IF EXISTS `posts_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts_category` (
  `category_Id` int(11) NOT NULL AUTO_INCREMENT,
  `category_Name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`category_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts_category`
--

LOCK TABLES `posts_category` WRITE;
/*!40000 ALTER TABLE `posts_category` DISABLE KEYS */;
INSERT INTO `posts_category` VALUES (1,'Sức khỏe'),(2,'Sinh lí'),(3,'Giáo dục'),(4,'Thể dục'),(5,'Game'),(6,'Hack');
/*!40000 ALTER TABLE `posts_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_Name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `product_Description` varchar(500) CHARACTER SET utf8 NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`product_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'1234','<p>122</p>\n','https://i.imgur.com/9yYAfiC.png'),(2,'1234','<p>122</p>\n','https://i.imgur.com/IItnNMh.png'),(3,'2121','<p>1221</p>\n','https://i.imgur.com/d235F4G.png'),(4,'2112','<p>1221</p>\n','https://i.imgur.com/G6RNFxn.jpeg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_resource`
--

DROP TABLE IF EXISTS `product_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_resource` (
  `pr_Id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_Id` int(11) NOT NULL,
  `product_Id` int(11) NOT NULL,
  `kcal1g` float NOT NULL,
  PRIMARY KEY (`pr_Id`),
  KEY `FKg49757mhnxwngowyx20ekon4d` (`product_Id`),
  KEY `FKq617f87uof594vknpdcru8i4c` (`resource_Id`),
  CONSTRAINT `FKg49757mhnxwngowyx20ekon4d` FOREIGN KEY (`product_Id`) REFERENCES `product` (`product_Id`),
  CONSTRAINT `FKq617f87uof594vknpdcru8i4c` FOREIGN KEY (`resource_Id`) REFERENCES `resources` (`resource_Id`),
  CONSTRAINT `fk_Product_Resource_productId` FOREIGN KEY (`product_Id`) REFERENCES `product` (`product_Id`),
  CONSTRAINT `fk_Product_Resource_resourceId` FOREIGN KEY (`resource_Id`) REFERENCES `resources` (`resource_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_resource`
--

LOCK TABLES `product_resource` WRITE;
/*!40000 ALTER TABLE `product_resource` DISABLE KEYS */;
INSERT INTO `product_resource` VALUES (1,8,1,3),(2,8,2,3),(3,10,3,1),(4,11,3,1),(6,4,4,2),(7,5,4,2);
/*!40000 ALTER TABLE `product_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_category`
--

DROP TABLE IF EXISTS `resource_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_category` (
  `categery_Id` int(11) NOT NULL AUTO_INCREMENT,
  `category_Name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`categery_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_category`
--

LOCK TABLES `resource_category` WRITE;
/*!40000 ALTER TABLE `resource_category` DISABLE KEYS */;
INSERT INTO `resource_category` VALUES (1,'Cháo, phở, miến, mì ăn liền'),(2,'Củ giàu tinh bột'),(3,'Dầu, mỡ, bơ'),(4,'Đồ hộp'),(5,'Đồ ngọt'),(6,'Gia vị, nước chấm'),(7,'Hạt giàu đạm và chất béo '),(8,'Ngũ cốc'),(9,'Nước giải khát'),(10,'Quả chín'),(11,'Rau và củ quả dùng làm rau'),(12,'Sữa'),(13,'Thịt'),(14,'Thủy hải sản'),(15,'Trứng');
/*!40000 ALTER TABLE `resource_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `resource_Id` int(11) NOT NULL AUTO_INCREMENT,
  `category_Id` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `resource_Name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `kcal1g` float NOT NULL,
  `resource_Description` varchar(1000) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`resource_Id`),
  KEY `FK9dfjxvno3woiph3vml9kc6plt` (`category_Id`),
  CONSTRAINT `FK9dfjxvno3woiph3vml9kc6plt` FOREIGN KEY (`category_Id`) REFERENCES `resource_category` (`categery_Id`),
  CONSTRAINT `fk_Resources_categoryId` FOREIGN KEY (`category_Id`) REFERENCES `resource_category` (`categery_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (1,2,'củ từ.jpg','Củ từ',0.92,'Củ từ là một món ăn thường ngày phổ biến với nhiều người. Tuy vậy củ từ có nhiều tác dụng cho sức khỏe và làm đẹp có thể ít người biết đến như kháng khuẩn, chống viêm, cải thiện tiêu hóa, giảm cân. Củ từ chứa rất nhiều các protein niêm dịch, ngoài ra còn chứa vitamin và các nguyên tố vi lượng. Tất cả các chất này có tác dụng ngăn cản sự tích tụ của cholesterol trong thành mạch máu, giảm thiểu nguy cơ mắc các bệnh về tim mạch, bệnh về huyết áp, nó còn giúp ổn định tinh thần.'),(2,2,'củ khoai lang.jpg','Khoai lang',1.19,'Khoai lang được ví như “thực phẩm vàng” là nhờ những tác dụng của khoai lang đối với sức khỏe con người như chống ung thư, cải thiện tiêu hóa, giảm cân an toàn, điều hòa huyết áp…'),(3,2,'củ khoai lang nghệ.jpg','Khoai lang nghệ',1.16,'Khoai lang mật(hay gọi là khoai lang nghệ) sau khi chế biến sẽ dẻo chứ khong bở, đặc biệt khi đã được phơi thì khoai càng dẻo và chảy nhiều mật, thịt khoai bên trong màu cam đậm, vị ngọt đặc trưng của mật khoai. Khoai lang mật khi chín có hương thơm rất dậy mùi. Vỏ khoai mỏng, có thể tự tách khỏi phần thịt khi được luộc kĩ và chảy mật dính tay.'),(4,2,'củ khoai môn.jpg','Khoai môn',1.09,'Khoai môn là một loại rau củ nhiệt đới được trồng ở nhiều quốc gia trên thế giới và được chế biến thành nhiều món ăn hấp dẫn trong thực đơn ẩm thực quốc tế. Khoai môn chứa nhiều chất dinh dưỡng tốt cho sức khỏe như chất xơ, mangan, vitamin E. Khoai môn chứa nhiều chất dinh dưỡng và đem lại nhiều lợi ích tuyệt vời cho sức khỏe.'),(5,2,'khoai tây chiên.jpg','Khoai tây chiên',5.25,'Khoai tây chiên là một trong số những món ăn vặt cực kì được yêu thích. Nhưng việc mua khoai tây chiên bên ngoài nhiều khi không tốt cho sức khỏe vì có lúc khoai tây bị chiên đi chiên lại rất nhiều lần. Vậy nên, làm được món khoai tây chiên ngon, giòn tại nhà bạn sẽ vừa có thêm một món ăn vặt hấp dẫn, an toàn mà còn tiết kiệm nữa.'),(6,2,'miến dong.jpg','Miến dong',3.32,'Miến dong sạch là một trong những đặc sản của vùng đất Cao Bằng.  Một trong những đặc điểm nổi bật của miến dong là: thơm, ngon, dai, mang một mùi vị đặc trưng có một không hai của bột dong. Sau khi chế biến bạn có thể để miến một thời gian mà không lo vấn đề miến bị sạn hay nát, bở.'),(7,3,'bơ.jpg','Bơ',7.56,'Bơ là một loại trái cây bổ dưỡng, tốt cho sức khỏe nhưng không phải ai cũng biết ăn bơ đúng cách. Bơ được các chuyên gia đánh giá rất cao vì giá trị dinh dưỡng mà chúng mang lại. Cụ thể, bơ chứa lượng vitamin dồi dào và đa dạng như vitamin A, D, E,&nbsp;B1, B2, B6, B5, C cùng các khoáng chất&nbsp;Sắt, Đồng, Kali, Kẽm, Mangan, Canxi, Magie, Natri, Selen,...Ngoài ra, lượng muối trong bơ thấp, trong khi chất xơ, hàm lượng lutein cao và carotenoid tự nhiên giúp đẹp da và sáng mắt. Chính vì vậy, đây là loại trái cây được nhiều người ưa chuộng, lựa chọn bổ sung cho thực đơn hàng ngày.'),(8,3,'dầu thực vật.jpg','Dầu thực vật',8.97,'Dầu thực vật là loại dầu được chiết xuất, chưng cất và tinh chế từ các loại thực vật có nhiều tinh dầu. Thành phần chính của dầu thực vật là các Axit béo không no, trạng thái lỏng ở nhiệt độ thường để cơ thể chúng ta dễ hấp thu. Điểm khác biệt giữa dầu thực vật và dầu động vật là hàm lượng Cholesterol - một chất gây hại đến sức khỏe tim mạch. Ở dầu thực vật, Cholesterol có liều lượng rất thấp không đáng kể và không có khả năng gây hại đến sức khỏe con người.'),(9,3,'mỡ lợn nước.jpg','Mỡ lợn nước',8.96,'Mỡ lợn giàu khoáng chất và vitamin tốt cho sức khỏe, không gây bệnh tim mạch và làm món ăn vị thơm, ngon hơn. Mỡ lợn chứa khoảng 40% chất béo bão hòa, khoảng 50% chất béo không bão hòa đơn và khoảng 10% chất béo không bão hòa đa.'),(10,4,'cá thu đóng hộp.jpg','Cá thu hộp',2.07,'Cá thu đóng hộp có hương vị ngon, và chất lượng an toàn. Được ướp gia vị thơm ngon và được nấu chín hoàn toàn.'),(11,4,'cá trích đóng hộp.jpg','Cá trích hộp',2.33,'Cá trích Seacrown đã được chế biến và đóng hộp tiện lợi, tiết kiệm thời gian chế biến cho các bà nội trợ.'),(12,4,'đậu phộng chiên.jpg','Đậu phộng chiên',6.8,'Ngăn ngừa rủi ro đột quỵ Đậu phộng là một nguồn giàu chất chống ô xy hóa và khoáng chất nên làm giảm nguy cơ đột quỵ và các vấn đề về tim khác. Chất tryptophan trong đậu phộng cũng chống lại chứng trầm cảm. Do đó đậu phộng có thể giúp bạn ngừa đột quỵ.'),(13,4,'mứt đu đủ.jpg','Mứt đu đủ',1.78,'Mứt đu đủ có thể dùng đãi khách trong dịp tết với hương vị thơm ngọt dịu nhẹ.'),(14,4,'mứt thơm.jpg','Mứt thơm',2.08,'Dứa cùng với nhiều loại trái cây khác rất bổ dưỡng với sức khỏe con người. Trong dứa không có cholesterol, lại giàu chất xơ, các enzym tiêu hóa, vitamin C, canxi và kali.'),(15,4,'nhãn hộp.jpg','Nhãn hộp',0.62,'Nhãn Đóng Hộp là loại nhãn ngâm siro, thường được sử dụng để pha chế các thức uống hoặc trong làm bánh ngọt.'),(16,4,'nước thơm.jpg','Nước thơm',0.39,'Tác dụng của nước ép dứa không chỉ là giải nhiệt hiệu quả mà còn có giảm cân vừa hiệu quả lại an toàn, đồng thời, bổ sung vitamin C và nhiều khoáng chất cần thiết khác cho cơ thể.'),(17,4,'thịt bò hộp.jpg','Thịt bò hộp',2.51,'Thịt bò hộp là một trong những sản phẩm đồ hộp thông dụng được sản xuất theo công nghệ hiện đại mang đến chất lượng cao cho người dùng.'),(18,4,'thịt gà hộp.jpg','Thịt gà hộp',2.73,'Thịt gà cung cấp lượng lớn protein, đây là nhóm chất chính tạo thành cấu trúc của tế bào và ảnh hưởng đến sự phát triển về cân nặng, chiều cao và trí não của con người.'),(19,4,'thịt heo hộp.jpg','Thịt heo hộp',3.44,'Thịt heo hộp là sản phẩm đã được nấu chín và tẩm ướp gia vị, rất tiện dụng và dễ ăn, giúp tiết kiệm thời gian khi nấu nướng. Bạn đọc cần lưu ý khi mua và sử dụng thịt heo hộp để đảm bảo an toàn vệ sinh thực phẩm.'),(20,4,'trái thơm hộp.jpg','Thơm hộp',0.56,'Dứa là trái cây nhiệt đới, giàu vitamin, enzyme và chất chống oxy hóa. Dứa có thể cung cấp đầy đủ chất dinh dưỡng, vitamin và khoáng chất.'),(21,4,'trái vải hộp.jpg','Vải hộp',0.6,'Sử dụng trái vải đóng hộp có sẵn pha trà với siro vải cho thêm đậm mùi và lắc đều là bạn đã có ngay một ly trà vải tươi ngon.'),(22,5,'bánh in chay.jpg','Bánh in chay',3.76,'Bánh trôi - bánh chay, xuất phát từ bánh Trung Quốc là hai loại bánh cổ truyền tại miền Bắc Việt Nam. Hai loại bánh này thường đi liền với nhau, phổ biến nhất trong dịp Tết Hàn Thực vào mùng 3 tháng 3 âm lịch hàng năm, còn gọi là \"ngày bánh trôi bánh chay\"'),(23,5,'bánh men.jpg','Bánh men',3.69,'Bánh men nhỏ xinh, trắng thơm, giòn tan ngay khi đưa vào miệng khiến gợi nhớ đến tuổi thơ của rất nhiều người'),(24,5,'bánh mì khô.jpg','Bánh mì khô',3.46,'Bánh mì đen hay bánh mì lúa mạch là một loại bánh mì được chế biến bằng những tỷ lệ khác nhau của bột mì từ hạt lúa mạch đen. Nó có thể được chế biến sao cho sáng màu hoặc tối màu, tùy thuộc vào các loại bột được sử dụng.'),(25,5,'bánh socola.jpg','Bánh sôcôla',4.49,'Bánh sô cô la hoặc sô cô la gâteau là một loại bánh có hương vị sô cô la tan chảy, bột ca cao hoặc cả hai.'),(26,5,'bánh thỏi.jpg','Bánh thỏi sôcôla',5.43,'Thanh sô-cô-la hay thỏi sô-cô-la là một loại bánh kẹo Sô-cô-la ở dạng thanh, trong thanh sô-cô-la có thể bao gồm một số hoặc tất cả các thành phần gồm ca cao, bơ ca cao, đường, sữa...'),(27,5,'đường cát trắng.jpg','Đường cát trắng',3.97,'Đường cát trắng có thể dùng để làm gia vị nấu ăn hàng ngày, nước đường cát trắng có thể chữa được hạ đường huyết. Ngoài ra nếu cho ít đường vào lọ hoa sẽ giúp nó tươi lâu hơn. Còn đường phèn do được tinh chế từ đường cát trắng, được loại bỏ hết tạp chất nên nó ít ngọt hơn, có vị thanh mát và giải nhiệt tốt hơn.'),(28,5,'kẹo café.jpg','Kẹo cà phê',3.78,'Viên kẹo 2 lớp với hương vị sữa thơm béo và cà phê đắng nhẹ, tuy đối lập mà hoà quyện, giúp bạn tỉnh táo hơn.'),(29,5,'kẹo đậu phộng.jpg','Kẹo đậu phộng',4.49,'Kẹo đậu phộng với hương vị thơm ngon, bùi béo vô cùng hấp dẫn là một trong những món kẹo ưa thích của khá nhiều người.'),(30,5,'kẹo dừa mềm.jpg','Kẹo dừa mềm',4.15,'Kẹo dừa là món kẹo thơm ngon, béo ngậy, là đặc sản nổi tiếng của tỉnh Bến Tre.'),(31,5,'kẹo ngậm bạc hà.jpg','Kẹo ngậm bạc hà',2.68,'Viên ngậm bạc hà Frisk Neo Peppermint 35g “xuất thân” từ hãng Kracie – một trong những thương hiệu nổi tiếng về mỹ phẩm, dược phẩm và thực phẩm tại Nhật Bản với lịch sử hơn 100 năm qua, kẹo 2 lớp màu siêu xinh kết hợp với vị bạc hà the mát cực kì cho cảm giác tươi mới không bao giờ quên được, đây là hương vị yêu thích nhất hiện nay trong series kẹo Frisk NEO.'),(32,5,'kẹo socola.jpg','Kẹo sôcôla',3.88,'Socola là hỗn hợp giữa bột ca cao và bơ ca cao, cho thêm đường, sữa, và một số phụ liệu, cuối cùng được đóng thành dạng thanh hay dạng viên.'),(33,5,'kẹo sữa.jpg','Kẹo sữa',3.9,'Kẹo sữa dành cho trẻ biếng ăn, biếng bú, không chịu hoặc không tỏ ra thích thú khi phải uống sữa.'),(34,6,'cari bột.jpg','Cari bột',2.83,'Giảm đau và viêm. Chất chống viêm của củ nghệ có trong bột cari chủ động làm giảm viêm khớp và suy thoái, cũng như các cơn đau liên quan đến các bệnh như viêm khớp dạng thấp.'),(35,6,'gừng tươi.jpg','Gừng tươi',0.25,'Chữa rối loạn tiêu hóa. Hợp chất Phenolic trong củ gừng được chứng minh rằng có khả năng làm giảm những triệu chứng rối loạn đường tiêu hóa như là đầy hơi, chướng bụng, táo bón.'),(36,6,'mắm tôm đặc.jpg','Mắm tôm đặc',0.73,'Mắm tôm thường có 3 dạng: đặc, sệt và lỏng.'),(37,6,'muối.jpg','Muối',0,'Muối biển có tác dụng giúp kiểm soát lượng đường trong máu.'),(38,6,'nghệ khô.jpg','Nghệ khô',3.6,'Tinh bột nghệ hỗ trợ ngăn ngừa ung thư Tinh bột nghệ chứa các chất chống oxi hóa giúp kháng virus, kháng nấm, ngăn ngừa sự phát triển của các tế bào xấu.'),(39,6,'nghệ tươi.jpg','Nghệ tươi',0.22,'Chất Curcumin trong nghệ tươi có công dụng kháng viêm, diệt khuẩn và làm liền vết viêm loét hiệu quả. Vậy nên, khi bạn uống nghệ tươi cùng với mật ong hàng ngày sẽ giảm bớt các triệu chứng và tăng hiệu quả chữa bệnh dạ dày như đau dạ dày, trào ngược dạ dày, viêm loét dạ dày…'),(40,6,'nước mắm.jpg','Nước mắm',0.28,'Nước mắm ích khí bổ huyết, bổ can thận, thông huyết mạch, lợi niệu, nhuận tràng. Dùng làm gia vị, khai vị trợ tiêu hóa. Dùng cho trường hợp trúng lạnh, trúng gió, co cứng chân tay, chuột rút, cứng hàm, suy kiệt, táo bón, thiếu máu… Liều dùng: 5-30 ml trong gia vị thực phẩm.'),(41,6,'tôm chua.jpg','Tôm chua',0.68,'Mắm tôm chua Dì Cẩn là một món ăn đậm đà, vừa hấp dẫn vừa lạ miệng.'),(42,6,'tương ớt.jpg','Tương ớt',0.37,'Trong tương ớt sử dụng nhiều ớt tươi trong thành phần có thể cải thiện tiêu hóa giúp nhuận tràng, giải phóng endorphins (chất giảm đau tự nhiên), thông mũi, giảm huyết áp cao, tăng cường tốc độ trao đổi chất. Sử dụng một ít tương ớt mỗi ngày còn có tác dụng ngăn chặn nguy cơ mắc các bệnh liên quan tiểu đường.'),(43,6,'xì dầu.jpg','Xì dầu',0.28,'Các chuyên gia Singapore đã gọi xì dầu là sản phẩm duy nhất có khả năng chống lại sự phá hủy tế bào mạch máu, do đó ngăn chặn sự phát triển xơ vữa động mạch và các bệnh khác.'),(44,7,'cùi dừa già.jpg','Cùi dừa già',3.68,'Cùi dừa có chưa các chất dinh dưỡng: Chất đạm, tinh bột, đường, chất xơ thực phẩm, chất béo. Các loại Vitamin có trong cùi dừa: B1, B2, B3, B5, B6, B9, C,…Các loại khoáng chất có trong cùi dừa: Ca, Fe, Mg, P, K, Zn,…'),(45,7,'cùi dừa non.jpg','Cùi dừa non',0.4,'Cùi dừa cung cấp dinh dưỡng. Cùi dừa có nhiều chất béo và calo mà lại chứa một lượng carb và protein vừa phải. Cùi dừa bảo vệ tim mạch. ...'),(46,7,'đậu đen.jpg','Đậu đen (hạt)',3.25,'Gúp giảm cân. Nước đậu đen là thực phẩm chứa ít năng lượng cũng như chất béo. Giúp chống lão hóa và làm đẹp da. Trong đậu đen có hợp chất anthocyanins. Giúp hạ huyết áp. ...'),(47,7,'đậu hà lan.jpg','Đậu Hà lan (hạt)',3.42,'Ngăn ngừa ung thư tin liên quan. Thúc đẩy sức khỏe tim. Đậu Hà Lan chứa các khoáng chất thiết yếu như kali và magiê giúp ngăn ngừa huyết áp cao, một yếu tố nguy cơ chính của bệnh tim. Làm giảm lượng đường trong máu. ...'),(48,7,'đậu phụ.jpg','Đậu phụ',0.95,'Đậu phụ là món ăn phổ biến trong bữa ăn hàng ngày của mọi gia đình.'),(49,7,'đậu tương.jpg','Đậu tương (đậu nành)',4,'Phòng bệnh tim mạch. Phòng ngừa ung thư vú và ung thư tuyến tiền liệt. Giảm nguy cơ trầm cảm. Phòng bệnh tiểu đường, bệnh thận. Tăng cường khả năng sinh sản. ...'),(50,7,'đậu xanh.jpg','Đậu xanh',3.28,'Nếu bạn ăn một chén cháo đậu xanh nấu chín mỗi ngày giúp bạn tăng cường hệ miễn dịch, hạ thấp 20% lượng cholesterol trong 3 tuần, nguy cơ mắc bệnh tim mạch và huyết áp giảm 40%. Chất xơ trong đậu xanh còn có khả năng loại bỏ các độc tố trong cơ thể, do đó giúp ngăn ngừa chứng ung thư ruột kết.'),(51,7,'hạt điều.jpg','Hạt điều',6.05,'Ngăn ngừa ung thư Hạt điều chứa proanthocyanidins - được chứng minh là loại flavanol có thể ngăn chặn các tế bào ung thư tái sản xuất và tiêu diệt tế bào ung thư.'),(52,7,'mè.jpg','Mè',5.68,'Nguồn thực phẩm giàu chất xơ tốt. Có tác dụng giảm cholesterol và chất béo trung tính. Nguồn cung protein thực vật dồi dào. Tác dụng hạ huyết áp. ...'),(53,7,'sữa đậu nành.jpg','Sữa đậu nành',0.28,'Trong sữa đậu nành có vitamin A, B1, B2, D, PP, K, F và các men có ích cho tiêu hóa. Ngoài ra, đồ uống này còn chứa chất isoflavone giúp bù lại tình trạng thiếu estrogen của phụ nữ có tuổi, chống loãng xương, phòng trị ung thư vú. Sữa đậu nành cũng cải thiện chứng thừa cholesterol ở đàn ông.'),(54,8,'bánh bao.jpg','Bánh bao',2.19,'Bánh bao chay nhân đậu thì trong bánh bao lại có rất nhiều các loại vitamin B6, B1, B12… các vitamin này có tác dụng làm giảm căng thẳng …'),(55,8,'bánh đúc.jpg','Bánh đúc',0.52,'Bánh đúc là món quà vặt có từ thời xa xưa. Bánh làm từ bột gạo và lạc, khi ăn có cảm giác mát, ngậy và có tác dụng chống đói hiệu quả.'),(56,8,'bánh mì.jpg','Bánh mì',2.49,'Giúp ruột khỏe: Bánh mì là nguồn phong phú chất xơ nên rất tốt cho hệ thống tiêu hóa. Giảm nguy cơ bệnh tim: Bánh mì giúp giảm nguy cơ bệnh mạch vành. Giảm cân: Bánh mì được xem là chọn lựa đúng đắn cho người gặp khó khăn khi theo đuổi chế độ ăn kiêng với khẩu phần chứa ít thành phần carbon.'),(57,8,'bánh phở.jpg','Bánh phở',1.41,'Bánh phở là nguyên liệu chính để tạo nên các món phở. Ngoài những thành phần khác như là nước phở, thịt, gia vị... thì bánh phở quyết định đến chất lượng của một bát (tô) phở. Riêng ở làng Chũ Lục Ngạn, Bắc Giang bánh phở khô có tên gọi khác là mỳ chũ.'),(58,8,'bánh tráng mỏng.jpg','Bánh tráng mỏng',3.33,'Bánh tráng hay còn gọi là bánh đa là loại bánh sử dụng nguyên liệu chính là tinh bột tráng mỏng phơi khô.'),(59,8,'bún.jpg','Bún',1.1,'Những sợi bún thì ta cũng đều biết rằng, bún được làm bởi gạo. Tuy vậy để có được bún vừa tươi vừa ngon, dai và giòn, trắng trong đồng thời bắt mắt người làm đã phải bỏ vô đó không phải là ít những phụ gia không giống nhau mà phổ biến nhất đấy chính là chất hàn the, chất huỳnh quang Tinopal, thêm nữa còn nhiều chất làm chua, chất tẩy trắng,…'),(60,8,'gạo nếp cái.jpg','Gạo nếp cái',3.46,'Nếp cái hoa vàng, có khi còn gọi là nếp ả hay nếp hoa vàng, là giống lúa nếp truyền thống nổi tiếng tại các tỉnh đồng bằng và trung du Bắc Bộ, Việt Nam, có hạt gạo tròn, dẻo, thơm đặc biệt nên thường dùng đồ xôi, làm cốm, làm các loại bánh có sử dụng gạo nếp, làm tương hoặc ủ rượu.'),(61,8,'gạo tẻ.jpg','Gạo tẻ',3.44,'Trong thành phần của gạo tẻ, có chứa các dưỡng chất cần thiết cho cơ thể như: Tinh bột, Protein, Vitamin, B1, Niacin, Vitamin C, Canxi, Sắt…'),(62,8,'ngô tươi.jpg','Ngô tươi',1.96,'Ngô hay còn gọi là bắp hay bẹ. Đây là một loại cây lương thực có nguồn gốc từ Trung Mỹ và sau đó lan tỏa ra khắp châu Mỹ từ cuối thế kỷ 15 đến đầu thế kỷ 16 Ngô là thực phẩm có sẵn quanh năm, chứa hàm lượng giá trị dinh dưỡng cao. Theo ẩm thực Việt Nam, hạt ngô còn được sử dụng để làm bánh ngô hay canh súp ngô rất ngon mà bổ dưỡng.'),(63,8,'ngô vàng.jpg','Ngô vàng hạt vàng',3.54,'Trong hạt ngô có chứa rất nhiều chất beta-cryptoxanthin'),(64,9,'bia.jpg','Bia',0.43,'Giảm nguy cơ bệnh tim. Chống lại bệnh Alzheimer. Giảm nguy cơ tiểu đường. Ngăn ngừa sỏi thận. Giảm thiểu nguy cơ ung thư ...'),(65,9,'coca cola.jpg','CocaCola',0.42,'Không chỉ có công dụng khử mùi xăng, Coca-Cola còn có thể đánh bay mọi vết bẩn cứng đầu như vết mực trên quần áo cực kỳ hiệu quả. Giờ đây, bạn không cần phải mua dung dịch tẩy rửa đắt đỏ nữa chỉ cần đổ một lon Coca vào máy giặt cùng với nước tẩy rửa quần áo là được.'),(66,9,'rượu nếp.jpg','Rượu nếp',1.66,'Rượu nếp giúp phòng ngừa tim mạch, đột qụy, tăng huyết áp. Rượu nếp cẩm phòng chống ung thư ...'),(67,10,'bưởi.jpg','Bưởi',0.3,'Phòng ngừa táo bón. Khi mùa thu tới, rất nhiều người lại bị chứng táo bón \"hành hạ\".'),(68,10,'cam.jpg','Cam',0.37,'Cam là loại trái cây phổ biến nhất thế giới với lượng calo thấp và nguồn dinh dưỡng cao. Cam có thể hỗ trợ sức khỏe của da và giảm nguy cơ mắc nhiều bệnh lý. Tham khảo một số thông tin về công dụng của nước cam cũng như cách sử dụng an toàn để bảo vệ sức khỏe.'),(69,10,'chanh.jpg','Chanh',0.23,'Cân bằng độ pH của cơ thể và giảm cân. Chữa các vấn đề liên quan đến chứng đầy bụng khó tiêu, táo bón và giúp lợi tiểu. Giảm đau và tránh nhiễm khuẩn răng miệng.'),(70,10,'chôm chôm.jpg','Chôm chôm',0.72,'Lượng vitamin chứa trong chôm chôm còn có tác dụng bổ sung dưỡng chất thiết ...'),(71,10,'chuối tây.jpg','Chuối tây',0.66,'Chuối chín có tác dụng làm hạ áp huyết cao và phòng ngừa nguy cơ đột qụy'),(72,10,'chuối tiêu.jpg','Chuối tiêu',0.97,'Thành phần kali trong chuối tiêu có tác dụng tăng cường bài tiết lượng nước và muối dư thừa trong máu, cân bằng hàm lượng natri. Ngoài ra, chuối tiêu còn bổ sung carotein giúp ngăn ngừa lão hóa mắt sớm, làm cho “cửa sổ tâm hồn” của bạn sáng hơn, khỏe hơn và bớt mệt mỏi.'),(73,10,'đu đủ chín.jpg','Đu đủ chín',0.35,'Cải thiện hệ tiêu hóa. Đu đủ rất tốt cho hệ tiêu hóa bởi có hàm lượng chất xơ cao.'),(74,10,'dưa hấu.jpg','Dưa hấu',0.16,'Dưa hấu là một phương pháp giúp lợi tiểu tự nhiên qua việc gia tăng lượng nước tiểu mà không gây căng thẳng cho thận như các đồ uống có cồn hay café. Dưa hấu còn giúp gan lọc chất acmoniac, giảm gánh nặng cho thận trong quá trình xử lý nước.'),(75,10,'dứa ta.jpg','Dứa ta',0.29,'Quả Khóm chứa nhiều Bromelain, có đặc tính chống viêm, giảm đau và hỗ trợ điều trị các bệnh viêm khớp, viêm khớp dạng thấp. Ngoài ra, Bromelain được cho là có thể giảm sưng, bầm tím và hỗ trợ việc chữa lành các vết thương sau chấn thương, phẫu thuật.'),(76,10,'hồng xiêm.jpg','Hồng xiêm',0.48,'Bổ sung năng lượng tức thì Hàm lượng glucose cao trong hồng xiêm cung cấp đường cho cơ thể trong một vài phút.'),(77,10,'lê.jpg','Lê',0.45,'Lê không chỉ có mùi vị đặc biệt, thơm ngon, mát mà còn có tác dụng tuyệt vời cho sức khỏe con người.'),(78,10,'mận.jpg','Mận',0.2,'Tốt cho xương khớp. Theo India Times, mận có thể làm tăng đáng kể mật độ khoáng xương ở cột sống và cẳng tay.'),(79,10,'mít dai.jpg','Mít dai',0.48,'Ít người biết rằng mít là nguồn cung vitamin C, A dồi dào, giúp tăng cường hệ miễn dịch, cải thiện sinh lực nam giới và chống ung thư. Một nghiên cứu gần đây chỉ ra rằng, ngoài các tác dụng được biết đến như tăng cường năng lượng, duy trì huyết áp, mít còn có khả năng phòng ngừa và điều trị ung thư.'),(80,10,'mít mật.jpg','Mít mật',0.62,'Mít mật vốn là loại quả không chỉ thơm mà còn rất ngọt nên có nhiều người ưa thích. Tuy nhiên, không như mít dai hay mít nghệ, mít mật khi chín thường rất mềm, chỉ cần chạm nhẹ vào múi là có thể bị nát hoặc chảy nước khá bất tiện. Do đó khi ăn loại quả này, nhiều người hay ngại làm.'),(81,10,'mơ.jpg','Mơ',0.46,'Mơ còn có tên là ô mai, khổ hạnh nhân, tên khoa học Prunus arme-niaca L., thuộc họ Hoa hồng (Rosaceae). Từ xa xưa mơ được nhiều dân tộc trên thế giới, nhất là ở phương Đông biết đến. Mơ là loại quả có giá trị dinh dưỡng rất cao, chứa nhiều vitamin và những chất chống oxy hoá mạnh, không những được dùng làm thuốc, món ăn mà còn có công dụng làm đẹp.'),(82,10,'na.jpg','Na',0.64,'Na, còn gọi là mãng cầu ta, mãng cầu na, mãng cầu dai/giai, sa lê, phan lệ chi, là một loài thuộc chi Na có nguồn gốc ở vùng châu Mỹ nhiệt đới. Nguồn gốc bản địa chính xác của loại cây này chưa rõ do hiện nay nó được trồng khắp nơi nhưng người ta cho rằng nó là cây bản địa của vùng Caribe.'),(83,10,'nhãn.jpg','Nhãn',0.48,'Nhãn là trái cây giàu vitamin C. Trong 100 g nhãn có chứa 84 mg dưỡng chất này, cung cấp 93% lượng vitamin C'),(84,10,'nho ta(chua).jpg','Nho ta (nho chua)',0.14,'Nho là một loại quả mọng lấy từ các loài cây thân leo thuộc chi Nho (Vitis).'),(85,10,'quýt.jpg','Quýt',0.38,'Quýt giúp ngăn ngừa đau đầu, trợ tiêu hóa và tốt cho việc giảm viêm. Loại quả này cũng giúp ngăn ngừa chứng chuột rút nhờ hàm lượng kali cao. Quýt không phải là một nguồn rất lớn canxi, nhưng nó chứa 22 mg mỗi khẩu phần. Canxi là một khoáng chất cần thiết giúp làm dịu thần kinh và làm giảm huyết áp của bạn.'),(86,10,'táo ta.jpg','Táo ta',0.37,'Táo ta (táo chua) có vỏ xanh, nhẵn bóng được trồng phổ biến ở Việt Nam với hai loại chính: táo chua và táo đường.'),(87,10,'táo tây.jpg','Táo tây',0.47,'Nghiên cứu cho thấy, táo tây có tác dụng dự phòng tăng huyết áp, xơ cứng động mạch, còn là thức ăn lý tưởng cho phụ nữ mang thai. Táo tây chứa nhiều muối kali, sau khi ăn sẽ làm hoán chuyển natri trong máu, cũng như bài ra cơ thể, từ đó giúp giảm huyết áp.'),(88,10,'vải.jpg','Vải',0.43,'Quả vải là loại trái cây hàng đầu giúp cải thiện sức khỏe tim mạch, phòng chống ung thư, giúp bạn có làn da đẹp và suối tóc óng ả. Mùa hè đến là thời điểm tuyệt vời để thưởng thức trái vải thơm ngon và đầy hương vị.'),(89,10,'vú sữa.jpg','Vú sữa',0.42,'Quả vú sữa có vị ngọt, thơm như vị sữa. Đây là thứ trái cây quen thuộc đối với người Việt. Nhưng không phải ai cũng biết rằng, vú sữa có nhiều tác dụng rất tốt cho sức khỏe của mọi người. Vú sữa cung cấp rất nhiều vitamin, dưỡng chất và vi chất thiết yếu cho cơ thể. Bên cạnh đó, vú sữa còn giúp bạn giảm cân, chắc xương và rất hữu ích cho ngày hành kinh.'),(90,10,'xoài.jpg','Xoài chín',0.69,'Trong một trái xoài có chứa nhiều vitamin chủ yếu là vitamin A, B1, B2, B6, C, E,… và nhiều loại khoáng chất điển hình là protein, lipit, gluxit. Đặc biệt xoài là nguồn cung cấp vitamin A và C cao nhất trong tất cả các loại trái cây. Các enzymes trong xoài cũng có chức năng giúp đào thải chất độc trong cơ thể; tạo ra kháng thể giúp cho cơ thể chống lại các vi khuẩn, vi rút gây bệnh thông thường.'),(91,11,'bầu.jpg','Bầu',0.14,'Chất xơ hòa tan có trong quả bầu có tác dụng ngăn ngừa bệnh tim mạch và giữ cho trái tim khỏe mạnh. Chất xơ không hòa tan có thể làm sạch ruột. Chất xơ còn giúp tiêu hóa tốt hơn và ngăn ngừa táo bón. Nó cũng giúp giảm nguy cơ ung thư, nồng độ axit và khả năng giảm thiểu tích lũy khí trong ruột.'),(92,11,'bí đao.jpg','Bí đao (bí xanh)',0.12,'Tác dụng chủ yếu là giải khát, làm mát, lợi tiểu để loại trừ nhiệt độc và nước ứ đọng trong cơ thể ra ngoài. Ăn bí đao thường xuyên có thể tiêu trừ nước thừa trong cơ thể ở người béo bệu, phù thũng.'),(93,11,'bí ngô.jpg','Bí ngô',0.24,'Bí đỏ vừa là một thực phẩm chứa nhiều dinh dưỡng vừa là một cây thuốc quý. Dây bí đỏ mọc lan trên mặt đất. Hiện nay có nhiều loài mà quả có hình dáng và màu sắc khác nhau: hình cầu, hình cầu dẹt, hình trụ; vỏ nâu, vỏ vân, vỏ sẫm màu ; thịt đỏ, thịt hồng, thịt vàng ; có loại nặng trên 100kg.'),(94,11,'cà chua','Cà chua',0.19,'Cải thiện thị lực. Cà chua là nguồn cung cấp vitamin A và C tuyệt vời giúp ngăn ngừa bệnh quáng gà và tăng thị lực cho đôi mắt của bạn.'),(95,11,'cà pháo','Cà pháo',0.2,'Từ xưa, cà pháo vẫn là món ăn truyền thống trong mỗi mâm cơm gia đình Việt Nam. Không những ăn ngon miệng, nếu biết sử dụng, cà pháo còn trở thành những vị thuốc giúp nhuận tràng, lợi tiểu, trị thũng thấp độc, trừ hòn cục trong bụng, ho lao....'),(96,11,'cà rốt.jpg','Cà rốt',0.38,'Cây cà rốt không chỉ là loại rau quen thuộc mà còn là cây thuốc quý. Cà rốt là loại cây thảo sống 2 năm. Lá cắt thành bản hẹp. Hoa tập hợp thành tán kép; trong mỗi tán, hoa ở chính giữa thì không sinh sản và màu tía, còn các hoa sinh sản ở chung quanh thì màu trắng hay hồng. Hạt Cà rốt có vỏ gỗ và lớp lông cứng che phủ.'),(97,11,'cà tím.jpg','Cà tím',0.22,'Cà tím có tên khoa học là solanum melongena, có nguồn gốc ở Ấn Độ. Theo các nhà dinh dưỡng, trong thành phần của cà tím có 92% nước, 5,5% glucid, 1,3% protid, 0,2% lipid.'),(98,11,'cải bắp.jpg','Cải bắp',0.29,'Bắp cải là loại rau quen thuộc vào mùa đông. Ăn rau bắp cải có tác dụng giúp tăng hồng cầu, ngừa ung thư, tốt cho tim mạch, ...'),(99,11,'cải cúc.jpg','Cải cúc',0.14,'Rau Cải cúc chứa 1,85% protid 2,57% glucid, 0,43% lipid và còn có nhiều vitamin B, C và một số vitamin A.'),(100,11,'cải thìa.jpg','Cải thìa (cải trắng)',0.16,'Phòng ngừa bệnh ung thư Các loại rau xanh thuộc họ cải như cải thìa là nguồn thực phẩm tuyệt vời, có khả năng cao phòng ngừa bệnh ung thư. …'),(101,11,'cải xanh.jpg','Cải xanh',0.15,'Rau cải canh có nhiều công dụng với sức khỏe như trị táo bón, mụn nhọt, ho, …'),(102,11,'cần ta.jpg','Cần ta',0.1,'Rau cần ta tính lương, vị ngọt, cay nhẹ, có thể dùng làm thực phẩm hoặc làm thuốc điều trị các bệnh lý như viêm gan, bí tiểu, đái ra máu, kinh nguyệt đến sớm, cao huyết áp, tiểu đường… Dưới đây là những tác dụng chữa bệnh từ dược liệu này.'),(103,11,'củ cải trắng.jpg','Củ cải trắng',0.21,'Có tác dụng làm giảm cholesterol. Củ cải đã được chứng minh là có khả năng làm giảm cholesterol trong cơ thể. …'),(104,11,'đậu cô ve.jpg','Đậu cô ve',0.73,'Đậu cô ve là thực phẩm phổ biến thường dùng của mọi gia đình. Đậu cô ve giúp cơ, xương chắc khỏe và có tác dụng giảm cân.'),(105,11,'dọc mùng.jpg','Dọc mùng',0.05,'Thân, lá của cây dọc mùng có tác dụng làm tiêu đờm, tiêu ứ, giảm ho đờm khó thở, tiêu ứ, trừ giun... Củ rễ của cây bạc hà đem phơi khô tán thành bột có thể dùng để trị ghẻ lở, dị ứng ngoài da…'),(106,11,'dưa cải bắp.jpg','Dưa cải bắp',0.18,'Dưa bắp cải có lượng calo thấp và giàu protein và chất xơ. Nó chứa các vitamin như vitamin A, vitamin C, vitamin K và các vitamin B khác nhau …'),(107,11,'dưa cải bẹ.jpg','Dưa cải bẹ',0.17,'Cải bẹ dưa có khả năng làm tăng sản xuất acid mật và giảm cholesterol xấu nên sẽ giúp giảm nguy cơ mắc bệnh tim và ung thư. Chất “xơ ăn kiêng” có trong cải bẹ dưa cực kỳ có lợi vì giúp kiểm soát nồng độ cholesterol trong quá trình hấp thu; nhuận tràng và làm giảm nguy cơ bị bệnh trĩ, táo bón hay ung thư ruột kết.'),(108,11,'dưa chuột.jpg','Dưa chuột',0.15,'Dưa chuột là loại rau được sử dụng phổ biến trong bữa ăn hàng ngày. Tuy nhiên, đi kèm với những lợi ích cho sức khỏe dưa leo còn mang lại nhiều tác dụng phụ không tốt.'),(109,11,'gấc.jpg','Gấc',1.22,'Tác dụng bổ sung dưỡng chất của quả gấc. Lượng beta-caroten của gấc cao gấp đôi cà rốt. Dầu gấc được cho là có chức năng phòng chống thiếu vitamin, tăng khả năng miễn dịch, tăng sức đề kháng cơ thể, chống oxy hóa, chống lão hóa tế bào…'),(110,11,'giá đỗ.jpg','Giá đậu xanh',0.43,'Các chuyên gia sức khỏe cho rằng giá đậu xanh sống có tác dụng kéo dài tuổi thọ, rất tốt trong những trường hợp thiểu năng sinh dục, …'),(111,11,'hành lá.jpg','Hành lá (hành hoa)',0.22,'Hành lá giàu chất xơ, vitamin C, vitamin K, vitamin A, vitamin B12, các flavonoid thiết …'),(112,11,'măng chua.jpg','Măng chua',0.11,'Ngoài ra, măng tre còn có nhiều tác dụng khác như trị táo bón, giúp tiêu ... Muối măng chua cũng là một biện pháp là giảm tính độc của măng.'),(113,11,'mộc nhĩ.jpg','Mộc nhĩ',3.04,'Hỗ trợ điều trị bệnh mạch vành, di chứng tai biến mạch máu não, mỡ trong máu và nhiều tình trạng khác. …'),(114,11,'mướp.jpg','Mướp',0.16,'Quả mướp không những có khả năng chống viêm, chống các nếp nhăn và làm đẹp dung nhan, mà còn có tác dụng hỗ trợ trong điều trị các chứng đau họng, ho, hen xuyễn, viêm tuyến má, ho bách nhật, đau răng, đau lưng, đậu không bay, tắc sữa, đau bụng kinh, kinh nguyệt quá nhiều, viêm bàng quang.'),(115,11,'nấm hương khô.jpg','Nấm hương khô',2.74,'Theo nghiên cứu của các nhà khoa học, trong nấm hương khô sẽ chứa rất nhiều vitamin, đạm, canxi, …'),(116,11,'ớt vàng to.jpg','Ớt vàng to',0.28,'Tất cả ớt chuông các màu sắc là nguồn kali cao. Khoáng chất này giúp giữ cho chất lỏng và khoáng chất cân bằng trong cơ thể, tăng cường chức năng cơ bắp và điều hòa huyết áp. Một chén ớt xanh có chứa 261 mg kali, trong khi các giống màu đỏ và màu vàng cung cấp hơn 300 mg mỗi cốc.'),(117,11,'rau kinh giới.jpg','Rau kinh giới',0.22,'Cây kinh giới là rau ăn quen thuộc vạn người Việt mê mẩn không thể thiếu. Lá kinh giới cũng có nhiều công dụng chữa bệnh hay ít ai biết.'),(118,11,'rau bí.jpg','Rau bí',0.18,'Chống ung thư Sự hiện diện của các đặc tính chống ô xy hóa và kháng viêm trong rau bí giúp chống lại căn bệnh gây chết người này.'),(119,11,'rau đay.jpg','Rau đay',0.24,'Rau đay quả dài cũng có vị đắng nhưng tính lạnh, có độc, có tác dụng nhuận trường, lợi tiểu, mát máu và lợi sữa (lá non và ngọn).'),(120,11,'rau khoai lang.jpg','Rau khoai lang',0.22,'Rau khoai lang là món ăn yêu thích của nhiều gia đình Việt. Rau khoai lang rất dễ trồng và có thể chế biến thành nhiều món ăn khác nhau. Không chỉ ngon miệng, rau khoai lang còn có khả năng trong việc điều trị một số bệnh thường gặp. Một trong những khả năng nổi trội của rau khoai lang chính là chữa trị táo bón.'),(121,11,'rau mồng tơi.jpg','Rau mồng tơi',0.14,'Chủ trị táo bón, ít sữa, tiểu buốt, tiểu rắt, đau mỏi xương khớp. Toàn cây được y học cổ truyền của Trung Quốc dùng điều trị bệnh lỵ, nhiễm trùng bàng quang, đau ruột thừa, bỏng, gãy xương, tổn thương ngoài da, đại tiện bí kết. Tại Ấn Độ, lá cây mồng tơi còn được dùng làm thuốc chữa bệnh lậu, mề đay, viêm bao quy đầu.'),(122,11,'rau mùi.jpg','Rau mùi',0.13,'Bảo vệ mắt, giúp mắt sáng: do có chứa hàm lượng beta carotene cao cùng với rất nhiều chất chống oxy hóa, rau mùi được xem là thảo dược giúp giảm các bệnh liên quan đến mắt và cải thiện thị lực rất tốt. Không chỉ thế, rau mùi còn có công dụng làm giảm nguy cơ mắc các bệnh như thoái hóa điểm vàng và đục thủy tinh thể.'),(123,11,'rau muống.jpg','Rau muống',0.23,'Tác dụng của rau muống được đánh giá cao trong việc ngăn ngừa và điều trị bệnh mãn tính. Rau muống cũng có nhiều lợi ích cho da và tóc.'),(124,11,'rau ngót.jpg','Rau ngót',0.35,'Thực tế những tác dụng của rau ngót đối với sức khỏe đã được y khoa công nhận. Rau ngót rất giàu protein, canxi, chất béo, và các vi khoáng …'),(125,11,'rau răm.jpg','Rau răm',0.3,'Các vị thuốc từ rau răm được dùng tươi hoặc phơi khô, giã sống để lấy nước uống. Khi kết hợp với các vị thuốc Đông y, rau răm có tác dụng làm sáng mắt, ích trí, chữa dạ dày lạnh, mạnh gân cốt, trị co gân (chuột rút), đầy hơi, đau bụng.'),(126,11,'rau rút.jpg','Rau rút',0.28,'Theo Đông y, rau rút hay còn gọi là rau nhút có vị ngọt, tính hàn, không độc, tác dụng an thần, mát gan, giải nhiệt độc, có tác dụng chữa chứng mất ngủ, trị nóng trong sinh mụn… làm thông huyết mạch, điều hòa tỳ vị, thông thủy đạo, lợi tiểu tiện, tiêu viêm, nhuận tràng, hạ sốt, chữa mất ngủ, hỗ trợ điều trị bướu cổ.'),(127,11,'rau thơm.jpg','Rau thơm',0.18,'Các loại rau thơm không chỉ làm cho các món ăn thêm hấp dẫn, mà còn góp phần không nhỏ trong việc phòng và chữa bệnh.'),(128,11,'su hào.jpg','Su hào',0.36,'Su hào cải thiện quá trình tiêu hóa, giúp giảm cân, ngăn ngừa ung thư, tăng cường miễn dịch, cải thiện tuần hoàn, củng cố xương, hỗ trợ thị giác, bảo vệ cơ và các chức năng thần kinh. Su hào có thể ăn sống hoặc qua nấu nướng.'),(129,11,'su su.jpg','Su su',0.18,'Su su không chỉ là loại quả quen thuộc trong mâm cơm hằng ngày, nó còn có nhiều tác dụng thần kỳ cho sức khỏe.'),(130,11,'súp lơ.jpg','Súp lơ',0.3,'Giảm nguy cơ mắc bệnh ung thư Nhiều nghiên cứu đã chỉ ra rằng có mối liên hệ chặt chẽ giữa chế độ ăn uống với nguy cơ mắc bệnh ung thư.'),(131,11,'tía tô.jpg','Tía tô',0.25,'Tía tô còn có tác dụng làm giảm co thắt cơ trơn của phế quản, chất tinh dầu làm tăng đường huyết.'),(132,12,'sữa bò tươi.jpg','Sữa bò tươi',0.74,'Sữa bò tươi nguyên chất là 1 món thức uống có tác dụng rất tốt và góp phần bảo vệ và nâng cao sức khỏe cho mỗi chúng ta.'),(133,12,'sữa bột tách béo.jpg','Sữa bột tách béo',3.57,'Một nghiên cứu khác với 20.000 phụ nữ cũng cho thấy rằng, uống 1 ly sữa nguyên chất mỗi ngày sẽ làm giảm 15% tăng cân trong vòng 9 năm so với những người uống sữa tách béo.'),(134,12,'sữa bột toàn phần.jpg','Sữa bột toàn phần',4.94,'Sữa bột là một sản phẩm sản xuất từ sữa ở dạng bột khô, được thực hiện bằng cách làm bốc hơi sữa để khô sau đó nghiền nhỏ, tán nhỏ thành bột. Một mục đích của sữa dạng bột khô này là phục vụ cho việc bảo quản, tích trữ, sử dụng. Sữa bột có thời hạn sử dụng lâu hơn hẳn so với sữa nước và không cần phải được làm lạnh, do bản thân nó đã có độ ẩm thấp.'),(135,12,'sữa chưa.jpg','Sữa chua',0.61,'Sữa chua thực chất là sữa bò tươi hoặc sữa được pha theo công thức sữa tươi cho lên men với các chủng vi khuẩn có lợi cho đường ruột (Lactobacillus bulgaricus và Streptococus thermophilus).'),(136,12,'sữa đặc có đường.jpg','Sữa đặc có đường',3.36,'Sữa đặc có đường được làm từ sữa bò nguyên chất, cho thêm đường trong quá trình sản xuất và nấu cô đặc lại nên có độ đặc và sánh khá cao.'),(137,12,'sữa mẹ.jpg','Sữa mẹ',0.61,'Sữa mẹ chứa nhiều chất kháng khuẩn, tăng cường sức đề kháng cho trẻ, chống các bệnh nhiễm khuẩn, nhất là tiêu chảy và viêm đường hô hấp. Do tác dụng kháng khuẩn của sữa mẹ nên trẻ được bú sữa mẹ sẽ ít mắc bệnh. Trẻ bú mẹ ít bị dị ứng, chàm/eczema.Sữa mẹ chứa nhiều chất kháng khuẩn, tăng cường sức đề kháng cho trẻ, chống các bệnh nhiễm khuẩn, nhất là tiêu chảy và viêm đường hô hấp. Do tác dụng kháng khuẩn của sữa mẹ nên trẻ được bú sữa mẹ sẽ ít mắc bệnh. Trẻ bú mẹ ít bị dị ứng, chàm/eczema.'),(138,13,'bao tử bò.jpg','Bao tử bò',0.97,'Dạ dày bò tác dụng kiện tỳ vị chữa tiêu hóa kém, bụng đầy chậm tiêu…'),(139,13,'bao tử heo.jpg','Bao tử heo',0.85,'Theo Y học cổ truyền, bao tử heo vị ngọt, tính ấm, có công dụng kiện tỳ ích vị, bổ hư nhược, ngoài các bệnh lý dạ dày còn được dùng chữa trị nhiều chứng bệnh khác như suy nhược cơ thể, thiếu máu, viêm gan vàng da, xơ gan, đái đường, rối loạn tiểu tiện, sa tử cung, di tinh, trẻ em suy dinh dưỡng, chứng ra mồ hôi nhiều ...'),(140,13,'cật bò.jpg','Cật bò',0.67,'Theo Đông y ngưu thận vị ngọt, tính hơi ấm không độc. Tác dụng bổ thận, dưỡng năm tạng… dùng trị chứng thận yếu, đau mỏi lưng gối, mỏi xương khớp, thận.. Dưới dạng phối hợp với đỗ trong, cẩu kỷ tiềm ăn. Với rau củ hầm ăn hoặc với rau muống, rau cần tây, hoa lý gia vị vừa đủ xào ăn đều tốt.'),(141,13,'cật heo.jpg','Cật heo',0.81,'Cật heo có nhiều chất đạm, béo, có nhiều chất khoáng như canxi, photpho, sắt và các vitamin quan trọng như vitamin A, Vitamin B1, Vitamin C…'),(142,13,'chà bông.jpg','Chà bông',3.96,'Chà bông là món ăn tiện lợi, thơm ngon và bổ dưỡng, nhưng chà bông được làm từ sắn dây và các chất phụ gia độc hại lại âm thầm “đầu độc” người tiêu dùng.'),(143,13,'chả lợn.jpg','Chả lợn',5.17,'Chả thịt heo hấp là món ngon dễ làm, thích hợp dùng cho bữa cơm gia đình hoặc làm món nhậu đều ngon tuyệt. Những miếng chả thịt heo hấp dai dai, bùi béo, ngấm đều gia vị ướp cực thơm ngon, khiến những ai một lần nếm thử là khó thể nào quên.'),(144,13,'chả quế.jpg','Chả quế',4.16,'Giò chả là món ngon đặc trưng của người Việt. Chả quế là một trong những món giò chả ngon được nhiều người ưa thích.'),(145,13,'giò heo.jpg','Chân giò lợn (bỏ xương)',2.3,'Chân giò hay giò heo/giò lợn hay gọi đơn giản là giò hay giò hầm là một món ăn thông dụng được chế biến từ nguyên liệu là giò của heo bằng phương pháp hầm. Chất keo trong móng giò còn trợ giúp các tế bào da không bị khô nhăn nhờ đó da luôn căng bóng, nở ngực. Móng giò mùi vị thơm ngon, giá trị dinh dưỡng cao.'),(146,13,'da heo.jpg','Da heo',1.18,'Phụ nữ nên ăn thường xuyên món này với số lượng phù hợp có tác dụng giữ ẩm cho làn da, làm cho tóc sáng bóng, giảm lão hóa, làm mờ các vết nhăn nheo trên da. Ngoài ra, bì lợn giúp điều trị các chứng bệnh khó chịu như đau họng, thiếu máu và một số bệnh về rối loạn chảy máu, bổ máu, giúp nhanh cầm máu.'),(147,13,'dăm bông thịt heo.jpg','Dăm bông heo',3.18,'Dăm bông thịt heo là món ăn phổ biến hiện nay, món dăm bông thịt heo có thể kết hợp thành nhiều món ăn khác như kẹp vào bánh mì, ăn trực tiếp hoặc bày vào mâm cỗ hoặc bàn tiệc nhẹ…'),(148,13,'thịt đầu heo.jpg','Đầu heo',3.35,'Thịt đầu heo ngâm mắm là món lai rai ngày Tết rất ngon mà lại không ngán. Sau khi ngâm mắm chừng 7- 10 ngày, thịt sẽ đượm đỏ màu mắm rất hấp dẫn.'),(149,13,'thịt đuôi bò.jpg','Đuôi bò',1.37,'Đuôi bò có lớp da dai dai, bên trong pha lẫn thịt và gân bò ăn rất ngon.'),(150,13,'thịt đuôi heo.jpg','Đuôi heo',4.67,'Thịt đuôi heo mềm béo, ngấm đều gia vị tẩm ướp thơm ngon. Món này dành cho các mẹ bầu ăn chơi cho đã thèm luôn nhé!'),(151,13,'thịt ếch.jpg','Ếch',0.9,'Thịt ếch, thịt cóc là thịt từ các loài ếch nhái, cóc, đây là món ăn được coi là bổ dưỡng và là món truyền thống trong nền văn hóa ẩm thực nhiều nước như Kerala, Thái Lan, Việt Nam, Indonesia, vùng Alentejo ở Bồ Đào Nha, Tây Ban Nha, Slovenia, Tây Bắc Hy Lạp, Đông Bắc Ý và phía Nam của Mỹ.'),(152,13,'gân chân bò.jpg','Gân chân bò',1.24,'Gân bò thường được lấy ở chân trước hoặc chân sau con bò. Gân bò dai, giòn, có mùi vị đặc trưng, giúp bổ sung collagen, bồi bổ thận, gân cốt. Có thể dùng gân bò xào chua ngọt, kho tộ, hầm với rượu vang đỏ, làm gỏi hoặc ngâm giấm.'),(153,13,'gan gà.jpg','Gan gà',1.11,'Phải đảm bảo rằng đó là những lá gan gà hữu cơ (gà được chăn nuôi bằng phương thức hữu cơ). Nếu không, bạn có nguy cơ ăn phải những loại gan chứa đầy chất kích thích và độc tố. Gan gà hữu cơ chứa vitamin B12, nếu cơ thể có sự thiếu hụt vitamin này có thể gây ra bệnh thiếu máu. Vitamin B12 có thể ngăn ngừa mất trí nhớ, thúc đẩy tâm trạng và năng lượng, làm chậm quá trình lão hóa, và tăng cường hệ thống miễn dịch cho cơ thể. Vì gan gà có lượng vitamin A thấp hơn so với gan bê hay gan vịt, nên bạn cần ăn gan gà thường xuyên hơn.'),(154,13,'gan heo.jpg','Gan heo',1.16,'Gan lợn có giá trị dinh dưỡng cao bởi có nhiều chất đạm, sắt, vitamin nhóm B, các loại men như men tiêu hóa, men thải độc, tốt cho người thiếu máu, mù màu, còi xương. Chưa hết, vitamin A có trong gan còn có tác dụng bổ mắt, tăng cường sức đề kháng, sinh trưởng và phát triển ở trẻ. Nghiên cứu của y học hiện đại cũng cho thấy, trong 100g gan lợn chứa 21,3 g protein, 25 mg sắt, 8.700 mcg vitamin A, vitamin B, D, axit folic, nicotilic…'),(155,13,'gan vịt.jpg','Gan vịt',1.22,'Gan vịt cũng tương tự gan ngỗng, là thực phẩm phổ biến ở Pháp và đôi khi tương đối đắt. Gan vịt giàu protein, khoáng chất và vitamin bao gồm nguyên tố đồng, vitamin A, và 9 axit amin thiết yếu. Đồng là nguyên tố vi lượng cần thiết cho cơ thể con người. Chúng còn rất quan trọng trong việc xây dựng xương, kích thích hoóc môn, và điều chỉnh nhịp tim của bạn. Hiệp hội Ung thư Mỹ đã chỉ ra rằng đồng có tính chống ôxy hóa và có thể giúp chống lại bệnh ung thư.'),(156,13,'giò bò.jpg','Giò bò',3.57,'Với giò bò chuẩn, người ta dùng chút mỡ lợn vào cùng với thịt bò. Như đã nói ở trên, mỡ giúp cho giò mềm, thơm, ngậy. Nhưng nếu dùng mỡ bò sẽ rất đậm mùi, nên những cơ sở sản xuất giò bò đã dùng mỡ lợn, với tỷ lệ khoảng 20% mỡ, còn lại là thịt bò.'),(157,13,'giò lụa.jpg','Giò lụa',1.36,'Giò lụa, giò chả hay chả lụa (phương ngữ Nam bộ) là tên gọi của món ăn được làm từ hai nguyên liệu cơ bản là thịt nạc thăn lợn giã nhuyễn kết hợp với nước mắm ngon, gói trong lá chuối và luộc chín. Thịnh hành trong ẩm thực Việt Nam từ Bắc xuống Nam như một món ăn vừa phổ thông vừa sang trọng, giò lụa giòn và thơm đậm mùi thịt tươi luộc cộng với mùi đặc trưng của lá chuối tươi được luộc chín.'),(158,13,'giò thủ.jpg','Giò thủ',5.53,'Giò thủ được làm bằng phần thịt thủ lợn, bao gồm các phần như tai, mũi, lưỡi, bì, mỡ và nạc lọc từ thủ của lợn (heo), thậm chí bao gồm cả phần thịt ở chân giò. Thành phần thường gặp thứ nữa là mộc nhĩ đen (nấm mèo), nấm hương (hay nấm đông cô). Gia vị đi kèm thường bao gồm hạt tiêu, hành khô, nước mắm.'),(159,13,'huyết bò.jpg','Huyết bò',0.75,'Món huyết bò xào lá hẹ lạ miệng, rất bắt cơm nhờ có vị ngọt của huyết cùng vị cay, mùi thơm nồng của các loại gia vị và lá hẹ.'),(160,13,'huyết heo sống.jpg','Huyết heo sống',0.25,'Theo y học cổ truyền, huyết heo có vị mặn, tính bình, dùng trị choáng váng, đầy bụng xốn xáo; có tác dụng hỗ trợ giúp ngăn ngừa thiếu máu cho những người đang trong quá trình ăn kiêng giảm béo.'),(161,13,'lạp xưởng.jpg','Lạp xưởng',5.85,'Lạp xưởng có chứa nhiều Lipid, Protid, Canxi… Ăn lượng vừa đủ tốt cho sức khỏe, nhưng ăn quá nhiều sẽ gây hại. Ngoài liều lượng ăn thì khi tiêu thụ lạp xưởng, bạn còn cần chú ý cách ăn, thực phẩm kết hợp.'),(162,13,'ruột già heo.jpg','Lòng heo (ruột già)',1.67,'Ruột già Heo còn gọi Trư đại tràng, Trư Phao là một trong những phủ tạng của Heo thường được người dân dùng chữa bệnh và bồi dưỡng sức khoẻ từ lâu đời. Nếu ruột già Heo được làm sạch và chế biến phối ngũ đúng không chỉ là món ngon bổ dưỡng còn được xem là vị thuốc quý chữa nhiều bênh hiệu quả.'),(163,13,'lưỡi bò.jpg','Lưỡi bò',1.64,'Lưỡi bò là phần thịt giá trị có thể đem lại một bữa ăn ít tốn kém cho cả gia đình. Mặc dù giá rẻ nhưng chất lượng của thịt cũng không thấp. Trên thực tế, nhờ hương vị đậm đà mà lưỡi bò được xem là thực phẩm xa xỉ vào thời xưa khi người ta không qua khe khắt. Việc học cách chế biến lưỡi bò đúng cách sẽ giúp bạn chuẩn bị được một món ăn đặc biệt và giàu dinh dưỡng.'),(164,13,'lưỡi heo.jpg','Lưỡi heo',1.78,'Lưỡi lợn là món ngon, tinh túy trong ngũ tạng con lợn, trong đó, “đầu lưỡi chủ tâm, giữa lưỡi chủ tỳ, rìa lưỡi chủ can, gốc lưỡi chủ thận”. Lưỡi lợn rất giàu protid, Ca, P; Mg; Fe, vitamin E, B1, B2, PP, B6, D, acid folic, B12… rất tốt cho trẻ em còi cọc, người có tuổi mệt mỏi khó lên cân do thiếu đạm.'),(165,13,'mề gà.jpg','Mề gà',0.99,'Màng mề gà có vị ngọt, tính bình, có tác dụng bổ tỳ vị, giúp tiêu hoá, chữa các chứng đau bụng, ăn uống kém, bụng đầy trướng, khó tiêu, đại tiện lỏng, viêm ruột già, đái són. Màng mề gà cho vị thuốc kê nội kim.'),(166,13,'nem chua.jpg','Nem chua',1.37,'Nem chua là món ăn truyền thống của Việt Nam. Ngoài giá trị dinh dưỡng cao, nem chua còn cung cấp hệ vi sinh vật có lợi (vi khuẩn lactic) có tác dụng tăng cường chức năng miễn dịch, ức chế một số bệnh đường ruột và kích thích tiêu hóa.'),(167,13,'óc bò.jpg','Óc bò',1.24,'Óc bò là một loại thực phẩm giàu chất dinh dưỡng, giúp bồi bổ cơ thể, tăng cường sức khỏe. Đặc biệt phospholipid có trong óc bò giúp bồi bổ tế bào thần kinh, phát triển và tăng cường hoạt động của các hóc môn sinh dục. Óc bò có nhiều cách chế biến nhưng hấp dẫn nhất vẫn là món óc bò nấu hành.'),(168,13,'óc heo.jpg','Óc heo',1.23,'Ăn óc heo đúng cách. Trong óc heo chứa những khoáng chất phổ biến như: Canxi, phốt pho, sắt và hàm lượng cholesterol có tác dụng nhất định trong việc bồi bổ xương khớp, có thể hạn chế hoặc cải thiện được chứng đau đầu, chóng mặt hay suy nhược thần kinh.'),(169,13,'pate.jpg','Patê',3.26,'Cách làm pate thịt nguội hay còn gọi là pate da heo kiểu miền Tây, được biến tấu từ món pate truyền thống của Pháp. Nhưng pate thịt nguội được nhồi trong bong bóng heo, có vị gần như jambon, dai giòn hơn so với pate.'),(170,13,'phèo heo.jpg','Phèo heo',0.44,'Phèo thực chất là phần ruột non của lợn, bò đã làm thịt. Đây là một phần của hệ tiêu hóa sau dạ dày và trước ruột già. Đây là nơi diễn ra quá trình tiêu hóa và hấp thụ chất dinh dưỡng của phần lớn thức ăn được đưa vào cơ thể.'),(171,13,'sườn heo bỏ xương.jpg','Sườn heo bỏ xương',1.87,'Sườn thăn là một trong những nguyên liệu tuyệt vời, có thể chế biến thành đa dạng các món ăn ngon.'),(172,13,'thịt tai heo.jpg','Tai heo',1.21,'Món tai heo không còn xa lạ với mọi người nhưng không hẳn ai cũng biết những công thức chế biến món ăn ngon này. Tai heo dễ làm, ăn không ngán, đảm bảo mọi người sẽ thích mê.'),(173,13,'thịt bê.jpg','Thịt bê nạc',0.85,'Thịt bê là loại thịt bò được lấy từ con bê hay bò tơ. Thịt bê có nhiều chất dinh dưỡng tốt cho sức khỏe, thịt loại có thớ nhỏ sẽ mềm, thớ to[1] và được chế biến thành nhiều món ăn ngon đặc biệt là món bê thui ở Việt Nam. Trên thế giới, thịt bê đã được một thành phần quan trọng trong ẩm thực Ý và ẩm thực Pháp từ thời cổ đại.'),(174,13,'thịt dê nạc.jpg','Thịt dê nạc',1.22,'Thịt dê có mùi vị thơm ngon, có tác dụng bổ dưỡng, giữ ấm rất tốt, rất thích hợp ăn trong mùa lạnh. Nhìn chung, thịt dê có tác dụng thúc đẩy lưu thông máu,  tăng thân nhiệt, có ích trong chữa trị bệnh lao,…'),(175,13,'thịt gà ta.jpg','Thịt gà ta',1.99,'Thịt gà rất giàu selenium, loại khoáng chất cần thiết giúp cải thiện quá trình trao đổi chất trong cơ thể. Chất này cũng rất hiệu quả trong việc tăng cường hoạt động tuyến giáp và hệ miễn dịch. Những đặc tính này hỗ trợ giảm cân cũng như giúp tránh xa các loại bệnh tật.'),(176,13,'thịt gà tây.jpg','Thịt gà tây',2.18,'Thịt gà tây được tin là giúp phòng ngừa ung thư nhờ có chứa làm lượng selenium cao. Đây là một khoáng chất cần thiết để đảm bảo chức năng lành mạnh của tuyến giáp và hệ miễn dịch. Đồng thời đây cũng là chất chống oxy hóa mạnh giúp chống lại các gốc tự do có thể gây ung thư trong cơ thể.'),(177,13,'thịt ba chỉ.jpg','Thịt heo ba chỉ',2.6,'Theo dinh dưỡng học cổ truyền, thịt ba ba vị ngọt, tính bình, có công dụng dưỡng âm lương huyết, bổ hư nhuyễn kiên và kháng ung, thường được dùng làm thức ăn bổ dưỡng cho người tạng nhiệt, hay nóng trong, mồ hôi ra nhiều…'),(178,13,'thịt heo mỡ.jpg','Thịt heo mỡ',3.94,'Lượng vitamin D trong mỡ lợn có tác dụng giúp cải thiện chức năng tim mạch, duy trì sức khỏe của phổi và hô hấp, tăng cường chức năng cơ bắp và giúp cơ thể phòng chống nhiễm trùng. Mỡ lợn chứa khoảng 40% chất béo bão hòa, khoảng 50% chất béo không bão hòa đơn và khoảng 10% chất béo không bão hòa đa.'),(179,13,'thịt lợn nạc.jpg','Thịt lợn nạc',1.39,'Khi khô, hàm lượng protein của thịt lợn nạc có thể lên tới 89% - làm cho nó trở thành một trong những nguồn protein giàu dinh dưỡng nhất. Thực phẩm này cũng chứa tất cả chín axit amin thiết yếu cần thiết cho sự tăng trưởng và phát triển cơ thể của bạn.'),(180,13,'thịt mông chó.jpg','Thịt mông chó',3.38,'Thịt chó được dùng trị tì thận khí hư, sưng vú, lưng đùi yếu mỏi. Ngoài ra mật chó cũng có tác dụng tương đối tốt, nó trị đau mắt đỏ, thổ huyết, ...'),(181,13,'thịt ngỗng.jpg','Thịt ngỗng',4.09,'Theo Đông y, thịt ngỗng vị ngọt, tính bình, chủ trị lợi tạng, ích khí, bổ hư, hoà vị, ngừng tiêu khát. Máu ngỗng cũng được dùng làm thuốc chữa nấc, buồn nôn. Chữa tiêu khát: Ninh thịt ngỗng thật nhừ rồi uống nước.'),(182,13,'thịt thỏ.jpg','Thịt thỏ',1.58,'Thịt thỏ có hàm lượng đạm cao nhưng ít chất béo và cholesterol nên là món ăn tốt với người huyết áp cao và các bệnh về tim mạch. Thường xuyên ăn thịt thỏ giúp cơ bắp đầy đặn, chắc khoẻ, chống lão hóa. Theo Đông y, thịt thỏ tính mát, bổ gân, mát máu, ích khí, mượt da, giải độc, khử nhiệt.'),(183,13,'thịt chó.jpg','Thịt vai chó',2.3,'Theo Đông y, thịt chó (cẩu nhục) vị mặn, chua, tính nóng, không độc; có tác dụng bổ dưỡng, trợ dương, ích khí trừ hàn. Thịt chó có chứa nhiều protid, lipid, Ca, P, Fe.'),(184,13,'thịt vịt.jpg','Thịt vịt',2.67,'Theo Đông y, thịt vịt tính hàn, vị ngọt, hơi mặn, không độc, có tác dụng bổ huyết, giải độc, thanh nhiệt dưỡng âm, lợi thấp nhiệt, điều hòa ngũ tạng…, di tinh, khô miệng, điều hòa kinh nguyệt…'),(185,13,'tim bò.jpg','Tim bò',0.89,'Tim bò là loại thịt giàu chất đạm bao bọc bởi mỡ. Mặt ngoài đa phần là mỡ và màng bao. Bên trong là các tĩnh mạch và dây chằng.'),(186,13,'tim gà.jpg','Tim gà',1.14,'Tim gà cung cấp 16 g chất đạm, 5,5 g chất béo. Cật lợn cung cấp 89 kcalo, 13 g chất đạm và 3,1g chất béo... Như vậy, có thể thấy tim cật là thực phẩm giàu chất đạm, giúp bồi bổ  tốt cho một số người nhưng lại có thể không tốt đối với người khác.'),(187,13,'tim heo.jpg','Tim heo',0.89,'Tim lợn còn hỗ trợ chữa chứng tim hồi hộp, chứng đau đầu, chóng mặt nhờ kết hợp với các vị thuốc Bắc. Công dụng: chữa các chứng tim hồi hộp, bồn chồn, suy nghĩ, lo lắng, mất ngủ suy nhược thần kinh, ngủ hay giật mình.'),(188,13,'xúc xích.jpg','Xúc xích',5.35,'Xúc xích chứa hóa chất, chất phụ gia, chất bảo quản, buộc gan phải hoạt động nhiều để giải độc cho cơ thể. Xúc xích là món ăn nguy hiểm gây hại cho sức khỏe. Ăn nhiều xúc xích (cũng như các thực phẩm chế biến sẵn), sẽ dẫn đến tình trạng thừa năng lượng dẫn đến béo phì, dễ mắc các bệnh tim mạch, tiểu đường, ung thư...'),(189,14,'ba khía muối.jpg','Ba khía muối',0.83,'Ba khía sau khi bắt xong, người dân sẽ xóc rửa cho sạch bùn đất rồi đổ vào lu, khạp có nước muối và đậy nắp kín lại. Từ khi muối cho đến lúc ăn được có thể 5-10 ngày. Chất lượng của ba khía phụ thuộc độ mặn của nước muối, bởi nếu nhạt quá thì ba khía sẽ hư nhưng mặn quá sẽ rụng càng, đen da, chát thịt... Ba khía muối chính là món ăn ăn mà hầu như không một người dân nào ở miền sông nước nào không biết đến, đặc biệt đây còn được xem là món khoái khẩu của nhiều người.'),(190,14,'bánh phồng tôm.jpg','Bánh phồng tôm',6.76,'Bánh phồng tôm là đặc sản vùng Tây Nam Bộ, là món ăn hương vị thơm ngon, giòn tan, béo ngậy gây nghiện, và lại được chiên với dầu khiến nhiều người lo sợ món ăn này có thể tích mỡ cho cơ thể.'),(191,14,'cá bống.jpg','Cá bống',0.7,'Theo sách Tuệ Tĩnh “cá bống vị ngọt mặn, tính bình không độc, tác dụng khoan trung, tiêu thức ăn, ấm tỳ vị ăn nhiều ngày rất tốt”. Cá bống rất tốt cho người bị chứng tỳ hư bụng đầy, đàm thấp ho thở, đau tức ngực sườn, nhức mỏi, người bị hư nhược liên quan tỳ phế hư đàm thấp trệ dùng đều tốt...'),(192,14,'cá chép.jpg','Cá chép',0.96,'Theo Đông y, cá chép là dương tính trong âm tính, có tác dụng lợi tiểu tiện, cho nên có thể chữa được bệnh khi kết lạnh; bình phổi thông sữa, làm sạch đường tiêu hóa, bài tiết và trừ khử được tả độc sưng tấy. Cá chép còn được coi là thuốc tiên chữa bệnh phụ nữ.'),(193,14,'cá đối.jpg','Cá đối',1.08,'Thịt cá đối là một thực phẩm ngon và giàu chất dinh dưỡng. Về thành phần hóa học, trong 100g thịt cá đối có 76g nước, 19,5g protid, 3,3g lipid, 21mg canxi, 224mg photpho, 1mg sắt và nhiều loại vitamin.'),(194,14,'cá diếc.jpg','Cá diếc',0.87,'Cá diếc còn có tên gọi là tức ngư, phụ ngư… Trong Đông y, cá diếc vị ngọt, tính ấm, không độc, có tác dụng bổ tỳ kiện vị, ích khí, bổ huyết, hành thủy, tiêu thũng, tiêu khát, sát khuẩn, dùng cho các trường hợp suy nhược cơ thể, đầy bụng, tiêu hóa kém, thúc đẩy việc tạo sữa, trị viêm đại tràng mạn tính, chữa vàng da…'),(195,14,'cá hồi.jpg','Cá hồi',1.36,'Cá hồi luôn là thức ăn được nhiều người lựa chọn vì hương vị thơm ngon, sự phong phú đa dạng trong cách chế biến và những lợi ích cho sức khỏe mà nó mang lại.'),(196,14,'cá khô.jpg','Cá khô',2.08,'Cá khô là một loại hải sản được rất nhiều người mê, đặc biệt là khi trời lạnh, cá khô hấp dẫn nhất khi được rán, chiên, rim mắm…'),(197,14,'cá lóc.jpg','Cá lóc',0.97,'Không chỉ được dùng làm thực phẩm, cá lóc còn được sử dụng trong điều trị bệnh. Theo Đông y, cá lóc có vị ngọt, tính bình, không độc, có tác dụng bổ khí huyết, gân xương, trừ đàm (dùng tốt cho những trường hợp bị các bệnh phổi), chữa phụ nữ ít sữa, bồi bổ cho người mới khỏi bệnh vì dễ hấp thu.'),(198,14,'cá mè.jpg','Cá mè',1.44,'Cá mè vị ngọt, tính ấm, không độc, có tác dụng bổ não tủy, nhuận phế, ích tỳ vị. Trong sách thuốc cổ có ghi: Thịt cá mà trắng có tác dụng khai vị, hạ khí, điều hòa ngũ tạng, chống hư huyết mạch, bổ gan, sáng mắt. Dùng cho các trường hợp tỳ vị hư hàn, ăn kém, đau bụng, đầy bụng, da thô ráp, tróc da và da khô.'),(199,14,'cá mỡ.jpg','Cá mỡ',1.51,'mỡ cá chính là nguồn cung cấp nhiều Omega 3 nhất. Công dụng của nó là ngăn ngừa chứng nghẽn mạch máu và đột quỵ, bên cạnh đó còn giúp chống viêm, ngăn ngừa đông máu, hạn chế tốt hiện tượng tim đập loạn nhịp giúp tăng cường hoạt động ghi nhớ của não và giúp tinh thần trở nên hoạt bát hơn.'),(200,14,'cá mòi.jpg','Cá mòi',1.24,'Cá mòi được coi là một loại cá có giá trị lớn tốt cho sức khỏe. Một số chất dinh dưỡng có trong cá mòi được biết là giúp ngăn ngừa bệnh tim hoặc có thể bảo vệ chống lại một số bệnh ung thư.'),(201,14,'cá nạc.jpg','Cá nạc',0.8,'Là loài cá có thịt ngọt và thơm. Thêm chút thịt và gia vị sẽ có ngay món chả cá nạc thơm ngon béo ngậy.'),(202,14,'cá ngừ.jpg','Cá ngừ',0.87,'Cá ngừ có nhiều thịt, ít xương và có hương thơm hấp dẫn, là nguyên liệu cho các món sashimi, sushi của người Nhật. Ngoài ra cá ngừ còn chế biến thành nhiều món ăn ngon khác như salad cá ngừ, cá ngừ kho thơm,...'),(203,14,'cá nục','Cá nục',1.11,'Cá nục là loại thực phẩm có giá trị dinh dưỡng cao và rất có lợi cho sức khỏe. Cá nục làm giảm nguy cơ tiểu đường.'),(204,14,'cá phèn.jpg','Cá phèn',1.04,'Cá phèn có chứa nhiều chất dinh dưỡng như vitamin A, vitamin C, vitamin D, vitamin B và protein. Cực kỳ tốt cho sức khỏe của con người. Giúp cơ thể hấp thụ chất dinh dưỡng tốt hơn, có sức đề kháng hơn. Ngoài ra, loài cá này có có nhiều hàm lượng omega 3 cao, có thể bằng lượng omega 3 có ở loài cá hồi.'),(205,14,'cá quả.jpg','Cá quả (cá lóc)',0.97,'Theo y học cổ truyền, cá lóc vị ngọt, tính bình, không độc, có tác dụng bổ khí huyết, gân xương, trừ đàm (dùng tốt cho những trường hợp bị các bệnh phổi), chữa phụ nữ ít sữa, bồi bổ cho người mới khỏi bệnh vì dễ hấp thu.'),(206,14,'cá rô đồng.jpg','Cá rô đồng',1.26,'Rô đồng là loài cá nước ngọt, sống phổ biến ở các ao, ruộng lúa, ao đìa, sông rạch... Mùa sinh sản chủ yếu vào tháng 5 - 7.  Cá rô  đồng có màu xanh từ xám đến nhạt, phần bụng có màu sáng hơn phần lưng, với một chấm màu thẫm ở đuôi và chấm khác ở sau mang. Chúng có răng chắc, sắc, xếp thành dãy trên hai hàm. Đây là loại thực phẩm dân dã, ngon và bổ. Theo phân tích thành phần dinh dưỡng, trong 100g thịt cá rô đồng chứa chất đạm 20,3g, chất béo 1,5g, và các chất khoáng vi lượng như can xi, phosphor, sắt,  vitamin B1, B2…'),(207,14,'cá rô phi.jpg','Cá rô phi',1,'Cá rô phi có nhiều chất dinh dưỡng, vitamin và khoáng chất, trong đó có một lượng đáng kể protein, axit béo, selen, phốt pho, kali, vitamin B12, niacin, vitamin B6 và axit pantothenic... Những chất này rất tốt cho sự tăng trưởng và phát triển của cơ thể.'),(208,14,'cá thu.jpg','Cá thu',1.66,'Cá thu được xếp vào trong 4 loại cá đặc sản ngon của biển, thịt thơm và bổ dưỡng. Cá thu là một trong những loại cá biển có thịt thơm ngon, nhiều giá trị dinh dưỡng như chất béo, chất đạm. Cá thu là sự tổng hợp của những vitamin và khoáng chất hàng đầu mà cơ thể cần thiết. Thịt cá thu rất giàu vitamin A, D, magie, kẽm, phốt pho, canxi,... giàu dinh dưỡng và năng lượng.'),(209,14,'cá trắm cỏ.jpg','Cá trắm cỏ',0.91,'Cá trắm có vị ngọt, tính bình, có công năng bổ thận khí, mạnh tỳ dưỡng vị, bình can sáng mắt, hóa thấp, khứ phong, lợi thủy. Cá trắm rất thích hợp với những người tỳ vị hư nhược, mất sức, phù nề, viêm gan, thận, tê thấp.'),(210,14,'cá trê.jpg','Cá trê',1.73,'Nhiều người thích ăn cá trê vì thịt thơm, chắc, ít xương dăm và có thể nấu thành nhiều món ăn hấp dẫn như chiên, nấu canh hay kho… Bên cạnh đó, cá trê còn giúp hỗ trợ điều trị nhiều loại bệnh.'),(211,14,'chà bông cá lóc.jpg','Chà bông cá lóc',3.12,'Chà bông cá lóc là món khoải khẩu của rất nhiều người, trong đó đặc biệt là người già và trẻ em. Món ăn có vị thơm ngọt và để được lâu.'),(212,14,'cua biển.jpg','Cua biển',1.03,'Công dụng: bổ khí, huyết, ích xương cốt, chữa khí huyết hư, nhức mỏi gân xương. Dùng thích hợp với người già, trẻ em, phụ nữ khí huyết hư, xương cốt yếu. Lưu ý: Cua biển giàu đạm. Người đang cần giảm cân, bệnh gút; người hay dị ứng cua ghẹ nên kiêng hoặc hạn chế dùng.'),(213,14,'cua đồng.jpg','Cua đồng',0.87,'Chúng sinh sản quanh năm nếu môi trường thuận lợi, tập trung vào mùa xuân, mùa hè, mùa thu. Đông y sử dụng cua đồng làm thuốc với tên là điền giải và cho rằng cua đồng có vị mặn, tính hàn, hơi độc, có tác dụng sinh phong liền gân nối xương; dùng trị nhiệt tà, bạt độc, trừ ghẻ lở và máu kết cục…'),(214,14,'ghẹ.jpg','Ghẹ',0.54,'Một số nghiên cứu dinh dưỡng còn ghi nhận ghẹ giúp làm giảm cholesterol xấu và triglycerides trong máu. Thịt ghẹ có vị ngọt, mặn, không độc, có tác dụng thanh nhiệt, sinh huyết, tán ứ, giảm đau, bổ xương tuỷ nên rất tốt cho cơ thể đang phát triển ở trẻ nhỏ và tình trạng suy yếu ở người cao tuổi.'),(215,14,'hải sâm.jpg','Hải sâm',0.9,'Hải sâm là vị thuốc Đông y có khả năng chống lại xơ vữa động mạch, bổ thận tráng dương, suy nhược cơ thể, điều trị viêm phế quản, liệt dương, di tinh...Theo Đông y, hải sâm có vị mặn, tính ấm tác dụng bổ thận, tráng dương, ích tinh, dưỡng huyết, nhuận táo, chống lão hóa, giảm ho, tiêu độc... Hải sâm thường được dùng trong các trường hợp tâm khí hư, thận khí suy, khí huyết kém, suy nhược cơ thể, suy nhược thần kinh, di tinh, liệt dương, tiểu tiện khó, tiểu buốt, táo bón…'),(216,14,'hến.jpg','Hến',0.45,'Hến là một loại thực phẩm chứa nhiều vitamin B12 và sắt, rất tốt cho những người bị thiếu máu. Tốt cho người bị tim mạch: Hến ít chất béo, ít cholesterol và nhiều axit béo Omega-3 nên đây cũng là món ăn rất tốt cho những người có bệnh tim mạch.'),(217,14,'lươn.jpg','Lươn',0.94,'Lươn tính ôn, vị ngọt, có công hiệu bổ khí dưỡng huyết, làm mạnh gân cốt; thích hợp với các chứng lao lực, ho hen, tiêu khát, kiết lỵ, phong thấp đau nhức, thận hư, đau lưng, bổ trí não.'),(218,14,'mực khô.jpg','Mực khô',2.91,'Mực khô là món ăn không còn xa lạ gì với người Việt Nam, đặc biệt là cánh mày râu. Thường chỉ xuất hiện với tư cách là món \"khai vị\" nhấm nháp trong các bữa nhậu hay khi nhà có tiệc tùng. Tuy nhiên, tác dụng của mực khô lại có lợi cho sức khỏe của con người hàng ngày. Mực không chỉ được yêu thích bởi hương thơm và vị ngon ngọt, mà còn đem lại cho người tiêu dùng nhiều giá trị dinh dưỡng tuyệt vời ít ai biết đến.'),(219,14,'mực tươi.jpg','Mực tươi',0.73,'Mực là một loài động vật thân mềm, sống chủ yếu ngoài biển khơi. Là loại hải sản với giá trị dinh dưỡng cao, mực là một thực phẩm chứa rất nhiều protein và các nguồn khoáng chất thiết yếu như Riboflavin, Vitamin B12, phốt pho, đồng và Selen. Nó cũng là một nguồn tốt của Niacin và kẽm, mực còn được đánh giá cao do chứa ít chất béo bão hòa và ít natri nhưng bên cạnh đó mực tươi chứa nhiều cholesterol.'),(220,14,'ốc bươu.jpg','Ốc bươu',0.84,'Ốc bươu hay ốc bưu, là tên gọi chỉ chung cho các động vật thân mềm chân bụng có vỏ tròn, có kích thước trung bình, đít tròn, có vỏ màu nâu đen cho đến đen tuyền, và thường dùng làm đồ ăn.'),(221,14,'ốc vặn.jpg','Ốc vặn',0.72,'Ốc vặn là loài thủy sản quen thuộc ở Việt Nam không chỉ là món ăn ngon miệng cho người Việt mà ốc vặn còn có nhiều giá trị dinh dưỡng. Theo đông y, ốc vặn có tính hàn, vị ngọt, thịt ốc có nhiều dưỡng chất tốt cho cơ thể như canxi, photpho…'),(222,14,'sò.jpg','Sò',0.51,'Sò - một loài động vật nhuyễn thể, vỏ cứng có khía dọc nổi rõ, họ sò hến, ở biển. Người tiêu dùng phân biệt, có sò huyết, sò gạo và sò lông; sò huyết to bằng ngón chân cái người lớn, vỏ thẫm, không có lông, thịt đỏ, dịch (máu) màu đỏ; sò gạo nhỏ hơn, thịt màu ngà, vỏ ở gần miệng có lông; sò lông to hơn ngón chân cái người lớn, vỏ bao phủ một lớp lông, thịt trắng ngà.'),(223,14,'tép gạo.jpg','Tép gạo',0.58,'Đây là loài tôm nhỏ khoảng 30–50 mm, thuộc phân bộ Pleocyemata, bộ Giáp xác mười chân, có màu xanh nhạt hoặc trắng, trong suốt.'),(224,14,'tép khô.jpg','Tép khô',2.69,'Tép biển khô còn có tên gọi khác là moi hoặc tép, ruốc…, là một món ăn dân dã, dễ ăn và dễ chế biến. Tép khô có thể chế biến thành nhiều món ăn ngon. Không chỉ có hương vị tuyệt vời, tép khô còn có nhiều lợi ích cho sức khỏe.'),(225,14,'tôm biển.jpg','Tôm biển',0.82,'Tôm biển giàu protid, canxi, phospho, sắt, vitamin B1, B2, PP, ngoài ra còn có cholesterol, melatonin, acid béo omega - 3, vỏ tôm có các polysaccharid. Theo Đông y, tôm biển vị ngọt, mặn, tính ôn; vào can, tỳ, phế, thận.'),(226,14,'tôm đồng.jpg','Tôm đồng',0.9,'Tôm đồng rất tốt cho những người muốn giảm hoặc duy trì cân nặng vì nó chứa chất béo thấp cũng như mức carbohydrate. Tôm đồng giúp thực hiện chế độ ăn uống lành mạnh và bổ dưỡng. Hải sản này có thể ăn thêm cùng với các loại rau và salad giúp tăng thêm hương vị cho bữa ăn.'),(227,14,'tôm khô.jpg','Tôm khô',3.47,'Tôm khô là một món ăn cũng như là một thành phần rất quen thuộc của nhiều gia đình. Tôm khô tự làm đảm bảo chất lượng và hợp vệ sinh.'),(228,15,'trai.jpg','Trai',0.38,'Thịt trai sông chứa 4,6% protid, 1,1% lipid, 16,4 mgʻ% Ca, 102 mg% P, 70 – 100 mg% Zn, 11,1 mg% Fe, 0,02 mg% vitamin B,, 0,18 mgʻ%b vitamin B, 1,2 mg% vitamin PP, 9 mg% vitamin C (Viện Dinh dưỡng). Vỏ trai sông chứa Ca dưới dạng carbonat và chất chitin. Thịt trai sông có vị ngọt, mặn, tính hàn, có tác đụng lợi thấp, thanh nhiệt, tiêu khát, hạ huyết áp. Vỏ trai sông có vị mặn, tính hàn, có tác dụng giảm đau, chống viêm, tiêu tích, minh mục, hóa đờm.'),(229,15,'lòng đỏ trứng gà.jpg','Lòng đỏ trứng gà',3.27,'Năm 1961, Hiệp hội Tim mạch Hoa Kỳ khuyến cáo người tiêu dùng nên hạn chế tiêu thụ cholesterol trong mỗi bữa ăn, vì đây là nguyên nhân của các bệnh về tim mạch. Lòng đỏ trứng cung cấp lớn lượng cholesterol. Do đó, để tránh ảnh hưởng xấu tới sức khỏe, mọi người cần hạn chế ăn lòng đỏ. Tuy nhiên, theo những nghiên cứu gần đây, các tổ chức sức khỏe ở nhiều nước đã dần bỏ đi những khuyến cáo về việc giới hạn lượng cholesterol nạp vào cơ thể mỗi ngày. Theo cách giải thích mới, gan chúng ta mỗi ngày đều sản xuất ra cholesterol vì đó là một chất cần cho cơ thể. Nếu chúng ta ăn những thực phẩm giàu cholesterol thì gan sẽ sản xuất ít cholesterol hơn. Ngược lại, nếu chúng ta tiêu thụ ít cholesterol thì gan sẽ phải làm việc nhiều hơn để sản xuất chất này. Ngoài ra, cholesterol không phải hoàn toàn xấu.'),(230,15,'lòng đỏ trứng vịt.jpg','Lòng đỏ trứng vịt',3.68,'Lòng đỏ trứng có hàm lượng vitamin cao, đặc biệt là những vitamin tan trong chất béo và tan trong nước. Sau đây là hàm lượng vitamin  có trong 1 quả trứng tiêu chuẩn: thiamin 0,030mg; riboflavin 0.090mg; niacin 0.004mg; vitamin B6 0.059mg; vitamin B9 (folate) 25microgram (μg); vitamin B12 0,33μg; vitamin A, RAE 65μg; vitamin A, IU 245IU; vitamin E 0.44mg; vitamin D (D2 và D3) 0,9μg; vitamin D 37IU; vitamin K 0.1μg; Lòng đỏ trứng cũng có nhiều hợp chất, vitamin, chất dinh dưỡng khác có lợi cho sức khoẻ.'),(231,15,'lòng trắng trứng gà.jpg','Lòng trắng trứnggà',0.46,'Lòng trắng trứng gà ít calo, giàu protein, canxi có lợi cho xương và răng, chứa selenium ngừa ung thư, không cholesterol tốt cho người bệnh tim…'),(232,15,'lòng trắng trứng vịt.jpg','Lòng trắng trứngvịt',0.5,'Lòng trắng trứng chứa rất ít chất béo bão hòa và cholesterol, là nguồn dinh dưỡng cung cấp protein, Vitamin B2, Selen. Tuy nhiên, lòng trắng trứng lại chứa nhiều Natri.'),(233,15,'trứng gà.jpg','Trứng gà',1.66,'Trứng gà được xem là “siêu thực phẩm”, rất rẻ, dễ chế biến và tác dụng trứng gà mang đến cho cơ thể rất nhiều. Trứng gà được dùng rất phổ biến ở Việt Nam, trong trứng chứa nhiều dưỡng chất và rất an toàn.'),(234,15,'trứng vịt.jpg','Trứng vịt',1.84,'Trứng vịt là món  ăn ngon và khá phổ biến đối với nhiều gia đình vì món  ăn  giàu chất dinh dưỡng và đặc  biệt có thể bổ sung đầy đủ nguồn dinh dưỡng cần thiết. Trứng vịt có rất nhiều công dụng cho sức khỏe người dùng như phòng ngừa bệnh về tim mạch, ngăn chặn lão hóa về mắt nhờ sự kết hợp của các Vitamin A,B2 và Lutein. Do vậy có thể kết luận trứng vịt khá tốt cho cơ thể nếu được cung cấp một lượng vừa đủ.'),(235,15,'trứng vịt lộn.jpg','Trứng vịt lộn',1.82,'Trứng vịt lộn là món ăn bổ dưỡng, bồi bổ sức khỏe rất tốt và hiệu quả. Tuy nhiên, do trứng chứa thành phần dinh dưỡng cao. khi sử dụng trứng vịt lộn cần phải dùng đúng liều lượng và sử dụng đúng cách mới có thể hiệu quả. Trứng vịt lộn đã được coi là một món ngon, vị thuốc bổ.');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_Id` int(11) NOT NULL AUTO_INCREMENT,
  `role_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_Id`),
  UNIQUE KEY `APP_ROLE_UK` (`role_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(255) NOT NULL,
  `image` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `date_Of_Birth` date DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `hashtag` varchar(255) DEFAULT NULL,
  `enable` char(1) NOT NULL,
  PRIMARY KEY (`user_Id`),
  UNIQUE KEY `APP_USER_UK` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'admin','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu','dat@gmail.com',NULL,NULL,NULL,NULL,NULL,'1'),(2,NULL,'dat','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu','admin@gmail.com',NULL,NULL,NULL,NULL,NULL,'1'),(3,NULL,'thao','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu','thao@gmail.com',NULL,NULL,NULL,NULL,NULL,'0'),(4,NULL,'thaogio1','$2a$10$9tLp4OYWhKVWQXcGH4LEj.9ATwOtyCR93Yxr8MjPxq18JuFmQLetm','y@gmail.com',NULL,NULL,NULL,NULL,NULL,'1'),(5,NULL,'thaobeo','$2a$10$edbstw.N/Z10bNN7DComjePJtSJAXqfg9lFZo8T8joRqwJH4FSMGy','2@gmail.com',NULL,NULL,NULL,NULL,NULL,'1'),(6,NULL,'thaobeo1','$2a$10$YvxIuDGyaqe43lrwrX4Hy.6khSI2REgbG/coXIL884I9zgbaiedyu','12@gmail.com',NULL,NULL,NULL,NULL,NULL,'1'),(7,NULL,'thao123','$2a$10$6RilLfUBHnhnEgAfOY9IFuCzlkViE56S2V.WexX0FssGmNp5sLhTC','thao121@gmail.com',NULL,NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_history` (
  `user_History_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `height` float NOT NULL,
  `weight` float NOT NULL,
  `bmi` float NOT NULL,
  `desire` varchar(255) CHARACTER SET utf8 NOT NULL,
  `track_Results` varchar(255) CHARACTER SET utf8 NOT NULL,
  `creation_Date` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`user_History_Id`),
  KEY `FKaa6ilb6iqih95bntoeyysb2pc` (`user_Id`),
  CONSTRAINT `FKaa6ilb6iqih95bntoeyysb2pc` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `fk_UserHistory_userId` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_history`
--

LOCK TABLES `user_history` WRITE;
/*!40000 ALTER TABLE `user_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `role_Id` int(11) NOT NULL,
  PRIMARY KEY (`ur_Id`),
  UNIQUE KEY `USER_ROLE_UK` (`user_Id`,`role_Id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_Id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_Id`) REFERENCES `role` (`role_Id`),
  CONSTRAINT `fk_User_Role_roleId` FOREIGN KEY (`role_Id`) REFERENCES `role` (`role_Id`),
  CONSTRAINT `fk_User_Role_userId` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(3,7,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-06 10:49:55
