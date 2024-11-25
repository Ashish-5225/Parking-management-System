

# Intelligent Parking System for Efficient Urban Mobility

This repository contains the code for the **Intelligent Parking Solutions for Efficient Urban Mobility** project. This solution leverages **HTML**, **CSS**, **JavaScript**, **Java**, and **MySQL** to provide advanced parking solutions that optimize space, reduce congestion, and enhance the driver experience.

---

## Features

### 1. Real-time Parking Availability Monitoring
- **Sensor Network**: Continuously tracks parking space availability in real-time.
- **Data Integration**: Aggregates sensor data for accurate parking information.
- **Visibility and Guidance**: Directs drivers to available spaces via digital signage and mobile apps.

### 2. Automated Parking Guidance and Navigation
- **Intelligent Routing**: Guides drivers to the nearest available space using dynamic algorithms.
- **Wayfinding Assistance**: Provides clear directions via digital signage and in-vehicle navigation.
- **Automated Parking**: Enables vehicles to self-park, maximizing space utilization.

### 3. Seamless Parking Reservation and Payment
- **Reservation System**: Allows users to reserve parking spaces through mobile apps or kiosks.
- **Contactless Payment**: Integrates multiple payment options for a frictionless experience.
- **Validation and Enforcement**: Ensures compliance and fairness in the parking system.

### 4. Dynamic Pricing for Optimal Utilization
- **Demand-based Pricing**: Adjusts rates dynamically based on occupancy and demand.
- **Revenue Optimization**: Maximizes city revenue while reducing congestion.
- **Equitable Access**: Balances the needs of various user groups.

---

## Tech Stack

### Frontend
- **HTML**: Structure and content of the web page.
- **CSS**: Styling for the application, including responsive design and animations.
- **JavaScript**: Adds interactivity, smooth scrolling, and dynamic updates.

### Backend
- **Java**: Handles server-side logic, including real-time data processing and API integration.

### Database
- **MySQL**: Stores parking availability, reservations, user data, and pricing information.

---

## Installation

### Prerequisites
1. Install MySQL on your system. 
2. Install Java (JDK 8+).
3. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/intelligent-parking-solutions.git

Frontend Setup

1. Navigate to the project directory:

cd intelligent-parking-solutions


2. Open the index.html file in your browser to view the frontend.



Backend Setup

1. Compile the Java files:

javac -d bin src/*.java


2. Run the backend server:

java -cp bin Main



Database Setup

1. Open your MySQL terminal or GUI tool.


2. Create a new database:

CREATE DATABASE parking_system;


3. Import the provided SQL schema and data:

mysql -u your_username -p parking_system < database/parking_system.sql


4. Update the database connection credentials in the Java backend:

Open the file src/DatabaseConnection.java.

Update the url, username, and password fields:

String url = "jdbc:mysql://localhost:3306/parking_system";
String username = "your_username";
String password = "your_password";





---

Usage

1. Frontend:

Modify the idp.css file to customize the appearance.

Edit the idp.js file for frontend interactivity.



2. Backend:

Enhance the src Java files to add additional logic or API endpoints.



3. Database:

Update or expand the MySQL database schema (database/parking_system.sql) to add new tables or relationships.





---

Project Structure

Frontend

       index.html          # Main HTML file
       idp.css             # CSS stylesheet
       idp.js              # JavaScript for interactivity

Backend


       Main.java        # Entry point for the backend
       DatabaseConnection.java # Handles MySQL connection
  
Database

       parking_system.sql   # SQL schema and initial data

README.md  

         # Project documentation







