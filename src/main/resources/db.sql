
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
CREATE TABLE `vehicles` (
      `vehicle_id` int NOT NULL AUTO_INCREMENT,
      `type` varchar(20) NOT NULL,
      PRIMARY KEY (vehicle_id)
      );

CREATE TABLE `airplanes` (
      `vehicle_id` int NOT NULL,
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
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
    FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);

CREATE TABLE `cars` (
      `vehicle_id` int NOT NULL,
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
      FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
      FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);
CREATE TABLE `boats` (
      `vehicle_id` int NOT NULL,
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
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
    FOREIGN KEY (dealer_id) REFERENCES dealers(id)
);
CREATE TABLE `trucks` (
      `vehicle_id` int NOT NULL,
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
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(vehicle_id),
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
  `start_date` datetime NOT NULL,
  `duration_days` int NOT NULL,
  `created_date` datetime NOT NULL,
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

START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Car');
INSERT INTO cars (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,number_doors)
VALUES (LAST_INSERT_ID(), 'Honda', 'Civic', '2.0L Inline 4', 'AB-1234-CD', 'Red', '1500kg', 5, 25000, 100, 'Gasoline', 1,'https://di-uploads-pod11.dealerinspire.com/hondaofkirkland/uploads/2019/08/2019-Civic-Sedan-Rallye-Red.png',5);
COMMIT;

START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Car');
INSERT INTO cars (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,number_doors)
VALUES (LAST_INSERT_ID(), 'Toyota', 'Camry', '2.5L Inline 4', 'XY-5678-ZW', 'Silver', '1600kg', 5, 30000, 60, 'Gasoline', 2,'https://file.kelleybluebookimages.com/kbb/base/evox/CP/51209/2023-Toyota-Camry-front_51209_032_2400x1800_1H1_nologo.png',4);
COMMIT;


START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Boat');
INSERT INTO boats (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url, number_lifeboats, max_speed_knots)
VALUES (LAST_INSERT_ID(), 'Bayliner', '2455 Ciera', 'MerCruiser 5.7L', 'FL2345', 'White', 2.5, 6, 450, 900, 'Gasoline', 1, 'https://imgs.yachthub.com/2/9/1/5/4/1/0_4.jpg', 1, 30);
COMMIT;

START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Boat');
INSERT INTO boats (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url, number_lifeboats, max_speed_knots)
VALUES (LAST_INSERT_ID(), 'Sea Ray', 'Sundancer 320', 'MerCruiser 6.2L', 'FL5678', 'White', 3.0, 8, 200, 500, 'Gasoline', 2, 'https://images.boatsgroup.com/images/1/20/82/8202082_20220421070942553_1_XLARGE.jpg', 2, 35);
COMMIT;



START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Airplane');
INSERT INTO airplanes (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url,engine_count,flightRange,max_speed_knots,seating_capacity)
VALUES (LAST_INSERT_ID(), 'Boeing', '737 MAX', 'CFM International LEAP-1B', 'N12345', 'White', 79.0, 189, 4850, 2000, 'Jet A', 1, 'https://www.smartwings.com/images/letadla/boeing-737-max-8/boeing-737-max-960.jpeg', 2, 3700, 470, 220);
COMMIT;

START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Airplane');
INSERT INTO airplanes (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url,engine_count,flightRange,max_speed_knots,seating_capacity)
VALUES (LAST_INSERT_ID(), 'Cessna', '172 Skyhawk', 'Lycoming O-360', 'N98765', 'Blue', 1.1, 4, 1500, 500, 'AvGas', 3, 'https://upload.wikimedia.org/wikipedia/commons/0/06/Cessna_172_Skyhawk_%28D-EDDX%29.jpg',2,3700,470,210);
COMMIT;



START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Truck');
INSERT INTO trucks (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url,weight_capacity)
VALUES (LAST_INSERT_ID(), 'Volvo', 'VNL 760', 'Volvo D13TC', 'TX1234', 'Blue', 18.1, 2, 500000, 600, 'Diesel', 1, 'https://vicimus-glovebox7.s3.us-east-2.amazonaws.com/photos/rgLubwKXttau/4V4NC9EH9LN254348/37850acea4d7341bb521d66c417506fe.jpg', 80000);
COMMIT;

START TRANSACTION;
INSERT INTO vehicles (type) VALUES
('Truck');
INSERT INTO trucks (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id,img_url,weight_capacity)
VALUES (LAST_INSERT_ID(), 'Ford', 'F-150', '3.5L V6 EcoBoost', 'TX5678', 'Red', 2.5, 5, 100000, 350, 'Gasoline', 2, 'https://www.thedrive.com/uploads/2022/05/09/Lightning-Review-Hero-3.jpg?auto=webp', 3000);
COMMIT;







INSERT INTO rental (id, user_id, vehicle_id, dealer_id, start_date, duration_days, created_date)
VALUES (1, 1, 1, 2,'2023-05-01', 7, '2023-05-01'),
       (2, 2, 2, 1,'2023-05-02', 5, '2023-05-02'),
       (3, 2, 3, 3,'2023-05-03', 3, '2023-05-03'),
       (4, 1, 2, 2,'2023-05-03', 3, '2023-05-04'),
       (5, 1, 3, 3,'2023-05-03', 3, '2023-05-05');














/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

