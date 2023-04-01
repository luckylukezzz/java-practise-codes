public class VideoProcessor {
    private CanVideoEncode encoder;
    private IVideoDatabase database;
    private  NotificationService notificationService;
    
    public VideoProcessor(CanVideoEncode encoder, IVideoDatabase database, NotificationService notificationService) {
        this.encoder = encoder;
        this.database = database;
        this.notificationService = notificationService;
    }


    public void process(Video video){
        encoder.encode(video);
        database.store(video);
        notificationService.send(video.getUser());
    }   

    
}
