
/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    private String storeName;
    private int total; // Total money collected at checkout
    private ArrayList<Item> basket;
    private int maxNumberOfItems = 5;  // Max number of items in the basket
    /**
     * Constructor to initialize Store details.
     * @param storeName The name of the store.
     */
    public Store(String storeName)
    {
        // initialise instance variables
        this.storeName = storeName;
        this.total = 0;
        this.basket = new ArrayList<>(); 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // Accessor methods
    public String getStoreName() {
        return storeName;
    }

    public int getTotal() {
        return total;
    }
    public Member() {
        basket = new ArrayList<>();
    }
      public void showMembers() {
        System.out.println("The members of this store are:");
        for (Member member : members) {
            System.out.println(member.getName() + " with id " + member.getId());
        }
    }
    public boolean basketOverFull(ArrayList<Item> basket) {
        return basket.size() > maxNumberOfItems;
    }
    public void checkout() {
        // Process basket items...
        basket.clear();  // Empty the basket after checkout
    }
    /**
     * Registers a member who enters the store.
     * @param member The member entering the store.
     */
    public void memberRegister1(Member member) {
        member.setStore(this);
        System.out.println("Welcome to " + storeName + ", " + member.getName());
    }

    /**
     * Registers a member using details and creates a temporary Member object.
     * @param name The name of the member.
     * @param id The unique ID of the member.
     * @param pinNumber The 4-digit PIN of the member.
     */
    public void memberRegister2(String name, String id, String pinNumber) {
        Member tempMember = new Member(name, id, pinNumber);
        tempMember.setStore(this);
        System.out.println("Welcome to " + storeName + ", " + tempMember.getName());
    }
    public void checkout(Member member) {
        ArrayList<Item> basket = member.getBasket();  // Get the basket from the member
        int totalCost = 0;

        System.out.println("Salford Thrifty Store: Serving " + member.getName());
        System.out.println("Your basket contains " + basket.size() + " items:");
        for (Item item : basket) {
            System.out.println(item.toString());
            totalCost += item.getPrice();
        }
        
        System.out.println("The total cost is " + totalCost + "p");
    }
    /**
     * Handles checkout for the given member.
     * @param amount The payment provided by the member.
     * @param member The member making the purchase.
     */
    public void checkout(int amount, Member member) {
        if (member.getItem() == null) {
            System.out.println("No item selected for purchase.");
            return;
        }

        int itemPrice = member.getItem().getPrice();

        if (amount < itemPrice) {
            System.out.println("Insufficient payment. Item price is " + member.getItem().getPriceString());
        } else {
            int change = amount - itemPrice;
            total += itemPrice;
            member.deductMoney(itemPrice);

            System.out.println("Receipt:");
            System.out.println("Store: " + storeName);
            System.out.println("Member: " + member.getName());
            System.out.println("Item: " + member.getItem().getName() + " - " + member.getItem().getPriceString());
            System.out.println("Payment: " + amount + "p");
            System.out.println("Change: " + change + "p");
            System.out.println("Thank you for shopping with us!");
        }
    }
}
