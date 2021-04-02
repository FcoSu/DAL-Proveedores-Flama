-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_pago_proveedores
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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `area_Id` int NOT NULL AUTO_INCREMENT,
  `area_Nombre` varchar(254) DEFAULT NULL,
  `area_Responsable` varchar(254) DEFAULT NULL,
  `area_Email` varchar(254) DEFAULT NULL,
  `area_Ceco` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`area_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Areadasdasdas','yomero','yomero@elarea.com','Niuno'),(2,'Areadasdasdas','yomero','yomero@elarea.com','Niuno'),(3,'MiSuperArea','yomero','yomero@elarea.com','Niuno'),(4,'MiSuperArea','yomero','yomero@elarea.com','Niuno'),(5,'MiSuperArea','yomero','yomero@elarea.com','Niuno'),(6,'MiPerfectaArea','yomero','yomero@elarea.com','Niuno'),(7,'MiPerfectaArea','yomero','yomero@elarea.com','Niuno'),(8,'MiPerfectaArea','yomero','yomero@elarea.com','Niuno'),(9,'the best area ever','yomerito','yomero@elarea.com','ElBanco:(');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrodeCosto`
--

DROP TABLE IF EXISTS `centrodeCosto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centrodeCosto` (
  `centro_Id` int NOT NULL,
  `aprovador_Id` varchar(254) DEFAULT NULL,
  `centro_Nombre` varchar(254) DEFAULT NULL,
  `monto_Maximo` int DEFAULT NULL,
  `moneda` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`centro_Id`),
  KEY `FK_EXISTE` (`aprovador_Id`),
  CONSTRAINT `FK_EXISTE` FOREIGN KEY (`aprovador_Id`) REFERENCES `waiver` (`aprovador_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrodeCosto`
--

LOCK TABLES `centrodeCosto` WRITE;
/*!40000 ALTER TABLE `centrodeCosto` DISABLE KEYS */;
INSERT INTO `centrodeCosto` VALUES (1,NULL,'Oper2021',1000000,'CLP'),(2,NULL,'RRHH2021',500000,'CLP'),(3,NULL,'MARK2021',700000,'CLP'),(4,NULL,'MANTO2021',2000000,'CLP');
/*!40000 ALTER TABLE `centrodeCosto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `definidoPara`
--

DROP TABLE IF EXISTS `definidoPara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `definidoPara` (
  `area_Id` int NOT NULL,
  `aprovador_Id` varchar(254) NOT NULL,
  PRIMARY KEY (`area_Id`,`aprovador_Id`),
  KEY `FK_ESTA_DEFINIDO` (`aprovador_Id`),
  CONSTRAINT `FK_ACARGO_DE` FOREIGN KEY (`area_Id`) REFERENCES `area` (`area_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ESTA_DEFINIDO` FOREIGN KEY (`aprovador_Id`) REFERENCES `waiver` (`aprovador_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `definidoPara`
--

LOCK TABLES `definidoPara` WRITE;
/*!40000 ALTER TABLE `definidoPara` DISABLE KEYS */;
/*!40000 ALTER TABLE `definidoPara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoSolicitud`
--

DROP TABLE IF EXISTS `estadoSolicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoSolicitud` (
  `estado_solicitud_Id` int NOT NULL,
  `estado` varchar(254) DEFAULT NULL,
  `descripcion` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`estado_solicitud_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoSolicitud`
--

LOCK TABLES `estadoSolicitud` WRITE;
/*!40000 ALTER TABLE `estadoSolicitud` DISABLE KEYS */;
INSERT INTO `estadoSolicitud` VALUES (1,'Recibido','Solicitud recibida'),(2,'Pendiente','Error durante el proceso'),(3,'Rechazado','Solicitud rechazada'),(4,'Aprobado','Solicitud aprobada');
/*!40000 ALTER TABLE `estadoSolicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `proveedor_id_Registro` int NOT NULL AUTO_INCREMENT,
  `proveedor_Id` varchar(254) NOT NULL,
  `proveedor_Nombre` varchar(254) DEFAULT NULL,
  `proveedor_Rut` varchar(254) DEFAULT NULL,
  `proveedor_Razon_Social` varchar(254) DEFAULT NULL,
  `proveedor_Email` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`proveedor_id_Registro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'TheBestProv','yomerito','18.777.447-5','Prueba de Ingreso','TheEmail@elCorreo.cl'),(2,'TheBestProv','yomerito','18.777.447-5','Prueba de Ingreso','TheEmail@elCorreo.cl');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resolucion`
--

DROP TABLE IF EXISTS `resolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resolucion` (
  `resolucion_Id` int NOT NULL,
  `solicitud_Id` int DEFAULT NULL,
  `monto_Total` int DEFAULT NULL,
  `resolucion_Comentario` varchar(254) DEFAULT NULL,
  `resolucion_Fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`resolucion_Id`),
  KEY `FK_RELATIONSHIP_7` (`solicitud_Id`),
  CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`solicitud_Id`) REFERENCES `solicitud` (`solicitud_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resolucion`
--

LOCK TABLES `resolucion` WRITE;
/*!40000 ALTER TABLE `resolucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `resolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitante`
--

DROP TABLE IF EXISTS `solicitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitante` (
  `solicitante_Id` int NOT NULL AUTO_INCREMENT,
  `solicitante_Nombre` varchar(254) DEFAULT NULL,
  `solicitante_Email` varchar(254) DEFAULT NULL,
  `solicitante_Cargo` varchar(254) DEFAULT NULL,
  `aprovador_Id` varchar(254) DEFAULT NULL,
  `aprovador_Nombre` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`solicitante_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitante`
--

LOCK TABLES `solicitante` WRITE;
/*!40000 ALTER TABLE `solicitante` DISABLE KEYS */;
INSERT INTO `solicitante` VALUES (1,'yomero','micorreo@theemail.com',' el de las pruebas','11232','minombre');
/*!40000 ALTER TABLE `solicitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitud` (
  `solicitud_Id` int NOT NULL AUTO_INCREMENT,
  `proveedor_id_Registro` int NOT NULL,
  `area_Id` int DEFAULT NULL,
  `centro_Id` int DEFAULT NULL,
  `solicitante_Id` int DEFAULT NULL,
  `estado_solicitud_Id` int DEFAULT NULL,
  `solicitud_Numero` int DEFAULT NULL,
  `solicitud_Monto` int DEFAULT NULL,
  `solicitud_Iva` float DEFAULT NULL,
  `solicitud_Prioridad` int DEFAULT NULL,
  `solicitud_Descripcion` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`solicitud_Id`),
  KEY `FK_CONSULTA_MONTO_MAXIMO` (`centro_Id`),
  KEY `FK_CREA` (`solicitante_Id`),
  KEY `FK_PERTENECE` (`area_Id`),
  KEY `FK_POSEE` (`proveedor_id_Registro`),
  KEY `FK_PUEDE_TENER` (`estado_solicitud_Id`),
  CONSTRAINT `FK_CONSULTA_MONTO_MAXIMO` FOREIGN KEY (`centro_Id`) REFERENCES `centrodeCosto` (`centro_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CREA` FOREIGN KEY (`solicitante_Id`) REFERENCES `solicitante` (`solicitante_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PERTENECE` FOREIGN KEY (`area_Id`) REFERENCES `area` (`area_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PUEDE_TENER` FOREIGN KEY (`estado_solicitud_Id`) REFERENCES `estadoSolicitud` (`estado_solicitud_Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (1,2,3,4,1,1,11433,540000,19.2,3,'Esta es una solicitud de prueba '),(2,2,3,4,1,1,11433,540000,19.2,3,'Esta es una solicitud de prueba '),(3,2,3,4,1,1,11433,540000,19.2,3,'Esta es una solicitud de prueba ');
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waiver`
--

DROP TABLE IF EXISTS `waiver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waiver` (
  `aprovador_Id` varchar(254) NOT NULL,
  `area_Nombre` varchar(254) DEFAULT NULL,
  `waiver` tinyint DEFAULT NULL,
  PRIMARY KEY (`aprovador_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waiver`
--

LOCK TABLES `waiver` WRITE;
/*!40000 ALTER TABLE `waiver` DISABLE KEYS */;
INSERT INTO `waiver` VALUES ('MANTO001','Mantenimiento',1),('Oper001','Operaciones',1),('RRHH001','RRHH',0);
/*!40000 ALTER TABLE `waiver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-02  1:14:50
