# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.25)
# Database: 5han
# Generation Time: 2020-01-26 08:38:47 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table contributor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `contributor`;

CREATE TABLE `contributor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `item_type` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `full_content` varchar(255) DEFAULT NULL,
  `publish_date` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `topic_status` varchar(255) DEFAULT NULL,
  `urgency_rating` varchar(255) DEFAULT NULL,
  `verify_status` varchar(255) DEFAULT NULL,
  `publish_date_epoch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table demand
# ------------------------------------------------------------

DROP TABLE IF EXISTS `demand`;

CREATE TABLE `demand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `item_type` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `full_content` varchar(255) DEFAULT NULL,
  `publish_date` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `topic_status` varchar(255) DEFAULT NULL,
  `urgency_rating` varchar(255) DEFAULT NULL,
  `verify_status` varchar(255) DEFAULT NULL,
  `publish_date_epoch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table fakenews
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fakenews`;

CREATE TABLE `fakenews` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `item_type` varchar(255) DEFAULT NULL,
  `pic` longtext,
  `title` varchar(255) DEFAULT NULL,
  `full_content` varchar(255) DEFAULT NULL,
  `publish_date` varchar(255) DEFAULT NULL,
  `publish_date_epoch_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
