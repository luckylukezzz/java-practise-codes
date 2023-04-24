import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

abstract class Account {
    private int accountNumber;
    private String currency;
    private String branch;
    double balance;
    
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public Account(int accountNumber, String currency, String branch, double balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.branch = branch;
        this.balance = balance;
    }
    
}
class SavingsAccount extends Account {

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
    private ArrayList<Account> accounts;
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
        System.out.println("balance is"+   acc.getBalance());
        accountId=acc.getAccountNumber();
        date=new Date();
        status="success";
    }

    public Transaction(double amount, Account acc ,String type) {
        this.amount = amount;
        this.acc = acc;
        if (type=="deposit"){
            acc.balance+=amount;

        }
        else{
            if (acc.balance>amount){
                acc.balance-=amount;
                status="success";
            }else{
                status ="unsucessful";
            }
        }
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
        Client client1= new Client(2001,2,"asd","sinhala","teacher","kuliyapityia",20,"male");
        Bank bank1= new Bank();
        bank1.createAcc(client1,"saving",55, "rs", "kurunegla",10000);
        bank1.createAcc(client1,"current",30, "rs", "colombo",50000);
        ATM atm1=new ATM();
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome!\nPlease enter your PIN: \n");
        int pin = sc.nextInt();
        if(atm1.verify(client1,pin) ){
            System.out.println("Select an account:");
            for (Account account : client1.getAccounts()) {
                System.out.println(account.accountNumber);
            }
            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();
            Account account = getAccount(client, accountNumber);

        }

    }
}
