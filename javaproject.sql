-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2017 at 11:24 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `documents`
--

CREATE TABLE `documents` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `public` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `research`
--

CREATE TABLE `research` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `money` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `public` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `research`
--

INSERT INTO `research` (`id`, `name`, `money`, `user_id`, `public`) VALUES
(123, 'Dobozfelismero robot ', 2000000, 222, 0),
(55555, 'robotpatkany ', 50000000, 444, 1),
(55556, 'lskjdg', 457643, 999, 0),
(55557, 'sdfs', 3454543, 666, 1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`) VALUES
(2, 'write'),
(4, 'read'),
(6, 'modify'),
(8, 'delete');

-- --------------------------------------------------------

--
-- Table structure for table `student_research`
--

CREATE TABLE `student_research` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `research_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `title_roles`
--

CREATE TABLE `title_roles` (
  `title_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `title_roles`
--

INSERT INTO `title_roles` (`title_id`, `role_id`) VALUES
(666666, 2),
(666666, 4),
(666666, 2),
(666666, 4),
(666666, 6),
(666666, 8),
(666666, 0);

-- --------------------------------------------------------

--
-- Table structure for table `titulusok`
--

CREATE TABLE `titulusok` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `titulusok`
--

INSERT INTO `titulusok` (`id`, `name`) VALUES
(1, 'rektor'),
(2, 'dékán'),
(3, 'kancellár'),
(10, 'hallgató'),
(30, 'portás'),
(50, 'rendszergazda'),
(100, 'professzor'),
(200, 'kutató munkatárs'),
(444, 'tanársegéd'),
(666, 'intézetvezető'),
(666666, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(200) NOT NULL,
  `passwd` varchar(200) NOT NULL,
  `id` int(11) NOT NULL,
  `titulus` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `passwd`, `id`, `titulus`) VALUES
('Roka UR', 'tutu', 222, 'tudomanyos munkatars'),
('peti', 'peti', 444, 'admin'),
('zsombi', 'zsombi', 666, 'kancellar'),
('fanni', 'krumpli', 999, 'rektor'),
('gipsz jakab', 'gipsy', 123456, 'hallgato'),
('yv', 'xbc', 123457, 'xcyb'),
('yv', 'xbc', 123458, 'xcyb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `research`
--
ALTER TABLE `research`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `student_research`
--
ALTER TABLE `student_research`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `titulusok`
--
ALTER TABLE `titulusok`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `documents`
--
ALTER TABLE `documents`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `research`
--
ALTER TABLE `research`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55558;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `student_research`
--
ALTER TABLE `student_research`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `titulusok`
--
ALTER TABLE `titulusok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=666667;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123459;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
