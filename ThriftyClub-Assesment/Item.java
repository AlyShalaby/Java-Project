
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
   private String name;
    private int price; // Price in pence

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, int price)
    {
        // initialise instance variables
        this.name = name;
        this.price = price;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
     // Accessor methods
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Returns the price in a user-friendly format (e.g., "150p").
     * @return The price as a formatted string.
     */
    public String getPriceString() {
        return name + " at " + price + "p";
    }
    private String convertPenceToString(int pence) {
        double pounds = pence / 100.0;
        return "£" + String.format("%.2f", pounds);
    }
}
