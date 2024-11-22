-- SQL Script for "Mysterious Bookstore" Database

-- Drop the database if it exists
DROP DATABASE IF EXISTS Mysterious_Bookstore;

-- Create the Mysterious Bookstore database
CREATE DATABASE Mysterious_Bookstore;

-- CREATE DATABASE IF NOT EXISTS School;

-- Switch to the Mysterious Bookstore database
USE Mysterious_Bookstore;

-- Drop tables if they exist
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Authors;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Customers;

-- Creating the 'Books' table
CREATE TABLE Books (
    BookID VARCHAR(10) PRIMARY KEY,
    Title VARCHAR(255),
    AuthorID VARCHAR(10),
    CategoryID VARCHAR(10),
    Price DECIMAL(10, 2)
);

-- Creating the 'Authors' table
CREATE TABLE Authors (
    AuthorID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(255),
    Country VARCHAR(255)
);

-- Creating the 'Categories' table
CREATE TABLE Categories (
    CategoryID VARCHAR(10) PRIMARY KEY,
    CategoryName VARCHAR(255)
);

-- Creating the 'Orders' table
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    BookID VARCHAR(10),
    CustomerID VARCHAR(10),
    Quantity INT,
    OrderDate DATE,
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

-- Creating the 'Customers' table
CREATE TABLE Customers (
    CustomerID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255)
);

-- Inserting sample data into 'Books'
INSERT INTO Books (BookID, Title, AuthorID, CategoryID, Price) VALUES
('B101', 'Mystery of the Old Library', 'A01', 'C01', 15.99),
('B102', 'The Lost Treasure', 'A02', 'C02', 9.99),
('B103', 'Adventures in SQL', 'A03', 'C03', 20.50),
('B104', 'The Great Adventure', 'A02', 'C02', 12.99),
('B105', 'SQL for Experts', 'A03', 'C03', 22.50),
('B106', 'Haunted Castle', 'A01', 'C01', 18.75),
('B108', 'The Spy’s Journal', 'A02', 'C01', 14.20);

-- Inserting sample data into 'Authors'
INSERT INTO Authors (AuthorID, Name, Country) VALUES
('A01', 'John Doe', 'USA'),
('A02', 'Emily Carter', 'UK'),
('A03', 'Alex Smith', 'Canada'),
('A04', 'Lisa Turner', 'Australia'),
('A05', 'Michael Johnson', 'Germany');

-- Inserting sample data into 'Categories'
INSERT INTO Categories (CategoryID, CategoryName) VALUES
('C01', 'Mystery'),
('C02', 'Adventure'),
('C03', 'Educational'),
('C04', 'Science Fiction'),
('C05', 'Romance');

-- Inserting sample data into 'Customers'
INSERT INTO Customers (CustomerID, Name, Email) VALUES
('CU01', 'Alice Brown', 'alice.brown@email.com'),
('CU02', 'Bob Johnson', 'bob.johnson@email.com'),
('CU03', 'Emily Carter', 'emily.carter@email.com'),
('CU04', 'David Clark', 'david.clark@email.com'),
('CU05', 'Sophia White', 'sophia.white@email.com');

-- Inserting sample data into 'Orders'
INSERT INTO Orders (OrderID, BookID, CustomerID, Quantity, OrderDate) VALUES
(1, 'B102', 'CU03', 1, '2023-05-15'),
(2, 'B103', 'CU04', 2, '2023-05-15'),
(3, 'B104', 'CU01', 1, '2023-05-16'),
(4, 'B105', 'CU02', 1, '2023-05-17'),
(5, 'B106', 'CU03', 3, '2023-06-10');

-- The database is now set up with sample data
