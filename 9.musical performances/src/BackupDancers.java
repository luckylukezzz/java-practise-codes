public class BackupDancers extends Artists implements IBackup{
    public BackupDancers(String name) {
        super(name);
    }
    @Override
    public void perform(){
        System.out.println("This is the method perform in the  class BackupDancers implements IBackup interface" ); 
        System.out.println("\n"+this.getName()+" backupDancer Dances\n");
    }
    
    
}
