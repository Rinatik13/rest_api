CREATE DATABASE  IF NOT EXISTS `rest_api` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rest_api`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: rest_api
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `akkredit`
--

DROP TABLE IF EXISTS `akkredit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `akkredit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `inn_gov` varchar(10) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `end_date` varchar(10) DEFAULT NULL,
  `company_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `akkredit`
--

LOCK TABLES `akkredit` WRITE;
/*!40000 ALTER TABLE `akkredit` DISABLE KEYS */;
/*!40000 ALTER TABLE `akkredit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `akkredit_docs`
--

DROP TABLE IF EXISTS `akkredit_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `akkredit_docs` (
  `akkredit_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`akkredit_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `akkredit_docs`
--

LOCK TABLES `akkredit_docs` WRITE;
/*!40000 ALTER TABLE `akkredit_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `akkredit_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buh_docs`
--

DROP TABLE IF EXISTS `buh_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buh_docs` (
  `buh_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`buh_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buh_docs`
--

LOCK TABLES `buh_docs` WRITE;
/*!40000 ALTER TABLE `buh_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `buh_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buhdocument`
--

DROP TABLE IF EXISTS `buhdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buhdocument` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_name` varchar(45) DEFAULT NULL,
  `oboroti_date` double DEFAULT NULL,
  `count_employee_date` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buhdocument`
--

LOCK TABLES `buhdocument` WRITE;
/*!40000 ALTER TABLE `buhdocument` DISABLE KEYS */;
INSERT INTO `buhdocument` VALUES (1,'2022',1000,'3',17),(2,'2021',2000,'4',17),(3,'2020',1000,'5',17);
/*!40000 ALTER TABLE `buhdocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name_form_com` varchar(255) DEFAULT NULL,
  `full_name_com` varchar(255) DEFAULT NULL,
  `small_name_com` varchar(255) DEFAULT NULL,
  `address_com` varchar(255) DEFAULT NULL,
  `mail_address_com` varchar(255) DEFAULT NULL,
  `inn_com` varchar(10) DEFAULT NULL,
  `kpp_com` varchar(10) DEFAULT NULL,
  `registration_number_com` varchar(15) DEFAULT NULL,
  `registration_number_gov_com` varchar(255) DEFAULT NULL,
  `date_registration_number_gov_doc` varchar(10) DEFAULT NULL,
  `date_registration_com` varchar(10) DEFAULT NULL,
  `bank_number` varchar(10) DEFAULT NULL,
  `name_form_bank` varchar(255) DEFAULT NULL,
  `name_bank` varchar(255) DEFAULT NULL,
  `address_bank` varchar(255) DEFAULT NULL,
  `checking_account_bank` varchar(22) DEFAULT NULL,
  `correspondent_account_bank` varchar(22) DEFAULT NULL,
  `okpo_com` varchar(10) DEFAULT NULL,
  `okato_com` varchar(11) DEFAULT NULL,
  `okved_com` varchar(5) DEFAULT NULL,
  `email_com` varchar(255) DEFAULT NULL,
  `telephone_com` varchar(12) DEFAULT NULL,
  `web_site_com` varchar(255) DEFAULT NULL,
  `summ` double DEFAULT NULL,
  `aktiv_summ` double DEFAULT NULL,
  `smpstatus` int DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? \"??????????-????????????\"','?????? \"??????????-????????????\"','??. ??????, ????. ???????? ???????????????? ?????? 25 ???????? 1','M-servis20@yandex.ru','dfdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,1,5),(2,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????????????????????????????\"','?????? \"????????????????????????????????\"','??. ??????','NGK@yandex.ru',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,2,1,5),(3,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????\"','?????? \"????????\"','??.??????','test@ya.ru',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,22,22,1,5),(4,'','','','','','123','123','','','','','','','','','','','','','','','','',0,0,0,5),(5,'','','?????? \"?????? ???? ?? ????????????\"','','','','','','','','','','','','','','','','','','','','',0,0,0,5),(6,'','','?????? \"?????????? ????????\"','','','','','','','','','','','','','','','','','','','','',0,0,0,5),(7,'','','POOO','','','','','','','','','','','','','','','','','','','','',0,0,0,5),(8,'','','','','','','','','','','','','','','','','','','','','','','',0,0,0,5),(9,'123','123','123','123','123','123','123','123','123','31.01.2013','31.01.2013','123','123','123','123','123','123','123','123','123','','123','123',0,0,0,5),(10,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????\"','?????? \"????????\"','??.??????','test@ya.ru',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,22,22,1,101),(11,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????\"','?????? \"????????\"','??.??????','??/?? 22','02020202','1233311','12754727','123123','13.01.2001','13.01.2001','123','??????','????????????????','??.??????','33333','44444','12313123','123123','42.03','com@ya.ru','+8877877','??????',0,0,0,102),(12,'123','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102),(13,'234','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102),(14,'123','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102),(15,'asd','asdas','asdas','','','','','','','','','','','','','','','','','','','','',0,0,0,102),(16,'','','asdasd','','','','','','','','','','','','','','','','','','','','',0,0,0,102),(17,'???????????????? ?? ???????????????????????? ???????????????????????????????? ','???????????? ????????????????????????	???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????????\"','?????? \"????????????\"','426009, ??. ????????????, ????. ????????????, ??. 123, ????. 11','426009, ??. ????????????, ????. ????????????, ??. 123, ????. 11','5619875673','3451233456','8765412345231','123','01.01.2022','01.01.2022','','','','','','','45327266','370000000','45.19','info@germes.ru','+73412888887','',0,0,0,5),(18,'???????????????? ?? ???????????????????????? ???????????????????????????????? ','???????????????? ?? ???????????????????????? ???????????????????????????????? \"????????????\"','?????? \"????????????\"','426009, ??. ????????????, ????. ????????????, ??. 123, ????. 11','426009, ??. ????????????, ????. ????????????, ??. 123, ????. 11','5619875673','3451233456','8765412345231','123','01.01.2009','01.01.2009','045678345','??????','??????????????','??.??????','4070987654345676543456','3090472627274747474732','45327266','370000000','45.19','info@germes.ru','+79872422185','www.info.com',0,0,0,103),(19,'???????????????? ?? ???????????????????????? ????????????????????????????????','???????????????? ?? ???????????????????????? ???????????????????????????????? ???????????????? ??????????','?????? ???????????????? ??????????','????????????, ???????????????? ??????????????, ??. ??????????, ????. ??????????????????????, 134','	 641882, ????????????, ???????????????? ??????????????, ??. ??????????, ????. ??????????????????????, 134','4201010000','420100000','1025604200000','12','13.01.2020','13.01.2020','041110000','?????? ????','???????????? ????????????????????','??. ??????????????????????','40701110103000000000','30101110100000000000','41301000','37000000','64.20','mail@site.ru','+79872422185','site.ru',0,0,0,104);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_docs`
--

DROP TABLE IF EXISTS `company_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_docs` (
  `company_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`company_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_docs`
--

LOCK TABLES `company_docs` WRITE;
/*!40000 ALTER TABLE `company_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_signature`
--

DROP TABLE IF EXISTS `company_signature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_signature` (
  `company_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`company_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_signature`
--

LOCK TABLES `company_signature` WRITE;
/*!40000 ALTER TABLE `company_signature` DISABLE KEYS */;
INSERT INTO `company_signature` VALUES (17,1);
/*!40000 ALTER TABLE `company_signature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_stamp`
--

DROP TABLE IF EXISTS `company_stamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_stamp` (
  `company_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`company_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_stamp`
--

LOCK TABLES `company_stamp` WRITE;
/*!40000 ALTER TABLE `company_stamp` DISABLE KEYS */;
INSERT INTO `company_stamp` VALUES (17,2);
/*!40000 ALTER TABLE `company_stamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_tender`
--

DROP TABLE IF EXISTS `company_tender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_tender` (
  `company_id` int NOT NULL,
  `tender_id` int NOT NULL,
  PRIMARY KEY (`company_id`,`tender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_tender`
--

LOCK TABLES `company_tender` WRITE;
/*!40000 ALTER TABLE `company_tender` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_tender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `inn_zakaz` varchar(45) DEFAULT NULL,
  `inn_ispolnitel` varchar(45) DEFAULT NULL,
  `summ` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  `smile_name_zakaz` varchar(45) DEFAULT NULL,
  `address_zakaz` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_docs`
--

DROP TABLE IF EXISTS `contract_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_docs` (
  `contract_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`contract_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_docs`
--

LOCK TABLES `contract_docs` WRITE;
/*!40000 ALTER TABLE `contract_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_pdf`
--

DROP TABLE IF EXISTS `document_pdf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_pdf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_pdf`
--

LOCK TABLES `document_pdf` WRITE;
/*!40000 ALTER TABLE `document_pdf` DISABLE KEYS */;
INSERT INTO `document_pdf` VALUES (1,'1','C:\\java\\blank\\StampEndSignature\\?????????????? ????.jpg'),(2,'2','C:\\java\\blank\\StampEndSignature\\MS.jpg'),(3,'',''),(5,'',''),(8,'??????????','user_104/company_19'),(9,'??????????','user_104/company_19'),(10,'??????????','user_104/company_19'),(11,'??????????','user_104/company_19'),(13,'??????????','user_104/company_19'),(14,'??????????','user_104/company_19'),(16,'??????????','user_104/company_19'),(18,'??????????','user_104/company_19'),(19,'??????????','user_104/company_19'),(20,'??????????','user_104/company_19'),(21,'??????????','user_104/company_19');
/*!40000 ALTER TABLE `document_pdf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `passport_serial` varchar(45) DEFAULT NULL,
  `passport_number` varchar(45) DEFAULT NULL,
  `passport_gov_name` varchar(45) DEFAULT NULL,
  `date_gov` varchar(45) DEFAULT NULL,
  `date_happy` varchar(45) DEFAULT NULL,
  `address_reg` varchar(45) DEFAULT NULL,
  `telephone_number` varchar(45) DEFAULT NULL,
  `inn` varchar(45) DEFAULT NULL,
  `snils` varchar(45) DEFAULT NULL,
  `goverment_status` varchar(45) DEFAULT NULL,
  `position_com` varchar(45) DEFAULT NULL,
  `date_trud` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'??????','??????????','????????','','','','','','','','','','','asd','',1),(2,'??????','??????????????','??????????????????','','','','','','','','','','','??????????????','',1),(3,'??????????','??????????????????????','??????????????????','1234','4123123','?????? ?? ??????','10.01.2016','13.08.1989','???? ???? ??. ??????','+79876543210','123','123566','???????????????????? ??????????????????','?????????????????????? ????????????????','01.01.2022',17),(10,'asd','','asd','','','','','','','','','','','','',0),(11,'12','','','','','','','','','','','','','','',0),(12,'','','123','','','','','','','','','','','123','',0),(13,'123','','123','','','','','','','','','','','123','',0),(14,'??????????????','??????????','??????','','','','','','','','','','','','',0),(15,'asdasd','','','','','','','','','','','','','','',0),(16,'qwe','','qwe','','','','','','','','','','','','',0),(17,'','','23234','','','','','','','','','','','','',1),(18,'asd','','asd','','','','','','','','','','','','',1),(19,'??????????????????????','','','','','','','','','','','','','','',1),(20,'??????????????','','','','','','','','','','','','','','',1),(21,'??????????????','','','','','','','','','','','','','?????????????? ??????????','',1),(22,'??????????????','','','','','','','','','','','','','','',1),(23,'??????????????','','Iasd','','','','','','','','','','','','',1),(24,'??????????????','????????????????','Iasd','','','','','','??.??????','','','','','','',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_docs`
--

DROP TABLE IF EXISTS `employee_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_docs` (
  `employee_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`employee_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_docs`
--

LOCK TABLES `employee_docs` WRITE;
/*!40000 ALTER TABLE `employee_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `license`
--

DROP TABLE IF EXISTS `license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `license` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `name_gov_com` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `license`
--

LOCK TABLES `license` WRITE;
/*!40000 ALTER TABLE `license` DISABLE KEYS */;
/*!40000 ALTER TABLE `license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licenzii_docs`
--

DROP TABLE IF EXISTS `licenzii_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `licenzii_docs` (
  `licenzii_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`licenzii_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licenzii_docs`
--

LOCK TABLES `licenzii_docs` WRITE;
/*!40000 ALTER TABLE `licenzii_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `licenzii_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oborudovanie`
--

DROP TABLE IF EXISTS `oborudovanie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oborudovanie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `ps` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oborudovanie`
--

LOCK TABLES `oborudovanie` WRITE;
/*!40000 ALTER TABLE `oborudovanie` DISABLE KEYS */;
/*!40000 ALTER TABLE `oborudovanie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oborudovanie_docs`
--

DROP TABLE IF EXISTS `oborudovanie_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oborudovanie_docs` (
  `oborudovanie_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`oborudovanie_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oborudovanie_docs`
--

LOCK TABLES `oborudovanie_docs` WRITE;
/*!40000 ALTER TABLE `oborudovanie_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `oborudovanie_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodact`
--

DROP TABLE IF EXISTS `prodact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodact`
--

LOCK TABLES `prodact` WRITE;
/*!40000 ALTER TABLE `prodact` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodact_docs`
--

DROP TABLE IF EXISTS `prodact_docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodact_docs` (
  `prodact_id` int NOT NULL,
  `docs_id` int NOT NULL,
  PRIMARY KEY (`prodact_id`,`docs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodact_docs`
--

LOCK TABLES `prodact_docs` WRITE;
/*!40000 ALTER TABLE `prodact_docs` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodact_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tender`
--

DROP TABLE IF EXISTS `tender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `web_address` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `inn_zakaz` varchar(10) DEFAULT NULL,
  `company_id` int NOT NULL,
  `count_employee` int DEFAULT NULL,
  `name_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tender`
--

LOCK TABLES `tender` WRITE;
/*!40000 ALTER TABLE `tender` DISABLE KEYS */;
INSERT INTO `tender` VALUES (1,'????????????','123','????123','123',1,1,NULL),(2,'???????????? ????????????????????????','????????','????777','5619875673',17,12,'?????? \"????????????????\"');
/*!40000 ALTER TABLE `tender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `inn` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Rinat','rinat','123','rinat@ya.ru','+7777','123'),(2,'Albuna','albina','222','albina@ya.ru','+7888','321'),(3,'Timur','timur','333','timur@ya.ru','+7111','213'),(4,'sdf','sdf',NULL,'','sdf','sdf'),(5,'rinat','rinatik',NULL,'rinatik@ya.ru','+79872422185','sozdatel13'),(6,'q','q','q','','q','q'),(7,'123','123','123','','123','123'),(8,'qw','qw','qw','','qw','qw'),(9,'qw','qw','qw','','qw','123'),(10,'qw','qw','qw','','qw','1'),(11,'123','123','123','','123','123'),(12,'123','123','123','','123','123'),(13,'22','12','22','','123','2'),(14,'22','12','22','','123','3'),(15,'22','12','22','','123','qwe'),(16,'22','12','22','','123','2'),(17,'22','12','22','','123','3'),(18,'22','12','22','','123','23'),(19,'22','12','22','','123','23'),(20,'234','234','234','','234','234'),(21,'123','123','123','','123','123'),(22,'123','123','123','','123','44'),(23,'123','123','123','','123','232'),(24,'123','123','123','','123','33'),(25,'123','123','123','','123','22'),(26,'123','123','123','','123','22'),(27,'123','123','123','','123','3'),(28,'123','123','123','','123','1'),(29,'123','123','123','','123','33'),(30,'123','123','123','','123','44'),(31,'123','123','123','','123','12'),(32,'123','123','123','','123','3'),(33,'123','123','123','','123','22'),(34,'123','123','123','','123','22'),(35,'123','123','123','','123','33'),(36,'123','123','123','','123','22'),(37,'123','123','123','','123','33'),(38,'123','123','123','','123','22'),(39,'123','123','123','','123','123'),(40,'123','123','123','','123','123'),(41,'123','123','123','','123','123'),(42,'123','123','123','','123','123'),(43,'123','123','123','','123','123'),(44,'123','123','123','','123','123'),(45,'123','123','123','','123','123'),(46,'123','123','123','','123','123'),(47,'123','??????????????','123','','123','123'),(48,'12','12','12','','12','12'),(49,'12','12','12','','12','12'),(50,'12','12','12','','21','21'),(51,'123','123','123','','123','123'),(52,'123','123','123','','123','123'),(53,'123','123','123','','123','123'),(54,'123','123','123','','123','33'),(55,'123','123','123','','123','123'),(56,'123','123','123','','123','123'),(57,'123','123','123','','123','8'),(58,'123','123','123','','123','123'),(59,'123','123','123','','123','123'),(60,'123','123','123','','123','123'),(61,'123','123','123','','123','12'),(62,'1','1','1','','1','1'),(63,'1','1','1','','1','1'),(64,'1','1','1','','1','1'),(65,'1','1','1','','1','1'),(66,'1','1','2','','2','2'),(67,'12','12','12','','12','12'),(68,'1','1','1','','1','1'),(69,'1','1','2','','2','3'),(70,'1','1','1','','3','4'),(71,'1','1','1','','3','4'),(72,'1','1','1','','3','4'),(73,'1','1','1','','1','1'),(74,'1','2','3','','4','5'),(75,'1','2','3','','4','5'),(76,'1','2','3','','4','5'),(77,'1','2','3','','4','5'),(78,'1','2','3','','4','5'),(79,'1','2','3','','4','5'),(80,'1','2','2','','3','4'),(81,'1','2','2','','3','4'),(82,'1','1','1','','1','1'),(83,'1','1','1','','1','1'),(84,'1','1','1','','1','1'),(85,'1','1','1','','1','1'),(86,'1','1','1','','1','1'),(87,'1','1','1','','1','1'),(88,'1','2','3','','4','5'),(89,'1','2','3','','4','5'),(90,'99','99','99','','99','99'),(91,'??????????','satana','007','uu@ya.ru','=9876222','123'),(92,'??????????','satana','007','uu@ya.ru','=9876222','444'),(93,'12','12','12','','12','12'),(94,'??????????','login','??????','ll@ya.ru','+888','123'),(95,'12','12','12','','12','12'),(96,'12','12','12','','12','12'),(97,'12','12','12','','12','12'),(98,'q','q','q','','q','q'),(99,'33','33','33','','33','33'),(100,'Admin','admin','777','admin@ya.ru','+7777','777'),(101,'Admin','admin','777','admin@ya.ru','+7777','777'),(102,'??????????','rinat','1234','123@yandex.ru','+798777','123'),(103,'Rinat','adminchik','12345','fanar13@ya.ru','+79872422185','sozdatel13'),(104,'??????????','rinat13','123123123','fanar1313@yandex.ru','+79872422185','Sozdatel13');
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

-- Dump completed on 2022-10-24 23:21:31
