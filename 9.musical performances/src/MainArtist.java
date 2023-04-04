public class MainArtist extends Singers{
    public MainArtist(String name) {
        super(name);
    }
    public void interactAudience(){
        System.out.println(this.getName()+" interacts with the audience");
    }
}

