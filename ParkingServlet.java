package com.example.parking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/parking")
public class ParkingServlet extends HttpServlet {
    private ParkingSpotDAO parkingSpotDAO;

    @Override
    public void init() throws ServletException {
        // Initialize DAO with 10 parking spots
        int totalSpots = Integer.parseInt(getServletConfig().getInitParameter("totalSpots"));
        parkingSpotDAO = new ParkingSpotDAO(totalSpots);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("park".equals(action)) {
            String licensePlate = request.getParameter("licensePlate");
            ParkingSpot availableSpot = parkingSpotDAO.findAvailableSpot();

            if (availableSpot != null) {
                availableSpot.parkVehicle(licensePlate);
                request.setAttribute("message", "Vehicle parked at spot " + availableSpot.getSpotNumber());
            } else {
                request.setAttribute("message", "No available parking spots!");
            }
        } else if ("remove".equals(action)) {
            String licensePlate = request.getParameter("licensePlate");
            ParkingSpot occupiedSpot = parkingSpotDAO.findSpotByLicensePlate(licensePlate);

            if (occupiedSpot != null) {
                occupiedSpot.removeVehicle();
                request.setAttribute("message", "Vehicle removed from spot " + occupiedSpot.getSpotNumber());
            } else {
                request.setAttribute("message", "Vehicle not found!");
            }
        }

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("parkingSpots", parkingSpotDAO.getAllParkingSpots());
        request.getRequestDispatcher("views/parkingStatus.jsp").forward(request, response);
    }
}
