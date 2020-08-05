-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2019 at 11:02 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id4111561_nikkat`
--

-- --------------------------------------------------------

--
-- Table structure for table `customor_registration`
--

CREATE TABLE `customor_registration` (
  `cid` int(11) NOT NULL,
  `aicms_id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `mobileno` int(20) NOT NULL,
  `email` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customor_registration`
--

INSERT INTO `customor_registration` (`cid`, `aicms_id`, `name`, `mobileno`, `email`, `password`, `token`) VALUES
(1, 1, 'Nikunj Ramani', 76240691, 'nikunjramani7624@gmail.com', 'nikunj', 'cd5FeOiOnvI:APA91bH_hCQvpGhftywcb5McZdRiyrvgr-G_hiGniqm95t8vOu6eumTmmOxgGiW-iLrksI2V0EQWStTxQpqZ6fgnf0PrlE_6zuFcHuvv33khhwNHgATd-DktxEV0EH2lL8cSEnSmsxiq');

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `email` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id`, `email`, `token`) VALUES
(1, 'nikunj@gmail.com', 'fl4yDTz3j8k:APA91bGWChwvf7fI4_euCplj1Z30dJdo0wvEw9h4swHuB0NRriLqATaly0T92JRemwbtbTsWBIFYopfeK37TTh3Ad9ycV-kWvOThA5izDSMYa15fcW3k01R1_F8WlYYQ39ZfaW6_HLeT'),
(2, 'nikunj@patelbhai', 'dPibAnbo_go:APA91bE15pWs2njcZzU5CsOvHJVFBdqpxX15X_7yzbKYHieOTB2R3UTNA6KgurD5uRd-ZL_pIgAdYFh-JggWljj76Ehgyf5_eTl8LBXxVx_9OrsZ6YXnPSUWIclh95uDdKI5RTvim8Rm');

-- --------------------------------------------------------

--
-- Table structure for table `motor_log`
--

CREATE TABLE `motor_log` (
  `mid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `on/off` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `motor_log`
--

INSERT INTO `motor_log` (`mid`, `cid`, `on/off`, `time`) VALUES
(247, 1, 'on', '2019-10-04 02:23:46'),
(248, 1, 'off', '2019-10-04 02:23:46'),
(249, 1, 'off', '2019-10-04 02:23:46'),
(250, 1, 'off', '2019-10-04 02:25:02'),
(251, 1, 'off', '2019-10-04 02:25:02'),
(252, 1, 'on', '2019-10-04 02:25:02');

-- --------------------------------------------------------

--
-- Table structure for table `sensor_data`
--

CREATE TABLE `sensor_data` (
  `sid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `soil_moisture` int(11) NOT NULL,
  `temprature` int(11) NOT NULL,
  `humidity` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sensor_data`
--

INSERT INTO `sensor_data` (`sid`, `cid`, `soil_moisture`, `temprature`, `humidity`, `level`, `datetime`) VALUES
(2370, 1, 52, 78, 69, 62, '2019-10-04 02:28:26'),
(2371, 1, 14, 62, 42, 49, '2019-10-04 02:28:26'),
(2372, 1, 63, 21, 20, 20, '2019-10-04 02:28:26'),
(2373, 1, 81, 24, 50, 51, '2019-10-04 02:28:26'),
(2374, 1, 84, 59, 51, 80, '2019-10-04 02:28:26'),
(2375, 1, 46, 33, 18, 32, '2019-10-04 02:28:26'),
(2376, 1, 74, 69, 92, 99, '2019-10-04 02:28:26'),
(2377, 1, 94, 76, 17, 83, '2019-10-04 02:28:26'),
(2378, 1, 41, 21, 50, 14, '2019-10-04 02:28:26'),
(2379, 1, 70, 89, 85, 42, '2019-10-04 02:28:26'),
(2380, 1, 71, 21, 54, 37, '2019-10-04 02:28:26'),
(2381, 1, 99, 67, 92, 85, '2019-10-04 02:28:26'),
(2382, 1, 42, 58, 57, 18, '2019-10-04 02:28:26'),
(2383, 1, 47, 80, 27, 73, '2019-10-04 02:28:26'),
(2384, 1, 35, 57, 88, 76, '2019-10-04 02:28:26'),
(2385, 1, 23, 16, 70, 100, '2019-10-04 02:28:26'),
(2386, 1, 86, 55, 76, 19, '2019-10-04 02:28:26'),
(2387, 1, 53, 23, 38, 94, '2019-10-04 02:28:26'),
(2388, 1, 89, 14, 30, 87, '2019-10-04 02:28:26'),
(2389, 1, 41, 34, 68, 28, '2019-10-04 02:28:26'),
(2390, 1, 27, 44, 17, 42, '2019-10-04 02:28:26'),
(2391, 1, 56, 25, 49, 28, '2019-10-04 02:28:26'),
(2392, 1, 12, 94, 54, 21, '2019-10-04 02:28:26'),
(2393, 1, 72, 98, 95, 79, '2019-10-04 02:28:26'),
(2394, 1, 46, 37, 55, 23, '2019-10-04 02:28:26'),
(2395, 1, 67, 42, 81, 25, '2019-10-04 02:28:26'),
(2396, 1, 76, 57, 80, 60, '2019-10-04 02:28:26'),
(2397, 1, 99, 62, 40, 82, '2019-10-04 02:28:26'),
(2398, 1, 37, 43, 55, 100, '2019-10-04 02:28:26'),
(2399, 1, 56, 43, 78, 73, '2019-10-04 02:28:26'),
(2400, 1, 74, 99, 99, 80, '2019-10-04 02:28:26'),
(2401, 1, 75, 36, 66, 61, '2019-10-04 02:28:26'),
(2402, 1, 14, 32, 73, 17, '2019-10-04 02:28:26'),
(2403, 1, 25, 82, 46, 54, '2019-10-04 02:28:26'),
(2404, 1, 73, 62, 56, 39, '2019-10-04 02:28:26'),
(2405, 1, 85, 92, 59, 48, '2019-10-04 02:28:26'),
(2406, 1, 27, 84, 50, 22, '2019-10-04 02:28:26'),
(2407, 1, 39, 96, 33, 14, '2019-10-04 02:28:26'),
(2408, 1, 19, 51, 52, 83, '2019-10-04 02:28:26'),
(2409, 1, 85, 64, 39, 47, '2019-10-04 02:28:26'),
(2410, 1, 34, 61, 16, 24, '2019-10-04 02:28:26'),
(2411, 1, 31, 33, 11, 32, '2019-10-04 02:30:10'),
(2412, 1, 50, 85, 92, 32, '2019-10-04 02:30:10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customor_registration`
--
ALTER TABLE `customor_registration`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `motor_log`
--
ALTER TABLE `motor_log`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `sensor_data`
--
ALTER TABLE `sensor_data`
  ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customor_registration`
--
ALTER TABLE `customor_registration`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `motor_log`
--
ALTER TABLE `motor_log`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=253;
--
-- AUTO_INCREMENT for table `sensor_data`
--
ALTER TABLE `sensor_data`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2413;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
