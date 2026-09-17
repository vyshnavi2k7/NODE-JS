//) Create an interface named Restaurant.
//create a method that will print the name of the restaurant when called. 
//Create an abstract method called addItem which adds the Item objects to the menu (item array).
// create an abstract method named getmenu which returns an item array. 
//create an abstract method placeOrder to generate order. 
//create an abstract method named generateBill which takes orderid and returns totalAmount with 6% tax.
// create a class called KFC that implements Restaurant.
// (Create Item and Order bean classes having required data).

package javalab1;

interface Res {
   void printRestaurantName();
   void addItem(Item item);
   Item[] getMenu();
   Order placeOrder(Item[] items);
   double generateBill(int orderId);    }
class Item {
   private int itemId;
   private String itemName;
   private double price;
   public Item() {
   }
   public Item(int itemId, String itemName, double price) {
       this.itemId = itemId;
       this.itemName = itemName;
       this.price = price;  }
   public int getItemId() {
       return itemId;    }
   public void setItemId(int itemId) {
       this.itemId = itemId;  }
   public String getItemName() {
       return itemName;                  
   }
class KFC implements Res {
   Item[] menu = new Item[10];
   int count = 0;
   Order[] orders = new Order[10];
   int orderCount = 0;
   int orderId = 1001;
   public void printRestaurantName() {
       System.out.println("Restaurant Name: KFC");
   }
 public void addItem(Item item) {
       if (count < menu.length) {
           menu[count] = item;
           count++;
           System.out.println(item.getItemName() + " added to menu");
       } else {
           System.out.println("Menu is full");
       }
   }
   public Item[] getMenu() {
       Item[] items = new Item[count];
  for (int i = 0; i < count; i++) {
           items[i] = menu[i];
       }
       return items; 
  }
}
}
