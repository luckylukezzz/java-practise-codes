public class LivePerformance extends Performance {
    public LivePerformance(MainArtist mainArtist, String performanceName, int year, String venue) {
        super(mainArtist,performanceName,year,venue);
    }
    @Override    
    public void record(){
        System.out.println("This is the method record in the  class LivePerformance \n (overidden the medthod form abstract class performance)" ); 
        System.out.println("recording live at "+ this.getVenue() );
    }
    public void interactAudience(){
        getMainArtist().interactAudience();
    }
}
