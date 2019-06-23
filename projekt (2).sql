-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 17 Cze 2019, 23:57
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orders`
--

CREATE TABLE `orders` (
  `Id` int(250) NOT NULL,
  `nrZlecenia` varchar(30) NOT NULL,
  `dataPrzyjecia` varchar(30) DEFAULT NULL,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `miasto` varchar(30) DEFAULT NULL,
  `ulica` varchar(30) DEFAULT NULL,
  `nrDomu` varchar(30) DEFAULT NULL,
  `nrLokalu` varchar(30) DEFAULT NULL,
  `NIP` varchar(30) DEFAULT NULL,
  `opis` varchar(200) DEFAULT NULL,
  `serwisant` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `orders`
--

INSERT INTO orders (`Id`, `nrZlecenia`, `dataPrzyjecia`, `imie`, `nazwisko`, `miasto`, `ulica`, `nrDomu`, `nrLokalu`, `NIP`, `opis`, `serwisant`) VALUES
(159, '1', '2', '3', '4', '7', '6', '8', '9', '5', 'opis', 'aaa'),
(160, '1', '2', '3', '4', '7', '6', '8', '9', '5', 'opis123dsfdssfsdfsdfdsfsdfsdfsdfssgdgfdsgdsgdfhgfdgfdsgdsgdsgdsgdgssfdgfdsgfdsgsfd', ''),
(161, '65465', 'cgfcgf', 'cgf', 'gfc', 'fcg', 'gfc', 'hfcg', 'cgfcgf', 'uyfuy', NULL, NULL),
(162, '65465', 'cgfcgf', 'cgf', 'gfc', 'fcg', 'gfc', 'hfcg', 'cgfcgf', 'uyfuy', NULL, NULL),
(168, '1', '2', '3', '4', '5', '7', '8', '9', '6', '', '0'),
(169, '0', '3', '9', '8', '5', '7', '6', '3', '1', '4', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `storage`
--

CREATE TABLE `storage` (
  `Id` int(200) NOT NULL,
  `Nazwa` varchar(30) DEFAULT NULL,
  `CenaNetto` int(11) DEFAULT NULL,
  `CenaBrutto` int(11) DEFAULT NULL,
  `Stan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `storage`
--

INSERT INTO `storage` (`Id`, `Nazwa`, `CenaNetto`, `CenaBrutto`, `Stan`) VALUES
(34, 'gpu', 1, 2, 6),
(36, '1', 444, 212, 124),
(37, '1', 3, 212, 124),
(38, '1', 444, 212, 124);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tempserwis`
--

CREATE TABLE `tempserwis` (
  `Id` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `storageId` int(11) NOT NULL,
  `ilosc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `tempserwis`
--

INSERT INTO `tempserwis` (`Id`, `orderId`, `storageId`, `ilosc`) VALUES
(1, 159, 34, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `Id` int(250) NOT NULL,
  `Imie` varchar(30) DEFAULT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Stanowisko` varchar(30) NOT NULL,
  `Haslo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`Id`, `Imie`, `Nazwisko`, `Stanowisko`, `Haslo`) VALUES
(1, 'Bartek', 'Kolodziej', 'admin', 'admin'),
(2, 'imie2', 'zlecenia', 'zlecenia', 'zlecenia'),
(3, 'Mirek', 'Kowalski', 'serwis', 'serwis'),
(4, 'Jadwiga', 'kowalska', 'ksiegowa', 'ksiegowa'),
(5, 'Janusz', 'Kowalski', 'magazyn', 'magazyn');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `orders`
--
ALTER TABLE orders
  ADD PRIMARY KEY (`Id`);

--
-- Indeksy dla tabeli `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`Id`);

--
-- Indeksy dla tabeli `tempserwis`
--
ALTER TABLE `tempserwis`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `orderId` (`orderId`),
  ADD KEY `storageId` (`storageId`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `orders`
--
ALTER TABLE orders
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=170;

--
-- AUTO_INCREMENT dla tabeli `storage`
--
ALTER TABLE `storage`
  MODIFY `Id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT dla tabeli `tempserwis`
--
ALTER TABLE `tempserwis`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `tempserwis`
--
ALTER TABLE `tempserwis`
  ADD CONSTRAINT `tempserwis_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES orders (`Id`),
  ADD CONSTRAINT `tempserwis_ibfk_2` FOREIGN KEY (`storageId`) REFERENCES `storage` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
