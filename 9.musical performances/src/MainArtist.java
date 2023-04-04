public class MainArtist extends Singers{
    public MainArtist(String name) {
        super(name);
    }
    public void interactAudience(){
        System.out.println("This is the method interactAudience in the MainArtist class" ); 
        System.out.println(this.getName()+" interacts with the audience");
    }
}

