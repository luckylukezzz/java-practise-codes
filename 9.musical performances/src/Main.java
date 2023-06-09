import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var show1 = new LivePerformance(new MainArtist("Taylor Swift"),"Eras Tour",2023,"Glendale");
        show1.setTrackList(new MusicTrack("Lavender Haze", 3.0f));
        show1.setTrackList(new MusicTrack("All Too Well", 2.45f));
        show1.setTrackList(new MusicTrack("the lakes", 3.45f));
        show1.setTrackList(new MusicTrack("The Man", 3.45f));
        show1.setTrackList(new MusicTrack("Love Story", 3.45f));

        show1.setbackupSingers(new BackupSingers("Jeslyn"));
        show1.setbackupSingers(new BackupSingers("Melanie"));

        show1.setbackupDancers(new BackupDancers("Stephanie"));
        show1.setbackupDancers(new BackupDancers("Jake"));

        show1.initiate();
        show1.interactAudience();

        Scanner x= new Scanner(System.in);
        x.nextLine();
    }
}
