import java.util.*;

/* CLASS - RoomInventory */
class RoomInventory {

    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 4);
        rooms.put("Suite", 3);
    }

    public void releaseRoom(String roomType) {
        rooms.put(roomType, rooms.getOrDefault(roomType, 0) + 1);
    }

    public int getAvailability(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }
}


/* CLASS - CancellationService */
class CancellationService {

    // Stack that stores recently released room IDs
    private Stack<String> releasedRoomIds;

    // Maps reservation ID to room type
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        inventory.releaseRoom(roomType);

        releasedRoomIds.push(reservationId);

        System.out.println(
                "Booking cancelled successfully. Inventory restored for room type: "
                        + roomType
        );
    }

    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.pop());
        }
    }
}


/* MAIN CLASS */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Simulate a confirmed booking
        String reservationId = "Single-1";
        cancellationService.registerBooking(reservationId, "Single");

        // Cancel booking
        cancellationService.cancelBooking(reservationId, inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Show updated inventory
        System.out.println(
                "\nUpdated Single Room Availability: "
                        + inventory.getAvailability("Single")
        );
    }
}