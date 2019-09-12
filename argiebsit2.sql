-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 12, 2019 at 04:14 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `argiebsit2`
--

-- --------------------------------------------------------

--
-- Table structure for table `logintbl`
--

CREATE TABLE `logintbl` (
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `username` text NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logintbl`
--

INSERT INTO `logintbl` (`firstname`, `lastname`, `username`, `pass`) VALUES
('argie', 'cabras', 'argie', 'argie'),
('a', 'a', 'a', 'a'),
('a', 'a', 'b', '92eb5ffee6ae2fec3ad71c777531578f'),
('a', 'a', 'argie', '6cf51b9070c74b2b7b90a24428e9a99b');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
