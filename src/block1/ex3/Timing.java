package block1.ex3;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

/**
 * Created by Rogier on 20-04-16.
 */
public class Timing {

    public static void main(String[] args) {

        Timer timer1 = new Timer();

        long t0 = System.currentTimeMillis() + 1000;
        for (int i = 0; i < 1000; i++) {
            TimerTask t1 = new MyTimerTask();
            timer1.schedule(t1,t0 - System.currentTimeMillis());
        }

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Variable: " + MyTimerTask.getShared());
        timer1.cancel();

//      ---------- Second Version ----------
        t0 = System.currentTimeMillis() + 1000;
        MyTimerTask.setShared(0);
        ArrayList<Timer> timers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Timer timer = new Timer();
            timers.add(timer);
            TimerTask t1 = new MyTimerTask();
            timer.schedule(t1,t0 - System.currentTimeMillis());
        }

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Variable: " + MyTimerTask.getShared());
        for (Timer timer : timers){
            timer.cancel();
        }

    }


}
