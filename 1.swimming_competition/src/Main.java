import java.util.*;


//includes everyone around the pool
class People{
    String name;
    int id;
    People(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void showScore(){
        for (String i :ScoreBoard.showSC()){
            System.out.println(i);
        }
    }
}

//judge class inheritedfrom people class

class Judge extends People{
    Judge(String name, int id) {
        super(name, id);
    }
    boolean isWhistled;
    void setWhistled() {
        isWhistled = true;
        System.out.println("Whistling");
    }
}

//swimmer class inheritedfrom people class

class Swimmer extends People{
    Swimmer(String name, int id) {
        super(name, id);
    }
    void swim(){
        System.out.println(this.name+" started swimming");
    }
    void ended(){
        System.out.println(this.name+" finished");
        ScoreBoard.setScore(this);
    }
}
//staff class inheritedfrom people class


class SupportingStaff extends People{
    SupportingStaff(String name, int id) {
        super(name, id);
    }
}
class Spectators extends People{
    Spectators(String name, int id) {
        super(name, id);
    }
}

//scorebord class contains static list which can be accessed witour creating an object

class ScoreBoard {
    static List<String>  score= new ArrayList<>();
    static List<String> showSC(){
        return score ;
    }
    static void setScore(Swimmer x){
        int lenSoreBoard=score.size();
        score.add((lenSoreBoard+1)+"==>"+x.name);

    }
}


public class Main {

    public static void main(String[] args) throws Exception {


        //pass the command line arguments as (no ofswimmers, no of judges, no of supportingstaff ,no of spectators)
        // ex:  10 2 10 50

        List<Swimmer>  swimmers= new ArrayList<>();
        int id=0;
        int noSwimmers=Integer.parseInt(args[0]);
        for (int i=0 ;i<noSwimmers ;i++){
            swimmers.add(new Swimmer("swimmer"+i, id));
            id++;
           
        }
        List<Judge>  judges= new ArrayList<>();
        int noJudge=Integer.parseInt(args[1]);
        for (int i=0 ;i<noJudge ;i++){
            judges.add(new Judge("Judge"+i, id));
            id++;
           
        }
        List<SupportingStaff>  staff = new ArrayList<>();
        int noSupportingStaff=Integer.parseInt(args[2]);
        for (int i=0 ;i<noSupportingStaff ;i++){
            staff.add(new SupportingStaff("SupportingStaff"+i, id));
            id++;
           
        }
        List<Spectators>  spectators = new ArrayList<>();
        int noSpec=Integer.parseInt(args[3]);
        for (int i=0 ;i<noSpec ;i++){
            spectators.add(new Spectators("Spectator"+i, id));
            id++;
           
        }

        //judge 1 whistles to start the event
        var judge1=judges.get(0);
        judge1.setWhistled();

        //swimmers begin to swim
        for(Swimmer x:swimmers ){
            x.swim();
        }

        //swimmers end
        for(Swimmer x:swimmers ){
            x.ended();
        }
        
        //spectator 1 looks at the scoreboard
        var spec1=spectators.get(0);
        spec1.showScore();
    }

}
