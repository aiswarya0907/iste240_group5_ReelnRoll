CREATE DATABASE IF NOT EXISTS iste240;
USE iste240;

CREATE TABLE IF NOT EXISTS seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY, seat_number VARCHAR(20) NOT NULL,
    seat_type VARCHAR(50) NOT NULL,
    booked BOOLEAN NOT NULL DEFAULT FALSE,
    theatre_id INT NOT NULL
    );

INSERT INTO seats (seat_number, seat_type, booked, theatre_id) VALUES

('A1', 'Regular', false, 1),
('A2', 'Regular', false, 1),
('A3', 'Regular', true, 1),
('A4', 'Regular', false, 1),
('A5', 'Regular', false, 1),
('A6', 'Regular', true, 1),
('A7', 'Regular', false, 1),
('A8', 'Regular', false, 1),


('B1', 'Premium', false, 1),
('B2', 'Premium', true, 1),
('B3', 'Premium', false, 1),
('B4', 'Premium', false, 1),
('B5', 'Premium', true, 1),
('B6', 'Premium', false, 1),


('C1', 'VIP', false, 1),
('C2', 'VIP', false, 1),
('C3', 'VIP', true, 1),
('C4', 'VIP', false, 1),
('C5', 'VIP', true, 1);