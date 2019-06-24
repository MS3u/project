-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Cze 2019, 16:17
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
-- Baza danych: `basa`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE `magazyn` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(30) NOT NULL,
  `stan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `magazyn`
--

INSERT INTO `magazyn` (`id`, `nazwa`, `stan`) VALUES
(1, 'gpu', '12');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `serwis`
--

CREATE TABLE `serwis` (
  `id` int(11) NOT NULL,
  `zlecenie_id` int(11) NOT NULL,
  `magazyn_id` int(11) NOT NULL,
  `status` varchar(30) NOT NULL,
  `serwisant` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(250) NOT NULL,
  `imie` varchar(30) NOT NULL,
  `nazwisko` varchar(30) NOT NULL,
  `stanowisko` varchar(30) NOT NULL,
  `haslo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `imie`, `nazwisko`, `stanowisko`, `haslo`) VALUES
(3, 'admin', 'admin', 'admin', '4c7df9ffac42261e9ea344a6e59b34c63a45d011ea8e380762de907580a459e6394a96a5815efc2d5c11b807deb913305499628a6a5fcc4aafacd3e80836a997'),
(5, 'serwis', 'serwis', 'serwis', '6ad13b0ba07cb641a576a525fa882a448aab1714cc0810c8f138cab9f9803a0611e2e2659bac850dc612b64c88fc5a5026b1ca82cf530672d7066c595b09ebfc'),
(7, 'magazyn', 'magazyn', 'magazyn', '9588fbacc0f37ac137407e0087b8c1f64e6589b66c1a32a6050885caa8b7533fbcf74af2f5b363ff87458ed0ac3a85ab9dfd5474e7acfde2f6a0b4bd5fab1c15');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zlecenie`
--

CREATE TABLE `zlecenie` (
  `id` int(11) NOT NULL,
  `nr` varchar(30) NOT NULL,
  `imie` varchar(255) NOT NULL,
  `nazwisko` varchar(30) NOT NULL,
  `pesel` varchar(30) NOT NULL,
  `telefon` varchar(30) NOT NULL,
  `opis` varchar(30) NOT NULL,
  `data` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `zlecenie`
--

INSERT INTO `zlecenie` (`id`, `nr`, `imie`, `nazwisko`, `pesel`, `telefon`, `opis`, `data`) VALUES
(1, '1111111', '1111111', '1111111', '1111111', '1111111', '1111111', NULL);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `serwis`
--
ALTER TABLE `serwis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `magazyn_id` (`magazyn_id`),
  ADD KEY `zlecenie_id` (`zlecenie_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `zlecenie`
--
ALTER TABLE `zlecenie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `serwis`
--
ALTER TABLE `serwis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `zlecenie`
--
ALTER TABLE `zlecenie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `serwis`
--
ALTER TABLE `serwis`
  ADD CONSTRAINT `serwis_ibfk_1` FOREIGN KEY (`magazyn_id`) REFERENCES `magazyn` (`id`),
  ADD CONSTRAINT `serwis_ibfk_2` FOREIGN KEY (`zlecenie_id`) REFERENCES `zlecenie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
