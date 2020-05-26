CREATE DATABASE  IF NOT EXISTS `tp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tp`;
-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 0.0.0.0    Database: tp
-- ------------------------------------------------------
-- Server version	5.7.29

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

--
-- Table structure for tables `Card` and `User`
--

DROP TABLE IF EXISTS `Card`;
DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` longtext,
  `family` varchar(150) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `energy` int(11) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `defence` int(11) DEFAULT NULL,
  `imgUrl` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for tables `Card` and `User`
--

LOCK TABLES `Card` WRITE;
/*!40000 ALTER TABLE `Card` DISABLE KEYS */;
INSERT INTO `Card` VALUES (1,'superman','Super hero','DC',100,100,50,10,'http://fairedesgifs.free.fr/da/sh/superman/superman%20(5).gif'),(2,'batman','SupeHero','DC',50,50,30,30,'http://fairedesgifs.free.fr/da/sh/batman/batman%20(24).gif'),(3,'DeadPool','Le passé exact de Deadpool reste flou, plusieurs versions de son passé s\'étant succédé.\n\nConnu sous le nom de Wade Wilson, il perd son père à l\'âge de 5 ans. Une autre version veut que son père l\'ait abandonné jeune. La plupart des versions relatent une enfance difficile. Cependant, la version la plus récente veut que ses parents aient toujours été en vie et qu\'il ait eu une enfance normale.\n\nDès ses 19 ans, il travaille en tant qu\'assassin pour une cellule secrète de la CIA, n\'acceptant que les missions auxquelles il croit, sans désir d’amasser une quelconque somme d\'argent. Ne voyant que très rarement sa femme, il décide de la quitter lorsqu\'il apprend qu\'il a un cancer, ne voulant pas la voir souffrir. Se sachant condamné par de multiples tumeurs, il accepte de servir de cobaye au Département K Canadien dans le cadre du projet Arme X. L\'expérience échoue et, considéré comme un rebut, il sert de cobaye au professeur Killbrew qui, par jeu et par plaisir sadique, le dote du même pouvoir d\'auto-guérison (facteur auto-guérisseur) que le mutant Wolverine, un de ses principaux ennemis qui, plus tard, deviendra son ami. L\'expérience réussit mais détruit sa peau, qui prend un aspect rongé et craquelé. Pendant cette période, les expériences de mort imminente qu\'il vit lui permettent de rencontrer la Mort elle-même, dont il tombe amoureux. Dans cet institut, son seul ami est tué par Ajax, un assistant de Killbrew, après que Deadpool se fut moqué de son nom, « Francis ». Ajax arrache alors le cœur de Deadpool pour le tuer, mais celui-ci, dans un instinct de vengeance, le fait repousser et part se venger.\n\nIl prend alors le nom de Deadpool (littéralement, la « cagnotte du mort » en français), en référence au jeu pratiqué par les gardiens du Département K qui misaient sur le prochain patient à mourir, Wilson se présentant alors ironiquement comme « le roi de la Deadpool ». Après son évasion du Département K, il reprend son activité passée de mercenaire. ','MARVEL',100,100,10,50,'http://fairedesgifs.free.fr/da/sh/deadpool/dp%20(18).gif'),(4,'Hulk','Le docteur Bruce Banner, un brillant physicien nucléaire, crée pour les forces armées des États-Unis un nouveau type d\'arme nucléaire, la bombe G, basée sur des rayons gamma.\n\nDurant un essai, Banner aperçoit un adolescent, Rick Jones, allongé dans sa voiture, qui répond bêtement à un pari de ses camarades. Demandant à son assistant Igor Starsky de stopper le compte à rebours, le physicien court vers la zone d\'essai et sauve le jeune inconscient en le poussant dans une tranchée de protection. Mais Starsky, qui se nomme en réalité Drenkov, est un espion russe à la solde du gouvernement envoyé pour s\'emparer des secrets de Banner. Il laisse la bombe exploser. Le docteur n\'a pas le temps de se mettre à l\'abri ; il est alors bombardé de rayons gamma, ce qui a pour effet de modifier profondément son ADN, mais qui, à la surprise de tous, ne le tue pas12,13.\n\nBanner reste en observation à l\'infirmerie en compagnie de Rick Jones jusqu\'au soir où Banner, dans une intense souffrance, voit son corps se transformer en un individu aux proportions colossales tandis que sa peau devient grise et que son psychisme se modifie pour adopter une intelligence quasi animale. Dans cet état, il détruit le mur de l\'infirmerie simplement en le poussant de la main puis, lorsqu\'une jeep de l\'armée lui fonce dessus, reste immobile alors que le véhicule s\'écrase sur lui sans qu\'il subisse de dommages, démontrant ainsi posséder une force et une résistance stupéfiante. En raison de sa corpulence, un garde le surnomme « Hulk »12 lors d\'une description faite à ses supérieursa.\n\nDepuis, lors de moments de stress ou de colère intense, le docteur Banner se métamorphose en une créature colossale à la peau verte (cette couleur ayant rapidement remplacé la peau grise originale) dotée d\'une force phénoménale et animée par une rage qu\'il ne parvient pas à contrôler (cette rage est présente en Banner depuis sa jeunesse quand, petit garçon, il est battu par son père et quand il vit sa mère mourir sous les coups de ce dernier). ','MARVEL',200,100,50,5,'http://fairedesgifs.free.fr/da/sh/hulk/hulk%20(3).gif');
/*!40000 ALTER TABLE `Card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-07  7:53:43