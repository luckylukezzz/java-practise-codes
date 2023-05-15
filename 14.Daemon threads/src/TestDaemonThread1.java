public class TestDaemonThread1 extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("daemon thread work");
            System.out.println(Thread.currentThread());
        }
        else{
            System.out.println("user thread work");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        TestDaemonThread1 t1=new TestDaemonThread1();
        TestDaemonThread1 t2=new TestDaemonThread1();
        TestDaemonThread1 t3=new TestDaemonThread1();
        t1.setName("daemon thread UwU");
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t1.join();
        t3.start();
        
    }
}
    