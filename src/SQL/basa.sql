-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 24 Cze 2019, 13:53
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
  `cena` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `magazyn`
--

INSERT INTO `magazyn` (`id`, `nazwa`, `cena`) VALUES
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
  `haslo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `imie`, `nazwisko`, `stanowisko`, `haslo`) VALUES
(1, 'admin', 'admin', 'admin', 'admin');

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
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
