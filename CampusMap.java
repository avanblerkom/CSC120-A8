import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);

        // Add instances of House
        House kingHouse = new House("King House", "10 Elm St", 3, true, true);
        Student alice = new Student("Alice", "12345", 2025);
        Student bob = new Student("Bob", "67890", 2024);
        kingHouse.moveIn(alice);
        kingHouse.moveIn(bob);
        kingHouse.moveOut(alice);
        myMap.addBuilding(kingHouse);

        House chaseHouse = new House("Chase House", "20 Green St", 2, false, false);
        Student charlie = new Student("Charlie", "54321", 2023);
        Student dave = new Student("Dave", "09876", 2022);
        chaseHouse.moveIn(charlie);
        chaseHouse.moveOut(dave);
        myMap.addBuilding(chaseHouse);

        // Add instances of Library
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive", 4, true);
        neilsonLibrary.addTitle("Introduction to Java");
        neilsonLibrary.addTitle("Data Structures", true);
        neilsonLibrary.checkOut("Introduction to Java", 7);
        myMap.addBuilding(neilsonLibrary);

        Library youngLibrary = new Library("Young Library", "15 Chapin Way", 3, false);
        youngLibrary.addTitle("Algorithms");
        youngLibrary.checkOut("Algorithms", 14);
        myMap.addBuilding(youngLibrary);

        // Add instances of Cafe
        Cafe campusCafe = new Cafe("Campus Cafe", "123 College St", 2, 100, 50, 30, 20);
        campusCafe.sellCoffee(12, 2, 1);
        campusCafe.restock(50, 20, 10, 5);
        myMap.addBuilding(campusCafe);

        Cafe fordCafe = new Cafe("Ford Cafe", "100 Green St", 1, 200, 100, 50, 40);
        fordCafe.sellCoffee(16, 3, 2);
        myMap.addBuilding(fordCafe);

        // Add additional buildings
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "1 Chapin Way Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "44 College Lane Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConnell Hall", "2 College Lane Northampton, MA 01063", 4));

        // Print the campus map
        System.out.println(myMap);
    }
}
