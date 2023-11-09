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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL,
  `pais_id` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_departamentos` (`pais_id`),
  CONSTRAINT `Fk_Departamentos_Paises` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,208,'Ahuachapán'),(2,208,'Santa Ana'),(3,208,'Sonsonate'),(4,208,'La Libertad'),(5,208,'Chalatenango'),(6,208,'San Salvador'),(7,208,'Cuscatlán'),(8,208,'La Paz'),(9,208,'Cabañas'),(10,208,'San Vicente'),(11,208,'Usulután'),(12,208,'Morazán'),(13,208,'San Miguel'),(14,208,'La Unión');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(100) NOT NULL,
  `nit` varchar(16) NOT NULL,
  `registro_iva` varchar(9) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `giro` varchar(100) NOT NULL,
  `nombre_corto` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `representante_legal` varchar(100) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pais_id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  `municipio_id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_contabilidad_UNIQUE` (`Id`),
  KEY `Fk_Contas_Departamentos_idx` (`departamento_id`),
  KEY `Fk_Contas_Municipios_idx` (`municipio_id`),
  KEY `Fk_Contas_Paises_idx` (`pais_id`),
  CONSTRAINT `Fk_Contas_Departamentos` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Contas_Municipios` FOREIGN KEY (`municipio_id`) REFERENCES `municipio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_Contas_Paises` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'FRJ SA. de CV','06143107650033','951234','Urbanizacion Tazumal senda 3 casa 17','Venta de Software','FRJ','Fracisco Romero','76022658','fromerojovel@gmail.com',208,6,1);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
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
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipio` (
  `id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reg_municipio_UNIQUE` (`id`),
  KEY `Fk_Municipios_Departamentos_idx` (`departamento_id`),
  CONSTRAINT `Fk_Municipios_Departamentos` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,1,'Ahuachapan'),(2,1,'Jujutla'),(3,1,'Atiquizaya'),(4,1,'Concepcion de Ataco'),(5,1,'El Refugio'),(6,1,'Guaymango'),(7,1,'Apaneca'),(8,1,'San Francisco Menendez'),(9,1,'San Lorenzo'),(10,1,'San Pedro Puxtla'),(11,1,'Tacuba'),(12,1,'Turin'),(13,2,'Candelaria de la Frontera'),(14,2,'Chalchuapa'),(15,2,'Coatepeque'),(16,2,'El Congo'),(17,2,'El Porvenir'),(18,2,'Masahuat'),(19,2,'Metapan'),(20,2,'San Antonio Pajonal'),(21,2,'San Sebastian Salitrillo'),(22,2,'Santa Ana'),(23,2,'Santa Rosa Guachipilin'),(24,2,'Santiago de la Frontera'),(25,2,'Texistepeque'),(26,3,'Acajutla'),(27,3,'Armenia'),(28,3,'Caluco'),(29,3,'Cuisnahuat'),(30,3,'Izalco'),(31,3,'Juayua'),(32,3,'Nahuizalco'),(33,3,'Nahulingo'),(34,3,'Salcoatitan'),(35,3,'San Antonio del Monte'),(36,3,'San Julian'),(37,3,'Santa Catarina Masahuat'),(38,3,'Santa Isabel Ishuatan'),(39,3,'Santo Domingo de Guzman'),(40,3,'Sonsonate'),(41,3,'Sonzacate'),(42,4,'Antiguo Cuscatlan'),(43,4,'Chiltiupan'),(44,4,'Ciudad Arce'),(45,4,'Colon'),(46,4,'Comasagua'),(47,4,'Huizucar'),(48,4,'Jayaque'),(49,4,'Jicalapa'),(50,4,'La Libertad'),(51,4,'Santa Tecla'),(52,4,'Nuevo Cuscatlan'),(53,4,'San Juan Opico'),(54,4,'Quezaltepeque'),(55,4,'Sacacoyo'),(56,4,'San Jose Villanueva'),(57,4,'San Matias'),(58,4,'San Pablo Tacachico'),(59,4,'Talnique'),(60,4,'Tamanique'),(61,4,'Teotepeque'),(62,4,'Tepecoyo'),(63,4,'Zaragoza'),(64,5,'Agua Caliente'),(65,5,'Arcatao'),(66,5,'Azacualpa'),(67,5,'Cancasque'),(68,5,'Chalatenango'),(69,5,'Citala'),(70,5,'Comapala'),(71,5,'Concepcion Quezaltepeque'),(72,5,'Dulce Nombre de Maria'),(73,5,'El Carrizal'),(74,5,'El Paraiso'),(75,5,'La Laguna'),(76,5,'La Palma'),(77,5,'La Reina'),(78,5,'Las Vueltas'),(79,5,'Nueva Concepcion'),(80,5,'Nueva Trinidad'),(81,5,'Nombre de Jesus'),(82,5,'Ojos de Agua'),(83,5,'Potonico'),(84,5,'San Antonio de la Cruz'),(85,5,'San Antonio Los Ranchos'),(86,5,'San Fernando (208, Chalatenango)'),(87,5,'San Francisco Lempa'),(88,5,'San Francisco Morazan'),(89,5,'San Ignacio'),(90,5,'San Isidro Labrador'),(91,5,'Las Flores'),(92,5,'San Luis del Carmen'),(93,5,'San Miguel de Mercedes'),(94,5,'San Rafael'),(95,5,'Santa Rita'),(96,5,'Tejutla'),(97,6,'Aguilares'),(98,6,'Apopa'),(99,6,'Ayutuxtepeque'),(100,6,'Cuscatancingo'),(101,6,'Ciudad Delgado'),(102,6,'El Paisnal'),(103,6,'Guazapa'),(104,6,'Ilopango'),(105,6,'Mejicanos'),(106,6,'Nejapa'),(107,6,'Panchimalco'),(108,6,'Rosario de Mora'),(109,6,'San Marcos'),(110,6,'San Martin'),(111,6,'San Salvador'),(112,6,'Santiago Texacuangos'),(113,6,'Santo Tomas'),(114,6,'Soyapango'),(115,6,'Tonacatepeque'),(116,7,'Cojutepeque'),(117,7,'Candelaria'),(118,7,'El Carmen (208, Cuscatlan)'),(119,7,'El Rosario (208, Cuscatlan)'),(120,7,'Monte San Juan'),(121,7,'Oratorio de Concepcion'),(122,7,'San Bartolome Perulapia'),(123,7,'San Cristobal'),(124,7,'San Jose Guayabal'),(125,7,'San Pedro Perulapan'),(126,7,'San Rafael Cedros'),(127,7,'San Ramon'),(128,7,'Santa Cruz Analquito'),(129,7,'Santa Cruz Michapa'),(130,7,'Suchitoto'),(131,7,'Tenancingo'),(132,8,'Zacatecoluca'),(133,8,'Cuyultitan'),(134,8,'El Rosario La Paz'),(135,8,'Jerusalen'),(136,8,'Mercedes La Ceiba'),(137,8,'Olocuilta'),(138,8,'Paraiso de Osorio'),(139,8,'San Antonio Masahuat'),(140,8,'San Emigdio'),(141,8,'San Francisco Chinameca'),(142,8,'San Pedro Masahuat'),(143,8,'San Juan Nonualco'),(144,8,'San Juan Talpa'),(145,8,'San Juan Tepezontes'),(146,8,'San Luis La Herradura'),(147,8,'San Luis Talpa'),(148,8,'San Miguel Tepezontes'),(149,8,'San Pedro Nonualco'),(150,8,'San Rafael Obrajuelo'),(151,8,'Santa Maria Ostuma'),(152,8,'Santiago Nonualco'),(153,8,'Tapalhuaca'),(154,9,'Cinquera'),(155,9,'Dolores'),(156,9,'Guacotecti'),(157,9,'Ilobasco'),(158,9,'Jutiapa'),(159,9,'San Isidro Cabañas'),(160,9,'Sensuntepeque'),(161,9,'Tejutepeque'),(162,9,'Victoria'),(163,10,'Apastepeque'),(164,10,'Guadalupe'),(165,10,'San Cayetano Istepeque'),(166,10,'San Esteban Catarina'),(167,10,'San Ildefonso'),(168,10,'San Lorenzo'),(169,10,'San Sebastian'),(170,10,'San Vicente'),(171,10,'Santa Clara'),(172,10,'Santo Domingo'),(173,10,'Tecoluca'),(174,10,'Tepetitan'),(175,10,'Verapaz'),(176,11,'Alegria'),(177,11,'Berlin'),(178,11,'California'),(179,11,'Concepcion Batres'),(180,11,'El Triunfo'),(181,11,'Ereguayquin'),(182,11,'Estanzuelas'),(183,11,'Jiquilisco'),(184,11,'Jucuapa'),(185,11,'Jucuaran'),(186,11,'Mercedes Umaña'),(187,11,'Nueva Granada'),(188,11,'Ozatlan'),(189,11,'Puerto El Triunfo'),(190,11,'San Agustin'),(191,11,'San Buenaventura'),(192,11,'San Dionisio'),(193,11,'San Francisco Javier'),(194,11,'Santa Elena'),(195,11,'Santa Maria'),(196,11,'Santiago de Maria'),(197,11,'Tecapan'),(198,11,'Usulutan'),(199,12,'Arambala'),(200,12,'Cacaopera'),(201,12,'Chilanga'),(202,12,'Corinto'),(203,12,'Delicias de Concepcion'),(204,12,'El Divisadero'),(205,12,'El Rosario Morazan'),(206,12,'Gualococti'),(207,12,'Guatajiagua'),(208,12,'Joateca'),(209,12,'Jocoaitique'),(210,12,'Jocoro'),(211,12,'Lolotiquillo'),(212,12,'Meanguera'),(213,12,'Osicala'),(214,12,'Perquin'),(215,12,'San Carlos'),(216,12,'San Fernando Morazan'),(217,12,'San Francisco Gotera'),(218,12,'San Isidro Morazan'),(219,12,'San Simon'),(220,12,'Sensembra'),(221,12,'Sociedad'),(222,12,'Torola'),(223,12,'Yamabal'),(224,12,'Yoloaiquin'),(225,13,'Carolina'),(226,13,'Chapeltique'),(227,13,'Chinameca'),(228,13,'Chirilagua'),(229,13,'Ciudad Barrios'),(230,13,'Comacaran'),(231,13,'El Transito'),(232,13,'Lolotique'),(233,13,'Moncagua'),(234,13,'Nueva Guadalupe'),(235,13,'Nuevo Eden de San Juan'),(236,13,'Quelepa'),(237,13,'San Antonio del Mosco'),(238,13,'San Gerardo'),(239,13,'San Jorge'),(240,13,'San Luis de la Reina'),(241,13,'San Miguel'),(242,13,'San Rafael Oriente'),(243,13,'Sesori'),(244,13,'Uluazapa'),(245,14,'La Union'),(246,14,'San Alejo'),(247,14,'Yucuaiquin'),(248,14,'Conchagua'),(249,14,'Intipuca'),(250,14,'San Jose'),(251,14,'El Carmen'),(252,14,'Yayantique'),(253,14,'Bolivar'),(254,14,'Meanguera del Golfo'),(255,14,'Santa Rosa de Lima'),(256,14,'Pasaquina'),(257,14,'Anamoros'),(258,14,'Nueva Esparta'),(259,14,'El Sauce'),(260,14,'Concepcion de Oriente'),(261,14,'Poloros'),(262,14,'Lislique');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombrepais` varchar(45) NOT NULL,
  `estatus` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Andorra',0),(2,'Emiratos Arabes Unidos',0),(3,'Afganistan',0),(4,'Antigua y Barbuda',0),(5,'Anguila',0),(6,'Albania',0),(7,'Armenia',0),(8,'Angola',0),(9,'Antartida',0),(10,'Argentina',0),(11,'Samoa Americana',0),(12,'Austria',0),(13,'Australia',0),(14,'Aruba',0),(15,'Azerbaiyan',0),(16,'Bosnia-Herzegovina',0),(17,'Barbados',0),(18,'Banglades',0),(19,'Belgica',0),(20,'Burkina Faso',0),(21,'Bulgaria',0),(22,'Bahrein',0),(23,'Burundi',0),(24,'Benin',0),(25,'San Bartolome',0),(26,'Bermudas',0),(27,'Brunei',0),(28,'Bolivia',0),(29,'Brasil',0),(30,'Las Bahamas',0),(31,'Butan',0),(32,'Isla Bouvet',0),(33,'Botsuana',0),(34,'Bielorrusia',0),(35,'Belice',0),(36,'Canada',0),(37,'Islas Cocos (Keeling)',0),(38,'Congo,  Republica Democratica del',0),(39,'Republica Centroafricana',0),(40,'Congo, Republica del',0),(41,'Suiza',0),(42,'Costa de Marfil',0),(43,'Islas Cook',0),(44,'Chile',0),(45,'Camerun',0),(46,'China',0),(47,'Colombia',0),(48,'Costa Rica',0),(49,'Cuba',0),(50,'Cabo Verde',0),(51,'Curacao',0),(52,'Isla de Navidad',0),(53,'Chipre',0),(54,'Republica Checa',0),(55,'Alemania',0),(56,'Yibuti',0),(57,'Dinamarca',0),(58,'Dominica',0),(59,'Republica Dominicana',0),(60,'Argelia',0),(61,'Ecuador',0),(62,'Estonia',0),(63,'Egipto',0),(64,'Sahara Occidental',0),(65,'Eritrea',0),(66,'Espana',0),(67,'Etiopia',0),(68,'Finlandia',0),(69,'Fiyi',0),(70,'Islas Malvinas-Falkland',0),(71,'Micronesia,  Estados Federados de',0),(72,'Islas Feroe',0),(73,'Francia',0),(74,'Francia',0),(75,'Gabon',0),(76,'Reino Unido',0),(77,'Granada',0),(78,'Georgia',0),(79,'Guayana Francesa',0),(80,'Guernsey',0),(81,'Ghana',0),(82,'Gibraltar',0),(83,'Groenlandia',0),(84,'Gambia',0),(85,'Guinea',0),(86,'Guadalupe',0),(87,'Guinea Ecuatorial',0),(88,'Grecia',0),(89,'Islas Georgia del Sur y Sandwich del Sur',0),(90,'Guatemala',0),(91,'Guam',0),(92,'Guinea-Bissau',0),(93,'Guyana',0),(94,'Hong Kong',0),(95,'Islas Heard y McDonald',0),(96,'Honduras',0),(97,'Croacia',0),(98,'Haiti',0),(99,'Hungria',0),(100,'Indonesia',0),(101,'Irlanda',0),(102,'Israel',0),(103,'Isla de Man',0),(104,'India',0),(105,'Territorio britanico del oceano indico',0),(106,'Iraq',0),(107,'Iran',0),(108,'Islandia',0),(109,'Italia',0),(110,'Jersey',0),(111,'Jamaica',0),(112,'Jordania',0),(113,'Japon',0),(114,'Kenia',0),(115,'Kirguistan',0),(116,'Camboya',0),(117,'Kiribati',0),(118,'Comoras',0),(119,'San Cristobal y Nieves',0),(120,'Corea del Norte',0),(121,'Corea del Sur',0),(122,'Kuwait',0),(123,'Islas Caiman',0),(124,'Kazajistan',0),(125,'Laos',0),(126,'Libano',0),(127,'Santa Lucia',0),(128,'Liechtenstein',0),(129,'Sri Lanka',0),(130,'Liberia',0),(131,'Lesoto',0),(132,'Lituania',0),(133,'Luxemburgo',0),(134,'Letonia',0),(135,'Libia',0),(136,'Marruecos',0),(137,'Monaco',0),(138,'Moldovia',0),(139,'Montenegro',0),(140,'Saint Martin',0),(141,'Madagascar',0),(142,'Islas Marshall',0),(143,'Macedonia',0),(144,'Mali',0),(145,'Burma',0),(146,'Mongolia',0),(147,'Macao',0),(148,'Islas Marianas del Norte',0),(149,'Martinica',0),(150,'Mauritania',0),(151,'Montserrat',0),(152,'Malta',0),(153,'Mauricio',0),(154,'Maldivas',0),(155,'Malaui',0),(156,'Mexico',0),(157,'Malasia',0),(158,'Mozambique',0),(159,'Namibia',0),(160,'Nueva Caledonia',0),(161,'Niger',0),(162,'Isla Norfolk',0),(163,'Nigeria',0),(164,'Nicaragua',0),(165,'Paises Bajos',0),(166,'Noruega',0),(167,'Nepal',0),(168,'Nauru',0),(169,'Niue',0),(170,'Nueva Zelanda',0),(171,'Oman',0),(172,'Panama',0),(173,'Peru',0),(174,'Polinesia Francesa',0),(175,'Papua Nueva Guinea',0),(176,'Filipinas',0),(177,'Pakistan',0),(178,'Polonia',0),(179,'San Pedro y Miguelon',0),(180,'Islas Pitcairn',0),(181,'Puerto Rico',0),(182,'Portugal',0),(183,'Palaos',0),(184,'Paraguay',0),(185,'Qatar',0),(186,'Reunion',0),(187,'Rumania',0),(188,'Serbia',0),(189,'Rusia',0),(190,'Ruanda',0),(191,'Arabia Saudita',0),(192,'Islas Salomon',0),(193,'Seychelles',0),(194,'Sudan',0),(195,'Suecia',0),(196,'Singapur',0),(197,'Santa Helena,  Ascension y Tristan de Acuna',0),(198,'Eslovenia',0),(199,'Svalbard',0),(200,'Eslovaquia',0),(201,'Sierra Leona',0),(202,'San Marino',0),(203,'Senegal',0),(204,'Somalia',0),(205,'Surinam',0),(206,'Sudan Sur',0),(207,'Santo Tome y Principe',0),(208,'El Salvador',1),(209,'Sint Maarten',0),(210,'Siria',0),(211,'Suazilandia',0),(212,'Islas Turcas y Caicos',0),(213,'Chad',0),(214,'Territorios Australes Franceses',0),(215,'Togo',0),(216,'Tailandia',0),(217,'Tayikistan',0),(218,'Tokelau',0),(219,'Timor Leste',0),(220,'Turkmenistan',0),(221,'Tunez',0),(222,'Tonga',0),(223,'Turquia',0),(224,'Trinidad y Tobago',0),(225,'Tuvalu',0),(226,'Taiwan',0),(227,'Tanzania',0),(228,'Ucrania',0),(229,'Uganda',0),(230,'Islas Ultramarinas menores de Estados Unidos',0),(231,'Estados Unidos',0),(232,'Uruguay',0),(233,'Uzbekistan',0),(234,'Santa Sede (Estado de la Ciudad del Vaticano)',0),(235,'San Vicente y las Granadinas',0),(236,'Venezuela',0),(237,'Islas Virgenes Britanicas',0),(238,'Islas Virgenes de los EE. UU.',0),(239,'Vietnam',0),(240,'Vanuatu',0),(241,'Islas Wallis y Futuna',0),(242,'Samoa',0),(243,'Kosovo',0),(244,'Yemen',0),(245,'Mayotte',0),(246,'Sudafrica',0),(247,'Zambia',0),(248,'Zimbabwe',0);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'ROLE_USER'),(2,2,'ROLE_ADMIN'),(3,9,'ROLE_NuevaPrueba'),(4,10,'ROLE_OPERADOR');
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
INSERT INTO `users` VALUES (1,'user','$2a$10$.Es50vZ.BJeRTjEzq/kNUOccsXg3pCsuncmEEaYivJk8Z16ytjRZW',_binary ''),(2,'admin','$2a$10$bUfKWC/OJhBeFaVDnkB.3uxRx1Oj1RYoLFjnzFju2svRJZ7e5uCCC',_binary ''),(9,'melvin','$2a$10$yTSilgZU/VjLfwfr.2Y.tO7YIOvPFFxzV6.R9Glchil11fvEgXrQK',_binary ''),(10,'fran','$2a$10$TkRR25f.H/2HpcDBmHBD1ulxKs8ZUsAYR8Le/IeS1.xKzqrDz6Edi',_binary ''),(12,'luis1','$2a$10$qtjf7H902jNvXaIxwd8bjOZAEhBVuubNI3QeT6LTKRwIAGrs5dq/i',_binary ''),(13,'pancho','$2a$10$k1e9rKfyRG9yWfCPpRQ1ke18WxJL8CiFwQUPmNH30//iXI/Z0SKeK',_binary ''),(14,'panchito','$2a$10$aPCzP/3KqEczd4vIunsHg.Ub.jd9WQW1OpS.6ZJ2BLm/Wu7.ESz0W',_binary '');
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

-- Dump completed on 2023-11-08 21:14:47
