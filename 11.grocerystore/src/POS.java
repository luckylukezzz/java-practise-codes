import java.util.*;
import java.io.*;


// class Cart implements Serializable {
//     private Map<Item, Integer> map = new HashMap<>();
//     private Customer customer;
//     public Cart(Customer customer) {
//         this.customer = customer;
//     }
//     public void addCartItem(Item item, Integer no){
//         map.put(item,no);
//     }
//     public Map<Item, Integer> getMap() {
//         return map;
//     }
//     public Customer getCustomer() {
//         return customer;
//     }
    
    
//     }

class people implements Serializable {
    private String name ;

    public people(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Cashier extends people {
    private String Branch;
    public Cashier(String name,String Branch) {
        super(name);
        this.Branch=Branch;
    }
    public String getBranch(){
        return Branch;
    }
}

class Customer extends people {
    public Customer(String name) {
        super(name);
    }
}

class Item implements Serializable {
    private int itemNo;
    private String name;
    private  int price;
    private int discount;
    private  int weight;
    private String manufacture;
    private String mfd;
    private  String exp;
    public Item(String name, int price,int discount, int weight, String manufacture, String mfd, String exp) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.manufacture = manufacture;
        this.mfd = mfd;
        this.exp = exp;
        this.discount=discount;
       
    }
    public int getItemNo() {
        return itemNo;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getDiscount() {
        return discount;
    }
      
  
}

class Bill implements Serializable {
    private int count=0;
    private Cashier cashier ;
    private Customer customer;
    public Bill(Cashier cashier, Customer customer) {
        this.cashier = cashier;
        this.customer = customer;
    }
    public void addItem(Item item, int amount) {
        count+=(item.getPrice()-item.getDiscount()*item.getPrice()/100)*amount ;
    }

    public void show(){
        System.out.println("bill issued by "+cashier.getName()+ " from "+cashier.getBranch()+" branch.");
        System.out.println("customer: "+ customer.getName());
        System.out.println("total price Rs. "+ count);
    }

    
}

class ItemCodeNotFound extends Exception {
    public ItemCodeNotFound(String message) {
        super(message);
    }
}
// private Item fetchItemDetails(int itemNo) throws ItemCodeNotFound {
   
//     if (!itemList.containsKey(itemNo)) {
//         throw new ItemCodeNotFound("Item code " + itemNo + " not found in the database.");
//     }
    
//     return itemList.get(itemNo);
// }




public class POS{
    public static Item fetchItemDetails(int itemNo , Map<Integer, Item> itemList) throws ItemCodeNotFound {
   
        if (!itemList.containsKey(itemNo)) {
            throw new ItemCodeNotFound("Item code " + itemNo + " not found in the database.");
        }
        
       return itemList.get(itemNo);
    }
    public static void main(String[] args) throws IOException {
        Map<Integer, Item> itemList = new HashMap<>();
        itemList.put(1,new Item("Apple",20,0,50,"tasty friuts","5/23","7/23"));
        itemList.put(2,new Item("Apple",20,0,50,"tasty friuts","5/23","7/23"));
        itemList.put(3, new Item("pineapple",100,0,200,"tasty friuts","5/23","7/23"));
        itemList.put(4,new Item("soap",100,20,50,"lux","1/23","8/25"));
        itemList.put(5,new Item("brush",100,10,20,"signal","1/23","8/25"));
        boolean x = true;
        Cashier cashier1 = new Cashier("Saman","Moratuwa");
        Customer customer1 = new Customer("john");
        Bill bill1 = new Bill(cashier1,customer1 );
        while (x){
            try {
                    InputStreamReader r = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(r);
                    String[] parts = br.readLine().split(" ");
                    if (parts[0].equals("s")){
                        FileOutputStream fileStream = new FileOutputStream("tempbill.txt");
                        ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
                        objStream.writeObject(bill1);
                        objStream.close();
                        
                    }
                    else if( parts[0].equals("-1")){
                        bill1.show();
                        break;
                    }

                    else{
                    int itemNo =Integer.parseInt(parts[0] );
                    int amount =Integer.parseInt(parts[1] );
                    Item a = fetchItemDetails(itemNo , itemList);
                    bill1.addItem(a, amount);
                    }
                    // br.close();
                    // r.close();

                    
                
                    
                    
                } catch (ItemCodeNotFound e) 
                {System.out.println("out of range enter another value");
                }
                

        }
        
       
       // Bill bill1 = new Bill(cashier1 ,customer1, true);

       



        
    }
}

