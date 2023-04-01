public class VideoDatabase implements IVideoDatabase {
    @Override
    public void store(Video video) {
        System.out.println("Storing video .... ");
        System.out.println("Done\n");
    }
}
