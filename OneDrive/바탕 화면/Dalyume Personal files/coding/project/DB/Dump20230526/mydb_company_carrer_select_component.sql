-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company_carrer_select_component`
--

DROP TABLE IF EXISTS `company_carrer_select_component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_carrer_select_component` (
  `company_tel_number` varchar(15) NOT NULL,
  `carrer` json NOT NULL,
  `carrer_score` int NOT NULL,
  PRIMARY KEY (`company_tel_number`),
  KEY `fk_company_carrer_select_component_company1_idx` (`company_tel_number`),
  CONSTRAINT `fk_company_carrer_select_component_company1` FOREIGN KEY (`company_tel_number`) REFERENCES `company` (`company_tel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_carrer_select_component`
--

LOCK TABLES `company_carrer_select_component` WRITE;
/*!40000 ALTER TABLE `company_carrer_select_component` DISABLE KEYS */;
INSERT INTO `company_carrer_select_component` VALUES ('010-1212-1212','\"[\'제조업체 10년 근무\',\'서비스업체 10년 근무\']\"',50),('010-7777-7777','\"[\'제조업체 10년 근무\',\'서비스업체 10년 근무\']\"',50),('010-9999-9999','\"[\'\',\'\',\'IT업 근무 경력\',\'\',\'\']\"',17);
/*!40000 ALTER TABLE `company_carrer_select_component` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26 14:47:24
