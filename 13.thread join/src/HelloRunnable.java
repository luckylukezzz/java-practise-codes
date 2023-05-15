public class HelloRunnable implements Runnable {
    public void run() {
        for(int i=0; i< 10 ; i++){
        System.out.println(i);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread hr1 = new Thread(new HelloRunnable(), " hr1");
        Thread hr2 = new Thread(new HelloRunnable(), " hr2");
        hr1.start();
        hr1.join(); // Block the current thread (Main) until hr1 is completed.
        hr2.start();
    }
}