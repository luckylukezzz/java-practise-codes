public class Singers extends Artists {
    public Singers(String name) {
        super(name);
    }
    public void sing(){
        System.out.println(this.getName()+" sings");
    }
    
}
