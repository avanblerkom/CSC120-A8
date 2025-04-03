/**
 * This class represents a House, which extends the Building class and implements HouseRequirements.
 * It manages residents and provides methods to move in, move out, and check residency.
 */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

    private ArrayList<Student> residents; // List of residents
    private boolean hasDiningRoom; // Indicates if the house has a dining room

    /**
     * Constructor to initialize the House.
     * @param name The name of the house.
     * @param address The address of the house.
     * @param nFloors The number of floors in the house.
     * @param hasDiningRoom Whether the house has a dining room.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors); // Call the Building constructor
        this.residents = new ArrayList<Student>(); // Initialize the residents list
        this.hasDiningRoom = hasDiningRoom; // Set the dining room status
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Checks if the house has a dining room.
     * @return True if the house has a dining room, false otherwise.
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Gets the number of residents in the house.
     * @return The number of residents.
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Moves a student into the house.
     * @param s The student to move in.
     */
    public void moveIn(Student s) {
        if (!this.residents.contains(s)) { // Check if the student is not already a resident
            this.residents.add(s); // Add the student to the residents list
            System.out.println(s.getName() + " has moved in.");
        } else {
            System.out.println(s.getName() + " is already a resident.");
        }
    }

    /**
     * Moves a student out of the house.
     * @param s The student to move out.
     * @return The student who moved out, or null if the student was not a resident.
     */
    public Student moveOut(Student s) {
        if (this.residents.remove(s)) { // Remove the student if they are a resident
            System.out.println(s.getName() + " has moved out.");
            return s; // Return the student who moved out
        } else {
            System.out.println(s.getName() + " is not a resident.");
            return null; // Return null if the student was not a resident
        }
    }

    /**
     * Checks if a student is a resident of the house.
     * @param s The student to check.
     * @return True if the student is a resident, false otherwise.
     */
    public boolean isResident(Student s) {
        return this.residents.contains(s); // Check if the student is in the residents list
    }

    public static void main(String[] args) {
        House myHouse = new House("Maple House", "123 Maple St", 3, true);
        System.out.println("Dining room: " + myHouse.hasDiningRoom());
        System.out.println("Number of residents: " + myHouse.nResidents());
    }

    @Override
    public void showOptions() {
        super.showOptions(); // Call the superclass method to include general options
        System.out.println("Additional options for House:\n" +
                           " + moveIn(Student s)\n" +
                           " + moveOut(Student s)\n" +
                           " + isResident(Student s)\n" +
                           " + hasDiningRoom()\n" +
                           " + nResidents()");
    }

}

