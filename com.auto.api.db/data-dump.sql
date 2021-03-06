-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional`
--

DROP TABLE IF EXISTS `additional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional` (
  `additionalid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(19,2) NOT NULL,
  PRIMARY KEY (`additionalid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional`
--

LOCK TABLES `additional` WRITE;
/*!40000 ALTER TABLE `additional` DISABLE KEYS */;
INSERT INTO `additional` VALUES (1,'Techo corredizo',12000.00),(2,'Aire Acondicionado',20000.00),(3,'Sistemas de frenos ABS',14000.00),(4,'Airbag',7000.00),(5,'Llantas de aleaci├│n',12000.00);
/*!40000 ALTER TABLE `additional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `autoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(19,2) NOT NULL,
  PRIMARY KEY (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Sed├ín',230000.00),(2,'Familiar',245000.00),(3,'Coup├®',270000.00);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `unitid` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(19,2) NOT NULL,
  `autoid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`unitid`),
  KEY `FKw52u1kgucl74qdrjn3frxk3p` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,323000.00,3),(2,282000.00,3),(3,259000.00,2);
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_additional`
--

DROP TABLE IF EXISTS `unit_additional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit_additional` (
  `unitid` bigint(20) NOT NULL,
  `additionalid` bigint(20) NOT NULL,
  KEY `FKc3jy442vjmtimfxs0eilh6uhg` (`additionalid`),
  KEY `FKgp3piv3waoumtsru41jiocr23` (`unitid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_additional`
--

LOCK TABLES `unit_additional` WRITE;
/*!40000 ALTER TABLE `unit_additional` DISABLE KEYS */;
INSERT INTO `unit_additional` VALUES (1,3),(1,1),(1,2),(1,4),(2,1),(3,3);
/*!40000 ALTER TABLE `unit_additional` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-08  4:31:28
