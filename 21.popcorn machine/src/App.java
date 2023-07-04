class PopcornMachine{
    int cookerDone = 0;
    int bagDone = 0;
    
    public synchronized void cooker(){
        System.out.println("cooker done cooking");
        cookerDone++;
        notifyAll();

    }
    public synchronized void bag(){
        while(!(cookerDone == 2)){
            try{wait();}catch(Exception e){};
        }
        System.out.println("bag done");
        bagDone++;
        notifyAll();
    }
    public synchronized void robotArm(Bell bell, Light light){
        while(!(bagDone == 3)){
            try{wait();}catch(Exception e){};
        }
        System.out.println("picked  BAG");
        // Create threads for the asynchronous events
        Thread bellThread = new Thread(bell::ring);
        Thread lightThread = new Thread(light::blink);

        // Start the event threads
        bellThread.start();
        lightThread.start();

        //Wait for the event threads to complete
        try {
            bellThread.join();
            lightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Bell {
    public void ring() {
        System.out.println("Bell rings");
    }
}

class Light {
    public void blink() {
        System.out.println("Light blinks");
    }
}

class Producer implements Runnable{
    PopcornMachine popcorn;
    public Producer(PopcornMachine popcorn){
        this.popcorn = popcorn;
    }
    public void run(){
        popcorn.cooker();
    }
}
class Consumer1 implements Runnable{
    PopcornMachine popcorn;
    public Consumer1(PopcornMachine popcorn) {
        this.popcorn = popcorn;
    }
    public void run(){
        popcorn.bag();
    }
}
class Consumer2 implements Runnable{
    PopcornMachine popcorn;
    Bell bell;
    Light light;
    public Consumer2(PopcornMachine popcorn, Bell bell, Light light){
        this.popcorn = popcorn;
        this.bell = bell;
        this.light = light;
    }
    public void run(){
        popcorn.robotArm(bell,light);
    }
}
public class App{
    public static void main (String[] args){

        PopcornMachine popcorn = new PopcornMachine();
        
        Thread t1 = new Thread(new Producer(popcorn));
        Thread t2 = new Thread(new Producer(popcorn));
        Thread t3 = new Thread(new Consumer1(popcorn));
        Thread t4 = new Thread(new Consumer1(popcorn));
        Thread t5 = new Thread(new Consumer1(popcorn));
        Thread t6 = new Thread(new Consumer2(popcorn,new Bell(),new Light() ));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
