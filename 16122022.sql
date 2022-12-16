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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `akkredit`
--

LOCK TABLES `akkredit` WRITE;
/*!40000 ALTER TABLE `akkredit` DISABLE KEYS */;
INSERT INTO `akkredit` VALUES (2,'0274051582','77-12/1233','10.10.2022','15.10.2023',17,'ПАО АНК \"Башнефть\"');
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
INSERT INTO `akkredit_docs` VALUES (1,51);
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
INSERT INTO `buh_docs` VALUES (2,39),(8,41),(10,108),(11,107),(12,106);
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
  `period_of_time` int DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buhdocument`
--

LOCK TABLES `buhdocument` WRITE;
/*!40000 ALTER TABLE `buhdocument` DISABLE KEYS */;
INSERT INTO `buhdocument` VALUES (1,'2022',1000,'3',17,0),(2,'2021',2000,'4',17,1),(3,'2020',1000,'5',17,2),(4,'2019',777,'20',17,3),(9,'2022',40,'20',21,0),(10,'2021',51,'18',21,1),(11,'2020',47,'13',21,2),(12,'2019',45,'15',21,3);
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
  `supervisor_id` int NOT NULL,
  `chief_accountant_id` int NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`supervisor_id`,`chief_accountant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (2,'Общестов с ограниченной ответственностью','Общество с ограниченной ответственностью \"Нефтегазкомплект\"','ООО \"Нефтегазкомплект\"','г. Уфа','NGK@yandex.ru',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,2,1,5,1,1),(10,'Общество с ограниченной ответственностью','Общество с ограниченной ответственностью \"Тест\"','ООО \"Тест\"','г.Уфа','test@ya.ru',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,22,22,1,101,1,1),(11,'Общество с ограниченной ответственностью','Общество с ограниченной ответственностью \"Тест\"','ООО \"Тест\"','г.Уфа','а/я 22','02020202','1233311','12754727','123123','13.01.2001','13.01.2001','123','ПАО','Сбербанк','г.Уфа','33333','44444','12313123','123123','42.03','com@ya.ru','+8877877','нет',0,0,0,102,1,1),(12,'123','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102,1,1),(13,'234','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102,1,1),(14,'123','','','','','','','','','','','','','','','','','','','','','','',0,0,0,102,1,1),(15,'asd','asdas','asdas','','','','','','','','','','','','','','','','','','','','',0,0,0,102,1,1),(16,'','','asdasd','','','','','','','','','','','','','','','','','','','','',0,0,0,102,1,1),(17,'Общество с ограниченной ответственностью ','Полное наименование	Общество с ограниченной ответственностью \"Гермес\"','ООО \"Гермес\"','426009, г. Ижевск, ул. Лесная, д. 123, оф. 11','426009, г. Ижевск, ул. Лесная, д. 123, оф. 11','5619875673','3451233456','8765412345231','123','01.01.2022','01.01.2022','','','','','','','45327266','370000000','45.19','info@germes.ru','+73412888887','',0,0,0,5,1,1),(18,'Общество с ограниченной ответственностью ','Общество с ограниченной ответственностью \"Гермес\"','ООО \"Гермес\"','426009, г. Ижевск, ул. Лесная, д. 123, оф. 11','426009, г. Ижевск, ул. Лесная, д. 123, оф. 11','5619875673','3451233456','8765412345231','123','01.01.2009','01.01.2009','045678345','ПАО','НашБанк','г.Уфа','4070987654345676543456','3090472627274747474732','45327266','370000000','45.19','info@germes.ru','+79872422185','www.info.com',0,0,0,103,1,1),(19,'Общество с ограниченной ответственностью','Общество с ограниченной ответственностью «Боромир плюс»','ООО «Боромир плюс»','Россия, Пермская область, г. Пермь, ул. Победителей, 134','	 641882, Россия, Пермская область, г. Пермь, ул. Победителей, 134','4201010000','420100000','1025604200000','12','13.01.2020','13.01.2020','041110000','ООО КБ','Кольцо Всевластия','г. Альметьевск','40701110103000000000','30101110100000000000','41301000','37000000','64.20','mail@site.ru','+79872422185','site.ru',0,0,0,104,1,1),(21,'Общество с ограниченной ответственностью','Общество с ограниченной ответственностью \"Мегга-Сервис\"','ООО \"Мегга-Сервис\"','Российская Федерация, Республика Башкортостан, г. Уфа, ул. Лизы Чайкиной дом 25 офис 1','450106, Республика Башкортостан, г. Уфа, а/я 42','0277126691','027701001','','МИФНС №39 по РБ','31.01.2013','31.01.2013','043601876','АО','Самарский филиал Банка \"ВБРР\"','443096, Россия г. Самара, ул. Осипенко, 11','40702810512120003171','30101810400000000876','12722553','','42.30','m-servis20@yandex.ru','83472661175','отсутствует',0,0,0,5,26,26);
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
INSERT INTO `company_docs` VALUES (21,80),(21,81),(21,82),(21,83),(21,84),(21,85),(21,86),(21,87),(21,88),(21,89),(21,90),(21,91),(21,110),(21,111),(21,112),(21,113),(21,114),(21,116),(21,117),(21,118),(21,119),(21,120),(21,121),(21,122),(21,123),(21,124),(21,125),(21,126),(21,127),(21,128),(21,129),(21,130),(21,131),(21,132),(21,133),(21,134),(21,135),(21,136),(21,137);
/*!40000 ALTER TABLE `company_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_owners`
--

DROP TABLE IF EXISTS `company_owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_owners` (
  `company_id` int NOT NULL,
  `owner_id` int NOT NULL,
  PRIMARY KEY (`company_id`,`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_owners`
--

LOCK TABLES `company_owners` WRITE;
/*!40000 ALTER TABLE `company_owners` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_owners` ENABLE KEYS */;
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
INSERT INTO `company_signature` VALUES (17,5),(21,7);
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
INSERT INTO `company_stamp` VALUES (17,6),(21,8);
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
  `name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `inn_zakaz` varchar(255) DEFAULT NULL,
  `inn_ispolnitel` varchar(255) DEFAULT NULL,
  `summ` varchar(255) DEFAULT NULL,
  `company_id` int NOT NULL,
  `smile_name_zakaz` varchar(255) DEFAULT NULL,
  `address_zakaz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (2,'Чистка','11.01.2022','31.12.2022','123',NULL,'1000000',17,'ООО ПАО АНК \"Башнефть\"',NULL),(4,'Договор на выполнение работ по ремонту основных фондов №БНС/ПТО/695/20/ДКС','12.01.2021','31.12.2021','0271006454',NULL,'2290394',21,'ООО \"Башнефть-Строй\"',NULL),(5,'Договор №В660721/0411Д подряда на выполнение работ','07.05.2021','31.12.2021','0277014204',NULL,'913722',21,'ПАО \"Уфаоргсинтез\"',NULL),(6,'Договор на выполнение работ по ремонту основных фондов №162/21/МГС','18.04.2021','31.12.2021','0273079970',NULL,'1445298',21,'ООО \"Техносервис\"',NULL),(7,'Договор на выполнение работ по ремонту основных фондов №БНС/ПТО/155/21/ДКС','01.04.2021','31.12.2021','0271006454',NULL,'11546104',21,'ООО \"Башнефть-Строй\"',NULL),(8,'Договор на выполнение работ по ремонту основных фондов №БНСНПЗ/У/154/21/ПРЧ','29.07.2021','31.12.2021','0275075378',NULL,'12876582',21,'ООО \"Башнефть-Сервис НПЗ\"',NULL),(9,'Договор на выполнение работ по ремонту основных фондов №БНСНПЗ/У/163/21/ПРЧ','25.08.2021','31.12.2022','0275075378',NULL,'9308518',21,'ООО \"Башнефть-Сервис НПЗ\"',NULL),(10,'Договор на выполнение работ по ремонту основных фондов №БНСНПЗ/У/153/21/ПРЧ','29.07.2021','31.12.2022','0275075378',NULL,'15824038',21,'ООО \"Башнефть-Сервис НПЗ\"',NULL),(11,'Договор на выполнение работ по ремонту основных фондов №БНС/ПТО/209/21/ДКС','14.05.2021','31.12.2022','0271006454',NULL,'709596',21,'ООО \"Башнефть-Строй\"',NULL),(12,'Договор на выполнение работ по чистке основных средств №БНФ/У/33/20/21/ДРО','03.02.2021','31.12.2021','027743002',NULL,'282001',21,'ПАО АНК \"Башнефть\"',NULL),(13,'Договор на выполнение работ по чистке основных средств №БНФ/у/32/63/21/ДРО','19.02.2021','31.12.2021','027743002',NULL,'151717',21,'ПАО АНК \"Башнефть\"',NULL),(14,'Договор субподряда на выполнение работ по ремонту основных фондов №МРП/П/51/06/21/1941','01.06.2021','31.12.2021','0278183780',NULL,'2493781',21,'ООО \"ТЭКСТРО\"',NULL),(15,'Договор №УТП-МС-И660721/0180Д подряда на выполнение работ','27.10.2021','31.12.2021','0277062423',NULL,'4800000',21,'ООО \"НПП \"УралТехПром\"',NULL),(16,'Договор на выполнение работ по ремонту основных фондов №472/21/МГС','28.06.2021','31.12.2021','0273079970',NULL,'900000',21,'ООО \"Техносервис\"',NULL),(17,'Договор субподряда на выполнение работ по ремонту основных фондов №УНХ/П/319/01/21/1876','25.01.2021','31.12.2021','0278183780',NULL,'2446569',21,'ООО \"ТЭКСТРО\"',NULL),(18,'Договор №69Р//16/158/309/00651/21 подряда на очистку резервуаров от нефтепродуктов с последующей утилизацией для Уфимской ТЭЦ-3','12.04.2021','31.12.2021','0277077282',NULL,'2640000',21,'ООО \"БГК\"',NULL),(19,'Договор на выполнение работ по чистке основных средств №БНФ/У/33/825/21ДРО','15.12.2021','31.12.2022','027743002',NULL,'3827763',21,'ПАО АНК \"Башнефть\"',NULL),(20,'Договор на выполнение работ по ремонту основных фондов №БНФ/У/33/490/21/ДРО','05.08.2021','31.12.2021','027743002',NULL,'17123792',21,'ПАО АНК \"Башнефть\"',NULL),(21,'Договор на выполнение работ по чистке основных средств №БНФ/У/33/742/21/ДРО','12.11.2021','31.12.2022','027743002',NULL,'22359667',21,'ПАО АНК \"Башнефть\"',NULL),(22,'Договор на выполнение работ по чистке основных средств №БНФ/У/33/805/21/ДРО','01.12.2021','31.12.2022','027743002',NULL,'41528301',21,'ПАО АНК \"Башнефть\"',NULL),(23,'Договор на выполнение работ по чистке основных средств №БНСНПЗ/У/128/21/ПРЧ','18.06.2021','31.12.2022','0275075378',NULL,'2920470',21,'ООО \"Башнефть-Сервис НПЗ\"',NULL);
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
INSERT INTO `contract_docs` VALUES (4,92),(5,93),(6,94),(7,95),(8,96),(9,97),(10,98),(11,99),(12,100),(13,101),(14,102),(15,103),(16,104),(17,105);
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
  `company_id` int DEFAULT NULL,
  `block` varchar(255) DEFAULT NULL,
  `block_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_pdf`
--

LOCK TABLES `document_pdf` WRITE;
/*!40000 ALTER TABLE `document_pdf` DISABLE KEYS */;
INSERT INTO `document_pdf` VALUES (39,'Документ','user_5/company_17/buhdocuments',17,'buhdocuments',1),(41,'Сведения о кадрах','user_5/company_17/buhdocuments',17,'buhdocuments',4),(42,'Письмо','user_5/company_17/employees',17,'employees',3),(47,'Лицензия','user_5/company_17/licenses',17,'licenses',1),(80,'iso 9001','user_5/company_21/all_docs',21,'all_docs',0),(81,'iso 14001','user_5/company_21/all_docs',21,'all_docs',0),(82,'iso 45001','user_5/company_21/all_docs',21,'all_docs',0),(83,'Договор аренды помещения','user_5/company_21/all_docs',21,'all_docs',0),(84,'Лист егрюл','user_5/company_21/all_docs',21,'all_docs',0),(85,'лист записи','user_5/company_21/all_docs',21,'all_docs',0),(86,'Приказ на директора и гб','user_5/company_21/all_docs',21,'all_docs',0),(87,'решение № 4','user_5/company_21/all_docs',21,'all_docs',0),(88,'свидетельство инн','user_5/company_21/all_docs',21,'all_docs',0),(89,'свидетельство о регистрации юр лица','user_5/company_21/all_docs',21,'all_docs',0),(90,'Устав ч1','user_5/company_21/all_docs',21,'all_docs',0),(91,'Устав ч2','user_5/company_21/all_docs',21,'all_docs',0),(92,'','user_5/company_21/contracts',21,'contracts',4),(93,'Договор №В660721','user_5/company_21/contracts',21,'contracts',5),(94,'Договор 162','user_5/company_21/contracts',21,'contracts',6),(95,'Договор 155','user_5/company_21/contracts',21,'contracts',7),(96,'Договор 154','user_5/company_21/contracts',21,'contracts',8),(97,'Договор 163','user_5/company_21/contracts',21,'contracts',9),(98,'Договор 153','user_5/company_21/contracts',21,'contracts',10),(99,'Договор 209','user_5/company_21/contracts',21,'contracts',11),(100,'Договор 33 20','user_5/company_21/contracts',21,'contracts',12),(101,'Договор 32 63','user_5/company_21/contracts',21,'contracts',13),(102,'Договор 51 06','user_5/company_21/contracts',21,'contracts',14),(103,'Договор 0180Д','user_5/company_21/contracts',21,'contracts',15),(104,'Договор 472','user_5/company_21/contracts',21,'contracts',16),(105,'Договор 319','user_5/company_21/contracts',21,'contracts',17),(106,'БО 2019','user_5/company_21/buhdocuments',21,'buhdocuments',12),(107,'БО 2020 год','user_5/company_21/buhdocuments',21,'buhdocuments',11),(108,'БО 2021','user_5/company_21/buhdocuments',21,'buhdocuments',10),(109,'Лицензия на отходы','user_5/company_21/licenses',21,'licenses',3),(110,'Структура','user_5/company_21/all_docs',21,'all_docs',0),(111,'Приказ № 11 о СИЗ','user_5/company_21/all_docs',21,'all_docs',0),(112,'Сводная ведомость условий труда','user_5/company_21/all_docs',21,'all_docs',0),(113,'Перечень программ инструктажей','user_5/company_21/all_docs',21,'all_docs',0),(114,'Положение о инструктаже','user_5/company_21/all_docs',21,'all_docs',0),(116,'программа вводного иструктажа','user_5/company_21/all_docs',21,'all_docs',0),(117,'ДИ спец','user_5/company_21/all_docs',21,'all_docs',0),(118,'программа первичного иструктажа','user_5/company_21/all_docs',21,'all_docs',0),(119,'первичный инструктаж водителя','user_5/company_21/all_docs',21,'all_docs',0),(120,'Первичный инструктаж слесаря','user_5/company_21/all_docs',21,'all_docs',0),(121,'Справка о медосмотрах 2021','user_5/company_21/all_docs',21,'all_docs',0),(122,'Акт о прохождении мед осмотров','user_5/company_21/all_docs',21,'all_docs',0),(123,'Гарантия наличия сотрудника ОТ','user_5/company_21/all_docs',21,'all_docs',0),(124,'Договор о проведении мед осмотров','user_5/company_21/all_docs',21,'all_docs',0),(125,'Договор 180 о мед осмотре','user_5/company_21/all_docs',21,'all_docs',0),(126,'Пред мед осмотр','user_5/company_21/all_docs',21,'all_docs',0),(127,'Предрейсовый мед осмотр','user_5/company_21/all_docs',21,'all_docs',0),(128,'Договор профитек','user_5/company_21/all_docs',21,'all_docs',0),(129,'Заключение соут 2015','user_5/company_21/all_docs',21,'all_docs',0),(130,'Лицензия профиТЭК','user_5/company_21/all_docs',21,'all_docs',0),(131,'отчёт соут до 2025','user_5/company_21/all_docs',21,'all_docs',0),(132,'перечень инструкций по охране труда','user_5/company_21/all_docs',21,'all_docs',0),(133,'Перечень инструкций ч1','user_5/company_21/all_docs',21,'all_docs',0),(134,'Положение о СУОТ и ПБ','user_5/company_21/all_docs',21,'all_docs',0),(135,'Приказ о нормах выдачи СИЗ','user_5/company_21/all_docs',21,'all_docs',0),(136,'приказ о внедрении СУОТ и ПБ','user_5/company_21/all_docs',21,'all_docs',0),(137,'Программа инструктажа слесаря чистильщика','user_5/company_21/all_docs',21,'all_docs',0);
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
  `surname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `patronymic` varchar(255) DEFAULT NULL,
  `passport_serial` varchar(255) DEFAULT NULL,
  `passport_number` varchar(255) DEFAULT NULL,
  `passport_gov_name` varchar(255) DEFAULT NULL,
  `date_gov` varchar(255) DEFAULT NULL,
  `date_happy` varchar(255) DEFAULT NULL,
  `address_reg` varchar(255) DEFAULT NULL,
  `telephone_number` varchar(255) DEFAULT NULL,
  `inn` varchar(255) DEFAULT NULL,
  `snils` varchar(255) DEFAULT NULL,
  `goverment_status` varchar(255) DEFAULT NULL,
  `position_com` varchar(255) DEFAULT NULL,
  `date_trud` varchar(255) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Губ','Ринат','Наил','','','','','','','','','','','asd','',1),(2,'Губ','Альбина','Илдаровна','','','','','','','','','','','Владыка','',1),(3,'Тимур','Губайдуллин','Ринатович','1234','4123123','МВД г Уфа','10.01.2016','13.08.1989','РФ РБ г. Уфа','+79876543210','123','123566','Российская Федерация','Генеральный директор','01.01.2022',17),(10,'asd','','asd','','','','','','','','','','','','',0),(11,'12','','','','','','','','','','','','','','',0),(12,'','','123','','','','','','','','','','','123','',0),(13,'123','','123','','','','','','','','','','','123','',0),(14,'Гафаров','Ринат','ФФФ','','','','','','','','','','','','',0),(15,'asdasd','','','','','','','','','','','','','','',0),(16,'qwe','','qwe','','','','','','','','','','','','',0),(17,'','','23234','','','','','','','','','','','','',1),(18,'asd','','asd','','','','','','','','','','','','',1),(19,'Губайдуллин','','','','','','','','','','','','','','',1),(20,'Шаляпин','','','','','','','','','','','','','','',1),(21,'Шаляпин','','','','','','','','','','','','','Главный шляпа','',1),(22,'Шаляпин','','','','','','','','','','','','','','',1),(23,'Шаляпин','','Iasd','','','','','','','','','','','','',1),(24,'Шаляпин','Писатель','Iasd','','','','','','г.Уфа','','','','','','',1),(26,'Гайнулин','Руслан','Рафикович','8008','621254','ОТДЕЛОМ УФМС РОССИИ ПО РБ В КИРОВСКОМ РАЙОНЕ ГОР. УФЫ','19.09.2008','13.09.1988','РФ, РБ, г. Уфа, ул. Рабкоров дом 4 корпус 4 квартира 179','+79273458195','027722686553','12855870088','Российская Федерация','Генеральный директор','10.03.2020',21);
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
INSERT INTO `employee_docs` VALUES (3,42);
/*!40000 ALTER TABLE `employee_docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_jpg`
--

DROP TABLE IF EXISTS `image_jpg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_jpg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `block` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company_id` int NOT NULL,
  `block_id` int DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_jpg`
--

LOCK TABLES `image_jpg` WRITE;
/*!40000 ALTER TABLE `image_jpg` DISABLE KEYS */;
INSERT INTO `image_jpg` VALUES (5,'Подпись','signature','user_5/company_17/signatureStamp',17,0),(6,'Печать','stamp','user_5/company_17/signatureStamp',17,0),(7,'подпись директора','signature','user_5/company_21/signatureStamp',21,0),(8,'печать компании','stamp','user_5/company_21/signatureStamp',21,0);
/*!40000 ALTER TABLE `image_jpg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `license`
--

DROP TABLE IF EXISTS `license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `license` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `name_gov_com` varchar(255) DEFAULT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `license`
--

LOCK TABLES `license` WRITE;
/*!40000 ALTER TABLE `license` DISABLE KEYS */;
INSERT INTO `license` VALUES (1,'Транспортировка и утилизация отходов','01.11.2022','123','31.12.2030','Ростуризм',17),(3,'Осуществление деятельности по сбору транспортированию отходов 1 - 4 класса опасности','10.01.2017','02 00440','','Управление Росприроднадзора',21);
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
INSERT INTO `licenzii_docs` VALUES (1,47),(3,109);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `identifier` varchar(255) DEFAULT NULL,
  `share` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner_owners`
--

DROP TABLE IF EXISTS `owner_owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner_owners` (
  `owner_id` int NOT NULL,
  `owners_id` int NOT NULL,
  PRIMARY KEY (`owner_id`,`owners_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner_owners`
--

LOCK TABLES `owner_owners` WRITE;
/*!40000 ALTER TABLE `owner_owners` DISABLE KEYS */;
/*!40000 ALTER TABLE `owner_owners` ENABLE KEYS */;
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
  `address_company` varchar(255) DEFAULT NULL,
  `type_of_tender` int DEFAULT NULL,
  `method_tender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tender`
--

LOCK TABLES `tender` WRITE;
/*!40000 ALTER TABLE `tender` DISABLE KEYS */;
INSERT INTO `tender` VALUES (1,'Чистка','123','РН123','123',1,1,NULL,NULL,0,'Запрос цен'),(2,'Ремонт оборудования','нету','РН777','5619875673',17,12,'ООО \"Башнефть\"',NULL,0,'Запрос цен'),(5,'Чистка промышленного оборудования АВТ-6','нету','РН22121122','0274051582',1,5,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(6,'Чистка промышленного оборудования','нету','РН20201233','0274051582',17,5,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(8,'Чистка промышленного оборудования','нету','РН5112311','12345678',21,10,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(9,'Тестовая чистка № 111','нету','№111','123',17,2,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(10,'Тестовая чистка № 222','нету','№222','22111',17,3,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(11,'Тестовая чистка № 333','нету','№ 333','21123',17,4,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(12,'Чистка АВО','нету','РН777','123',21,5,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(13,'Чистка резервуаров','нету','РН001','123',21,10,'ПАО АНК \"Башнефть\"',NULL,0,'Запрос цен'),(14,'Чистка звезды','нету','1111','123',17,20,'ПАО АНК \"Башнефть\"',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Rinat','rinat','123','rinat@ya.ru','+7777','123'),(2,'Albuna','albina','222','albina@ya.ru','+7888','321'),(3,'Timur','timur','333','timur@ya.ru','+7111','213'),(4,'sdf','sdf',NULL,'','sdf','sdf'),(5,'rinat','rinatik',NULL,'rinatik@ya.ru','+79872422185','sozdatel13'),(6,'q','q','q','','q','q'),(7,'123','123','123','','123','123'),(8,'qw','qw','qw','','qw','qw'),(9,'qw','qw','qw','','qw','123'),(10,'qw','qw','qw','','qw','1'),(11,'123','123','123','','123','123'),(12,'123','123','123','','123','123'),(13,'22','12','22','','123','2'),(14,'22','12','22','','123','3'),(15,'22','12','22','','123','qwe'),(16,'22','12','22','','123','2'),(17,'22','12','22','','123','3'),(18,'22','12','22','','123','23'),(19,'22','12','22','','123','23'),(20,'234','234','234','','234','234'),(21,'123','123','123','','123','123'),(22,'123','123','123','','123','44'),(23,'123','123','123','','123','232'),(24,'123','123','123','','123','33'),(25,'123','123','123','','123','22'),(26,'123','123','123','','123','22'),(27,'123','123','123','','123','3'),(28,'123','123','123','','123','1'),(29,'123','123','123','','123','33'),(30,'123','123','123','','123','44'),(31,'123','123','123','','123','12'),(32,'123','123','123','','123','3'),(33,'123','123','123','','123','22'),(34,'123','123','123','','123','22'),(35,'123','123','123','','123','33'),(36,'123','123','123','','123','22'),(37,'123','123','123','','123','33'),(38,'123','123','123','','123','22'),(39,'123','123','123','','123','123'),(40,'123','123','123','','123','123'),(41,'123','123','123','','123','123'),(42,'123','123','123','','123','123'),(43,'123','123','123','','123','123'),(44,'123','123','123','','123','123'),(45,'123','123','123','','123','123'),(46,'123','123','123','','123','123'),(47,'123','ОООочко','123','','123','123'),(48,'12','12','12','','12','12'),(49,'12','12','12','','12','12'),(50,'12','12','12','','21','21'),(51,'123','123','123','','123','123'),(52,'123','123','123','','123','123'),(53,'123','123','123','','123','123'),(54,'123','123','123','','123','33'),(55,'123','123','123','','123','123'),(56,'123','123','123','','123','123'),(57,'123','123','123','','123','8'),(58,'123','123','123','','123','123'),(59,'123','123','123','','123','123'),(60,'123','123','123','','123','123'),(61,'123','123','123','','123','12'),(62,'1','1','1','','1','1'),(63,'1','1','1','','1','1'),(64,'1','1','1','','1','1'),(65,'1','1','1','','1','1'),(66,'1','1','2','','2','2'),(67,'12','12','12','','12','12'),(68,'1','1','1','','1','1'),(69,'1','1','2','','2','3'),(70,'1','1','1','','3','4'),(71,'1','1','1','','3','4'),(72,'1','1','1','','3','4'),(73,'1','1','1','','1','1'),(74,'1','2','3','','4','5'),(75,'1','2','3','','4','5'),(76,'1','2','3','','4','5'),(77,'1','2','3','','4','5'),(78,'1','2','3','','4','5'),(79,'1','2','3','','4','5'),(80,'1','2','2','','3','4'),(81,'1','2','2','','3','4'),(82,'1','1','1','','1','1'),(83,'1','1','1','','1','1'),(84,'1','1','1','','1','1'),(85,'1','1','1','','1','1'),(86,'1','1','1','','1','1'),(87,'1','1','1','','1','1'),(88,'1','2','3','','4','5'),(89,'1','2','3','','4','5'),(90,'99','99','99','','99','99'),(91,'Риант','satana','007','uu@ya.ru','=9876222','123'),(92,'Риант','satana','007','uu@ya.ru','=9876222','444'),(93,'12','12','12','','12','12'),(94,'Ринат','login','инн','ll@ya.ru','+888','123'),(95,'12','12','12','','12','12'),(96,'12','12','12','','12','12'),(97,'12','12','12','','12','12'),(98,'q','q','q','','q','q'),(99,'33','33','33','','33','33'),(100,'Admin','admin','777','admin@ya.ru','+7777','777'),(101,'Admin','admin','777','admin@ya.ru','+7777','777'),(102,'Ринат','rinat','1234','123@yandex.ru','+798777','123'),(103,'Rinat','adminchik','12345','fanar13@ya.ru','+79872422185','sozdatel13'),(104,'Ринат','rinat13','123123123','fanar1313@yandex.ru','+79872422185','Sozdatel13'),(105,'','','','','',''),(106,'rinat','adimn','123','ad@ad.ru','+77771111222','admin');
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

-- Dump completed on 2022-12-16 21:22:18
