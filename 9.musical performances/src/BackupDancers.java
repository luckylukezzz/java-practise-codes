public class BackupDancers extends Artists implements IBackup{
    public BackupDancers(String name) {
        super(name);
    }
    @Override
    public void perform(){
        System.out.println(this.getName()+" backupDancer Dances");
    }
    
    
}
