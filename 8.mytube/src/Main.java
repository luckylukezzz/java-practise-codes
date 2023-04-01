public class Main {
    public static void main(String[] args) throws Exception {
        var video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Lucky's Birthday");
        video.setUser(new User("asd@gmail.com"));

        var processor = new VideoProcessor(new VideoEncoder(),new VideoDatabase(),new EmailService());
        processor.process(video);
    }
}
