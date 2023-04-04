public abstract class Singers extends Artists {
    public Singers(String name) {
        super(name);
    }
    public void sing(){
        System.out.println("This is the method sing in the Singers class" ); 
        System.out.println(this.getName()+" sings");
    }
    
}
