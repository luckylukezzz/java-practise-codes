class X{
    public static void test(){
        System.out.println("X");
    }
}
class Y extends X{
    public static void test(){
        System.out.println("Y");
    }
}

public class App {

    public static void main(String[] args) {
        
        X y = new Y();
        y.test();
        
        
    }


}