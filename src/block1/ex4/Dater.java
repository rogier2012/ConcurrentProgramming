package block1.ex4;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Rogier on 20-04-16.
 */
public class Dater implements Runnable {
    private SimpleDateFormat dateFormat;

    public Dater(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void run() {
        try {
            dateFormat.parse("20-12-1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
