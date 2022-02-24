-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: insurance
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `id` int NOT NULL,
  `name` varchar(150) NOT NULL,
  `location` varchar(150) NOT NULL,
  `phone` varchar(150) NOT NULL,
  `state` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Oddzial1','Kielce','987654310','Polska'),(2,'Oddzial2','Warszawa','12345','Polska'),(3,'Oddzial3','Berlin','18723687123','Niemcy');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_policy`
--

DROP TABLE IF EXISTS `customer_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_policy` (
  `id` int NOT NULL,
  `cupid` varchar(150) NOT NULL,
  `cid` varchar(150) NOT NULL,
  `pid` varchar(150) NOT NULL,
  `ptype` varchar(150) NOT NULL,
  `aid` varchar(150) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `rela` varchar(150) NOT NULL,
  `pamt` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_policy`
--

LOCK TABLES `customer_policy` WRITE;
/*!40000 ALTER TABLE `customer_policy` DISABLE KEYS */;
INSERT INTO `customer_policy` VALUES (7,'5001','4001','1001','Tygodniowy','3002','VVV','BBBB','50000.0'),(8,'5002','4003','1001','Roczny','3002','VVV','BBBB','50000.0'),(9,'5003','4003','1001','Roczny','3002','VVV','BBBB','50000.0'),(10,'5004','4003','1002','Roczny','3002','VVV','BBBB','50000.0'),(11,'5005','4001','1004','Miesieczny','3003','VVV','BBBB','50000.0');
/*!40000 ALTER TABLE `customer_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy` (
  `id` int NOT NULL,
  `pid` varchar(150) NOT NULL,
  `pname` varchar(150) NOT NULL,
  `pterm` int NOT NULL,
  `pamt` int NOT NULL,
  `pfamt` int NOT NULL,
  `pint` int NOT NULL,
  `pbper` int NOT NULL,
  `prat` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (3,'1001','Ubezpieczenie domu',24,10000,11000,2,12,2),(4,'1002','Ubezpieczenie podrózy',12,1800000,20000,10,6,2),(5,'1003','Ubezpieczenie samochodowe',24,25000,30000,2,12,2),(6,'1004','Ubezpieczenie firmowe',12,18000,2000,1,3,1),(7,'1005','Ubezpieczenie zdrowotne',12,15000,20000,2,12,2);
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_details`
--

DROP TABLE IF EXISTS `policy_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy_details` (
  `id` int NOT NULL,
  `cid` varchar(150) NOT NULL,
  `paamt` varchar(150) NOT NULL,
  `pid` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_details`
--

LOCK TABLES `policy_details` WRITE;
/*!40000 ALTER TABLE `policy_details` DISABLE KEYS */;
INSERT INTO `policy_details` VALUES (1,'4001','31000.0','5001'),(2,'4001','10500.0','5002'),(3,'4001','2000.0','5003'),(4,'4001','2000.0','5003'),(5,'4001','10500.0','5002'),(6,'4001','10500.0','5002');
/*!40000 ALTER TABLE `policy_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Tabela `user_admin`
--

DROP TABLE IF EXISTS `user_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_admin` (
  `id` int NOT NULL,
  `aid` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(150) NOT NULL,
  `address` varchar(150) NOT NULL,
  `contact` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Tabela `user_admin`
--

LOCK TABLES `user_admin` WRITE;
/*!40000 ALTER TABLE `user_admin` DISABLE KEYS */;
INSERT INTO `user_admin` VALUES (1,'101','Albert','admin',25,'Male','Daleszyce','600121412');
/*!40000 ALTER TABLE `user_admin` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_SAFE_UPDATES = 0;

UPDATE user_admin
SET password = '1000:81469e6bc9c83b6c7d83a0678a06a522:de7bfa50e973beca4127d5933b2422bed59a845f3c8bb059bfb7c20bf014f2355d1ace8d99d3e452fca5cfe64a64249ec7e6abb768fe0b51edb5d72db0c86e92'
WHERE id = 1;

--
-- Tabela `user_agent`
--

DROP TABLE IF EXISTS `user_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_agent` (
  `id` int NOT NULL,
  `aid` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `fname` varchar(150) NOT NULL,
  `aage` varchar(150) NOT NULL,
  `gen` varchar(150) NOT NULL,
  `qua` varchar(150) NOT NULL,
  `occu` varchar(150) NOT NULL,
  `aadd` varchar(150) NOT NULL,
  `sec` varchar(150) NOT NULL,
  `mname` int NOT NULL,
  `pass` varchar(150) NOT NULL,
  `phno` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Tabela `user_agent`
--

LOCK TABLES `user_agent` WRITE;
/*!40000 ALTER TABLE `user_agent` DISABLE KEYS */;

/*!40000 ALTER TABLE `user_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Tabela `user_customer`
--

DROP TABLE IF EXISTS `user_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_customer` (
  `id` int NOT NULL,
  `cid` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `fname` varchar(150) NOT NULL,
  `age` varchar(150) NOT NULL,
  `gen` varchar(150) NOT NULL,
  `qua` varchar(150) NOT NULL,
  `cadd` varchar(150) NOT NULL,
  `occ` varchar(150) NOT NULL,
  `pass` varchar(150) NOT NULL,
  `agname` int NOT NULL,
  `phno` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Tabela `user_customer`
--

LOCK TABLES `user_customer` WRITE;
/*!40000 ALTER TABLE `user_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Tabela `user_manager`
--

DROP TABLE IF EXISTS `user_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_manager` (
  `id` int NOT NULL,
  `name` varchar(150) NOT NULL,
  `fname` varchar(150) NOT NULL,
  `gen` varchar(150) NOT NULL,
  `age` varchar(150) NOT NULL,
  `qua` varchar(150) NOT NULL,
  `addd` varchar(150) NOT NULL,
  `bname` varchar(150) NOT NULL,
  `pass` varchar(150) NOT NULL,
  `phone` varchar(150) NOT NULL,
  `mid` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Tabela `user_manager`
--

ALTER TABLE `insurance`.`policy`
ADD COLUMN `desc_` VARCHAR(45) NULL AFTER `prat`;

LOCK TABLES `user_manager` WRITE;
/*!40000 ALTER TABLE `user_manager` DISABLE KEYS */;

/*!40000 ALTER TABLE `user_manager` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12 18:59:39

ALTER TABLE `insurance`.`policy`
ADD COLUMN `desc_` VARCHAR(45) NULL AFTER `prat`;

ALTER TABLE `user_agent` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_admin` CHANGE `password` `password` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_customer` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_manager` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
