package block1.ex4;

import java.text.SimpleDateFormat;

/**
 * Created by Rogier on 20-04-16.
 */
public class TestingClass {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Dater(dateFormat));
            t.run();
        }
    }
}
