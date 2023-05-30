-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_tel_number` varchar(15) NOT NULL COMMENT '회사의 전화번호를 PK로 ',
  `company_name` text NOT NULL COMMENT '회사의 이름',
  `company_profile_url` text,
  `company_address` text NOT NULL,
  `company_category` varchar(45) DEFAULT NULL,
  `company_password` varchar(255) NOT NULL,
  `company_email` varchar(255) NOT NULL,
  `company_home_page` varchar(45) DEFAULT NULL,
  `company_contents` varchar(45) DEFAULT NULL,
  `company_employee` varchar(45) DEFAULT NULL,
  `company_annual_sales` varchar(45) DEFAULT NULL,
  `company_starting_salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`company_tel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('010-1212-1212','마이크로소프트',NULL,'뉴욕','IT','$2a$10$/SadzJibyBRmK.SlBWj5s.c5bwSRHDRvXx/2M6q0UzfGm4AOkKFhe','microsoft96652@naver.com','','','','',''),('010-1523-1235','가나다','http://localhost:4040/company-file/e2d61c30-3113-4554-a1b7-f0da08d23494.jpg','부산',NULL,'$2a$10$lW9HTUHOGjhcff4Q7EVo/eORxfaGxeMiChGNmNilS2WYLI8272of6','qqq123@naver.com','','','','',''),('010-3410-0000','아앙','http://localhost:4040/company-file/8349ebde-90be-4e5e-8b16-3b9d8ed1f308.jpg','부산동구','dsa','$2a$10$Rj.3xfUnILabPZsM6LSpDeq5S6E8on2EFYI445kv2rJznlHuXtg1C','qqq1234@naver.com','dsadsa','ㅗㅗㅗㅗㅗㅗㅗ','133','144444','1444'),('010-6645-9999','네이버',NULL,'서울특별시','IT','','naver96652@naver.com','','','','',''),('010-7777-7777','카카오',NULL,'서울','IT','$2a$10$loZqkKqjP2NPasAbKGL/XuOleoNYlyFqXtEbHXUujg0CMOxRmC1aq','kakao96652@naver.com','','','','','');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26 14:47:51
