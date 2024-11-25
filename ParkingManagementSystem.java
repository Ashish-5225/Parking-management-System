import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingManagementSystem {

    // Model class
    static class ParkingSpot {
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

        public void setSpotNumber(int spotNumber) {
            this.spotNumber = spotNumber;
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
    }

    // DAO class
    static class ParkingSpotDAO {
        private final List<ParkingSpot> parkingSpots;

        public ParkingSpotDAO(int totalSpots) {
            parkingSpots = new ArrayList<>();
            for (int i = 0; i < totalSpots; i++) {
                parkingSpots.add(new ParkingSpot(i + 1));
            }
        }

        public List<ParkingSpot> getAllParkingSpots() {
            return parkingSpots;
        }

        public ParkingSpot findSpotByNumber(int spotNumber) {
            return parkingSpots.stream()
                    .filter(spot -> spot.getSpotNumber() == spotNumber)
                    .findFirst()
                    .orElse(null);
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

    // Service class
    static class ParkingLotService {
        private final ParkingSpotDAO parkingSpotDAO;

        public ParkingLotService(int totalSpots) {
            this.parkingSpotDAO = new ParkingSpotDAO(totalSpots);
        }

        public void parkVehicle(String licensePlate) {
            ParkingSpot availableSpot = parkingSpotDAO.findAvailableSpot();
            if (availableSpot != null) {
                availableSpot.parkVehicle(licensePlate);
                System.out.println("Vehicle with license plate " + licensePlate + " parked at spot " + availableSpot.getSpotNumber());
            } else {
                System.out.println("No available parking spots!");
            }
        }

        public void removeVehicle(String licensePlate) {
            ParkingSpot occupiedSpot = parkingSpotDAO.findSpotByLicensePlate(licensePlate);
            if (occupiedSpot != null) {
                occupiedSpot.removeVehicle();
                System.out.println("Vehicle with license plate " + licensePlate + " removed from spot " + occupiedSpot.getSpotNumber());
            } else {
                System.out.println("Vehicle with license plate " + licensePlate + " not found!");
            }
        }

        public void displayParkingStatus() {
            System.out.println("\nParking Lot Status:");
            for (ParkingSpot spot : parkingSpotDAO.getAllParkingSpots()) {
                if (spot.isOccupied()) {
                    System.out.println("Spot " + spot.getSpotNumber() + ": Occupied by vehicle with license plate " + spot.getLicensePlate());
                } else {
                    System.out.println("Spot " + spot.getSpotNumber() + ": Empty");
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of parking spots: ");
        int totalSpots = scanner.nextInt();

        ParkingLotService parkingLotService = new ParkingLotService(totalSpots);

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
                    parkingLotService.parkVehicle(licensePlate);
                }
                case 2 -> {
                    System.out.print("Enter vehicle license plate to remove: ");
                    String removePlate = scanner.nextLine();
                    parkingLotService.removeVehicle(removePlate);
                }
                case 3 -> parkingLotService.displayParkingStatus();
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

