public class LivePerformance extends Performance {
    public LivePerformance(MainArtist mainArtist, String performanceName, int year, String venue) {
        super(mainArtist,performanceName,year,venue);
    }    
    public void record(){
        System.out.println("recording live at "+ this.getVenue() );
    }
}
