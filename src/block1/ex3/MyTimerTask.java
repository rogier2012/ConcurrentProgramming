package block1.ex3;

import java.util.TimerTask;

/**
 * Created by Rogier on 20-04-16.
 */
public class MyTimerTask extends TimerTask {
    private static int shared;

    public MyTimerTask() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            shared++;
        }

    }

    public static int getShared() {
        return shared;
    }

    public static void setShared(int shared) {
        MyTimerTask.shared = shared;
    }
}
