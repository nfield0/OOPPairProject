-- phpMyAdmin SQL Dump
-- version 5.1.4deb1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 31 mars 2023 à 01:22
-- Version du serveur : 8.0.32-0ubuntu0.22.10.2
-- Version de PHP : 8.1.7-1ubuntu3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `JavaISP`
--
DROP DATABASE IF EXISTS JavaISP;
CREATE DATABASE JavaISP CHARACTER SET utf8mb4;
USE JavaISP;

-- --------------------------------------------------------

--
-- Structure de la table `boats`
--

CREATE TABLE `boats` (
  `id` int NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `maker` text NOT NULL,
  `registration` text NOT NULL,
  `color` text,
  `engine` text,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `cars`
--

CREATE TABLE `cars` (
  `id` int NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `maker` text NOT NULL,
  `registration` text NOT NULL,
  `color` text,
  `engine` text,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL,
  `wheels` int DEFAULT NULL,
  `number_doors` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `planes`
--

CREATE TABLE `planes` (
  `id` int NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `maker` text NOT NULL,
  `registration` text NOT NULL,
  `color` text,
  `engine` text,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `rental`
--

CREATE TABLE `rental` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `vehicle_id` int NOT NULL,
  `start_date` date NOT NULL,
  `duration` int NOT NULL,
  `rental_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `trucks`
--

CREATE TABLE `trucks` (
  `id` int NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `maker` text NOT NULL,
  `registration` text NOT NULL,
  `color` text,
  `engine` text,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `account_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

CREATE TABLE `vehicles` (
  `id` int NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `maker` text NOT NULL,
  `registration` text NOT NULL,
  `color` text,
  `engine` text,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `boats`
--
ALTER TABLE `boats`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `planes`
--
ALTER TABLE `planes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trucks`
--
ALTER TABLE `trucks`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `boats`
--
ALTER TABLE `boats`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `planes`
--
ALTER TABLE `planes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rental`
--
ALTER TABLE `rental`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `trucks`
--
ALTER TABLE `trucks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;











-- DB Redone

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `JavaISP`
--
DROP DATABASE IF EXISTS JavaISP;
CREATE DATABASE JavaISP CHARACTER SET utf8mb4;
USE JavaISP;

CREATE TABLE `dealers` (
  `id` int NOT NULL,
  `type` varchar(20),
  `address` varchar(20),
  PRIMARY KEY (id)
);
CREATE TABLE `vehicles` (
  `id` int NOT NULL,
  `type` varchar(20) NOT NULL,
  `make` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `engine` varchar(20) NOT NULL,
  `registration` varchar(20) NOT NULL,
  `color` varchar(20),
  `weight_tonnes` INT NOT NULL,
  `number_passengers` int DEFAULT NULL,
  `stock` int NOT NULL,
  `mileage` int NOT NULL,
  `price` int NOT NULL,
  `fuel_type` varchar(20),
  `dealer_id` INT,
  PRIMARY KEY (id),
  FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);

CREATE TABLE `airplanes` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `vehicle_id` INT NOT NULL,
    `model_number` VARCHAR(50) NOT NULL,
    `engine_count` VARCHAR(50) NOT NULL,
    `range` INT NOT NULL,
    `max_speed_kmh` int NOT NULL,
    `seating_capacity` INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

CREATE TABLE `cars` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `vehicle_id` INT NOT NULL,
    `number_doors` INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);
CREATE TABLE `boats` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `vehicle_id` INT NOT NULL,
    `number_lifeboats` INT NOT NULL,
    `max_speed_knots` INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);
CREATE TABLE `trucks` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `vehicle_id` INT NOT NULL,
    `weight_limit` INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `account_creation` date NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE `rental` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `vehicle_id` int NOT NULL,
  `start_date` date NOT NULL,
  `duration_days` int NOT NULL,
  `rental_date` date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
  );


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




-- insert sample data


