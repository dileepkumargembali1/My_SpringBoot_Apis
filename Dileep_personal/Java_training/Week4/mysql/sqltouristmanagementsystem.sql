CREATE DATABASE TravelBookingSystem;
use TravelBookingSystem;
CREATE TABLE CUSTOMERS (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    country VARCHAR(50),
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
select * from customers;
INSERT INTO CUSTOMERS (name, email, phone, country)
VALUES
('Rama Rao', 'rama.rao@example.com', '9876543210', 'India'),
('Lakshmi Devi', 'lakshmi.devi@example.com', '9876543211', 'India'),
('Krishna Murthy', 'krishna.murthy@example.com', '9876543212', 'India'),
('Sita Mahalakshmi', 'sita.mahalkshmi@example.com', '9876543213', 'India'),
('Chandra Sekhar', 'chandra.sekhar@example.com', '9876543214', 'India'),
('Anusha Reddy', 'anusha.reddy@example.com', '9876543215', 'India'),
('Venkatesh', 'venkatesh@example.com', '9876543216', 'India'),
('Bhavani Devi', 'bhavani.devi@example.com', '9876543217', 'India'),
('Prasad Rao', 'prasad.rao@example.com', '9876543218', 'India'),
('Sravani', 'sravani@example.com', '9876543219', 'India');

CREATE TABLE DESTINATIONS (
    dest_id INT PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    avg_temperature DECIMAL(5,2),
    best_season VARCHAR(50)
);
INSERT INTO DESTINATIONS (dest_id, city, country, category, avg_temperature, best_season) VALUES
(1, 'Goa', 'India', 'Beach', 28.50, 'November to February'),
(2, 'Manali', 'India', 'Hill Station', 15.20, 'March to June'),
(3, 'Jaipur', 'India', 'Historical', 30.00, 'October to March'),
(4, 'Mysuru', 'India', 'Cultural', 27.00, 'October to February'),
(5, 'Darjeeling', 'India', 'Hill Station', 14.50, 'March to May'),
(6, 'Kerala', 'India', 'Backwaters', 29.00, 'October to March'),
(7, 'Varanasi', 'India', 'Religious', 32.00, 'October to March'),
(8, 'Puducherry', 'India', 'Beach', 29.50, 'October to March'),
(9, 'Rishikesh', 'India', 'Adventure', 25.00, 'September to November'),
(10, 'Leh', 'India', 'Mountain', 10.00, 'June to September');

CREATE TABLE BOOKINGS (
    booking_id INT PRIMARY KEY,
    customer_id INT NOT NULL,
    dest_id INT NOT NULL,
    booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    travel_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(20) DEFAULT 'Confirmed', -- Confirmed, Cancelled, etc.
    total_amount DECIMAL(10,2),

    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id),
    FOREIGN KEY (dest_id) REFERENCES DESTINATIONS(dest_id)
);

INSERT INTO BOOKINGS (booking_id, customer_id, dest_id, booking_date, travel_date, return_date, status, total_amount)
VALUES
(1, 1, 3, '2024-06-01', '2024-07-15', '2024-07-20', 'Confirmed', 15000.00),
(2, 1, 5, '2024-06-10', '2024-08-05', '2024-08-12', 'Confirmed', 18000.00),
(3, 2, 2, '2024-06-05', '2024-07-01', '2024-07-06', 'Cancelled', 17000.00),
(4, 3, 1, '2024-06-07', '2024-11-10', '2024-11-17', 'Confirmed', 22000.00),
(5, 4, 4, '2024-06-12', '2024-09-10', '2024-09-15', 'Confirmed', 19500.00),
(6, 5, 8, '2024-06-20', '2024-10-05', '2024-10-12', 'Confirmed', 16000.00),
(7, 6, 7, '2024-06-25', '2024-09-25', '2024-09-30', 'Confirmed', 14000.00),
(8, 7, 2, '2024-06-28', '2024-08-20', '2024-08-27', 'Cancelled', 20000.00),
(9, 8, 3, '2024-07-02', '2024-10-01', '2024-10-07', 'Confirmed', 15500.00),
(10, 9, 1, '2024-07-05', '2024-11-15', '2024-11-22', 'Confirmed', 21000.00);

select * from bookings;

 
CREATE TABLE PAYMENTS (
    payment_id INT PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(50),
    status VARCHAR(20) DEFAULT 'Success',

    FOREIGN KEY (booking_id) REFERENCES BOOKINGS(booking_id)
);
INSERT INTO PAYMENTS (payment_id, booking_id, payment_date, amount, payment_method, status)
VALUES
(1, 1, '2024-06-01', 15000.00, 'UPI', 'Success'),
(2, 2, '2024-06-10', 18000.00, 'Credit Card', 'Success'),
(3, 3, '2024-06-06', 0.00, 'Net Banking', 'Failed'),
(4, 4, '2024-06-07', 22000.00, 'Debit Card', 'Success'),
(5, 5, '2024-06-12', 19500.00, 'UPI', 'Success'),
(6, 6, '2024-06-20', 16000.00, 'Wallet', 'Success'),
(7, 7, '2024-06-25', 14000.00, 'UPI', 'Success'),
(8, 8, '2024-06-28', 0.00, 'Credit Card', 'Failed'),
(9, 9, '2024-07-02', 15500.00, 'Net Banking', 'Success'),
(10, 10, '2024-07-05', 21000.00, 'UPI', 'Success');

CREATE TABLE HOTELS (
    hotel_id INT PRIMARY KEY,
    dest_id INT NOT NULL,
    hotel_name VARCHAR(100) NOT NULL,
    rating DECIMAL(3,2),
    price_per_night DECIMAL(10,2),
    amenities TEXT,

    FOREIGN KEY (dest_id) REFERENCES DESTINATIONS(dest_id)
);
INSERT INTO HOTELS (hotel_id, dest_id, hotel_name, rating, price_per_night, amenities)
VALUES
(1, 1, 'Goa Beach Resort', 4.50, 5500.00, 'Free WiFi, Swimming Pool, Beach Access, Spa'),
(2, 1, 'Sea View Goa Hotel', 4.20, 4800.00, 'Breakfast Included, Parking, Beach View'),
(3, 2, 'Himalayan Heights Manali', 4.70, 6200.00, 'Heated Rooms, Mountain View, Bonfire Area'),
(4, 2, 'Snow Valley Manali', 4.30, 4500.00, 'Free Parking, Restaurant, Tour Desk'),
(5, 3, 'Jaipur Palace Hotel', 4.00, 4000.00, 'Heritage Property, Free WiFi, Rooftop Dining'),
(6, 4, 'Royal Mysuru Stay', 4.10, 3500.00, 'Cultural Tours, Parking, Free Breakfast'),
(7, 5, 'Darjeeling Hills Resort', 4.60, 5000.00, 'Tea Garden View, Free WiFi, Fireplace'),
(8, 6, 'Kerala Backwater Retreat', 4.80, 7000.00, 'Houseboat Experience, Spa, Ayurvedic Treatments'),
(9, 1, 'Goa Luxury Villas', 4.90, 8500.00, 'Private Pool, Beach Access, Free Breakfast'),
(10, 2, 'Manali River View Stay', 4.40, 5100.00, 'River View, Mountain Excursions, Free WiFi');

select * from hotels;

CREATE TABLE HOTEL_BOOKINGS (
    hb_id INT PRIMARY KEY,
    booking_id INT NOT NULL,
    hotel_id INT NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    rooms INT DEFAULT 1,
    total_cost DECIMAL(10,2),

    FOREIGN KEY (booking_id) REFERENCES BOOKINGS(booking_id),
    FOREIGN KEY (hotel_id) REFERENCES HOTELS(hotel_id)
);

INSERT INTO HOTEL_BOOKINGS (hb_id, booking_id, hotel_id, check_in, check_out, rooms, total_cost)
VALUES
(1, 1, 1, '2024-07-15', '2024-07-20', 1, 27500.00),
(2, 2, 1, '2024-08-05', '2024-08-12', 2, 77000.00),
(3, 3, 2, '2024-07-01', '2024-07-06', 1, 24000.00),
(4, 4, 2, '2024-11-10', '2024-11-17', 2, 67200.00),
(5, 5, 3, '2024-09-10', '2024-09-15', 1, 20000.00),
(6, 6, 4, '2024-10-05', '2024-10-12', 1, 24500.00),
(7, 7, 5, '2024-09-25', '2024-09-30', 2, 54000.00),
(8, 8, 5, '2024-08-20', '2024-08-27', 1, 27000.00),
(9, 9, 6, '2024-10-01', '2024-10-07', 1, 52000.00),
(10, 10, 7, '2024-11-15', '2024-11-22', 2, 71400.00);

select * from bookings;
INSERT INTO BOOKINGS (booking_id, customer_id, dest_id, booking_date, travel_date, return_date, status, total_amount)
VALUES
(11, 1, 6, '2025-06-01', '2025-06-10', '2025-06-18', 'Confirmed', 24000.00),
(12, 2, 4, '2025-06-02', '2025-06-15', '2025-06-20', 'Confirmed', 18500.00),
(13, 3, 9, '2025-06-05', '2025-06-22', '2025-06-29', 'Confirmed', 29000.00),
(14, 1, 8, '2025-06-08', '2025-06-25', '2025-06-30', 'Confirmed', 20000.00);

-- 1st query List all customers who have made bookings in the last 30 days
SELECT c.customer_id, c.name, c.email, c.phone, b.booking_id, b.booking_date
FROM CUSTOMERS c
JOIN BOOKINGS b ON c.customer_id = b.customer_id
WHERE b.booking_date >= CURDATE() - INTERVAL 30 DAY;

-- 2nd query
SELECT d.city, d.country, COUNT(b.booking_id) AS total_bookings FROM DESTINATIONS d JOIN BOOKINGS b ON d.dest_id = b.dest_id 
GROUP BY d.city, d.country 
ORDER BY total_bookings DESC LIMIT 3;

-- 3rd query Calculate the total revenue generated from each destination 
SELECT 
    d.dest_id,
    d.city,
    d.country,
    SUM(b.total_amount) AS total_revenue
FROM 
    DESTINATIONS d
JOIN 
    BOOKINGS b ON d.dest_id = b.dest_id
GROUP BY 
    d.dest_id, d.city, d.country;
    
-- 4h query Display customers who have never made any booking 
SELECT 
    c.customer_id,
    c.name,
    c.email,
    c.phone
FROM 
    CUSTOMERS c
LEFT JOIN 
    BOOKINGS b ON c.customer_id = b.customer_id
WHERE 
    b.booking_id IS NULL;
    
-- Intermediate queries 
-- 1 query Find customers who have booked hotels with rating above 4.5 and spent more than 30000
SELECT c.customer_id,c.name,c.email,h.hotel_name,h.rating,hb.total_cost
FROM 
    CUSTOMERS c
JOIN 
    BOOKINGS b ON c.customer_id = b.customer_id
JOIN 
    HOTEL_BOOKINGS hb ON b.booking_id = hb.booking_id
JOIN 
    HOTELS h ON hb.hotel_id = h.hotel_id
WHERE 
    h.rating > 4.5
    AND hb.total_cost > 30000;

-- 2 Create a query to show monthly booking trends for the current year

SELECT 
    MONTH(booking_date) AS month_number,
    MONTHNAME(booking_date) AS month_name,
    COUNT(booking_id) AS total_bookings
FROM 
    BOOKINGS
WHERE 
    YEAR(booking_date) = YEAR(CURDATE())
GROUP BY 
    MONTH(booking_date), MONTHNAME(booking_date)
ORDER BY 
    month_number;

-- 3 List destinations where the average booking amount is above the overall average 

SELECT 
    d.dest_id,
    d.city,
    d.country,
    AVG(b.total_amount) AS avg_booking_amount
FROM 
    DESTINATIONS d
JOIN 
    BOOKINGS b ON d.dest_id = b.dest_id
GROUP BY 
    d.dest_id, d.city, d.country
HAVING 
    AVG(b.total_amount) > (SELECT AVG(total_amount) FROM BOOKINGS);

-- 4 Find customers who have visited the same destination more than once 
SELECT 
    b.customer_id,
    c.name,
    b.dest_id,
    d.city,
    d.country,
    COUNT(b.booking_id) AS visit_count
FROM 
    BOOKINGS b
JOIN 
    CUSTOMERS c ON b.customer_id = c.customer_id
JOIN 
    DESTINATIONS d ON b.dest_id = d.dest_id
GROUP BY 
    b.customer_id, b.dest_id
HAVING 
    COUNT(b.booking_id) > 1;
    
-- advanced 
-- 1 Create a stored procedure to calculate customer loyalty points based on total spending

DELIMITER $$

CREATE PROCEDURE CalculateLoyaltyPoints(IN input_customer_id INT)
BEGIN
    DECLARE total_spent DECIMAL(10,2);
    DECLARE loyalty_points INT DEFAULT 0;

    -- Step 1: Calculate total spending for the customer
    SELECT IFNULL(SUM(total_amount), 0)
    INTO total_spent
    FROM BOOKINGS
    WHERE customer_id = input_customer_id;

    -- Step 2: Assign loyalty points based on spending
    IF total_spent > 50000 THEN
        SET loyalty_points = 500;
    ELSEIF total_spent > 25000 THEN
        SET loyalty_points = 250;
    ELSEIF total_spent > 10000 THEN
        SET loyalty_points = 100;
    ELSE
        SET loyalty_points = 0;
    END IF;

    -- Step 3: Show result
    SELECT 
        input_customer_id AS customer_id, 
        total_spent AS total_spending, 
        loyalty_points AS loyalty_points;
END $$

DELIMITER ;


CALL CalculateLoyaltyPoints(1);

-- Write a trigger to automatically update the booking status when payment is completed 

DELIMITER $$

CREATE TRIGGER update_booking_status_after_payment
AFTER INSERT ON PAYMENTS
FOR EACH ROW
BEGIN
    IF NEW.status = 'Success' THEN
        UPDATE BOOKINGS
        SET status = 'Confirmed'
        WHERE booking_id = NEW.booking_id;
    END IF;
END $$

DELIMITER ;


