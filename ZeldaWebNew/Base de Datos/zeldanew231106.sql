CREATE DATABASE  IF NOT EXISTS `zeldanew` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zeldanew`;
-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: zeldanew
-- ------------------------------------------------------
-- Server version	5.7.40

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
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudades` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'San Salvador'),(2,'San Jose'),(3,'Managua'),(4,'Los Angeles'),(5,'San Francisco');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `ciudades_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaf22wxd0vy9h69nta0p35jses` (`ciudades_id`),
  CONSTRAINT `FKaf22wxd0vy9h69nta0p35jses` FOREIGN KEY (`ciudades_id`) REFERENCES `ciudades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (3,'Lima','diana.lima@gmail.com','Diana','7456-3292',1),(4,'Ramos','carlosRamos@yahoo.com','Carlos','7356-0098',3),(5,'Lopez','roxanalopez@hotmail.com','Roxana Alejandra','7316-0309',5),(6,'Thompson','clay.thompson@nba.com','Clay','89737921',5),(7,'Oberto Ramirez','Fab.Oberto@espn.com.sv','Fabricio','9839-3021',4),(8,'romero','f@d','francisco','3453-3443',1),(9,'lopez','norma@lo.com.sv','norma','3222-3332',4),(10,'romero','samuel@romero.com','samuel','3322-9898',1),(11,'Guns','juan@guns.com','juan','8748-4933',5);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contabilidades`
--

DROP TABLE IF EXISTS `contabilidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contabilidades` (
  `Id_contabilidad` int(11) NOT NULL,
  `Razon_Social` varchar(100) NOT NULL,
  `NIT` varchar(16) NOT NULL,
  `Registro_IVA` varchar(9) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `Giro` varchar(200) NOT NULL,
  `Nombre_Corto` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Representante_Legal` varchar(100) DEFAULT NULL,
  `Telefono` varchar(12) DEFAULT NULL,
  `Fecha_Creacion` datetime(6) NOT NULL,
  `Usuario_Creacion` varchar(20) NOT NULL,
  `Fecha_modificacion` datetime(6) DEFAULT NULL,
  `Usuario_Modificacion` varchar(20) DEFAULT NULL,
  `idpais` int(11) NOT NULL,
  `iddepto` int(11) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  PRIMARY KEY (`Id_contabilidad`),
  UNIQUE KEY `Id_contabilidad_UNIQUE` (`Id_contabilidad`),
  KEY `Fk_Contas_Departamentos_idx` (`iddepto`),
  KEY `Fk_Contas_Municipios_idx` (`idmunicipio`),
  KEY `Fk_Contas_Paises_idx` (`idpais`),
  CONSTRAINT `Fk_Contas_Departamentos` FOREIGN KEY (`iddepto`) REFERENCES `departamentos` (`reg_depto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Contas_Municipios` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`reg_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Contas_Paises` FOREIGN KEY (`idpais`) REFERENCES `paises` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contabilidades`
--

LOCK TABLES `contabilidades` WRITE;
/*!40000 ALTER TABLE `contabilidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `contabilidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `reg_depto` int(11) NOT NULL,
  `idpais` int(11) NOT NULL,
  `iddepto` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`reg_depto`),
  UNIQUE KEY `reg_depto_UNIQUE` (`reg_depto`),
  KEY `FK_departamentos_paises_idx` (`idpais`),
  CONSTRAINT `Fk_Departamentos_Paises` FOREIGN KEY (`idpais`) REFERENCES `paises` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,208,1,'Ahuachapán'),(2,208,2,'Santa Ana'),(3,208,3,'Sonsonate'),(4,208,4,'La Libertad'),(5,208,5,'Chalatenango'),(6,208,6,'San Salvador'),(7,208,7,'Cuscatlán'),(8,208,8,'La Paz'),(9,208,9,'Cabañas'),(10,208,10,'San Vicente'),(11,208,11,'Usulután'),(12,208,12,'Morazán'),(13,208,13,'San Miguel'),(14,208,14,'La Unión');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos_roles`
--

DROP TABLE IF EXISTS `grupos_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos_roles` (
  `rol` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`rol`),
  UNIQUE KEY `rol_uniqje` (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos_roles`
--

LOCK TABLES `grupos_roles` WRITE;
/*!40000 ALTER TABLE `grupos_roles` DISABLE KEYS */;
INSERT INTO `grupos_roles` VALUES ('ROLE_ADMIN','Role para Administrador'),('ROLE_LOGISTICA','Role de logistica'),('ROLE_NuevaPrueba','ROLE_de Nueva Prueba'),('ROLE_OPERADOR','Role para Operador'),('ROLE_USER','Role para Usuario General');
/*!40000 ALTER TABLE `grupos_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipios` (
  `reg_municipio` int(11) NOT NULL,
  `idpais` int(11) NOT NULL,
  `iddepto` int(11) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`reg_municipio`),
  UNIQUE KEY `reg_municipio_UNIQUE` (`reg_municipio`),
  KEY `Fk_Municipios_Departamentos_idx` (`iddepto`),
  CONSTRAINT `Fk_Municipios_Departamentos` FOREIGN KEY (`iddepto`) REFERENCES `departamentos` (`reg_depto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,208,1,1,'Ahuachapan'),(2,208,1,2,'Jujutla'),(3,208,1,3,'Atiquizaya'),(4,208,1,4,'Concepcion de Ataco'),(5,208,1,5,'El Refugio'),(6,208,1,6,'Guaymango'),(7,208,1,7,'Apaneca'),(8,208,1,8,'San Francisco Menendez'),(9,208,1,9,'San Lorenzo'),(10,208,1,10,'San Pedro Puxtla'),(11,208,1,11,'Tacuba'),(12,208,1,12,'Turin'),(13,208,2,1,'Candelaria de la Frontera'),(14,208,2,2,'Chalchuapa'),(15,208,2,3,'Coatepeque'),(16,208,2,4,'El Congo'),(17,208,2,5,'El Porvenir'),(18,208,2,6,'Masahuat'),(19,208,2,7,'Metapan'),(20,208,2,8,'San Antonio Pajonal'),(21,208,2,9,'San Sebastian Salitrillo'),(22,208,2,10,'Santa Ana'),(23,208,2,11,'Santa Rosa Guachipilin'),(24,208,2,12,'Santiago de la Frontera'),(25,208,2,13,'Texistepeque'),(26,208,3,1,'Acajutla'),(27,208,3,2,'Armenia'),(28,208,3,3,'Caluco'),(29,208,3,4,'Cuisnahuat'),(30,208,3,5,'Izalco'),(31,208,3,6,'Juayua'),(32,208,3,7,'Nahuizalco'),(33,208,3,8,'Nahulingo'),(34,208,3,9,'Salcoatitan'),(35,208,3,10,'San Antonio del Monte'),(36,208,3,11,'San Julian'),(37,208,3,12,'Santa Catarina Masahuat'),(38,208,3,13,'Santa Isabel Ishuatan'),(39,208,3,14,'Santo Domingo de Guzman'),(40,208,3,15,'Sonsonate'),(41,208,3,16,'Sonzacate'),(42,208,4,1,'Antiguo Cuscatlan'),(43,208,4,2,'Chiltiupan'),(44,208,4,3,'Ciudad Arce'),(45,208,4,4,'Colon'),(46,208,4,5,'Comasagua'),(47,208,4,6,'Huizucar'),(48,208,4,7,'Jayaque'),(49,208,4,8,'Jicalapa'),(50,208,4,9,'La Libertad'),(51,208,4,10,'Santa Tecla'),(52,208,4,11,'Nuevo Cuscatlan'),(53,208,4,12,'San Juan Opico'),(54,208,4,13,'Quezaltepeque'),(55,208,4,14,'Sacacoyo'),(56,208,4,15,'San Jose Villanueva'),(57,208,4,16,'San Matias'),(58,208,4,17,'San Pablo Tacachico'),(59,208,4,18,'Talnique'),(60,208,4,19,'Tamanique'),(61,208,4,20,'Teotepeque'),(62,208,4,21,'Tepecoyo'),(63,208,4,22,'Zaragoza'),(64,208,5,1,'Agua Caliente'),(65,208,5,2,'Arcatao'),(66,208,5,3,'Azacualpa'),(67,208,5,4,'Cancasque'),(68,208,5,5,'Chalatenango'),(69,208,5,6,'Citala'),(70,208,5,7,'Comapala'),(71,208,5,8,'Concepcion Quezaltepeque'),(72,208,5,9,'Dulce Nombre de Maria'),(73,208,5,10,'El Carrizal'),(74,208,5,11,'El Paraiso'),(75,208,5,12,'La Laguna'),(76,208,5,13,'La Palma'),(77,208,5,14,'La Reina'),(78,208,5,15,'Las Vueltas'),(79,208,5,16,'Nueva Concepcion'),(80,208,5,17,'Nueva Trinidad'),(81,208,5,18,'Nombre de Jesus'),(82,208,5,19,'Ojos de Agua'),(83,208,5,20,'Potonico'),(84,208,5,21,'San Antonio de la Cruz'),(85,208,5,22,'San Antonio Los Ranchos'),(86,208,5,23,'San Fernando (208, Chalatenango)'),(87,208,5,24,'San Francisco Lempa'),(88,208,5,25,'San Francisco Morazan'),(89,208,5,26,'San Ignacio'),(90,208,5,27,'San Isidro Labrador'),(91,208,5,28,'Las Flores'),(92,208,5,29,'San Luis del Carmen'),(93,208,5,30,'San Miguel de Mercedes'),(94,208,5,31,'San Rafael'),(95,208,5,32,'Santa Rita'),(96,208,5,33,'Tejutla'),(97,208,6,1,'Aguilares'),(98,208,6,2,'Apopa'),(99,208,6,3,'Ayutuxtepeque'),(100,208,6,4,'Cuscatancingo'),(101,208,6,5,'Ciudad Delgado'),(102,208,6,6,'El Paisnal'),(103,208,6,7,'Guazapa'),(104,208,6,8,'Ilopango'),(105,208,6,9,'Mejicanos'),(106,208,6,10,'Nejapa'),(107,208,6,11,'Panchimalco'),(108,208,6,12,'Rosario de Mora'),(109,208,6,13,'San Marcos'),(110,208,6,14,'San Martin'),(111,208,6,15,'San Salvador'),(112,208,6,16,'Santiago Texacuangos'),(113,208,6,17,'Santo Tomas'),(114,208,6,18,'Soyapango'),(115,208,6,19,'Tonacatepeque'),(116,208,7,1,'Cojutepeque'),(117,208,7,2,'Candelaria'),(118,208,7,3,'El Carmen (208, Cuscatlan)'),(119,208,7,4,'El Rosario (208, Cuscatlan)'),(120,208,7,5,'Monte San Juan'),(121,208,7,6,'Oratorio de Concepcion'),(122,208,7,7,'San Bartolome Perulapia'),(123,208,7,8,'San Cristobal'),(124,208,7,9,'San Jose Guayabal'),(125,208,7,10,'San Pedro Perulapan'),(126,208,7,11,'San Rafael Cedros'),(127,208,7,12,'San Ramon'),(128,208,7,13,'Santa Cruz Analquito'),(129,208,7,14,'Santa Cruz Michapa'),(130,208,7,15,'Suchitoto'),(131,208,7,16,'Tenancingo'),(132,208,8,1,'Zacatecoluca'),(133,208,8,2,'Cuyultitan'),(134,208,8,3,'El Rosario La Paz'),(135,208,8,4,'Jerusalen'),(136,208,8,5,'Mercedes La Ceiba'),(137,208,8,6,'Olocuilta'),(138,208,8,7,'Paraiso de Osorio'),(139,208,8,8,'San Antonio Masahuat'),(140,208,8,9,'San Emigdio'),(141,208,8,10,'San Francisco Chinameca'),(142,208,8,11,'San Pedro Masahuat'),(143,208,8,12,'San Juan Nonualco'),(144,208,8,13,'San Juan Talpa'),(145,208,8,14,'San Juan Tepezontes'),(146,208,8,15,'San Luis La Herradura'),(147,208,8,16,'San Luis Talpa'),(148,208,8,17,'San Miguel Tepezontes'),(149,208,8,18,'San Pedro Nonualco'),(150,208,8,19,'San Rafael Obrajuelo'),(151,208,8,20,'Santa Maria Ostuma'),(152,208,8,21,'Santiago Nonualco'),(153,208,8,22,'Tapalhuaca'),(154,208,9,1,'Cinquera'),(155,208,9,2,'Dolores'),(156,208,9,3,'Guacotecti'),(157,208,9,4,'Ilobasco'),(158,208,9,5,'Jutiapa'),(159,208,9,6,'San Isidro Cabañas'),(160,208,9,7,'Sensuntepeque'),(161,208,9,8,'Tejutepeque'),(162,208,9,9,'Victoria'),(163,208,10,1,'Apastepeque'),(164,208,10,2,'Guadalupe'),(165,208,10,3,'San Cayetano Istepeque'),(166,208,10,4,'San Esteban Catarina'),(167,208,10,5,'San Ildefonso'),(168,208,10,6,'San Lorenzo'),(169,208,10,7,'San Sebastian'),(170,208,10,8,'San Vicente'),(171,208,10,9,'Santa Clara'),(172,208,10,10,'Santo Domingo'),(173,208,10,11,'Tecoluca'),(174,208,10,12,'Tepetitan'),(175,208,10,13,'Verapaz'),(176,208,11,1,'Alegria'),(177,208,11,2,'Berlin'),(178,208,11,3,'California'),(179,208,11,4,'Concepcion Batres'),(180,208,11,5,'El Triunfo'),(181,208,11,6,'Ereguayquin'),(182,208,11,7,'Estanzuelas'),(183,208,11,8,'Jiquilisco'),(184,208,11,9,'Jucuapa'),(185,208,11,10,'Jucuaran'),(186,208,11,11,'Mercedes Umaña'),(187,208,11,12,'Nueva Granada'),(188,208,11,13,'Ozatlan'),(189,208,11,14,'Puerto El Triunfo'),(190,208,11,15,'San Agustin'),(191,208,11,16,'San Buenaventura'),(192,208,11,17,'San Dionisio'),(193,208,11,18,'San Francisco Javier'),(194,208,11,19,'Santa Elena'),(195,208,11,20,'Santa Maria'),(196,208,11,21,'Santiago de Maria'),(197,208,11,22,'Tecapan'),(198,208,11,23,'Usulutan'),(199,208,12,1,'Arambala'),(200,208,12,2,'Cacaopera'),(201,208,12,3,'Chilanga'),(202,208,12,4,'Corinto'),(203,208,12,5,'Delicias de Concepcion'),(204,208,12,6,'El Divisadero'),(205,208,12,7,'El Rosario Morazan'),(206,208,12,8,'Gualococti'),(207,208,12,9,'Guatajiagua'),(208,208,12,10,'Joateca'),(209,208,12,11,'Jocoaitique'),(210,208,12,12,'Jocoro'),(211,208,12,13,'Lolotiquillo'),(212,208,12,14,'Meanguera'),(213,208,12,15,'Osicala'),(214,208,12,16,'Perquin'),(215,208,12,17,'San Carlos'),(216,208,12,18,'San Fernando Morazan'),(217,208,12,19,'San Francisco Gotera'),(218,208,12,20,'San Isidro Morazan'),(219,208,12,21,'San Simon'),(220,208,12,22,'Sensembra'),(221,208,12,23,'Sociedad'),(222,208,12,24,'Torola'),(223,208,12,25,'Yamabal'),(224,208,12,26,'Yoloaiquin'),(225,208,13,1,'Carolina'),(226,208,13,2,'Chapeltique'),(227,208,13,3,'Chinameca'),(228,208,13,4,'Chirilagua'),(229,208,13,5,'Ciudad Barrios'),(230,208,13,6,'Comacaran'),(231,208,13,7,'El Transito'),(232,208,13,8,'Lolotique'),(233,208,13,9,'Moncagua'),(234,208,13,10,'Nueva Guadalupe'),(235,208,13,11,'Nuevo Eden de San Juan'),(236,208,13,12,'Quelepa'),(237,208,13,13,'San Antonio del Mosco'),(238,208,13,14,'San Gerardo'),(239,208,13,15,'San Jorge'),(240,208,13,16,'San Luis de la Reina'),(241,208,13,17,'San Miguel'),(242,208,13,18,'San Rafael Oriente'),(243,208,13,19,'Sesori'),(244,208,13,20,'Uluazapa'),(245,208,14,1,'La Union'),(246,208,14,2,'San Alejo'),(247,208,14,3,'Yucuaiquin'),(248,208,14,4,'Conchagua'),(249,208,14,5,'Intipuca'),(250,208,14,6,'San Jose'),(251,208,14,7,'El Carmen'),(252,208,14,8,'Yayantique'),(253,208,14,9,'Bolivar'),(254,208,14,10,'Meanguera del Golfo'),(255,208,14,11,'Santa Rosa de Lima'),(256,208,14,12,'Pasaquina'),(257,208,14,15,'Anamoros'),(258,208,14,16,'Nueva Esparta'),(259,208,14,17,'El Sauce'),(260,208,14,18,'Concepcion de Oriente'),(261,208,14,19,'Poloros'),(262,208,14,20,'Lislique');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `idpais` int(11) NOT NULL AUTO_INCREMENT,
  `iniciales` varchar(2) NOT NULL,
  `nombrepais` varchar(45) NOT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`idpais`),
  UNIQUE KEY `iniciales_UNIQUE` (`iniciales`),
  UNIQUE KEY `idpais_UNIQUE` (`idpais`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'AD','Andorra',0),(2,'AE','Emiratos Arabes Unidos',0),(3,'AF','Afganistan',0),(4,'AG','Antigua y Barbuda',0),(5,'AI','Anguila',0),(6,'AL','Albania',0),(7,'AM','Armenia',0),(8,'AO','Angola',0),(9,'AQ','Antartida',0),(10,'AR','Argentina',0),(11,'AS','Samoa Americana',0),(12,'AT','Austria',0),(13,'AU','Australia',0),(14,'AW','Aruba',0),(15,'AZ','Azerbaiyan',0),(16,'BA','Bosnia-Herzegovina',0),(17,'BB','Barbados',0),(18,'BD','Banglades',0),(19,'BE','Belgica',0),(20,'BF','Burkina Faso',0),(21,'BG','Bulgaria',0),(22,'BH','Bahrein',0),(23,'BI','Burundi',0),(24,'BJ','Benin',0),(25,'BL','San Bartolome',0),(26,'BM','Bermudas',0),(27,'BN','Brunei',0),(28,'BO','Bolivia',0),(29,'BR','Brasil',0),(30,'BS','Las Bahamas',0),(31,'BT','Butan',0),(32,'BV','Isla Bouvet',0),(33,'BW','Botsuana',0),(34,'BY','Bielorrusia',0),(35,'BZ','Belice',0),(36,'CA','Canada',0),(37,'CC','Islas Cocos (Keeling)',0),(38,'CD','Congo,  Republica Democratica del',0),(39,'CF','Republica Centroafricana',0),(40,'CG','Congo, Republica del',0),(41,'CH','Suiza',0),(42,'CI','Costa de Marfil',0),(43,'CK','Islas Cook',0),(44,'CL','Chile',0),(45,'CM','Camerun',0),(46,'CN','China',0),(47,'CO','Colombia',0),(48,'CR','Costa Rica',0),(49,'CU','Cuba',0),(50,'CV','Cabo Verde',0),(51,'CW','Curacao',0),(52,'CX','Isla de Navidad',0),(53,'CY','Chipre',0),(54,'CZ','Republica Checa',0),(55,'DE','Alemania',0),(56,'DJ','Yibuti',0),(57,'DK','Dinamarca',0),(58,'DM','Dominica',0),(59,'DO','Republica Dominicana',0),(60,'DZ','Argelia',0),(61,'EC','Ecuador',0),(62,'EE','Estonia',0),(63,'EG','Egipto',0),(64,'EH','Sahara Occidental',0),(65,'ER','Eritrea',0),(66,'ES','Espana',0),(67,'ET','Etiopia',0),(68,'FI','Finlandia',0),(69,'FJ','Fiyi',0),(70,'FK','Islas Malvinas-Falkland',0),(71,'FM','Micronesia,  Estados Federados de',0),(72,'FO','Islas Feroe',0),(73,'FR','Francia',0),(74,'FX','Francia',0),(75,'GA','Gabon',0),(76,'GB','Reino Unido',0),(77,'GD','Granada',0),(78,'GE','Georgia',0),(79,'GF','Guayana Francesa',0),(80,'GG','Guernsey',0),(81,'GH','Ghana',0),(82,'GI','Gibraltar',0),(83,'GL','Groenlandia',0),(84,'GM','Gambia',0),(85,'GN','Guinea',0),(86,'GP','Guadalupe',0),(87,'GQ','Guinea Ecuatorial',0),(88,'GR','Grecia',0),(89,'GS','Islas Georgia del Sur y Sandwich del Sur',0),(90,'GT','Guatemala',0),(91,'GU','Guam',0),(92,'GW','Guinea-Bissau',0),(93,'GY','Guyana',0),(94,'HK','Hong Kong',0),(95,'HM','Islas Heard y McDonald',0),(96,'HN','Honduras',0),(97,'HR','Croacia',0),(98,'HT','Haiti',0),(99,'HU','Hungria',0),(100,'ID','Indonesia',0),(101,'IE','Irlanda',0),(102,'IL','Israel',0),(103,'IM','Isla de Man',0),(104,'IN','India',0),(105,'IO','Territorio britanico del oceano indico',0),(106,'IQ','Iraq',0),(107,'IR','Iran',0),(108,'IS','Islandia',0),(109,'IT','Italia',0),(110,'JE','Jersey',0),(111,'JM','Jamaica',0),(112,'JO','Jordania',0),(113,'JP','Japon',0),(114,'KE','Kenia',0),(115,'KG','Kirguistan',0),(116,'KH','Camboya',0),(117,'KI','Kiribati',0),(118,'KM','Comoras',0),(119,'KN','San Cristobal y Nieves',0),(120,'KP','Corea del Norte',0),(121,'KR','Corea del Sur',0),(122,'KW','Kuwait',0),(123,'KY','Islas Caiman',0),(124,'KZ','Kazajistan',0),(125,'LA','Laos',0),(126,'LB','Libano',0),(127,'LC','Santa Lucia',0),(128,'LI','Liechtenstein',0),(129,'LK','Sri Lanka',0),(130,'LR','Liberia',0),(131,'LS','Lesoto',0),(132,'LT','Lituania',0),(133,'LU','Luxemburgo',0),(134,'LV','Letonia',0),(135,'LY','Libia',0),(136,'MA','Marruecos',0),(137,'MC','Monaco',0),(138,'MD','Moldovia',0),(139,'ME','Montenegro',0),(140,'MF','Saint Martin',0),(141,'MG','Madagascar',0),(142,'MH','Islas Marshall',0),(143,'MK','Macedonia',0),(144,'ML','Mali',0),(145,'MM','Burma',0),(146,'MN','Mongolia',0),(147,'MO','Macao',0),(148,'MP','Islas Marianas del Norte',0),(149,'MQ','Martinica',0),(150,'MR','Mauritania',0),(151,'MS','Montserrat',0),(152,'MT','Malta',0),(153,'MU','Mauricio',0),(154,'MV','Maldivas',0),(155,'MW','Malaui',0),(156,'MX','Mexico',0),(157,'MY','Malasia',0),(158,'MZ','Mozambique',0),(159,'NA','Namibia',0),(160,'NC','Nueva Caledonia',0),(161,'NE','Niger',0),(162,'NF','Isla Norfolk',0),(163,'NG','Nigeria',0),(164,'NI','Nicaragua',0),(165,'NL','Paises Bajos',0),(166,'NO','Noruega',0),(167,'NP','Nepal',0),(168,'NR','Nauru',0),(169,'NU','Niue',0),(170,'NZ','Nueva Zelanda',0),(171,'OM','Oman',0),(172,'PA','Panama',0),(173,'PE','Peru',0),(174,'PF','Polinesia Francesa',0),(175,'PG','Papua Nueva Guinea',0),(176,'PH','Filipinas',0),(177,'PK','Pakistan',0),(178,'PL','Polonia',0),(179,'PM','San Pedro y Miguelon',0),(180,'PN','Islas Pitcairn',0),(181,'PR','Puerto Rico',0),(182,'PT','Portugal',0),(183,'PW','Palaos',0),(184,'PY','Paraguay',0),(185,'QA','Qatar',0),(186,'RE','Reunion',0),(187,'RO','Rumania',0),(188,'RS','Serbia',0),(189,'RU','Rusia',0),(190,'RW','Ruanda',0),(191,'SA','Arabia Saudita',0),(192,'SB','Islas Salomon',0),(193,'SC','Seychelles',0),(194,'SD','Sudan',0),(195,'SE','Suecia',0),(196,'SG','Singapur',0),(197,'SH','Santa Helena,  Ascension y Tristan de Acuna',0),(198,'SI','Eslovenia',0),(199,'SJ','Svalbard',0),(200,'SK','Eslovaquia',0),(201,'SL','Sierra Leona',0),(202,'SM','San Marino',0),(203,'SN','Senegal',0),(204,'SO','Somalia',0),(205,'SR','Surinam',0),(206,'SS','Sudan Sur',0),(207,'ST','Santo Tome y Principe',0),(208,'SV','El Salvador',1),(209,'SX','Sint Maarten',0),(210,'SY','Siria',0),(211,'SZ','Suazilandia',0),(212,'TC','Islas Turcas y Caicos',0),(213,'TD','Chad',0),(214,'TF','Territorios Australes Franceses',0),(215,'TG','Togo',0),(216,'TH','Tailandia',0),(217,'TJ','Tayikistan',0),(218,'TK','Tokelau',0),(219,'TL','Timor Leste',0),(220,'TM','Turkmenistan',0),(221,'TN','Tunez',0),(222,'TO','Tonga',0),(223,'TR','Turquia',0),(224,'TT','Trinidad y Tobago',0),(225,'TV','Tuvalu',0),(226,'TW','Taiwan',0),(227,'TZ','Tanzania',0),(228,'UA','Ucrania',0),(229,'UG','Uganda',0),(230,'UM','Islas Ultramarinas menores de Estados Unidos',0),(231,'US','Estados Unidos',0),(232,'UY','Uruguay',0),(233,'UZ','Uzbekistan',0),(234,'VA','Santa Sede (Estado de la Ciudad del Vaticano)',0),(235,'VC','San Vicente y las Granadinas',0),(236,'VE','Venezuela',0),(237,'VG','Islas Virgenes Britanicas',0),(238,'VI','Islas Virgenes de los EE. UU.',0),(239,'VN','Vietnam',0),(240,'VU','Vanuatu',0),(241,'WF','Islas Wallis y Futuna',0),(242,'WS','Samoa',0),(243,'XK','Kosovo',0),(244,'YE','Yemen',0),(245,'YT','Mayotte',0),(246,'ZA','Sudafrica',0),(247,'ZM','Zambia',0),(248,'ZW','Zimbabwe',0);
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `Fk_roles_grupos_roles_idx` (`rol`),
  CONSTRAINT `Fk_roles_grupos_roles` FOREIGN KEY (`rol`) REFERENCES `grupos_roles` (`rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'ROLE_USER'),(2,2,'ROLE_ADMIN'),(3,9,'ROLE_NuevaPrueba');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user','$2a$10$.Es50vZ.BJeRTjEzq/kNUOccsXg3pCsuncmEEaYivJk8Z16ytjRZW',_binary ''),(2,'admin','$2a$10$YKyE3dli3CbtQyElMJPkL.mfffc78CfWxVKS.Yc5DgxlmeKHju.Gi',_binary ''),(9,'melvin','$2a$10$yTSilgZU/VjLfwfr.2Y.tO7YIOvPFFxzV6.R9Glchil11fvEgXrQK',_binary ''),(10,'fran','$2a$10$TkRR25f.H/2HpcDBmHBD1ulxKs8ZUsAYR8Le/IeS1.xKzqrDz6Edi',_binary ''),(12,'luis1','$2a$10$qtjf7H902jNvXaIxwd8bjOZAEhBVuubNI3QeT6LTKRwIAGrs5dq/i',_binary ''),(13,'pancho','$2a$10$k1e9rKfyRG9yWfCPpRQ1ke18WxJL8CiFwQUPmNH30//iXI/Z0SKeK',_binary ''),(14,'panchito','$2a$10$aPCzP/3KqEczd4vIunsHg.Ub.jd9WQW1OpS.6ZJ2BLm/Wu7.ESz0W',_binary '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'zeldanew'
--

--
-- Dumping routines for database 'zeldanew'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-06 20:30:03
