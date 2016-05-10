package block3.cp.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogier on 10-05-16.
 */
public class LRRunnable implements Runnable {
    private LeftRightDeadlock deadlock;

    public LRRunnable(LeftRightDeadlock deadlock) {
        this.deadlock = deadlock;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            deadlock.leftRight();
            deadlock.rightLeft();
        }
    }


    public static void main(String[] args) {
        LeftRightDeadlock leftRightDeadlock = new LeftRightDeadlock();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            LRRunnable runnable = new LRRunnable(leftRightDeadlock);
            Thread t1 = new Thread(runnable);
            threads.add(t1);
            t1.start();
        }

        for (Thread thread : threads
             ) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//"Thread-99":
//        at block3.cp.deadlock.LeftRightDeadlock.leftRight(LeftRightDeadlock.java:12)
//        - waiting to lock <0x000000076abd0730> (a java.lang.Object)
//        at block3.cp.deadlock.LRRunnable.run(LRRunnable.java:18)
//        at java.lang.Thread.run(Thread.java:745)
//        "Thread-6":
//        at block3.cp.deadlock.LeftRightDeadlock.leftRight(LeftRightDeadlock.java:13)
//        - waiting to lock <0x000000076abd0740> (a java.lang.Object)
//        - locked <0x000000076abd0730> (a java.lang.Object)
//        at block3.cp.deadlock.LRRunnable.run(LRRunnable.java:18)
//        at java.lang.Thread.run(Thread.java:745)
//        "Thread-5":
//        at block3.cp.deadlock.LeftRightDeadlock.rightLeft(LeftRightDeadlock.java:21)
//        - waiting to lock <0x000000076abd0730> (a java.lang.Object)
//        - locked <0x000000076abd0740> (a java.lang.Object)
//        at block3.cp.deadlock.LRRunnable.run(LRRunnable.java:19)
//        at java.lang.Thread.run(Thread.java:745)
//
//        Found 1 deadlock.
