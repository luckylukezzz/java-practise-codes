public abstract class Artists {
    private String name ;

    public Artists(String name) {
        this.name = name;
    }
    public String getName() {
        System.out.println("This is the method getName in the class Artists" ); 
        return name;
    }
}
