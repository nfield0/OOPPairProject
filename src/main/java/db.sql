
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
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20),
  `address` varchar(100),
  `phone_num` varchar(20),
  PRIMARY KEY (id)
);

CREATE TABLE `airplanes` (
      `vehicle_id` int NOT NULL AUTO_INCREMENT,
      `type` varchar(20) NOT NULL,
      `make` varchar(20) NOT NULL,
      `model` varchar(20) NOT NULL,
      `engine` varchar(20) NOT NULL,
      `registration` varchar(20) NOT NULL,
      `color` varchar(20),
      `weight_tonnes` FLOAT NOT NULL,
      `number_passengers` int DEFAULT NULL,
      `mileage` int NOT NULL,
      `price` int NOT NULL,
      `fuel_type` varchar(20),
      `dealer_id` INT,
      `img_url` VARCHAR(200),
    `engine_count` VARCHAR(50) NOT NULL,
    `flightRange` INT NOT NULL,
    `max_speed_knots` int NOT NULL,
    `seating_capacity` INT NOT NULL,
    PRIMARY KEY (vehicle_id),
    FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);

CREATE TABLE `cars` (
      `vehicle_id` int NOT NULL AUTO_INCREMENT,
      `type` varchar(20) NOT NULL,
      `make` varchar(20) NOT NULL,
      `model` varchar(20) NOT NULL,
      `engine` varchar(20) NOT NULL,
      `registration` varchar(20) NOT NULL,
      `color` varchar(20),
      `weight_tonnes` FLOAT NOT NULL,
      `number_passengers` int DEFAULT NULL,
      `mileage` int NOT NULL,
      `price` int NOT NULL,
      `fuel_type` varchar(20),
      `dealer_id` INT,
      `img_url` VARCHAR(200),
      `number_doors` INT NOT NULL,
      PRIMARY KEY (vehicle_id),
      FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);
CREATE TABLE `boats` (
      `vehicle_id` int NOT NULL AUTO_INCREMENT,
      `type` varchar(20) NOT NULL,
      `make` varchar(20) NOT NULL,
      `model` varchar(20) NOT NULL,
      `engine` varchar(20) NOT NULL,
      `registration` varchar(20) NOT NULL,
      `color` varchar(20),
      `weight_tonnes` FLOAT NOT NULL,
      `number_passengers` int DEFAULT NULL,
      `mileage` int NOT NULL,
      `price` int NOT NULL,
      `fuel_type` varchar(20),
      `dealer_id` INT,
      `img_url` VARCHAR(200),
    `number_lifeboats` INT NOT NULL,
    `max_speed_knots` INT NOT NULL,
    PRIMARY KEY (vehicle_id),
    FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);
CREATE TABLE `trucks` (
      `vehicle_id` int NOT NULL AUTO_INCREMENT,
      `type` varchar(20) NOT NULL,
      `make` varchar(20) NOT NULL,
      `model` varchar(20) NOT NULL,
      `engine` varchar(20) NOT NULL,
      `registration` varchar(20) NOT NULL,
      `color` varchar(20),
      `weight_tonnes` FLOAT NOT NULL,
      `number_passengers` int DEFAULT NULL,
      `mileage` int NOT NULL,
      `price` int NOT NULL,
      `fuel_type` varchar(20),
      `dealer_id` INT,
      `img_url` VARCHAR(200),
    `weight_capacity` INT NOT NULL,
    PRIMARY KEY (vehicle_id),
    FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE `rental` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `vehicle_id` int NOT NULL,
  `dealer_id` int NOT NULL,
  `start_date` date NOT NULL,
  `duration_days` int NOT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (dealer_id) REFERENCES dealers(id)
  );


-- insert sample data

INSERT INTO users(id,name,email,password,admin)
VALUES (1,"Arthur","arthur@gmail.com","Password",0),
       (2,"Nathan","nathan@gmail.com","Password",1);

INSERT INTO dealers (id, name, address, phone_num)
VALUES (1, 'John Doe', '123 Main St, Anytown USA', '555-1234'),
       (2, 'Jane Smith', '456 Park Ave, Somewhere USA', '555-5678'),
       (3, 'Bob Johnson', '789 Elm St, Nowhere USA', '555-9012');



-- Insert data into the car table
INSERT INTO cars (type, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,number_doors)
VALUES ('Hatchback', 'Honda', 'Civic', '2.0L Inline 4', 'AB-1234-CD', 'Red', '1500kg', 5, 25000, 15000, 'Gasoline', 1,'',5),
('Hatchback', 'Honda', 'Civic', '2.0L Inline 4', 'AB-1234-CD', 'Red', '1500kg', 5, 25000, 15000, 'Gasoline', 1,'',5),
('Hatchback', 'Honda', 'Civic', '2.0L Inline 4', 'AB-1234-CD', 'Red', '1500kg', 5, 25000, 15000, 'Gasoline', 1,'',5);

INSERT INTO boats (type, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url, number_lifeboats, max_speed_knots)
VALUES ('Cabin Cruiser', 'Bayliner', '2455 Ciera', 'MerCruiser 5.7L', 'FL2345', 'White', 2.5, 6, 450, 30000, 'Gasoline', 1, '', 1, 30),
      ('Sailboat', 'Beneteau', 'Oceanis 35.1', 'Yanmar 3YM30AE', 'CA4567', 'Blue', 3.0, 8, 1200, 75000, 'Diesel', 1,'', 0, 7),
      ('Speedboat', 'Sea Ray', 'Sundancer 320', 'MerCruiser 6.2L', 'NY8901', 'Black', 4.5, 10, 200, 125000, 'Gasoline', 1,'', 0, 50),
      ('Fishing Boat', 'Boston Whaler', '170 Montauk', 'Mercury 90HP', 'MA4321', 'Green', 1.5, 4, 300, 25000, 'Gasoline', 1,'', 0, 25),
      ('Pontoon Boat', 'Sun Tracker', 'Fishin Barge 24 XP3', 'Mercury 150HP', 'TX7890', 'Yellow', 2.2, 12, 50, 35000, 'Gasoline', 1,'', 0, 20);


INSERT INTO trucks (type, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,weight_capacity)
VALUES ('Semi-Trailer', 'Volvo', 'VNL 760', 'Volvo D13TC', 'TX1234', 'Blue', 18.1, 2, 500000, 120000, 'Diesel', 1, '', 80000),
('Dump Truck', 'Mack', 'Granite GU713', 'Mack MP8', 'NY5678', 'Red', 24.5, 3, 250000, 170000, 'Diesel', 1, '', 66000),
('Box Truck', 'Isuzu', 'NQR', 'Isuzu 4HK1-TC', 'CA9012', 'White', 7.5, 3, 200000, 40000, 'Diesel', 1, '', 17950),
('Pickup Truck', 'Ford', 'F-150', '2.7L EcoBoost', 'FL3456', 'Black', 2.0, 5, 100000, 35000, 'Gasoline', 2, '', 3200),
('Flatbed Truck', 'Peterbilt', '567', 'PACCAR MX-13', 'TX7890', 'Yellow', 22.7, 2, 300000, 140000, 'Diesel', 3, '', 50000);


INSERT INTO rental (id, user_id, vehicle_id, dealer_id, start_date, duration_days, created_date)
VALUES (1, 1, 1, 2,'2023-05-01', 7, '2023-05-01'),
       (2, 2, 2, 1,'2023-05-02', 5, '2023-05-02'),
       (3, 1, 3, 3,'2023-05-03', 3, '2023-05-03');




INSERT INTO airplanes (type, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url,engine_count,flightRange,max_speed_knots,seating_capacity)
VALUES ('Commercial', 'Boeing', '737 MAX', 'CFM International LEAP-1B', 'N12345', 'White', 79.0, 189, 4850, 120000000, 'Jet A', 1, '', 2, 3700, 470, 220),
        ('Business Jet', 'Gulfstream', 'G650', 'Rolls-Royce BR725', 'N54321', 'Blue', 45.6, 19, 7000, 65000000, 'Jet A', 3, '', 2, 7500, 594, 8),
        ('Helicopter', 'Eurocopter', 'AS350', 'Turbomeca Arriel 1D1', 'N78901', 'Red', 2.3, 5, 1000, 1500000, 'Jet A', 3, '', 1, 400, 135, 5),
        ('Private Jet', 'Cessna', 'Citation Latitude', 'Pratt & Whitney Canada PW306D1', 'N24680', 'Silver', 16.5, 9, 2400, 17000000, 'Jet A', 2, '', 2, 2800, 446, 9),
        ('Military', 'Lockheed Martin', 'F-35 Lightning II', 'Pratt & Whitney F135-PW-100', 'USAF001', 'Grey', 13.3, 1, 1200, 89000000, 'Jet A', 2, '', 1, 2200, 1199, 1);











/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

