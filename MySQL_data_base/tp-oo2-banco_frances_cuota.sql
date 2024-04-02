-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tp-oo2-banco_frances
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuota` (
  `idCuota` int NOT NULL AUTO_INCREMENT,
  `nroCuota` int DEFAULT NULL,
  `fechaVencimiento` date DEFAULT NULL,
  `saldoPendiente` double DEFAULT NULL,
  `amortizacion` double DEFAULT NULL,
  `interesesCuota` double DEFAULT NULL,
  `cuota` double DEFAULT NULL,
  `deuda` double DEFAULT NULL,
  `cancelada` bit(1) DEFAULT NULL,
  `fechaDePago` date DEFAULT NULL,
  `punitorios` double DEFAULT NULL,
  `idPrestamo` int DEFAULT NULL,
  PRIMARY KEY (`idCuota`),
  KEY `fk_cuota_prestamo_idx` (`idPrestamo`),
  CONSTRAINT `fk_cuota_prestamo` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
INSERT INTO `cuota` VALUES (2,0,'2024-04-02',20.2,20.2,20.2,20.2,20.2,_binary '\0','2024-04-02',20.2,2),(3,0,'2024-04-02',40.2,20.2,20.2,20.2,20.2,_binary '\0','2024-04-02',20.2,2),(4,0,'2024-04-02',60.2,20.2,20.2,20.2,20.2,_binary '\0','2024-04-02',20.2,2);
/*!40000 ALTER TABLE `cuota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-02 13:06:03
