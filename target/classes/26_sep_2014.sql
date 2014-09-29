-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: afsinergia
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `afsinergia`;
USE `afsinergia`;

--
-- Table structure for table `afst_cliente`
--

DROP TABLE IF EXISTS `afst_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_gpoemp` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `contacto` varchar(40) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `movil` varchar(15) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `fecha_alta` date DEFAULT '1000-01-01',
  `fecha_actualiza` date DEFAULT '1000-01-01',
  `fecha_baja` date DEFAULT '1000-01-01',
  PRIMARY KEY (`id_cliente`),
  KEY `fk_afst_cliente_afst_gpoemp1_idx` (`id_gpoemp`),
  CONSTRAINT `fk_afst_cliente_afst_gpoemp1` FOREIGN KEY (`id_gpoemp`) REFERENCES `afst_gpoemp` (`id_gpoemp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_cliente`
--

LOCK TABLES `afst_cliente` WRITE;
/*!40000 ALTER TABLE `afst_cliente` DISABLE KEYS */;
INSERT INTO `afst_cliente` VALUES (1,1,'Luis','aaaaaa ee','12345678','87654321','eee@aaaaaa.com.mx','1000-01-01','2014-09-22','1000-01-01'),(2,1,'Bimboo','pedro','5530265659','5510236984','pedro@prueba.com.mx','1000-01-01','2014-09-11','1000-01-01'),(3,1,'marinelaa','Peter Parker','5530265659','551023698472','pedro@prueba.com.mx','1000-01-01','2014-08-12','1000-01-01'),(4,1,'banorte','pedro','5530265659','551023698472','pedro@prueba.com.mx','1000-01-01','1000-01-01','1000-01-01'),(5,2,'lumen','maria','5556209146','5561892654','maria@loc.com.mx','1000-01-01','1000-01-01','1000-01-01'),(6,2,'farmacia','maria','5556209146','5561892654','maria@loc.com.mx','1000-01-01','1000-01-01','1000-01-01'),(8,3,'boing','maria','5556209146','5561892654','maria@loc.com.mx','1000-01-01','1000-01-01','1000-01-01'),(24,1,'Gamesa','Paquito','56139541','56139542','pso@prueba.com.mx','2014-09-22',NULL,NULL);
/*!40000 ALTER TABLE `afst_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_contrato`
--

DROP TABLE IF EXISTS `afst_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_contrato` (
  `id_contrato` int(11) NOT NULL AUTO_INCREMENT,
  `no_contrato` varchar(45) NOT NULL,
  `nom_contrato` varchar(45) NOT NULL,
  `inicio_contrato` date NOT NULL,
  `plazo` int(11) NOT NULL,
  `no_unidades` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_actualiza` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  UNIQUE KEY `no_contrato_UNIQUE` (`no_contrato`),
  KEY `fk_id_cliente_contrato_idx` (`id_cliente`),
  CONSTRAINT `fk_id_cliente_contrato` FOREIGN KEY (`id_cliente`) REFERENCES `afst_cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_contrato`
--

LOCK TABLES `afst_contrato` WRITE;
/*!40000 ALTER TABLE `afst_contrato` DISABLE KEYS */;
INSERT INTO `afst_contrato` VALUES (1,'xx13asdas','aaaaaaaaa','2014-07-22',6,0,1,NULL,NULL,NULL),(2,'mi contrato 1','bbbbbbb','2014-07-22',15,10,1,NULL,NULL,NULL),(3,'201491163314','Call center','2014-09-01',12,0,1,NULL,NULL,NULL),(4,'2014911131251','Unidades bimbo','2014-09-11',12,0,1,NULL,NULL,NULL),(5,'2014911133951','dossss','2014-09-11',12,0,2,NULL,NULL,NULL),(6,'201491114752','sdasdasdas1111','2014-09-11',6,0,3,NULL,NULL,NULL),(7,'2014911151245','coooooo','2014-09-11',6,0,1,NULL,NULL,NULL),(8,'201491115133','unidades banorte','2014-09-11',6,0,4,NULL,NULL,NULL),(9,'2014922125711','mi contratooooo','2014-09-22',30,0,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `afst_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_empresa`
--

DROP TABLE IF EXISTS `afst_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_actualiza` date NOT NULL DEFAULT '1000-01-01',
  `fecha_baja` date NOT NULL DEFAULT '1000-01-01',
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_empresa`
--

LOCK TABLES `afst_empresa` WRITE;
/*!40000 ALTER TABLE `afst_empresa` DISABLE KEYS */;
INSERT INTO `afst_empresa` VALUES (1,'afsinergia','wtc','1000-01-01','1000-01-01','1000-01-01'),(2,'traking','wtc','1000-01-01','1000-01-01','1000-01-01'),(3,'patito','wtc','1000-01-01','1000-01-01','1000-01-01'),(4,'grupo carso','wtc','1000-01-01','1000-01-01','1000-01-01'),(5,'telefonica','wtc','1000-01-01','1000-01-01','1000-01-01'),(6,'otra','la meche','1000-01-01','1000-01-01','1000-01-01');
/*!40000 ALTER TABLE `afst_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_flotilla`
--

DROP TABLE IF EXISTS `afst_flotilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_flotilla` (
  `id_flotilla` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `id_contrato` int(11) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_actualiza` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_flotilla`),
  KEY `fk_id_contrato_asft_flotilla_idx` (`id_contrato`),
  CONSTRAINT `fk_id_contrato_asft_flotilla` FOREIGN KEY (`id_contrato`) REFERENCES `afst_contrato` (`id_contrato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_flotilla`
--

LOCK TABLES `afst_flotilla` WRITE;
/*!40000 ALTER TABLE `afst_flotilla` DISABLE KEYS */;
INSERT INTO `afst_flotilla` VALUES (1,'Walmart',1,'2014-09-10','2014-09-10',NULL),(2,'ADO',1,'2014-09-10','2014-09-10',NULL),(3,'Esrella Blanca',1,'2014-09-10','2014-09-10',NULL),(4,'Bimbo',1,'2014-09-10','2014-09-10',NULL),(5,'Barcel',2,'2014-09-10',NULL,NULL),(6,'flotilla6',2,'2014-09-10',NULL,NULL),(7,'flotilla7',2,'2014-09-10',NULL,NULL),(8,'flotilla8',3,'2014-09-10',NULL,NULL),(9,'Gamesa',1,'2014-09-10','2014-09-10',NULL),(10,'Maxtor',7,'2014-09-11',NULL,NULL);
/*!40000 ALTER TABLE `afst_flotilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_gpoemp`
--

DROP TABLE IF EXISTS `afst_gpoemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_gpoemp` (
  `id_gpoemp` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `id_empp` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_actualiza` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_gpoemp`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`),
  KEY `fk_afst_gpoemp_afst_empresa1_idx` (`id_empresa`),
  KEY `fk_id_cliente_afst_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_afst_gpoemp_afst_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `afst_empresa` (`id_empresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_cliente_afst_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `afst_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_gpoemp`
--

LOCK TABLES `afst_gpoemp` WRITE;
/*!40000 ALTER TABLE `afst_gpoemp` DISABLE KEYS */;
INSERT INTO `afst_gpoemp` VALUES (1,1,'afsinergia',0,1,NULL,NULL,NULL),(2,2,'traking',1,2,NULL,NULL,NULL),(3,3,'patito',2,3,NULL,NULL,NULL),(4,4,'carso',1,4,NULL,NULL,NULL),(5,5,'telefonica',3,5,NULL,NULL,NULL),(6,6,'otra',0,6,NULL,NULL,NULL);
/*!40000 ALTER TABLE `afst_gpoemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_instalacion`
--

DROP TABLE IF EXISTS `afst_instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_instalacion` (
  `id_instalacion` int(11) NOT NULL AUTO_INCREMENT,
  `observacion` varchar(200) NOT NULL,
  `fecha_instalacion` date NOT NULL,
  `id_instalador` int(11) NOT NULL,
  `id_dispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id_instalacion`),
  KEY `fk_id_instalador_instalacion_idx` (`id_instalador`),
  KEY `fk_id_dispositivo_instalador_idx` (`id_dispositivo`),
  CONSTRAINT `fk_id_dispositivo_instalador` FOREIGN KEY (`id_dispositivo`) REFERENCES `dist_dispositivo` (`id_dispositivo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_instalador_instalacion` FOREIGN KEY (`id_instalador`) REFERENCES `afst_instalador` (`id_instalador`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_instalacion`
--

LOCK TABLES `afst_instalacion` WRITE;
/*!40000 ALTER TABLE `afst_instalacion` DISABLE KEYS */;
INSERT INTO `afst_instalacion` VALUES (1,'instalación correcta','2014-07-23',1,1);
/*!40000 ALTER TABLE `afst_instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afst_instalador`
--

DROP TABLE IF EXISTS `afst_instalador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afst_instalador` (
  `id_instalador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `paterno` varchar(45) NOT NULL,
  `materno` varchar(45) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_actualiza` date NOT NULL,
  `fecha_baja` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_instalador`),
  KEY `fk_id_cliente_cliente_idx` (`id_cliente`),
  CONSTRAINT `fk_id_cliente_instalador1` FOREIGN KEY (`id_cliente`) REFERENCES `afst_cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afst_instalador`
--

LOCK TABLES `afst_instalador` WRITE;
/*!40000 ALTER TABLE `afst_instalador` DISABLE KEYS */;
INSERT INTO `afst_instalador` VALUES (1,'Locadio','Perez','Prado','loc1920@gmail.com','2014-04-17','2014-04-17','2014-04-17',1);
/*!40000 ALTER TABLE `afst_instalador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disc_carrier`
--

DROP TABLE IF EXISTS `disc_carrier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disc_carrier` (
  `id_carrier` int(11) NOT NULL AUTO_INCREMENT,
  `nom_carrier` varchar(45) NOT NULL,
  `nom_apn` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_carrier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disc_carrier`
--

LOCK TABLES `disc_carrier` WRITE;
/*!40000 ALTER TABLE `disc_carrier` DISABLE KEYS */;
INSERT INTO `disc_carrier` VALUES (1,'TELCEL','internet.itelcel.com'),(2,'MOVISTAR','--'),(3,'IUSACELL','--');
/*!40000 ALTER TABLE `disc_carrier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disc_tipo_dispositivo`
--

DROP TABLE IF EXISTS `disc_tipo_dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disc_tipo_dispositivo` (
  `id_tipo_dispositivo` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `ficha_tecnica` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_dispositivo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disc_tipo_dispositivo`
--

LOCK TABLES `disc_tipo_dispositivo` WRITE;
/*!40000 ALTER TABLE `disc_tipo_dispositivo` DISABLE KEYS */;
INSERT INTO `disc_tipo_dispositivo` VALUES (1,'queclink','gv300','--');
/*!40000 ALTER TABLE `disc_tipo_dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dist_dispositivo`
--

DROP TABLE IF EXISTS `dist_dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dist_dispositivo` (
  `id_dispositivo` int(11) NOT NULL AUTO_INCREMENT,
  `id_contrato` int(11) NOT NULL,
  `id_sim` int(11) NOT NULL,
  `id_tipo_dispositivo` int(11) NOT NULL,
  `imei` varchar(17) NOT NULL,
  `fecha_alta` date NOT NULL DEFAULT '1000-01-01',
  `fecha_actualiza` date DEFAULT '1000-01-01',
  `fecha_baja` date DEFAULT '1000-01-01',
  PRIMARY KEY (`id_dispositivo`),
  UNIQUE KEY `id_sim_UNIQUE` (`id_sim`),
  UNIQUE KEY `imei_UNIQUE` (`imei`),
  KEY `fk_no_contrato_dispo_idx` (`id_contrato`),
  KEY `fk_id_sim_contrato_idx` (`id_sim`),
  KEY `fk_id_tipo_dispositivo_dispositivo_idx` (`id_tipo_dispositivo`),
  CONSTRAINT `fk_id_contrato_dispositivo` FOREIGN KEY (`id_contrato`) REFERENCES `afst_contrato` (`id_contrato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_sim_contrato` FOREIGN KEY (`id_sim`) REFERENCES `dist_sim` (`id_sim`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_tipo_dispositivo_dispositivo` FOREIGN KEY (`id_tipo_dispositivo`) REFERENCES `disc_tipo_dispositivo` (`id_tipo_dispositivo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dist_dispositivo`
--

LOCK TABLES `dist_dispositivo` WRITE;
/*!40000 ALTER TABLE `dist_dispositivo` DISABLE KEYS */;
INSERT INTO `dist_dispositivo` VALUES (1,1,1,1,'123455432113333','1000-01-01','2014-09-10','1000-01-01'),(2,1,2,1,'111112222233456','2014-09-01','2014-09-01',NULL),(3,1,3,1,'111112222233457','2014-09-01','1000-01-01','1000-01-01'),(4,1,4,1,'111112222233455','2014-09-01','2014-09-01','2014-09-01'),(5,1,5,1,'111112222233411','2014-09-01','2014-09-01','1000-01-01'),(6,1,6,1,'111112222233412','2014-09-01','2014-09-01','1000-01-01');
/*!40000 ALTER TABLE `dist_dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dist_operador`
--

DROP TABLE IF EXISTS `dist_operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dist_operador` (
  `id_operador` int(11) NOT NULL AUTO_INCREMENT,
  `id_unidad` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `paterno` varchar(45) NOT NULL,
  `materno` varchar(45) NOT NULL,
  `ini_jornada` time NOT NULL DEFAULT '00:00:00',
  `fin_jornada` time NOT NULL DEFAULT '00:00:00',
  `fecha_alta` date NOT NULL DEFAULT '1000-01-01',
  `fehca_actuliza` date NOT NULL DEFAULT '1000-01-01',
  `fecha_baja` date NOT NULL DEFAULT '1000-01-01',
  PRIMARY KEY (`id_operador`),
  KEY `fk_dist_operador_unit_unidad1_idx` (`id_unidad`),
  CONSTRAINT `fk_dist_operador_unit_unidad1` FOREIGN KEY (`id_unidad`) REFERENCES `unit_unidad` (`id_unidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dist_operador`
--

LOCK TABLES `dist_operador` WRITE;
/*!40000 ALTER TABLE `dist_operador` DISABLE KEYS */;
INSERT INTO `dist_operador` VALUES (1,1,'Ramiro','perez','lopez','01:00:00','01:00:00','1000-01-01','1000-01-01','1000-01-01'),(2,2,'Pancho','López','Nería','01:00:00','01:00:00','1000-01-01','1000-01-01','1000-01-01');
/*!40000 ALTER TABLE `dist_operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dist_plan`
--

DROP TABLE IF EXISTS `dist_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dist_plan` (
  `id_plan` int(11) NOT NULL AUTO_INCREMENT,
  `id_carrier` int(11) NOT NULL,
  `id_contrato` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `formato_sim` varchar(20) NOT NULL,
  `costo_sim` double NOT NULL,
  `nom_plan` varchar(45) NOT NULL,
  `vigencia_plan` date NOT NULL,
  `costo_plan` double NOT NULL,
  `datos` int(11) NOT NULL,
  `fecha_alta` date NOT NULL DEFAULT '0001-01-01',
  `fecha_actualiza` date NOT NULL DEFAULT '0001-01-01',
  `fecha_baja` date NOT NULL DEFAULT '0001-01-01',
  PRIMARY KEY (`id_plan`),
  KEY `fk_id_carrier_disc_carrier_idx` (`id_carrier`),
  KEY `fk_id_contrato_dist_contrato_idx` (`id_contrato`),
  CONSTRAINT `fk_id_carrier_disc_carrier` FOREIGN KEY (`id_carrier`) REFERENCES `disc_carrier` (`id_carrier`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_contrato_dist_contrato` FOREIGN KEY (`id_contrato`) REFERENCES `afst_contrato` (`id_contrato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dist_plan`
--

LOCK TABLES `dist_plan` WRITE;
/*!40000 ALTER TABLE `dist_plan` DISABLE KEYS */;
INSERT INTO `dist_plan` VALUES (1,1,1,'Telcel','estandar',100,'PLUS','2015-07-22',600,1024,'2014-07-22','2014-07-22','0000-00-00');
/*!40000 ALTER TABLE `dist_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dist_sim`
--

DROP TABLE IF EXISTS `dist_sim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dist_sim` (
  `id_sim` int(11) NOT NULL AUTO_INCREMENT,
  `id_plan` int(11) NOT NULL,
  `id_carrier` int(11) NOT NULL,
  `iccid` varchar(20) NOT NULL,
  `linea` varchar(15) NOT NULL,
  `fecha_activacion` date NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_baja` date DEFAULT '1000-01-01',
  PRIMARY KEY (`id_sim`),
  UNIQUE KEY `iccid_UNIQUE` (`iccid`),
  UNIQUE KEY `linea_UNIQUE` (`linea`),
  KEY `fk_id_carrier_sim_idx` (`id_plan`),
  KEY `fk_id_carier_dic_sim_idx` (`id_carrier`),
  CONSTRAINT `fk_id_carier_dic_sim` FOREIGN KEY (`id_carrier`) REFERENCES `disc_carrier` (`id_carrier`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_plan_sim` FOREIGN KEY (`id_plan`) REFERENCES `dist_plan` (`id_plan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dist_sim`
--

LOCK TABLES `dist_sim` WRITE;
/*!40000 ALTER TABLE `dist_sim` DISABLE KEYS */;
INSERT INTO `dist_sim` VALUES (1,1,1,'123451625341562531','65243561','2014-07-22','2014-07-22',NULL),(2,1,1,'123451625341562532','65243562','2014-07-22','2014-07-22',NULL),(3,1,1,'123451625341562533','65243563','2014-07-22','2014-07-22',NULL),(4,1,2,'123451625341562534','65243564','2014-07-22','2014-07-22',NULL),(5,1,2,'123451625341562535','65243565','2014-07-22','2014-07-22',NULL),(6,1,3,'123451625341562536','65243566','2014-07-22','2014-07-22',NULL),(7,1,3,'123451625341562537','65243567','2014-07-22','2014-07-22',NULL),(8,1,3,'123451625341562538','65243568','2014-07-22','2014-07-22',NULL);
/*!40000 ALTER TABLE `dist_sim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invc_fam_accesorio`
--

DROP TABLE IF EXISTS `invc_fam_accesorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invc_fam_accesorio` (
  `id_fam_accesorio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_actualiza` date NOT NULL,
  `fecha_baja` date NOT NULL,
  PRIMARY KEY (`id_fam_accesorio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invc_fam_accesorio`
--

LOCK TABLES `invc_fam_accesorio` WRITE;
/*!40000 ALTER TABLE `invc_fam_accesorio` DISABLE KEYS */;
INSERT INTO `invc_fam_accesorio` VALUES (1,'camaras','2014-07-22','0000-00-00','0000-00-00');
/*!40000 ALTER TABLE `invc_fam_accesorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invt_accesorio`
--

DROP TABLE IF EXISTS `invt_accesorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invt_accesorio` (
  `id_accesorio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `precio_unidad` double NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_actualiza` date NOT NULL,
  `fecha_baja` date NOT NULL,
  `id_fam_accesorio` int(11) NOT NULL,
  `id_dispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id_accesorio`),
  KEY `fk_id_fam_accesorio_accesorio_idx` (`id_fam_accesorio`),
  KEY `fk_id_unidad_accesorio_idx` (`id_dispositivo`),
  CONSTRAINT `fk_id_dispositivo_accesorio` FOREIGN KEY (`id_dispositivo`) REFERENCES `dist_dispositivo` (`id_dispositivo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_fam_accesorio_accesorio` FOREIGN KEY (`id_fam_accesorio`) REFERENCES `invc_fam_accesorio` (`id_fam_accesorio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invt_accesorio`
--

LOCK TABLES `invt_accesorio` WRITE;
/*!40000 ALTER TABLE `invt_accesorio` DISABLE KEYS */;
INSERT INTO `invt_accesorio` VALUES (1,'camara','201','Minoalta',1000,'2014-07-22','0000-00-00','0000-00-00',1,1);
/*!40000 ALTER TABLE `invt_accesorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invt_lote`
--

DROP TABLE IF EXISTS `invt_lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invt_lote` (
  `id_lote` int(11) NOT NULL AUTO_INCREMENT,
  `cant_prod` int(11) NOT NULL,
  `num_factura` varchar(15) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `id_accesorio` int(11) NOT NULL,
  PRIMARY KEY (`id_lote`),
  UNIQUE KEY `num_factura_UNIQUE` (`num_factura`),
  KEY `fk_id_accesorio_lote_idx` (`id_accesorio`),
  CONSTRAINT `fk_id_accesorio_lote` FOREIGN KEY (`id_accesorio`) REFERENCES `invt_accesorio` (`id_accesorio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invt_lote`
--

LOCK TABLES `invt_lote` WRITE;
/*!40000 ALTER TABLE `invt_lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `invt_lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptlc_funcion`
--

DROP TABLE IF EXISTS `ptlc_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptlc_funcion` (
  `id_fun` int(11) NOT NULL AUTO_INCREMENT,
  `nom_fun` varchar(30) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `url_controlador` varchar(100) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `icono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_fun`),
  UNIQUE KEY `url_controlador_UNIQUE` (`url_controlador`),
  KEY `fk_ptlc_funcion_ptlc_modulo1_idx` (`id_modulo`),
  CONSTRAINT `fk_ptlc_funcion_ptlc_modulo1` FOREIGN KEY (`id_modulo`) REFERENCES `ptlc_modulo` (`id_modulo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptlc_funcion`
--

LOCK TABLES `ptlc_funcion` WRITE;
/*!40000 ALTER TABLE `ptlc_funcion` DISABLE KEYS */;
INSERT INTO `ptlc_funcion` VALUES (1,'Clientes','1','getClientes',1,'fa fa-usd'),(2,'Contratos','1','getContratos',1,'fa fa-file-text-o'),(7,'Usuarios','1','getUsuarios',1,'fa fa-user'),(8,'Grupos de usuarios','1','getGruposUsuarios',1,'fa fa-users'),(9,'Dispositivos de rastreo','1','getDispositivos',1,'fa fa-arrows'),(10,'Unidades','1','getUnidades',1,'fa fa-car'),(11,'Flotillas','1','getFlotillas',1,'fa fa-truck'),(12,'Instaladores','1','getInstaladores',1,'fa fa-male');
/*!40000 ALTER TABLE `ptlc_funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptlc_modulo`
--

DROP TABLE IF EXISTS `ptlc_modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptlc_modulo` (
  `id_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `nom_mod` varchar(30) NOT NULL,
  `id_prod` int(11) NOT NULL,
  PRIMARY KEY (`id_modulo`),
  KEY `fk_ptlc_modulo_ptlc_producto1_idx` (`id_prod`),
  CONSTRAINT `fk_ptlc_modulo_ptlc_producto1` FOREIGN KEY (`id_prod`) REFERENCES `ptlc_producto` (`id_prod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptlc_modulo`
--

LOCK TABLES `ptlc_modulo` WRITE;
/*!40000 ALTER TABLE `ptlc_modulo` DISABLE KEYS */;
INSERT INTO `ptlc_modulo` VALUES (1,'Alta',1),(2,'Crear',2);
/*!40000 ALTER TABLE `ptlc_modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptlc_producto`
--

DROP TABLE IF EXISTS `ptlc_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptlc_producto` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_actualiza` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptlc_producto`
--

LOCK TABLES `ptlc_producto` WRITE;
/*!40000 ALTER TABLE `ptlc_producto` DISABLE KEYS */;
INSERT INTO `ptlc_producto` VALUES (1,'basico',NULL,NULL,NULL),(2,'intermedio',NULL,NULL,NULL),(3,'plus',NULL,NULL,NULL),(4,'basico',NULL,NULL,NULL),(5,'basico',NULL,NULL,NULL),(6,'basico',NULL,NULL,NULL),(7,'plus',NULL,NULL,NULL),(8,'plus',NULL,NULL,NULL),(9,'plus',NULL,NULL,NULL);
/*!40000 ALTER TABLE `ptlc_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptlr_prod_cont`
--

DROP TABLE IF EXISTS `ptlr_prod_cont`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptlr_prod_cont` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `id_contrato` int(11) NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_baja` date NOT NULL,
  `vigencia` date NOT NULL,
  PRIMARY KEY (`id_prod`,`id_contrato`),
  KEY `fk_id_contrato_prod_cont_idx` (`id_contrato`),
  CONSTRAINT `fk_id_contrato_prod_cont` FOREIGN KEY (`id_contrato`) REFERENCES `afst_contrato` (`id_contrato`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_producto_prod_cont` FOREIGN KEY (`id_prod`) REFERENCES `ptlc_producto` (`id_prod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptlr_prod_cont`
--

LOCK TABLES `ptlr_prod_cont` WRITE;
/*!40000 ALTER TABLE `ptlr_prod_cont` DISABLE KEYS */;
INSERT INTO `ptlr_prod_cont` VALUES (1,1,'2014-07-22','0000-00-00','2015-07-22');
/*!40000 ALTER TABLE `ptlr_prod_cont` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptlt_privilegio`
--

DROP TABLE IF EXISTS `ptlt_privilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ptlt_privilegio` (
  `id_privilegio` int(11) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `id_fun` int(11) NOT NULL,
  `id_gpousu` int(11) NOT NULL,
  `alta` varchar(1) DEFAULT '0',
  `baja` varchar(1) DEFAULT '0',
  `cambio` varchar(1) DEFAULT '0',
  `consulta` varchar(1) DEFAULT '0',
  PRIMARY KEY (`id_privilegio`),
  KEY `fk_id_modulo_idx` (`id_modulo`),
  KEY `fk_id_fun_idx` (`id_fun`),
  KEY `fk_id_gpousu_idx` (`id_gpousu`),
  CONSTRAINT `fk_id_fun` FOREIGN KEY (`id_fun`) REFERENCES `ptlc_funcion` (`id_fun`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_gpousu` FOREIGN KEY (`id_gpousu`) REFERENCES `usut_gpousu` (`id_gpousu`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_modulo` FOREIGN KEY (`id_modulo`) REFERENCES `ptlc_modulo` (`id_modulo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptlt_privilegio`
--

LOCK TABLES `ptlt_privilegio` WRITE;
/*!40000 ALTER TABLE `ptlt_privilegio` DISABLE KEYS */;
INSERT INTO `ptlt_privilegio` VALUES (0,1,12,1,'1','1','1','0'),(1,1,1,1,'1','0',NULL,'1'),(2,1,7,1,'0','1','1','0'),(3,2,2,1,'0','1','1','0'),(6,1,8,1,'1','1','1','1'),(7,1,1,2,'0','0','0','0'),(8,1,2,2,'1','1','1','1'),(9,1,9,1,'1','0','0','0'),(10,1,10,1,'1','1','1','1'),(11,1,11,1,'0','0','0','1');
/*!40000 ALTER TABLE `ptlt_privilegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_usuarios_roles`
--

DROP TABLE IF EXISTS `rel_usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rel_usuarios_roles` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `fk_id_rol_usut_rol_idx` (`id_rol`),
  CONSTRAINT `fk_id_rol_usut_rol` FOREIGN KEY (`id_rol`) REFERENCES `usut_rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_usuario_usut_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usut_usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_usuarios_roles`
--

LOCK TABLES `rel_usuarios_roles` WRITE;
/*!40000 ALTER TABLE `rel_usuarios_roles` DISABLE KEYS */;
INSERT INTO `rel_usuarios_roles` VALUES (2,1),(8,1);
/*!40000 ALTER TABLE `rel_usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unic_tipo_unidad`
--

DROP TABLE IF EXISTS `unic_tipo_unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unic_tipo_unidad` (
  `id_tipo_unidad` int(11) NOT NULL AUTO_INCREMENT,
  `nom_unidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unic_tipo_unidad`
--

LOCK TABLES `unic_tipo_unidad` WRITE;
/*!40000 ALTER TABLE `unic_tipo_unidad` DISABLE KEYS */;
INSERT INTO `unic_tipo_unidad` VALUES (0,'Selecciona una'),(1,'Vehiculo'),(2,'Movil'),(3,'Objeto'),(4,'Persona');
/*!40000 ALTER TABLE `unic_tipo_unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit_unidad`
--

DROP TABLE IF EXISTS `unit_unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit_unidad` (
  `id_unidad` int(11) NOT NULL AUTO_INCREMENT,
  `id_dispositivo` int(11) NOT NULL,
  `id_flotilla` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `foto` varchar(100) DEFAULT 'no unidad',
  `placas` varchar(20) DEFAULT NULL,
  `motor` varchar(30) DEFAULT NULL,
  `color` varchar(30) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `no_puertas` int(11) DEFAULT '0',
  `anio` varchar(4) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `cap_combustible` double DEFAULT '0',
  `foto_t_circulacion` varchar(100) DEFAULT NULL,
  `ondometro` int(11) DEFAULT '0',
  `cap_carga` double DEFAULT NULL,
  `no_poliza` varchar(20) DEFAULT NULL,
  `ven_poliza` date DEFAULT '1000-01-01',
  `genero` varchar(1) DEFAULT '',
  `car_especial` varchar(220) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT '1000-01-01',
  `proporcion` varchar(45) DEFAULT NULL,
  `tecnologia_cel` varchar(45) DEFAULT NULL,
  `fecha_alta` date NOT NULL DEFAULT '1000-01-01',
  `fecha_actualiza` date DEFAULT '1000-01-01',
  `fecha_baja` date DEFAULT '1000-01-01',
  `id_tipo_unidad` int(11) NOT NULL,
  PRIMARY KEY (`id_unidad`),
  UNIQUE KEY `id_dispositivo_UNIQUE` (`id_dispositivo`),
  KEY `fk_unit_unidad_dist_dispositivo1_idx` (`id_dispositivo`),
  KEY `fk_unit_unidad_afst_flotilla1_idx` (`id_flotilla`),
  KEY `fk_id_tipo_unidad_unidad_idx` (`id_tipo_unidad`),
  CONSTRAINT `fk_id_tipo_unidad_unic_tipo_unidad1` FOREIGN KEY (`id_tipo_unidad`) REFERENCES `unic_tipo_unidad` (`id_tipo_unidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_unit_unidad_afst_flotilla1` FOREIGN KEY (`id_flotilla`) REFERENCES `afst_flotilla` (`id_flotilla`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_unit_unidad_dist_dispositivo1` FOREIGN KEY (`id_dispositivo`) REFERENCES `dist_dispositivo` (`id_dispositivo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit_unidad`
--

LOCK TABLES `unit_unidad` WRITE;
/*!40000 ALTER TABLE `unit_unidad` DISABLE KEYS */;
INSERT INTO `unit_unidad` VALUES (1,1,1,'Ford lobo 2015','no unidad','KADAD_12321','asdadá','asasdasd','saasd',0,'2010','ASADASD',0,'null',0,0,'101112','2016-08-31','0','chocada del faro delantero derecho.','2014-09-03','','','2014-09-03','2014-09-10','1000-01-01',1),(2,2,2,'Dragonn','no unidad',NULL,NULL,NULL,'xperia',0,NULL,'sony ericsson',0,NULL,0,NULL,NULL,'1000-01-01','0','negro','1000-01-01',NULL,'gsm','2014-09-03','2014-09-09','1000-01-01',2),(7,3,3,'Matias Carrillo',NULL,'','','','',NULL,'','',NULL,NULL,NULL,NULL,'',NULL,'1','Despistado','2000-12-21','','','2014-09-08','2014-09-09',NULL,4),(17,4,1,'cha cha cha',NULL,'','','','',NULL,'','',NULL,NULL,NULL,NULL,'',NULL,NULL,'que rico cha cha',NULL,'grande.....','','2014-09-22','2014-09-22',NULL,3);
/*!40000 ALTER TABLE `unit_unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usut_gpousu`
--

DROP TABLE IF EXISTS `usut_gpousu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usut_gpousu` (
  `id_gpousu` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `id_contrato` int(11) NOT NULL,
  `fecha_alta` date DEFAULT '1000-01-01',
  `fecha_actualiza` date DEFAULT '1000-01-01',
  `fecha_baja` date DEFAULT '1000-01-01',
  PRIMARY KEY (`id_gpousu`),
  KEY `fk_id_cliente__idx` (`id_contrato`),
  CONSTRAINT `fk_id_contrato_usut_gpousu` FOREIGN KEY (`id_contrato`) REFERENCES `afst_contrato` (`id_contrato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usut_gpousu`
--

LOCK TABLES `usut_gpousu` WRITE;
/*!40000 ALTER TABLE `usut_gpousu` DISABLE KEYS */;
INSERT INTO `usut_gpousu` VALUES (1,'admiinGpos.',1,'2014-12-12','2014-09-10',NULL),(2,'usuario.',1,'2014-12-12','2014-09-10',NULL),(3,'Call center',1,NULL,NULL,NULL),(4,'clie. 2 contr.5',5,NULL,'2014-09-11',NULL);
/*!40000 ALTER TABLE `usut_gpousu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usut_rol`
--

DROP TABLE IF EXISTS `usut_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usut_rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nom_rol` varchar(20) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usut_rol`
--

LOCK TABLES `usut_rol` WRITE;
/*!40000 ALTER TABLE `usut_rol` DISABLE KEYS */;
INSERT INTO `usut_rol` VALUES (1,'Amin'),(2,'User');
/*!40000 ALTER TABLE `usut_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usut_usuario`
--

DROP TABLE IF EXISTS `usut_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usut_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_gpousu` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'ACTIVE',
  `nombre` varchar(45) NOT NULL,
  `ape_pat` varchar(45) NOT NULL,
  `ape_mat` varchar(45) NOT NULL,
  `fecha_alta` date DEFAULT '1000-01-01',
  `fecha_actualiza` date DEFAULT '1000-01-01',
  `fecha_baja` date DEFAULT '1000-01-01',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_usut_usuario_usut_gpousu1_idx` (`id_gpousu`),
  CONSTRAINT `fk_usut_usuario_usut_gpousu1` FOREIGN KEY (`id_gpousu`) REFERENCES `usut_gpousu` (`id_gpousu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usut_usuario`
--

LOCK TABLES `usut_usuario` WRITE;
/*!40000 ALTER TABLE `usut_usuario` DISABLE KEYS */;
INSERT INTO `usut_usuario` VALUES (2,2,'nemesis','nemesis','ACTIVE','Shinji','Mikami','Biohazard',NULL,'2014-09-10',NULL),(8,1,'gokuuu','goku','ACTIVE','Akira','toriyama','Nagoyato',NULL,'2014-09-22',NULL),(15,1,'gohand.','gohan','ACTIVE','son','gohanda','takakahyi','2014-08-25','2014-09-10',NULL),(16,2,'el santo','123456','INACTIVE','Peter ','lllll','lllll','2014-08-26','2014-08-27',NULL),(17,3,'user3','us3r','INACTIVE','fuiii','sss','ooo','2014-09-11','2014-09-11',NULL),(18,3,'aaaaaaaaaaa','1111111','ACTIVE','aaaaa','qqqqq','qqqqq','2014-09-11',NULL,NULL);
/*!40000 ALTER TABLE `usut_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-26 15:06:29
