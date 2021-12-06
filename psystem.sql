-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2021 at 11:20 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `psystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `customertbl`
--

CREATE TABLE `customertbl` (
  `CustomerID` varchar(10) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  `CustomerCreditLimit` int(11) NOT NULL,
  `isLimitSet` varchar(3) NOT NULL,
  `LastSetDate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customertbl`
--

INSERT INTO `customertbl` (`CustomerID`, `CustomerName`, `CustomerCreditLimit`, `isLimitSet`, `LastSetDate`) VALUES
('10001', 'Obinna Okolie', 4192, 'Yes', '03/12/2021'),
('10002', 'Ada Mamae', 6000, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `orderlinetbl`
--

CREATE TABLE `orderlinetbl` (
  `OrderID` int(11) NOT NULL,
  `ProductID` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `CustomerID` varchar(50) NOT NULL,
  `OrderDate` varchar(50) NOT NULL,
  `PaymentMethod` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderlinetbl`
--

INSERT INTO `orderlinetbl` (`OrderID`, `ProductID`, `Quantity`, `Price`, `CustomerID`, `OrderDate`, `PaymentMethod`) VALUES
(1, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(1, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(1, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(1, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(1, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(1, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(1, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(1, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(2, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(3, 'P001', 1, 100, '10001', '03/12/2021', 'Cash'),
(3, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(4, 'P002', 1, 30, '10001', '03/12/2021', 'Cash'),
(5, 'P001', 2, 100, '10001', '03/12/2021', 'Cash');

-- --------------------------------------------------------

--
-- Table structure for table `ordertbl`
--

CREATE TABLE `ordertbl` (
  `OrderID` int(11) NOT NULL,
  `OrderDate` varchar(50) NOT NULL,
  `PaymentMethod` varchar(50) NOT NULL,
  `CustomerID` varchar(50) NOT NULL,
  `itemAmount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordertbl`
--

INSERT INTO `ordertbl` (`OrderID`, `OrderDate`, `PaymentMethod`, `CustomerID`, `itemAmount`) VALUES
(1, '02-12-2021', 'Cash', '10001', 0);

-- --------------------------------------------------------

--
-- Table structure for table `producttbl`
--

CREATE TABLE `producttbl` (
  `ProductID` varchar(10) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `ProductPrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producttbl`
--

INSERT INTO `producttbl` (`ProductID`, `ProductName`, `ProductPrice`) VALUES
('P001', 'Orange', 100),
('P002', 'Mango', 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customertbl`
--
ALTER TABLE `customertbl`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `ordertbl`
--
ALTER TABLE `ordertbl`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `producttbl`
--
ALTER TABLE `producttbl`
  ADD PRIMARY KEY (`ProductID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
