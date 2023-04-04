public class StudioPerformance extends Performance {
    public StudioPerformance(MainArtist mainArtist, String performanceName, int year, String venue) {
        super(mainArtist,performanceName,year,venue);
    } 
    public void record(){
        System.out.println("Recording in the studio");
    }
}
