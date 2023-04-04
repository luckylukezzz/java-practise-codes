public class StudioPerformance extends Performance {
    public StudioPerformance(MainArtist mainArtist, String performanceName, int year, String venue) {
        super(mainArtist,performanceName,year,venue);
    } 
    public void record(){
        System.out.println("This is the method record in the  class StudioPerformance \n (overidden the medthod form abstract class performance)" ); 
        System.out.println("\nRecording in the studio\n");
    }
}
