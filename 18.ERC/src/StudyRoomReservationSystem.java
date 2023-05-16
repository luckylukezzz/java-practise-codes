import java.util.HashMap;
import java.util.Map;

class StudyRoom{
    private int roomNo;
    private int maxCapacity;
    private int capacity=0;
    private boolean isAvailable= true;

    public StudyRoom(int roomNo, int maxCapacity) {
        this.roomNo = roomNo;
        this.maxCapacity = maxCapacity;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public int getRoomNo() {
        return roomNo;
    }
    public synchronized int  getCapacity() {
        return capacity;
    }
    public synchronized int getMaxCapacity() {
        return maxCapacity;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }
    public synchronized void decCapacity() {
        capacity--;
        
    }
    public synchronized void incCapacity() {
        capacity++;
        if (capacity == maxCapacity){
            setAvailable(false);
        }
    }
}


class  StudyRoomUnavailableException extends Exception {
    public  StudyRoomUnavailableException() {
        super("room unavailable");
    }
}



public class StudyRoomReservationSystem {
    private static Map <Integer , StudyRoom> roomList = new HashMap<>();

    public static void setRoom(int roomNumber, int maxCapacity){
        roomList.put(roomNumber,new StudyRoom(roomNumber, maxCapacity));
    }

    public static synchronized void  reserveStudyRoom(int  roomNumber) throws StudyRoomUnavailableException{
        if (roomList.get( roomNumber).getCapacity() < roomList.get( roomNumber).getMaxCapacity()){
            System.out.println("reserve successful");
            roomList.get( roomNumber).incCapacity();
        }else{
           throw new StudyRoomUnavailableException();
        }
    }

    public static synchronized void releaseStudyRoom(int roomNumber) {
        System.out.println("release successful");
        if (roomList.get(roomNumber).getCapacity() > 0)
            roomList.get(roomNumber).decCapacity();
    }

    public static synchronized void displayStudyRoomStatus() {
        for ( var i : roomList.keySet()){
            String x;
            if (roomList.get(i).isAvailable()){
                x= "available";
            }else x= "not available";
            System.out.println( "room "+i+" is "+x +" capacity "+roomList.get(i).getCapacity() + " max capacity "+roomList.get(i).getMaxCapacity() );
        }
        
    }
    public static void threadCreater(int i , int j){
        switch (i) {
            case 1:
                new Thread() {
                    public void run() {
                        try {
                            reserveStudyRoom(j);
                        } catch (StudyRoomUnavailableException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                    }
                }.start();
                break;
            case 2:
                new Thread() {
                    public void run() {
                        releaseStudyRoom(1);
                    }
                }.start();
                break;
            }
    }
    public static void threadCreater() throws InterruptedException{
        var x = new Thread() {
            public void run() {
                displayStudyRoomStatus();
            }
        };
        x.start();
        x.join();

    }
    public static void main(String[] args) throws InterruptedException {
        setRoom(1,4) ;
        setRoom(2,4) ;
        setRoom(3,5) ;

        threadCreater();
        threadCreater(1,1);
        threadCreater(1,1);
        threadCreater(1,1);
        threadCreater(1,1);
        threadCreater(1,1);
        threadCreater(1,1);
        threadCreater(2,1);
        threadCreater(1,2);
        threadCreater();
       
        // new Thread() {
        //     public void run() {
        //         displayStudyRoomStatus();
        //     }
        // }.start();
       
        // new Thread() {
        //     public void run() {
        //         try {
        //             reserveStudyRoom(1);
        //         } catch (StudyRoomUnavailableException e) {
        //             System.out.println("Exception: " + e.getMessage());
        //         }
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         try {
        //             reserveStudyRoom(1);
        //         } catch (StudyRoomUnavailableException e) {
        //             System.out.println("Exception: " + e.getMessage());
        //         }
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         try {
        //             reserveStudyRoom(1);
        //         } catch (StudyRoomUnavailableException e) {
        //             System.out.println("Exception: " + e.getMessage());
        //         }
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         try {
        //             reserveStudyRoom(1);
        //         } catch (StudyRoomUnavailableException e) {
        //             System.out.println("Exception: " + e.getMessage());
        //         }
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         try {
        //             reserveStudyRoom(1);
        //         } catch (StudyRoomUnavailableException e) {
        //             System.out.println("Exception: " + e.getMessage());
        //         }
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         displayStudyRoomStatus();
        //     }
        // }.start();
        // new Thread() {
        //     public void run() {
        //         releaseStudyRoom(1);
        //     }
        // }.start();
        

    }
    

}
