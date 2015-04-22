-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2014 at 01:41 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tsuih`
--
CREATE DATABASE IF NOT EXISTS `tsuih` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tsuih`;

-- --------------------------------------------------------

--
-- Table structure for table `post_table`
--

CREATE TABLE IF NOT EXISTS `post_table` (
  `postNumber` int(10) NOT NULL AUTO_INCREMENT,
  `idNumber` varchar(15) NOT NULL,
  `postType` varchar(50) NOT NULL,
  `postTitle` varchar(150) NOT NULL,
  `message` varchar(1500) NOT NULL,
  `viewer` varchar(100) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`postNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=52 ;

--
-- Dumping data for table `post_table`
--

INSERT INTO `post_table` (`postNumber`, `idNumber`, `postType`, `postTitle`, `message`, `viewer`, `datetime`) VALUES
(31, '', 'Announcement', 'for all students', 'this is an announcement for all students only', 'All Students', '2014-03-01 05:45:51'),
(32, '2014', 'Memo', 'New Memo', 'New Memo For All, Posted By 2014', 'All', '2014-03-02 17:47:37'),
(33, '2014', 'Date of Graduation', 'CCS Graduation', 'Event: April 2014', 'All Students of CCS', '2014-03-02 18:01:03'),
(34, '2014', 'Announcement', 'Latest Annoucment for All', 'This messageis for all..', 'All', '2014-03-03 08:08:43'),
(35, '2014', 'Announcement', 'for all students only', 'this message is for students only.', 'All Students', '2014-03-03 17:50:53'),
(36, '2014', 'Announcement', 'this is for ccs first year', 'for ccs 1st year only', '1st Year Students of CCS', '2014-03-04 03:06:19'),
(37, '2014', 'Announcement', 'Schedule', 'Final Exam for graduating Students will be on March 13, 14 2014', '4th Year Students of CCS', '2014-03-04 05:25:59'),
(38, '2014', 'Memo', 'Attention', 'All CCS Faculty will have a seminar in Tacloban on March 15 2014', 'Faculty of CCS', '2014-03-04 05:31:07'),
(39, '2014', 'May Pasok Ba?', 'Urgent ', 'No classes on March 17 2014 due to the bad weather', 'All', '2014-03-04 05:35:45'),
(40, '2014', 'Upcoming Events', 'Intrams Schedule', 'September 19 to 23 Intrams Schedule', 'All', '2014-03-04 05:38:03'),
(41, '2014', 'Date of Graduation', 'All 4th year CCS', 'May 20 2014 CCS Graduation from 9AM to 3PM ', '4th Year Students of CCS', '2014-03-04 05:42:56'),
(42, '2014', 'Announcement', 'Final Exam', 'Final Exam for graduating students will be on march 14-17 ', 'All Students', '2014-03-04 14:57:15'),
(43, '2014', 'Date of Graduation', 'Graduation Schedule', 'Schedule of Graduation for 4th year students will be on may ', 'All Students', '2014-03-04 15:03:45'),
(44, '2014', 'Date of Graduation', 'all', 'all ccs', 'All Students of CCS', '2014-03-04 15:33:39'),
(45, '2014', 'Date of Graduation', 'asdf', 'asdf', 'All', '2014-03-04 15:45:37'),
(46, '2014', 'Upcoming Events', 'asdf', 'asdf', 'All Students', '2014-03-04 16:13:00'),
(47, '2014', 'May Pasok Ba?', 'asdfasdf', 'asdfasdfasdf', 'All', '2014-03-04 16:13:35'),
(48, '2014', 'Memo', 'mmmmmmmmmmmm', 'mmmmmmmmmm', 'All Students', '2014-03-04 16:14:50'),
(49, '2014', 'Whats New?', 'what?', 'asfsadf', 'All', '2014-03-04 16:17:13'),
(50, '2014', 'Whats New?', 'aaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaa', 'All', '2014-03-04 16:20:33'),
(51, '2014', 'Announcement', 'sdadsf', 'asfasdf', 'All Deans', '2014-03-04 17:12:35');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE IF NOT EXISTS `user_table` (
  `idNumber` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `middleName` varchar(50) NOT NULL,
  `college` varchar(50) DEFAULT NULL,
  `yearLevel` varchar(20) DEFAULT NULL,
  `category` varchar(20) NOT NULL,
  `position` varchar(50) NOT NULL,
  `salutation` varchar(10) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`idNumber`, `password`, `firstName`, `lastName`, `middleName`, `college`, `yearLevel`, `category`, `position`, `salutation`, `datetime`) VALUES
('1', '1', 'j ', 'l', 'm', NULL, NULL, 'User', 'Dean', 'Eng.', '2014-03-04 17:40:36'),
('12345', '12345', 'Jun', 'Jun', 'Jun', 'College of Computer Studies', NULL, 'Faculty', 'Faculty', '', '2014-03-01 04:45:56'),
('2007100163', '12345', 'John Paul', 'Cachero', 'Santiago', 'College of Computer Studies', 'Fourth Year', 'Student', 'Student', '', '2014-03-04 18:57:34'),
('2009100149', 'adam', 'Michael', 'Trinidad', 'Estabillo', 'College of Computer Studies', 'First Year', 'Student', 'Student', '', '2014-03-01 03:31:48'),
('2013103677', 'jane', 'jane', 'valdez', 'hipolito', 'College of Business and Accountancy', 'Second Year', 'Student', 'Student', '', '2014-03-04 15:04:59'),
('2014', 'admin', 'Juan', 'Dela Cruz', 'Juan', NULL, NULL, 'User', 'President', 'Mr.', '2014-03-01 04:44:55');

-- --------------------------------------------------------

--
-- Table structure for table `validation_table`
--

CREATE TABLE IF NOT EXISTS `validation_table` (
  `idNumber` varchar(10) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `middleName` varchar(50) NOT NULL,
  `college` varchar(50) DEFAULT NULL,
  `yearLevel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `validation_table`
--

INSERT INTO `validation_table` (`idNumber`, `firstName`, `lastName`, `middleName`, `college`, `yearLevel`) VALUES
('2006123456', '', '', '', NULL, NULL),
('2007100163', 'John Paul', 'Cachero', 'Santiago', 'College of Computer Studies', 'Fourth Year'),
('2007201100', 'Vincent Joseph', 'Dumaliang', 'Espanyol', 'College of Computer Studies', 'Fourth Year'),
('2009100149', 'Michael Adam', 'Trinidad', 'Estabillo', 'College of Computer Studies', 'Fourth Year'),
('2009101003', 'Lester John', 'Lagasca', '', 'College of Engineering', NULL),
('2009101840', 'Joel', 'Aquino', '', 'College of Engineering', NULL),
('2010100403', 'Jezen', 'Jualo', 'Jovita', 'College of Computer Studies', 'Fourth Year'),
('2010100701', 'Ronnel', 'Calma', 'Guevarra', 'College of Computer Studies', 'Fourth Year'),
('2010300122', 'Logimar', 'Sotero', '', 'College of Technology', NULL),
('2010300289', 'Kevin', 'Reyes', '', 'College of Architecture', NULL),
('2012100121', 'Micah Shaira', 'Asprer', '', 'College of Arts and Social Sciences', NULL),
('2012101059', 'Chandeth', 'Guevarra', '', 'College of Business and Accountancy', NULL),
('2012103677', 'Rio', 'Castillo', '', 'College of Business and Accountancy', NULL),
('2013103677', 'Jane', 'Valdez', '', 'College of Business and Accountancy', NULL),
('2014000000', '', '', '', '', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
