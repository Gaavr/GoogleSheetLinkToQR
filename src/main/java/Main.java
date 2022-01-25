import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        PreparingLinks.getData();
        ArrayList<String> links = PreparingLinks.getLinksForRange();
        for (String link : links) {
            MyQR.createByString(link);
        }
    }
}
