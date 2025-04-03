/**
 * This class represents a Cafe, which extends the Building class and implements CafeRequirements.
 * It manages inventory for coffee, sugar, cream, and cups, and provides methods to sell coffee and restock inventory.
 */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor to initialize the Cafe with starting inventory.
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     * @param nFloors The number of floors in the cafe.
     * @param nCoffeeOunces Initial coffee inventory in ounces.
     * @param nSugarPackets Initial sugar packet inventory.
     * @param nCreams Initial cream inventory.
     * @param nCups Initial cup inventory.
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); // Call the Building constructor
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a cup of coffee, decreasing inventory based on the size and ingredients used.
     * If inventory is insufficient, restocks automatically.
     * @param size The size of the coffee in ounces.
     * @param nSugarPackets The number of sugar packets used.
     * @param nCreams The number of cream splashes used.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCoffeeOunces < size || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || nCups < 1) {
            System.out.println("Not enough stock to sell coffee. Restocking...");
            restock(size, nSugarPackets, nCreams, 1); // Restock with the required amounts
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sold a coffee of size " + size + "oz with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
    }

    /**
     * Restocks the cafe's inventory.
     * @param nCoffeeOunces The amount of coffee to add in ounces.
     * @param nSugarPackets The number of sugar packets to add.
     * @param nCreams The number of cream splashes to add.
     * @param nCups The number of cups to add.
     */
    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked: " + nCoffeeOunces + " coffee ounces, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups.");
    }

    @Override
    public void showOptions() {
        super.showOptions(); // Call the superclass method to include general options
        System.out.println("Additional options for Cafe:\n" +
                           " + sellCoffee(int size, int nSugarPackets, int nCreams)\n" +
                           " + restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups)");
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "123 College St", 1, 100, 50, 30, 20);
        myCafe.sellCoffee(12, 2, 3);
        myCafe.sellCoffee(100, 10, 5); // This will trigger restocking
    }
}
