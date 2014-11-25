CREATE DATABASE  IF NOT EXISTS `RadioCabs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `RadioCabs`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: RadioCabs
-- ------------------------------------------------------
-- Server version	5.7.3-m13

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
-- Table structure for table `tblAction`
--

DROP TABLE IF EXISTS `tblAction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAction` (
  `actID` int(11) NOT NULL AUTO_INCREMENT,
  `actModel` varchar(45) NOT NULL,
  `actAction` varchar(10) NOT NULL,
  PRIMARY KEY (`actID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAction`
--

LOCK TABLES `tblAction` WRITE;
/*!40000 ALTER TABLE `tblAction` DISABLE KEYS */;
INSERT INTO `tblAction` VALUES (1,'Admin','Create'),(2,'Admin','Edit'),(3,'Admin','View'),(5,'Advertise','Create'),(6,'Advertise','Edit'),(7,'Advertise','View'),(9,'City','Create'),(10,'City','Edit'),(11,'City','View'),(13,'Company','Create'),(14,'Company','Edit'),(15,'Company','View'),(17,'Driver','Create'),(18,'Driver','Edit'),(19,'Driver','View'),(21,'MembershipType','Create'),(22,'MembershipType','Edit'),(23,'MembershipType','View'),(25,'Payment','Edit'),(26,'Payment','View'),(28,'PaymentType','Create'),(29,'PaymentType','Edit'),(30,'PaymentType','View'),(32,'Role','Create'),(33,'Role','Edit'),(34,'Role','View'),(37,'Permission','Edit');
/*!40000 ALTER TABLE `tblAction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblAdmin`
--

DROP TABLE IF EXISTS `tblAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAdmin` (
  `admID` int(11) NOT NULL AUTO_INCREMENT,
  `rolID` int(11) NOT NULL,
  `admUsername` varchar(50) NOT NULL,
  `admPass` varchar(50) NOT NULL,
  `admAvartar` varchar(225) DEFAULT 'user.jpg',
  `admEmail` varchar(50) NOT NULL,
  `admTel` varchar(20) NOT NULL,
  `admStatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`admID`),
  UNIQUE KEY `admUsername_UNIQUE` (`admUsername`),
  KEY `tblAdmin_to_tblRole_idx` (`rolID`),
  CONSTRAINT `tblAdmin_to_tblRole` FOREIGN KEY (`rolID`) REFERENCES `tblRole` (`rolID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAdmin`
--

LOCK TABLES `tblAdmin` WRITE;
/*!40000 ALTER TABLE `tblAdmin` DISABLE KEYS */;
INSERT INTO `tblAdmin` VALUES (2,1,'admin','admin','admin.jpg','nghqua89@gmail.com','01679959615',1),(3,10,'testadmin','123456','user.jpg','nghquan89@gmail.com','1234557901',1);
/*!40000 ALTER TABLE `tblAdmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblAdvertise`
--

DROP TABLE IF EXISTS `tblAdvertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblAdvertise` (
  `advID` int(11) NOT NULL AUTO_INCREMENT,
  `comID` int(11) NOT NULL,
  `advImageURL` varchar(225) NOT NULL,
  `advRegDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `advDescription` text NOT NULL,
  `advStatus` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`advID`),
  KEY `tblAdvertise_to_tblCompany_idx` (`comID`),
  CONSTRAINT `tblAdvertise_to_tblCompany` FOREIGN KEY (`comID`) REFERENCES `tblCompany` (`comID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblAdvertise`
--

LOCK TABLES `tblAdvertise` WRITE;
/*!40000 ALTER TABLE `tblAdvertise` DISABLE KEYS */;
INSERT INTO `tblAdvertise` VALUES (1,1,'9014_767380079985766_2169210558438315712_n_(2).jpg','2014-11-20 15:27:10','Ble bleh\r\n                                ',2);
/*!40000 ALTER TABLE `tblAdvertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblCity`
--

DROP TABLE IF EXISTS `tblCity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblCity` (
  `citID` int(11) NOT NULL AUTO_INCREMENT,
  `citName` varchar(50) NOT NULL,
  `citStatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`citID`),
  UNIQUE KEY `citName_UNIQUE` (`citName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblCity`
--

LOCK TABLES `tblCity` WRITE;
/*!40000 ALTER TABLE `tblCity` DISABLE KEYS */;
INSERT INTO `tblCity` VALUES (1,'Hanoi',1),(2,'testCity',1);
/*!40000 ALTER TABLE `tblCity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblCompany`
--

DROP TABLE IF EXISTS `tblCompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblCompany` (
  `comID` int(11) NOT NULL AUTO_INCREMENT,
  `comUsername` varchar(50) NOT NULL,
  `comPass` varchar(50) NOT NULL,
  `comName` varchar(100) NOT NULL,
  `comContactPerson` varchar(50) NOT NULL,
  `comDesignation` varchar(100) NOT NULL,
  `comImageURL` varchar(225) NOT NULL,
  `citID` int(11) NOT NULL,
  `comAddress` varchar(100) NOT NULL,
  `comMobile` varchar(20) NOT NULL,
  `comTel` varchar(20) NOT NULL,
  `comFax` varchar(20) DEFAULT NULL,
  `comEmail` varchar(50) NOT NULL,
  `comRegDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comStatus` int(11) NOT NULL DEFAULT '2',
  `mtID` int(11) NOT NULL,
  PRIMARY KEY (`comID`),
  UNIQUE KEY `comUsername_UNIQUE` (`comUsername`),
  KEY `company_to_membertype_idx` (`mtID`),
  KEY `company_to_city_idx` (`citID`),
  CONSTRAINT `company_to_city` FOREIGN KEY (`citID`) REFERENCES `tblCity` (`citID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `company_to_membertype` FOREIGN KEY (`mtID`) REFERENCES `tblMembershipType` (`mtID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblCompany`
--

LOCK TABLES `tblCompany` WRITE;
/*!40000 ALTER TABLE `tblCompany` DISABLE KEYS */;
INSERT INTO `tblCompany` VALUES (1,'comApt','123456','Hanoi Aptech','Quan Nguyen Hong','Hanoi Aptech Education','9014_767380079985766_2169210558438315712_n.jpg',1,'19 Nguyen Trai St.','0974738679','0439684965','','aptech@gmail.com','2014-11-12 14:54:45',1,2);
/*!40000 ALTER TABLE `tblCompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblDriver`
--

DROP TABLE IF EXISTS `tblDriver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblDriver` (
  `drvID` int(11) NOT NULL AUTO_INCREMENT,
  `drvUsername` varchar(50) NOT NULL,
  `drvPass` varchar(50) NOT NULL,
  `drvName` varchar(100) NOT NULL,
  `drvContactPerson` varchar(50) NOT NULL,
  `drvImage` varchar(225) NOT NULL,
  `citID` int(11) NOT NULL,
  `drvAddress` varchar(100) NOT NULL,
  `drvMobile` varchar(20) NOT NULL,
  `drvTel` varchar(20) NOT NULL,
  `drvEmail` varchar(50) NOT NULL,
  `drvExp` text NOT NULL,
  `drvDescription` text,
  `drvRegDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `drvStatus` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`drvID`),
  UNIQUE KEY `drvUsername_UNIQUE` (`drvUsername`),
  KEY `tblDriver_to_tblCity_idx` (`citID`),
  CONSTRAINT `tblDriver_to_tblCity` FOREIGN KEY (`citID`) REFERENCES `tblCity` (`citID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblDriver`
--

LOCK TABLES `tblDriver` WRITE;
/*!40000 ALTER TABLE `tblDriver` DISABLE KEYS */;
INSERT INTO `tblDriver` VALUES (2,'driver','driver','Quan Nguyen Hong','Quang Pham Ngoc','1236846_599652656754025_311317968_n.jpg',1,'Cau Giay St.','01679959715','0438550550','nghquan89@gmail.com','Do some job','','2014-11-11 10:03:09',1),(6,'testDriver','testDriver','testDriver','testDriver','6d69138faaf5636d7048f7f5f5de19c4-d5l5g6z.jpg',1,'testDriver','0123456789','0123456789','testmail@gmail.com','None','','2014-11-11 10:37:41',2);
/*!40000 ALTER TABLE `tblDriver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblFeedback`
--

DROP TABLE IF EXISTS `tblFeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblFeedback` (
  `fbID` int(11) NOT NULL AUTO_INCREMENT,
  `fbType` varchar(50) NOT NULL,
  `fbMobile` varchar(20) NOT NULL,
  `fbEmail` varchar(50) NOT NULL,
  `fbDescription` text NOT NULL,
  `fbTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fbStatus` varchar(10) NOT NULL DEFAULT 'Actived',
  PRIMARY KEY (`fbID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblFeedback`
--

LOCK TABLES `tblFeedback` WRITE;
/*!40000 ALTER TABLE `tblFeedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblFeedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblMembershipType`
--

DROP TABLE IF EXISTS `tblMembershipType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblMembershipType` (
  `mtID` int(11) NOT NULL AUTO_INCREMENT,
  `mtName` varchar(50) NOT NULL,
  `mtFee` float NOT NULL,
  `mtStatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`mtID`),
  UNIQUE KEY `mtName_UNIQUE` (`mtName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblMembershipType`
--

LOCK TABLES `tblMembershipType` WRITE;
/*!40000 ALTER TABLE `tblMembershipType` DISABLE KEYS */;
INSERT INTO `tblMembershipType` VALUES (2,'Free',1,1),(3,'Basic',3,1);
/*!40000 ALTER TABLE `tblMembershipType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblPayment`
--

DROP TABLE IF EXISTS `tblPayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblPayment` (
  `payID` int(11) NOT NULL AUTO_INCREMENT,
  `ptID` int(11) NOT NULL,
  `comID` int(11) DEFAULT NULL,
  `advID` int(11) DEFAULT NULL,
  `drvID` int(11) DEFAULT NULL,
  `payTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `payTimeExpired` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `payTotal` float NOT NULL,
  `payStatus` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`payID`,`payTime`),
  KEY `tblPayment_to_tblCompany_idx` (`comID`),
  KEY `tblPayment_to_tblAdvertise_idx` (`advID`),
  KEY `tblPayment_to_tblDriver_idx` (`drvID`),
  KEY `tblPayment_to_tblPaymentType_idx` (`ptID`),
  CONSTRAINT `tblPayment_to_tblAdvertise` FOREIGN KEY (`advID`) REFERENCES `tblAdvertise` (`advID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tblPayment_to_tblCompany` FOREIGN KEY (`comID`) REFERENCES `tblCompany` (`comID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tblPayment_to_tblDriver` FOREIGN KEY (`drvID`) REFERENCES `tblDriver` (`drvID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tblPayment_to_tblPaymentType` FOREIGN KEY (`ptID`) REFERENCES `tblPaymentType` (`ptID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblPayment`
--

LOCK TABLES `tblPayment` WRITE;
/*!40000 ALTER TABLE `tblPayment` DISABLE KEYS */;
INSERT INTO `tblPayment` VALUES (10,1,1,NULL,NULL,'2014-11-24 10:03:16','2014-12-24 10:03:16',16,2),(11,9,NULL,NULL,2,'2014-11-24 12:48:22','2014-12-24 12:48:22',10,2);
/*!40000 ALTER TABLE `tblPayment` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tblPayment_BINS` BEFORE INSERT ON `tblPayment` FOR EACH ROW
begin
SET NEW.payTotal = calculateTotal(NEW.ptID,if(character_length(NEW.comID)>0,NEW.comID,0));
SET NEW.payTimeExpired = calculateExpired(NEW.ptID);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tblPaymentType`
--

DROP TABLE IF EXISTS `tblPaymentType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblPaymentType` (
  `ptID` int(11) NOT NULL AUTO_INCREMENT,
  `ptFor` varchar(20) NOT NULL,
  `ptType` varchar(20) NOT NULL,
  `ptDays` int(11) NOT NULL,
  `ptFee` float NOT NULL,
  `ptStatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ptID`),
  UNIQUE KEY `pmtUnique` (`ptFor`,`ptType`,`ptDays`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblPaymentType`
--

LOCK TABLES `tblPaymentType` WRITE;
/*!40000 ALTER TABLE `tblPaymentType` DISABLE KEYS */;
INSERT INTO `tblPaymentType` VALUES (1,'Company','Monthly',30,15,1),(3,'Company','Quarterly',90,40,1),(4,'Advertise','Monthly',30,15,1),(5,'Advertise','Quarterly',90,40,1),(9,'Driver','Monthly',30,10,1),(10,'Driver','Quarterly',90,45,1);
/*!40000 ALTER TABLE `tblPaymentType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblPermission`
--

DROP TABLE IF EXISTS `tblPermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblPermission` (
  `perID` int(11) NOT NULL AUTO_INCREMENT,
  `rolID` int(11) NOT NULL,
  `actID` int(11) NOT NULL,
  `perStatus` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`perID`),
  KEY `permission_to_action_idx` (`actID`),
  KEY `permission_to_role_idx` (`rolID`),
  CONSTRAINT `permission_to_action` FOREIGN KEY (`actID`) REFERENCES `tblAction` (`actID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `permission_to_role` FOREIGN KEY (`rolID`) REFERENCES `tblRole` (`rolID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblPermission`
--

LOCK TABLES `tblPermission` WRITE;
/*!40000 ALTER TABLE `tblPermission` DISABLE KEYS */;
INSERT INTO `tblPermission` VALUES (19,1,1,1),(20,1,2,1),(21,1,3,1),(22,1,5,1),(23,1,6,1),(24,1,7,1),(25,1,9,1),(26,1,10,1),(27,1,11,1),(28,1,13,1),(29,1,14,1),(30,1,15,1),(31,1,17,1),(32,1,18,1),(33,1,19,1),(34,1,21,1),(35,1,22,1),(36,1,23,1),(37,1,25,1),(38,1,26,1),(39,1,28,1),(40,1,29,1),(41,1,30,1),(42,1,32,1),(43,1,33,1),(44,1,34,1),(46,1,37,1),(48,10,1,0),(49,10,2,0),(50,10,3,0),(51,10,5,0),(52,10,6,0),(53,10,7,0),(54,10,9,0),(55,10,10,0),(56,10,11,0),(57,10,13,0),(58,10,14,0),(59,10,15,0),(60,10,17,0),(61,10,18,0),(62,10,19,0),(63,10,21,0),(64,10,22,0),(65,10,23,0),(66,10,25,0),(67,10,26,0),(68,10,28,0),(69,10,29,0),(70,10,30,0),(71,10,32,0),(72,10,33,1),(73,10,34,1),(74,10,37,0),(75,11,1,0),(76,11,2,0),(77,11,3,0),(78,11,5,0),(79,11,6,0),(80,11,7,0),(81,11,9,0),(82,11,10,0),(83,11,11,0),(84,11,13,0),(85,11,14,0),(86,11,15,0),(87,11,17,0),(88,11,18,0),(89,11,19,0),(90,11,21,0),(91,11,22,0),(92,11,23,0),(93,11,25,0),(94,11,26,0),(95,11,28,0),(96,11,29,0),(97,11,30,0),(98,11,32,0),(99,11,33,0),(100,11,34,0),(101,11,37,0);
/*!40000 ALTER TABLE `tblPermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblRole`
--

DROP TABLE IF EXISTS `tblRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblRole` (
  `rolID` int(11) NOT NULL AUTO_INCREMENT,
  `rolName` varchar(50) NOT NULL,
  `rolStatus` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`rolID`),
  UNIQUE KEY `rolName_UNIQUE` (`rolName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblRole`
--

LOCK TABLES `tblRole` WRITE;
/*!40000 ALTER TABLE `tblRole` DISABLE KEYS */;
INSERT INTO `tblRole` VALUES (1,'Super Admin',1),(10,'Administrator',1),(11,'testRole',1);
/*!40000 ALTER TABLE `tblRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'RadioCabs'
--
/*!50003 DROP FUNCTION IF EXISTS `calculateExpired` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `calculateExpired`(id INT) RETURNS timestamp
BEGIN
set @days = (Select ptDays from tblPaymentType where ptID = id);
set @result = (SELECT TIMESTAMP(DATE_ADD(NOW(), INTERVAL @days day)));
RETURN @result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `calculateTotal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `calculateTotal`(id INT, com INT) RETURNS float
BEGIN
set @fee = (Select ptFee from tblPaymentType where ptID = id);
set @memfee = if(com > 0,(Select mtFee from tblMembershipType inner join tblCompany on tblMembershipType.mtID = tblCompany.mtID where comID = com),0);
RETURN @fee+@memfee;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `setExpired` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `setExpired`() RETURNS int(11)
BEGIN
CREATE TEMPORARY TABLE IF NOT EXISTS lstDrv AS (SELECT tblDriver.drvID FROM tblDriver inner join tblPayment on tblDriver.drvID = tblPayment.drvID where payTimeExpired < current_timestamp and payStatus = 1);
CREATE TEMPORARY TABLE IF NOT EXISTS lstCompany AS (SELECT tblCompany.comID FROM tblCompany inner join tblPayment on tblCompany.comID = tblPayment.comID where payTimeExpired < current_timestamp and payStatus = 1);
CREATE TEMPORARY TABLE IF NOT EXISTS lstAdv AS (SELECT tblAdvertise.advID FROM tblAdvertise inner join tblPayment on tblAdvertise.advID = tblPayment.advID where payTimeExpired < current_timestamp and payStatus = 1);
Set @clDrv = (Select count(*) from lstDrv);
Set @clCom = (Select count(*) from lstCompany);
Set @clAdv = (Select count(*) from lstAdv);
if @clDrv > 0 then
Update tblDriver set drvStatus = 2 where drvID in (Select drvID from lstDrv);
end if;
if @clCom > 0 then
Update tblCompany set comStatus = 2 where comID in (Select comID from lstCompany);
end if;
if @clAdv > 0 then
Update tblAdvertise set advStatus = 2 where advID in (Select advID from lstAdv);
end if;
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-26  0:54:53
