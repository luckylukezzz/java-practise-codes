// use 2001 as the pin number for the client



import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

abstract class Account {
    private int accountNumber;
    private String currency;
    private String branch;
    private ArrayList<Transaction> transactions=new ArrayList<>();
    public double balance;
    
    
    public Account(int accountNumber, String currency, String branch, double balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.branch = branch;
        this.balance = balance;
    }
    public String getCurrency() {
        return currency;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void addTransaction(Transaction t){
        transactions.add(t);
    }
    
}
class SavingsAccount extends Account {
    private int interestRate =4;
    public SavingsAccount(int accountNumber, String currency, String branch, double balance) {
        super(accountNumber, currency, branch, balance);
    }
    
    
};
class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String currency, String branch, double balance) {
        super(accountNumber, currency, branch, balance);
    }
}



class Client{
    
    private int id;
    private String name;
    private String nationality;
    private String occupation;
    private String address;
    private int age;
    private String gender;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private int pin;
    

    public Client(int pin,int id, String name, String nationality, String occupation, String address, int age, String gender) {
        this.pin = pin;
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.occupation = occupation;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }
    
    public void addAcc(Account acc){
        accounts.add(acc);
    }
    public int getPin() {
        return pin;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}



class Bank{
    void createAcc(Client client,String accType,int accountNumber, String currency, String branch, double balance){
        if ( accType=="saving"){
            client.addAcc(new SavingsAccount(accountNumber,currency,branch,balance));
        }
        else{
            client.addAcc(new CurrentAccount(accountNumber,currency,branch,balance));
        }
    }
    void getLoan(Client client,int amount){
        if (client.getAccounts().size()==0){
            System.out.println("no accounts");
        }
        else{
            System.out.println("loan sucessful");
        }
    }

}


class Transaction {
    int transactionId;
    int accountId;
    Date date;
    String status;
    double amount; 
    Account acc;
    String type;

    public Transaction(Account acc) {
        this.acc = acc;
        System.out.println("Balance is: "+acc.getCurrency()+" " + acc.getBalance());
        accountId=acc.getAccountNumber();
        date=new Date();
        status="success";
    }

    public Transaction(double amount, Account acc ,String type) {
        this.amount = amount;
        this.acc = acc;
        if (type=="deposit"){
            acc.balance+=amount;
            status = "Deposited money";
        }
        else{
            if (acc.balance>amount){
                acc.balance-=amount;
                status="Withdrawal success";
            }else{
                status ="Withdrawal unsucessful";
            }
        }
        System.out.println(status);
        accountId=acc.getAccountNumber();
        date=new Date();
        
    } 

}




public class ATM {
    boolean verify(Client client,int pin){
        if(client.getPin()==pin){
            return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        Client client1= new Client(2001,2,"Saman Kumaara","sinhala","teacher","kuliyapityia",20,"male");
        Bank bank1= new Bank();
        bank1.createAcc(client1,"saving",5555, "rs", "kurunegla",10000);
        bank1.createAcc(client1,"current",3000, "rs", "colombo",50000);
        ATM atm1=new ATM();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Welcome!\nPlease enter your PIN: \n");
            int pin = sc.nextInt();
            if(atm1.verify(client1,pin) ){
                System.out.println("Select an account:");
                int i=1;
                for (Account account : client1.getAccounts()) {
                    System.out.println(i+". "+account.getAccountNumber());
                    i++;
                }
                System.out.print("Enter your choice: ");
                int accountNumber = sc.nextInt();
                var arr = client1.getAccounts();
                Account acc = arr.get(accountNumber -1);

                System.out.println("\nMain Menu");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        Transaction trans1=new Transaction(acc);
                        break;
                    case 2:
                        System.out.println("Enter amount: ");
                        int v1 =sc.nextInt();
                        Transaction trans2=new Transaction(v1,acc,"withdrawal");
                        break;
                    case 3:
                        System.out.println("Enter amount: ");
                        int v2 =sc.nextInt();
                        Transaction trans3=new Transaction(v2,acc,"deposit");
                        break;
                    case 4:
                        System.exit(0);
                }    
            }
        
            else{System.out.println("invalid pin");}
        }    
    }
}
