-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 25. Mrz 2016 um 04:51
-- Server Version: 5.6.21
-- PHP-Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `integraid`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `friend_list`
--

CREATE TABLE IF NOT EXISTS `friend_list` (
  `uid` int(11) NOT NULL,
  `fid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `friend_list`
--

INSERT INTO `friend_list` (`uid`, `fid`) VALUES
(4, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `languages`
--

CREATE TABLE IF NOT EXISTS `languages` (
`lang_id` int(11) NOT NULL,
  `lang_name` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `languages`
--

INSERT INTO `languages` (`lang_id`, `lang_name`) VALUES
(1, 'german'),
(2, 'english'),
(3, 'arabic'),
(4, 'french');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `languages_competence`
--

CREATE TABLE IF NOT EXISTS `languages_competence` (
  `uid` int(11) NOT NULL,
  `language` varchar(50) NOT NULL,
  `skill` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `languages_competence`
--

INSERT INTO `languages_competence` (`uid`, `language`, `skill`) VALUES
(3, 'english', 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `language_target`
--

CREATE TABLE IF NOT EXISTS `language_target` (
  `uid` int(11) NOT NULL,
  `target_language` varchar(50) NOT NULL,
  `skill` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `language_target`
--

INSERT INTO `language_target` (`uid`, `target_language`, `skill`) VALUES
(4, 'arabic', 3);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `skill_levels`
--

CREATE TABLE IF NOT EXISTS `skill_levels` (
`skill_id` int(11) NOT NULL,
  `skill_level` int(11) NOT NULL,
  `describtion` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `skill_levels`
--

INSERT INTO `skill_levels` (`skill_id`, `skill_level`, `describtion`) VALUES
(1, 0, 'No competence in speech and write/read'),
(2, 1, 'Understanding a few words, no s'),
(3, 2, 'User is able to understand and to read a few words. He is not able to write.'),
(4, 3, 'User is able to read and understand the basics. He is able to write a bit'),
(6, 4, 'basic speech, no read and write'),
(7, 5, 'basic speech, few words in reading/writing'),
(8, 6, 'basic speech, basics in read/write'),
(9, 7, 'good speech and good read/write'),
(10, 8, 'very good speech and good read/write'),
(11, 9, 'Fluent speech and very good read/write');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`uid` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `surname` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `nickname` varchar(32) NOT NULL,
  `gender` varchar(11) NOT NULL,
  `age` varchar(5) NOT NULL,
  `email` varchar(32) NOT NULL,
  `encrypted_pw` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `users`
--

INSERT INTO `users` (`uid`, `unique_id`, `user_type`, `surname`, `name`, `nickname`, `gender`, `age`, `email`, `encrypted_pw`, `salt`, `created_at`) VALUES
(3, 'kjfsafasfsdf32as', 'student', 'Moritz', 'Rücker', 'Moriruec', 'male', '20-29', 'Moritzor@gmx.net', 'rewrewr4345r234r2', '892324as', '2016-03-03 00:00:00'),
(4, 'kjfsafasfsdf32as', 'tutor', 'Moritz', 'Rücker', 'Moriruec', 'male', '20-29', 'Moritzor@gmx.net', 'rewrewr4345r234r2', '892324as', '2016-03-03 00:00:00');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user_types`
--

CREATE TABLE IF NOT EXISTS `user_types` (
`type_id` int(11) NOT NULL,
  `type` varchar(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user_types`
--

INSERT INTO `user_types` (`type_id`, `type`) VALUES
(1, 'student'),
(2, 'tutor');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `friend_list`
--
ALTER TABLE `friend_list`
 ADD PRIMARY KEY (`uid`), ADD KEY `fid` (`fid`);

--
-- Indizes für die Tabelle `languages`
--
ALTER TABLE `languages`
 ADD PRIMARY KEY (`lang_name`), ADD KEY `lang_id` (`lang_id`);

--
-- Indizes für die Tabelle `languages_competence`
--
ALTER TABLE `languages_competence`
 ADD PRIMARY KEY (`uid`), ADD UNIQUE KEY `skill` (`skill`), ADD UNIQUE KEY `language` (`language`);

--
-- Indizes für die Tabelle `language_target`
--
ALTER TABLE `language_target`
 ADD PRIMARY KEY (`uid`), ADD UNIQUE KEY `target_language` (`target_language`,`skill`), ADD UNIQUE KEY `skill` (`skill`);

--
-- Indizes für die Tabelle `skill_levels`
--
ALTER TABLE `skill_levels`
 ADD PRIMARY KEY (`skill_level`), ADD KEY `skill_id` (`skill_id`);

--
-- Indizes für die Tabelle `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`uid`), ADD KEY `user_type` (`user_type`);

--
-- Indizes für die Tabelle `user_types`
--
ALTER TABLE `user_types`
 ADD PRIMARY KEY (`type`), ADD UNIQUE KEY `type_id` (`type_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `languages`
--
ALTER TABLE `languages`
MODIFY `lang_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `skill_levels`
--
ALTER TABLE `skill_levels`
MODIFY `skill_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT für Tabelle `users`
--
ALTER TABLE `users`
MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `user_types`
--
ALTER TABLE `user_types`
MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `friend_list`
--
ALTER TABLE `friend_list`
ADD CONSTRAINT `friend_list_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
ADD CONSTRAINT `friend_list_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `users` (`uid`);

--
-- Constraints der Tabelle `languages_competence`
--
ALTER TABLE `languages_competence`
ADD CONSTRAINT `languages_competence_ibfk_1` FOREIGN KEY (`skill`) REFERENCES `skill_levels` (`skill_level`),
ADD CONSTRAINT `languages_competence_ibfk_2` FOREIGN KEY (`language`) REFERENCES `languages` (`lang_name`),
ADD CONSTRAINT `languages_competence_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`);

--
-- Constraints der Tabelle `language_target`
--
ALTER TABLE `language_target`
ADD CONSTRAINT `language_target_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
ADD CONSTRAINT `language_target_ibfk_2` FOREIGN KEY (`skill`) REFERENCES `skill_levels` (`skill_level`),
ADD CONSTRAINT `language_target_ibfk_3` FOREIGN KEY (`target_language`) REFERENCES `languages` (`lang_name`);

--
-- Constraints der Tabelle `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_type`) REFERENCES `user_types` (`type`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
