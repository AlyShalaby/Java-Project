
/**
 * The Member class keeps track of a members name and id 
 * pin and  the store they are in what item they pick how much
 * money they have and what they bought last. It lets the
 * member choose an item pay for it and check what they
 * bought before.
 * @author (Aly Shalaby)
 * @version (28/11/2024)
 */
public class Member
{
    // instance variables - replace the example below with your own
    private String name;
    private String id;  // uniqe id max length 10
    private String pinNumber;  // four digits 
    private Store store; //store the member
    private Item item; // The item selected by the member
    private int money; // Money in pence default= 500
    private String lastPurchasedItem; //tracks the last purchased
    private ArrayList<Item> basket;
    /**
     * Constructor to initialize Member details.
     */
    public Member(String name, String id, String pinNumber)
    {
        // initialise instance variables
        this.name = name;
        this.id = id;
        this.pinNumber = pinNumber;
        this.money = 500; // Default wallet amount in pence
        this.lastPurchasedItem = "No purchases yet"; //default message
        basket = new ArrayList<>();
      
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public Store getStore() {
        return store;
    }

    

    public int getMoney() {
        return money;
    }

    // Mutator methods
    public void selectItem(Item item) {
        basket.add(item);  // Adds the selected item to the basket
    }
    public void setStore(Store store) {
        this.store = store;
    }

    public void selectItem(Item item) {
        this.item = item;
        System.out.println(name + " has selected the item: " + item.getName() + " for " + item.getPriceString());
    }
    public int calculateCostOfBasket() {
        int totalCost = 0;
        int counter = 0;
        while (counter < basket.size()) {
            totalCost += basket.get(counter).getPrice();
            counter++;
        }
        return totalCost;
        }
    public void showBasket() {
        System.out.println("Your basket contains " + basket.size() + " items:");
        int counter = 1;
        while (counter <= basket.size()) {
            System.out.println(basket.get(counter - 1).toString());
            counter++;
        }
        }
    /**
     *  initiate checkout for the selected item.
     * 
     */
    public void goToCheckout(int payment) {
        if (store != null && item != null) {
            store.checkout(payment, this);
            updateLastPurchasedItem(item); // Update last purchase after checkout
        } else {
            System.out.println("You must select a store and an item before checkout.");
        }
    }
    public void putItemBack(int index) {
        if (index >= 0 && index < basket.size()) {
            basket.remove(index);  // Remove item at the specified index
        }
    }  
    public void putItemBack(String name) {
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).getName().equals(name)) {
                basket.remove(i);  // Remove item by name
                return;
            }
        }
    }
}

public class Member {
    private ArrayList<Item> basket;

    public void putExpensiveItemsBack(int price) {
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).getPrice() >= price) {
                basket.remove(i);  // Remove expensive items
                i--;  // Adjust index after removal
            }
        }
    }
    /**
     * Deducts the amount from the member's money after purchase.
     */
    public void deductMoney(int amount) {
        if (amount > 0 && amount <= money) {
            money -= amount;
        }
    }
    private void updateLastPurchasedItem(Item item) {
        lastPurchasedItem = item.getName() + " at " + item.getPriceString();
    }

    public void viewLastPurchasedItem() {
        System.out.println(name + "s Last Purchase: " + lastPurchasedItem);
    }
}
