import java.util.Scanner;

// ParkingSpot class representing a parking spot
class ParkingSpot {
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

    public void parkVehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.licensePlate = null;
        this.isOccupied = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}

// ParkingLot class managing the parking lot
class ParkingLot {
    private ParkingSpot[] parkingSpots;

    public ParkingLot(int totalSpots) {
        parkingSpots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1);
        }
    }

    // Method to park a vehicle
    public void parkVehicle(String licensePlate) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied()) {
                spot.parkVehicle(licensePlate);
                System.out.println("Vehicle with license plate " + licensePlate + " parked at spot " + spot.getSpotNumber());
                return;
            }
        }
        System.out.println("No available parking spots!");
    }

    // Method to remove a vehicle
    public void removeVehicle(String licensePlate) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isOccupied() && spot.getLicensePlate().equals(licensePlate)) {
                spot.removeVehicle();
                System.out.println("Vehicle with license plate " + licensePlate + " removed from spot " + spot.getSpotNumber());
                return;
            }
        }
        System.out.println("Vehicle with license plate " + licensePlate + " not found!");
    }

    // Method to display parking status
    public void displayParkingStatus() {
        System.out.println("\nParking Lot Status:");
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isOccupied()) {
                System.out.println("Spot " + spot.getSpotNumber() + ": Occupied by vehicle with license plate " + spot.getLicensePlate());
            } else {
                System.out.println("Spot " + spot.getSpotNumber() + ": Empty");
            }
        }
    }

    public void setParkingSpots(ParkingSpot[] parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}

// Main class to run the parking management system
public class ParkingManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of parking spots: ");
        int totalSpots = scanner.nextInt();

        ParkingLot parkingLot = new ParkingLot(totalSpots);

        while (true) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Parking Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter vehicle license plate: ");
                    String licensePlate = scanner.nextLine();
                    parkingLot.parkVehicle(licensePlate);
                }

                case 2 -> {
                    System.out.print("Enter vehicle license plate to remove: ");
                    String removePlate = scanner.nextLine();
                    parkingLot.removeVehicle(removePlate);
                }

                case 3 -> parkingLot.displayParkingStatus();

                case 4 -> {
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
