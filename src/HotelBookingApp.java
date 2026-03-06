abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size (sq ft): " + squareFeet);
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("Single Room Details");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailability);

        System.out.println("\nDouble Room Details");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability);

        System.out.println("\nSuite Room Details");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}