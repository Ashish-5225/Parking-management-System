-- Create the database
CREATE DATABASE ParkingManagementSystem1;

USE ParkingManagementSystem1;

-- Users Table
CREATE TABLE Users (
    UserID INT(101) PRIMARY KEY,
    UserName VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(15) NOT NULL UNIQUE,
    Email VARCHAR(100) NOT NULL UNIQUE,
    UserType VARCHAR(20) NOT NULL CHECK (UserType IN ('Customer', 'Admin')) -- Define user roles
);

-- Parking Slots Table
CREATE TABLE ParkingSlots (
    SlotID INT (201) PRIMARY KEY,
    SlotNumber VARCHAR(10) NOT NULL UNIQUE,
    IsAvailable BIT DEFAULT 1 NOT NULL, -- 1 for available, 0 for occupied
    PricePerHour DECIMAL(10, 2) NOT NULL,
    Location VARCHAR(100) NOT NULL
);

-- Reservations Table
CREATE TABLE Reservations (
    ReservationID INT (101) PRIMARY KEY,
    UserID INT NOT NULL,
    SlotID INT NOT NULL,
    
    StartTime DATETIME NOT NULL,
    EndTime DATETIME NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL, -- This will be updated via triggers or application logic
    CONSTRAINT FK_Reservations_UserID FOREIGN KEY (UserID) REFERENCES Users(UserID),
    CONSTRAINT FK_Reservations_SlotID FOREIGN KEY (SlotID) REFERENCES ParkingSlots(SlotID)
);

-- Payments Table
CREATE TABLE Payments (
    PaymentID INT (401) PRIMARY KEY,
    ReservationID INT NOT NULL,
 
    AmountPaid DECIMAL(10, 2) NOT NULL,
    PaymentMethod VARCHAR(20) NOT NULL CHECK (PaymentMethod IN ('Cash', 'Card', 'Online')),
    CONSTRAINT FK_Payments_ReservationID FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID)
);

