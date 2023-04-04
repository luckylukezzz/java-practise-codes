public class StudioPerformance extends Performance {
    public StudioPerformance(MainArtist mainArtist, String performanceName, int year, String venue) {
        super(mainArtist,performanceName,year,venue);
    } 
    @Override
    public void record(){
        System.out.println("This is the method record in the  class StudioPerformance \n (overidden the medthod form abstract class performance)" ); 
        System.out.println("\nRecording in the studio\n");
    }

    public void beginAudioProcess(){
        System.out.println("This is the method beginAudioProcess in the  class StudioPerformance" ); 
        System.out.println("\nProcessing Audio\n");
    }
}
