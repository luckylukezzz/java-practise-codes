import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String[] parts = br.readLine().split(" ");
        System.out.println(parts[0]);
    }
}
