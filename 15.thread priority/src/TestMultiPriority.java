public class TestMultiPriority extends Thread{
    public void run(){
        System.out.println("thread name:"+Thread.currentThread().getName());
        System.out.println("thread priority:"+Thread.currentThread().getPriority());
    }
    public static void main(String args[]){
        TestMultiPriority m1=new TestMultiPriority();
        TestMultiPriority m2=new TestMultiPriority();
        m1.setName("min priority thread");
        m2.setName("max priority thread");
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.start();
    }
    }