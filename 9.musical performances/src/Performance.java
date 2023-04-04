import java.util.*;



public abstract class Performance {
    
    private MainArtist mainArtist;
    public String performanceName;
    private int year;
    private String venue;
    private List<MusicTrack> trackList;
    private List<IBackup> backupSingers;
    private List<IBackup> backupDancers;

    public Performance(MainArtist mainArtist, String performanceName, int year, String venue ) {
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.year = year;
        this.venue = venue;
        this.trackList = new ArrayList<>();
        this.backupSingers = new ArrayList<>();
        this.backupDancers = new ArrayList<>();
    }    
    public String getVenue() {
        return venue;
    }
    public void setbackupSingers(IBackup backupSinger) {        
        backupSingers.add(backupSinger);
    }
    public void setbackupDancers(IBackup backupDancer) {        
        backupDancers.add(backupDancer);
    }
    public void setTrackList(MusicTrack track) {        
        trackList.add(track);
    }
    public void initiate(){
        System.out.println("Welcome to the Performance "+this.performanceName+" by "+mainArtist);
        mainArtist.sing();
        for (IBackup backSinger : backupSingers){
           backSinger.perform();
        }
        for (IBackup backDancer : backupDancers){
            backDancer.perform();
         }
    }
    public abstract void record();
}
