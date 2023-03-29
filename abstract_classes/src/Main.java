public class Main {
    public static void main(String[] args) throws Exception {
        UIcontrol[] controls ={new CheckBox(),new TextBox()};
        for (var i: controls) {
            i.render();
            boolean isInUIclass = i instanceof UIcontrol;
            System.out.println(isInUIclass);
         }


    }
}