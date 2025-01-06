package com.example.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotDAO {
    private final List<ParkingSpot> parkingSpots;

    public ParkingSpotDAO(int totalSpots) {
        parkingSpots = new ArrayList<>();
        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpots;
    }

    public ParkingSpot findAvailableSpot() {
        return parkingSpots.stream()
                .filter(spot -> !spot.isOccupied())
                .findFirst()
                .orElse(null);
    }

    public ParkingSpot findSpotByLicensePlate(String licensePlate) {
        return parkingSpots.stream()
                .filter(spot -> spot.isOccupied() && spot.getLicensePlate().equals(licensePlate))
                .findFirst()
                .orElse(null);
    }
}
