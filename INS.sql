

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


-- table `branch`


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


--  table `branch`


LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Oddzial_1','Kielce','600600130','Polska'),
(2,'Oddzial_2','Warszawa','600655530','Polska'),
(3,'Oddzial_3','Berlin','632500130','Niemcy'),
(4,'Oddzial_4','Szczecin','600467130','Polska'),
(5,'Oddzial_5','Krakow','642100130','Polska'),
(6,'Oddzial_6','Wroclaw','600631570','Polska'),
(7,'Oddzial_7','Poznan','600120111','Polska'),
(8,'Oddzial_8','Zywiec','611602230','Polska')
;
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;


--  table `customer_policy`


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


--  table `customer_policy`


LOCK TABLES `customer_policy` WRITE;
/*!40000 ALTER TABLE `customer_policy` DISABLE KEYS */;
INSERT INTO `customer_policy` VALUES (7,'5001','4001','1001','Tygodniowy','3002','PLN','BBBB','50000.0'),
(8,'5002','4003','1001','Roczny','3002','PLN','BBBB','50000.0'),
(9,'5003','4003','1001','Roczny','3002','PLN','BBBB','50000.0');
/*!40000 ALTER TABLE `customer_policy` ENABLE KEYS */;
UNLOCK TABLES;


--  table `policy`


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


-- table `policy`


LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (3,'1001','Ubezpieczenie domu',24,10000,11000,2,12,2),
(4,'1002','Ubezpieczenie podrózy',12,1800000,20000,10,6,2),
(5,'1003','Ubezpieczenie samochodowe',24,25000,30000,2,12,2),
(6,'1004','Ubezpieczenie firmowe',12,18000,2000,1,3,1),
(7,'1005','Ubezpieczenie zdrowotne',12,15000,20000,2,12,2);
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;


-- table `policy_details`


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


--  table `policy_details`


LOCK TABLES `policy_details` WRITE;
/*!40000 ALTER TABLE `policy_details` DISABLE KEYS */;
INSERT INTO `policy_details` VALUES (1,'4001','31000.0','5001'),(2,'4001','10500.0','5002'),(3,'4001','2000.0','5003'),(4,'4001','2000.0','5003'),(5,'4001','10500.0','5002'),(6,'4001','0',''),(7,'4001','10500.0','5002');
/*!40000 ALTER TABLE `policy_details` ENABLE KEYS */;
UNLOCK TABLES;


--  table `user_admin`


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


-- table `user_admin`


LOCK TABLES `user_admin` WRITE;
/*!40000 ALTER TABLE `user_admin` DISABLE KEYS */;
INSERT INTO `user_admin` VALUES (1,'101','Albert','admin',25,'Male','Daleszyce','600121412');
/*!40000 ALTER TABLE `user_admin` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_SAFE_UPDATES = 0;

UPDATE user_admin
SET password = '1000:81469e6bc9c83b6c7d83a0678a06a522:de7bfa50e973beca4127d5933b2422bed59a845f3c8bb059bfb7c20bf014f2355d1ace8d99d3e452fca5cfe64a64249ec7e6abb768fe0b51edb5d72db0c86e92'
WHERE id = 1;


--  table `user_agent`


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


--  table `user_agent`


LOCK TABLES `user_agent` WRITE;
/*!40000 ALTER TABLE `user_agent` DISABLE KEYS */;
INSERT INTO `user_agent` VALUES (2,'3002','Piotr','Nowak','25','Male','Zawodowe','Zaawansowane','Kielce','50000',2,'Piotr1123','600131968'),
(3,'3003','Konrad','Stok','25','Male','Srednie','Zaawansowane','Warszawa','50000',1,'Konrad1123','605782913');
/*!40000 ALTER TABLE `user_agent` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_SAFE_UPDATES = 0;

UPDATE user_agent
SET pass = '1000:52f4df2543e2ea6b9a154c60af4044d5:db7a11a113321d2df0a846820ee27cd349c0e5f1678739cb543e63ddc99e43283ac99d8abf74733c88c487cafdc6d93af3f63320fdb4156156111f866a7d15b6'
WHERE id = 2;


UPDATE user_agent
SET pass = '1000:019ca1a8e66ef21f1cdc264ae76b6efd:9e1cf228432ddd58f1cc418ab2f3e9345964b4502b3d6734da7d678b8f9a77720a2e85d5742b4e7fa2db595cd6b8dd280e32742a12903b76fd012b01cdeccf0f'
WHERE id = 3;

--  table `user_customer`


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


--  table `user_customer`


LOCK TABLES `user_customer` WRITE;
/*!40000 ALTER TABLE `user_customer` DISABLE KEYS */;
INSERT INTO `user_customer` VALUES (1,'4001','Marcin','Robak','25','Male','Srednie','Kielce','Student','Marcin1123',3,'681726381'),
(2,'4002','Wojtek','Kracz','25','Male','Srednie','Warszawa','Mechanik','Wojtek1123',2,'601203871'),
(3,'4003','Michal','Wronek','25','Male','Zawodowe','Krakow','Sprzedawca','Michal1123',2,'601928761');
/*!40000 ALTER TABLE `user_customer` ENABLE KEYS */;
UNLOCK TABLES;

UPDATE user_customer
SET pass = '1000:2089fc3de3ef95d330c6a1985dffded5:c12574958567ff84896f6869b51d53f580cd2b0388fc83a9cc408472a4e4900290e4b6b99ff11385c3e9f1eae14a83135021132b8f4da3a67e21548efb46fb9c'
WHERE id = 1;


UPDATE user_customer
SET pass = '1000:15fe94d890857da05b7dec7efbf6309d:c01350b2c506da2d833978c5006326cf757cedd5f6a02d7fb2171521a3cfb4260e8b72de1795a52e4aea8b42856d15b0e1109fc9ea847d82aef24f241c3bd4ca'
WHERE id = 2;

UPDATE user_customer
SET pass = '1000:c9b33b6d7e4649cb0d0decb639506c2f:793ca1b300d78d57e0a8b162bcfcab8f21510b960c4a86b8b8cfa18583577b72b7fb33bdf5c0ea6a3fd83f1e2418161e5c2183bb3401ab08f2b8b2b9142481bc'
WHERE id = 3;


--  table `user_manager`


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


-- table `user_manager`


ALTER TABLE `insurance`.`policy`
ADD COLUMN `desc_` VARCHAR(45) NULL AFTER `prat`;

LOCK TABLES `user_manager` WRITE;
/*!40000 ALTER TABLE `user_manager` DISABLE KEYS */;
INSERT INTO `user_manager` VALUES (1,'Kuba','Nowak','Male','25','Wyzsze ','Kielce','Oddzial_1','Kuba1123','601293875','2001'),
(2,'Jan','Wtorek','Male','25','Wyzsze','Wroclaw','Oddzial_2','Jan1123','609827361','2002');
/*!40000 ALTER TABLE `user_manager` ENABLE KEYS */;
UNLOCK TABLES;

SET SQL_SAFE_UPDATES = 0;

UPDATE user_manager
SET pass = '1000:fc5d6dd3ad5f7fe383d2c3ec2de5976f:c94a09b6bd7914bbbc0657d166bff428db9b88b636d8e82dac6da807f5a2d4a5512fd1448e795e65afa8632202d4d55c5dc4071896f33bfe5a8fea0aceda8d7c'
WHERE id = 1;


UPDATE user_manager
SET pass = '1000:56f32be3209f0d768298d99ecd539ac6:85b47794f668d39980c694f2aefa4fd3657baf93569d3dbad475f5ec4ce77c1126279c49df544d384c97106179212eda4b7f9a60d9b328add954dcef503596b1'
WHERE id = 2;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--

ALTER TABLE `insurance`.`policy`
ADD COLUMN `desc_` VARCHAR(45) NULL AFTER `prat`;

ALTER TABLE `user_agent` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_admin` CHANGE `password` `password` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_customer` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;
ALTER TABLE `user_manager` CHANGE `pass` `pass` VARCHAR(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;

