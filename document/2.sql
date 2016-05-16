/*
SQLyog v10.2 
MySQL - 5.7.3-m13-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COMMENT='国家信息';

/*Data for the table `country` */

insert  into `country`(`Id`,`countryname`,`countrycode`) values (1,'Angola','AO'),(2,'Afghanistan','AF'),(3,'Albania','AL'),(4,'Algeria','DZ'),(5,'Andorra','AD'),(6,'Anguilla','AI'),(7,'Antigua and Barbuda','AG'),(8,'Argentina','AR'),(9,'Armenia','AM'),(10,'Australia','AU'),(11,'Austria','AT'),(12,'Azerbaijan','AZ'),(13,'Bahamas','BS'),(14,'Bahrain','BH'),(15,'Bangladesh','BD'),(16,'Barbados','BB'),(17,'Belarus','BY'),(18,'Belgium','BE'),(19,'Belize','BZ'),(20,'Benin','BJ'),(21,'Bermuda Is.','BM'),(22,'Bolivia','BO'),(23,'Botswana','BW'),(24,'Brazil','BR'),(25,'Brunei','BN'),(26,'Bulgaria','BG'),(27,'Burkina-faso','BF'),(28,'Burma','MM'),(29,'Burundi','BI'),(30,'Cameroon','CM'),(31,'Canada','CA'),(32,'Central African Republic','CF'),(33,'Chad','TD'),(34,'Chile','CL'),(35,'China','CN'),(36,'Colombia','CO'),(37,'Congo','CG'),(38,'Cook Is.','CK'),(39,'Costa Rica','CR'),(40,'Cuba','CU'),(41,'Cyprus','CY'),(42,'Czech Republic','CZ'),(43,'Denmark','DK'),(44,'Djibouti','DJ'),(45,'Dominica Rep.','DO'),(46,'Ecuador','EC'),(47,'Egypt','EG'),(48,'EI Salvador','SV'),(49,'Estonia','EE'),(50,'Ethiopia','ET'),(51,'Fiji','FJ'),(52,'Finland','FI'),(53,'France','FR'),(54,'French Guiana','GF'),(55,'Gabon','GA'),(56,'Gambia','GM'),(57,'Georgia','GE'),(58,'Germany','DE'),(59,'Ghana','GH'),(60,'Gibraltar','GI'),(61,'Greece','GR'),(62,'Grenada','GD'),(63,'Guam','GU'),(64,'Guatemala','GT'),(65,'Guinea','GN'),(66,'Guyana','GY'),(67,'Haiti','HT'),(68,'Honduras','HN'),(69,'Hongkong','HK'),(70,'Hungary','HU'),(71,'Iceland','IS'),(72,'India','IN'),(73,'Indonesia','ID'),(74,'Iran','IR'),(75,'Iraq','IQ'),(76,'Ireland','IE'),(77,'Israel','IL'),(78,'Italy','IT'),(79,'Jamaica','JM'),(80,'Japan','JP'),(81,'Jordan','JO'),(82,'Kampuchea (Cambodia )','KH'),(83,'Kazakstan','KZ'),(84,'Kenya','KE'),(85,'Korea','KR'),(86,'Kuwait','KW'),(87,'Kyrgyzstan','KG'),(88,'Laos','LA'),(89,'Latvia','LV'),(90,'Lebanon','LB'),(91,'Lesotho','LS'),(92,'Liberia','LR'),(93,'Libya','LY'),(94,'Liechtenstein','LI'),(95,'Lithuania','LT'),(96,'Luxembourg','LU'),(97,'Macao','MO'),(98,'Madagascar','MG'),(99,'Malawi','MW'),(100,'Malaysia','MY'),(101,'Maldives','MV'),(102,'Mali','ML'),(103,'Malta','MT'),(104,'Mauritius','MU'),(105,'Mexico','MX'),(106,'Moldova, Republic of','MD'),(107,'Monaco','MC'),(108,'Mongolia','MN'),(109,'Montserrat Is','MS'),(110,'Morocco','MA'),(111,'Mozambique','MZ'),(112,'Namibia','NA'),(113,'Nauru','NR'),(114,'Nepal','NP'),(115,'Netherlands','NL'),(116,'New Zealand','NZ'),(117,'Nicaragua','NI'),(118,'Niger','NE'),(119,'Nigeria','NG'),(120,'North Korea','KP'),(121,'Norway','NO'),(122,'Oman','OM'),(123,'Pakistan','PK'),(124,'Panama','PA'),(125,'Papua New Cuinea','PG'),(126,'Paraguay','PY'),(127,'Peru','PE'),(128,'Philippines','PH'),(129,'Poland','PL'),(130,'French Polynesia','PF'),(131,'Portugal','PT'),(132,'Puerto Rico','PR'),(133,'Qatar','QA'),(134,'Romania','RO'),(135,'Russia','RU'),(136,'Saint Lueia','LC'),(137,'Saint Vincent','VC'),(138,'San Marino','SM'),(139,'Sao Tome and Principe','ST'),(140,'Saudi Arabia','SA'),(141,'Senegal','SN'),(142,'Seychelles','SC'),(143,'Sierra Leone','SL'),(144,'Singapore','SG'),(145,'Slovakia','SK'),(146,'Slovenia','SI'),(147,'Solomon Is','SB'),(148,'Somali','SO'),(149,'South Africa','ZA'),(150,'Spain','ES'),(151,'Sri Lanka','LK'),(152,'St.Lucia','LC'),(153,'St.Vincent','VC'),(154,'Sudan','SD'),(155,'Suriname','SR'),(156,'Swaziland','SZ'),(157,'Sweden','SE'),(158,'Switzerland','CH'),(159,'Syria','SY'),(160,'Taiwan','TW'),(161,'Tajikstan','TJ'),(162,'Tanzania','TZ'),(163,'Thailand','TH'),(164,'Togo','TG'),(165,'Tonga','TO'),(166,'Trinidad and Tobago','TT'),(167,'Tunisia','TN'),(168,'Turkey','TR'),(169,'Turkmenistan','TM'),(170,'Uganda','UG'),(171,'Ukraine','UA'),(172,'United Arab Emirates','AE'),(173,'United Kiongdom','GB'),(174,'United States of America','US'),(175,'Uruguay','UY'),(176,'Uzbekistan','UZ'),(177,'Venezuela','VE'),(178,'Vietnam','VN'),(179,'Yemen','YE'),(180,'Yugoslavia','YU'),(181,'Zimbabwe','ZW'),(182,'Zaire','ZR'),(183,'AC','DM');

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` varchar(10) NOT NULL,
  `dname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`) values ('1','事业部'),('2','销售部'),('3','技术部');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `empno` varchar(10) NOT NULL,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(10) DEFAULT NULL,
  `mgr` varchar(10) DEFAULT NULL,
  `sal` varchar(10) DEFAULT NULL,
  `deptno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`empno`,`ename`,`job`,`mgr`,`sal`,`deptno`) values ('01','jacky','clerk','tom','1000','1'),('02','tom','clerk','','2000','1'),('03','jenny','sales','pretty','600','2'),('04','pretty','sales','','800','2'),('05','buddy','jishu','canndy','1000','3'),('06','canndy','jishu','','1500','3'),('07','biddy','clerk','','2000','1');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(20) DEFAULT NULL COMMENT '父级id',
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `level` int(20) DEFAULT NULL COMMENT '菜单级别',
  `scort` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`pid`,`name`,`level`,`scort`) values (1,NULL,'账户列表',0,',1'),(2,1,'修改手机号码',1,',1,2'),(3,NULL,'系统管理',0,',3'),(4,3,'管理员管理',1,',3,4'),(5,4,'菜单2-1-1',2,',3,4,5'),(6,1,'账户解冻',1,',1,6'),(7,1,'账户冻结',1,',1,7'),(8,3,'角色管理',1,',3,8');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`Email`,`phone`) values (1,'hejun','123',NULL,NULL,NULL),(3,'li','1',NULL,NULL,NULL);

/*Table structure for table `user login info` */

DROP TABLE IF EXISTS `user login info`;

CREATE TABLE `user login info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '登录名',
  `logindate` datetime DEFAULT NULL COMMENT '登录时间',
  `loginip` varchar(16) DEFAULT NULL COMMENT '登录IP',
  PRIMARY KEY (`Id`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录日志';

/*Data for the table `user login info` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
