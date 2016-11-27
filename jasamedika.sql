-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2016 at 11:09 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jasamedika`
--

-- --------------------------------------------------------

--
-- Table structure for table `kecamatan`
--

CREATE TABLE `kecamatan` (
  `id` int(10) NOT NULL,
  `nama_kecamatan` varchar(100) NOT NULL,
  `id_kota` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kecamatan`
--

INSERT INTO `kecamatan` (`id`, `nama_kecamatan`, `id_kota`) VALUES
(1, 'Antapani', '32.73'),
(2, 'Arcamanik', '32.73'),
(3, 'Kiaracondong', '32.73'),
(4, 'Buah Batu', '32.73');

-- --------------------------------------------------------

--
-- Table structure for table `kelurahan`
--

CREATE TABLE `kelurahan` (
  `id` int(10) NOT NULL,
  `kelurahan` varchar(100) NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `kota` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelurahan`
--

INSERT INTO `kelurahan` (`id`, `kelurahan`, `kecamatan`, `kota`) VALUES
(1, 'Antapani Kidul', 'Antapani', 'Kota Bandung'),
(2, 'Antapani Kulon', 'Antapani', 'Kota Bandung'),
(3, 'Antapani Tengah', 'Antapani', 'Kota Bandung'),
(4, 'Antapani Wetan', 'Antapani', 'Kota Bandung'),
(5, 'Babakan Sari', 'Kiaracondong', 'Kota Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `id` int(10) NOT NULL,
  `nama_kota` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`id`, `nama_kota`) VALUES
(1, 'Kabupaten Bogor'),
(2, 'Kabupaten Cianjur'),
(3, 'Kabupaten Sukabumi'),
(4, 'Kota Bandung');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id` int(100) NOT NULL DEFAULT '0',
  `nama` varchar(100) NOT NULL DEFAULT '',
  `alamat` varchar(300) NOT NULL DEFAULT '',
  `no_telepon` varchar(50) NOT NULL DEFAULT '',
  `RTRW` varchar(10) NOT NULL DEFAULT '',
  `kelurahan` varchar(100) NOT NULL DEFAULT '',
  `tanggal_lahir` varchar(100) NOT NULL DEFAULT '',
  `jenis_kelamin` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id`, `nama`, `alamat`, `no_telepon`, `RTRW`, `kelurahan`, `tanggal_lahir`, `jenis_kelamin`) VALUES
(1611000003, 'John Lennon', 'JL. Antabaru no.09', '0876548723', '01/02', 'Antapani Kidul', '10-11-1945', 'L'),
(1611000004, 'Paul McCartney', 'JL. Aryajipang no.20', '0876548745', '10/05', 'Antapani Kulon', '02-14-1946', 'L'),
(1611000005, 'Goerge Harisson', 'JL. sukabumi', '0876548753', '08/12', 'Antapani Wetan', '19-06-1947', 'L'),
(1611000006, 'Ringgo Starkey', 'JL. Bogor no.54', '0876548728', '05/07', 'Antapani Tengah', '08-12-1948', 'L'),
(1611000007, 'Goerge Martin', 'JL. Jakarta no.10', '0876239845', '10/02', 'Antapani Kulon', '12-12-1940', 'L'),
(1611000008, 'Cecep Gorbachev', 'JL. Kremlin', '09827636482', '01/01', 'Antapani Kidul', '22-12-1965', 'L'),
(1611000011, 'asada', 'dsdsds', '324343255', '01/01', 'dsdadsf', '1-1-1980', 'L'),
(1611000012, 'Keith Richard', 'JL. Jemy no.19', '0877648723', '10/11', 'BBK Sari', '2-12-1942', 'L'),
(1611000013, 'Eric Clapton', 'JL. Kubang no.87', '0876566723', '01/02', 'Antapani Kidul', '10-11-1942', 'L');

--
-- Triggers `pasien`
--
DELIMITER $$
CREATE TRIGGER `trigger_insert_id_pasen` BEFORE INSERT ON `pasien` FOR EACH ROW BEGIN
  INSERT INTO tbl_generate_id VALUES (NULL);
  SET NEW.id = CONCAT((SELECT DATE_FORMAT(NOW(), '%y%m')), LPAD(LAST_INSERT_ID(), 6, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_generate_id`
--

CREATE TABLE `tbl_generate_id` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_generate_id`
--

INSERT INTO `tbl_generate_id` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(11),
(12),
(13);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kota` (`id_kota`),
  ADD KEY `nama_kecamatan` (`nama_kecamatan`),
  ADD KEY `id_kota_2` (`id_kota`);

--
-- Indexes for table `kelurahan`
--
ALTER TABLE `kelurahan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `index_kelurahan` (`kelurahan`),
  ADD KEY `index_kecamatan` (`kecamatan`),
  ADD KEY `nama_keluharan` (`kelurahan`),
  ADD KEY `index_kota` (`kota`),
  ADD KEY `nama_kecamatan` (`kecamatan`),
  ADD KEY `nama_kota` (`kota`),
  ADD KEY `nama_kecamatan_2` (`kecamatan`),
  ADD KEY `nama_kota_2` (`kota`),
  ADD KEY `id_2` (`id`),
  ADD KEY `id_3` (`id`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kota` (`id`),
  ADD KEY `nama_kota` (`nama_kota`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kelurahan` (`kelurahan`);

--
-- Indexes for table `tbl_generate_id`
--
ALTER TABLE `tbl_generate_id`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kecamatan`
--
ALTER TABLE `kecamatan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `kelurahan`
--
ALTER TABLE `kelurahan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_generate_id`
--
ALTER TABLE `tbl_generate_id`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
