public class Main {
    public static void main(String[] args) throws Exception {
        UIcontrol[] controls ={new CheckBox(),new TextBox(),new UIcontrol()};
        for (var i: controls) {
            i.render();
         }
    }
}