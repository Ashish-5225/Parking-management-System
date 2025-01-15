package com.example.ParkingManagementSystem ;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private String licensePlate;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.licensePlate = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void parkVehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.licensePlate = null;
        this.isOccupied = false;
    }
}
