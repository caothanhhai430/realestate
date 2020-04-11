CREATE DATABASE  IF NOT EXISTS `estate_caothanhhai_82019` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `estate_caothanhhai_82019`;
-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: estate_springmvc82019
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS account;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  username varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--


--
-- Table structure for table `assignmentstaff`
--

DROP TABLE IF EXISTS assignmentstaff;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE assignmentstaff (
  buildingid bigint(20) NOT NULL,
  staffid bigint(20) NOT NULL,
  PRIMARY KEY (buildingid,staffid),
  KEY FKog4mtdj5yiutsbq096hwwcf5u (staffid),
  CONSTRAINT FKog4mtdj5yiutsbq096hwwcf5u FOREIGN KEY (staffid) REFERENCES `user` (id),
  CONSTRAINT FKrrkj46ufr182l79jwnkonlu89 FOREIGN KEY (buildingid) REFERENCES building (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentstaff`
--

INSERT INTO assignmentstaff VALUES (3,2);
INSERT INTO assignmentstaff VALUES (4,2);
INSERT INTO assignmentstaff VALUES (5,4);

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS building;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE building (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  buildingarea bigint(20) DEFAULT NULL,
  carcost varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  costdescription varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  timedecorator varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  deposit varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  district varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  electricitycost varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  managername varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  managerphone varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  motorbikecost varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  numberofbasement bigint(20) DEFAULT NULL,
  overtimecost varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  payment varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  costrent bigint(20) DEFAULT NULL,
  timerent varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  servicecost varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  street varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  structure varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  ward varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

INSERT INTO building VALUES (3,'hai2','2020-04-11 23:36:23','cth11','2020-04-12 00:26:28',4651,'1','1','1','1','QUAN_GO_VAP','1','Nguyễn Văn E','0991564409','1','FLC Tower 7',5,'1','1',1460,'1','1','đường Nguyễn Trãi','1','NGUYEN_CAN,NOI_THAT,TANG_TRET','phường 1');
INSERT INTO building VALUES (4,'hai2','2020-04-11 23:36:23','hai2','2020-04-12 00:25:18',3068,'','','','','QUAN_TAN_BINH','','Nguyễn Văn E','0497879419','','Bitexco 93',10,'','',2058,'','','đường Lê Thị Riêng','','TANG_TRET','phường 5');
INSERT INTO building VALUES (5,'hai2','2020-04-11 23:36:23','cth12','2020-04-12 00:36:58',4361,'1','1','1','1','HUYEN_CAN_GIO','1','Nguyễn Văn F','0724516479','1','Sonadezi 143',7,'1','1',1073,'1','1','đường Lê Lai','1','NGUYEN_CAN,NOI_THAT,TANG_TRET','phường 10');
INSERT INTO building VALUES (6,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',3922,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn E','0215373661','','FLC Tower 110',1,'','',492,'','','đường Nguyễn Huệ','','TANG_TRET','phường 3');
INSERT INTO building VALUES (7,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',1578,'','','','','QUAN_11','','Nguyễn Văn A','0893753036','','Sonadezi 124',2,'','',2453,'','','đường Lê Thị Riêng','','TANG_TRET','phường 10');
INSERT INTO building VALUES (8,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',1909,'','','','','QUAN_12','','Nguyễn Văn C','0413043213','','Landmark 87',4,'','',1616,'','','đường Lê Thị Riêng','','TANG_TRET','phường 7');
INSERT INTO building VALUES (9,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',4333,'','','','','QUAN_GO_VAP','','Nguyễn Văn A','0744159074','','FLC Tower 77',6,'','',543,'','','đường Nguyễn Trãi','','NGUYEN_CAN','phường 10');
INSERT INTO building VALUES (10,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',4666,'','','','','QUAN_THU_DUC','','Nguyễn Văn E','0423827043','','FLC Tower 15',1,'','',153,'','','đường Hàm Nghi','','NGUYEN_CAN','phường 5');
INSERT INTO building VALUES (11,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',1357,'','','','','QUAN_TAN_PHU','','Nguyễn Văn A','0325008696','','FLC Tower 171',8,'','',1530,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 5');
INSERT INTO building VALUES (12,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',3436,'','','','','QUAN_11','','Nguyễn Văn D','0323794454','','Bitexco 106',8,'','',1341,'','','đường Nguyễn Trãi','','NGUYEN_CAN','phường 2');
INSERT INTO building VALUES (13,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',4637,'','','','','HUYEN_HOC_MON','','Nguyễn Văn B','0422709700','','Lotte Center 122',4,'','',2920,'','','đường Nguyễn Huệ','','NOI_THAT','phường 4');
INSERT INTO building VALUES (14,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',773,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn C','0229578069','','Landmark 41',5,'','',1427,'','','đường Nguyễn Trãi','','NOI_THAT','phường 0');
INSERT INTO building VALUES (15,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',2671,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn F','0019173512','','Sonadezi 137',4,'','',1334,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 2');
INSERT INTO building VALUES (16,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',2654,'','','','','QUAN_8','','Nguyễn Văn D','0919642443','','FLC Tower 170',7,'','',1878,'','','đường Võ Văn Kiệt','','NOI_THAT','phường 0');
INSERT INTO building VALUES (17,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',3208,'','','','','QUAN_9','','Nguyễn Văn E','0027652532','','Sonadezi 147',10,'','',2494,'','','đường Lê Lai','','NOI_THAT','phường 8');
INSERT INTO building VALUES (18,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',2476,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn H','0562186921','','Landmark 159',7,'','',232,'','','đường Nguyễn Huệ','','NOI_THAT','phường 0');
INSERT INTO building VALUES (19,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',2434,'','','','','QUAN_6','','Nguyễn Văn C','0324418959','','Lotte Center 36',6,'','',2784,'','','đường Hàm Nghi','','NOI_THAT','phường 0');
INSERT INTO building VALUES (20,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',337,'','','','','QUAN_4','','Nguyễn Văn C','0750968567','','Lotte Center 193',4,'','',2772,'','','đường Võ Văn Kiệt','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (21,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',3019,'','','','','QUAN_8','','Nguyễn Văn D','0977061614','','Lotte Center 23',1,'','',2450,'','','đường Lê Lai','','NGUYEN_CAN','phường 10');
INSERT INTO building VALUES (22,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',4208,'','','','','HUYEN_CU_CHI','','Nguyễn Văn C','0445030629','','Bitexco 123',1,'','',495,'','','đường Nguyễn Huệ','','TANG_TRET','phường 3');
INSERT INTO building VALUES (23,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',3743,'','','','','HUYEN_CAN_GIO','','Nguyễn Văn G','0416400547','','Lotte Center 180',3,'','',953,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 8');
INSERT INTO building VALUES (24,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',4932,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn E','0969747176','','Vinfast 186',8,'','',1410,'','','đường Nguyễn Trãi','','TANG_TRET','phường 0');
INSERT INTO building VALUES (25,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',2272,'','','','','QUAN_2','','Nguyễn Văn H','0800946102','','Lotte Center 167',7,'','',1184,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 8');
INSERT INTO building VALUES (26,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1533,'','','','','QUAN_THU_DUC','','Nguyễn Văn C','0833464923','','Lotte Center 164',8,'','',1184,'','','đường Phạm Ngũ Lão','','NGUYEN_CAN','phường 6');
INSERT INTO building VALUES (27,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',4848,'','','','','QUAN_12','','Nguyễn Văn E','0944750229','','Vinfast 56',6,'','',622,'','','đường Lê Thị Riêng','','TANG_TRET','phường 0');
INSERT INTO building VALUES (28,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',2622,'','','','','QUAN_TAN_PHU','','Nguyễn Văn B','0100862303','','Bitexco 124',9,'','',1125,'','','đường Lê Thị Riêng','','NOI_THAT','phường 6');
INSERT INTO building VALUES (29,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',3601,'','','','','QUAN_TAN_BINH','','Nguyễn Văn B','0599505693','','Vinfast 24',10,'','',479,'','','đường Lê Thị Riêng','','TANG_TRET','phường 10');
INSERT INTO building VALUES (30,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',4402,'','','','','QUAN_TAN_PHU','','Nguyễn Văn G','0642815193','','FLC Tower 106',3,'','',469,'','','đường Nguyễn Trãi','','TANG_TRET','phường 1');
INSERT INTO building VALUES (31,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1018,'','','','','QUAN_TAN_BINH','','Nguyễn Văn E','0212062802','','Sonadezi 95',7,'','',766,'','','đường Võ Văn Kiệt','','NGUYEN_CAN','phường 2');
INSERT INTO building VALUES (32,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',931,'','','','','QUAN_GO_VAP','','Nguyễn Văn B','0327665526','','Sonadezi 186',10,'','',908,'','','đường Nguyễn Trãi','','NGUYEN_CAN','phường 7');
INSERT INTO building VALUES (33,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',622,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn E','0369815465','','Vinfast 197',5,'','',2183,'','','đường Hàm Nghi','','TANG_TRET','phường 4');
INSERT INTO building VALUES (34,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',211,'','','','','QUAN_2','','Nguyễn Văn H','0157674545','','Bitexco 4',8,'','',1081,'','','đường Lê Lai','','NGUYEN_CAN','phường 6');
INSERT INTO building VALUES (35,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1729,'','','','','QUAN_GO_VAP','','Nguyễn Văn A','0179829322','','Sonadezi 32',2,'','',1606,'','','đường Nguyễn Huệ','','TANG_TRET','phường 3');
INSERT INTO building VALUES (36,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1274,'','','','','QUAN_9','','Nguyễn Văn H','0927085690','','Sonadezi 62',7,'','',100,'','','đường Lê Lai','','NGUYEN_CAN','phường 10');
INSERT INTO building VALUES (37,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',3105,'','','','','QUAN_BINH_THANH','','Nguyễn Văn C','0780873370','','Bitexco 113',5,'','',630,'','','đường Nguyễn Trãi','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (38,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1405,'','','','','QUAN_9','','Nguyễn Văn F','0842090081','','Lotte Center 198',8,'','',909,'','','đường Hàm Nghi','','TANG_TRET','phường 8');
INSERT INTO building VALUES (39,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1937,'','','','','HUYEN_BINH_CHANH','','Nguyễn Văn D','0413169634','','Sonadezi 165',3,'','',896,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 4');
INSERT INTO building VALUES (40,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',936,'','','','','QUAN_9','','Nguyễn Văn F','0679782734','','Landmark 32',5,'','',2080,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 3');
INSERT INTO building VALUES (41,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',286,'','','','','QUAN_8','','Nguyễn Văn H','0578292141','','Vinfast 149',4,'','',1282,'','','đường Phạm Ngũ Lão','','TANG_TRET','phường 7');
INSERT INTO building VALUES (42,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3668,'','','','','HUYEN_CU_CHI','','Nguyễn Văn E','0998761697','','Landmark 89',8,'','',2185,'','','đường Phạm Ngũ Lão','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (43,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2984,'','','','','QUAN_12','','Nguyễn Văn H','0136411833','','Sonadezi 7',2,'','',1188,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 1');
INSERT INTO building VALUES (44,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2426,'','','','','QUAN_8','','Nguyễn Văn A','0922841066','','Landmark 110',5,'','',1028,'','','đường Lê Lai','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (45,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1998,'','','','','QUAN_6','','Nguyễn Văn E','0607672264','','Lotte Center 85',6,'','',300,'','','đường Hàm Nghi','','NGUYEN_CAN','phường 7');
INSERT INTO building VALUES (46,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',4163,'','','','','HUYEN_CU_CHI','','Nguyễn Văn A','0700760999','','Sonadezi 132',6,'','',102,'','','đường Lê Thị Riêng','','TANG_TRET','phường 4');
INSERT INTO building VALUES (47,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2279,'','','','','QUAN_TAN_BINH','','Nguyễn Văn B','0993602037','','Landmark 29',6,'','',521,'','','đường Lê Lai','','TANG_TRET','phường 0');
INSERT INTO building VALUES (48,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3240,'','','','','HUYEN_CAN_GIO','','Nguyễn Văn C','0937530323','','Vinfast 167',8,'','',2506,'','','đường Lê Lai','','NOI_THAT','phường 3');
INSERT INTO building VALUES (49,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3251,'','','','','QUAN_THU_DUC','','Nguyễn Văn B','0554008813','','Landmark 15',1,'','',1933,'','','đường Lê Thị Riêng','','TANG_TRET','phường 6');
INSERT INTO building VALUES (50,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3869,'','','','','QUAN_7','','Nguyễn Văn H','0023544675','','Landmark 152',9,'','',1643,'','','đường Phạm Ngũ Lão','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (51,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3223,'','','','','HUYEN_CU_CHI','','Nguyễn Văn E','0656332847','','Bitexco 7',6,'','',2786,'','','đường Hàm Nghi','','NOI_THAT','phường 8');
INSERT INTO building VALUES (52,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2797,'','','','','HUYEN_CU_CHI','','Nguyễn Văn G','0033944685','','Landmark 110',6,'','',992,'','','đường Võ Văn Kiệt','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (53,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2126,'','','','','QUAN_1','','Nguyễn Văn E','0353232225','','Lotte Center 199',3,'','',2654,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 9');
INSERT INTO building VALUES (54,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1354,'','','','','QUAN_10','','Nguyễn Văn H','0695753166','','Lotte Center 76',3,'','',617,'','','đường Nguyễn Trãi','','TANG_TRET','phường 6');
INSERT INTO building VALUES (55,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3704,'','','','','QUAN_TAN_BINH','','Nguyễn Văn E','0891612841','','Bitexco 50',8,'','',2814,'','','đường Lê Lai','','NOI_THAT','phường 8');
INSERT INTO building VALUES (56,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',4501,'','','','','QUAN_2','','Nguyễn Văn A','0269751253','','Lotte Center 44',6,'','',2839,'','','đường Lê Thị Riêng','','NOI_THAT','phường 4');
INSERT INTO building VALUES (57,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',4818,'','','','','QUAN_3','','Nguyễn Văn F','0403683661','','Bitexco 151',6,'','',1496,'','','đường Phạm Ngũ Lão','','NGUYEN_CAN','phường 1');
INSERT INTO building VALUES (58,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',4950,'','','','','QUAN_7','','Nguyễn Văn F','0741346581','','Bitexco 187',4,'','',315,'','','đường Nguyễn Trãi','','NOI_THAT','phường 10');
INSERT INTO building VALUES (59,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',4829,'','','','','QUAN_7','','Nguyễn Văn F','0263459710','','FLC Tower 36',9,'','',2756,'','','đường Lê Thị Riêng','','NOI_THAT','phường 5');
INSERT INTO building VALUES (60,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',654,'','','','','QUAN_9','','Nguyễn Văn G','0316606347','','Lotte Center 94',7,'','',389,'','','đường Nguyễn Trãi','','TANG_TRET','phường 10');
INSERT INTO building VALUES (61,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',687,'','','','','QUAN_2','','Nguyễn Văn C','0117041428','','Landmark 87',1,'','',344,'','','đường Lê Thị Riêng','','NOI_THAT','phường 6');
INSERT INTO building VALUES (62,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2065,'','','','','HUYEN_HOC_MON','','Nguyễn Văn E','0070755416','','FLC Tower 196',5,'','',1088,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 0');
INSERT INTO building VALUES (63,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3133,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn G','0255223307','','Vinfast 133',4,'','',274,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 10');
INSERT INTO building VALUES (64,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1516,'','','','','QUAN_5','','Nguyễn Văn H','0017777680','','FLC Tower 200',5,'','',211,'','','đường Lê Thị Riêng','','TANG_TRET','phường 0');
INSERT INTO building VALUES (65,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',2876,'','','','','QUAN_7','','Nguyễn Văn B','0593895436','','Vinfast 2',10,'','',1427,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 5');
INSERT INTO building VALUES (66,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',796,'','','','','QUAN_12','','Nguyễn Văn H','0433234129','','Sonadezi 33',7,'','',717,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (67,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',3032,'','','','','HUYEN_BINH_CHANH','','Nguyễn Văn H','0574161829','','Sonadezi 118',4,'','',2219,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 1');
INSERT INTO building VALUES (68,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',3102,'','','','','QUAN_7','','Nguyễn Văn D','0350359562','','Bitexco 183',5,'','',2500,'','','đường Nguyễn Huệ','','TANG_TRET','phường 7');
INSERT INTO building VALUES (69,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',117,'','','','','HUYEN_CU_CHI','','Nguyễn Văn C','0728590969','','Landmark 105',5,'','',556,'','','đường Hàm Nghi','','TANG_TRET','phường 1');
INSERT INTO building VALUES (70,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4182,'','','','','QUAN_3','','Nguyễn Văn B','0532400379','','FLC Tower 62',6,'','',328,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 3');
INSERT INTO building VALUES (71,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2939,'','','','','QUAN_TAN_PHU','','Nguyễn Văn B','0527114255','','Bitexco 193',2,'','',1422,'','','đường Nguyễn Trãi','','TANG_TRET','phường 7');
INSERT INTO building VALUES (72,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4025,'','','','','QUAN_TAN_PHU','','Nguyễn Văn E','0174940159','','FLC Tower 176',8,'','',2682,'','','đường Lê Lai','','TANG_TRET','phường 2');
INSERT INTO building VALUES (73,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',3514,'','','','','QUAN_9','','Nguyễn Văn E','0245845986','','Bitexco 86',5,'','',779,'','','đường Lê Lai','','NGUYEN_CAN','phường 8');
INSERT INTO building VALUES (74,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2849,'','','','','QUAN_2','','Nguyễn Văn C','0959162512','','Sonadezi 10',5,'','',2792,'','','đường Hàm Nghi','','TANG_TRET','phường 5');
INSERT INTO building VALUES (75,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',1627,'','','','','QUAN_1','','Nguyễn Văn C','0486587130','','FLC Tower 189',9,'','',2188,'','','đường Lê Lai','','TANG_TRET','phường 6');
INSERT INTO building VALUES (76,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',292,'','','','','QUAN_BINH_THANH','','Nguyễn Văn C','0810057753','','Vinfast 132',7,'','',2197,'','','đường Lê Lai','','TANG_TRET','phường 8');
INSERT INTO building VALUES (77,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4511,'','','','','QUAN_BINH_TAN','','Nguyễn Văn H','0244789465','','Lotte Center 141',3,'','',1472,'','','đường Lê Thị Riêng','','NOI_THAT','phường 0');
INSERT INTO building VALUES (78,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',3209,'','','','','QUAN_3','','Nguyễn Văn G','0346167439','','FLC Tower 117',7,'','',2161,'','','đường Hàm Nghi','','TANG_TRET','phường 5');
INSERT INTO building VALUES (79,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2771,'','','','','HUYEN_BINH_CHANH','','Nguyễn Văn B','0700783822','','FLC Tower 72',8,'','',184,'','','đường Hàm Nghi','','NGUYEN_CAN','phường 10');
INSERT INTO building VALUES (80,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4630,'','','','','QUAN_10','','Nguyễn Văn C','0454607490','','Vinfast 93',6,'','',893,'','','đường Võ Văn Kiệt','','TANG_TRET','phường 3');
INSERT INTO building VALUES (81,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',3339,'','','','','QUAN_PHU_NHUAN','','Nguyễn Văn E','0968118551','','Bitexco 25',2,'','',2040,'','','đường Hàm Nghi','','TANG_TRET','phường 5');
INSERT INTO building VALUES (82,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',538,'','','','','QUAN_TAN_BINH','','Nguyễn Văn H','0712145737','','Vinfast 9',7,'','',405,'','','đường Hàm Nghi','','TANG_TRET','phường 7');
INSERT INTO building VALUES (83,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',507,'','','','','QUAN_5','','Nguyễn Văn G','0472236658','','Sonadezi 40',2,'','',2336,'','','đường Lê Thị Riêng','','TANG_TRET','phường 4');
INSERT INTO building VALUES (84,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4567,'','','','','HUYEN_BINH_CHANH','','Nguyễn Văn H','0526854257','','Sonadezi 135',10,'','',1473,'','','đường Lê Thị Riêng','','NGUYEN_CAN','phường 0');
INSERT INTO building VALUES (85,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2555,'','','','','QUAN_GO_VAP','','Nguyễn Văn F','0314813685','','Vinfast 68',10,'','',1370,'','','đường Lê Lai','','NGUYEN_CAN','phường 8');
INSERT INTO building VALUES (86,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2315,'','','','','HUYEN_CU_CHI','','Nguyễn Văn E','0800736257','','Vinfast 184',10,'','',678,'','','đường Hàm Nghi','','NOI_THAT','phường 3');
INSERT INTO building VALUES (87,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2402,'','','','','QUAN_BINH_THANH','','Nguyễn Văn A','0632092204','','Sonadezi 110',5,'','',1124,'','','đường Nguyễn Trãi','','NOI_THAT','phường 0');
INSERT INTO building VALUES (88,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',3850,'','','','','QUAN_2','','Nguyễn Văn D','0105810866','','Lotte Center 77',8,'','',1371,'','','đường Hàm Nghi','','NOI_THAT','phường 5');
INSERT INTO building VALUES (89,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2439,'','','','','QUAN_4','','Nguyễn Văn E','0321814878','','FLC Tower 21',8,'','',281,'','','đường Lê Thị Riêng','','TANG_TRET','phường 9');
INSERT INTO building VALUES (90,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',1338,'','','','','QUAN_TAN_BINH','','Nguyễn Văn A','0644801466','','Vinfast 26',3,'','',1773,'','','đường Võ Văn Kiệt','','NOI_THAT','phường 0');
INSERT INTO building VALUES (91,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4020,'','','','','QUAN_11','','Nguyễn Văn B','0375424881','','Bitexco 110',10,'','',480,'','','đường Hàm Nghi','','NGUYEN_CAN','phường 0');
INSERT INTO building VALUES (92,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',2616,'','','','','HUYEN_CU_CHI','','Nguyễn Văn A','0867463505','','Sonadezi 69',6,'','',2489,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 2');
INSERT INTO building VALUES (93,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',703,'','','','','QUAN_8','','Nguyễn Văn D','0826205943','','Lotte Center 53',9,'','',2638,'','','đường Nguyễn Trãi','','NGUYEN_CAN','phường 10');
INSERT INTO building VALUES (94,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',4000,'','','','','QUAN_BINH_THANH','','Nguyễn Văn F','0179160092','','FLC Tower 29',2,'','',1027,'','','đường Phạm Ngũ Lão','','TANG_TRET','phường 0');
INSERT INTO building VALUES (95,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,'','','','','QUAN_7','','Nguyễn Văn G','0693170866','','Bitexco 156',9,'','',1892,'','','đường Hàm Nghi','','NOI_THAT','phường 2');
INSERT INTO building VALUES (96,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',2093,'','','','','QUAN_12','','Nguyễn Văn F','0871751399','','Sonadezi 133',1,'','',2538,'','','đường Lê Thị Riêng','','TANG_TRET','phường 10');
INSERT INTO building VALUES (97,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',3855,'','','','','HUYEN_CAN_GIO','','Nguyễn Văn H','0085258750','','Bitexco 191',2,'','',2045,'','','đường Lê Thị Riêng','','NGUYEN_CAN','phường 5');
INSERT INTO building VALUES (98,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',3447,'','','','','QUAN_TAN_BINH','','Nguyễn Văn E','0100189720','','Sonadezi 150',1,'','',1303,'','','đường Nguyễn Huệ','','NGUYEN_CAN','phường 9');
INSERT INTO building VALUES (99,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',1152,'','','','','HUYEN_CU_CHI','','Nguyễn Văn F','0415247395','','Lotte Center 129',6,'','',1498,'','','đường Nguyễn Trãi','','TANG_TRET','phường 2');
INSERT INTO building VALUES (100,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',1967,'','','','','QUAN_8','','Nguyễn Văn G','0564057377','','Lotte Center 195',9,'','',1358,'','','đường Phạm Ngũ Lão','','NOI_THAT','phường 0');
INSERT INTO building VALUES (101,'admin','2020-04-12 00:54:16','admin','2020-04-12 00:54:16',2349,'','','','','QUAN_3','','Hai','0987679361','','LandMark ABC',2,'','',8000,'','','đường CMT8','','NOI_THAT,TANG_TRET','phường 6');

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS customer;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE customer (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  company varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  demand varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  email varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  note varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  phone varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

INSERT INTO customer VALUES (1,'hai2','2020-04-12 00:18:33','hai2','2020-04-12 00:33:18','Vinfast','nhà rộng','nguyenvana481@gmail.com','Nguyễn Văn F','gấp','0197140979',NULL);
INSERT INTO customer VALUES (2,'hai2','2020-04-12 00:18:33','hai2','2020-04-12 00:18:33','','','nguyenvana696@gmail.com','Nguyễn Văn E','','0768177153',NULL);
INSERT INTO customer VALUES (3,'hai2','2020-04-12 00:18:33','hai2','2020-04-12 00:27:17','','','nguyenvanh670@gmail.com','Nguyễn Văn C','','0730736768',NULL);
INSERT INTO customer VALUES (5,'hai2','2020-04-12 00:18:33','hai2','2020-04-12 00:18:33','','','nguyenvanf222@gmail.com','Nguyễn Văn E','','0152220260',NULL);
INSERT INTO customer VALUES (7,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvana591@gmail.com','Nguyễn Văn D','','0311293036',NULL);
INSERT INTO customer VALUES (8,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvane958@gmail.com','Nguyễn Văn A','','0180747016',NULL);
INSERT INTO customer VALUES (10,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanf918@gmail.com','Nguyễn Văn H','','0863992758',NULL);
INSERT INTO customer VALUES (11,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvana920@gmail.com','Nguyễn Văn H','','0903200863',NULL);
INSERT INTO customer VALUES (12,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanc205@gmail.com','Nguyễn Văn H','','0085547654',NULL);
INSERT INTO customer VALUES (13,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanb036@gmail.com','Nguyễn Văn H','','0983555428',NULL);
INSERT INTO customer VALUES (14,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanc076@gmail.com','Nguyễn Văn F','','0052868747',NULL);
INSERT INTO customer VALUES (15,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvang100@gmail.com','Nguyễn Văn G','','0090661807',NULL);
INSERT INTO customer VALUES (16,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanc641@gmail.com','Nguyễn Văn B','','0234397815',NULL);
INSERT INTO customer VALUES (17,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvana027@gmail.com','Nguyễn Văn D','','0096120938',NULL);
INSERT INTO customer VALUES (18,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanf762@gmail.com','Nguyễn Văn E','','0931770117',NULL);
INSERT INTO customer VALUES (19,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvane538@gmail.com','Nguyễn Văn D','','0873189625',NULL);
INSERT INTO customer VALUES (20,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvand113@gmail.com','Nguyễn Văn F','','0242869735',NULL);
INSERT INTO customer VALUES (21,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanc529@gmail.com','Nguyễn Văn C','','0233337842',NULL);
INSERT INTO customer VALUES (22,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvand897@gmail.com','Nguyễn Văn E','','0772389170',NULL);
INSERT INTO customer VALUES (23,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanc965@gmail.com','Nguyễn Văn D','','0379338916',NULL);
INSERT INTO customer VALUES (24,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvane916@gmail.com','Nguyễn Văn D','','0916419670',NULL);
INSERT INTO customer VALUES (25,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanb227@gmail.com','Nguyễn Văn F','','0615763668',NULL);
INSERT INTO customer VALUES (26,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvang629@gmail.com','Nguyễn Văn H','','0885748925',NULL);
INSERT INTO customer VALUES (27,'hai2','2020-04-12 00:18:34','hai2','2020-04-12 00:18:34','','','nguyenvanb603@gmail.com','Nguyễn Văn F','','0036553381',NULL);
INSERT INTO customer VALUES (28,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh871@gmail.com','Nguyễn Văn C','','0567272451',NULL);
INSERT INTO customer VALUES (29,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvand369@gmail.com','Nguyễn Văn A','','0191789327',NULL);
INSERT INTO customer VALUES (30,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvand317@gmail.com','Nguyễn Văn E','','0374728699',NULL);
INSERT INTO customer VALUES (31,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf686@gmail.com','Nguyễn Văn A','','0867282390',NULL);
INSERT INTO customer VALUES (32,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanc074@gmail.com','Nguyễn Văn E','','0369097640',NULL);
INSERT INTO customer VALUES (33,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvane128@gmail.com','Nguyễn Văn H','','0842183732',NULL);
INSERT INTO customer VALUES (34,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh881@gmail.com','Nguyễn Văn F','','0630858226',NULL);
INSERT INTO customer VALUES (35,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvang583@gmail.com','Nguyễn Văn E','','0741495284',NULL);
INSERT INTO customer VALUES (36,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanc867@gmail.com','Nguyễn Văn G','','0294125827',NULL);
INSERT INTO customer VALUES (37,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanb670@gmail.com','Nguyễn Văn D','','0679701801',NULL);
INSERT INTO customer VALUES (38,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh778@gmail.com','Nguyễn Văn C','','0220899236',NULL);
INSERT INTO customer VALUES (39,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh633@gmail.com','Nguyễn Văn F','','0829585826',NULL);
INSERT INTO customer VALUES (40,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvane563@gmail.com','Nguyễn Văn A','','0548451066',NULL);
INSERT INTO customer VALUES (41,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanb692@gmail.com','Nguyễn Văn B','','0284725525',NULL);
INSERT INTO customer VALUES (42,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvane348@gmail.com','Nguyễn Văn B','','0579715203',NULL);
INSERT INTO customer VALUES (43,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanb302@gmail.com','Nguyễn Văn D','','0586972203',NULL);
INSERT INTO customer VALUES (44,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf041@gmail.com','Nguyễn Văn B','','0156560548',NULL);
INSERT INTO customer VALUES (45,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvane964@gmail.com','Nguyễn Văn B','','0958260718',NULL);
INSERT INTO customer VALUES (46,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf527@gmail.com','Nguyễn Văn E','','0255890413',NULL);
INSERT INTO customer VALUES (47,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvand019@gmail.com','Nguyễn Văn D','','0908761424',NULL);
INSERT INTO customer VALUES (48,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf660@gmail.com','Nguyễn Văn E','','0459125940',NULL);
INSERT INTO customer VALUES (49,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvand215@gmail.com','Nguyễn Văn F','','0191367844',NULL);
INSERT INTO customer VALUES (50,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvana065@gmail.com','Nguyễn Văn C','','0682217414',NULL);
INSERT INTO customer VALUES (51,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvang466@gmail.com','Nguyễn Văn F','','0412723893',NULL);
INSERT INTO customer VALUES (52,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanc805@gmail.com','Nguyễn Văn C','','0224131347',NULL);
INSERT INTO customer VALUES (53,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf230@gmail.com','Nguyễn Văn F','','0223235361',NULL);
INSERT INTO customer VALUES (54,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanc269@gmail.com','Nguyễn Văn A','','0936796507',NULL);
INSERT INTO customer VALUES (55,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh940@gmail.com','Nguyễn Văn B','','0772617843',NULL);
INSERT INTO customer VALUES (56,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanh015@gmail.com','Nguyễn Văn C','','0983580785',NULL);
INSERT INTO customer VALUES (57,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvanf799@gmail.com','Nguyễn Văn C','','0289403259',NULL);
INSERT INTO customer VALUES (58,'hai2','2020-04-12 00:18:35','hai2','2020-04-12 00:18:35','','','nguyenvand281@gmail.com','Nguyễn Văn A','','0829024611',NULL);
INSERT INTO customer VALUES (59,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh690@gmail.com','Nguyễn Văn G','','0162715981',NULL);
INSERT INTO customer VALUES (60,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvand160@gmail.com','Nguyễn Văn D','','0805076865',NULL);
INSERT INTO customer VALUES (61,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvang199@gmail.com','Nguyễn Văn G','','0005418354',NULL);
INSERT INTO customer VALUES (62,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanf822@gmail.com','Nguyễn Văn D','','0471830116',NULL);
INSERT INTO customer VALUES (63,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvane537@gmail.com','Nguyễn Văn E','','0969110077',NULL);
INSERT INTO customer VALUES (64,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanf948@gmail.com','Nguyễn Văn E','','0885301962',NULL);
INSERT INTO customer VALUES (65,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanb283@gmail.com','Nguyễn Văn A','','0505463086',NULL);
INSERT INTO customer VALUES (66,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanb238@gmail.com','Nguyễn Văn G','','0631890894',NULL);
INSERT INTO customer VALUES (67,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh255@gmail.com','Nguyễn Văn C','','0121121651',NULL);
INSERT INTO customer VALUES (68,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanb141@gmail.com','Nguyễn Văn H','','0173151543',NULL);
INSERT INTO customer VALUES (69,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvana575@gmail.com','Nguyễn Văn B','','0141315130',NULL);
INSERT INTO customer VALUES (70,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvana264@gmail.com','Nguyễn Văn G','','0476310835',NULL);
INSERT INTO customer VALUES (71,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanf696@gmail.com','Nguyễn Văn E','','0110715139',NULL);
INSERT INTO customer VALUES (72,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanf112@gmail.com','Nguyễn Văn F','','0055288934',NULL);
INSERT INTO customer VALUES (73,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvana185@gmail.com','Nguyễn Văn A','','0094284509',NULL);
INSERT INTO customer VALUES (74,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvand942@gmail.com','Nguyễn Văn H','','0066626568',NULL);
INSERT INTO customer VALUES (75,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvang725@gmail.com','Nguyễn Văn C','','0222557779',NULL);
INSERT INTO customer VALUES (76,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanb392@gmail.com','Nguyễn Văn C','','0782151544',NULL);
INSERT INTO customer VALUES (77,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh558@gmail.com','Nguyễn Văn H','','0607190965',NULL);
INSERT INTO customer VALUES (78,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvang785@gmail.com','Nguyễn Văn D','','0467940491',NULL);
INSERT INTO customer VALUES (79,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvand503@gmail.com','Nguyễn Văn F','','0372221341',NULL);
INSERT INTO customer VALUES (80,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanb051@gmail.com','Nguyễn Văn H','','0253183113',NULL);
INSERT INTO customer VALUES (81,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh682@gmail.com','Nguyễn Văn B','','0155898583',NULL);
INSERT INTO customer VALUES (82,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanf308@gmail.com','Nguyễn Văn F','','0942548879',NULL);
INSERT INTO customer VALUES (83,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh593@gmail.com','Nguyễn Văn G','','0386991038',NULL);
INSERT INTO customer VALUES (84,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh150@gmail.com','Nguyễn Văn C','','0012039939',NULL);
INSERT INTO customer VALUES (85,'hai2','2020-04-12 00:18:36','hai2','2020-04-12 00:18:36','','','nguyenvanh216@gmail.com','Nguyễn Văn D','','0420200829',NULL);
INSERT INTO customer VALUES (86,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvanh143@gmail.com','Nguyễn Văn C','','0375659265',NULL);
INSERT INTO customer VALUES (87,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvang804@gmail.com','Nguyễn Văn E','','0949535485',NULL);
INSERT INTO customer VALUES (88,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvane460@gmail.com','Nguyễn Văn A','','0261934279',NULL);
INSERT INTO customer VALUES (89,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvand715@gmail.com','Nguyễn Văn E','','0340186331',NULL);
INSERT INTO customer VALUES (90,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvanc220@gmail.com','Nguyễn Văn B','','0800002005',NULL);
INSERT INTO customer VALUES (91,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvane991@gmail.com','Nguyễn Văn H','','0646981975',NULL);
INSERT INTO customer VALUES (92,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvang129@gmail.com','Nguyễn Văn F','','0336452329',NULL);
INSERT INTO customer VALUES (93,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvand539@gmail.com','Nguyễn Văn C','','0558114799',NULL);
INSERT INTO customer VALUES (94,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvanh292@gmail.com','Nguyễn Văn D','','0823323323',NULL);
INSERT INTO customer VALUES (95,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvanb340@gmail.com','Nguyễn Văn H','','0772167935',NULL);
INSERT INTO customer VALUES (96,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvang477@gmail.com','Nguyễn Văn C','','0600382819',NULL);
INSERT INTO customer VALUES (97,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvane299@gmail.com','Nguyễn Văn H','','0870536179',NULL);
INSERT INTO customer VALUES (98,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvanf852@gmail.com','Nguyễn Văn A','','0312258884',NULL);
INSERT INTO customer VALUES (99,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvana971@gmail.com','Nguyễn Văn C','','0324786959',NULL);
INSERT INTO customer VALUES (100,'hai2','2020-04-12 00:18:37','hai2','2020-04-12 00:18:37','','','nguyenvand368@gmail.com','Nguyễn Văn G','','0924356260',NULL);
INSERT INTO customer VALUES (101,'admin','2020-04-12 00:56:46','admin','2020-04-12 00:56:46','','','nguyenvank324@gmail.com','Nguyễn Văn K','','0985741239',NULL);

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS rentarea;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE rentarea (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  buildingid bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKqhqoxlvm1iblaew5s0v8n3ut4 (buildingid),
  CONSTRAINT FKqhqoxlvm1iblaew5s0v8n3ut4 FOREIGN KEY (buildingid) REFERENCES building (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

INSERT INTO rentarea VALUES (7,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,4);
INSERT INTO rentarea VALUES (8,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',900,4);
INSERT INTO rentarea VALUES (11,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',300,6);
INSERT INTO rentarea VALUES (12,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',500,6);
INSERT INTO rentarea VALUES (13,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',700,7);
INSERT INTO rentarea VALUES (14,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',800,7);
INSERT INTO rentarea VALUES (15,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',400,8);
INSERT INTO rentarea VALUES (16,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,8);
INSERT INTO rentarea VALUES (17,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',300,9);
INSERT INTO rentarea VALUES (18,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',400,9);
INSERT INTO rentarea VALUES (19,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',800,10);
INSERT INTO rentarea VALUES (20,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',400,10);
INSERT INTO rentarea VALUES (21,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,11);
INSERT INTO rentarea VALUES (22,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',300,11);
INSERT INTO rentarea VALUES (23,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,12);
INSERT INTO rentarea VALUES (24,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',900,12);
INSERT INTO rentarea VALUES (25,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',900,13);
INSERT INTO rentarea VALUES (26,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',500,13);
INSERT INTO rentarea VALUES (27,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',900,14);
INSERT INTO rentarea VALUES (28,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',500,14);
INSERT INTO rentarea VALUES (29,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',700,15);
INSERT INTO rentarea VALUES (30,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',300,15);
INSERT INTO rentarea VALUES (31,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',100,16);
INSERT INTO rentarea VALUES (32,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',500,16);
INSERT INTO rentarea VALUES (33,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',100,17);
INSERT INTO rentarea VALUES (34,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',400,17);
INSERT INTO rentarea VALUES (35,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,18);
INSERT INTO rentarea VALUES (36,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',400,18);
INSERT INTO rentarea VALUES (37,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',1000,19);
INSERT INTO rentarea VALUES (38,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',300,19);
INSERT INTO rentarea VALUES (39,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',1000,20);
INSERT INTO rentarea VALUES (40,'hai2','2020-04-11 23:36:23','hai2','2020-04-11 23:36:23',600,20);
INSERT INTO rentarea VALUES (41,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',800,21);
INSERT INTO rentarea VALUES (42,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,21);
INSERT INTO rentarea VALUES (43,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',200,22);
INSERT INTO rentarea VALUES (44,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',300,22);
INSERT INTO rentarea VALUES (45,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,23);
INSERT INTO rentarea VALUES (46,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',900,23);
INSERT INTO rentarea VALUES (47,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,24);
INSERT INTO rentarea VALUES (48,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,24);
INSERT INTO rentarea VALUES (49,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,25);
INSERT INTO rentarea VALUES (50,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,25);
INSERT INTO rentarea VALUES (51,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,26);
INSERT INTO rentarea VALUES (52,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,26);
INSERT INTO rentarea VALUES (53,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,27);
INSERT INTO rentarea VALUES (54,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,27);
INSERT INTO rentarea VALUES (55,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',200,28);
INSERT INTO rentarea VALUES (56,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',400,28);
INSERT INTO rentarea VALUES (57,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,29);
INSERT INTO rentarea VALUES (58,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,29);
INSERT INTO rentarea VALUES (59,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',700,30);
INSERT INTO rentarea VALUES (60,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',200,30);
INSERT INTO rentarea VALUES (61,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',800,31);
INSERT INTO rentarea VALUES (62,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',1000,31);
INSERT INTO rentarea VALUES (63,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',700,32);
INSERT INTO rentarea VALUES (64,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,32);
INSERT INTO rentarea VALUES (65,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,33);
INSERT INTO rentarea VALUES (66,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',300,33);
INSERT INTO rentarea VALUES (67,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,34);
INSERT INTO rentarea VALUES (68,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,34);
INSERT INTO rentarea VALUES (69,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,35);
INSERT INTO rentarea VALUES (70,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,35);
INSERT INTO rentarea VALUES (71,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',800,36);
INSERT INTO rentarea VALUES (72,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',100,36);
INSERT INTO rentarea VALUES (73,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',200,37);
INSERT INTO rentarea VALUES (74,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,37);
INSERT INTO rentarea VALUES (75,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',600,38);
INSERT INTO rentarea VALUES (76,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',700,38);
INSERT INTO rentarea VALUES (77,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',500,39);
INSERT INTO rentarea VALUES (78,'hai2','2020-04-11 23:36:24','hai2','2020-04-11 23:36:24',700,39);
INSERT INTO rentarea VALUES (79,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,40);
INSERT INTO rentarea VALUES (80,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,40);
INSERT INTO rentarea VALUES (81,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',700,41);
INSERT INTO rentarea VALUES (82,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1000,41);
INSERT INTO rentarea VALUES (83,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',400,42);
INSERT INTO rentarea VALUES (84,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,42);
INSERT INTO rentarea VALUES (85,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1000,43);
INSERT INTO rentarea VALUES (86,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',800,43);
INSERT INTO rentarea VALUES (87,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',600,44);
INSERT INTO rentarea VALUES (88,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,44);
INSERT INTO rentarea VALUES (89,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',200,45);
INSERT INTO rentarea VALUES (90,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,45);
INSERT INTO rentarea VALUES (91,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,46);
INSERT INTO rentarea VALUES (92,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',200,46);
INSERT INTO rentarea VALUES (93,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,47);
INSERT INTO rentarea VALUES (94,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,47);
INSERT INTO rentarea VALUES (95,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,48);
INSERT INTO rentarea VALUES (96,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',800,48);
INSERT INTO rentarea VALUES (97,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,49);
INSERT INTO rentarea VALUES (98,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',400,49);
INSERT INTO rentarea VALUES (99,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',200,50);
INSERT INTO rentarea VALUES (100,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,50);
INSERT INTO rentarea VALUES (101,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,51);
INSERT INTO rentarea VALUES (102,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',600,51);
INSERT INTO rentarea VALUES (103,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',600,52);
INSERT INTO rentarea VALUES (104,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',400,52);
INSERT INTO rentarea VALUES (105,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,53);
INSERT INTO rentarea VALUES (106,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,53);
INSERT INTO rentarea VALUES (107,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,54);
INSERT INTO rentarea VALUES (108,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,54);
INSERT INTO rentarea VALUES (109,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,55);
INSERT INTO rentarea VALUES (110,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,55);
INSERT INTO rentarea VALUES (111,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',800,56);
INSERT INTO rentarea VALUES (112,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',200,56);
INSERT INTO rentarea VALUES (113,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,57);
INSERT INTO rentarea VALUES (114,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',200,57);
INSERT INTO rentarea VALUES (115,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,58);
INSERT INTO rentarea VALUES (116,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1000,58);
INSERT INTO rentarea VALUES (117,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,59);
INSERT INTO rentarea VALUES (118,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1000,59);
INSERT INTO rentarea VALUES (119,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,60);
INSERT INTO rentarea VALUES (120,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',600,60);
INSERT INTO rentarea VALUES (121,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,61);
INSERT INTO rentarea VALUES (122,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,61);
INSERT INTO rentarea VALUES (123,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,62);
INSERT INTO rentarea VALUES (124,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',700,62);
INSERT INTO rentarea VALUES (125,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',400,63);
INSERT INTO rentarea VALUES (126,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,63);
INSERT INTO rentarea VALUES (127,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',900,64);
INSERT INTO rentarea VALUES (128,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',300,64);
INSERT INTO rentarea VALUES (129,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,65);
INSERT INTO rentarea VALUES (130,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',1000,65);
INSERT INTO rentarea VALUES (131,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',500,66);
INSERT INTO rentarea VALUES (132,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,66);
INSERT INTO rentarea VALUES (133,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',100,67);
INSERT INTO rentarea VALUES (134,'hai2','2020-04-11 23:36:25','hai2','2020-04-11 23:36:25',800,67);
INSERT INTO rentarea VALUES (135,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,68);
INSERT INTO rentarea VALUES (136,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',100,68);
INSERT INTO rentarea VALUES (137,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,69);
INSERT INTO rentarea VALUES (138,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,69);
INSERT INTO rentarea VALUES (139,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,70);
INSERT INTO rentarea VALUES (140,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,70);
INSERT INTO rentarea VALUES (141,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,71);
INSERT INTO rentarea VALUES (142,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,71);
INSERT INTO rentarea VALUES (143,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,72);
INSERT INTO rentarea VALUES (144,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',600,72);
INSERT INTO rentarea VALUES (145,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',600,73);
INSERT INTO rentarea VALUES (146,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,73);
INSERT INTO rentarea VALUES (147,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',100,74);
INSERT INTO rentarea VALUES (148,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',600,74);
INSERT INTO rentarea VALUES (149,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',100,75);
INSERT INTO rentarea VALUES (150,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,75);
INSERT INTO rentarea VALUES (151,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,76);
INSERT INTO rentarea VALUES (152,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',1000,76);
INSERT INTO rentarea VALUES (153,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',600,77);
INSERT INTO rentarea VALUES (154,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,77);
INSERT INTO rentarea VALUES (155,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,78);
INSERT INTO rentarea VALUES (156,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,78);
INSERT INTO rentarea VALUES (157,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,79);
INSERT INTO rentarea VALUES (158,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,79);
INSERT INTO rentarea VALUES (159,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,80);
INSERT INTO rentarea VALUES (160,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,80);
INSERT INTO rentarea VALUES (161,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,81);
INSERT INTO rentarea VALUES (162,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,81);
INSERT INTO rentarea VALUES (163,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,82);
INSERT INTO rentarea VALUES (164,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,82);
INSERT INTO rentarea VALUES (165,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,83);
INSERT INTO rentarea VALUES (166,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,83);
INSERT INTO rentarea VALUES (167,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',1000,84);
INSERT INTO rentarea VALUES (168,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,84);
INSERT INTO rentarea VALUES (169,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,85);
INSERT INTO rentarea VALUES (170,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,85);
INSERT INTO rentarea VALUES (171,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',200,86);
INSERT INTO rentarea VALUES (172,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,86);
INSERT INTO rentarea VALUES (173,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,87);
INSERT INTO rentarea VALUES (174,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,87);
INSERT INTO rentarea VALUES (175,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,88);
INSERT INTO rentarea VALUES (176,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',200,88);
INSERT INTO rentarea VALUES (177,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',1000,89);
INSERT INTO rentarea VALUES (178,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',200,89);
INSERT INTO rentarea VALUES (179,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',900,90);
INSERT INTO rentarea VALUES (180,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,90);
INSERT INTO rentarea VALUES (181,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,91);
INSERT INTO rentarea VALUES (182,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,91);
INSERT INTO rentarea VALUES (183,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',400,92);
INSERT INTO rentarea VALUES (184,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',800,92);
INSERT INTO rentarea VALUES (185,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,93);
INSERT INTO rentarea VALUES (186,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',600,93);
INSERT INTO rentarea VALUES (187,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,94);
INSERT INTO rentarea VALUES (188,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',300,94);
INSERT INTO rentarea VALUES (189,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',700,95);
INSERT INTO rentarea VALUES (190,'hai2','2020-04-11 23:36:26','hai2','2020-04-11 23:36:26',500,95);
INSERT INTO rentarea VALUES (191,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',800,96);
INSERT INTO rentarea VALUES (192,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',200,96);
INSERT INTO rentarea VALUES (193,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',800,97);
INSERT INTO rentarea VALUES (194,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',600,97);
INSERT INTO rentarea VALUES (195,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',200,98);
INSERT INTO rentarea VALUES (196,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',900,98);
INSERT INTO rentarea VALUES (197,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',800,99);
INSERT INTO rentarea VALUES (198,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',700,99);
INSERT INTO rentarea VALUES (199,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',700,100);
INSERT INTO rentarea VALUES (200,'hai2','2020-04-11 23:36:27','hai2','2020-04-11 23:36:27',1000,100);
INSERT INTO rentarea VALUES (206,'cth11','2020-04-12 00:26:28','cth11','2020-04-12 00:26:28',900,3);
INSERT INTO rentarea VALUES (207,'cth11','2020-04-12 00:26:28','cth11','2020-04-12 00:26:28',100,3);
INSERT INTO rentarea VALUES (208,'cth12','2020-04-12 00:36:58','cth12','2020-04-12 00:36:58',500,5);
INSERT INTO rentarea VALUES (209,'cth12','2020-04-12 00:36:58','cth12','2020-04-12 00:36:58',500,5);
INSERT INTO rentarea VALUES (210,'ADMIN','2020-04-12 00:54:16','ADMIN','2020-04-12 00:54:16',123,101);
INSERT INTO rentarea VALUES (211,'ADMIN','2020-04-12 00:54:16','ADMIN','2020-04-12 00:54:16',456,101);
INSERT INTO rentarea VALUES (212,'ADMIN','2020-04-12 00:54:16','ADMIN','2020-04-12 00:54:16',789,101);

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE role (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  description varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

INSERT INTO role VALUES (1,NULL,NULL,NULL,NULL,'Nhân viên',0);
INSERT INTO role VALUES (2,NULL,NULL,NULL,NULL,'Quản lý',1);

--
-- Table structure for table `staff_customer`
--

DROP TABLE IF EXISTS staff_customer;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE staff_customer (
  customerid bigint(20) NOT NULL,
  staffid bigint(20) NOT NULL,
  PRIMARY KEY (customerid,staffid),
  KEY FK6trfheqsgh84hle7imt46o0i0 (staffid),
  CONSTRAINT FK6trfheqsgh84hle7imt46o0i0 FOREIGN KEY (staffid) REFERENCES `user` (id),
  CONSTRAINT FKlqvgs2k1a4mmdc5wv4jsr6lmv FOREIGN KEY (customerid) REFERENCES customer (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_customer`
--

INSERT INTO staff_customer VALUES (1,2);
INSERT INTO staff_customer VALUES (3,2);
INSERT INTO staff_customer VALUES (1,4);

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS transaction;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  note varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  customerid bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKldobv9jeuxje0fjqnhrw6e23v (customerid),
  CONSTRAINT FKldobv9jeuxje0fjqnhrw6e23v FOREIGN KEY (customerid) REFERENCES customer (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

INSERT INTO transaction VALUES (1,'cth11','2020-04-12 00:29:13','cth11','2020-04-12 00:29:13','ghi chú 1',0,1);
INSERT INTO transaction VALUES (2,'cth11','2020-04-12 00:29:21','cth11','2020-04-12 00:29:21','ghi chú 2',0,1);
INSERT INTO transaction VALUES (3,'cth11','2020-04-12 00:29:28','cth11','2020-04-12 00:29:28','ghi chú 3',0,1);
INSERT INTO transaction VALUES (4,'cth11','2020-04-12 00:29:36','cth11','2020-04-12 00:29:36','ghi chú 4',0,1);
INSERT INTO transaction VALUES (5,'cth11','2020-04-12 00:29:43','cth11','2020-04-12 00:29:43','ghi chú 5',0,1);
INSERT INTO transaction VALUES (6,'cth11','2020-04-12 00:29:53','cth11','2020-04-12 00:29:53','ghi chú 6',0,1);
INSERT INTO transaction VALUES (7,'cth11','2020-04-12 00:30:00','cth11','2020-04-12 00:30:00','ghi chú 7',0,1);
INSERT INTO transaction VALUES (8,'cth11','2020-04-12 00:30:06','cth11','2020-04-12 00:30:06','ghi chú 8',0,1);
INSERT INTO transaction VALUES (9,'cth11','2020-04-12 00:30:12','cth11','2020-04-12 00:30:12','ghi chú 9',0,1);
INSERT INTO transaction VALUES (10,'cth11','2020-04-12 00:30:20','cth11','2020-04-12 00:30:20','ghi chú 10',0,1);
INSERT INTO transaction VALUES (11,'cth11','2020-04-12 00:30:27','cth11','2020-04-12 00:30:27','ghi chú 11',0,1);
INSERT INTO transaction VALUES (12,'cth11','2020-04-12 00:30:33','cth11','2020-04-12 00:30:33','ghi chú 12',0,1);
INSERT INTO transaction VALUES (13,'cth11','2020-04-12 00:30:40','cth11','2020-04-12 00:30:40','ghi chú 13',0,1);
INSERT INTO transaction VALUES (14,'cth11','2020-04-12 00:30:46','cth11','2020-04-12 00:30:46','ghi chú 14',0,1);
INSERT INTO transaction VALUES (15,'cth11','2020-04-12 00:30:53','cth11','2020-04-12 00:30:53','ghi chú 15',0,1);
INSERT INTO transaction VALUES (16,'cth11','2020-04-12 00:31:01','cth11','2020-04-12 00:31:01','ghi chú 16',0,1);
INSERT INTO transaction VALUES (17,'cth11','2020-04-12 00:31:08','cth11','2020-04-12 00:31:08','ghi chú 17',0,1);
INSERT INTO transaction VALUES (18,'cth11','2020-04-12 00:31:14','cth11','2020-04-12 00:31:14','ghi chú 18',0,1);
INSERT INTO transaction VALUES (19,'cth11','2020-04-12 00:31:20','cth11','2020-04-12 00:31:20','ghi chú 19',0,1);
INSERT INTO transaction VALUES (20,'cth11','2020-04-12 00:31:25','cth11','2020-04-12 00:31:25','ghi chú 20',0,1);
INSERT INTO transaction VALUES (21,'cth11','2020-04-12 00:31:31','cth11','2020-04-12 00:31:31','ghi chú 21',0,1);
INSERT INTO transaction VALUES (22,'cth11','2020-04-12 00:31:37','cth11','2020-04-12 00:31:37','ghi chú 22',0,1);
INSERT INTO transaction VALUES (23,'cth11','2020-04-12 00:31:43','cth11','2020-04-12 00:31:43','ghi chú 23',0,1);
INSERT INTO transaction VALUES (24,'cth11','2020-04-12 00:31:50','cth11','2020-04-12 00:31:50','ghi chú 24',0,1);
INSERT INTO transaction VALUES (25,'cth12','2020-04-12 00:34:14','cth12','2020-04-12 00:34:14','ghi chú 25',0,1);
INSERT INTO transaction VALUES (26,'cth12','2020-04-12 00:34:23','cth12','2020-04-12 00:34:23','ghi chú 26',0,1);
INSERT INTO transaction VALUES (27,'cth12','2020-04-12 00:34:29','cth12','2020-04-12 00:34:29','ghi chú 27',0,1);
INSERT INTO transaction VALUES (28,'cth12','2020-04-12 00:34:36','cth12','2020-04-12 00:34:36','ghi chú 28',0,1);
INSERT INTO transaction VALUES (29,'cth12','2020-04-12 00:34:43','cth12','2020-04-12 00:34:43','ghi chú 29',0,1);
INSERT INTO transaction VALUES (30,'cth12','2020-04-12 00:34:52','cth12','2020-04-12 00:34:52','ghi chú 30',0,1);
INSERT INTO transaction VALUES (31,'admin','2020-04-12 01:03:41','admin','2020-04-12 01:03:41','ghi chú 31',0,1);

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  id bigint(20) NOT NULL,
  createdby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createddate datetime DEFAULT NULL,
  modifiedby varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  modifieddate datetime DEFAULT NULL,
  avatar varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  fullname varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  phone varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  username varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO user VALUES (1,'Hai','2020-04-03 21:13:37','hai2','2020-04-11 23:56:51','http://res.cloudinary.com/dc4rxxjyt/image/upload/v1586624210/xhuc89ye1zkevydcipza.jpg','Cao Thanh Hai','$2y$12$uB8Zi6z0/V2Npiz0SETaCODKKkNtdwMh78xW3U2r/9CnbgexS5fz2','0987584102',1,'hai2');
INSERT INTO user VALUES (2,'hai2','2020-04-12 00:23:48','cth11','2020-04-12 00:25:56','http://res.cloudinary.com/dc4rxxjyt/image/upload/v1586625955/ytyl7lkr1rrmrmbtry0p.jpg','Cao Thanh Hai 2','$2a$10$937eCUQrvKHRAlX3LWp9J.jcr.Y3DKH8k9AOGd6scqs5UhNRUWUsi','0987678987',1,'cth11');
INSERT INTO user VALUES (3,'hai2','2020-04-12 00:28:28','hai2','2020-04-12 00:28:28',NULL,'Admin','$2a$10$8wHxkf4CNwbHR62s/.DE8O8zLy3ac4g20y3O9qp0G22twSIlZSc.K','0987765482',1,'admin');
INSERT INTO user VALUES (4,'hai2','2020-04-12 00:32:49','hai2','2020-04-12 00:32:49',NULL,'Cao Thanh Hai 3','$2a$10$PbH00YTOPId1edZnASbHYObAl1DepGeCAdkYSodOeX9Z32Y3s6Y52','0987765390',1,'cth12');

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS user_role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY FKa68196081fvovjhkek5m97n3y (role_id),
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES `user` (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

INSERT INTO user_role VALUES (2,1);
INSERT INTO user_role VALUES (4,1);
INSERT INTO user_role VALUES (1,2);
INSERT INTO user_role VALUES (3,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
