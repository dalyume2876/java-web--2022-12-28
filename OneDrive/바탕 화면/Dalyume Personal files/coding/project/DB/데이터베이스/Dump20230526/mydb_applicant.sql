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
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant` (
  `applicant_user_email` varchar(45) NOT NULL COMMENT '지원자의 이메일 주소를 PK로 등록 ',
  `applicant_company_tel_number` varchar(45) NOT NULL,
  `applicant_final_education` text NOT NULL COMMENT '지원자 최종학력',
  `applicant_carrer` text NOT NULL COMMENT '지원자 경력사항',
  `applicant_license` text NOT NULL COMMENT '지원자 자격증',
  `applicant_Total_score` varchar(45) NOT NULL,
  `applicant_percentile` varchar(45) NOT NULL,
  PRIMARY KEY (`applicant_user_email`,`applicant_company_tel_number`),
  KEY `fk_applicant_user1_idx` (`applicant_user_email`),
  KEY `fk_applicant_company1_idx` (`applicant_company_tel_number`),
  CONSTRAINT `fk_applicant_company1` FOREIGN KEY (`applicant_company_tel_number`) REFERENCES `company` (`company_tel_number`),
  CONSTRAINT `fk_applicant_user1` FOREIGN KEY (`applicant_user_email`) REFERENCES `user` (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES ('dlacogus123@naver.com','010-7777-7777','\"[\'부산고등학교\',\'부산대학교\',\'하늘 대학원\']\"','\"[\'제조업 6년\',\'서비스업 4년\']\"','\"[\'\']\"','0','0.000'),('qqq123@naver.com','010-1523-1235','\"[\'서강대학교\']\"','\"[\'비서직 근무 경력\']\"','\"[\'SQLD 자격증\']\"','0','100.0'),('qqq123@naver.com','010-3410-0000','\"[\'\']\"','\"[\'\']\"','\"[\'\']\"','0','100.0'),('qqq123@naver.com','010-7777-7777','\"[\'\']\"','\"[\'\']\"','\"[\'\']\"','0','0.0'),('rlagusxo96652@naver.com','010-7777-7777','\"[\'고려대학교\']\"','\"[\'제조업체 10년 근무\']\"','\"[\'SQLD 전문기사 자격증\']\"','130','0.0'),('rnehgk123@naver.com','010-7777-7777','\"[\'부산고등학교\',\'울산대학교\',\'우리 대학원\']\"','\"[\'제조업 6년\',\'서비스업 4년\']\"','\"[\'SQLD 전문기사 자격증\',\'정보처리 기사 자격증\',\'PhD 자격증\']\"','50','66.666'),('손흥민123@naver.com','010-7777-7777','\"[\'서울대학교\',\'연세대학교 대학원\']\"','\"[\'제조업 10년\',\'서비스업 5년\']\"','\"[\'SQLD\']\"','30','75.0');
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26 14:47:52
