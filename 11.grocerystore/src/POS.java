import java.util.*;
import java.io.*;


//people is the parent class of cilds customer and cashier

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


// item class stores all the data about a item object
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


// used to create the bill and the objects can be serialized

class Bill implements Serializable {
    private int count=0;
    private Cashier cashier ;
    private Customer customer;
    public Bill(Cashier cashier, Customer customer) {
        this.cashier = cashier;
        this.customer = customer;
    }
    // adds items to the bill as the cashiers calls this func
    public void addItem(Item item, int amount) {
        count+=(item.getPrice()-item.getDiscount()*item.getPrice()/100)*amount ;
    }

    //prints the bill with this
    public void show(){
        System.out.println("bill issued by "+cashier.getName()+ " from "+cashier.getBranch()+" branch.");
        System.out.println("customer: "+ customer.getName());
        System.out.println("total price Rs. "+ count);
    }

    
}
//exception to handle if the cashier enters a wronng item number

class ItemCodeNotFound extends Exception {
    public ItemCodeNotFound(String message) {
        super(message);
    }
}



//Point of sale software used to make bills for customers and save the temp bills

public class POS{

    //method which raise exception if the item code is wrong checking the itemlist database (hash map)
    //or else returns the item object of the itemNo
    public static Item fetchItemDetails(int itemNo , Map<Integer, Item> itemList) throws ItemCodeNotFound {
   
        if (!itemList.containsKey(itemNo)) {
            throw new ItemCodeNotFound("Item code " + itemNo + " not found in the database.");
        }
        
       return itemList.get(itemNo);
    }
    public static void main(String[] args) throws IOException {

        //hard coded database to store the item data
        Map<Integer, Item> itemList = new HashMap<>();
        itemList.put(1,new Item("Apple",20,0,50,"tasty friuts","5/23","7/23"));
        itemList.put(2,new Item("Apple",20,0,50,"tasty friuts","5/23","7/23"));
        itemList.put(3, new Item("pineapple",100,0,200,"tasty friuts","5/23","7/23"));
        itemList.put(4,new Item("soap",100,20,50,"lux","1/23","8/25"));
        itemList.put(5,new Item("brush",100,10,20,"signal","1/23","8/25"));
        //temp objects
        Cashier cashier1 = new Cashier("Saman","Moratuwa");
        Customer customer1 = new Customer("john");

        Bill bill1 = new Bill(cashier1,customer1 );

        //gets user input until we input -1 
        //serializes the current bill object when we input s
        while (true){
            try {
                    InputStreamReader r = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(r);
                    String[] parts = br.readLine().split(" ");
                    if (parts[0].equals("s")){
                        FileOutputStream fileStream = new FileOutputStream("tempbill.txt");
                        ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
                        objStream.writeObject(bill1);
                        objStream.close();
                        br.close();
                        r.close();
                        break;
                    }
                    else if( parts[0].equals("-1")){
                        bill1.show();
                        br.close();
                        r.close();
                        break;
                    }

                    else{
                    int itemNo =Integer.parseInt(parts[0] );
                    int amount =Integer.parseInt(parts[1] );
                    //raise exception or continue billing
                    Item a = fetchItemDetails(itemNo , itemList);
                    bill1.addItem(a, amount);
                    }
                    

                } catch (ItemCodeNotFound e) 
                {System.out.println("out of range enter another value");
                }
                
                

        }
       



        
    }
}

