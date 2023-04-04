public class BackupSingers extends Singers implements IBackup {

    public BackupSingers(String name) {
        super(name);
    }
    
    @Override
    public void perform(){
       this.sing();
    }
  
}