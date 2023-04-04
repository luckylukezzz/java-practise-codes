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
   
    public void setbackupSingers(IBackup backupSinger) { 
        System.out.println("This is the method setbackupSingers in the abstract class Performance" );       
        backupSingers.add(backupSinger);
    }
    public void setbackupDancers(IBackup backupDancer) {   
        System.out.println("This is the method setbackupDancers in the abstract class Performance" );      
        backupDancers.add(backupDancer);
    }
    public void setTrackList(MusicTrack track) { 
        System.out.println("This is the method setTrackList in the abstract class Performance" );        
        trackList.add(track);
    }
    public void initiate(){
        System.out.println("This is the method initiate in the abstract class Performance" ); 
        System.out.println("Welcome to the Performance "+this.performanceName+" by "+mainArtist.getName());
        this.record();
        mainArtist.sing();
        for (IBackup backSinger : backupSingers){
           backSinger.perform();
        }
        for (IBackup backDancer : backupDancers){
            backDancer.perform();
         }
    }
    public abstract void record();

    public String getVenue() {
        System.out.println("This is the method getVenue in the abstract class Performance" );
        return venue;
    }
    public MainArtist getMainArtist() {
        System.out.println("This is the method getMainArtist in the abstract class Performance" );
        return mainArtist;
    }

    public int getYear() {
        System.out.println("This is the method getYear in the abstract class Performance" );
        return year;
    }

}
