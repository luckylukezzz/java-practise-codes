public class UIcontrol {
    private boolean isEnabled = false;

    public void enable() {
        isEnabled = true;
    }


    public void disable() {
        isEnabled = false;
    }

    public void render() {
        System.out.println("default render");
    }

}