-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Cze 2019, 15:45
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt1`
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

INSERT INTO `orders` (`Id`, `nrZlecenia`, `dataPrzyjecia`, `imie`, `nazwisko`, `miasto`, `ulica`, `nrDomu`, `nrLokalu`, `NIP`, `opis`, `serwisant`) VALUES
(159, '134334', '2', 'Janusz', '4', '7', 'Krotka', '8', '9', '7879', 'opis nie za dlugi', ''),
(180, '134334', '2', 'Jan', '4', '7', 'dluga', '8', '9', '7879', 'opis', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `serwis`
--

CREATE TABLE `serwis` (
  `id` int(11) NOT NULL,
  `nrZlecenia` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `serwisant` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `serwis`
--

INSERT INTO `serwis` (`id`, `nrZlecenia`, `status`, `serwisant`) VALUES
(31, '123', 'nie', 'Jan'),
(34, '1', 'tak juz prawie', 'Andzrzej'),
(35, '34', 'done', 'Janusz'),
(36, '34', 'prawie', 'Janusz'),
(37, '21`', 'done', 'Mateusz');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `storage`
--

CREATE TABLE `storage` (
  `Id` int(200) NOT NULL,
  `Nazwa` varchar(30) DEFAULT NULL,
  `CenaNetto` float(11,0) DEFAULT NULL,
  `CenaBrutto` float(11,0) DEFAULT NULL,
  `Stan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `storage`
--

INSERT INTO `storage` (`Id`, `Nazwa`, `CenaNetto`, `CenaBrutto`, `Stan`) VALUES
(34, 'cpu', 12, 3, 4),
(40, 'ff', 46, 57, 5);

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
(1, 159, 34, 55);

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
(1, 'Bartek', 'Kolodziej', 'admin', 'x'),
(2, 'imie2', 'zlecenia', 'zlecenia', 'zlecenia'),
(3, 'Mirek', 'Kowalski', 'serwis', 's'),
(4, 'Jadwiga', 'kowalska', 'ksiegowa', 'ksiegowa'),
(6, 'x', 'x', 'x', 'x'),
(8, '', '', '', ''),
(9, 'magazyn', 'magazyn', 'magazyn', 'magazyn'),
(10, 'admin', 'admin', 'admin', 'admin'),
(27, '', '', '', ''),
(28, 'a', 'b', 'c', 'd'),
(29, 'a', 'b', 'c', 'd'),
(30, 'a', 'b', 'c', 'd'),
(31, 'a', 'bd', 'cd', 'dd'),
(33, 'mat', 'szu', 'admin', 'admin'),
(34, 'mat', 'szu', 'admin', 'admin'),
(35, 'mat', 'szu', 'admin', 'admin');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Id`);

--
-- Indeksy dla tabeli `serwis`
--
ALTER TABLE `serwis`
  ADD PRIMARY KEY (`id`);

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
ALTER TABLE `orders`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=181;

--
-- AUTO_INCREMENT dla tabeli `serwis`
--
ALTER TABLE `serwis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT dla tabeli `storage`
--
ALTER TABLE `storage`
  MODIFY `Id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT dla tabeli `tempserwis`
--
ALTER TABLE `tempserwis`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `tempserwis`
--
ALTER TABLE `tempserwis`
  ADD CONSTRAINT `tempserwis_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`Id`),
  ADD CONSTRAINT `tempserwis_ibfk_2` FOREIGN KEY (`storageId`) REFERENCES `storage` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
