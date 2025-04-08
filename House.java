/**
 * This class represents a House, which extends the Building class 
 * It manages residents and provides methods to move in, move out, and check residency.
 */
import java.util.ArrayList;

public class House extends Building {

    private ArrayList<Student> residents; // List of residents
    private boolean hasDiningRoom; // Indicates if the house has a dining room
    private boolean hasElevator; // Indicates if the house has an elevator

    /**
     * Constructor to initialize the House.
     * @param name The name of the house.
     * @param address The address of the house.
     * @param nFloors The number of floors in the house.
     * @param hasDiningRoom Whether the house has a dining room.
     * @param hasElevator Whether the house has an elevator.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors); // Call the Building constructor
        this.residents = new ArrayList<Student>(); // Initialize the residents list
        this.hasDiningRoom = hasDiningRoom; // Set the dining room status
        this.hasElevator = hasElevator; // Set the elevator status
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
    public void studentname(Student s) {
        if (!this.residents.contains(s)) { // Check if the student is not already a resident
            this.residents.add(s); // Add the student to the residents list
            System.out.println(s.getName() + " has moved in.");
        } else {
            System.out.println(s.getName() + " is already a resident.");
        }
    }

    /**
     * Moves a resident into the house by their name.
     * @param resname The name of the resident to move in.
     */
    public void moveIn(Student s) {
        // Check if a resident with the given name already exists
        for (Student resident : this.residents) {
            if (resident.getName().equals(s.getName())) {
                System.out.println(s.getName() + " is already a resident.");
                return; // Exit the method if the resident already exists
            }
        }

        // If no resident with the given name exists, create a new Student and add them
        Student newResident = s; // Use the provided Student object directly
        this.residents.add(newResident);
        System.out.println(s.getName() + " has moved in.");
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
     * Moves a resident out of the house by their name, with an option to notify them.
     * @param resident The name of the resident to move out.
     * @param notify Whether to notify the resident.
     * @return The student who moved out, or null if the resident was not found.
     */
    public Student moveOut(String resident, boolean notify) {
        for (Student s : this.residents) { // Iterate through the residents list
            if (s.getName().equals(resident)) { // Match the name of the resident
                this.residents.remove(s); // Remove the resident from the list
                if (notify) {
                    System.out.println("Notification: " + resident + " has been moved out.");
                } else {
                    System.out.println(resident + " has moved out.");
                }
                return s; // Return the removed Student object
            }
        }
        System.out.println(resident + " is not a resident.");
        return null; // Return null if the resident was not found
    }

    /**
     * Checks if a student is a resident of the house.
     * @param s The student to check.
     * @return True if the student is a resident, false otherwise.
     */
    public boolean isResident(Student s) {
        return this.residents.contains(s); // Check if the student is in the residents list
    }

    /**
     * Override the goToFloor method to allow non-adjacent floor movement if the house has an elevator.
     * @param floorNum The floor number to go to.
     */
    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }
        // Check if the house does not have an elevator and restrict movement to adjacent floors
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("This house does not have an elevator. You can only move to adjacent floors.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public static void main(String[] args) {
        House myHouse = new House("Maple House", "123 Maple St", 3, true, true);
        System.out.println("Dining room: " + myHouse.hasDiningRoom());
        System.out.println("Number of residents: " + myHouse.nResidents());
    }

    @Override
    public void showOptions() {
        super.showOptions(); // Call the superclass method to include general options
        System.out.println("Additional options for House:\n" +
                           " + moveIn(Student s)\n" +
                           " + moveIn(String name)\n" +
                           " + moveOut(Student s)\n" +
                           " + moveOut(String name, boolean notify)\n" +
                           " + isResident(Student s)\n" +
                           " + hasDiningRoom()\n" +
                           " + nResidents()\n" +
                           " + goToFloor(int floorNum)");
    }

}

