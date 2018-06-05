-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 05 juin 2018 à 06:37
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `GetMapbyId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetMapbyId` (`ID` INT)  BEGIN 
SELECT Maps_content 
FROM maps
WHERE Id_maps=ID;
End$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `maps`
--

DROP TABLE IF EXISTS `maps`;
CREATE TABLE IF NOT EXISTS `maps` (
  `Id_maps` int(11) NOT NULL AUTO_INCREMENT,
  `Maps_content` varchar(9978) NOT NULL,
  PRIMARY KEY (`Id_maps`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `maps`
--

INSERT INTO `maps` (`Id_maps`, `Maps_content`) VALUES
(1, '  OO---------------O OO     1          IOO               @ IO   O- -----O1O O--OI                  II     O--  ---O--O II               A  II   O-------O1I O--OI               Q  IO     O-- ---OO--O II               1  YO---O--------O-----O'),
(2, '      O-O---------O    O--O1I         OO   I 1  I        @ IO--O    I   1      II 1 O---O-------O  OI1                 YI 1 O --O---O   A  OO--O  Q I   1      I   I 1  I          I   O--O1I         OO      O-O---------O                     '),
(3, 'O-----O--------O--O I     O 1  1 OO   IOI                @IOI            O----IOI   O   OO        IOI OOO      OO     IOOOO      Q      AOIOI  1   O        OOIOI 1  OOO     OO  OOOI1  OO        OO   OO---O----------OO YOOOOOOOOOOOOOOOOOOOO '),
(4, '  O--O-----------O   OO              OO OO               @OOI  O-O  OO-OO  O-O-II         I        II         I        II         O     A  II              IO YII  O--O O-O   O-OO IO Q                O OO              OO   O--------------O  '),
(5, 'O------------------OI                 YII O-O   O-O      @ II                  II         O-------OII                  II     O-O 1 O-O A  II                  II       O-O 1 O-O  II                  IIQ        O-O 1 O--OO---------O O---O   ');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
