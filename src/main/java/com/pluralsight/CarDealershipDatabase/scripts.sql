CREATE DATABASE CarDealership;
USE CarDealership;
CREATE TABLE dealerships (
	dealership_id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);
CREATE TABLE vehicles (
	VIN VARCHAR(17) PRIMARY KEY,
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    color VARCHAR(20),
    price DECIMAL(10,2),
);
CREATE TABLE inventory (
	dealership_id int,
    VIN VARCHAR(17),
    PRIMARY KEY (dealership_id, VIN),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);
CREATE TABLE sales_contracts (
	id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    customer_name VARCHAR(50),
    sale_price DECIMAL(10,2),
    sale_date DATE,
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);
INSERT INTO dealerships (name, address, phone) VALUES
('Premier Auto Mall', '100 Main St', '555-1100'),
('West Coast Motors', '220 Lake Rd', '555-2200'),
('Luxury Rides', '400 Sunset Blvd', '555-3300');
INSERT INTO vehicles (VIN, make, model, year, color, price) VALUES
('1HGCM82633A004352', 'Honda', 'Accord', 2020, 'Black', 22000.00),
('1FTRW08L21KC12345', 'Ford', 'F-150', 2019, 'Red', 28000.00),
('JH4KA8270MC000321', 'Acura', 'Legend', 2022, 'White', 35000.00),
('2T1BURHE6JC123456', 'Toyota', 'Corolla', 2021, 'Blue', 19000.00),
('3VWFE21C04M000789', 'Volkswagen', 'Jetta', 2018, 'Silver', 16000.00);
INSERT INTO inventory (dealership_id, VIN) VALUES
(1, '1HGCM82633A004352'),
(1, '1FTRW08L21KC12345'),
(2, 'JH4KA8270MC000321'),
(3, '2T1BURHE6JC123456'),
(2, '3VWFE21C04M000789');
INSERT INTO sales_contracts (VIN, customer_name, sale_price, sale_date) VALUES
('1FTRW08L21KC12345', 'Phu Doan', 27000.00, '2024-06-01'),
('3VWFE21C04M000789', 'Jackson Bowling', 15500.00, '2024-05-15');
-- 1. Get all dealerships
SELECT * FROM dealerships;
-- 2. Find all vehicles for a specific dealership
SELECT v.*
FROM vehicles AS v
JOIN inventory AS i
ON i.VIN = v.VIN
WHERE i.dealership_id = 2;
-- 3. Find a car by VIN
SELECT * FROM vehicles
WHERE VIN = '1HGCM82633A004352';
-- 4. Find the dealership where a certain car is located, by VIN
SELECT d.* FROM dealerships AS d
JOIN inventory AS i
ON d.dealership_id = i.dealership_id
WHERE i.VIN = '1FTRW08L21KC12345';
-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT d.* FROM dealerships AS d
JOIN inventory AS i
ON d.dealership_id = i.dealership_id
JOIN vehicles AS v
ON v.VIN = i.VIN
WHERE v.make = 'Ford' AND v.model = 'F-150' AND v.color = 'Red';
-- 6. Get all sales information for a specific dealer for a specific date range
SELECT s.*, d.* FROM sales_contracts AS s
JOIN vehicles AS v
ON v.VIN = s.VIN
JOIN inventory AS i
ON v.VIN = i.VIN
JOIN dealerships AS d
ON i.dealership_id = d.dealership_id
WHERE d.dealership_id = 1 AND s.sale_date BETWEEN '2024-05-15' AND '2024-06-01';
