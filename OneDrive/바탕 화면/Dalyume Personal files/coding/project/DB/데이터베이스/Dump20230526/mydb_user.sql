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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_email` varchar(45) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_profile_url` varchar(255) DEFAULT NULL,
  `user_tel_number` varchar(15) NOT NULL,
  `user_name` varchar(5) NOT NULL,
  `user_address` text NOT NULL,
  `user_age` int NOT NULL,
  `user_gender` varchar(45) NOT NULL,
  `user_final_education` text,
  `user_carrer` text,
  `user_license` text,
  `user_wish_list` json DEFAULT NULL,
  PRIMARY KEY (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('dlacogus123@naver.com','$2a$10$aDlz/a40frqay4GJiiDWgOiYr0vRrRUETZO/4fct/ZLmtadBheKs2',NULL,'010-2222-2222','임채현','부산광역시',20,'남',NULL,NULL,NULL,NULL),('dlcjddyd123@naver.com','$2a$10$nIiAXd2KCVnQGbQ.IoQYl.cZOIRbPN4rBL8TbVxsl.c.7UXVCdQuK',NULL,'010-8888-8888','이청용','부산광역시',20,'남',NULL,NULL,NULL,NULL),('qqq123@naver.com','$2a$10$qJ7HHEqvcXZIAEzwNbz57.g3OwzrqeCyiAUkxsp65uMP0flMpm8Gm','http://localhost:4040/user-file/2a1575f5-360e-4a45-afc9-0510077390be.png','010-2222-4892','dsa','부산 동구 초량동',25,'남성','\"[\'연세대학교\']\"','\"[\'제조업 근무 경력\']\"','\"[\'SQLD 자격증\']\"',NULL),('rlagusxo96652@naver.com','$2a$10$yN5n7MvByRt6PIS9hWBARecoHJ87tpA16S4X4bDiRl3fkcpQY7JLq',NULL,'010-8482-1490','김현태','부산광역시',46,'남자','\"[\'서울대학교\',\'연세대학교 대학원\']\"',NULL,'\"[\'SQLD\']\"',NULL),('rnehgk123@naver.com','$2a$10$7NfBe4xmuGjeIJlURS0N2eu48q1P2YJF6JSDu1qCqFH9pB2iziXfy',NULL,'010-3333-3333','구도하','부산광역시',20,'남',NULL,NULL,NULL,NULL),('구자철123@naver.com','$2a$10$BJsa9JK20DISzUlfd7EVIOZkdZOqrLQ25J404ntywrhmXymvB6dp.',NULL,'010-6666-6666','구자철','부산광역시',20,'남',NULL,NULL,NULL,NULL),('손흥민123@naver.com','$2a$10$vNI0wpvZ/D53zHhznecFvuq7CY8m7P4VphTPUpI7CDQZpWby3Vlwe',NULL,'010-4444-4444','손흥민','부산광역시',20,'남','\"[\'서울대학교\',\'연세대학교 대학원\']\"','\"[\'제조업 10년\',\'서비스업 5년\']\"','\"[\'SQLD\']\"',NULL),('황희찬123@naver.com','$2a$10$UMnzMNoPyHuFQnjO24bsZ.ZYxPictPW0/rFYNUsxxeJso4yymq53i',NULL,'010-5555-5555','황희찬','부산광역시',20,'남',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
