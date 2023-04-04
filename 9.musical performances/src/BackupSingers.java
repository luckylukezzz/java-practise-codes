public class BackupSingers extends Singers implements IBackup {

    public BackupSingers(String name) {
        super(name);
    }
    
    @Override
    public void perform(){
        System.out.println("This is the method perform in the  class BackupSingers implements IBackup interface" ); 
       this.sing();
    }
  
}