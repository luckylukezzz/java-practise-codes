class Q{
    int num;
    boolean valueSet = false;

    public synchronized void put (int num){
        while(valueSet){
            try{ wait(); } catch (Exception e){}
        }
        System.out.println("Put " + num );
        this.num = num;
        valueSet = true;
        notify();
    
    }
    public synchronized void get(){
        while(!valueSet){
            try{ wait(); } catch (Exception e){}
        }
        System.out.println("Get " + num );
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable{
    Q q;

    public Producer(Q q){
        this.q = q;
        Thread t = new Thread(this , "Producer");
        t.start();
    }
    public void run(){
        int i = 0;
        while (true){
            q.put(i++);
            try{Thread.sleep(10000); }catch(Exception e){}
        }
    }
}

class Consumer implements Runnable{
    Q q;
    public Consumer(Q q){
        this.q = q;
        Thread t = new Thread(this , "Consumer");
        t.start();
    }

    public void run(){
        while(true){
            q.get();
            try{ Thread.sleep(10000); }catch(Exception e){}
        }
    }
}
public class InnerThread {
    public static void main(String[] args) throws Exception {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        
    }
}

/*In the Q class, the put() method and the get() method are both declared as synchronized, which means they acquire the lock on the instance of Q when they are executed.

Inside the put() method, the while loop is used to check if valueSet is true. If it is true, it means that the consumer thread is still processing the previously put value, and the producer thread needs to wait. So, the producer thread calls wait() to release the lock and wait for the consumer thread to consume the value. The lock is released at the moment the wait() method is called.

Similarly, inside the get() method, the while loop is used to check if valueSet is false. If it is false, it means that no value has been put by the producer thread yet, and the consumer thread needs to wait. So, the consumer thread calls wait() to release the lock and wait for the producer thread to put a value. The lock is released at the moment the wait() method is called.

The locks are reacquired by the threads when the notify() method is called. In the put() method, after setting the value and before calling notify(), the producer thread reacquires the lock. Similarly, in the get() method, after printing the value and before calling notify(), the consumer thread reacquires the lock.

By calling notify(), the thread that called wait() (either the producer or the consumer thread) signals to the waiting thread that the lock is released and it can continue its execution. The waiting thread can then reacquire the lock and proceed with its task.

In summary, the locks are released when the wait() method is called, and they are reacquired when the notify() method is called. */