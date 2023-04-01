public class Video {
    
    private String fileName;
    private String title;
    private User user;

    public void setTitle(String title) {
        this.title = title;
        
    }
    public String getTitle() {
        return title;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
